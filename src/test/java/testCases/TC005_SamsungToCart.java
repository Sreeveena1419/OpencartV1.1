package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectmodels.HomePage;
import pageobjectmodels.Landing_Dashboard;
import pageobjectmodels.LoginPage;
import pageobjectmodels.MonitorsPage;
import pageobjectmodels.SamsungMonitorPage;

public class TC005_SamsungToCart extends BaseClass
{
	
	@Test
	public void SamsungToCart()
	{
		
		logger.info("+_+_+_+_+_**Starting Testcase 05++^+&+&+*+*");
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.enteremail(p.getProperty("email"));
		lp.enterpwd(p.getProperty("password"));
		lp.logintoapp();
		
		Landing_Dashboard ld= new Landing_Dashboard(driver);
		ld.ChooseMonitor();
		
		MonitorsPage mp = new MonitorsPage(driver);
		mp.ChooseSamsung();
		
		SamsungMonitorPage sp = new SamsungMonitorPage(driver);
		sp.EnterQty(p.getProperty("SamsungQty"));
		sp.Samsung2cart();
		boolean msg =sp.displaymsg();
		Assert.assertTrue(msg);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("+_+_+_+_+_**Finishing Testcase 05++^+&+&+*+*");
		
	}
	
	
}
