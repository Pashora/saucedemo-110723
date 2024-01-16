import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Integer.parseInt;

public class Header {
    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;



    public void clickOnBurgerMenu() {
        burgerMenu.click();
    }

    public int getQuantityOfCartBadge(){
      return parseInt(cartBadge.getText());
    }

}
