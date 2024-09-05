package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators:
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement lnk_Myaccount;  //MyAccount link
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") WebElement lnk_reg;  //Register menu
	@FindBy(linkText = "Login") WebElement lnk_login; //Login menu
	
	public void clickmyaccount()
	{
		lnk_Myaccount.click();
	}
	
	public void clickreg()
	{
		lnk_reg.click();
	}

	public void clicklogin()
	{
		lnk_login.click();
	}
	

	
	

}
