package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonitorsPage extends BasePage
{
public MonitorsPage (WebDriver driver)
{
	super(driver);
}

@FindBy (xpath="//div[@class='caption']//a[contains(text(),'Samsung SyncMaster 941BW')]") WebElement SamsungMonitor;


public void ChooseSamsung() 
{
	SamsungMonitor.click();
}

}
