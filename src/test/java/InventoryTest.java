import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void itemsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        //Quantity of items is 6
        assertEquals(6, inventoryPage.getInventoryItemSize());

        //all inventory items are displayed
        assertTrue(inventoryPage.allItemsAreDisplayed());

        //all items name are not empty
       assertTrue(inventoryPage.allNamesAreNotEmpty());
       //all items' names are started from "Sauce Labs"
        //найти что все названия товарoв начинаются на "Sauce Labs"
    }
}
