import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTest {
    @Test
    public void testFirst() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/Yelena/Downloads/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        Thread.sleep(3000);

        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        driver.close();
        driver.quit();
    }
    @Test
    public void testVerify() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/Yelena/Downloads/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";


        System.setProperty( chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String actualResult = driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        driver.close();
        driver.quit();
    }
}

