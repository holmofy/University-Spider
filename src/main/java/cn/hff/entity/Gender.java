package cn.hff.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别
 * <p>
 * Created by Holmofy on 2018/5/9.
 */
@Getter
@AllArgsConstructor
public enum Gender {

    MALE("男"), FEMALE("女"), UNKNOWN("未知");

    private String text;

    public static Gender fromText(String text) {
        if ("男".equals(text)) {
            return MALE;
        } else if ("女".equals(text)) {
            return FEMALE;
        } else {
            return UNKNOWN;
        }
    }
}
