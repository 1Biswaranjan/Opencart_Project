package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;

public class TC_002_LoginTest extends BaseTestClass {

	@Test(groups= {"Sanity","Master"})
	public void Login()
	{
		try {
		log.info("**** login test start***");
		 
		HomePage hp = new HomePage(driver);
		hp.myAccountLink();
		log.info("click on my account link");
		hp.loginLink();
		log.info("click on login link");
		
		LoginPage lp = new LoginPage(driver);
		lp.emailadd(rb.getString("Email"));
		log.info("enter email id");
		lp.password(rb.getString("password"));
		log.info("enter password");
		lp.loginBtn();
		log.info("click on login button");
		
		MyAccountPage mp = new MyAccountPage(driver);
		String msg=mp.cnfMsg();
		log.info("got the actual msg");
		System.out.println(msg);
		 
		Assert.assertEquals(msg,"My Account");
		log.info("comparision");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		log.info("**** login test finished***");
	}
}
