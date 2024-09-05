package testCases;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectmodels.HomePage;
import pageobjectmodels.Landing_Dashboard;
import pageobjectmodels.LoginPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
  
	@Test (dataProvider ="LoginData", dataProviderClass =DataProviders.class, groups ="Datadriven" )
public void loginddt(String uname, String pwd, String exp)
{
		logger.info("****LOGIN STARTING*****");	
		try {
		//Homepage accessing my account and login menu
		HomePage hp= new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		//Login page 
		LoginPage lp = new LoginPage(driver);
		lp.enteremail(uname);
		lp.enterpwd(pwd);
		lp.logintoapp();
		
		Landing_Dashboard ld= new Landing_Dashboard(driver);
		boolean myaccmsg = ld.myaccount();
		//Assert.assertEquals(myaccmsg, true, "LoginFailed");
		//Assert.assertTrue(myaccmsg);
		
		//valid success testpass
		//valid unsuccessful testfail
		
		//invalid success testfail
		//invalid unsuccessful testpass
		
		if(exp.equalsIgnoreCase("Valid"))
		{ 
			if(myaccmsg==true)
			{
			ld.clicklogout();
			Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(myaccmsg==true)
			{
				ld.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****LOGIN Finished*****");
		
}
}

