package cn.hff.scheduler;

import cn.hff.common.CommonPaySystem;
import cn.hff.dao.JxauStudentInfoDao;
import cn.hff.dao.StudentDao;
import cn.hff.entity.Student;
import cn.hff.school.jxau.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link CommonPaySystem}
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
@Component
public class PaySystemTracker {

    private static final Log log = LogFactory.getLog(PaySystemTracker.class);

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JxauStudentInfoDao studentInfoDao;

    CommonPaySystem paySystem = new CommonPaySystem(Constants.PAY_SYSTEM_SITE);

    public void track() {
        long count = studentInfoDao.count();
        for (int i = 1; i <= count; i++) {
            String stuNum = studentInfoDao.findById(i).get().getStuNum();
            if (studentDao.countByStuNumber(stuNum) <= 0) {
                Student student = paySystem.getStudentInfo(stuNum);
                // 获取成功就可以退出账号，方便下个账号登陆
                paySystem.logout();
                if (student != null) {
                    studentDao.save(student);
                }
            } else {
                log.info("学号" + stuNum + "信息已采集");
            }
        }
    }
}
