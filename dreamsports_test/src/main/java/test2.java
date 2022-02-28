import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test2 {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities();
        //    des.setCapability("automationName", "Appium");//Selendroid //自动化的模式选择
        //     des.setCapability("app", "C:\\software\\CalcTest.apk");//配置待测试的apk的路径
//      des.setCapability("browserName", "chrome");  //h5
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "10");//手机操作系统版本
        des.setCapability("deviceName", "VNX9X20420K00723");//使用的手机类型或模拟器类型  UDID
        des.setCapability("udid","VNX9X20420K00723");
        des.setCapability("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability("appActivity", "com.rongmeng.sports.screen.ui.start.StartActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到

//        des.setCapability("unicodeKeyboard", "True");//支持中文输入
//        des.setCapability("resetKeyboard", "True");//支持中文输入
//        des.setCapability("newCommandTimeout", "10");//没有新命令时的超时时间设置
//        des.setCapability("nosign", "True");//跳过检查和对应用进行 debug 签名的步骤

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms

        Common cm = new Common();
        driver.findElement(By.id("com.rongmeng.sports.screen:id/ed_account")).sendKeys("hugaolin");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/ed_password")).sendKeys("hugaolin2021");
        driver.hideKeyboard();
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_login")).click();
        while(cm.byElementIsExist(driver,By.xpath("//*[@text='跳绳']"))==false){
            cm.SwipeLeft(driver);
        };
        driver.findElement(By.xpath("//*[@text='跳绳']")).click();
        driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();
        while(cm.byElementIsExist(driver,By.xpath("//*[contains(@text,'允许')]"))){
            driver.findElement(By.xpath("//*[contains(@text,'允许')]")).click();
        }
    }

}