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

    CommonPaySystem<JxauPayStudent> paySystem = new CommonPaySystem<>(Constants.PAY_SYSTEM_SITE, JxauPayStudent.class);

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