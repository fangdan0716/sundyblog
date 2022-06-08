import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;

public class ChangeProj1 {
    public static final Logger LOGGER = LoggerFactory.getLogger("ChangeProj1");
    private static void changeProj(AndroidDriver driver, String sportsName) throws InterruptedException, MalformedURLException {
        //判断当前项目是否在首页
        if(driver.getPageSource().contains(sportsName)==false){
            LOGGER.info("当前项目与测试项目不一致，请更换项目");
            Common cm = new Common ();
            //判断当前项目是否在请选择项目页面
            if(driver.getPageSource().contains("请选择项目")) {
                LOGGER.info("当前页面在更换项目页");
                //有漏洞，所要选择的项目与当前项目很近，则无法选择
                try {
                    while (driver.getPageSource().contains(sportsName)==false){
                        cm.SwipeLeft(driver);//滑动向左
                    }
                }catch (NoSuchElementException e){
                    System.out.println(e);
                    //LOGGER.info(e);
                }
                LOGGER.info("找到项目点击");
                driver.findElement(By.xpath("//*[@text=\"" + sportsName + "\"]")).click();
                LOGGER.info("点击下一步");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();//下一步
                Thread.sleep(100);
                //判断当前页面是否是首页，如果不是则在设置区域页面
                if(driver.getPageSource().contains("设置区域")==true){
                   // com.rongmeng.sports.screen:id/tv_save
                    LOGGER.info("设置区域页面点击下一步");
                    driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_save")).click();//下一步
                    //判断当前页面是否为人脸区域设置页面
                    if(driver.getPageSource().contains("设置人脸区域")==true) {
                        LOGGER.info("设置人脸区域点击保存设置");
                        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_save")).click();
                    }
                }else {
                    LOGGER.info("当前项目区域已被设置过直接跳到首页，可点击go开始测试进入配对或运动页");
                }
            }else{
                //点击设置按钮，进入体测设置页面
                LOGGER.info("点击设置按钮，进入进入体测设置页面");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
                LOGGER.info("点击更换项目，进入请选择项目页面");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_change_model")).click();
                try {
                    while (driver.getPageSource().contains(sportsName)==false){
                        cm.SwipeLeft(driver);//滑动向左
                    }
                }catch (NoSuchElementException e){
                    System.out.println(e);
                    //LOGGER.info(e);
                }

                LOGGER.info("找到项目点击");
                driver.findElement(By.xpath("//*[@text=\"" + sportsName + "\"]")).click();
                LOGGER.info("点击下一步");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();//下一步
                Thread.sleep(100);
                System.out.println(driver.getPageSource().contains("设置区域"));
                //判断当前页面是否是首页，如果不是则在设置区域页面
                if(driver.getPageSource().contains("设置区域")==true){
                    // com.rongmeng.sports.screen:id/tv_save
                    LOGGER.info("设置区域页面点击下一步");
                    driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_save")).click();//下一步
                    //判断当前页面是否为人脸区域设置页面
                    if(driver.getPageSource().contains("设置人脸区域")==true) {
                        LOGGER.info("设置人脸区域点击保存设置");
                        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_save")).click();
                    }
                }else {
                    LOGGER.info("当前项目区域已被设置过直接跳到首页，可点击go开始测试进入配对或运动页");
                }
            }
        }else{
            LOGGER.info("当前项目与测试项目一致且当前页面在首页，可点击go开始测试进入配对或运动页");
        }



    }
//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        //DriverInfo driverInfo = new DriverInfo();
//        String platformName="Android",platformVersion="10",deviceName="A7YFBB1514000232",//VNX9X20420K00639
//                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
//        AndroidDriver driver=DriverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
//        changeProj(driver,"游泳200米");
//
//    }

}
