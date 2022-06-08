import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public class tableTennisLevelFirst {
    public  static final Logger LOGGER= LoggerFactory.getLogger("tableTennisLevelFirstDriver");
    //
    public static AndroidDriver tableTennisLevelFirstDriver() throws InterruptedException, MalformedURLException {
        LOGGER.info("driverInfo_Start:调用DriverInfo类");
        DriverInfo driverInfo = new DriverInfo();
        String platformName="Android",platformVersion="10",deviceName="A7YFBB1514000232",//VNX9X20420K00639
                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
        LOGGER.info("driverInfo_Start:返回AndroidDriver");
        return driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
    }
    public static void tableTennisLevelFirstMotion() throws InterruptedException, MalformedURLException {
        AndroidDriver driver = tableTennisLevelFirstDriver();
        LOGGER.info("点击开始测试 go");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
        while (true) {
            LOGGER.info("乒乓球运动时长为30秒");
            Thread.sleep(40000);
            LOGGER.info("点击下一位");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_next")).click();
        }

    }

    public static void main(String[] args) throws  InterruptedException, MalformedURLException {
        tableTennisLevelFirstMotion();
    }
}
