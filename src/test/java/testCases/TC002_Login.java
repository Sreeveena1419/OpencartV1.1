package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectmodels.HomePage;
import pageobjectmodels.Landing_Dashboard;
import pageobjectmodels.LoginPage;

public class TC002_Login extends BaseClass
{
@Test(groups={"Sanity","Master"})
	public void Login()
	{
	logger.info("****LOGIN STARTING*****");	
	try {
	//Homepage accessing my account and login menu
	HomePage hp= new HomePage(driver);
	hp.clickmyaccount();
	hp.clicklogin();
	
	//Login page 
	LoginPage lp = new LoginPage(driver);
	lp.enteremail(p.getProperty("email"));
	lp.enterpwd(p.getProperty("password"));
	lp.logintoapp();
	
	Landing_Dashboard ld= new Landing_Dashboard(driver);
	boolean myaccmsg = ld.myaccount();
	//Assert.assertEquals(myaccmsg, true, "LoginFailed");
	Assert.assertTrue(myaccmsg);
	}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	
	
	logger.info("********TEST COMPLETED *******");
	
	}
}
