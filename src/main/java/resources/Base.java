package resources;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;



public class Base {
	public static WebDriver driver;
	public Properties prop;

	public WebDriver InitialiseDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\dinav\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\dinav\\Downloads\\chromedriver_win32_Version2.35\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else  if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\dinav\\Downloads\\geckodriver-v0.19.1-win64_extract\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	}
	
	public void getScreenshot1(String result) throws IOException
	{
		System.out.println("result is "+result);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\dinav\\"+result+"screenshot.png"));
	}
	
	

}
