import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class sit_ups {
    public static AndroidDriver setUp() throws InterruptedException, MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities ();
        AndroidDriver driver;
        des.setCapability ("platformName", "Android");//平台名称
        des.setCapability ("platformVersion", "10");//手机操作系统版本
        des.setCapability ("deviceName", "A7YFBB1518002080");//使用的手机类型或模拟器类型  UDID
        des.setCapability ("udid", "A7YFBB1518002080");
        des.setCapability ("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability ("appActivity", "com.dreamsport.sports.ui.activity.StartActivity");//注意更换app测试人员常常要获取activity
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
        // Common cm = new Common();
        AndroidDriver driver = setUp ();
        sjn s = new sjn ();
        String sportsName = "仰卧起坐";
        String nextname = "下一步";
        String Under_a = "下一位";
        String save = "保存设置";
        //判断首次进入
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/ed_account")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_account")).sendKeys ("hugaolin");
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_password")).sendKeys ("dabai521");
            driver.hideKeyboard ();
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_login")).click ();
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取仰卧起坐
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
        }



        if (driver.getPageSource ().contains (sportsName) == false) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取仰卧起坐
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            //driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
           // driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
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


//        driver.findElement (By.xpath ("//*[@text=\"" + guifan + "\"]")).click ();
//        driver.findElementById ("com.rongmeng.sports.screen:id/rb_difficulty_2").click ();
        Thread.sleep (60000);

       // s.webdemo1 ();
    }
}
