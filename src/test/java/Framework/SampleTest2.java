package Framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest2 {
	
	@Test(dataProvider ="getData")
	public void printOnScreen(String username, String password, String text)
	{
		System.out.println(username);
		System.out.println(password);
		System.out.println(text);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][3];
		
		data[0][0] = "restricteduser@mail.com";
		data[0][1] = "123shd";
		data[0][2] = "Restricted user";

		
		data[1][0] = "gooduser@mail.com";
		data[1][1] = "1345shd";
		data[1][2] = "good user";
		
		return data;
	}

}
