package cn.hff.util;

import org.springframework.util.StringUtils;

/**
 * 解析数字的工具类
 * <p>
 * Created by Holmofy on 2018/6/27.
 */
public class NumberUtils {

    private NumberUtils() {
    }

    public static Double safeParseDouble(String string) {
        return StringUtils.isEmpty(string) ? null : Double.parseDouble(string);
    }

    public static Integer safeParseInteger(String string) {
        return StringUtils.isEmpty(string) ? null : Integer.parseInt(string);
    }

}
