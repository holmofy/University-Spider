package cn.hff.common;

import cn.hff.entity.Gender;
import cn.hff.entity.Student;
import cn.hff.http.Headers;
import cn.hff.util.ImageUtils;
import lombok.AllArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
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

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    private static final int LOGIN_RETRY_COUNT = 5;

    private static HttpClient client = HttpClients.createDefault();

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
                    InputStream content = entity.getContent();
                    return ImageUtils.recognition(content);
                }
            } else {
                log.info("请求失败");
            }
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        } catch (TesseractException e) {
            log.warn("验证码识别失败", e);
        }
        return null;
    }

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
        int retryCount = 0;
        while (!login(stuNum) && retryCount < LOGIN_RETRY_COUNT) {
            retryCount++;
        }
        if (retryCount >= LOGIN_RETRY_COUNT) {
            return null;
        }
        // 登录成功后尝试获取学生信息
        String url = baseUrl + "/student/Index.aspx";
        HttpUriRequest request = RequestBuilder.get(url).build();
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
                    try {
                        student.setBirthday(LocalDate.parse(birthday));
                    } catch (DateTimeParseException e) {
                        log.warn("时间解析异常", e);
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
        String checkCode = getCheckCode();
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
                .addHeader(Headers.USER_AGENT)
                .setEntity(new StringEntity(params, ContentType.APPLICATION_FORM_URLENCODED))
                .build();
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            // 登录成功后会重定向到/student/Index.aspx页面
            return statusCode == HttpStatus.SC_MOVED_TEMPORARILY;
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return false;
    }
}
