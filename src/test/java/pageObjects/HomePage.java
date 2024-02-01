package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;


	public HomePage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnk_myAccount_ele;
	
	@FindBy(xpath = "//*[@class='dropdown-item' and text() ='Register' ]")
	WebElement lnk_register_ele;	
	
	@FindBy(xpath = "//*[@class='dropdown-item' and text() ='Login' ]")
	WebElement lnk_login_ele;
	
	
	//Functions
	public void clickmyAccount()
	{
		lnk_myAccount_ele.click();
	}
	
	public void clickRegister()
	{
		lnk_register_ele.click();
	}
	
	public void clickLogin()
	{
		lnk_login_ele.click();
	}	
}
