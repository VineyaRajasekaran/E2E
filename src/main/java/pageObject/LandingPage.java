package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	//driver variable created inside a class
	
	//constructor
	public LandingPage(WebDriver driver) {
		//assigning life to the driver
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	

	
	
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	WebElement Nothanks;
	
	
	
	
	@FindBy(xpath="//a[@href='http://qaclickacademy.usefedora.com/sign_in']")
	WebElement Login;
	
	
	
	@FindBy(xpath="//h2[text()='Featured Courses']")
	WebElement Title;
	
	
	
	@FindBy(xpath="//nav[@class='navbar-collapse collapse']")
	WebElement Navigate;
	
	

	public WebElement getLogin()
	{
		return Login;
		
	}
	
	public WebElement noThanks()
	{
		return Nothanks;
		
	}
	
	public WebElement getTitle()
	{
		return Title;
		
	}
	
	public WebElement getNavigate()
	{
		return Navigate;
		
	}

}
