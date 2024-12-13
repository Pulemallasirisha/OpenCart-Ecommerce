package testCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Search;
import testBase.BaseClass;

public class TC007_Search extends BaseClass {

	@Test
	public void verify_search()
	{
		logger.info("...Starting TC007_Search..... ");
		//home page
		 HomePage hp = new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 
		 //login page
		 LoginPage lp= new LoginPage(driver);
		 lp.setEmail(p.getProperty("email"));
		 lp.setPassword(p.getProperty("password"));
		 lp.clickLogin();
		 logger.info("......login Successful.....");
		 
		 logger.info("......Searching product.....");
		 //search the product
		 Search se = new Search(driver);
		 se.setSearch("mac");
		 se.clickSearchbtn();
		 
		 Select drpcategory = new Select(se.drpcategory);
		 drpcategory.selectByVisibleText("Desktops");
		 
		 se.setSubcategory();
		 se.clickSearch();
		 
		//validation 
		 
		 String actualResult = se.getResult();
		 logger.info("Search result: " + actualResult);
		 
		 String expectedResult = "Products meeting the search criteria";
		 if(actualResult.equals(expectedResult))
		 {
			Assert.assertTrue(true);
			System.out.println(expectedResult);
			logger.info("Validation passed: The result matches the expected text.");
		 }
		 else
		 {
			 Assert.assertTrue(false);
			 logger.info("Validation failed: The result  doesn't matches the expected text.");
		 }
		 logger.info("...Ending TC007_Search..... ");
		 
		 
	}
}
