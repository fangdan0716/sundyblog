import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class tiduanDemo3 {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities();
        //    des.setCapability("automationName", "Appium");//Selendroid //自动化的模式选择
        //     des.setCapability("app", "C:\\software\\CalcTest.apk");//配置待测试的apk的路径
//      des.setCapability("browserName", "chrome");  //h5
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "10");//手机操作系统版本
        des.setCapability("deviceName", "192.168.110.176:5555");//使用的手机类型或模拟器类型  UDID  192.168.1.193:5555  AFFBB20721901159
        des.setCapability("udid","192.168.110.176:5555");
        des.setCapability("appPackage", "cn.dreamsports.exercise");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability("appActivity", ".MainActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到
        des.setCapability("noReset",true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms

//        Common cm = new Common();
//        driver.findElement(By.id("com.rongmeng.sports.screen:id/ed_password")).sendKeys("hugaolin2021");
        driver.findElement(By.xpath("//*[@text='开始']")).click();
        driver.findElement(By.xpath("//*[@text='双脚跳绳']")).click();
        for(int i=0; i<=5000; i++) {
            sleep(4000);
            driver.findElement(By.xpath("//*[@text='开始锻炼']")).click();
            driver.findElement(By.xpath("//*[@text='开始']")).click();
            sleep(6000);
        }
    }

}