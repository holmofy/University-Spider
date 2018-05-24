package cn.hff.util;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by Holmofy on 2018/5/24.
 */
@CommonsLog
public class DateUtils {

    private DateUtils() {
    }

    public static LocalDate parseDate(String date) {
        if (StringUtils.isEmpty(date)) return null;
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            log.warn("日期解析失败", e);
            return null;
        }
    }

    public static LocalDate parseDate(String date, DateTimeFormatter formatter) {
        if (StringUtils.isEmpty(date)) return null;
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            log.warn("日期解析失败", e);
            return null;
        }
    }
}
