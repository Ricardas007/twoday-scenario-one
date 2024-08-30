package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.NavigateToHoodiesAndSweaters;
import lt.twoday.task.SelectFrankieSweatshirt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SelectFrankieSweatshirtTest extends BaseTest{

    @Description("Select “Frankie Sweatshirt” and open its details.")
    @ParameterizedTest
    @ValueSource(strings = {"Frankie Sweatshirt"})
    public void SelectFrankieSweatshirt(String sweatshirtName) {
        NavigateToHoodiesAndSweaters navigate = new NavigateToHoodiesAndSweaters(driver);
        navigate.selectMensHoodiesAndSweatShirts();
        navigate.mensHoodiesAndSweatshirtsName();
        SelectFrankieSweatshirt select = new SelectFrankieSweatshirt(driver);
        select.slectFrankieSweatshirt();
        String selectedProductName = select.getSelectedProductName();
        Assertions.assertEquals(sweatshirtName, selectedProductName, "Selected product name does not match.");
    }
}
