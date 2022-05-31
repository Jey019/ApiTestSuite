package apitest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTests {

    private static WebDriver driver;

    @BeforeAll
    public static void Setup(){
        driver = new ChromeDriver();

    }

    @BeforeEach
    public void Start()
    {
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
    }

    @Test
    public void FormsTests()
    {
        WebElement forms = driver.findElement(By.cssSelector("[aria-label='forms']"));
        forms.click();
        Assertions.assertEquals("https://d18u5zoaatmpxx.cloudfront.net/#/forms", driver.getCurrentUrl());
        WebElement id = driver.findElement(By.id("name"));
        id.sendKeys("Jay");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("jey.venkataramanan@accesshq.com");
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("NSW");
        WebElement agree = driver.findElement(By.className("v-input--selection-controls__ripple"));
        agree.click();
        WebElement btnfound = null;
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement btn : buttons)
        {
            if (btn.getText().equalsIgnoreCase("submit"))
            {
                btnfound = btn;
                break;
            }


        }
        if (btnfound == null) { throw (new NotFoundException()); }
        btnfound.click();

        WebElement popup = driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver, 10).until(d -> popup.isDisplayed());
        //WebElement popmessage = driver.findElement(By.cssSelector(".snackbar"));
        Assertions.assertEquals("Thanks for your feedback Jay", popup.getText());

    }


    @AfterAll
    public static void Quit(){
        if (driver !=null)
            driver.quit();

    }
}
