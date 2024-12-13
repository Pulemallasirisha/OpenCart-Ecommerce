package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_ForgotPassword extends BaseClass {
	
	@Test
	public void verify_forgotpassword()
	{
		logger.info("...Starting TC005_ForgotPassword..... ");
		 HomePage hp = new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 
		 
		//login page
		 LoginPage lp= new LoginPage(driver);
		 lp.setEmail(p.getProperty("email"));
		 lp.setPassword(p.getProperty("password"));
		 lp.clickLogin();
		 
		 //forfot password
		 
		 ForgotPassword fp = new ForgotPassword(driver);
		 fp.clickForgot();
		 fp.setEmail(p.getProperty("email"));
		 fp.clickContinue();
		 
		 
		 // Assertion to verify confirmation message
		    String expectedMessage = "An email with a confirmation link has been sent your email address."; // Expected message content
		    System.out.println(expectedMessage);
		    Assert.assertEquals(fp.getConfirmationMsg(), expectedMessage, "The confirmation message is incorrect!");
		 
		    logger.info("...Finished TC005_ForgotPassword..... ");
	}
	

}
