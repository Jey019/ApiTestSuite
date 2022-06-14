package PizzHQUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PizzaMenuPage {
    private WebElement element;

    public PizzaMenuPage(WebElement drink){
        this.element = drink;
    }
    public String getItemName(){
       return element.findElement(By.tagName("h3")).getText();
    }
    public void clickOrder(){
        element.findElement(By.tagName("button")).click();
    }
    public void yourOrderNavigationMenu(){
        element.findElement(By.cssSelector("[aria-label=your order]")).click();
    }
    public String getTotal(){
        return element.findElement(By.className("order-total display-1 mt-1")).getText();
    }
}
