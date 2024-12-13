package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC004_LogoutTest extends BaseClass {

	@Test
	public void verify_logout()
	{
		logger.info("...Starting TC004_LogoutTest..... ");
		 HomePage hp = new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 
		//login page
		 LoginPage lp= new LoginPage(driver);
		 lp.setEmail(p.getProperty("email"));
		 lp.setPassword(p.getProperty("password"));
		 lp.clickLogin();
		 
		 //logout 
		 MyAccountPage pg = new MyAccountPage(driver);
		 pg.clickLogout();
		 logger.info("...Finished TC004_LogoutTest..... ");
	}
	
	
}
