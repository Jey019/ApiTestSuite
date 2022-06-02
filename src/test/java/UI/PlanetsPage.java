package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanetsPage {

    private WebDriver driver;

    public PlanetsPage(WebDriver driver){
        this.driver = driver;
    }

    public PlanetTile findPlaneTileByName(String name){
        var tiles = driver.findElements(By.className("planet"));
        for (WebElement tile : tiles){
            var currentPlanet = new PlanetTile(tile);
            if (currentPlanet.getName().equalsIgnoreCase(name)){
                return currentPlanet;
            }
        }
        return null;
    }
}
