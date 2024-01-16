import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SideBarTest extends BaseTest {
    @Test
    public void allLinkAreDisplayed() {
        //Auth
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        //Go to burger menu
        Header header = new Header(driver);
        header.clickOnBurgerMenu();

        //Check that all links are displayed
        SideBar sideBar = new SideBar(driver);
        assertTrue(sideBar.allItemsLinkIsDisplayed());
        assertTrue(sideBar.aboutLinkIsDisplayed());
        assertTrue(sideBar.logoutLinkIsDisplayed());
        assertTrue(sideBar.resetAppStateLinkIsDisplayed());
    }
}
