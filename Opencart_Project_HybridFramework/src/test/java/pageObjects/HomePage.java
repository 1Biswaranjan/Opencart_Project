package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseObjectClass {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void myAccountLink()
	{
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
    }
	
	public void registerLink()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
    }
	
	public void loginLink()
	{
		driver.findElement(By.linkText("Login")).click();
	}
	
	public void searchProduct(String prdctname)
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(prdctname);
	}
	
	public void clickSearchBtn()
	{
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

}
