package PizzHQUI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PizzaPageTests extends BasePage {

    @Test
    public void LoginTest(){
        var menu = new Tabs(driver);
        menu.navigateToLogin();

        var login = new LoginPage(driver);
        login.setUserName("bob");
        login.setPassword("ilovepizza");
        login.clickLoginButton();
        login.clickUserProfileSignIn();
        var heading = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals(heading.substring(7,18), "Welcome bob");
    }
    @Test
    public void OrderItem(){
        var menu = new Tabs(driver);
        menu.navigateToMenu();

        var pizza = new PizzaPage(driver);
        PizzaMenuPage item = pizza.findTileByNameToClickOrder("Espresso Thickshake");
        item.clickOrder();
        item.yourOrderNavigationMenu();
        Assertions.assertEquals("4.99", item.getTotal());
    }

}
