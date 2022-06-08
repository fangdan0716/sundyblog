import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.internal.thread.IThreadFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class swim200Meter {
   public  static final Logger LOGGER= LoggerFactory.getLogger("swim200Meter");
    //起点设备
    public static AndroidDriver driverInfo_Start() throws InterruptedException, MalformedURLException {
        LOGGER.info("driverInfo_Start:调用DriverInfo类");
        DriverInfo driverInfo = new DriverInfo();
        String platformName="Android",platformVersion="10",deviceName="A7YFBB1510000890",//VNX9X20420K00639
                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
        LOGGER.info("driverInfo_Start:返回AndroidDriver");
        return driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
    }
    //起点区域设置
    public static void setUp_Start(String sportsName ) throws MalformedURLException, InterruptedException{
        LOGGER.info("changeProj:调用Common类");
        Common cm = new Common ();
        LOGGER.info("changeProj:swim200Meter的driverInfo_Start");
        AndroidDriver driver = swim200Meter.driverInfo_Start();

        //AndroidDriver s1 = swim200Meter.driverInfo_finish();
        //String sportsName = "游泳200米";
        String nextname = "下一步";
        String save = "保存设置";
        String The_roll = "起点";
        String throwing = "终点";
        LOGGER.info("项目首次登录");
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/ed_account")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_account")).sendKeys ("fangdan");
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_password")).sendKeys ("dabai521");
            driver.hideKeyboard ();
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_login")).click ();
            LOGGER.info("条件：当前项目未选择任何项目，更换项目为游泳200米");
            for(int i =0;i<=6;i++){
                cm.SwipeLeft(driver);//滑动向左
            }
            LOGGER.info("找到项目点击");
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();
            LOGGER.info("点击下一步");
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            LOGGER.info("进入设置");
            Thread.sleep(1000);
            Boolean deviceLoc =driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).getText().equals("起点");
            if(deviceLoc=true){
                Thread.sleep(1000);
                //driver.findElement(By.id("com.rongmeng.sports.screen:id/text_left")).click();//设备总数
                LOGGER.info("点击泳道长度");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/right_text")).click();
                LOGGER.info("选择50");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/text_tv")).click();
                LOGGER.info("下一步");
                driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
                LOGGER.info("保存");
                driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
            }else {
                LOGGER.info("设备位置切换到起点");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).click();

            }

     //}
//        else if (driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).isEnabled()==false){
//
//            LOGGER.info("条件：登录后未选择任何项目，更换项目为游泳200米");
//            for(int i =0;i<=6;i++){
//                cm.SwipeLeft(driver);//滑动向左
//            }
//            LOGGER.info("找到项目点击");
//            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();
//            LOGGER.info("点击下一步");
//            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
//            LOGGER.info("进入设置");
//            Thread.sleep(1000);
//            Boolean deviceLoc =driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).getText().equals("起点");
//            if(deviceLoc=true){
//                Thread.sleep(1000);
//                //driver.findElement(By.id("com.rongmeng.sports.screen:id/text_left")).click();//设备总数
//                LOGGER.info("点击泳道长度");
//                driver.findElement(By.id("com.rongmeng.sports.screen:id/right_text")).click();
//                LOGGER.info("选择50");
//                driver.findElement(By.id("com.rongmeng.sports.screen:id/text_tv")).click();
//                LOGGER.info("下一步");
//                driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
//                LOGGER.info("保存");
//                driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
//            }else {
//                LOGGER.info("设备位置切换到起点");
//                driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).click();
//
//            }

        } else if(driver.getPageSource ().contains (The_roll) == false){
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_change_model")).click ();//项目选择
            //
            LOGGER.info("条件：当前项目为仰卧起坐，更换项目为游泳200米");
            for(int i =0;i<6;i++){
                cm.SwipeLeft(driver);//滑动向左
            }
            LOGGER.info("找到项目点击");
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();
            LOGGER.info("点击下一步");
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            LOGGER.info("进入设置");
            //driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            //driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).getText()
            Thread.sleep(1000);
            Boolean deviceLoc =driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).getText().equals("起点");
            if(deviceLoc=true){
                Thread.sleep(1000);
                //driver.findElement(By.id("com.rongmeng.sports.screen:id/text_left")).click();//设备总数
                LOGGER.info("点击泳道长度");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/right_text")).click();
                LOGGER.info("选择50");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/text_tv")).click();
                LOGGER.info("下一步");
                driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
                LOGGER.info("保存");
                driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存
            }else {
                LOGGER.info("设备位置切换到起点");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).click();

            }



        }

    }
    //终点设备
    public static AndroidDriver driverInfo_finish() throws InterruptedException, MalformedURLException {
        DriverInfo driverInfo = new DriverInfo();
        String platformName="Android",platformVersion="10",deviceName="A7YFBB1517001130",
                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
        return driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
    }
    //终点设置
    public static void setUp_finish(String sportsName ) throws InterruptedException, MalformedURLException {
        LOGGER.info("changeProj:调用Common类");
        Common cm = new Common ();
        LOGGER.info("changeProj:swim200Meter的driverInfo_finish");
        AndroidDriver driver = swim200Meter.driverInfo_finish();
        String nextname = "下一步";
        String save = "保存设置";
        String The_roll = "起点";
        String throwing = "终点";
        LOGGER.info("项目首次登录");
        if (driver.getPageSource ().contains ("com.rongmeng.sports.screen:id/ed_account")) {
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_account")).sendKeys ("fangdan");
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ed_password")).sendKeys ("dabai521");
            driver.hideKeyboard ();
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/btn_login")).click ();
            cm.SwipeLeft (driver);//滑动向左
            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();//实心球
            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + nextname + "\"]")).click ();//下一步
            driver.findElement (By.xpath ("//*[@text=\"" + save + "\"]")).click ();//保存

        }
