package PizzHQUI;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class Tabs {
    private WebDriver driver;

    public Tabs(WebDriver driver) {
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

    public void navigateToMenu(){
        WebElement fndmenu = null;
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for (WebElement currentelement : elements)
        {
            if (currentelement.getText().equalsIgnoreCase("menu")){
                fndmenu = currentelement;
                break;
            }
        }
        if (fndmenu == null){ throw (new NotFoundException());}
        fndmenu.click();
    }
}
