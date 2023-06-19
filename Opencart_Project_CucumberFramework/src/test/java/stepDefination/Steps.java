package stepDefination;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckoutPage;
import pageObjects.EndToEndTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;
import pageObjects.RegistrationpPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCart;
import utilities.DataReader;

public class Steps {
	
	public WebDriver driver;
    HomePage hp;
    RegistrationpPage rp;
    MyAccountPage macc;
    LoginPage lp;
    SearchPage sp;
    ProductPage pp;
    ShoppingCart sc;
    EndToEndTest et;
    CheckoutPage cp;
    
    List<HashMap<String,String>> dataMap;
    
    public Logger log; //for logging
    public ResourceBundle rb; // for reading properties file
    public String br; //to store browser name
    public String randomName;
    public String randomNumber;
    public String randomPassword;
    public String randomEmail;
    
	@Before
	public void setUp()
	{
		 //for logging
        log= LogManager.getLogger(this.getClass());
        //Reading config.properties (for browser)
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");
        randomName =RandomStringUtils.randomAlphabetic(5);
        randomEmail=randomName+"@gmail.com";
        randomNumber=RandomStringUtils.randomNumeric(10);
        String randomp1= RandomStringUtils.randomAlphabetic(3);
        String randomp2 = RandomStringUtils.randomNumeric(2);
        randomPassword=randomp1+"@"+randomp2;
	}

	@After
	public void tearDown(Scenario scenario)
	{
		System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {
             byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
            }
		driver.quit();
	}
	
	                               // *** Implement Registration Feature ***
	
