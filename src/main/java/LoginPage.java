import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    @FindBy(className = "login_logo")
    private WebElement logo;

    @FindBy(id = "login_credentials")
    private WebElement usernameSection;
    @FindBy(className = "login_password")
    private WebElement passwordsSection;

    public boolean setUserNameInputFieldIsDisplayed() {
        return userNameInputField.isDisplayed();
    }

    public void enterUsername(String usernameValue) {
        userNameInputField.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.sendKeys(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String errorMessageGetText() {
        return errorMessage.getText();
    }

    public boolean logoIsDisplayed() {
        return logo.isDisplayed();
    }

    public boolean usernameSectionIsDisplayed() {
        return usernameSection.isDisplayed();
    }

    public boolean passwordsSectionIsDisplayed() {
        return passwordsSection.isDisplayed();
    }
}
