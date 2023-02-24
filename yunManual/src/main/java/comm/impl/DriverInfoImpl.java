package comm.impl;

import comm.DriverInfo;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverInfoImpl implements DriverInfo  {
    @Override
    public AndroidDriver DriverInfo(String platformName, String platformVersion, String deviceName, String appPackage, String appActivity) throws MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities ();
        AndroidDriver driver;
        des.setCapability ("platformName", platformName);//平台名称
        des.setCapability ("platformVersion",platformVersion);//手机操作系统版本
        des.setCapability ("deviceName", deviceName);//使用的手机类型或模拟器类型  UDID
        des.setCapability ("udid", deviceName);
        des.setCapability ("appPackage", appPackage);//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability ("appActivity", appActivity);//注意更换app测试人员常常要获取activity
        des.setCapability ("noReset", true);
//    des.setCapability("waitForIdleTimeout",100)
//  des.setCapability ("automationName", "uiautomator2");
        driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        //driver = new AndroidDriver (new URL("http://localhost:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);//设置超时等待时间,默认250ms
        return driver;
    }
}
