package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menu {
    private WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToFormsPage() {
        WebElement formMenu = driver.findElement(By.cssSelector("[aria-label=forms]"));
        formMenu.click();

    }

    public void navigateToPlanetsPage() {
        WebElement formMenu = driver.findElement(By.cssSelector("[aria-label=planets]"));
        formMenu.click();


    }
}
