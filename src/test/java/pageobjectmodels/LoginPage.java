package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement provide_Email;
	@FindBy(xpath= "//input[@id='input-password']") WebElement provide_pwd;
	@FindBy(xpath= "//input[@value='Login']") WebElement click_login;
	
	public void enteremail(String Email)
	{
		provide_Email.sendKeys(Email);
	}
	
	public void enterpwd(String paswd)
	{
		provide_pwd.sendKeys(paswd);
	}
	
	public void logintoapp()
	{
		click_login.click();
	}
	

	
	
	

}
