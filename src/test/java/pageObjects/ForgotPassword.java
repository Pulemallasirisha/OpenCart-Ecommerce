package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage{
	public ForgotPassword(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement lnkforgot;
	
	@FindBy(xpath="(//input[@id='input-email'])[1]")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement stringmsg;
	
	
	public void clickForgot()
	{
		lnkforgot.click();
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
		
	public String getConfirmationMsg() {
	    return stringmsg.getText();
	}

}
