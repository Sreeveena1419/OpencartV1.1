package pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{
	public RegistrationPage (WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators of Registration page

	@FindBy(xpath="//input[@id='input-firstname']") WebElement Firstname_txt;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement Lastname_txt;
	@FindBy(xpath="//input[@id='input-email']") WebElement Email_txt;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement Telephone_txt;
	@FindBy(xpath="//input[@id='input-password']") WebElement Pwd_txt;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement CnfPwd_txt;

	@FindBy(xpath="//label[normalize-space()='No']") WebElement Nwsltr_radio;
	@FindBy(xpath="//input[@name='agree']") WebElement PrvcyPol_radio;
	@FindBy(xpath="//input[@value='Continue']") WebElement ContnuBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement SuccessMsg;
	
	
	//Actions
	
	public void EnterFname(String Fname) 
	{
		Firstname_txt.sendKeys(Fname);
	}
	
	public void EnterLname(String Lname) 
	{
		Lastname_txt.sendKeys(Lname);
	}
	
	public void EnterMailID(String MailID) 
	{
		Email_txt.sendKeys(MailID);
	}
	
	public void EnterPhone(String Phone) 
	{
		Telephone_txt.sendKeys(Phone);
	}
	
	public void EnterPswd1(String Pswd1) 
	{
		Pwd_txt.sendKeys(Pswd1);
	}
	
	public void EnterCnfPswd(String Pswd2) 
	{
		CnfPwd_txt.sendKeys(Pswd2);
	}
	
	public void Newsletter() 
	{
		Nwsltr_radio.click();
	}
	
	public void PrivPol() 
	{
		PrvcyPol_radio.click();
	}
	
	public void Ctnbtn() 
	{
		ContnuBtn.click();
	}
	
	
	public String Message() 
	{
		try{
			return (SuccessMsg.getText());
		
	}
	catch (Exception e)
	{
		return (e.getMessage());
	}
	}
	
	
}


