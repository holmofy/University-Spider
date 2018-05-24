package cn.hff.common;

import cn.hff.entity.Gender;
import cn.hff.entity.Student;
import cn.hff.http.Headers;
import cn.hff.util.DateUtils;
import cn.hff.util.ImageUtils;
import lombok.AllArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
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
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * 校园网上统一支付平台
 * <p>
 * http://tyzfpt.jxau.edu.cn/student/Index.aspx
 * <p>
 * Created by Holmofy on 2018/5/9.
 */
@AllArgsConstructor
public class CommonPaySystem {

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
    public Student getStudentInfo(String stuNum) {
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
                Student student = new Student();
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
        String params = "__VIEWSTATE=%2FwEPDwULLTE5MTY2NjQxMzQPZBYCZg9kFgQCAQ8WAh4JaW5uZXJodG1sBfQBPGxpPjxhIGNsYXNzPSIiIGhyZWY9ImphdmFzY3JpcHQ6T3BlblB1YignMycpIj7igKLlhbPkuo7nvZHkuIrmlK%2Fku5jml7bpl7TosIPmlbQ8L2E%2BPC9saT48bGk%2BPGEgY2xhc3M9IiIgaHJlZj0iamF2YXNjcmlwdDpPcGVuUHViKCc0JykiPuKAoue8tOi0ueaMh%2BWNlzwvYT48L2xpPjxsaT48YSBjbGFzcz0iIiBocmVmPSJqYXZhc2NyaXB0Ok9wZW5QdWIoJzExJykiPuKAoue9keS4iuaUr%2BS7mOmineW6puivtOaYjjwvYT48L2xpPmQCCw8WAh4HVmlzaWJsZWhkZN1hW9h1jgAKOrAMO6eHdz91lJCgwrUvN5Vz3%2BCUNqCC&__EVENTVALIDATION=%2FwEWBQLEzv6XAgKEwbvHBgKrrsjjCQKcoazCDgKdrZyeBUXbvvCRzmvNcB8PvLXWJnfZnjCaOqfGDeU6VMq8Xrrx" +
                "&txtAdminName=" +
                stuNum +
                "&txtAdminPassword=" +
                stuNum +
                "&txtAdminCheckCode=" +
                checkCode +
                "&adminLoginButton=%E7%99%BB+%E9%99%86";
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
}
