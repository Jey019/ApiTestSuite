package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetTile {

    private WebElement element;

    public PlanetTile(WebElement tile){
        this.element = tile;
    }
    public String getName(){
        return element.findElement(By.tagName("h2")).getText();

    }

    public String getDistance(){
        return element.findElement(By.className("distance")).getText();
    }
}
