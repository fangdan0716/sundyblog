import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.trace.Trace.flush;

public class Basketball_around_the_pole {

    public static AndroidDriver setUp1() throws InterruptedException, MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities ();
        des.setCapability ("platformName", "Android");//平台名称
        des.setCapability ("platformVersion", "10");//手机操作系统版本
        des.setCapability ("deviceName", "A7YFBB1518002112");//使用的手机类型或模拟器类型  UDID
        des.setCapability ("udid", "A7YFBB1518002112");
        des.setCapability ("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability ("appActivity", "com.dreamsport.sports.ui.activity.StartActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到
        des.setCapability ("noReset", true);
//        des.setCapability("waitForIdleTimeout",100);
        //  des.setCapability ("automationName", "uiautomator2");
        driver = new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址

        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;
    }

    @Test
    public void testDemo() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = setUp1 ();
        sjn s = new sjn ();
        String sportsName = "发令起跑";
        String nextname = "下一步";
        String save = "保存设置";
        String Mode = "模式设置";
        String guifan = "规范设置";
        String sss = "计时结束";
//        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/ed_account")) {
//            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_account")).sendKeys ("hugaolin");
//            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_password")).sendKeys ("dabai521");
//            driver.hideKeyboard ();
//            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_login")).click ();
//            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取跳绳
//            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
//            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
//            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
//        }
        driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_go")).click ();
        while (true) {
            flush();
            Thread.sleep (8888);
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();
            Thread.sleep (8000);
            driver.findElement (By.xpath ("//*[@text=\"" + sss + "\"]")).click ();
        }

    }
}
