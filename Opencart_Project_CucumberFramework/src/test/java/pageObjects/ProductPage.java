package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BaseObjectClass {

	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	public void selectCartValue(String qnty)
	{
	    driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	    driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(qnty);
    }

     public void clickToCart()
                {
	              driver.findElement(By.xpath("//button[@id='button-cart']")).click();
                }

     public Boolean cnfMsg()
           { 
	
              try {
                     boolean value = driver.findElement(By.xpath("//div[contains(text(),'Success: You have added')]")).isDisplayed();
                      return value;
	              }
              catch(Exception e)
                    {
	                   return false;
                    }
           }
	
      public void viewCart() throws InterruptedException
      {
    	  driver.findElement(By.xpath("//span[@id='cart-total']")).click();
    	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//strong[normalize-space()='View Cart']")).click();
    	  
      }

}
