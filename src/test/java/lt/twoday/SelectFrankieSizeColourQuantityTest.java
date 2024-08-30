package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.NavigateToHoodiesAndSweaters;
import lt.twoday.task.SelectFrankieSizeColourQuantity;
import lt.twoday.task.SelectFrankieSweatshirt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SelectFrankieSizeColourQuantityTest extends BaseTest{

    @Description("Select size, colour and quantity.")
    @ParameterizedTest
    @ValueSource(strings = {"4"})

    public void ChooseFrankieSweatshirtAddSizeColourQuantity(String quantity) {
        NavigateToHoodiesAndSweaters navigate = new NavigateToHoodiesAndSweaters(driver);
        navigate.selectMensHoodiesAndSweatShirts();
        navigate.mensHoodiesAndSweatshirtsName();

        SelectFrankieSweatshirt select = new SelectFrankieSweatshirt(driver);
        select.slectFrankieSweatshirt();

        SelectFrankieSizeColourQuantity sizeColorQuantity = new SelectFrankieSizeColourQuantity(driver);
        sizeColorQuantity.selectSize();
        sizeColorQuantity.selectColor();
        sizeColorQuantity.selectQuantity(quantity);

        String selectedSize = sizeColorQuantity.getSelectedSize();
        Assertions.assertEquals("S", selectedSize,"Selected size should match");
        String selectedColor = sizeColorQuantity.getSelectedColor();
        Assertions.assertEquals("Yellow", selectedColor,"Selected color should match");
        String selectedQuantity = sizeColorQuantity.getSelectedQuantity();
        Assertions.assertEquals(quantity, selectedQuantity,"Selected quantity should match");
    }
}
