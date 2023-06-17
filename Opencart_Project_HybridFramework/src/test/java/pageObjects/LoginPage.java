package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseObjectClass {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void emailadd(String emmail)
	{
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emmail);
	}
	
	public void password(String pass)
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
	}
	
	public void loginBtn()
	{
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	public void homeBtn()
	{
		driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
	}
}
