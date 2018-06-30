package cn.hff.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.hff.common.CommonPaySystem;
import cn.hff.dao.JxauPayStudentDao;
import cn.hff.dao.JxauStudentInfoDao;
import cn.hff.entity.JxauPayStudent;
import cn.hff.entity.JxauStudentInfo;
import cn.hff.school.jxau.Constants;
import lombok.extern.apachecommons.CommonsLog;

/**
 * {@link CommonPaySystem}
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
@CommonsLog
@Component
public class JxauPaySystemTracker {

    @Autowired
    private JxauPayStudentDao studentDao;

    @Autowired
    private JxauStudentInfoDao studentInfoDao;

    CommonPaySystem<JxauPayStudent> paySystem = new CommonPaySystem<>(Constants.PAY_SYSTEM_SITE, JxauPayStudent.class,
            (username, password, checkCode) -> "__VIEWSTATE=%2FwEPDwULLTE5MTY2NjQxMzQPZBYCZg9kFgQCAQ8WAh4JaW5uZXJodG1sBfQBPGxpPjxhIGNsYXNzPSIiIGhyZWY9ImphdmFzY3JpcHQ6T3BlblB1YignMycpIj7igKLlhbPkuo7nvZHkuIrmlK%2Fku5jml7bpl7TosIPmlbQ8L2E%2BPC9saT48bGk%2BPGEgY2xhc3M9IiIgaHJlZj0iamF2YXNjcmlwdDpPcGVuUHViKCc0JykiPuKAoue8tOi0ueaMh%2BWNlzwvYT48L2xpPjxsaT48YSBjbGFzcz0iIiBocmVmPSJqYXZhc2NyaXB0Ok9wZW5QdWIoJzExJykiPuKAoue9keS4iuaUr%2BS7mOmineW6puivtOaYjjwvYT48L2xpPmQCCw8WAh4HVmlzaWJsZWhkZN1hW9h1jgAKOrAMO6eHdz91lJCgwrUvN5Vz3%2BCUNqCC&__EVENTVALIDATION=%2FwEWBQLEzv6XAgKEwbvHBgKrrsjjCQKcoazCDgKdrZyeBUXbvvCRzmvNcB8PvLXWJnfZnjCaOqfGDeU6VMq8Xrrx" +
                    "&txtAdminName=" +
                    username +
                    "&txtAdminPassword=" +
                    password +
                    "&txtAdminCheckCode=" +
                    checkCode +
                    "&adminLoginButton=%E7%99%BB+%E9%99%86");

    public void track() {
//        List<JxauStudentInfo> students = studentInfoDao.findByStuNumLike("2016%");
        List<JxauStudentInfo> students = studentInfoDao.findByStatusNotEquals("未报到");
        students.stream().map(JxauStudentInfo::getStuNum)
                .filter(stuNum -> {
                    int c = studentDao.countByStuNumber(stuNum);
                    if (c > 0) {
                        log.info(stuNum + "学号信息已采集，跳过");
                    }
                    return c <= 0;
                })
                .forEach(stuNum -> {
                    JxauPayStudent student = paySystem.getStudentInfo(stuNum);
                    // 获取成功就可以退出账号，方便下个账号登陆
                    paySystem.logout();
                    if (student != null) {
                        studentDao.save(student);
                    }
                });
    }
}
