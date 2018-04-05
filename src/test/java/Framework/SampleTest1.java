package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest1 {
	WebDriver driver;
	@Test(dataProvider="getData")
	public void LoginFB(String user, String pwd)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dinav\\Downloads\\chromedriver_win32_Version2.35\\chromedriver.exe");
		 driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts(TimeUnit.SECONDS)
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="hello1";
		data[0][1]="pwd1";
		
		data[1][0]="hello2";
		data[1][1]="pwd2";
		return data;
				
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
	@Test
	public void testGitSampleteest()
	{
		System.out.println("Git sample success");
	}
	
	@Test
	public void testGitSampledevelopbranchteest()
	{
		System.out.println("Git sample develop branch success");
	}
	
	

}
