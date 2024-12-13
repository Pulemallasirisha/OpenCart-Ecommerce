package testCases;



import org.testng.annotations.Test;


import pageObjects.Address;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC010_Address extends BaseClass{
	@Test
	 public void verify_address()  {
		logger.info("...Starting TC010_Address..... ");
	 
		// Home page actions
	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        hp.clickLogin();
	        
	        logger.info("...Login Successfull..... ");
	        // Login page actions
	        LoginPage lp = new LoginPage(driver);
	        
	        lp.setEmail(p.getProperty("email"));
	        lp.setPassword(p.getProperty("password"));
	        lp.clickLogin();
	        
	        logger.info("...Enter address details..... ");
	        //address
	        Address  ad = new Address(driver);
	        ad.clickAddress();
	        ad.clickNewAddress();
	        ad.setFirstName(randomString().toUpperCase());
	        ad.setLastName(randomString().toUpperCase());
	        ad.setCompany(randomString().toUpperCase());
	        ad.setAddress1(randomString().toUpperCase());
	        ad.setAddress2(randomString().toUpperCase());
	        ad.setCity(randomString().toUpperCase());
	        ad.setPostcode(randomNumber());
	        ad.setCountry("India");
	        ad.setRegion("Telangana");
	        ad.setDefault();
	        ad.clickContinue();
	        
	        logger.info("...Ending TC010_Address..... ");
		 
	 }

}
