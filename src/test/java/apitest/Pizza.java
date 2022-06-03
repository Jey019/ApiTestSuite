package apitest;

import com.sun.xml.bind.v2.WellKnownNamespace;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Pizza {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\4358\\ChromeDriver102\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://d3udduv23dv8b4.cloudfront.net/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

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


        WebElement itemfound1 = null;
        List<WebElement> login1 = driver.findElements(By.tagName("a"));
        for (WebElement a: login1)
        {
            if (a.getText().equalsIgnoreCase("person")){
                itemfound1 = a;
                break;
            }
        }
        if (itemfound1 == null) { throw (new NotFoundException()); }
        itemfound1.click();

        var heading = driver.findElement(By.tagName("h2")).getText();

        Assertions.assertEquals(heading, "person Welcome bob");

    }

    }


