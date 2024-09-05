package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	//@BeforeClass(groups="Master")
	@BeforeClass (groups={"Sanity","Master", "Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws InterruptedException, IOException
	{
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		logger= LogManager.getLogger(this.getClass());
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-search-engine-choice-screen");
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capability = new DesiredCapabilities();
			
			//for OS
			 if(os.equalsIgnoreCase("windows"))
			 {
				 capability.setPlatform(Platform.WIN11);
			 }
			 else if (os.equalsIgnoreCase("mac"))
			 {
				 capability.setPlatform(Platform.MAC);
			 }
			 else if (os.equalsIgnoreCase("Linux"))
			 {
				 capability.setPlatform(Platform.LINUX);
			 }
			 else
			 {
				 System.out.println("No matching OS");
			 }

			
			// for Browser
			 switch(br.toLowerCase())
					 {
					 case "chrome": capability.setBrowserName("chrome");break;
					 case "edge" : capability.setBrowserName("MicrosoftEdge");break;
					 case "firefox" : capability.setBrowserName("firefox");break;
					 default: System.out.println("Invalid browser"); return;
					 }
			 
			 driver = new RemoteWebDriver (new URL("http://192.168.1.226:4444"), capability);
			 
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		
		{
			
		    switch (br.toLowerCase())
			{
			case "chrome": driver= new ChromeDriver(options); break;
			case "edge" : driver= new EdgeDriver(); break;
			default: System.out.println("Invalid browser"); return;
		}
		}
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //adding wait to the scripts
	    driver.get(p.getProperty("appURL"));
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	}
public String random()
	
	{ 
		String generatedstring= RandomStringUtils.randomAlphabetic(7);
		return generatedstring;
	}
	
	public String randomnum()
	{
		String generatednum= RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
	
	public String randomalphanum()
	{
		String generatedstring= RandomStringUtils.randomAlphabetic(3);
		String generatedalpha= RandomStringUtils.randomNumeric(3);
		return (generatedstring+"#"+generatedalpha);
	}
	
	public String capturescreen(String Image)
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetpath = System.getProperty("user.dir")+"\\screenshots\\"+Image+"-"+timestamp+".png";
		File targetImage = new File(targetpath);
		sourceFile.renameTo(targetImage);
		return targetpath;
		
	}
	//@AfterClass(groups="Master")
	@AfterClass(groups={"Sanity","Master"})
	public void teardown()
	{
		driver.quit();
	}
}
