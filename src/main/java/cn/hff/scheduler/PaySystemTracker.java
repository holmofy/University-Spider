package cn.hff.scheduler;

import cn.hff.common.CommonPaySystem;
import cn.hff.dao.JxauStudentInfoDao;
import cn.hff.dao.StudentDao;
import cn.hff.entity.Student;
import cn.hff.school.jxau.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link CommonPaySystem}
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
@Component
public class PaySystemTracker {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JxauStudentInfoDao studentInfoDao;

    CommonPaySystem paySystem = new CommonPaySystem(Constants.PAY_SYSTEM_SITE);

    public void track() {
        long count = studentInfoDao.count();
        for (int i = 1; i <= count; i++) {
            String stuNum = studentInfoDao.findById(i).get().getStuNum();
            Student student = paySystem.getStudentInfo(stuNum);
            studentDao.save(student);
        }
    }
}
