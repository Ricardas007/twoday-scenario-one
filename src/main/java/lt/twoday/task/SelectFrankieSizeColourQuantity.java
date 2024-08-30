package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SelectFrankieSizeColourQuantity extends BasePage{

    @FindBy(css = "[attribute-code='size'] [index='1']")
    WebElement selectSizeS;

    @FindBy (css = "[attribute-code='color'] [index='2']")
    WebElement selectColourYellow;

    @FindBy (css = "input#qty")
    WebElement selectQuantityFour;

    @FindBy (css = "[attribute-code='size'] span:nth-of-type(2)")
    WebElement selectedSize;

    @FindBy (css = "[attribute-code='color'] span:nth-of-type(2)")
    WebElement selectedColor;

    @FindBy (xpath = "/html//input[@id='qty']")
    WebElement selectedQuantity;


    public SelectFrankieSizeColourQuantity(WebDriver driver) {
        super(driver);
    }

    public void selectSize() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[attribute-code='size'] [index='1']")));
        selectSizeS.click();
    }

    public void selectColor() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[attribute-code='color'] [index='2']")));
        selectColourYellow.click();
    }

    public void selectQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input#qty"))).clear();
        selectQuantityFour.click();
        selectQuantityFour.clear();
        selectQuantityFour.sendKeys(quantity);
    }

    public String getSelectedSize() {
        return selectedSize.getText();
    }

    public String getSelectedColor() {
        return selectedColor.getText();
    }

    public String getSelectedQuantity() {
        return selectedQuantity.getAttribute("value");
    }
}
