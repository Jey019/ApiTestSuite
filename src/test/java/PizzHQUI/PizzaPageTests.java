package PizzHQUI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PizzaPageTests extends BasePage {

    @Test
    public void LoginTest(){
        var menu = new Menu(driver);
        menu.navigateToLogin();

        var login = new LoginPage(driver);
        login.setUserName("bob");
        login.setPassword("ilovepizza");
        login.clickLoginButton();
        login.clickUserProfileSignIn();
        var heading = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals(heading.substring(7,18), "Welcome bob");
    }
}
