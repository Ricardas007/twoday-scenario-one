package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OpenCartAndCheckProductSameAsYouAddedToCartTest extends BaseTest{

    @Description("Open cart and check if product match the one You added to the cart.")
    @ParameterizedTest
    @ValueSource(strings = {"4"})

    public void OpenCartAndCheckProductMatchYourAddedToCart(String quantity) {
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
        String productNameInCart = openCart.chechIsCorrectProductAddedToCart();
        Assertions.assertEquals("Frankie Sweatshirt", productNameInCart, "Selected product by user and added to cart should match");
    }
}
