package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTestClass {
	
	public static WebDriver driver;
	public Logger log;
	public ResourceBundle rb;
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters("browser")
	public void setUp(String br)
	{ 
		rb=ResourceBundle.getBundle("config");
	
		log = LogManager.getLogger(this.getClass());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver(options);
		}
		else if (br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomName()
	{
		String randomName=RandomStringUtils.randomAlphabetic(5);
		return(randomName);
	}

	public String randomNumber()
	{
		String randomNumeric=RandomStringUtils.randomNumeric(10);
		return(randomNumeric);
	}
	
	public String randomPassword()
	{
		String randomName=RandomStringUtils.randomAlphabetic(5);
		String randomNumeric=RandomStringUtils.randomNumeric(3);
		return(randomName+"@"+randomNumeric);
	}
		
	public String captureScreenShot(String testName) throws IOException
	{
		String timeStamp= new SimpleDateFormat("dd-M-yyyy hh-mm-ss").format(new Date());
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(".\\screenshot\\"+testName+timeStamp+".png");
		FileUtils.copyFile(src, file);
		String destination=file.getAbsolutePath();
		return(destination);
	}
}
