package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BaseObjectClass {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	public String cnfMsg()
	{
		try
		{
		String msg=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText();
		return(msg);
		}
		catch(Exception e)
		{
			return("");
		}
		
		
	}

	public void logoutbtn()
	{
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
	}
	
}
