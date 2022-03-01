import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static com.sun.deploy.trace.Trace.flush;

public class sjn {


    public static WebDriver webdemo1(String ss) throws InterruptedException {
        WebDriver driver = new ChromeDriver ();
        flush ();
        //打开网页
        driver.get ("http://yuntiyu-test.dream-sports.cn/#/login?redirect=%2FstudentManage");
        String title = driver.getTitle ();
        System.out.printf (title);
         driver.manage ().window ().maximize ();
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/ul/li[2]")).click ();
////*[@id="app"]/div/div[2]/div/form/ul/li[2]
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/div[1]/div/div/input")).sendKeys ("hugaolin");
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/div[2]/div/div/input")).sendKeys ("dabai521");
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/button")).click ();
        Thread.sleep (10000);
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/section/main/div/center[1]/div/div[1]/div/div/div[1]")).click ();
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/section/main/div/div/div/div[1]/div/ul/div[7]/a/li")).click ();
        while (true){
            Thread.sleep (60000);
            driver.navigate ().refresh ();

        }
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver ();
        driver.get ("http://yuntiyu-test.dream-sports.cn/#/login?redirect=%2FstudentManage");
        String title = driver.getTitle ();
        System.out.printf (title);
        driver.manage ().window ().maximize ();
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/ul/li[2]")).click ();
//*[@id="app"]/div/div[2]/div/form/ul/li[2]
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/div[1]/div/div/input")).sendKeys ("hugaolin");
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/div[2]/div/div/input")).sendKeys ("dabai521");
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/div[2]/div/form/button")).click ();
        Thread.sleep (10000);
        driver.findElement (By.xpath ("//*[@id=\"app\"]/div/section/main/div/center[1]/div/div[1]/div/div/div[1]")).click ();
        Thread.sleep (3000);
        driver.close();

    }


}
