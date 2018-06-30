package cn.hff.scheduler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Holmofy on 2018/6/28.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JxnuTrackerTest {

    @Autowired
    JxnuTracker tracker;

    @Test
    public void test() {
        tracker.trackPaySystem();
    }

    @Test
    public void distinct() {
        tracker.distinctStuNum();
    }

}
