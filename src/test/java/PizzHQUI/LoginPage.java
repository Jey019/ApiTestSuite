package PizzHQUI;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUserProfile(){
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
    }

    public void setUserName(String name) {
        driver.findElement(By.id("gen-20220603-password")).sendKeys(name);
    }

    public String setUserName() {
        return driver.findElement(By.id("gen-20220603-password")).getText();
    }

    public void setPassword(String password){
        driver.findElement(By.id("gen-20220603-password")).sendKeys(password);
    }

    public void clickLoginButton(){
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
    public void clickUserProfileSignIn(){
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
    }
}
