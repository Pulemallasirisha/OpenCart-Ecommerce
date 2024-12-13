package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends BasePage {

    public AddToCart(WebDriver driver) {
        super(driver);
    }

    // Locating product prices on the search results page
    @FindBy(css = ".product-layout .price")
    public List<WebElement> priceElements;

    // Locating product titles (links) to click
    @FindBy(css = ".product-thumb h4 a")
    public List<WebElement> productTitles;

    // Locating "Add to Cart" button
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addtocart;

    // Locating the success message after adding to cart
    @FindBy(css = ".alert-success")
	public
    WebElement successMessage;

    // Click "Add to Cart" button
    public void clickAddToCart() {
        addtocart.click();
    }

    // Retrieve the success message text
    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
