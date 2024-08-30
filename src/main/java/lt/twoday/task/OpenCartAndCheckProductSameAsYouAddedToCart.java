package lt.twoday.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenCartAndCheckProductSameAsYouAddedToCart extends BasePage{

    @FindBy(css = ".minicart-wrapper > .action.showcart")
    WebElement cartIcon;

    @FindBy (css = ".product-item-name > a")
    WebElement productNameInCart;

    public OpenCartAndCheckProductSameAsYouAddedToCart(WebDriver driver) {
        super(driver);
    }

    public void clickOnCartIcon() {
        wait.until(ExpectedConditions.visibilityOf(cartIcon)).click();
    }

    public String chechIsCorrectProductAddedToCart() {
        return productNameInCart.getText();
    }
}
