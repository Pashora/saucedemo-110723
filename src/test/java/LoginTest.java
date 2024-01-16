import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static java.lang.Thread.sleep;

public class LoginTest extends BaseTest {


//    @Test
//    public void successfulLoginWithoutPO() throws InterruptedException {
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));
//        userNameInputField.sendKeys("standard_user");
//        WebElement passwordInputField =
//                driver.findElement(By.id("password"));
//        passwordInputField.sendKeys("secret_sauce");
//        WebElement loginButton =
//                driver.findElement(By.id("login-button"));
//        loginButton.click();
//        //Check that auth is successful
//        // assertTrue(driver.getCurrentUrl().contains("inventory.html"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement inventoryList =
//                driver.findElement(By.className("inventory_list"));
//        assertTrue(inventoryList.isDisplayed());
//        // sleep(5000);
//    }

    @Test
    public void successfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
    }

    @Test
    public void invalidPasswordWithoutPO() {
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement passwordInputField =
                driver.findElement(By.id("password"));
        passwordInputField.sendKeys("qe43677");
        WebElement loginButton =
                driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorMessage =
                driver.findElement(By.tagName("h3"));
        //если мне нужно сравнить символ в символ, мне следует использовать assertEquals
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage.getText());

        //если нужно сравнить вхождение какого-то кусочка, тогда использую assertTrue
        // assertTrue(errorMessage.getText().contains("Username and password do not match any user in this service"));
    }

    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("qe43677");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.errorMessageGetText()
                .contains("Username and password do not match any user in this service"));
    }

    @Test
    public void lockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.errorMessageGetText()
                .contains("Sorry, this user has been locked out."));
    }


    //check that logo, username section and password section are displayed
    @Test
    public void elementsAreDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logoIsDisplayed();
        loginPage.usernameSectionIsDisplayed();
        loginPage.passwordsSectionIsDisplayed();
    }

    @Test
    public void testSuccessLogout() {
        //login with valid data
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        //Navigate to burger menu
        Header header = new Header(driver);
        header.clickOnBurgerMenu();

        //Follow the link Logout
        SideBar sideBar = new SideBar(driver);
        sideBar.followTheLogoutLink();

        //Assert that logout is successful
        assertTrue(loginPage.usernameSectionIsDisplayed());


    }
}
