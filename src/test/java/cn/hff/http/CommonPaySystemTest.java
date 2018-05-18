package cn.hff.http;

import cn.hff.common.CommonPaySystem;
import cn.hff.entity.Student;
import cn.hff.school.jxau.Constants;
import org.junit.Test;

/**
 * 网上缴费系统测试
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public class CommonPaySystemTest {

    @Test
    public void test() {
        CommonPaySystem paySystem = new CommonPaySystem(Constants.PAY_SYSTEM_SITE);
        Student student = paySystem.getStudentInfo("20142529");
        System.out.println(student);
    }

}
