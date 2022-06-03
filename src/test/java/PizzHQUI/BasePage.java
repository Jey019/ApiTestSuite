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
        public void startup(){
            driver.get("https://d3udduv23dv8b4.cloudfront.net/");
            driver.manage().window().maximize();

            WebElement itemfound = null;
            List<WebElement> login = driver.findElements(By.tagName("a"));
            for (WebElement a: login)
            {
                if (a.getText().equalsIgnoreCase("person")){
                    itemfound = a;
                    break;
                }
            }
            if (itemfound == null) { throw (new NotFoundException()); }
            itemfound.click();

            WebElement element = driver.findElement(By.name("gen-20220603-username"));
            element.sendKeys("bob");

            WebElement element1 = driver.findElement(By.name("gen-20220603-password"));
            element1.sendKeys("ilovepizza");


            WebElement btnfound = null;
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            for (WebElement btn : buttons)
            {
                if (btn.getText().equalsIgnoreCase("login"))
                {
                    btnfound = btn;
                    break;
                }


            }
            if (btnfound == null) { throw (new NotFoundException()); }
            btnfound.click();

        }
        @AfterAll
        public static void cleanup(){
            if (driver != null){
                driver.quit();
            }
        }
    }


