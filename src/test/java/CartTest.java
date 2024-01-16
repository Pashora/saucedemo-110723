import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {
    @Test
    public void checkCartBadgeWithQuantity() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.backPackAddToCart();
        Header header = new Header(driver);
        assertEquals(1, header.getQuantityOfCartBadge());

    }

    @Test
    public void checkCartBadgeWithQuantity3Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.backPackAddToCart();
        inventoryPage.bikeLightAddToCart();
        inventoryPage.tShirtAddToCart();
        Header header = new Header(driver);
        assertEquals(3, header.getQuantityOfCartBadge());
    }

    @Test
    public void backpackAddedToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //add backpack
        inventoryPage.backPackAddToCart();
        //go to Shopping Cart
        Header header = new Header(driver);
        header.clickOnBurgerMenu();          //перепроверить элемент
       // check item
        CartPage cartPage = new CartPage (driver);
        assertTrue(cartPage.getInventoryName().contains("Sauce Labs Backpack"));

    }
}
