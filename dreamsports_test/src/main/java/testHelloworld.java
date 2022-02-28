import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testHelloworld {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
    }
     }

