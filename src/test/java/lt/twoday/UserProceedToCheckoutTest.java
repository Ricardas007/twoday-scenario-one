package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserProceedToCheckoutTest extends BaseTest{

    @Description("When user add products to cart he proceed to checkout")
    @ParameterizedTest
    @ValueSource(strings = {"4"})

    public void UserProceedToCheckout(String quantity) {
        NavigateToHoodiesAndSweaters navigate = new NavigateToHoodiesAndSweaters(driver);
        navigate.selectMensHoodiesAndSweatShirts();
        navigate.mensHoodiesAndSweatshirtsName();

        SelectFrankieSweatshirt select = new SelectFrankieSweatshirt(driver);
        select.slectFrankieSweatshirt();

        SelectFrankieSizeColourQuantity sizeColorQuantity = new SelectFrankieSizeColourQuantity(driver);
        sizeColorQuantity.selectSize();
        sizeColorQuantity.selectColor();
        sizeColorQuantity.selectQuantity(quantity);

        AddProductToCartCheckQuantity cartQnt = new AddProductToCartCheckQuantity(driver);
        cartQnt.addProductToCart();
        cartQnt.waitForActualQuantityApearInCart(quantity);
        OpenCartAndCheckProductSameAsYouAddedToCart openCart = new OpenCartAndCheckProductSameAsYouAddedToCart(driver);
        openCart.clickOnCartIcon();

        UserProceedToCheckout checkout = new UserProceedToCheckout(driver);
        checkout.pressCheckoutButton();
        String sectionLabel = checkout.checkIsUserLandedOnCheckoutPage();
        Assertions.assertEquals("Shipping Address", sectionLabel, "When user navigate to checkout it should land on checkout page with title 'Shipping Address'");
    }
}
