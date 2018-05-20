package cn.hff.school.jxau;

import cn.hff.dao.StudentDao;
import cn.hff.entity.Student;
import cn.hff.http.Headers;
import cn.hff.http.HttpUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 校园一卡通系统
 * <p>
 * Created by Holmofy on 2018/5/10.
 */
@Component
public class SchoolCardSystem {

    private static final Log log = LogFactory.getLog(SchoolCardSystem.class);

    private static final String prefix = "60";

    private static final String baseUrl = Constants.SCHOOL_CARD_SITE;

    private static final HttpClient client = HttpClients.createDefault();

    @Autowired
    private StudentDao studentDao;

    /**
     * 获取学生基本信息
     * <p>
     * http://210.35.128.134/SelfSearch/User/baseinfo.aspx
     */
    public Student getBaseInfo() {
        return null;
    }

    /**
     * http://210.35.128.134/SelfSearch/User/Photo.ashx
     */
    public InputStream getStudentImage() {
        String url = baseUrl + "/SelfSearch/User/Photo.ashx";
        return HttpUtils.get(url);
    }

    private boolean login(String stuNum) {
        String password = getPassword(stuNum);
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        String jobNum = prefix + stuNum;
        String url = baseUrl + "/SelfSearch/PostLogin.aspx";
        HttpUriRequest request = RequestBuilder.post(url)
                .addHeader(Headers.USER_AGENT)
                .addParameter("logintype", "Outid")
                .addParameter("username", jobNum)
                .addParameter("password", password)
                .build();
        try {
            HttpResponse response = client.execute(request);
            EntityUtils.consume(response.getEntity());
            // 登录成功重定向到/SelfSearch/Index.aspx页面
            return response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY;
        } catch (IOException e) {
            log.warn("网络请求失败", e);
        }
        return false;
    }

    private String getPassword(String stuNum) {
        String idCartNum = studentDao.findByStuNumber(stuNum).getIdCartNum();
        if (!StringUtils.isEmpty(idCartNum)) {
            return idCartNum.substring(idCartNum.length() - 6)
                    .replace('X', '0')
                    .replace('x', '0');
        }
        return null;
    }
}
