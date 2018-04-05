package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	//driver variable created inside a class
	
	//constructor
	public LoginPage(WebDriver driver) {
		//assigning life to the driver
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	

	
	
	
	@FindBy(id="user_email")
	WebElement Email;
	
	
	
	
	@FindBy(id="user_password")
	WebElement Password;
	
	@FindBy(name="commit")
	WebElement LoginButton;
	
	
	
	

	public WebElement getEmail()
	{
		return Email;
		
	}
	
	public WebElement getPwd()
	{
		return Password;
		
	}
	
	public WebElement getLoginButton()
	{
		return LoginButton;
		
	}


}
