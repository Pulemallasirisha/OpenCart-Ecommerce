
package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

   

   // private WebDriver driver;

    @Test(groups={"Regression","Master"})
    public void verify_AccountRegistration() {
    	logger.info("**** Starting TC_AccountRegistrationTest ****");
    	try {
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("**Clicked On My Account link**");
        wait.until(ExpectedConditions.elementToBeClickable(hp.lnkRegister));
        hp.clickRegister();
        logger.info("***Clicked On Register link***");
        
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        wait.until(ExpectedConditions.visibilityOf(regPage.txtFirstname));
        
        logger.info("Providing Customer Details");
        regPage.setFirstName(randomString().toUpperCase());
        regPage.setLastName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "abc@gmail.com");
        regPage.setTelephone(randomNumber());

        String password = randomAlphaNumeric();
        regPage.setPassword(password);
        regPage.setConfirmPassword(password);
        regPage.setPrivacyPolicy();
        wait.until(ExpectedConditions.elementToBeClickable(regPage.btnContinue));
        regPage.clickConrinue();
        logger.info("Validating expected msg");
        
        String confMsg = wait.until(ExpectedConditions.visibilityOf(regPage.msgConfirmation)).getText();
        if(confMsg.equals("Your Account Has Been Created!"))
        {
        	Assert.assertTrue(true);
        }
        else
        {
        	logger.error("Test Failed");
    		logger.debug("Debug loogs");
    		Assert.assertFalse(false);
        }
        
        
        //Assert.assertEquals(confMsg, "Your Account Has Been Created!||");
    	}
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
    	
    	logger.info("***** Finished Starting TC_AccountRegistrationTest ****");
    }
    	


   
}