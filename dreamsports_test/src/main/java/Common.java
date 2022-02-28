
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

        import io.appium.java_client.TouchAction;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;


public class Common {
    // 上滑
    public void SwipeUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(width / 2, 100))
                .moveTo(PointOption.point(width / 2, height - 100)).release()
                .perform();
    }

    // 下滑
    public void SwipeDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height - 100))
                .moveTo(PointOption.point(width / 2, 100)).release().perform();
    }

    // 左滑
    public void SwipeLeft(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width-100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    public void SwipeRight(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }

    public boolean byElementIsExist(AndroidDriver driver,By by){
        try{
            driver.findElement(by);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
