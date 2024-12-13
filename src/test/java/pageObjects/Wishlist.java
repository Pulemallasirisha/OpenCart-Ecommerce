package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Wishlist extends BasePage {

	public Wishlist(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']")
	WebElement btnwishlist;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;
	
	@FindBy(xpath="//body/nav[@id='top']/div[@class='container']/div[@id='top-links']/ul[@class='list-inline']/li[3]")
	WebElement lnkwishlist;
	
	
	
	
	public WebElement getWishlistButton() {
        return btnwishlist;
    }

    public WebElement getSuccessMessage() {
        return successmsg;
    }
	
	public void clickWishlist()
	{
		btnwishlist.click();
	}
	
	public String getMsg()
	{
		return successmsg.getText();
	}

	public void displayWishlist()
	{
		lnkwishlist.click();
	}
	
	
	
}
