import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class solid {

    //起掷线
    public static AndroidDriver setUp() throws InterruptedException, MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities ();
        AndroidDriver driver;
        des.setCapability ("platformName", "Android");//平台名称
        des.setCapability ("platformVersion", "10");//手机操作系统版本
        des.setCapability ("deviceName", "VNX9X20420K00634");//使用的手机类型或模拟器类型  UDID
        des.setCapability ("udid", "VNX9X20420K00634");
        des.setCapability ("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability ("appActivity", "com.dreamsport.sports.ui.activity.StartActivity");//注意更换app测试人员常常要获取activity
        des.setCapability ("noReset", true);
//    des.setCapability("waitForIdleTimeout",100)
//  des.setCapability ("automationName", "uiautomator2");
        driver = new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;

    }

    //投掷区
    public static AndroidDriver setUp1() throws InterruptedException, MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities ();
        des.setCapability ("platformName", "Android");//平台名称
        des.setCapability ("platformVersion", "10");//手机操作系统版本
        des.setCapability ("deviceName", "A7YFBB1628001082");//使用的手机类型或模拟器类型  UDID
        des.setCapability ("udid", "A7YFBB1628001082");
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
    public void testDemo1() throws MalformedURLException, InterruptedException {
//    public static void main(String[] args) throws IOException, InterruptedException {
        Common cm = new Common ();
        AndroidDriver driver = setUp ();//起掷线
        AndroidDriver driver1 = setUp1 ();//投掷区
        sjn s = new sjn ();
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/ed_account")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_account")).sendKeys ("hugaolin");
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_password")).sendKeys ("dabai521");
            driver.hideKeyboard ();
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_login")).click ();

        }
        String sportsName = "实心球";
        String nextname = "下一步";
        String save = "保存设置";
        String The_roll = "起掷线";
        String throwing = "投掷区1";
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/info_tv")) {
            //  driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            //driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
            //cm.SwipeLeft (driver);//滑动向左
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//实心球
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + The_roll + "\"]")).click ();
            driver.findElement (By.xpath ("//*[@text=\"" + throwing + "\"]")).click ();
            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
        }

        if (driver.getPageSource ().contains (The_roll) == false) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
            //cm.SwipeLeft (driver);//滑动向左
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取实心球
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_setting_area")).click ();//设置区域
            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
        }
        driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_go")).click ();
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screenreen:id/ql_next")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();
        }
        Thread.sleep (2000);

        //投掷区
        if (driver1.getPageSource ().contains ("com.rongmeng.sports.screen:id/hint")) {
            //  driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            //driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
            cm.SwipeLeft (driver1);//滑动向左
            driver1.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//实心球
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver1.findElement (By.xpath ("//*[@text=\"" + The_roll + "\"]")).click ();//选择投掷区
            driver1.findElement (By.xpath ("//*[@text=\"" + throwing + "\"]")).click ();
            driver1.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver1.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
        }
        if (driver1.getPageSource ().contains (sportsName) == false) {
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
//            for (int i = 0; i < 7; i++) {
//                cm.SwipeLeft (driver1);//滑动向左
//            }
            driver1.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取实心球
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/btn_setting_area")).click ();//设置区域
            driver1.findElement (By.xpath ("//*[@text=\"" + The_roll + "\"]")).click ();//选择投掷区
            driver1.findElement (By.xpath ("//*[@text=\"" + throwing + "\"]")).click ();
            driver1.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver1.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存设置
        }
        driver1.findElement (By.id ("com.rongmeng.sports.screen:id/btn_go")).click ();
        if (driver1.getPageSource ().contains ("com.rongmeng.sports.screenreen:id/ql_next")) {
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();
        }
        //获取配对码
        String ss = driver.findElementById ("com.rongmeng.sports.screen:id/tv_code").getText ();
        //判断有无输入框
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/et_input")) {
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/et_input")).sendKeys (ss);
            driver1.findElement (By.id ("com.rongmeng.sports.screen:id/btn_confirm")).click ();
        }

        Thread.sleep (2000);
        driver.findElement (By.id ("com.rongmeng.sports.screen:id/start_test")).click ();
        //打开后端网址
       // s.webdemo1 ();
    }

}