package UI;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTests extends BaseTestSuite {



    @Test
    public void FormsTests()
    {
        var menu = new Menu(driver);
        menu.navigateToFormsPage();

        var forms = new FormsPage(driver);
        forms.setName("Jay");
        forms.setEmail("jey.venkataramanan@accesshq.com");
        forms.setState("NSW");
        forms.clickAgree();
        forms.clickSubmitButton();
        Assertions.assertEquals("Thanks for your feedback Jay", forms.getPopupMessageText());

    }

    @Test
    public void ValidateFormTest()
    {
        var menu = new Menu(driver);
        menu.navigateToFormsPage();

        var forms = new FormsPage(driver);
        forms.clickSubmitButton();
        forms.getErrorName();

        forms.getErrorEmail();
        forms.getErrorAgree();

        Assertions.assertEquals("Your name is required", forms.getErrorName());
        Assertions.assertEquals("Your email is required", forms.getErrorEmail());
        Assertions.assertEquals("You must agree to continue", forms.getErrorAgree());
    }
    @Test
    public void DistanceToJupiterTest(){
        var menu = new Menu(driver);
        menu.navigateToPlanetsPage();

        var planets = new PlanetsPage(driver);
        var jupiter =  planets.findPlaneTileByName("Jupiter");
        Assertions.assertEquals("778,500,000 km", jupiter.getDistance());

    }


}
