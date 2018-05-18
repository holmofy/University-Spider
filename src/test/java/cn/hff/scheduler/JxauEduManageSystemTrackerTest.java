package cn.hff.scheduler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Holmofy on 2018/5/14.
 */
@SpringBootTest
@Configuration
@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = "cn.hff.dao")
public class JxauEduManageSystemTrackerTest {

    @Autowired
    JxauEduManageSystemTracker tracker;

    @Test
    public void test() {
        tracker.track();
    }

}
