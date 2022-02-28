import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test3 {
    private static AndroidDriver task1() throws MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "10");//手机操作系统版本
        des.setCapability("deviceName", "VNX9X20420K00634");//使用的手机类型或模拟器类型  UDID
        des.setCapability("udid","VNX9X20420K00634");
        des.setCapability("appPackage", "com.rongmeng.sports.screen");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability("appActivity", "com.rongmeng.sports.screen.ui.start.StartActivity");//app测试人员常常要获取activity，进行相关测试,后续会讲到
        des.setCapability("noReset",true);
        des.setCapability("automationName","uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;
    }

    private static AndroidDriver task2() throws MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "10");//手机操作系统版本
        des.setCapability("deviceName", "VNX9X20420K00723");//使用的手机类型或模拟器类型  UDID
        des.setCapability("udid","VNX9X20420K00723");
        des.setCapability("appPackage", "com.huawei.filemanager");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability("appActivity", "com.huawei.hidisk.filemanager.FileManager");//app测试人员常常要获取activity，进行相关测试,后续会讲到
        des.setCapability("waitForIdleTimeout",100);
        des.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        des.setCapability("noReset",true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址a
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;
    }
    @Test
    public void testDemo1() throws MalformedURLException, InterruptedException {
//    public static void main(String[] args) throws IOException, InterruptedException {
        AndroidDriver driver1 = task1();
        AndroidDriver driver2 = task2();

        Common cm = new Common();
        if (driver1.getPageSource().contains("com.rongmeng.sports.screen:id/ed_account")) {
            driver1.findElement(By.id("com.rongmeng.sports.screen:id/ed_account")).sendKeys("hugaolin");
            driver1.findElement(By.id("com.rongmeng.sports.screen:id/ed_password")).sendKeys("hugaolin2021");
            driver1.hideKeyboard();
            driver1.findElement(By.id("com.rongmeng.sports.screen:id/btn_login")).click();
        }
        String sportsName="立定跳远";
//        while(cm.byElementIsExist(driver1,By.xpath("//*[@text=\"" + sportsName + "\"]"))==false){
        while(driver1.getPageSource().contains(sportsName)==false){
            cm.SwipeLeft(driver1);
        };
        driver1.findElement(By.xpath("//*[@text=\""+ sportsName +"\"]")).click();
        if(driver1.getPageSource().contains("com.rongmeng.sports.screen:id/ql_next")){
            driver1.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();
        }
        String okBtn_xpath = "(//*[contains(@text,'允许')])[2]";
        while(cm.byElementIsExist(driver1,By.xpath(okBtn_xpath))){
            driver1.findElement(By.xpath(okBtn_xpath)).click();
        }
        driver1.findElement(By.id("com.rongmeng.sports.screen:id/ct_model")).click();
        if(driver1.findElement(By.xpath("(//*[@text=\"游客模式\"]/following-sibling::*)[2]")).getText().equals("关闭")){
            driver1.findElement(By.xpath("(//*[@text=\"游客模式\"]/following-sibling::*)[1]")).click();
        }
//        WebElement privacyOKBtn = driver2.findElementByAndroidUIAutomator("new UiSelector().text(\"同意\")");
//        if(privacyOKBtn.isDisplayed()){
//            privacyOKBtn.click();
//        }
        driver2.findElement(By.xpath("//*[@text=\"视频\"]")).click();
        driver2.findElement(By.xpath("//*[@text=\"所有视频\"]/parent::*/parent::*")).click();
        driver2.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"立定跳远.mp4.\"])[1]/parent::*/parent::*")).click();
        driver2.findElement(By.id("com.huawei.himovie:id/local_video_viewpager")).click();
//        driver2.findElement(By.id("com.huawei.himovie:id/play")).click();
        WebElement slider = driver2.findElement(By.id("com.huawei.himovie:id/speed_bar"));
        int xAxisStartPoint = slider.getLocation().getX();
        int xAxisEndPoint = xAxisStartPoint + slider.getSize().getWidth();
        int yAxis = slider.getLocation().getY();
        TouchAction act=new TouchAction(driver2);
        act.press(PointOption.point(xAxisStartPoint,yAxis)).moveTo(PointOption.point(0,yAxis)).release().perform();
//        driver2.findElement(By.id("com.huawei.himovie:id/play")).click();
        Thread.sleep(8000);
        WebDriverWait wait1 = new WebDriverWait(driver1,10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"请去起跳区域站好\"]")));
        WebDriverWait wait2 = new WebDriverWait(driver1,10);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("com.rongmeng.sports.screen:id/dw_tv")));
        //判断头像和语音;
        String distanceId = "com.rongmeng.sports.screen:id/time_tv";
        String unitId = "com.rongmeng.sports.screen:id/dw_tv";
        String nextLinkId = "com.rongmeng.sports.screen:id/start_tv_next_group";
        Assert.assertTrue(Integer.parseInt(driver1.findElementById(distanceId).getText())>=190);
        Assert.assertEquals(driver1.findElementById(unitId).getText(),"cm");
        Assert.assertTrue(driver1.findElementById(nextLinkId).isDisplayed());
    }


}