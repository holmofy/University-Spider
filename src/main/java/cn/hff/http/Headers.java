package cn.hff.http;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

/**
 * Http请求头，模拟浏览器请求
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public class Headers {

    private Headers() {
    }

    private static final String USER_AGENT_VALUE = "\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36\"";

    public static final Header USER_AGENT = new BasicHeader(HttpHeaders.USER_AGENT, USER_AGENT_VALUE);


}
