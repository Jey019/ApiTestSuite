package UI;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestSuite {
    protected static WebDriver driver;

    @BeforeAll
    public static void Setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\4358\\ChromeDriver102\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @BeforeEach
    public void startup(){
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }
    @AfterAll
    public static void cleanup(){
        if (driver != null){
            driver.quit();
        }
    }
}
