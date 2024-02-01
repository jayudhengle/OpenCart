package testCases;

import pageObjects.*;
import testBase.BaseTest;
import utilities.ExcelReader;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest
{
	@Test(dataProvider = "loginDetails", dataProviderClass = ExcelReader.class)
	public void loginFunctionalityTest(String email, String pass, String res) throws InterruptedException
	{
		System.out.println(email);		
		System.out.println(pass);
		
	
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress(email);
		lp.enterPassword(pass);
		lp.clickLoignButton();
		
		Thread.sleep(3000);	
		
	}
}
