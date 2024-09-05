package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodels.HomePage;
import pageobjectmodels.RegistrationPage;

public class TC001_AccReg  extends BaseClass
{

	@Test(groups={"Regression","Master"})
	public void accregistartion()
	{
		
		logger.info("*****TEST CASE STARTED ******");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clickreg();
		
		logger.info("####ENTERING VALUES######");
		RegistrationPage rp = new RegistrationPage(driver);
		rp.EnterFname(random().toUpperCase());
		rp.EnterLname(random().toUpperCase());
		rp.EnterMailID(random()+"@gmail.com".toLowerCase());
		rp.EnterPhone(randomnum());
		String Password =randomalphanum();
		rp.EnterPswd1(Password);
		rp.EnterCnfPswd(Password);
		rp.Newsletter();
		rp.PrivPol();
		
		logger.info("#####CLICKING BUTTON#####");
		rp.Ctnbtn();
		
		String confmsg= rp.Message();
		SoftAssert sa = new SoftAssert();
		if (confmsg.equals("Your Account Has Been Created!"))
		{
			sa.assertTrue(true);
		}
		else
		{
			logger.error("###TEST FAILED####");
			logger.debug("#####DEBUG LOG IS####");
			sa.assertTrue(false);
		}
			
			sa.assertAll();
		 }
		catch (Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("******TEST FINISHED******");
				
	}
	
	
}
