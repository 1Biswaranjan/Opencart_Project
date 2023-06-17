package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEndTest extends BaseObjectClass{

	public EndToEndTest(WebDriver driver)
	{
		super(driver);
	}
	
	
	public void billiAddress(String fname, String lname, String add1, String city, String postcode, String country, String state) throws InterruptedException
	{
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("address_1")).sendKeys(add1);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("postcode")).sendKeys(postcode);
		
		Select se1 = new Select(driver.findElement(By.name("country_id")));
		se1.selectByVisibleText(country);
		
		Thread.sleep(500);
		Select se2 = new Select(driver.findElement(By.name("zone_id")));
		se2.selectByVisibleText(state);
		
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
}
