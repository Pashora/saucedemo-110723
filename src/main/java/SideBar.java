import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {
    WebDriver driver;

    public SideBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateLink;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutLink;

    public void followTheLogoutLink() {
        logOutLink.click();
    }

    public boolean allItemsLinkIsDisplayed() {
        return allItemsLink.isDisplayed();
    }

    public boolean aboutLinkIsDisplayed() {
        return aboutLink.isDisplayed();
    }

    public boolean logoutLinkIsDisplayed() {
        return logOutLink.isDisplayed();
    }

    public boolean resetAppStateLinkIsDisplayed() {
        return resetAppStateLink.isDisplayed();
    }
}
