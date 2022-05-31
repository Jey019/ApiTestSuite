package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FormsPage {
    private final WebDriver driver;

    public FormsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name){
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public String getName(){
        return driver.findElement(By.id("name")).getText();
    }

    public void setEmail(String email){
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public String getEmail(){
        return driver.findElement(By.name("email")).getText();
    }

    public void setState(String state){
        driver.findElement(By.id("state")).sendKeys(state);
    }

    public void clickAgree(){
        driver.findElement(By.className("v-input--selection-controls__ripple")).click();
    }

    public String getPopupMessageText(){
        WebElement popup = driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver, 10).until(d -> popup.isDisplayed());
        return popup.getText();
    }

    public String getErrorName(){
        return driver.findElement(By.id("name-err")).getText();
    }

    public String getErrorEmail(){
        return driver.findElement(By.id("email-err")).getText();
    }

    public String getErrorAgree(){
        return driver.findElement(By.id("agree-err")).getText();
    }
    public void clickSubmitButton(){
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

    }

}
