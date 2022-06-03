package PizzHQUI;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class Menu {
    private WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLogin(){
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
}
