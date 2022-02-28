import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Table_tennis {

    public static AndroidDriver setUp() throws InterruptedException, MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersio", "10");//手机操作系统版本
        des.setCapability("deviceName", "A7YFBB1518002112");//使用的手机类型或模拟器类型  UDID
        des.setCapability("udid", "A7YFBB1518002112");
        des.setCapability("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability("appActivity", ".ui.start.StartActivity");//注意更换app测试人员常常要获取activity
        des.setCapability("appWaitActivity", "");
        des.setCapability("noReset", true);
//        des.setCapability("waitForIdleTimeout",100);
        //  des.setCapability ("automationName", "uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;
    }

    @Test
    public void testDemo1() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = setUp();
        String ss = "乒乓球一级";
        String se = "对空颠球";
        String se1 = "对墙颠球";
        String se2 = "托球绕桌跑";
        String se3 = "双手接球";
        String  sss = "设置区域";
        String nextname = "下一步";
        String save = "保存设置";
        // String sc =driver.findElement (By.id ("com.rongmeng.sports.screen:id/set_check_tv")).getText();
        String a[] = {se, se1, se2, se3};
        Common cm = new Common();

        // driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
        // driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
        if (driver.getPageSource().contains(ss) == false) {
            //cm.SwipeLeft(driver);//滑动向左
            driver.findElement(By.xpath("//*[@text=\"" + ss + "\"]")).click();//获取乒乓球1级
            driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();//下一步
            driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//保存
            Thread.sleep(100);
            driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//保存
            // driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();//设置
            //  driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_setting_area")).click();//设置区域
        }
        System.out.print(a[0]);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();//设置
            driver.findElement(By.xpath("//*[@text=\"" + sss + "\"]")).click(); //设置区域
            driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).click();
            driver.findElement(By.xpath("//*[@text=\"" + a[i] + "\"]")).click();//选择项目
            driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//下一步
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//保存
            driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
            if (driver.getPageSource().contains("com.rongmeng.sports.screenreen:id/ql_next")) {
                driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();
            }
            Thread.sleep(60000);
            driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_back")).click();
            if (i == 3) {
                i = 0;
            }

        }

    }
}

