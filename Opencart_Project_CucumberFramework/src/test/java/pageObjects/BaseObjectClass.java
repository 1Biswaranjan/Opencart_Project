package pageObjects;

import org.openqa.selenium.WebDriver;

public class BaseObjectClass {

	public WebDriver driver;
	public BaseObjectClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
}
