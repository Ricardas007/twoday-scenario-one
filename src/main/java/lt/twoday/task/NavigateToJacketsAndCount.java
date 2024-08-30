package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NavigateToJacketsAndCount extends BasePage{

    @FindBy(id = "ui-id-5")
    WebElement hoverOverMensMeniu;

    @FindBy (partialLinkText = "Tops")
    WebElement navigateToTops;

    @FindBy (id = "ui-id-19")
    WebElement navigateToJackets;

    @FindBy (className = "toolbar-number")
    WebElement numberOfProductsDisplayedOnPage;

    @FindBy (xpath = "//div[@class='product-item-info']")
    List<WebElement> listedProductOnPage;

    public NavigateToJacketsAndCount(WebDriver driver) {
        super(driver);
    }


    public void selectMensJackets() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMensMeniu).perform();
        actions.moveToElement(navigateToTops).moveToElement(navigateToJackets).perform();
        actions.click().build().perform();
    }

    public String numberJacketsDisplayed() {
        String numberOfProducts = numberOfProductsDisplayedOnPage.getText();
        return numberOfProducts;
    }

    public int numberOfJacketsCounted() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='product-item-info']")));
        int numberOfProductsOnPage = listedProductOnPage.size();
        return numberOfProductsOnPage;
    }

}
