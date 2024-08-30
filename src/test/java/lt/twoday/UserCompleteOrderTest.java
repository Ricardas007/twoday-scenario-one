package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

public class UserCompleteOrderTest extends BaseTest{

    @Description("After user proceed to check out he should fill up personal info and complete order")
    @ParameterizedTest(name = "Test{index} => quantity{0}, e-mail{1}, firstname{2}, lastName{3}, address{4}, city{5}, country{6}, state{7}, zipCode{8}, phoneNumber{9}")
    @CsvFileSource(files = "src/main/resources/shipping_details.csv", numLinesToSkip = 1)

    public void UserCompleteOrder(ArgumentsAccessor arguments) throws InterruptedException {
        String quantity = arguments.getString(0);

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

        String customerEmail = arguments.getString(1);
        String customerFirstName = arguments.getString(2);
        String customerLastName = arguments.getString(3);
        String customerAddress = arguments.getString(4);
        String customerCity = arguments.getString(5);
        String customerCountry = arguments.getString(6);
        String customerState = arguments.getString(7);
        String customerZip = arguments.getString(8);
        String customerPhone = arguments.getString(9);

        UserCompleteOrder complete = new UserCompleteOrder(driver);

        complete.selectCountry(customerCountry);
        complete.selectState(customerState);
        complete.enterUserEmail(customerEmail);
        complete.enterUserFirstName(customerFirstName);
        complete.enterUserLastName(customerLastName);
        complete.enterUserAddress(customerAddress);
        complete.enterUserCity(customerCity);
        complete.enterUserStateZip(customerZip);
        complete.enterUserPhone(customerPhone);
        complete.clickNextButtonAfterShippingMethodLoads();
        complete.placeTheOrderAndFinish();
        String confirmationText = complete.proceedToFinalPageGetConfirmationText();
        Assertions.assertEquals("Thank you for your purchase!", confirmationText, "Did not get message : Thank you for your purchase!");
    }
}
