package com.infoglen;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;




public class ConfigMethod extends Base {

	public WebDriver driver;
	public PageObjects objects;
	

	@BeforeClass
	public void init() {

		System.out.println("Login to home Page");
		driver = chooseBrowser();
		objects=new PageObjects(driver);
	}

//	 @AfterClass

	public void browserClose() {

		driver.quit();
	}

}