package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectmodels.HomePage;
import pageobjectmodels.IMacPage;
import pageobjectmodels.Landing_Dashboard;
import pageobjectmodels.LoginPage;

public class TC004_MacToCart extends BaseClass
{
@Test
	public void Addmac()
	{
	
	logger.info("******TC004 Starting*****");
	try {
	//Homepage accessing my account and login menu
		HomePage hp= new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		logger.info("-------Logging into the app --------");
		//Login page 
		LoginPage lp = new LoginPage(driver);
		lp.enteremail(p.getProperty("email"));
		lp.enterpwd(p.getProperty("password"));
		lp.logintoapp();
	
		//Landing Dashboard
		Landing_Dashboard ld= new Landing_Dashboard(driver);
		ld.choosemac();
		
		logger.info("-------- adding the mac to cart ------");
		//Imac page
		IMacPage imac = new IMacPage(driver);
		imac.imactocart();
		
		boolean message = imac.addtocart_success();
		Assert.assertTrue(message);
		
		
	}
	
	catch (Exception e)
	{
		Assert.fail();	
	}
	logger.info("****TEST COMPLETED******");
		
	
	
	
	}
}
