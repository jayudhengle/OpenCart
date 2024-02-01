

package testBase;


import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	public ChromeOptions options;
	

	public void  captureScreenshots(String tname) throws IOException
	{
	
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dt = new Date();
		String currentDttm =  df.format(dt); 
		
		TakesScreenshot takesScreenshot =  (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+ "/screenshots/myScreen" + tname + "_" +currentDttm +".png";
		System.out.println(targetFilePath);		
		File targetFile = new File (targetFilePath);
		
		FileUtils.copyFile(sourceFile, targetFile);		
		sourceFile.renameTo(targetFile);		
	}	
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) throws InterruptedException, IOException
	{
		FileReader file =  new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);	
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//options= new ChromeOptions();
			//options.addArguments("--headless");
			driver=new ChromeDriver();				
		}	
		
		else 
		{
			if (browser.equalsIgnoreCase("edge"))		
			{
				WebDriverManager.edgedriver().setup();
				//options= new ChromeOptions();
				//options.addArguments("--headless");
				driver=new EdgeDriver();				
			}	
			else
			{
				WebDriverManager.firefoxdriver().setup();
				//options= new ChromeOptions();
				//options.addArguments("--headless");
				driver=new FirefoxDriver();		
			}
		}
	}
	
	@BeforeMethod
	public void enterUTL() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));			
		Thread.sleep(3000);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();		
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
}
