package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Search;
import pageObjects.Wishlist;
import testBase.BaseClass;

public class TC008_Wishlist extends BaseClass {

    @Test
    public void verify_wishlist() {
        logger.info("...Starting TC008_Wishlist..... ");
        
        // Home Page
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();
        
        // Login Page
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();
        logger.info("......Login successful.....");
        
        // Search Product
        logger.info("......Searching product.....");
        Search se = new Search(driver);
        se.setSearch("imac");
        se.clickSearchbtn();
        
        // Add to Wishlist
        Wishlist ws = new Wishlist(driver);
        
        // Wait for wishlist button to be clickable and then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ws.getWishlistButton()));  // Assuming getWishlistButton() is a method that returns btnwishlist
        ws.clickWishlist();
        
        // Wait for success message to be visible
        wait.until(ExpectedConditions.visibilityOf(ws.getSuccessMessage()));  // Assuming getSuccessMessage() returns successmsg
        
        // Capture the actual result from the success message
        String actualResult = ws.getMsg().trim();
        logger.info("Success message received: " + actualResult);
        
        // Expected Result
        String expectedResult = "Success: You have added iMac to your wish list!";
        
        // Validate the success message
        if (actualResult.equalsIgnoreCase(expectedResult)) {
            Assert.assertTrue(false);
            logger.info("Validation passed: The result matches the expected text.");
        } else {
            Assert.assertTrue(true);
            logger.info("Validation failed: The result doesn't match the expected text.");
        }
        
        
        ws.displayWishlist();
        
       
        
        logger.info("...Ending TC008_Wishlist..... ");
    }
}
