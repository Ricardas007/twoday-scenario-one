package lt.twoday.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserProceedToCheckout extends BasePage {

    @FindBy(css = "button#top-cart-btn-checkout")
    WebElement checkoutButton;

    @FindBy (css = "li#shipping > .step-title")
    WebElement shippingAddressLabel;

    public UserProceedToCheckout(WebDriver driver) {
        super(driver);
    }

    public void pressCheckoutButton() {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public String checkIsUserLandedOnCheckoutPage() {
        return wait.until(ExpectedConditions.visibilityOf(shippingAddressLabel)).getText();
    }
}
