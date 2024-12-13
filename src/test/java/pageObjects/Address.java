package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Address extends BasePage{
	
	public Address(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Address Book']")
	WebElement btnAddress;
	
	@FindBy(xpath="//a[normalize-space()='New Address']")
	WebElement btnNewAddress;
	
	@FindBy(name="firstname")
	public
	WebElement txtfirstname;
	
	@FindBy(name="lastname")
	WebElement txtlastname;
	
	@FindBy(name="company")
	WebElement txtcompany;
	
	@FindBy(name="address_1")
	WebElement txtaddress_1;
	
	@FindBy(name="address_2")
	WebElement txtaddress_2;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="postcode")
	WebElement txtpostcode;
	
	@FindBy(name="country_id")
	public
	WebElement drpcountry_id;
	
	@FindBy(name="zone_id")
	public
	WebElement drpzone_id;
	
	@FindBy(name="default")
	WebElement rbtndefault;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[@class='text-danger']") // Locator for error message
	public WebElement errorMessage;

	
	public boolean isErrorMessageDisplayed() {
	    try {
	        return errorMessage.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

	
	
	
	
	public void clickAddress()
	{
		btnAddress.click();
	}
	
	public void clickNewAddress()
	{
		btnNewAddress.click();
	}
	
	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}

	public void setCompany(String comp)
	{
		txtcompany.sendKeys(comp);
	}

	public void setAddress1(String add1)
	{
		txtaddress_1.sendKeys(add1);
	}

	public void setAddress2(String add2)
	{
		txtaddress_2.sendKeys(add2);
	}

	public void setCity(String city)
	{
		txtcity.sendKeys(city);
	}

	public void setPostcode(String postcode)
	{
		txtpostcode.sendKeys(postcode);
	}
	

	public void setCountry(String country)
	{
		Select selectCountry = new Select(drpcountry_id);
        selectCountry.selectByVisibleText(country);
		
	}
	
	public void setRegion(String region)
	{
		Select selectRegion = new Select(drpzone_id);
        selectRegion.selectByVisibleText(region);
		
	}
	
	
	public void setDefault()
	{
		rbtndefault.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	 

}
