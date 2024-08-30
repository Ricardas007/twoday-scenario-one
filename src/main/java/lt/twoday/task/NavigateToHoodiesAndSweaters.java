package lt.twoday.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigateToHoodiesAndSweaters extends BasePage{

    @FindBy(id = "ui-id-5")
    WebElement hoverOverMensMeniu;

    @FindBy (partialLinkText = "Tops")
    WebElement navigateToTops;

    @FindBy (id = "ui-id-20")
    WebElement navigateToHoodies;

    @FindBy (className = "base")
    WebElement hoodiesAndSweatshirtsSection;


    public NavigateToHoodiesAndSweaters(WebDriver driver) {
        super(driver);
    }

    public void selectMensHoodiesAndSweatShirts() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMensMeniu).perform();
        actions.moveToElement(navigateToTops).moveToElement(navigateToHoodies).perform();
        actions.click().build().perform();
    }

    public String mensHoodiesAndSweatshirtsName() {
        return hoodiesAndSweatshirtsSection.getText();
    }
}
