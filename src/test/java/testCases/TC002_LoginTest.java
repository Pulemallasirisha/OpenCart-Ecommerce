package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		
		logger.info("...Starting TC002_LoginTest..... ");
		try {
		//home page
		 HomePage hp = new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 
		 //login page
		 LoginPage lp= new LoginPage(driver);
		 lp.setEmail(p.getProperty("email"));
		 lp.setPassword(p.getProperty("password"));
		 lp.clickLogin();
		 
		 //my accountpage
		 MyAccountPage macc = new MyAccountPage(driver);
	     boolean targetPage = macc.isMyAccountPageExists();
	     
	     Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.info("failed test case");
		}
	     logger.info("...Finished TC002_LoginTest..... ");
	}
}
