package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductToCartCheckQuantity extends BasePage{

    @FindBy (css = "#product-addtocart-button span")
    WebElement pressAddToCartButton;

    @FindBy(css = "span.counter-number")
    WebElement cartIcon;

    public AddProductToCartCheckQuantity(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        pressAddToCartButton.click();
    }

    public String getCartQuantity() {
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        return cartIcon.getText().trim();
    }

    public void waitForActualQuantityApearInCart(String quantity) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.counter-number"), quantity));
    }

}
