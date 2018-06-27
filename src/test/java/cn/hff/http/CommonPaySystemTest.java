package cn.hff.http;

import org.junit.Test;

import cn.hff.common.CommonPaySystem;
import cn.hff.entity.JxauPayStudent;
import cn.hff.school.jxau.Constants;

/**
 * 网上缴费系统测试
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public class CommonPaySystemTest {

    @Test
    public void test() {
        CommonPaySystem<JxauPayStudent> paySystem = new CommonPaySystem<>(Constants.PAY_SYSTEM_SITE, JxauPayStudent.class);
        JxauPayStudent student = paySystem.getStudentInfo("20142529");
        System.out.println(student);
    }

}
