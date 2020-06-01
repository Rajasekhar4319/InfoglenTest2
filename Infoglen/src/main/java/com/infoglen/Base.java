package com.infoglen;



import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Base {

	 WebDriver driver;	
	public   WebDriver chooseBrowser()
	{
		File f=new File(System.getProperty("user.dir"));
		String bname=UserData.bname;
		if(bname.equalsIgnoreCase("chrome"))	
		{
			System.setProperty("webdriver.chrome.driver",f+"/chromedriver.exe");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setAcceptInsecureCerts(true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--start-maximized");
            options.merge(capabilities);
            driver=new ChromeDriver(options);
			
		   
			return driver;
		}
		
		else if(bname.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",f+"/geckodriver");
				driver = new FirefoxDriver();
			//	System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
			//	driver = new SafariDriver();
				
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless", "--disable-gpu","--ignore-certificate-errors","window-size=1440,900");
//				
//				
//				driver= new ChromeDriver(options);
				return driver;
			}
		
		else
		{
			return null;
		}
	}

	
	
	
	
	
	
	
}
