import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import oracle.jrockit.jfr.jdkevents.ThrowableTracer;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.trace.Trace.flush;

//import org.junit.jupiter.api.DynamicTest;
public class Basic {




    public static AndroidDriver setUp() throws InterruptedException, MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities ();
        des.setCapability ("platformName", "Android");//平台名称
        des.setCapability ("platformVersion", "10");//手机操作系统版本
        des.setCapability ("deviceName", "VNX9X20420K00459");//使用的手机类型或模拟器类型  UDID
        des.setCapability ("udid", "VNX9X20420K00459");
        des.setCapability ("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability ("appActivity", "com.dreamsport.sports.ui.activity.StartActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到
        des.setCapability ("noReset", true);
//        des.setCapability("waitForIdleTimeout",100);
        //  des.setCapability ("automationName", "uiautomator2");
        driver = new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;
    }


    public static WebDriver webdemo1() {

        WebDriver driver1;
        WebDriver driver2 = new ChromeDriver ();
        driver2.get ("http://yuntiyu-test.dream-sports.cn/#/login?redirect=%2FstudentManage");
        String title = driver2.getTitle ();
        System.out.printf (title);
        return driver2;
    }

    @Test
    public void testDemo1() throws MalformedURLException, InterruptedException {
//    public static void main(String[] args) throws IOException, InterruptedException {
        // Common cm = new Common();
       AndroidDriver driver = setUp ();
        String sportsName = "跳绳";
        String nextname = "下一步";
        String save = "保存设置";
        String Mode = "模式设置";
        String sheng = "无绳";
        String ys = "有绳";
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


        //判断非跳绳项目
        if (driver.getPageSource ().contains (sportsName) == false) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取跳绳
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_setting_area")).click ();//设置区域
            if (driver.findElement (By.xpath ("(//*[@text=\"有绳\"])")).getText ().equals ("有绳")) {
                driver.findElement (By.xpath ("//*[@text=\"" + ys + "\"]")).click ();
                driver.findElement (By.xpath ("//*[@text=\"" + sheng + "\"]")).click ();
            }
//        driver1.findElement(By.xpath("//*[@text=\""+ ys +"\"]")).click();
//        driver1.findElement(By.xpath("//*[@text=\""+ sheng +"\"]")).click();

            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
        }

//          while(driver1.getPageSource().contains(sportsName)==false){
//              //     cm.SwipeLeft(driver1);
//          };

//            driver1.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//获取跳绳
//             driver1.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步

//
//          while(driver1.getPageSource().contains(sportsName)==false){
//              //     cm.SwipeLeft(driver1);
//          };
        driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screenreen:id/ql_next")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();
        }

        //String okBtn_xpath = "(//*[contains(@text,'允许')])[2]";
        //driver.findElement (By.xpath ("//*[@text=\"" + Mode + "\"]")).click ();
        // 判断游客模式是否为开启状态
//        if (driver.findElement (By.xpath ("(//*[@text=\"游客模式\"]/following-sibling::*)[2]")).getText ().equals ("关闭")) {
//            driver.findElement (By.xpath ("(//*[@text=\"游客模式\"]/following-sibling::*)[1]")).click ();
//        }
//
//        if (driver.findElement (By.xpath ("(//*[@text=\"自动切换下一位\"]/following-sibling::*)[2]")).getText ().equals ("关闭")) {
//            driver.findElement (By.xpath ("(//*[@text=\"自动切换下一位\"]/following-sibling::*)[1]")).click ();
//        }
        //
//          String results= "com.rongmeng.sports.screen:id/time_tv";//获取成绩
//           String nextLinkId = "com.rongmeng.sports.screen:id/start_tv_next_group";
        Thread.sleep (2000);
//        driver.findElementByXPath ("//*[@resource-id='com.rongmeng.sports.screen:id/tab1_lay']");
//        driver.findElement (By.id ("com.rongmeng.sports.screen:id/time_tv"));
      //  Assert.assertTrue (Integer.parseInt (driver.findElementById ("com.rongmeng.sports.screen:id/time_tv").getText ()) >= 50);
        Thread.sleep (60000);
        flush ();
        WebDriver driver2 = webdemo1 ();
        driver2.manage ().window ().maximize ();
        driver2.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/ul/li[2]")).click ();
        //*[@id="app"]/div/div[2]/div/form/ul/li[2]
        driver2.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/div[1]/div/div/input")).sendKeys ("hugaolin");
        driver2.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/div[2]/div/div/input")).sendKeys ("dabai521");
        driver2.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/button")).click ();
        Thread.sleep (10000);
        driver2.findElement (By.xpath ("//*[@id=\"app\"]/div/section/main/div/center[1]/div/div[1]/div/div/div[1]")).click ();
        driver2.findElement (By.xpath ("//*[@id=\"app\"]/div/section/main/div/div/div/div[1]/div/ul/div[7]/a/li")).click ();
        while (true) {
            Thread.sleep (60000);
            driver2.navigate ().refresh ();
            Thread.sleep (2000);
            Assert.assertTrue (Integer.parseInt (driver.findElementById ("com.rongmeng.sports.screen:id/time_tv").getText ()) >= 50);
            String rue=driver.findElementById ("com.rongmeng.sports.screen:id/time_tv").getText ();


        }
//         driver2.close();
    }

//    public void tearDown() {
//        // driver.quit();//注释后脚本执行完后APP不会退出。
//    }
}

