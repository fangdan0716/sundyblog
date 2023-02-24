import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public class Settings {
    public  static final Logger LOGGER= LoggerFactory.getLogger("basketballFirst");
//    static DriverInfo driverInfo = new DriverInfo();
//    static String platformName="Android";
//    static String platformVersion="10";
//    static String deviceName="A7YFBB1518002112";//VNX9X20420K00639
//    static String appPackage="com.rongmeng.sports.screen";
//    static  String appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
//    static AndroidDriver driver;
//
//    static {
//        try {
//            driver = driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

    public Settings(AndroidDriver driver) throws MalformedURLException, InterruptedException {
        driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
    }
    //切换到wifi摄像头
    public static void settingsCameraWifi(AndroidDriver driver) throws InterruptedException, MalformedURLException {
        //com.rongmeng.sports.screen:id/iv_setting
        LOGGER.info("点击设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
        LOGGER.info("点击摄像头管理");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_camera_info")).click();
        if(driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_wifi")).isSelected()==false){
            LOGGER.info("点击WIFI");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_wifi")).click();
        }else{
            LOGGER.info("当前已在wifi-tab下");
        }
    }
//添加wifi摄像头
    public static void settingsCameraWifiAdd(AndroidDriver driver,String ip) throws InterruptedException, MalformedURLException {
        //
        LOGGER.info("调用settingsCameraWifi方法");
        settingsCameraWifi(driver);
        LOGGER.info("点击添加摄像头");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_camera_add")).click();
        LOGGER.info("输入ip");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/et_address")).sendKeys(ip);
        LOGGER.info("点击确定");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_confirm")).click();
    }
    //删除wifi摄像头
//    type 取消或删除
    public static void settingsCameraWifidelete(AndroidDriver driver,Boolean type) throws InterruptedException, MalformedURLException {
        LOGGER.info("调用settingsCameraWifi方法");
        settingsCameraWifi(driver);
        boolean del = driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_del")).isEnabled();
        if(del=true){
            driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_del")).click();
            if(driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_del_false")).isEnabled()==type){
                //删除摄像头弹窗-取消
                driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_del_false")).click();

            }else if (driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_del_true")).isEnabled()==type){
                //删除摄像头弹窗-确定
                driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_del_false")).click();
            }else {
                //关闭删除摄像头弹窗
                driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_del_close")).click();
            }
        }

    }
    //
    public static void settingsCameraWifiupdate(AndroidDriver driver,String ip) throws InterruptedException, MalformedURLException {
        LOGGER.info("调用settingsCameraWifi方法");
        settingsCameraWifi(driver);
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_modify")).click();
        driver.findElement(By.id("com.rongmeng.sports.screen:id/et_address")).sendKeys(ip);
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_confirm")).click();
    }

//切换到usb
    public static void settingsCameraUSB(AndroidDriver driver) throws InterruptedException, MalformedURLException {
        LOGGER.info("点击设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
        LOGGER.info("点击摄像头管理");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_camera_info")).click();
        LOGGER.info("点击USB");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_usb")).click();
    }
    //切换到本地
    public static void settingsCameraSelf(AndroidDriver driver) throws InterruptedException, MalformedURLException {
        LOGGER.info("点击设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
        LOGGER.info("点击摄像头管理");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_camera_info")).click();
        LOGGER.info("点击本地");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_local")).click();
    }
    //视频流地址设置
    public static void settingsVideoStream(AndroidDriver driver,String address,String port) throws InterruptedException, MalformedURLException {
        LOGGER.info("点击设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
        LOGGER.info("点击摄像头管理");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_camera_info")).click();
        Thread.sleep(100);

        LOGGER.info("点击视频流");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_rmtp")).click();
        Thread.sleep(100);
        LOGGER.info("添加摄像头");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_camera_add")).click();
        Thread.sleep(100);
        LOGGER.info("输入视频流地址");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/et_address")).sendKeys(address);
        Thread.sleep(100);
        LOGGER.info("输入视频流读取间的毫秒数");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/et_port")).sendKeys(port);
        LOGGER.info("确定");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_confirm")).click();

    }

//服务设置
    public static void settingsServiceInfo(AndroidDriver driver) throws InterruptedException, MalformedURLException {
        LOGGER.info("点击设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
        LOGGER.info("点击服务设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_service_info")).click();
    }
    /*
    画面镜像：com.rongmeng.sports.screen:id/sw_animation
    设置加密：com.rongmeng.sports.screen:id/sw_password
    人脸识别区域设置：com.rongmeng.sports.screen:id/sw_face_area
    测试服务模式：com.rongmeng.sports.screen:id/sw_test_service
    本地视频录制：com.rongmeng.sports.screen:id/sw_video_local
    录像机视频录制：com.rongmeng.sports.screen:id/sw_video_record
    跑圈手动打卡：com.rongmeng.sports.screen:id/sw_run_manual
    人脸识别模式：com.rongmeng.sports.screen:id/tv_face_update
                com.rongmeng.sports.screen:id/rb_cloud
                com.rongmeng.sports.screen:id/rb_local
                com.rongmeng.sports.screen:id/tv_true
    录像机通讯地址：com.rongmeng.sports.screen:id/tv_video_address
                 com.rongmeng.sports.screen:id/et_address_video
                com.rongmeng.sports.screen:id/tv_score_confirm
     */
    public static void settingsServiceInfoSwitch(AndroidDriver driver,String ele,String open) throws InterruptedException, MalformedURLException {
        settingsServiceInfo(driver);
        if(driver.findElement(By.id(ele)).getText()!=open){
            driver.findElement(By.id(ele)).click();
        }else {
            LOGGER.info(ele+"元素的状态为："+open);
        }
    }

    public static void settingsServiceInfoFaceUpdate(AndroidDriver driver,String ele) throws InterruptedException, MalformedURLException {
        settingsServiceInfo(driver);
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_face_update")).click();
        driver.findElement(By.id(ele)).click();
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_true")).click();

    }
    public static void settingsServiceInfoVideoAddress(AndroidDriver driver,String ip) throws InterruptedException, MalformedURLException {
        settingsServiceInfo(driver);
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_video_address")).click();
        driver.findElement(By.id("com.rongmeng.sports.screen:id/et_address_video")).sendKeys(ip);
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_score_confirm")).click();

    }
    //地址设置
    /*
    模型分析服务地址:com.rongmeng.sports.screen:id/tv_model_address_update
            内置：com.rongmeng.sports.screen:id/rb_inner
            本地:com.rongmeng.sports.screen:id/rb_service_local
            云端：com.rongmeng.sports.screen:id/rb_service_wifi
            自定义：com.rongmeng.sports.screen:id/rb_service_infomy
            确定：com.rongmeng.sports.screen:id/tv_true
     */
    //地址设置
    public static void settingsaAdressInfo(AndroidDriver driver) throws InterruptedException, MalformedURLException {
        LOGGER.info("点击设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();
        LOGGER.info("点击服务设置");
        driver.findElement(By.id("com.rongmeng.sports.screen:id/rb_address_info")).click();
    }
    //模型分析服务地址
    public static void settingsModelAdressUpdate(AndroidDriver driver,String ele,String model) throws InterruptedException, MalformedURLException {
        settingsaAdressInfo(driver);
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_model_address_update")).click();
        if(driver.findElement(By.id(ele)).getText()!=model){
            driver.findElement(By.id(ele)).click();
        }else {
            LOGGER.info(ele+"元素的状态为："+model);
        }
    }




//    public static void main(String[] args) throws InterruptedException, MalformedURLException{
//        String platformName="Android";
//        String platformVersion="10";
//        String deviceName="A7YFBB1628001082";//VNX9X20420K00639
//        String appPackage="com.rongmeng.sports.screen";
//         String appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
//        AndroidDriver driver= DriverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
//
//        settingsVideoStream(driver,"sdcard/1.mp4","30");
//    }
}
