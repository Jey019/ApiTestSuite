package PizzHQUI;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


    public class BasePage {
        protected static WebDriver driver;

        @BeforeAll
        public static void Setup() throws MalformedURLException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\4358\\ChromeDriver102\\chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        }

        @BeforeEach
        public void startup() {
            driver.get("https://d3udduv23dv8b4.cloudfront.net/");
            driver.manage().window().maximize();

        }
        @AfterAll
        public static void cleanup(){
            if (driver != null){
                driver.quit();
            }
        }
    }


