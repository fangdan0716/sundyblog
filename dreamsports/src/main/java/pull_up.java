import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.trace.Trace.flush;

public class pull_up {
    public static AndroidDriver driver;
    public static WebDriver driver1;

    public static AndroidDriver pull_Up() throws InterruptedException, MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities ();
        des.setCapability ("platformName", "Android");//平台名称
        des.setCapability ("platformVersion", "10");//手机操作系统版本
        des.setCapability ("deviceName", "A7YFBB1518002080");//使用的手机类型或模拟器类型  UDID
        des.setCapability ("udid", "A7YFBB1518002080");
        des.setCapability ("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability ("appActivity", "com.dreamsport.sports.ui.activity.StartActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到
        des.setCapability ("noReset", true);
        des.setCapability ("automationName", "uiautomator2");
        driver = new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;
    }

    @Test
    public void testDemo() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = pull_Up ();
        sjn s = new sjn ();
        String sportsName = "引体向上";
        String nextname = "下一步";
        String save = "保存设置";
        String Mode = "模式设置";
        String guifan = "规范设置";
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/ed_account")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_account")).sendKeys ("hugaolin");
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_password")).sendKeys ("dabai521");
            driver.hideKeyboard ();
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_login")).click ();
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取跳绳
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
        }


        if (driver.getPageSource ().contains (sportsName) == false) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//引体向上
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_setting_area")).click ();//设置区域
//          driver1.findElement(By.xpath("//*[@text=\""+ ys +"\"]")).click();
//           driver1.findElement(By.xpath("//*[@text=\""+ sheng +"\"]")).click();
            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
        }
        driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screenreen:id/ql_next")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();
        }
        while (true) {
            Thread.sleep (666);
            Assert.assertTrue (Integer.parseInt (driver.findElementById ("com.rongmeng.sports.screen:id/time_tv").getText ()) >= 50);
            driver.findElementById ("com.rongmeng.sports.screen:id/tv_next");
            //s.webdemo1 ();
        }
//        driver.findElement (By.xpath ("//*[@text=\"" + guifan + "\"]")).click ();
//        driver.findElementById ("com.rongmeng.sports.screen:id/rb_difficulty_2").click ();


        // driver2.close();
    }
}
