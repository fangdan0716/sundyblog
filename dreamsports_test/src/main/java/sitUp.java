import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public class sitUp {
    public  static final Logger LOGGER= LoggerFactory.getLogger("sitUp");
    public static AndroidDriver driverInfo_SitUp() throws InterruptedException, MalformedURLException {
        LOGGER.info("driverInfo_SitUp---start");
        DriverInfo driverInfo = new DriverInfo();
        String platformName="Android",platformVersion="10",deviceName="A7YFBB1522000135",//VNX9X20420K00639
                appPackage="com.rongmeng.sports.screen",appActivity="com.dreamsport.sports.ui.activity.StartActivity" ;
        LOGGER.info("driverInfo_SitUp:返回AndroidDriver");
        return driverInfo.DriverInfo(platformName,platformVersion,deviceName,appPackage,appActivity);


    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException{
        sitUp.driverInfo_SitUp();
    }

}
