package cn.hff.scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.hff.dao.JxnuStudentInfoDao;
import cn.hff.entity.Gender;
import cn.hff.entity.JxnuStudentInfo;

/**
 * Created by Holmofy on 2018/6/27.
 */
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

    FirefoxDriver driver = new FirefoxDriver();

    public void track() {
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
        for (int i = 0; i < collegeSelector.getOptions().size(); i++) {
            collegeSelector.selectByIndex(i);
            // 选择了学院导致页面刷新，ASP.NET写的网站就是这么坑逼
            // 每个学院的班级数可能不一样，要临时获取
            WebElement clazz = driver.findElement(By.id("_ctl1_ddlClass"));
            Select classSelector = new Select(clazz);
            for (int j = 0; j < classSelector.getOptions().size(); j++) {
                classSelector.selectByIndex(j);
                driver.findElement(By.id("_ctl1_btnSearch")).click();
                processTableResult();
                // 刷新页面后重新加载DOM，需要重新查找
                clazz = driver.findElement(By.id("_ctl1_ddlClass"));
                classSelector = new Select(clazz);
            }
            // 注意，下一次循环页面已经刷新，需要重新findElement
            college = driver.findElement(By.id("_ctl1_ddlCollege"));
            collegeSelector = new Select(college);
        }
    }

    private void processTableResult() {
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
                .collect(Collectors.toList());
        jxnuStudentInfoDao.saveAll(students);
    }

}
