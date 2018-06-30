package cn.hff.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import cn.hff.entity.CommonPayStudent;
import cn.hff.entity.Gender;
import cn.hff.http.Headers;
import cn.hff.util.DateUtils;
import cn.hff.util.ImageUtils;
import lombok.AllArgsConstructor;
import net.sourceforge.tess4j.TesseractException;

/**
 * 校园网上统一支付平台
 * <p>
 * http://tyzfpt.jxau.edu.cn/student/Index.aspx
 * <p>
 * Created by Holmofy on 2018/5/9.
 */
@AllArgsConstructor
public class CommonPaySystem<T extends CommonPayStudent> {

    private static final Log log = LogFactory.getLog(CommonPaySystem.class);

    /**
     * 根据tesseract训练数据的精确度确定
     */
    private static final int LOGIN_RETRY_COUNT = 10;

    private static HttpClient client = HttpClients.createDefault();

    private static RequestConfig conf = RequestConfig.custom()
            .setConnectTimeout(10 * 1000)
            .setConnectionRequestTimeout(10 * 1000)
            .build();

    /**
     * 网址域名
     */
    private String baseUrl;

    private Class<T> clazz;

    private ViewStateParamJoiner joiner;

    /**
     * 获取验证码
     * 同时SessionID会由Apache HttpClient cookie自动管理
     * CheckCode.aspx
     */
    private String getCheckCode() {
        String url = baseUrl + "/CheckCode.aspx";
        HttpUriRequest request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                HttpEntity entity = response.getEntity();
                if (entity.getContentType().getValue().startsWith("image")) {
                    // image/jpeg,image/gif
                    byte[] bytes = EntityUtils.toByteArray(entity);
                    return ImageUtils.recognition(new ByteArrayInputStream(bytes));
                }
            } else {
                EntityUtils.consumeQuietly(response.getEntity());
                log.info("请求失败");
            }
        } catch (IOException e) {
            log.warn("网络请求异常", e);
        } catch (TesseractException e) {
            log.warn("验证码识别异常", e);
        }
        return "";
    }

    private static final String pattern = "yyyyMMdd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

    /**
     * 根据学号获取学生的信息
     * <p>
     * /student/Index.aspx
     *
     * @param stuNum 学号
     * @return 学生信息
     */
    public T getStudentInfo(String stuNum) {
        // 登录失败重试
        int tryCount = 1;
        while (!login(stuNum) && tryCount < LOGIN_RETRY_COUNT) {
            tryCount++;
        }
        log.warn("尝试登陆" + tryCount + "次");
        if (tryCount >= LOGIN_RETRY_COUNT) {
            log.warn("尝试多次失败，停止尝试，学号为：" + stuNum);
            return null;
        }
        // 登录成功后尝试获取学生信息
        String url = baseUrl + "/student/Index.aspx";
        HttpUriRequest request = RequestBuilder.get(url)
                .setConfig(conf)
                .build();
        try {
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                T student = BeanUtils.instantiateClass(clazz);
                Document document = Jsoup.parse(EntityUtils.toString(response.getEntity()));
                student.setName(document.getElementById("labStudentName").text().trim());
                student.setStuNumber(document.getElementById("labStudnetNo").text().trim());
                student.setGender(Gender.fromText(document.getElementById("labStudentSex").text().trim()));
                student.setDepartment(document.getElementById("labCollage").text().trim());
                student.setMajor(document.getElementById("labMajor").text().trim());
                student.setStartYear(document.getElementById("labInShoolYear").text().trim());
                String birthday = document.getElementById("labBri").text().trim();
                if (!StringUtils.isEmpty(birthday)) {
                    if (birthday.length() == pattern.length()) {
                        student.setBirthday(DateUtils.parseDate(birthday, formatter));
                    } else {
                        student.setBirthday(DateUtils.parseDate(birthday));
                    }
                }
                student.setStudentClass(document.getElementById("labClass").text().trim());
                student.setIdCartNum(document.getElementById("Labelsfzh").text().trim());
                student.setBankCartNum(document.getElementById("yhkh").text().trim());
                return student;
            } else {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return null;
    }

    /**
     * 学生登陆
     * <p>
     * /Login.aspx
     */
    private boolean login(String stuNum) {
        String url = baseUrl + "/Login.aspx";
        String checkCode = null;
        int tryCount = 1;
        while (checkCode == null || checkCode.length() != 4) {
            // 验证码长度为4，如果不为4，那肯定是识别失败
            checkCode = getCheckCode();
            tryCount++;
        }
        log.info("尝试识别验证码" + tryCount + "次");

        // 网站用ASP.NET写的，隐藏表单与中的_VIEWSTATE仍需要传回去
        String params = joiner.join(stuNum, stuNum, checkCode);
        HttpUriRequest request = RequestBuilder.post(url)
                .setConfig(conf)
                .addHeader(Headers.USER_AGENT)
                .setEntity(new StringEntity(params, ContentType.APPLICATION_FORM_URLENCODED))
                .build();
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            // 登录成功后会重定向到/student/Index.aspx页面
            EntityUtils.consume(response.getEntity());
            return statusCode == HttpStatus.SC_MOVED_TEMPORARILY;
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return false;
    }

    public boolean logout() {
        String url = baseUrl + "/LogOut.aspx";
        HttpUriRequest request = RequestBuilder.get(url)
                .setConfig(conf)
                .addHeader(Headers.USER_AGENT)
                .build();
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            EntityUtils.consume(response.getEntity());
            return statusCode == HttpStatus.SC_MOVED_TEMPORARILY;
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return false;
    }

    public interface ViewStateParamJoiner {
        String join(String username, String password, String checkCode);
    }
}
