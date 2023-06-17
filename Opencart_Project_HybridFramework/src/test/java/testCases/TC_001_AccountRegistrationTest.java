package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationpPage;
import testBase.BaseTestClass;
public class TC_001_AccountRegistrationTest extends BaseTestClass {

	@Test(groups= {"Regression","Master"})
	public void test_Account_Registration()
	{
		
		log.info("Test Case Started");
      try {
		HomePage hp = new HomePage(driver);
		hp.myAccountLink();
		log.info("click on my account");
		hp.registerLink();
		log.info("click on registerLink");
		RegistrationpPage rp = new RegistrationpPage(driver);
		log.info("provide customer data");
		rp.firstName(randomName());
		rp.lastName(randomName());
		rp.emailId(randomName()+"@gmail.com");
		rp.telePhone(randomNumber());
		String pasword=randomName();
		rp.password(pasword);
		rp.cnfPassword(pasword);
		rp.newsletterYes();
		log.info("click on newsletters Yes");
		rp.agreeButton();
		log.info("click on agree");
		rp.continueButton();
		log.info("click on continue");
		String actualMsg=rp.successMsg();
		Assert.assertEquals(actualMsg, "Your Account Has Been Created!");

      }
      catch(Exception e)
      {
    	  log.error("Test Case is failed");
    	  Assert.fail();
      }
      log.info("test_Account_Registration is completed");
	}

}
