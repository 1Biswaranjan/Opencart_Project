package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BaseObjectClass {

	public SearchPage (WebDriver driver)
	{
		super(driver);
	}
	
	public Boolean searchProduct(String prdct)
	{
		boolean value=false;
		
	    List<WebElement> products = driver.findElements(By.xpath("//*[@id='content']/div[3]//img"));
	    for(WebElement product:products)
	    {
	    	if(product.getAttribute("title").equals(prdct))
	    	{
	    		value=true;
		    	break;
	    	}
	    }
	    return value;
	}
	
	public void clickProduct(String prdct)
	{
	    List<WebElement> products = driver.findElements(By.xpath("//*[@id='content']/div[3]//img"));
	    for(WebElement product:products)
	    {
	    	if(product.getAttribute("title").equals(prdct))
	    	{
	    		product.click();
	    		break;
	    	}
	    }
	}
	    
}
