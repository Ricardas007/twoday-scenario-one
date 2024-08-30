package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.NavigateToJacketsAndCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NavigateToJacketsAndCountDisplayedNumberTest extends BaseTest{

    @Description("Check/Assert that the displayed number of jackets matches the selected number of jackets displayed per page")
    @Test
    public void NavigateToJacketsAndCountNumberJacketsDisplayed() {

        NavigateToJacketsAndCount navigate = new NavigateToJacketsAndCount(driver);
        navigate.selectMensJackets();
        String numberOfProductsDisplayedOnPage = navigate.numberJacketsDisplayed();
        int numberDisplayed = Integer.parseInt(numberOfProductsDisplayedOnPage);
        int numberOfProductsCountedOnPage = navigate.numberOfJacketsCounted();
        Assertions.assertEquals(numberOfProductsCountedOnPage, numberDisplayed, "The number of products displayed in section should match the product count");
    }
}
