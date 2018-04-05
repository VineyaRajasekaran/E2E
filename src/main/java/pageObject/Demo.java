package pageObject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dinav\\Downloads\\chromedriver_win32_Version2.35\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
	File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		//FileUtils.copyFile(src, "C:\\Users\\dinav\\screenshot.png");
		FileUtils.copyFile(src, new File("C:\\\\Users\\\\dinav\\\\screenshot.png"));
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

}
