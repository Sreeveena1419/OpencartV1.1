package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamsungMonitorPage extends BasePage
{
public SamsungMonitorPage(WebDriver driver)
{
	super(driver);
}


@FindBy (xpath="//input[@id='input-quantity']") WebElement Quantity;
@FindBy (xpath="//button[@id='button-cart']") WebElement AddtoCart;

@FindBy (xpath="//div[@class='alert alert-success alert-dismissible']") WebElement cartmessage;

public void EnterQty(String Qty)
{
	Quantity.clear();
	Quantity.sendKeys(Qty);
}

public void Samsung2cart()
{
	AddtoCart.click();
}

public boolean displaymsg()
{
	try
	{
		return cartmessage.isDisplayed();
	}
	catch (Exception e)
	{
		return false;
	}
	
}

}
