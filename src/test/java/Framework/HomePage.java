package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	private static final Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeMethod
	public void callBrowser() throws IOException {
		WebDriver driver = InitialiseDriver();

		String url = prop.getProperty("url");
		driver.get(url);
		log.info("logged into browser");

	}

	@Test(dataProvider="getData")
	public void UserCredentials(String username, String password, String text) throws IOException {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10000L);
		
		LandingPage lp = new LandingPage(driver);

		wait.until(ExpectedConditions.elementToBeClickable(lp.noThanks())).click();

		wait.until(ExpectedConditions.elementToBeClickable(lp.getLogin())).click();

		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(username);
		l.getPwd().sendKeys(password);
		log.info(text);
		//System.out.println(text);
		l.getLoginButton().click();
		
		log.info("Reached child Window");
		

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][3];
		// 0th row
		data[0][0] = "restricteduser@mail.com";
		data[0][1] = "123shd";
		data[0][2] = "Restricted user";

		// 1t8h row
		data[1][0] = "gooduser@mail.com";
		data[1][1] = "1345shd";
		data[1][2] = "good user";
		
		data[2][0] = "normaluser@mail.com";
		data[2][1] = "1345shd";
		data[2][2] = "normal user";
		
		
		
		return data;
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		driver=null;
	}


}
