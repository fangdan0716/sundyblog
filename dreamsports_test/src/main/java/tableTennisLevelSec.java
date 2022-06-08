import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public class tableTennisLevelSec {
    public  static final Logger LOGGER= LoggerFactory.getLogger("tableTennisLevelSecMotion");
    //
    public static AndroidDriver tableTennisLevelSecDriver() throws InterruptedException, MalformedURLException {
        LOGGER.info("driverInfo_Start:调用DriverInfo类");
        DriverInfo driverInfo = new DriverInfo();
        String platformName="Android",platformVersion="10",deviceName="A7YFBB1518002112",//VNX9X20420K00639
                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
        LOGGER.info("driverInfo_Start:返回AndroidDriver");
        return driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
    }
    //运动，科目一二手动修改成绩，科目三四点击发起结束
    public static void tableTennisLevelSecMotion() throws InterruptedException, MalformedURLException {
        AndroidDriver driver = tableTennisLevelSecDriver();
        LOGGER.info("点击开始测试 go");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
        while (true) {
            Thread.sleep(7000);
            LOGGER.info("修改科目一平击发球成绩");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_edit")).click();
            Thread.sleep(100);
            driver.findElement(By.id("com.rongmeng.sports.screen:id/e1_r2_et")).sendKeys("2");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/e1_r2_qd_tv")).click();
            Thread.sleep(5000);
            LOGGER.info("修改科目二反手推/拨上旋");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_edit")).click();
            Thread.sleep(100);
            driver.findElement(By.id("com.rongmeng.sports.screen:id/e1_r2_et")).sendKeys("2");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/e1_r2_qd_tv")).click();
            LOGGER.info("修改科目三正手攻球上旋");
            Thread.sleep(5000);
            LOGGER.info("点击发起结束");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_finished")).click();
            Thread.sleep(5000);
            LOGGER.info("科目四1/2正手两点攻上旋");
            Thread.sleep(5000);
            LOGGER.info("点击发起结束");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_finished")).click();
            Thread.sleep(100);
            LOGGER.info("下一位");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_next")).click();
        }
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
            tableTennisLevelSec.tableTennisLevelSecMotion();


    }

}
