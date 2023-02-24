import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;

public class basketballFirst {
   public  static final Logger LOGGER= LoggerFactory.getLogger("basketballFirst");
    static DriverInfo driverInfo = new DriverInfo();
    static String platformName="Android";
    static String platformVersion="10";
    static String deviceName="A7YFBB1518002112";//VNX9X20420K00639
    static String appPackage="com.rongmeng.sports.screen";
    static  String appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
    static AndroidDriver driver;
    static {
        try {
            driver = driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
    }
    public static void basketballFirstSport(String sportsName) throws InterruptedException, MalformedURLException {

//com.rongmeng.sports.screen:id/tv_name
        //篮球一级
        //下一步
        ///com.rongmeng.sports.screen:id/tv_save
        //com.rongmeng.sports.screen:id/tv_save
        //保存设置
        //com.rongmeng.sports.screen:id/tv_save
        //服务设置
        //com.rongmeng.sports.screen:id/rb_service_info
        //人脸识别区域设置
        //com.rongmeng.sports.screen:id/sw_face_area
        //模式设置
        //com.rongmeng.sports.screen:id/ct_view

        //游客模式
        //com.rongmeng.sports.screen:id/switch1   [1032,919][1120,967]
        ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Switch
        //自动下一位
        ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.Switch
        //com.rongmeng.sports.screen:id/switch1   [1032,987][1120,1035]
        //切换到篮球一级
        LOGGER.info("changeProj:调用Common类");
        Common cm = new Common ();
        String nextname = "下一步";
        String The_roll = "起点";
        String save = "保存设置";
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

        }else if(driver.getPageSource ().contains (The_roll) == false) {
            driver.findElement(By.id("com.rongmeng.sports.screen:id/iv_setting")).click();//设置
            driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_change_model")).click();//项目选择
            //
            LOGGER.info("条件：当前项目为仰卧起坐，更换项目为篮球一级");
            for (int i = 0; i < 9; i++) {
                cm.SwipeLeft(driver);//滑动向左
            }
            LOGGER.info("找到项目点击");
            driver.findElement(By.xpath("//*[@text=\"" + sportsName + "\"]")).click();
            LOGGER.info("点击下一步");
            driver.findElement(By.id("com.rongmeng.sports.screen:id/ql_next")).click();//下一步
            LOGGER.info("进入设置");
            for(int i=0;i<3;i++) {
                driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_save")).click();
            }
        //当前是篮球一级，进入运动页
        driver.findElement(By.id("com.rongmeng.sports.screen:id/btn_go")).click();
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_start")).click();

        //Thread.sleep(1000);
        driver.findElement(By.id("com.rongmeng.sports.screen:id/tv_next")).click();

     }
    }
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        basketballFirstSport("篮球一级");

    }

}
