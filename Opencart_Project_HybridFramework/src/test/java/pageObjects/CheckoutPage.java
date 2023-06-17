package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BaseObjectClass {

	public CheckoutPage (WebDriver driver)
	{
		super(driver);
	}
	
	public void clikContiueButton() throws InterruptedException
	{ 
		Thread.sleep(500);
		driver.findElement(By.id("button-payment-address")).click();
		Thread.sleep(500);
		driver.findElement(By.id("button-shipping-address")).click();
		Thread.sleep(500);
		driver.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.id("button-payment-method")).click();
		Thread.sleep(500);
		driver.findElement(By.id("button-confirm")).click();
		Thread.sleep(4500);
		Alert al=driver.switchTo().alert();
		al.accept();
		Thread.sleep(500);
		driver.findElement(By.id("button-confirm")).click();
	}
	 
	public String verifyConfirmOrder()
	{
		String cnf_msg = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		return(cnf_msg);
	}
	
	public void clickToHomePage()
	{
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	}
}
