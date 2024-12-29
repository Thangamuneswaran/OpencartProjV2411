package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.net.URL;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
public static WebDriver driver;
public Logger logger;	
public Properties p;
	@BeforeClass(groups={"Sanity","Master","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		//
		//p.getProperty("execution-env").equalsIgnoreCase("remote"
		
		/*if("remote".equalsIgnoreCase(p.getProperty("execution_env", "default")))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			//browser
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			default : System.out.println("No matching browser");
			
			}
			@SuppressWarnings("deprecation")
			URL gridUrl = new URL("http://localhost:4444/wd/hub");
			driver=new RemoteWebDriver(gridUrl,capabilities);
			
		}
		*/
		
		if("local".equalsIgnoreCase(p.getProperty("execution_env", "default"))) 
		{
		
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();
		break;
		
		case "edge": driver=new EdgeDriver();
		break;
		
		case "firefox": driver=new FirefoxDriver();
		break;
		
		default : System.out.println("Invalid browser name");
		return;
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL")); //reading URL from properties file
		driver.manage().window().maximize();
	   
	}
 
	@AfterClass(groups={"Sanity","Master","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
	    return generatedstring; 
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
	    return generatednumber; 
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(10);
	    return (generatedstring+"#"+generatednumber); 
	}
	
	public String capturesScreen(String tname) throws IOException{
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+ tname + timeStamp;
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
		
	}
	
}
