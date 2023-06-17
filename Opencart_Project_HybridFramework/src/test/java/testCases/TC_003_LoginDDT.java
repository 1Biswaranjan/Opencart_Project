package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTestClass;

public class TC_003_LoginDDT extends BaseTestClass {

	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class)
	public void loginWithDatadriven(String email, String password, String exp)
	{
		
		log.info("*** Data Driven Test Case Start ***");
		HomePage hp = new HomePage(driver);
		hp.myAccountLink();
		log.info("click on my account");
		hp.loginLink();
		log.info("click on login link");
		
		LoginPage lp = new LoginPage(driver);
		lp.emailadd(email);
		log.info("Email id is entered");
		lp.password(password);
		log.info("Password is entered");
		lp.loginBtn();
		log.info("click on login button");
		
		MyAccountPage mp = new MyAccountPage(driver);
		String act_msg=mp.cnfMsg();
		log.info("actual msg received");
		
		if(exp.equals("Pass"))
		{
			if(act_msg.equalsIgnoreCase("My Account"))
			{
				mp.logoutbtn();
				log.info("click on logout button");
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		log.info("Expected Result is compared With Status Pass ");
		}
		
		if(exp.equals("Fail"))
		{
			if(act_msg.equalsIgnoreCase("My Account"))
			{
				mp.logoutbtn();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		log.info("Expected Result is compared With Status Fail ");
		
		}
		log.info("*** Data Driven Test Case finish ***");
	}
}

