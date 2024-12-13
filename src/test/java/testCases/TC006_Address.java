package testCases;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.Address;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

@Test
public class TC006_Address extends BaseClass{
	public void add_address() throws InterruptedException
	{
		logger.info("...Starting TC006_Address..... ");
		
		//home page
		 HomePage hp = new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		
		//login
		 LoginPage lp= new LoginPage(driver);
		 lp.setEmail(p.getProperty("email"));
		 lp.setPassword(p.getProperty("password"));
		 lp.clickLogin();
		 
		 //Add address
		 Address ad = new Address(driver); 
		 ad.clickAddress();
		 ad.clickNewAddress();
		 logger.info("Providing Address Details");
		 ad.setFirstName(randomString().toUpperCase());
		 ad.setLastName(randomString().toUpperCase());
		 ad.setCompany(randomString().toUpperCase());
		 ad.setAddress1(randomString().toUpperCase());
		 ad.setAddress2(randomString().toUpperCase());
		 ad.setCity(randomString().toUpperCase());
		 ad.setPostcode(randomNumber());
		 
		 logger.info("Selecting country randomly");
		 Select countryDropdown = new Select(ad.drpcountry_id);
		 List<WebElement> countryOptions = countryDropdown.getOptions();
		 
		// Generate a random number between 1 and the number of available options
		  Random random = new Random();
		  int randomIndex = random.nextInt(countryOptions.size());
		    
		  // Select the country randomly
		  countryDropdown.selectByIndex(randomIndex);
		  
		  
		  Thread.sleep(3000);
		  logger.info("Selecting region randomly");
		
		// Random Region (Zone) Selection
			Select regionDropdown = new Select(ad.drpzone_id);  // Use ad.drpzone_id
			List<WebElement> regionOptions = regionDropdown.getOptions();
			 
			int randomRegionIndex = random.nextInt(regionOptions.size());
			regionDropdown.selectByIndex(randomRegionIndex);
		   
		    
		 ad.setDefault();
		 ad.clickContinue();
		 logger.info("...Ending TC006_Address..... ");
		
	}

}
