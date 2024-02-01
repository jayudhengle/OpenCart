package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}	
	
	//Elements
	@FindBy(name="user-name")
	WebElement txt_emailAdddress;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(name = "login-button")
	WebElement btn_login;
	
	
	//Functions
	public void enterEmailAddress(String email)
	{
		txt_emailAdddress.sendKeys(email);
	}
	
	public void enterPassword(String pass)
	{
		txt_password.sendKeys(pass);
	}
	
	public void clickLoignButton()
	{
		btn_login.submit();		
	}

}
