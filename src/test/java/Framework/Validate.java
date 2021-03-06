package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class Validate extends Base{
	private static final Logger log = LogManager.getLogger(HomePage.class.getName());
	
	
	@BeforeTest
	public void callBrowser() throws IOException {
		WebDriver driver = InitialiseDriver();

		String url = prop.getProperty("url");
		driver.get(url);

	}

	
	@Test
	public void ValidateTitle() throws IOException {
		
		WebDriverWait wait = new WebDriverWait(driver, 3000L);
		LandingPage lp = new LandingPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lp.noThanks())).click();
		log.info("verify title");
		String title = lp.getTitle().getText();
		Assert.assertEquals(title, "FEATURED 123COURSES");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}

		

}
