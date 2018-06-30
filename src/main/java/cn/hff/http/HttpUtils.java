package cn.hff.http;

import cn.hff.school.jxau.EduManageSystem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Holmofy on 2018/5/13.
 */
public class HttpUtils {

    private static final Log log = LogFactory.getLog(EduManageSystem.class);

    private static final HttpClient client = HttpClients.createDefault();

    public static InputStream get(String url) {
        HttpUriRequest request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                return response.getEntity().getContent();
            } else {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        } catch (IOException e) {
            log.warn("网络请求失败");
        }
        return null;
    }

}
