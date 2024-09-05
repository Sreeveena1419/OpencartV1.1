package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Landing_Dashboard extends BasePage
{
public Landing_Dashboard(WebDriver driver)
{
	super(driver);
}
Actions act = new Actions(driver);
@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myaccount_title;
@FindBy (xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement Logout;

@FindBy (xpath= "//a[normalize-space()='Desktops']") WebElement Desktop_menu;
@FindBy (xpath= "//a[normalize-space()='Mac (1)']") WebElement Mac_menu;

@FindBy (xpath="//a[normalize-space()='Components']") WebElement Components_menu;
@FindBy (xpath="//a[normalize-space()='Monitors (2)']") WebElement Monitors_menu;

public boolean myaccount()
{
	try {
		return (myaccount_title.isDisplayed());
	}
	catch (Exception e)
	{
		return false;
	}
	
}
	
public void clicklogout()
{
	Logout.click();
}

public void choosemac()
{
	
	act.moveToElement(Desktop_menu).moveToElement(Mac_menu).click().perform();
	
}
public void ChooseMonitor() 
{
	act.moveToElement(Components_menu).moveToElement(Monitors_menu).click().perform();
}


}
