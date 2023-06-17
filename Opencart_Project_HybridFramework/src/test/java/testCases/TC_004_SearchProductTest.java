package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTestClass;

public class TC_004_SearchProductTest extends BaseTestClass {
	
	@Test
	public void searchResult()
	{
		
	try {
			
		log.info("*** Search Product test case is start ***");
		HomePage hp = new HomePage(driver);
		hp.searchProduct("Mac");
		log.info("Product is type in the search box");
		hp.clickSearchBtn();
		log.info("click on search button");
		Thread.sleep(3000);
		SearchPage sp = new SearchPage(driver);
		boolean value = sp.searchProduct("iMac");
		log.info("Verify the search product in result section ");
		
		Assert.assertEquals(value, true);
		
		System.out.println("Search Product is dispay in the result ");
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
	
	   log.info("*** Search Product test case is finished ***");
	   
	}

}
