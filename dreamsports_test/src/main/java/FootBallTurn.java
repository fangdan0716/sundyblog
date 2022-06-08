import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;
/*
足球运球绕杆往返
 */
public class FootBallTurn {
    public  static final Logger LOGGER= LoggerFactory.getLogger("FootBallTurn");
    //起点设备
    public static AndroidDriver FootBallTurn_start() throws InterruptedException, MalformedURLException {
        LOGGER.info("driverInfo_Start:调用DriverInfo类");
        DriverInfo driverInfo = new DriverInfo();
        String platformName="Android",platformVersion="10",deviceName="A7YFBB1510000890",//VNX9X20420K00639
                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
        LOGGER.info("driverInfo_Start:返回AndroidDriver");
        return driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
    }
    //终点设备
    public static AndroidDriver FootBallTurn_finish() throws InterruptedException, MalformedURLException {
        DriverInfo driverInfo = new DriverInfo();
        String platformName="Android",platformVersion="10",deviceName="A7YFBB1517001130",
                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
        return driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
    }
    //运动，无需进入设置区域
    public static void Motion() throws InterruptedException, MalformedURLException {
        LOGGER.info("起点设备对象");
        AndroidDriver start =FootBallTurn_start();
        LOGGER.info("终点设备对象");
        AndroidDriver finish =FootBallTurn_finish();
        LOGGER.info("调用配对方法");
        DeviceMatch.match(start,finish);
        LOGGER.info("起点点击配对页面的开始测试按钮，运动页面进行身份识别");
        start.findElement (By.id ("com.rongmeng.sports.screen:id/start_test")).click ();

        while (true) {
            // driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            //显示等待
            try {
                WebDriverWait wait = new WebDriverWait (start, 1);
                wait.until (ExpectedConditions.presenceOfElementLocated (By.id ("com.rongmeng.sprtos.screen:id/tv_start")));
            }catch (NoSuchElementException e){
                return ;
            }

            Thread.sleep (15000);
            start.findElement (By.id ("com.rongmeng.sports.screen:id/tv_start")).click ();

        }
    }

}