//        else if (driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).isEnabled()==false){
//
//            LOGGER.info("条件：登录后未选择任何项目，更换项目为游泳200米");
//            for(int i =0;i<=6;i++){
//                cm.SwipeLeft(driver);//滑动向左
//            }
//            LOGGER.info("找到项目点击");
//            driver.findElement (By.xpath ("//*[@text=\"" + sportsName + "\"]")).click ();
//            LOGGER.info("点击下一步");
//            driver.findElement (By.id ("com.rongmeng.sports.screen:id/ql_next")).click ();//下一步
//            LOGGER.info("进入设置");
//            Thread.sleep(1000);
//            Boolean deviceLoc =driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).getText().equals("起点");
//            if (deviceLoc=true) {
//                Thread.sleep(1000);
//                LOGGER.info("设备位置切换到终点");
//                driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).click();
//                LOGGER.info("保存设置");
//                //com.rongmeng.sports.screen:id/tv_save
//                driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//保存
//            }else {
//                driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//保存
//            }
//
//        }
        else if(driver.getPageSource ().contains (The_roll) == false) {
            driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();//设置
            driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_change_model")).click();//项目选择
            //
            LOGGER.info("条件：当前项目为仰卧起坐，更换项目为游泳200米");
            for (int i = 0; i < 6; i++) {
                cm.SwipeLeft(driver);//滑动向左
            }
            LOGGER.info("找到项目点击");
            driver.findElement(By.xpath("//*[@text=\"" + sportsName + "\"]")).click();
            LOGGER.info("点击下一步");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();//下一步
            LOGGER.info("进入设置");
            //driver.findElement (By.id ("com.rongmeng.sports.screen:id/iv_setting")).click ();//设置
            //driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).getText()
            Thread.sleep(1000);
            Boolean deviceLoc =driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).getText().equals("起点");
            if (deviceLoc=true) {
                Thread.sleep(1000);
                LOGGER.info("设备位置切换到终点");
                driver.findElement(By.id("com.rongmeng.sports.screen:id/set_check_tv")).click();
//                LOGGER.info("识别道次");
//                driver.findElement(By.id("com.rongmeng.sports.screen:id/text_tv")).click();
//                LOGGER.info("开始泳道");
//                driver.findElement(By.id("com.rongmeng.sports.screen:id/text_tv")).click();
                LOGGER.info("保存设置");
                //com.rongmeng.sports.screen:id/tv_save
                driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//保存
            }else {
                driver.findElement(By.xpath("//*[@text=\"" + save + "\"]")).click();//保存
            }
        }


    }
    //配对
    public static void device_match() throws MalformedURLException, InterruptedException {
        //com.rongmeng.sports.screen:id/btn_go              device_match
        LOGGER.info("changeProj:swim200Meter的device_match【配对】开始执行");
        LOGGER.info("changeProj:swim200Meter的driverInfo_Start");
        AndroidDriver driver_start = swim200Meter.driverInfo_Start();
        LOGGER.info("起点点击go 开始测试");
        driver_start.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
        LOGGER.info("获取起点配对码");
        String match_code = driver_start.findElement (By.id ("com.rongmeng.sports.screen:id/tv_code")).getText ();
        Thread.sleep(5000);

        LOGGER.info("changeProj:swim200Meter的driverInfo_finish");
        AndroidDriver driver_finish = swim200Meter.driverInfo_finish();
        LOGGER.info("终点点击go 开始测试");
        driver_finish.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
        LOGGER.info("终点输入配对码");
        Thread.sleep (500);
        if (driver_finish.getPageSource ().contains ("com.rongmeng.sports.screen:id/et_input")) {
            //填充配对码
            driver_finish.findElement (By.id ("com.rongmeng.sports.screen:id/et_input")).sendKeys (match_code);
            //点击确定
            driver_finish.findElement (By.id ("com.rongmeng.sports.screen:id/btn_confirm")).click ();
        }
        Thread.sleep (200);
        LOGGER.info("p配对成功，点击开始测试");
        driver_start.findElement (By.id ("com.rongmeng.sports.screen:id/start_test")).click ();
        while (true) {
            // driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            //显示等待
            try {
                WebDriverWait wait = new WebDriverWait (driver_start, 1);
                wait.until (ExpectedConditions.presenceOfElementLocated (By.id ("com.rongmeng.sports.screen:id/tv_start")));
            }catch (NoSuchElementException e){
                return ;
            }

            Thread.sleep (15000);
            driver_start.findElement (By.id ("com.rongmeng.sports.screen:id/tv_start")).click ();
            Thread.sleep(5000);
            try {
                new WebDriverWait(driver_start,10).until(ExpectedConditions.presenceOfElementLocated(By.id("com.rongmeng.sports.screen:id/tv_time")));

            }catch (NoSuchElementException e){
                return ;

            }

            //打开后端网址
            // s.webdemo1 ();
        }



    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        String sportname="游泳200米";
//        swim200Meter.setUp_Start(sportname);//A7YFBB1522000135
//
//        swim200Meter.setUp_finish(sportname);
        swim200Meter.device_match();

    }
 }
