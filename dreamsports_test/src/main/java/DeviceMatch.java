import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public class DeviceMatch {
    public  static final Logger LOGGER= LoggerFactory.getLogger("DeviceMatch");

    public static void match(AndroidDriver driverStart,AndroidDriver driverFinish) throws MalformedURLException, InterruptedException{
        LOGGER.info("起点点击go 开始测试");
        driverStart.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
        LOGGER.info("获取起点配对码");
        String match_code = driverStart.findElement (By.id ("com.rongmeng.sports.screen:id/tv_code")).getText ();
        Thread.sleep(5000);

        LOGGER.info("终点点击go 开始测试");

        LOGGER.info("终点点击go 开始测试");
        driverFinish.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
        LOGGER.info("终点输入配对码");
        Thread.sleep (500);
        if (driverFinish.getPageSource ().contains ("com.rongmeng.sports.screen:id/et_input")) {
        //填充配对码
            driverFinish.findElement (By.id ("com.rongmeng.sports.screen:id/et_input")).sendKeys (match_code);
        //点击确定
            driverFinish.findElement (By.id ("com.rongmeng.sports.screen:id/btn_confirm")).click ();
    }
        Thread.sleep (200);
        LOGGER.info("p配对成功，点击开始测试");
    }
}
