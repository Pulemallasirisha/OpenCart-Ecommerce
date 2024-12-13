package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddToCart;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Search;
import testBase.BaseClass;

public class TC009_AddToCart extends BaseClass {

    @Test
    public void verify_addtocart() throws InterruptedException {
        logger.info("...Starting TC009_AddToCart..... ");

        // Home page actions
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        // Login page actions
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();

        logger.info("......Searching product.....");

        // Search for "mac"
        Search se = new Search(driver);
        se.setSearch("mac");
        se.clickSearchbtn();

        // Adding a wait to ensure search results are fully loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".product-layout")));

        // Instantiate AddToCart page object
        AddToCart addToCartPage = new AddToCart(driver);

        // Get price elements and product titles from AddToCart page object
        List<WebElement> priceElements = addToCartPage.priceElements;
        List<WebElement> productTitles = addToCartPage.productTitles;

        // Iterate through the products and click the one within the price range
        for (int i = 0; i < priceElements.size(); i++) {
            // Extract the price, handle cases with multiple prices (discounts)
            String priceText = priceElements.get(i).getText().split("\n")[0].replace("$", "").replace(",", "");

            try {
                // Parse the price into a double
                double price = Double.parseDouble(priceText);

                // Check if price is within the specified range
                if (price > 500.00 && price < 2000.00) {
                    logger.info("Clicking on product with price: $" + price);
                    productTitles.get(i).click();  // Click the product
                    break;  // Stop after clicking the first matching product
                }
            } catch (NumberFormatException e) {
                logger.error("Unable to parse price: " + priceText);
            }
        }
        logger.info("...Adding the product to the cart..... ");

        // Click on "Add to Cart" button
        addToCartPage.clickAddToCart();

        // Wait for the success message to be visible
        wait.until(ExpectedConditions.visibilityOf(addToCartPage.successMessage));

        logger.info("..... Success message validation  ");
        
        
        // Retrieve and validate the success message
        String successMsg = addToCartPage.getSuccessMessage();
        logger.info("Validating success message: " + successMsg);
        Assert.assertTrue(successMsg.contains("Success: You have added"), "Success message validation failed!");
        
        logger.info("...Ending TC009_AddToCart..... ");
    }
}
