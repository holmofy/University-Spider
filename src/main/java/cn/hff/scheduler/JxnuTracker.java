package cn.hff.scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import cn.hff.common.CommonPaySystem;
import cn.hff.dao.JxnuPayStudentDao;
import cn.hff.dao.JxnuStudentInfoDao;
import cn.hff.entity.Gender;
import cn.hff.entity.JxnuPayStudent;
import cn.hff.entity.JxnuStudentInfo;
import cn.hff.school.jxnu.Constants;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Holmofy on 2018/6/27.
 */
@Slf4j
@Component
public class JxnuTracker {

    private static final String STU_NUM = "1402031024";

    private static final String PASSWD = "360428199708060043";

    static {
        System.setProperty("webdriver.chrome.driver", "E:/HTMLDevTools/selenium/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "E:/HTMLDevTools/selenium/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "E:/HTMLDevTools/selenium/MicrosoftWebDriver.exe");
        System.setProperty("webdriver.ie.driver", "E:/HTMLDevTools/selenium/IEDriverServer.exe");
    }

    @Autowired
    private JxnuStudentInfoDao jxnuStudentInfoDao;

    @Autowired
    private JxnuPayStudentDao jxnuPayStudentDao;


    public void trackCommonInfo() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://jwc.jxnu.edu.cn");
        WebElement loginWindow = driver.findElement(By.id("login_window")).findElement(By.tagName("iframe"));
        driver.switchTo().frame(loginWindow);
        WebElement stuNum = driver.findElement(By.id("StuNum"));
        stuNum.click();
        stuNum.sendKeys(STU_NUM);
        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys(PASSWD);
        driver.findElement(By.id("login")).click();
        driver.getScreenshotAs(OutputType.FILE);
        driver.get("http://jwc.jxnu.edu.cn/User/default.aspx?&code=119&&uctl=MyControl\\all_searchstudent.ascx");
        driver.findElement(By.id("_ctl1_rbtType_1")).click();

        WebElement college = driver.findElement(By.id("_ctl1_ddlCollege"));
        Select collegeSelector = new Select(college);
        for (int i = 17; i < collegeSelector.getOptions().size(); i++) {
            collegeSelector.selectByIndex(i);
            // 选择了学院导致页面刷新，ASP.NET写的网站就是这么坑逼
            // 每个学院的班级数可能不一样，要临时获取
            WebElement clazz = driver.findElement(By.id("_ctl1_ddlClass"));
            Select classSelector = new Select(clazz);
            for (int j = 0; j < classSelector.getOptions().size(); j++) {
                try {
                    classSelector.selectByIndex(j);
                    driver.findElement(By.id("_ctl1_btnSearch")).click();
                    processTableResult(driver);
                    // 刷新页面后重新加载DOM，需要重新查找
                    clazz = driver.findElement(By.id("_ctl1_ddlClass"));
                    classSelector = new Select(clazz);
                } catch (Exception e) {
                    log.warn("class selector error", e);
                }
            }
            // 注意，下一次循环页面已经刷新，需要重新findElement
            college = driver.findElement(By.id("_ctl1_ddlCollege"));
            collegeSelector = new Select(college);
        }
    }

    private void processTableResult(FirefoxDriver driver) {
        WebElement content = driver.findElement(By.id("_ctl1_dgContent"));
        String innerText = content.getText();
        String[] lines = innerText.split("\n");
        List<JxnuStudentInfo> students = Arrays.stream(lines)
                .skip(1)// 跳过表头
                .map(line -> line.split("\\s+"))
                .map((words) -> JxnuStudentInfo.builder()
                        .department(words[0].trim())
                        .className(words[1].trim())
                        .name(words[2].trim())
                        .stuNum(words[3].trim())
                        .gender(Gender.fromText(words[4].trim()))
                        .build())
                // 前面可能已经保存过
                .filter(stuInfo -> {
                    if (0 != jxnuStudentInfoDao.count(Example.of(stuInfo))) {
                        log.info("该记录已经保存:学号{},姓名{}", stuInfo.getStuNum(), stuInfo.getName());
                        return false;
                    } else {
                        log.info("即将保存该记录:学号" + stuInfo.getStuNum());
                        return true;
                    }
                })
                .collect(Collectors.toList());
        jxnuStudentInfoDao.saveAll(students);
        log.info("保存了{}条数据", students.size());
    }

    public void trackPaySystem() {
        CommonPaySystem<JxnuPayStudent> system = new CommonPaySystem<>(Constants.PAY_SYSTEM_SITE, JxnuPayStudent.class,
                (username, password, checkCode) -> "__VIEWSTATE=%2FwEPDwUKLTY4MDgxMjMxOA9kFgJmD2QWBAIBDxYCHglpbm5lcmh0bWwFSDxsaT48YSBjbGFzcz0iIiBocmVmPSJqYXZhc2NyaXB0Ok9wZW5QdWIoJzExJykiPuKAoue8tOi0ueaMh%2BWNlzwvYT48L2xpPmQCCw8WAh4HVmlzaWJsZWhkZJBOfGt45hXHuF9LVGDFy%2B28KE%2BcTJvKCxYt6AladQuv&__VIEWSTATEGENERATOR=C2EE9ABB&__EVENTVALIDATION=%2FwEdAAW5JEU99IPGSBTVCEszFgAC4V1o1qVa7bfV9m%2FH81YMMFmDzMIKFHB6OjBdi43WAtkDcJrrcHDvat2dWinsG8z3lLE7dCbT1gK400y5xzXO2N2HMwvff4KeY2X14WuxfvZJeWtOJqKQZZzdd6Z%2F5zb6" +
                        "&txtAdminName=" + username +
                        "&txtAdminPassword=" + password +
                        "&txtAdminCheckCode=" + checkCode +
                        "&adminLoginButton=%E7%99%BB+%E9%99%86");
        // 14届
        List<JxnuStudentInfo> list1 = jxnuStudentInfoDao.findByStuNumStartingWith("14");
        // 学号有20前缀
        List<JxnuStudentInfo> list2 = jxnuStudentInfoDao.findByStuNumStartingWith("2014");
        Stream.concat(list1.stream().map(JxnuStudentInfo::getStuNum),
                list2.stream().map(JxnuStudentInfo::getStuNum).map(stuNum -> stuNum.substring(2)))
                .map(system::getStudentInfo)
                .filter(Objects::nonNull)
                .peek((studentInfo) -> log.info("信息保存成功，学号：" + studentInfo.getStuNumber()))
                .peek(jxnuPayStudentDao::save)
                .forEach((student) -> system.logout());
    }


    public void distinctStuNum() {
        List<String> stuNums = jxnuStudentInfoDao.findDistinctStuNum();
        if (!CollectionUtils.isEmpty(stuNums)) {
            stuNums.forEach(num -> {
                JxnuStudentInfo stu = jxnuStudentInfoDao.getFirstByStuNum(num);
                Integer id = stu.getId();
                jxnuStudentInfoDao.deleteByStuNumEqualsAndIdNotEquals(num, id);
            });
        }
    }


}
