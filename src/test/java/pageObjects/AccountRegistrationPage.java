package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
public
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmPassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkdPolicy;

@FindBy(xpath="//input[@value='Continue']")
public
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
public
WebElement msgConfirmation;



public void setFirstName(String fname)
{
	txtFirstname.sendKeys(fname);
}


public void setLastName(String lname)
{
	txtLastname.sendKeys(lname);
}

public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void setTelephone(String tel)
{
	txtTelephone.sendKeys(tel);
}

public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void setConfirmPassword(String cpwd)
{
	txtConfirmPassword.sendKeys(cpwd);
}
public void setPrivacyPolicy()
{
	chkdPolicy.click();
	}
public void clickConrinue()
{
	btnContinue.click();
}

public String  getConfirmationMsg()
{
	try {
		return(msgConfirmation.getText());
	}catch (Exception e)
	{
		return(e.getMessage());
	}
}









	
}
