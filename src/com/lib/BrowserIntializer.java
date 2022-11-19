package com.lib;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserIntializer extends ExtentReportNG{
	
	  public static  WebDriver driver;
	  public static ExtentReports extent;
	  public DesiredCapabilities capabilities;
	  
	  @Parameters({ "browser", "appUrl" })
	  @BeforeTest
	  public WebDriver openBrowser(String browser, String appUrl) throws MalformedURLException {
		  // launch the specified browser  
		  
		  try {
		      if (browser.equalsIgnoreCase("firefox")) {	
		    	  WebDriverManager.firefoxdriver().setup();		    	  	       
			        driver = new FirefoxDriver();		      
		        
		      }
		     else if (browser.equalsIgnoreCase("chrome")) {		    	 
		    	 ChromeOptions options = new ChromeOptions();	    	 
		    	 WebDriverManager.chromedriver().setup();
		    	 driver = new ChromeDriver();
				 options.setHeadless(false);				
				 driver= new ChromeDriver(options);				
		        
		      }else if (browser.equalsIgnoreCase("safari")){
		    	  WebDriverManager.safaridriver().setup();
		    	  driver = new SafariDriver();     
		      
		    }else if (browser.equalsIgnoreCase("ie")) {		       
		        driver = new InternetExplorerDriver();		        
		      }
		      
		      driver.manage().window().maximize();
		      driver.get(appUrl);
		      return driver;		      
		    } catch (Exception e) {
		      e.getMessage();
		    }
		    return driver;	  
		  
	  }
	  
	  public static WebDriver driver() {
		    return driver;
		  }
	  
	

}
