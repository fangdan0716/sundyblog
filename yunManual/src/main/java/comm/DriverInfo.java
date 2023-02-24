package comm;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public interface DriverInfo {
    AndroidDriver DriverInfo(String platformName, String platformVersion,
                             String deviceName, String appPackage, String appActivity) throws MalformedURLException;
}
