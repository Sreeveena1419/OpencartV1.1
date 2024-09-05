package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IMacPage extends BasePage
{
public IMacPage(WebDriver driver)
{
	super(driver);
}


@FindBy(xpath="//span[normalize-space()='Add to Cart']") WebElement Addtocart_mac;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successmsg;

public void imactocart()
{
	Addtocart_mac.click();
}
public boolean addtocart_success()
{
	try {
	return successmsg.isDisplayed();
	} catch (Exception e)
	{
		return false;
	}
}

}
