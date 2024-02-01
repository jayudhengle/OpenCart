package testCases;
import pageObjects.HomePage;

import testBase.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest
{
	
	@Test
	public void homePageDetails() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);		
		hp.clickmyAccount();
		hp.clickRegister();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='content']/h1")).getText(), "Register Account");		
	}

}
