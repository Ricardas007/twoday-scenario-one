package lt.twoday.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFrankieSweatshirt extends BasePage{

    @FindBy(partialLinkText = "Frankie Sweatshirt")
    WebElement frankieSweatshirt;

    @FindBy (xpath = "//span[@class='base']")
    WebElement selectedProduct;

    public SelectFrankieSweatshirt(WebDriver driver) {
        super(driver);
    }

    public void slectFrankieSweatshirt() {
        frankieSweatshirt.click();
    }

    public String getSelectedProductName() {
        return selectedProduct.getText();
    }
}
