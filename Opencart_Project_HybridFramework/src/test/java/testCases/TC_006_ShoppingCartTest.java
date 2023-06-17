package testCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCart;
import testBase.BaseTestClass;

public class TC_006_ShoppingCartTest extends BaseTestClass {

	@Test
	public void verifyShoppingcartPage() throws InterruptedException
	{
		 try {
		    	log.info("*** verifyCheckoutPage Test Case Start ***");
		    	
		    	 HomePage hp = new HomePage(driver);
		    	 LoginPage lp = new LoginPage(driver);
		    	 hp.myAccountLink();
		    	 hp.loginLink();
				 lp.emailadd(rb.getString("Email"));
				 log.info("enter email id");
				 lp.password(rb.getString("password"));
				 log.info("enter password");
				 lp.loginBtn();
				 log.info("click on login button");
				 lp.homeBtn();
		    	
		    	 hp.searchProduct("mac");
		    	 log.info("Search the product");
		    	 hp.clickSearchBtn();
		    	 log.info("clik on search button");
		    	 
		    	 SearchPage sp = new SearchPage(driver);
		    	 sp.clickProduct("iMac");
		    	 log.info("clik on searched product");
		    	 
		    	 ProductPage pp = new ProductPage(driver);
		    	 Thread.sleep(1000);
		    	 pp.selectCartValue("2");
		    	 log.info("Update the cart value");
		    	 pp.clickToCart();
		    	 log.info("clik on Add to cart button");
		    	 Thread.sleep(1000);
		    	 boolean msg=pp.cnfMsg();
		    	 Assert.assertEquals(msg, true);
		    	 log.info("Confirmation message is compare to expected message");
		    	 Thread.sleep(1000);
		    	 pp.viewCart();
		    	 log.info("clik on cart button");
		    	 
		    	 Thread.sleep(1000);
		    	 ShoppingCart sc = new ShoppingCart(driver);
		    	 String attribute=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")).getAttribute("value");
		    	 int att_value=Integer.parseInt(attribute);
		    	 if(att_value!=2)
		    	 {
		    		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")).clear();
		    		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")).sendKeys("2");
		    		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		    	 }
		    	 sc.cliclEST();
		    	 String act_amount = sc.getAmount();
		    	 System.out.println(act_amount);
		    	 String exp_amount = "$205.00";
		    	 Assert.assertEquals(act_amount, exp_amount);
		    	 log.info("actual product amount is compare to expected product amount");
		    	 
		    	 sc.clickCheckout();
		    	 Thread.sleep(1000);
		    	 String act_title = sc.verifyCheckoutPage();
		    	 String exp_title = "Checkout";
		    	 Assert.assertEquals(act_title, exp_title);
		    	 log.info("actual title is compare to expected title");
		 }
		 catch(Exception e)
		 {
			 fail(e.getMessage());
		 }
		
		        log.info("*** verifyCheckoutPage Test Case finish ***");
	}
}
