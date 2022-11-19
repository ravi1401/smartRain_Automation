package com.lib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;

	public class TestBase extends BrowserIntializer{
	protected static final Log logger = LogFactory.getLog(TestBase.class);	
		private static Properties configProp = new Properties();
		private static String propFilePath;
		private static File file;
		private static FileInputStream fileInput;
		public static String key;
		public static String value;
		public static String[] dataValue;
		public static String[] keyValue;		
		  
		WebElement element, toElement;
		WebDriverWait wait;
		String By;
		ExtentTest test;
		JavascriptExecutor js;	
	
	
		/*webdriver waits for given Seconds*/
	
		public void implicityWaits(int i ) throws Exception{
		logInfo("Entered into implicityWaits method");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));	
		
			}
		
		
		// This method is used to get the current day.
		
			public static int getCurrentDay(){
				logInfo("Eneterd into getCurrentDay method");
			     Calendar calendar = Calendar.getInstance(TimeZone.getDefault());		     
			     int day = calendar.get(calendar.DATE);
			     return day;
			     
			}
		
		// This method is used to generate random number in s specified range.    
	    public static int generateRandomNumberInRange(int min,int max){
			logger.info("Generating random number in range - "+min+","+max);
			Random r = new Random();
			int num=r.nextInt(max-min) + min;			
			return num;	
			}
	
	
		// This method is used to Wait for a element to present.		
		public void wdWait(String Bytype,String locator) throws Exception{			
			try{
				
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_WAIT_TIME));						   			   		 
				switch(Bytype){
				case "xpath":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByXPath.xpath(locator)));
					break;
				case "id":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ById.id(locator)));
					break;
				case "className":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClassName.className(locator)));
					break;
				case "cssSelector":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByCssSelector.cssSelector(locator)));
					break;
				case "linkText":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLinkText.linkText(locator)));
					break;
				case "partialLinkText":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByPartialLinkText.partialLinkText(locator)));
					break;
				default :
					System.out.println("Invalid type passed to waitOnElement.");
					break;
				}				
				if(element.isDisplayed()){
	            	logInfo(element.getText() + " element is present");            	
	            }
			}
			catch(Exception e){
				logInfo("Failed!! Unable to wait on this element " + locator);		
			}			
		}		
	
		// This method is used to Maximize the browser window.	
		public void maximizeBrowser() throws Exception{		
			try{	
				driver.manage().window().maximize();
				
				
				
			}
			catch(Exception e){
				logInfo("Failed!! unable to maximize the browser window");		
			}
		}		
		
		// This method is used to Wait for a element to present.		
		public void waitOnLoadingSpinner(int seconds) throws Exception{						
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(ByXPath.xpath("//div[@class='loading-mask'][@style='display: block;']//img")));
		}
		
		// This method is used to configure the log4j.xml file and can send the logging information to that file.
		public static void logInfo(Object message) {
			try{	
				Logger Log = Logger.getLogger(Logger.class.getName());
				DOMConfigurator.configure("log4j.xml");
			    Log.info(message);
			}
			catch(Exception e){
				logInfo("Failed!! unable to log the information.");		
			}
			
	 	} 		
		
		public void waitTilldisableOfElement(int seconds) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(org.openqa.selenium.By.xpath(spinner)));
		}

		// This method is used to perform click operation on a specific element.			
		public void clickOnObject(String Bytype, String locator) {		
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));				
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				case "linkText":
					element = driver.findElement(ByLinkText.linkText(locator));
					break;
				default :
					System.out.println("Invalid type passed to clickOnElement."+locator);
					break;
				}
				if(element.isDisplayed() && element.isEnabled()){
					element.click();
				}
				   
			}
			catch(Exception e){
				logInfo("Failed!! Unable to click on an element."+locator);		
			}
			
		}
		
		// This method is used to submit an element.	
		public void submitObject(String Bytype, String locator) {		
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				case "linkText":
					element = driver.findElement(ByLinkText.linkText(locator));
					break;
				default :
					System.out.println("Invalid type passed to submitElement."+locator);
					break;
				}
				if(element.isDisplayed() && element.isEnabled()){
					element.submit();
				}
				   
			}
			catch(Exception e){
				logInfo("Failed!! Unable to submit the element."+locator);		
			}		
		}	
		
		// To Get Text of WebElement	
		public String getText(String Bytype, String locator) throws Exception{	
			String acctText = null;			
				try{
					switch(Bytype){			
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to getText."+locator);
					break;
				}				
				acctText =element.getText().trim();	
				}catch(Exception e){
					logInfo("Failed!! Unable to retrive the element."+locator);		
				}
				return acctText;
										
			}	
			
		// To Get Text of WebElement and convert into smaller case	
		public String getTextInSmallerCase(String Bytype, String locator) throws Exception{	
			String acctText = null;			
				try{
					switch(Bytype){			
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to getText."+locator);
					break;
				}				
				acctText =element.getText().toLowerCase().trim();	
				
				}catch(Exception e){
					logInfo("Failed!! Unable to retrive the element."+locator);		
				}
				return acctText;												
			}
	
	
		// To Get Text of WebElement	
		public String getAttribute(String Bytype, String locator, String valueOrPlaceholder) throws Exception{	
			String acctAtrribute = null;			
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to getText."+locator);
					break;
				}				
					if(valueOrPlaceholder=="placeholder") {
						acctAtrribute =element.getAttribute("placeholder").trim();							
					}else if(valueOrPlaceholder=="value"){
						acctAtrribute= element.getAttribute("value").trim();						
					}
					else if(valueOrPlaceholder=="aria-checked"){
						acctAtrribute= element.getAttribute("aria-checked").trim();						
					}else if(valueOrPlaceholder=="max"){
						acctAtrribute= element.getAttribute("max").trim();						
					}
					else {
						System.err.println("You have passed invalid Attribute");
						
					}	return acctAtrribute;				
										
			}				
				
			// To Get attribute of WebElement	
			public String verifyAttribute(String Bytype, String locator, String attribute, String expAttbValue) throws Exception{	
				String acctAttrb = null;			
					switch(Bytype){
					case "xpath":
						element = driver.findElement(ByXPath.xpath(locator));
						break;
					case "id":
						element = driver.findElement(ById.id(locator));
						break;
					case "name":
						element = driver.findElement(ByName.name(locator));
						break;
					case "className":
						element = driver.findElement(ByClassName.className(locator));
						break;
					case "cssSelector":
						element = driver.findElement(ByCssSelector.cssSelector(locator));
						break;
					default :
						System.out.println("Invalid type passed to getText."+locator);
						break;
					}
					
					if(element.isDisplayed() && element.isEnabled()){
						acctAttrb = element.getAttribute(attribute).trim();				
						Assert.assertEquals(acctAttrb, expAttbValue);				
					}		
				return acctAttrb;
			}

	
	
		//SoftAssetrs		
		public void softAssert(String actualValue, String expectedValue) {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualValue, expectedValue);	
		}
		
		// To Get attribute of WebElement	
		public String verifyTextPresent(String Bytype, String locator, String expValue) throws Exception{	
			String acctText = null;			
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to getText."+locator);
					break;
				}				
				if(element.isDisplayed() && element.isEnabled()){
					acctText = element.getText().trim();
					System.out.println(acctText);
					Assert.assertEquals(acctText, expValue);					
				}		
			return acctText;
		}
	
		// To tabbing out from the field	
		public void tabbingOut(String Bytype, String locator) throws Exception{	
			
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to getText."+locator);
					break;
				}
				element.sendKeys(Keys.TAB);				
		}			
		
		
		// This method is used to select either a radio buttons or check boxes  and wont click if it is already selected.
		public void selectRadioOrCheckbox(String Bytype, String locator) throws Exception{	
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to selectRadioOrCheckbox."+locator);
					break;
				}
				
				if(element.isDisplayed() && element.isEnabled()){
					if(!element.isSelected()){
						element.click();
			}}}
			catch(Exception e){
				logInfo("Failed!! Unable to select the specified option" + locator);		
			}
		}
		
		// This method is used to verify if the specified element is present on the DOM page.	
		public boolean verifyElementPresent(String Bytype,String locator) throws InterruptedException{
			boolean isElementPresent = false;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			try{
				switch(Bytype){
				case "xpath":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByXPath.xpath(locator)));
					break;
				case "id":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ById.id(locator)));
					break;
				case "name":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByName.name(locator)));
					break;
				case "className":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClassName.className(locator)));
					break;
				case "cssSelector":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByCssSelector.cssSelector(locator)));
					break;
				case "linkText":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLinkText.linkText(locator)));
					break;
				default :
					System.out.println("Invalid type passed to verifyElementPresent."+locator);
					break;
				}
				
				if(element.isDisplayed())
					isElementPresent = true;
	
			}catch(Exception e){
		    	e.printStackTrace();
		    	System.out.println("specified element is not present"+locator);
		    }
			return isElementPresent;
		}
			
		// This method is used to verify if the specified link text is present on the page.	
		public boolean verifyLinkPresent(String expValue) throws Exception{	
			 boolean flag = false;
			try{
			   	List<WebElement> links = driver.findElements(ByTagName.tagName("a"));
		    	for(WebElement x : links){
		    		String actValue = x.getText();
		    		if(actValue.contains(expValue)){
		    			flag = true;
		    			break;
		    		} 
		    	}
		    	 if(flag = false){
		    		 logInfo("The link "+ expValue + " : could not be found.");
		    	 }
		    	
			}catch(Exception e) {
				logInfo("Failed!! Unable to find a link " + expValue);			
			}
			 return flag;
		}				
		   	
		// This method is used to perform click operation on the specified button.	
		public void clickOnButton(String Bytype, String locator) throws Exception{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to clickOnButton."+locator);
					break;
				}
				element.click();		
			}
			catch(Exception e){
				logInfo("Failed!! Unable to click on a button."+locator);		
			}
			
		}
		
		// This method is used to double click on a specified element.	
		public void doubleClick(String Bytype, String locator ) throws Exception{
			try{
				Actions action = new Actions(driver);
				
				switch(Bytype){
				case "xpath":
					action.moveToElement(driver.findElement(ByXPath.xpath(locator))).doubleClick().build().perform();
					break;
				case "id":
					action.moveToElement(driver.findElement(ById.id(locator))).doubleClick().build().perform();
					break;
				case "name":
					action.moveToElement(driver.findElement(ByName.name(locator))).doubleClick().build().perform();
					break;
				case "className":
					action.moveToElement(driver.findElement(ByClassName.className(locator))).doubleClick().build().perform();
					break;
				case "cssSelector":
					action.moveToElement(driver.findElement(ByCssSelector.cssSelector(locator))).doubleClick().build().perform();
					break;
				case "linkText":
					action.moveToElement(driver.findElement(ByLinkText.linkText(locator))).doubleClick().build().perform();
					break;
				case "tagName":
					action.moveToElement(driver.findElement(ByTagName.tagName(locator))).doubleClick().build().perform();
					break;
				case "partialLinkText":
					action.moveToElement(driver.findElement(ByPartialLinkText.partialLinkText(locator))).doubleClick().build().perform();
					break;
				default :
					System.out.println("Invalid type passed to clickOnButton."+locator);
					break;
				}
				
			}
			catch(Exception e){
				logInfo("Failed!! To double click on " + locator);		
			}
				
		}
			
		// This method is used to click on the text area.	
		public void enterInTextArea(String Bytype, String locator, String enterTextArea) throws Exception{	
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				case "tagName":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to clickOnTextArea."+locator);
					break;
				}
				if(element.isDisplayed()){
					element.click();
					element.clear();
					element.sendKeys(enterTextArea);
				}
				
			}
			catch(Exception e){
				logInfo("Failed!! Unable to click and enter text in the text area element."+locator);		
			}
			
		}
			
		// This method is used to enter the values into a text box			
		public void enterText(String Bytype, String locator, String value) throws Exception{	
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to inputText."+locator);
					break;
				}			
				if(element.isDisplayed() && element.isEnabled()){
					element.sendKeys(value);
				}
			}
			catch(Exception e){
				logInfo("Failed!! Unable to enter a text into a textbox."+locator);		
			}
		}
				
		// This method is used to clear text box values.	
		public void clearText(String Bytype, String locator) throws Exception{	
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to inputTextClear."+locator);
					break;
				}
				
				if(element.isDisplayed() && element.isEnabled()){
					element.clear();
				}
			}
			catch(Exception e){
				logInfo("Failed!! Unable to clear the text from a textbox."+locator);		
			}
		}
		
		// This method is used to select options from a drop down list. 			
		public void selectFromDropdown(String Bytype, String locator, String selectType, String value) throws Exception{
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "tagName":
					element = driver.findElement(ByTagName.tagName(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to selectFromDropdown."+locator);
					break;
				}
				
				if(element.isDisplayed() && element.isEnabled()){
					Select select = new Select(element);
					if(selectType == "byVisibleText"){
						select.selectByVisibleText(value);
					} else if (selectType == "byValue"){
						select.selectByValue(value);
					} else if(selectType == "byIndex"){
						Integer ivalue = Integer.valueOf(value);
						select.selectByIndex(ivalue);
						
					}
				  }
			}
			catch(Exception e){
				logInfo("Failed!! Required option is not available or not select drop down list"+locator);		
			}
		}
			
		// This method is used to select options from a drop down list. 	
		public String retrieveSelectedOption(String Bytype, String locator) throws Exception{
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "tagName":
					element = driver.findElement(ByTagName.tagName(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to selectFromDropdown."+locator);
					break;
				}
								
					Select select = new Select(element);
					select.getAllSelectedOptions();
						
					
				  
			}
			catch(Exception e){
				logInfo("Failed!! Required option is not available or not select drop down list"+locator);		
			}
			return value;
		}
		

		//This method is used to get the current selected item from drop down	
		public String getCurrentSelectionFromDropdown(String Bytype, String locator) throws Exception{
			String value = null;
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "tagName":
					element = driver.findElement(ByTagName.tagName(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to selectFromDropdown."+locator);
					break;
				}
				
				if(element.isDisplayed() && element.isEnabled()){
					Select select = new Select(element);
					value = select.getFirstSelectedOption().getText().trim();
				}
			}
			catch(Exception e){
			logInfo("Failed!! Required option is not available or not select drop down list"+locator);
			}
			return value;
		}
			
		// This method is used to select either a radio buttons or check boxes.	
		public void deselectRadioOrCheckbox(String Bytype, String locator) throws Exception{	
			try{
				switch(Bytype){
				case "xpath":
					element = driver.findElement(ByXPath.xpath(locator));
					break;
				case "id":
					element = driver.findElement(ById.id(locator));
					break;
				case "name":
					element = driver.findElement(ByName.name(locator));
					break;
				case "className":
					element = driver.findElement(ByClassName.className(locator));
					break;
				case "cssSelector":
					element = driver.findElement(ByCssSelector.cssSelector(locator));
					break;
				default :
					System.out.println("Invalid type passed to selectRadioOrCheckbox."+locator);
					break;
				}
				
				if(element.isDisplayed() && element.isEnabled()){
					if(element.isSelected()){
					element.click();
			}}}
			catch(Exception e){
				logInfo("Failed!! Unable to select the specified option" + locator);		
			}
		}
			
		    				
		// This method is used to wait until page being loaded.	
		public void waitForPageToLoad()
		  {
		     (new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME))).until(new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver d) {
		        return (((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		      }
		    });
		 }
		
		
		public void threadSleep(int seconds) throws InterruptedException{
			
			Thread.sleep(seconds);
			
			
		}
		 // This method is used to scroll the screen to particular object.
		 public void scrollDown(String Bytype, String locator) throws Exception{
			 try{
				 js = (JavascriptExecutor)driver;        				 
				switch(Bytype){
					case "xpath":
						element = driver.findElement(ByXPath.xpath(locator));
						break;
					case "id":
						element = driver.findElement(ById.id(locator));
						break;
					case "name":
						element = driver.findElement(ByName.name(locator));
						break;
					case "className":
						element = driver.findElement(ByClassName.className(locator));
						break;
					case "cssSelector":
						element = driver.findElement(ByCssSelector.cssSelector(locator));
						break;
					case "linkText":
						element = driver.findElement(ByLinkText.linkText(locator));
						break;	
					case "partialLinkText":
						element = driver.findElement(ByPartialLinkText.partialLinkText(locator));
						break;	
					default :
						System.out.println("Invalid type passed to scroll."+locator);
						break;
					}
					
					if(element.isDisplayed()){
						 js.executeScript("arguments[0].scrollIntoView(true);", element);						
						 int  size = (int)js.executeScript("return window.innerHeight;",element);
					
					}
				}
				catch(Exception e){
					logger.error("Failed!! Unable to find element "+locator);		
				}
		 }
		 			
		// This method is being used to accept javascript alerts / confirmations		
		public void confirmAlert(){			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			}
			
			// This method is being used to dismiss javascript alerts / confirmations		
			public void dismissAlert() throws Exception{			
			Alert alert = driver.switchTo().alert();
			alert.dismiss();			
			}
				
				    
		 // This method is used to hover mouse on object.	
	  	 public void hoverOnElementAndClick(String Bytype, String locator) throws Exception{
			 try{				 
				 Actions builder = new Actions(driver);				
				switch(Bytype){
					case "xpath":
						element = driver.findElement(ByXPath.xpath(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "id":
						element = driver.findElement(ById.id(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "name":
						element = driver.findElement(ByName.name(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "className":
						element = driver.findElement(ByClassName.className(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "cssSelector":
						element = driver.findElement(ByCssSelector.cssSelector(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
						break;
					case "linkText":
						element = driver.findElement(ByLinkText.linkText(locator));
						builder.moveToElement(element).build().perform();
						builder.click();
					case "partialLinkText":
						element = driver.findElement(ByPartialLinkText.partialLinkText(locator));
						builder.moveToElement(element).build().perform();
						builder.click();	
					default :
						System.out.println("Invalid type passed to clickOnButton."+locator);
						break;
					}
					
			 	}
				catch(Exception e){
					logger.error("Failed!! Unable to click on a button."+locator);		
				}
		 }
	 
		 //This method is used drag and drop the webElement from location another location. 	 
		 public void dragAndDropAction(WebElement source, WebElement target) throws Exception{				
				Actions builder = new Actions(driver);
				Action drag = builder.clickAndHold(source).
						moveToElement(target).
						release(target).
						build();
				drag.perform();			
			}			 
	 
		 /**Store Attribute or Data in passed property file **/	 
		 public void setAttributeOptionsInProperty(String propertyFileName, String propertyName, String locatorValue) throws ConfigurationException {
				logInfo("Entered into setAttributeOptionsInProperty() method.");			
				String propFilePath = providePropFilePath()+propertyFileName+propFilePathAft;	
				PropertiesConfiguration conf = new PropertiesConfiguration(propFilePath);
				conf.setProperty(propertyName, locatorValue);
				conf.save();			
			}
			 
		 public String getAttributeOptionsFromProperty(String propertyFileName, String propertyName)  {
			    logInfo("Entered into getAttributeOptionsFromProperty() method.");				
			   // propFilePath = projectPath + "/properties/" + propertyFileName + ".properties";	
			    String propFilePath = providePropFilePath()+propertyFileName+propFilePathAft;	
				try {
					File file = new File(propFilePath);
					fileInput = new FileInputStream(file);
					configProp.load(fileInput);
					// fileInput.close();
	
					Enumeration enuKeys = configProp.keys();
					while (enuKeys.hasMoreElements()) {
						key = (String) enuKeys.nextElement();
						if(key.trim().equalsIgnoreCase(propertyName.trim())){
							value = configProp.getProperty(key);
							break;
						}
					}
				
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
						return value;
			}
			 
	 	public int storeDataInProrpertyFile(String sheetName, String testCaseId) throws IOException, ConfigurationException{
			logInfo("Entered into  storeDataInProrpertyFile() method");
			//Create an object of File class to open xlsx file					
		    File file =    new File(provideExcelCityPath());
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook wbook = new HSSFWorkbook(inputStream);
		    //Read sheet inside the workbook by its name
		    Sheet xelitsSheet = wbook.getSheet(sheetName);	
		    //Find number of rows in excel file		    
		    Row row = xelitsSheet.getRow(0);
		    short nthCoulmns=0;
		    int totalRows = xelitsSheet.getLastRowNum()-xelitsSheet.getFirstRowNum();		   
		    int totalCoulmns = row.getLastCellNum();
		    boolean isPresentTC=false;
		    int j=0;
		    for(int i=0;i<=totalRows; i++) {		    		
		    		Cell eachCell = xelitsSheet.getRow(i).getCell(j);	
		    		String actCellValue= eachCell.getStringCellValue().trim();		    		
		    		if(actCellValue.equalsIgnoreCase(testCaseId)){
		    			isPresentTC=true;
		    			nthCoulmns =xelitsSheet.getRow(i).getLastCellNum();
		    			for(int k=1;k<nthCoulmns;k++) {		    			
		    				Cell city = xelitsSheet.getRow(i).getCell(k);		    				
		    				String expCity=city.getStringCellValue();
		    				setAttributeOptionsInProperty(sheetName, testCaseId+(k+1), expCity);
		    				    				
		    			}
		    			break;
		    		}
		    }if(!isPresentTC) {
		    	Assert.assertTrue(isPresentTC,testCaseId+" testcaseId is not present");
		    }
		    return nthCoulmns;
		 } 
	 	
	 	public int storeDataInProrpertyFile_old(String sheetName, String testCaseId) throws IOException, ConfigurationException{
			logInfo("Entered into  storeDataInProrpertyFile() method");
			//Create an object of File class to open xlsx file					
		    File file =    new File(provideExcelCityPath());
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook wbook = new HSSFWorkbook(inputStream);
		    //Read sheet inside the workbook by its name
		    Sheet xelitsSheet = wbook.getSheet(sheetName);	
		    //Find number of rows in excel file		    
		    Row row = xelitsSheet.getRow(0);
		    short nthCoulmns=0;
		    int totalRows = xelitsSheet.getLastRowNum()-xelitsSheet.getFirstRowNum();		   
		    int totalCoulmns = row.getLastCellNum();
		    boolean isPresentTC=false;
		    int j=0;
		    for(int i=0;i<=totalRows; i++) {		    		
		    		Cell eachCell = xelitsSheet.getRow(i).getCell(j);	
		    		String actCellValue= eachCell.getStringCellValue().trim();		    		
		    		if(actCellValue.equalsIgnoreCase(testCaseId)){
		    			isPresentTC=true;
		    			nthCoulmns =xelitsSheet.getRow(i).getLastCellNum();
		    			for(int k=1;k <nthCoulmns;k++) {
		    				Cell city = xelitsSheet.getRow(i).getCell(k);
		    				String expCity=city.getStringCellValue();
		    				setAttributeOptionsInProperty(sheetName, testCaseId+(k+1), expCity);
		    				
		    				
		    			}
		    			
		    			break;
		    		}
		    }if(!isPresentTC) {
		    	Assert.assertTrue(isPresentTC,testCaseId+" testcaseId is not present");
		    }
		    return nthCoulmns;
		 } 
		
		
		public int getRowsCoutFromSheet(String sheetName) throws IOException, ConfigurationException{
			logInfo("Entered into  storeDataInProrpertyFile() method");
		    //Create an object of File class to open xlsx file			
			String excelFilePath = projectPath + "/attributeData/productDetails.xls";
		    File file =    new File(excelFilePath);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook wbook = new HSSFWorkbook(inputStream);
		    //Read sheet inside the workbook by its name
		    Sheet smartSheet = wbook.getSheet(sheetName);	
		    //Find number of rows in excel file		    
		    Row row = smartSheet.getRow(0);
		    int totalRows = smartSheet.getLastRowNum()-smartSheet.getFirstRowNum();
			return totalRows;
		   
		    } 				
			
		/** Navigates to home page*/
		public void homePage() throws Exception {
	        logInfo("Enter into homePage method");
	        driver.navigate().to(appUrl);
	        
		}				
				
		public void uploadFile(String fileType,String cssLocator) throws Exception{
			logInfo("Entered into  uploadFile() method");
			switch(fileType){
		 	
			case "Image":
				driver.findElement(ByCssSelector.cssSelector(cssLocator)).sendKeys(uploadFilePath);
				break;
			default :
				System.out.println("Invalid File Type mentiods.");
				break;	
			
			}	
		}				
	

		public void navigateTabs() throws Exception {					
			logInfo("Enter into navigateTabs() method");
			List<WebElement> tabs = driver.findElements(org.openqa.selenium.By.xpath(navTabs));
			System.out.println("No of tabs : "+tabs.size());
			for(WebElement tab:tabs ) {
				tab.click();						
			}
			
		}	
				
		public void navigateToModule(String expMenuPage) throws Exception {
			logInfo("Enter into navigateToModule() method");
			wdWait("xpath", navTabs);
			List<WebElement> tabs = driver.findElements(org.openqa.selenium.By.xpath(navTabs));			
			boolean isPagePresent=false;
			for(WebElement tab:tabs ) {
			tab.click();					
			wdWait("cssSelector", dashboardTitle);
			String actPage= getText("cssSelector", dashboardTitle);				
			if(actPage.equalsIgnoreCase(expMenuPage)) {
				isPagePresent=true;
				waitTilldisableOfElement(10);				
				break;					
					}
			}if(!isPagePresent) {
			Assert.assertTrue(isPagePresent, expMenuPage+ " is not present.");
			}		
		}
				
		public void selectMenuIconInSite(String menuIcon) throws Exception {
			logInfo("Entered into selectMenuIconInSite() method.");
			waitTilldisableOfElement(7);			
			wdWait("cssSelector", menuIcons);
			boolean isPresent = false;
			List <WebElement> menu = driver.findElements(org.openqa.selenium.By.cssSelector(menuIcons));
			for(WebElement icons: menu) {
				String selectIcons = icons.getAttribute("src");				
				if(selectIcons.contains(menuIcon)) {
					isPresent=true;						
					icons.click();
					waitTilldisableOfElement(10);
					break;					
				}
			}if(!isPresent) {
				Assert.assertTrue(isPresent,menuIcon +" is not present");
			}					
		}
				
		public void selectExistingSite(String expectedSiteName) throws Exception {
			logInfo("Entered into selectExistingSite() method.");
			Actions act = new Actions(driver);
			String expSiteName=expectedSiteName.toUpperCase().trim();
			wdWait("xpath", sitesList);
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(sitesList));
			boolean isSitePrtesent=false;			
			for(int i=1;i<=sites.size();i++) {
				WebElement site= driver.findElement(org.openqa.selenium.By.xpath(sitesListBfr+i+sitesListAft));
				scrollDown("xpath", sitesListBfr+i+sitesListAft);				
				String actSiteName= site.getText().trim();	
				threadSleep(1000);				
					if(actSiteName.equals(expSiteName)) {
					isSitePrtesent=true;					
					sleep(5000);
					site.click();
					//act.doubleClick(site).build().perform();
					break;
					
				}
			}if(!isSitePrtesent) {
				Assert.assertTrue(isSitePrtesent, expSiteName+ " is not present");
			}			
		}
		
		public void selectSiteFromAllSites(String expectedSiteName) throws Exception {
			logInfo("Entered into selectSiteFromAllSites() method.");
			Actions act = new Actions(driver);
			String expSiteName=expectedSiteName.toUpperCase().trim();
			wdWait("xpath", sitesList);
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(newSiteList));
			boolean isSitePrtesent=false;			
			for(int i=1;i<=sites.size();i++) {
				WebElement site= driver.findElement(org.openqa.selenium.By.xpath(sitesListNewBfr+i+sitesListAft));
				scrollDown("xpath", sitesListBfr+i+sitesListAft);				
				String actSiteName= site.getText().trim();				
					if(actSiteName.equals(expSiteName)) {
					isSitePrtesent=true;					
					sleep(5000);
					site.click();
					//act.doubleClick(site).build().perform();
					break;
					
				}
			}if(!isSitePrtesent) {
				Assert.assertTrue(isSitePrtesent, expSiteName+ " is not present");
			}			
		}
		
		public void searchAndSelectExistingSite(String expectedSiteName) throws Exception {
			logInfo("Entered into searchAndSelectExistingSite() method.");
			sleep(3000);
			wdWait("cssSelector", umSearch);
			String expSiteName=expectedSiteName.toUpperCase().trim();
			enterText("cssSelector", umSearch,expSiteName);			
			wdWait("xpath", sitesList);
			sleep(7000);
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(sitesList));					
			boolean isSitePrtesent=false;
			for(int i=1;i<=sites.size();i++) {
				WebElement site= driver.findElement(org.openqa.selenium.By.xpath(sitesListBfr+i+sitesListAft));
				scrollDown("xpath", sitesListBfr+i+sitesListAft);				
				String actSiteName= site.getText().trim();					
					if(actSiteName.equals(expSiteName)) {
					isSitePrtesent=true;					
					sleep(5000);
					site.click();					
					break;					
				}
			}if(!isSitePrtesent) {
				Assert.assertTrue(isSitePrtesent, expSiteName+ " is not present");
			}	
			
		}
		
		public void selectSiteByWildSearch(String expectedSiteName) throws Exception {
			logInfo("Entered into selectExistingSite() method.");
			sleep(6000);
			wdWait("cssSelector", umSearch);
			String expSiteName=expectedSiteName.toUpperCase().trim();
			enterText("cssSelector", umSearch,expSiteName);			
			wdWait("xpath", sitesList);
			sleep(10000);
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(sitesList));					
			boolean isSitePrtesent=false;
			for(int i=1;i<=sites.size();i++) {
				WebElement site= driver.findElement(org.openqa.selenium.By.xpath(sitesListBfr+i+sitesListAft));
				scrollDown("xpath", sitesListBfr+i+sitesListAft);				
				String actSiteName= site.getText().trim().toUpperCase();					
					if(actSiteName.contains(expSiteName)) {
					isSitePrtesent=true;					
					sleep(5000);
					site.click();					
					break;					
				}
			}if(!isSitePrtesent) {
				Assert.assertTrue(isSitePrtesent, expSiteName+ " is not present");
			}	
			
		}
		
		
		public String selectAndGetRamdomlySite() throws Exception {
			logInfo("Entered into selectAndGetRamdomlySite() method.");
			Actions act = new Actions(driver);
			//String expSiteName=expectedSiteName.toUpperCase().trim();
			wdWait("xpath", sitesList);
			String actSiteName = null;
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(newSiteList));
			 if(sites.size()==0) {
				 String noResult= getText(css, noReslt);				
				 Assert.assertEquals(noResult, noResltText);
			 	}else if(sites.size()==1) {
				WebElement site= driver.findElement(org.openqa.selenium.By.xpath(sitesListNewBfr+1+sitesListAft));
				actSiteName= site.getText().trim();									
				sleep(5000);
				site.click();
				}else {
					int i=TestBase.generateRandomNumberInRange(1, sites.size());						
						WebElement site= driver.findElement(org.openqa.selenium.By.xpath(sitesListNewBfr+i+sitesListAft));
						scrollDown("xpath", sitesListBfr+i+sitesListAft);				
						actSiteName= site.getText().trim();									
							sleep(5000);
							site.click();
				}
			
					return actSiteName;
							
		}
		
		public void noResults() throws Exception {
			logInfo("Entered into selectAndGetRamdomlySite() method.");			
			wdWait("xpath", sitesList);			
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(newSiteList));
			 if(sites.size()==0) {
				 String noResult= getText(css, noReslt);
				 System.out.println("noResult "+noResult);
				 Assert.assertNotEquals(noResult, noResltText);
			 	}							
		}
		
		public int getTotalSitesFromGrid() throws Exception {
			logInfo("Entered into getTotalSitesFromGrid() method.");	
			sleep(10000);
			wdWait("xpath", sitesList);
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(newSiteList));
			int i=sites.size();	
			return i;			
		}
		
		public int getTotalSitesFromList() throws Exception {
			logInfo("Entered into getTotalSitesFromList() method.");	
			sleep(10000);
			wdWait(css, siteListView);
			List <WebElement> sites = driver.findElements(org.openqa.selenium.By.cssSelector(siteListView));
			int i=sites.size();	
			return i;			
		}
		
		public void confirmPopup(String expConfMessage) throws Exception {
		logInfo("Entered into confirmPopup() method.");	
			SoftAssert sa = new SoftAssert();
			sleep(10000);
			waitTilldisableOfElement(10);
			wdWait("cssSelector", confMsg);
			String conMsg=getText("cssSelector", confMsg);				
			sa.assertEquals(conMsg, expConfMessage);
			clickOnButton("xpath", dialogYes);	
			sa.assertAll();
		}
		
		public void sleep(int value) throws InterruptedException {
			Thread.sleep(value);
			}	
		
		public void refreshScreen() {
			logInfo("Entered into refreshScreen() method.");	
			driver.navigate().refresh();
			
		}
		
		public String date_Time(String location){
			logInfo("Entered into date_Time() method.");
			Date date = new Date();			
			DateFormat df = new SimpleDateFormat("yyyy, M, d, H, m");				
			df.setTimeZone(TimeZone.getTimeZone(location));				
			return  df.format(date);		
		}
		
		public String getDate(String location){
			logInfo("Entered into getDate() method.");
			Date date = new Date();			
			DateFormat df = new SimpleDateFormat("dd/MM/YYYY");				
			df.setTimeZone(TimeZone.getTimeZone(location));				
			return  df.format(date);		
		}
		
		
		//to retreive future time based on given location.		
		public String getFutureTime(String location, int expHours)throws Exception{
			logInfo("Entered into getFutureTime() method.");
			Date date = new Date();				 
			DateFormat df = new SimpleDateFormat("yyyy,M,d,H,m");				
			df.setTimeZone(TimeZone.getTimeZone(location));		
			Calendar c = Calendar.getInstance();
	        c.setTime(date);
			c.add(Calendar.HOUR, expHours);
			 Date currentDatePlusSix = c.getTime();
			 return df.format(currentDatePlusSix);
			
		}
		public String getTimerTime(int hours,int min)throws Exception{
			logInfo("Entered into getTimerTime() method.");
			int expHor = hours-1;
			String ExpTime = null;
			if(min==59) {
			ExpTime = expHor+":"+min ;
			}
			else {
				ExpTime = expHor+":58" ;
			}
			
			return ExpTime;
		}
		
		
		public String getNextDate(int period,String currentDate) throws ParseException{
			logInfo("Entered into date_Time() method.");
		     Calendar cd = Calendar.getInstance();
		     SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/YYYY");
		     Date date = formatter.parse(currentDate);
		     cd.setTime(date);
		     cd.add(Calendar.DAY_OF_MONTH, period);
		     String expDate = formatter.format(cd.getTime());
		     return expDate;
		}
		

		
		public String getDay(String location) throws ParseException{
			logInfo("Entered into getDay() method.");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date myDate = sdf.parse(getDate(location));			
			sdf.applyPattern("EEE");
			String week = sdf.format(myDate).toUpperCase().substring(0,2);			
			return  week;		
		}
		
		public String getDateAndTime(String location){
			logInfo("Entered into getDateAndTime() method.");
			Date date = new Date();			
			DateFormat df = new SimpleDateFormat("MMMMM d, yyyy h:mm a");				
			df.setTimeZone(TimeZone.getTimeZone(location));				
			return  df.format(date);		
		}
				
		public String provideExcelCityPath() {
			logInfo("Entered into provideExcelCityPath() method.");
			String os = System.getProperty("os.name").toLowerCase();	
			String excelCityPath=null;
			if(os.contains("win")) {				  
				  excelCityPath = excelCityPath_Win;				 
			  }else if(os.contains("mac")||os.contains("linux")||(os.contains("ubuntu"))){				
				  excelCityPath = excelCityPath_Mac;				  
			  }
			return excelCityPath;			
		}
		
		public String providePropFilePath() {
			logInfo("Entered into providePropFilePath() method.");
			String os = System.getProperty("os.name").toLowerCase();	
			String propFilePathBfr=null;
			if(os.contains("win")) {				  
				propFilePathBfr = propFilePathBfr_Win;				 
			  }else if(os.contains("mac")||os.contains("linux")||(os.contains("ubuntu"))){				
				  propFilePathBfr = propFilePathBfr_Mac;				  
			  }
			return propFilePathBfr;			
		}
		
		
		
		
}