	@Given("user open the browser")
	public void user_open_the_browser() 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver(options);
		if(br.equals("chrome"))
	        {
	           driver=new ChromeDriver(options);
	        }
	        else if (br.equals("firefox")) {
	            driver = new FirefoxDriver();
	        }
	        else if (br.equals("edge")) {
	            driver = new EdgeDriver();
	        }
	}

	@Given("open the url {string}")
	public void open_the_url(String url) 
	{
		driver.get(url);
        driver.manage().window().maximize();
	}

	@When("user navigate to Homepage")
	public void user_navigate_to_homepage() 
	{
		hp = new HomePage(driver);
		hp.myAccountLink();
		log.info("click on my account");
	}

	@When("click on register")
	public void click_on_register() 
	{
		hp.registerLink();
		log.info("click on registerLink");
	}

	@When("user enter firstname as {string}")
	public void user_enter_firstname_as(String fname) throws InterruptedException 
	{
		Thread.sleep(500);
		rp = new RegistrationpPage(driver);
		rp.firstName(fname);
	}

	@When("user enter lastname as {string}")
	public void user_enter_lastname_as(String lname) 
	{
		rp.lastName(lname);
	}

	@When("user enter email as {string}")
	public void user_enter_email_as(String email) 
	{
		rp.emailId(email);
	}

	@When("user enter telephone as {string}")
	public void user_enter_telephone_as(String telephone) 
	{
		rp.telePhone(telephone);
	}

	@When("user enter password as {string}")
	public void user_enter_password_as(String password) 
	{
		rp.password(password);
	}

	@When("user enter confirm password as {string}")
	public void user_enter_confirm_password_as(String cnfPassword) 
	{
		rp.cnfPassword(cnfPassword);
	}

	@When("user click the subscribe buttn yes")
	public void user_click_the_subscribe_buttn_yes() 
	{
		rp.newsletterYes();
		log.info("click on newsletters Yes");
	}

	@When("user click the privacy policy")
	public void user_click_the_privacy_policy() 
	{
		rp.agreeButton();
		log.info("click on agree");
	}

	@When("user click the continue button")
	public void user_click_the_continue_button() 
	{
		rp.continueButton();
		log.info("click on continue");
	}


	@Then("validate the success message")
	public void validate_the_success_message() throws InterruptedException 
	{
		Thread.sleep(1000);
		String act_Message=rp.successMsg();
		String exp_Message="Your Account Has Been Created!";
		if(act_Message.equalsIgnoreCase(exp_Message))
		{
			log.info("Expected message is equal to actual message");
            Assert.assertTrue(true);
		}
		else
		{
			log.info("Expected message is not equal to actual message");
            Assert.assertTrue(false);
		}
		
	}

	@Then("click on continue")
	public void click_on_continue() 
	{
		rp.successCntBtn();
		log.info("click on continue");

	}

	@Then("validate the My Account page")
	public void validate_the_my_account_page() throws InterruptedException 
	{
		Thread.sleep(1000);
	    macc = new MyAccountPage(driver);
	    String act_msg=macc.myAccPageTitle();
	    String exp_msg="My Account";
	    if(act_msg.equalsIgnoreCase(exp_msg))
	    {
	    	log.info("Expected message is equal to actual message");
            Assert.assertTrue(true);
	    }
	    else
	    {
	    	log.info("Expected message is not equal to actual message");
            Assert.assertTrue(false);
	    }
	}
	
	
	                                         // *** Implement Login Feature with DDT ***
	
	@When("click on Login")
	public void click_on_login() 
	{
	    hp.loginLink();
	    log.info("click on login button from dropdown");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException 
	{
	   Thread.sleep(500);
	   lp = new LoginPage(driver);
	   lp.emailadd(email);
	   log.info("Enter email id");
	   lp.password(password);
	   log.info("Enter password");

	}

	@When("Click on Login button")
	public void click_on_login_button() 
	{
	    lp.loginBtn();
	    log.info("click on login button");
	}
	
	
	// *** Login With DDT Using Excel Sheet ***
			
	@Then("check User navigates to MyAccount Page by passing Email and Password with excel row {string}")
	public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_row(String row) throws InterruptedException 
	{
		String path = ".\\testData\\CucumberDDT.xlsx";
		dataMap=DataReader.data(path, "Sheet1");
		int index = Integer.parseInt(row)-1;
		String email=dataMap.get(index).get("username");
		String pwd=dataMap.get(index).get("password");
		String exp_res=dataMap.get(index).get("res");
		
		lp = new LoginPage(driver);
        lp.emailadd(email);
		lp.password(pwd);
		lp.loginBtn();
		Thread.sleep(1000);
		macc=new MyAccountPage(driver);
	try 
		{
		  String act_title=macc.myAccPageTitle();
		  if(exp_res.equalsIgnoreCase("Valid"))
		  {
		    
			if(act_title.equalsIgnoreCase("My Account")) {
			 macc.logoutbtn();
			 Assert.assertTrue(true); 
			}
			else
	          {
	              Assert.assertTrue(false);
	          }
		  }
		  
		  if(exp_res.equalsIgnoreCase("Invalid"))
		  {
			if(act_title.equalsIgnoreCase("My Account")) {
			   macc.logoutbtn();
			  Assert.assertTrue(false); 
			}
			else
	          {
	              Assert.assertTrue(true);
	          }
		  }
		}
	catch(Exception e)
	{
		Assert.fail();
	}
	
 }
	 
	           // *** EndToEnd Test the application
	
	@When("user enter firstname")
	public void user_enter_firstname() throws InterruptedException 
	{
		Thread.sleep(500);
		rp = new RegistrationpPage(driver);
		rp.firstName(randomName);
	}

	@When("user enter lastname")
	public void user_enter_lastname() 
	{
		rp.lastName(randomName);
	}

	@When("user enter email")
	public void user_enter_email() 
	{
		rp.emailId(randomEmail);
	}

	@When("user enter telephone")
	public void user_enter_telephone() 
	{
		rp.telePhone(randomNumber);
	}

	@When("user enter password")
	public void user_enter_password() 
	{
		rp.password(randomPassword);
	}

	@When("user enter confirm password")
	public void user_enter_confirm_password() 
	{
		rp.cnfPassword(randomPassword);
	}

	@Then("logout from application")
	public void logout_from_application() 
	{
	   rp.logoutbtn();
	}
	
	@When("User enters Email and Password")
	public void user_enters_email_and_password() throws InterruptedException 
	{
		Thread.sleep(500);
		lp = new LoginPage(driver);
        lp.emailadd(randomEmail);
		lp.password(randomPassword);
	}
	
	@Then("click the Login button")
	public void click_the_login_button() throws InterruptedException 
	{
	   lp.loginBtn();
	   Thread.sleep(500);
	   lp.homeBtn();
	}

	@When("type the prduct name as {string}")
	public void type_the_prduct_name_as(String prdctName) throws InterruptedException 
	{
	   Thread.sleep(500);
	   hp.searchProduct(prdctName);
	}
	@When("click on search  button")
	public void click_on_search_button() 
	{
	    hp.clickSearchBtn();
	}

	@Then("verify the searched product and click the searched product")
	public void verify_the_searched_product_and_click_the_searched_product() throws InterruptedException 
	{
		Thread.sleep(500);
		SearchPage sp = new SearchPage(driver);
		sp.clickProduct("iMac");
	}

	@When("select the cart value")
	public void select_the_cart_value() 
	{
		pp = new ProductPage(driver);
		pp.selectCartValue("2");
		log.info("update the cart value");
	}
	@When("click on add to cart")
	public void click_on_add_to_cart() 
	{
		pp.clickToCart();
		log.info("click on add to cart button");
	}
	@Then("verify the confirmation message after add the product to cart")
	public void verify_the_confirmation_message_after_add_the_product_to_cart() throws InterruptedException 
	{
		Thread.sleep(1500);
    	boolean msg=pp.cnfMsg();
    	Assert.assertEquals(msg, true);
    	log.info("cnf meassage is verify");
	}
	@Then("click on view to verify product added to cart")
	public void click_on_view_to_verify_product_added_to_cart() throws InterruptedException 
	{
		pp.viewCart();
    	log.info("click on view cart button");
	}

	@When("click on estimate tax and fill the details")
	public void click_on_estimate_tax_and_fill_the_details() throws InterruptedException 
	{
		sc = new ShoppingCart(driver);
		Thread.sleep(1500);
		sc.cliclEST();
	}
	@Then("verify the price of the product after fill the details")
	public void verify_the_price_of_the_product_after_fill_the_details() throws InterruptedException 
	{
		 String act_amount = sc.getAmount();
    	 String exp_amount = "$205.00";
    	 Assert.assertEquals(act_amount, exp_amount);
    	 log.info("verify the amount in shopping cart page");
	}
	@Then("click on checkout button")
	public void click_on_checkout_button() 
	{
		 sc.clickCheckout();
	}

	@When("user enter the details of address & continue to place the order")
	public void user_enter_the_details_of_address_continue_to_place_the_order() throws InterruptedException 
	{
		et = new EndToEndTest(driver);
		Thread.sleep(1000);
		et.billiAddress("qwert", "asdfg", "zxcvbn", "sety", "123546", "India", "Orissa");
   	    log.info("Enter new address");
	}
	
	@Then("verify order is Successfully placed")
	public void verify_order_is_successfully_placed() throws InterruptedException 
	{
		cp = new CheckoutPage(driver);
		Thread.sleep(1000);
   	    String act_cnfmsg=cp.verifyConfirmOrder();
   	    String exp_cnfmsg="Your order has been placed!";
   	    Assert.assertEquals(act_cnfmsg, exp_cnfmsg);
   	    log.info("actual confirm message is compare to expected confirm message");
	}
	
	@Then("click on continue to homepage")
	public void click_on_continue_to_homepage() throws InterruptedException 
	{
		Thread.sleep(3000);
   	    cp.clickToHomePage();
   	    log.info("clik on Continue button for home page");
	}






	
	
	
	
	
}