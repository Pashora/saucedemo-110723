import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCartButton;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShirtAddToCartButton;


    public boolean inventoryListIsDisplayed() {
        return inventoryList.isDisplayed();
    }

    public int getInventoryItemSize() {
        return items.size();
    }

    public boolean allItemsAreDisplayed() {
        boolean allDisplayed = true;
        for (WebElement item : items) {
            if (item.isDisplayed() == false) {
                allDisplayed = false;
                break;

            }
        }
        return allDisplayed;
    }

    public boolean allNamesAreNotEmpty() {
        boolean allNamesAreNotEmpty = true;
        for (WebElement name : itemNames) {
            if (name.getText().isEmpty()) {
                allNamesAreNotEmpty = false;
                break;
            }
        }
        return allNamesAreNotEmpty;
    }
    public boolean allNamesStartWithSauceLabs() {
        boolean allStartWithSauceLabs = true;
        String expectedText = "Sauce Labs";

        int i = 0;
        for(WebElement item : itemNames) {
            String text = item.getText();

            if(!text.startsWith(expectedText)) {
                allStartWithSauceLabs = false;
                System.out.println("Element without Sauce Labs: " + i);
                break;
            }
            i++;
        }
        return allStartWithSauceLabs;
    }

    public void backPackAddToCart(){
        backpackAddToCartButton.click();
    }
    public void bikeLightAddToCart(){
        bikeLightAddToCartButton.click();
    }
    public void tShirtAddToCart() {
        tShirtAddToCartButton.click();
    }
}
