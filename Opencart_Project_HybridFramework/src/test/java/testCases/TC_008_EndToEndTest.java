package testCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.EndToEndTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.RegistrationpPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCart;
import testBase.BaseTestClass;

public class TC_008_EndToEndTest extends BaseTestClass {

	@Test
	public void endToEndTesting() throws InterruptedException
	{

		try {	
			log.info("*** End To End Test Case start ***");
		//Register new account		
			HomePage hp = new HomePage (driver);
			hp.myAccountLink();
			log.info("click on my account button");
			Thread.sleep(1500);
			hp.registerLink();
			log.info("click on register button");
			Thread.sleep(1500);
			
			RegistrationpPage rp = new RegistrationpPage(driver);
			log.info("Give the personal details");
			rp.firstName(randomName());
			rp.lastName(randomName());
			String email = randomName()+"@gmail.com";
			rp.emailId(email);
			rp.telePhone(randomNumber());
			String password = randomPassword();
			rp.password(password);
			rp.cnfPassword(password);
			rp.newsletterYes();
			rp.agreeButton();
			rp.continueButton();
			log.info("click on continue button");
			String act_msg=rp.successMsg();
			String exp_msg="Your Account Has Been Created!";
			Assert.assertEquals(act_msg, exp_msg);
			log.info("Successfull registration is verified");
			Thread.sleep(1500);
			rp.logoutbtn();
			log.info("click on logout button");
			
		//Login with newly register account
			LoginPage lp = new LoginPage(driver);
			hp.myAccountLink();
			hp.loginLink();
			log.info("click on login button");
			lp.emailadd(email);
			lp.password(password);
			log.info("email add & password is enter");
			lp.loginBtn();
			log.info("click on login button");
			Thread.sleep(1500);
			lp.homeBtn();
			log.info("click on home button");
			
		//Search product and select
		
			hp.searchProduct("mac");
			log.info("serch the product");
			hp.clickSearchBtn();
			log.info("click on search button");
			Thread.sleep(1500);
			SearchPage sp = new SearchPage(driver);
			sp.clickProduct("iMac");
			log.info("click on the searched product");
		
		//product page select the quantity & add to cart
			
			ProductPage pp = new ProductPage(driver);
			pp.selectCartValue("2");
			log.info("update the cart value");
			pp.clickToCart();
			log.info("click on add to cart button");
			Thread.sleep(1500);
	    	boolean msg=pp.cnfMsg();
	    	System.out.println(msg); 
	    	Assert.assertEquals(msg, true);
	    	log.info("cnf meassage is verify");
	    	pp.viewCart();
	    	log.info("click on view cart button");
	    	
	    //	ShoppingCart page & Checkout Page
			
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
	    	 log.info("verify the amount in shopping cart page");
	    	 
	    	 sc.clickCheckout();
	    	 Thread.sleep(1500);
	    	 String act_title = sc.verifyCheckoutPage();
	    	 String exp_title = "Checkout";
	    	 Assert.assertEquals(act_title, exp_title);
	    	 log.info("verify the title of the checkout page");
	    	 
	    	 EndToEndTest et = new EndToEndTest(driver);
	    	 et.billiAddress("qwert", "asdfg", "zxcvbn", "sety", "123546", "India", "Orissa");
	    	 log.info("Enter new address");
	    	 
	    	 CheckoutPage cp = new CheckoutPage(driver);
	    	 Thread.sleep(1000);
	    	 String act_cnfmsg=cp.verifyConfirmOrder();
	    	 String exp_cnfmsg="Your order has been placed!";
	    	 Assert.assertEquals(act_cnfmsg, exp_cnfmsg);
	    	 log.info("actual confirm message is compare to expected confirm message");
	    	 Thread.sleep(3000);
	    	 cp.clickToHomePage();
	    	 log.info("clik on Continue button for home page");
		}
		catch(Exception e)
		{
		      fail(e.getMessage());
		}
		
		log.info("*** End To End Test Case finished ***");
	}	
}
