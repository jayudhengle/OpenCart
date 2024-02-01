package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.JavascriptExecutor;


public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}	
	
	//Elements
	@FindBy(name = "firstname")
	WebElement txt_firstName;

	@FindBy(name = "lastname")
	WebElement txt_lastName;
	
	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(name = "email")
	WebElement txt_email;
	
	@FindBy(xpath = "//*[@id='input-newsletter-yes']")
	WebElement rb_subscribeYes;
	
	@FindBy(xpath = "//*[@id='input-newsletter-no']")
	WebElement rb_subscribeNo;
	
	@FindBy(xpath =  "//*[@type='checkbox' and @name = 'agree']")
	WebElement cb_agree;
	
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement btn_continue;

		
	
	//Functions
	public void enterfirstName(String name )
	{
		txt_firstName.sendKeys(name);
	}
	
	public void enterlastName(String last)
	{
		txt_lastName.sendKeys(last);

	}
	
	public void enterPassword(String pass)
	{
		txt_password.sendKeys(pass);
	}
	
	public void enterEmail(String email)
	{
		txt_email.sendKeys(email);		
	}
	
	public void selectSubcription(String value) throws InterruptedException
	{
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		
		if (value == "yes" || value =="Yes")
		{
			rb_subscribeYes.click();
		}		
			
		else
		{
			rb_subscribeNo.click();	
		}
	}
	
	public void selectAgreeCheckBox() throws InterruptedException
	{
		Actions actions = new Actions(driver); 
		actions.moveToElement(cb_agree).click();
	}
	
	public void clickContinue()
	{
		btn_continue.submit();
	}
}
