package lt.twoday;

import jdk.jfr.Description;
import lt.twoday.task.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class NavigateToHoodiesAndSweatersTest extends BaseTest {

    @Description("Using navigation menu, find mens Hoodies & Sweatshirts section.")
    @Test
    public void UserNavigateToHoodiesAndSweatshirts() {

        NavigateToHoodiesAndSweaters navigate = new NavigateToHoodiesAndSweaters(driver);
        navigate.selectMensHoodiesAndSweatShirts();
        navigate.mensHoodiesAndSweatshirtsName();
        String sectionName = navigate.mensHoodiesAndSweatshirtsName();
        Assertions.assertEquals("Hoodies & Sweatshirts", sectionName, "Name of section should match the name which user navigate to");
    }
}


