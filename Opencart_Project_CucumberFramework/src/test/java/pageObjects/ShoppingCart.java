package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCart extends BaseObjectClass {

	
	public ShoppingCart(WebDriver driver)
	{
		super(driver);
	}
	
	public void cliclEST() throws InterruptedException
	{
		driver.findElement(By.xpath("(//a[@class='accordion-toggle'])[2]")).click();
		
		Thread.sleep(500);
		Select se1 = new Select(driver.findElement(By.name("country_id")));
		se1.selectByVisibleText("India");
		
		Thread.sleep(500);
		Select se2 = new Select(driver.findElement(By.name("zone_id")));
		se2.selectByVisibleText("Orissa");
		
		Thread.sleep(500);
		driver.findElement(By.name("postcode")).sendKeys("155040");
		driver.findElement(By.id("button-quote")).click();
		Thread.sleep(500);
		driver.findElement(By.name("shipping_method")).click();
		driver.findElement(By.id("button-shipping")).click();
		
	}
	
	public String getAmount() throws InterruptedException
	{
		Thread.sleep(500);
		String amount = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/table/tbody/tr[3]/td[2]")).getText();
		return amount;
	}
	
	public void clickCheckout()
	{
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	}
	
	public String verifyCheckoutPage()
	{
		String title=driver.getTitle();
		return title;
	}
	
}

