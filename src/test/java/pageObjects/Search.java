package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BasePage {

	public Search(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtsearch;
	
	@FindBy(xpath="(//button[@class='btn btn-default btn-lg'])[1]")
	WebElement btnsearch;
	
	@FindBy(xpath="//select[@name='category_id']")
	public
	WebElement drpcategory;
	
	
	@FindBy(xpath="//input[@name='sub_category']")
	WebElement subcategory;
	
	@FindBy(xpath="//input[@id='button-search']")
	WebElement search;
	
	@FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']")
	WebElement searchresult;
	
	
	public void setSearch(String pname)
	{
		txtsearch.sendKeys(pname);
	}
	
	
	public void clickSearchbtn()
	{
		btnsearch.click();
	}
	
	
	public void clickCategory()
	{
		drpcategory.click();;
	}
	public void setSubcategory()
	{
		subcategory.click();;
	}
	public void clickSearch()
	{
		search.click();
	}
	
	public String getResult()
	{
		return searchresult.getText();
	}
	
	
	
}
