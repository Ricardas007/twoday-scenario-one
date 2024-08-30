package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.AddProductToCartCheckQuantity;
import lt.twoday.task.NavigateToHoodiesAndSweaters;
import lt.twoday.task.SelectFrankieSizeColourQuantity;
import lt.twoday.task.SelectFrankieSweatshirt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class AddProductToCartCheckQuantityTest extends BaseTest{

    @Description("Add product to cart and check that cart icon is updated with product quantity.")
    @ParameterizedTest
    @ValueSource(strings = {"4"})

    public void AddSelectedProductToCartCheckIsIconIsUpdated(String quantity) {
        NavigateToHoodiesAndSweaters navigate = new NavigateToHoodiesAndSweaters(driver);
        navigate.selectMensHoodiesAndSweatShirts();
        navigate.mensHoodiesAndSweatshirtsName();

        SelectFrankieSweatshirt select = new SelectFrankieSweatshirt(driver);
        select.slectFrankieSweatshirt();

        SelectFrankieSizeColourQuantity sizeColorQuantity = new SelectFrankieSizeColourQuantity(driver);
        sizeColorQuantity.selectSize();
        sizeColorQuantity.selectColor();
        sizeColorQuantity.selectQuantity(quantity);

        AddProductToCartCheckQuantity cartQuantity = new AddProductToCartCheckQuantity(driver);
        cartQuantity.addProductToCart();
        cartQuantity.waitForActualQuantityApearInCart(quantity);

        cartQuantity.getCartQuantity();
        String cartQuantityIcon = cartQuantity.getCartQuantity();
        Assertions.assertEquals(quantity, cartQuantityIcon, "Cart quantity should match with products in cart");

    }
}
