package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationpPage extends BaseObjectClass {

	public RegistrationpPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void firstName(String fname)
	{
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lname);
	}
	
	public void emailId(String email)
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	}
	
	public void telePhone(String tele)
	{
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(tele);
	}
	
	
	public void password(String password)
	{
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	}
	
	public void cnfPassword(String password)
	{
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(password);
	}
	
	public void newsletterYes()
	{
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();			
	}
	
	public void newsletterNo()
	{
		driver.findElement(By.xpath("//input[@value='0']")).click();			
	}
	
	public void agreeButton()
	{
		driver.findElement(By.xpath("//input[@name='agree']")).click();			
	}
	
	public void continueButton()
	{
		driver.findElement(By.xpath("//input[@value='Continue']")).click();			
	}
	
	public String successMsg()
	{
		String message=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		return message;
	}
	
	public void logoutbtn()
	{
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
	}
	
	public void successCntBtn()
	{
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	}

}
