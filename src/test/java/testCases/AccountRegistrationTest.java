package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseTest;
import pageObjects.AccountRegistrationPage;

public class AccountRegistrationTest extends BaseTest
{
	
	@Test
	public void registration() throws InterruptedException
	{
			
		HomePage hp = new HomePage(driver);		
		
		hp.clickmyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage agp =  new AccountRegistrationPage(driver);
		
		agp.enterfirstName(randomeString());
		agp.enterlastName(randomeString());
		agp.enterEmail("test@gmail.com");
		agp.enterPassword(randomAlphaNumeric());
		Thread.sleep(3000);
		agp.selectSubcription("yes");
		agp.selectAgreeCheckBox();
		agp.clickContinue();		
		
		
		Assert.assertEquals(1, 0);
		
		
		
	}
}
