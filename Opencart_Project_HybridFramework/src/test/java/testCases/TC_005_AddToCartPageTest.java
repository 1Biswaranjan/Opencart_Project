package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseTestClass;

public class TC_005_AddToCartPageTest extends BaseTestClass {

     @Test
	 public void addToCart()
	 {
    try {
    	log.info("*** Add To Cart Test Case Start ***");
    	 HomePage hp = new HomePage(driver);
    	 hp.searchProduct("mac");
    	 log.info("Search the product");
    	 hp.clickSearchBtn();
    	 log.info("clik on search button");
    	 
    	 SearchPage sp = new SearchPage(driver);
    	 sp.clickProduct("iMac");
    	 log.info("clik on searched product");
    	 
    	 ProductPage pp = new ProductPage(driver);
    	 Thread.sleep(2000);
    	 pp.selectCartValue("2");
    	 log.info("Update the cart value");
    	 pp.clickToCart();
    	 log.info("clik on Add to cart button");
    	 Thread.sleep(2000);
    	 boolean msg=pp.cnfMsg();
    	 System.out.println(msg);
    	 
    	 Assert.assertEquals(msg, true);
    	 log.info("Confirmation message is compare to expected message");
    }
    catch(Exception e)
    {
    	Assert.fail(e.getMessage());
    }
    	 
    log.info("*** Add To Cart Test Case finish ***");	 
    	 
	 }
}
