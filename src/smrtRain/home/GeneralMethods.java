package smrtRain.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.lib.TestBase;

import smrtRain.sites.SiteMethods;


public class GeneralMethods extends TestBase{	
	SoftAssert softAssert = new SoftAssert();	
	SiteMethods sm = new SiteMethods();
	public void loginCredenditals(String emailId, String password) throws Exception {
		logInfo("Enter into loginCredenditals() method");
		enterText("cssSelector", emaiField, emailId);
		enterText("cssSelector", pwdField, password);
		wdWait("cssSelector", loginBtn);
		submitObject("cssSelector", loginBtn);
		Thread.sleep(10000);
		wdWait("cssSelector", homeDB);
		String home = getText("cssSelector", homeDB);
		if((home.equalsIgnoreCase("Home"))||(home.equalsIgnoreCase("Casa"))){
			
		}else {
			Assert.assertNotSame(home, "Home");			
		}		
		sleep(10000);
		softAssert.assertAll();
	}
	
	
	/*********************    HOME        ***********************/
	
	
	public void editProfile() throws Exception {
		logInfo("Enter into changeProfileLanguage() method");
		clickOnObject("cssSelector", profiler);
		wdWait("cssSelector", profile);
		clickOnObject("cssSelector", profile);
		wdWait("cssSelector", editIcon);
		clickOnObject("cssSelector", editIcon);
		//chooseLanguage(expLang);
	}
	
	public void chooseLanguage(String expLang) throws Exception {
		logInfo("Enter into chooseLanguage() method");
		wdWait("cssSelector", chooseDp);	
		sleep(6000);
		int lanSize=driver.findElements(By.cssSelector(chooseDp)).size();
		if(lanSize==0){			
			selectMenuIconInSite(iconSiteHome);
			Assert.assertNotNull(expLang);
		}else {		
		clickOnObject("cssSelector", chooseDp);		
		sleep(4000);
		boolean isPresent=false;
		 List <WebElement> opt=driver.findElements(By.cssSelector(timeZoneOption));
		 int size=opt.size();		 
			 for(int i=1;i<=size;i++) {				 
				 WebElement opTypeOpt=driver.findElement(By.cssSelector(opTypeBfr+i+opTypeAfr));
				 String opName = opTypeOpt.getText().trim();				 
				 if(opName.equalsIgnoreCase(expLang)) {
						 isPresent=true;						 
						 opTypeOpt.click();
						 sleep(3000);
						 clickOnObject("cssSelector", proUpdate);
						 				 
						 break;
					 }
				 }if(!isPresent) {
					 clickOnObject("cssSelector", firstOption);
					 clickOnObject("cssSelector", proUpdate);
					 
					 Assert.assertTrue(isPresent, expLang+ " is not persent");
				 }
		}
		
	}
	
	public void getCardTitle(String expTitle) {
		logInfo("Enter into getCardTitle() method");
		int cardSize=driver.findElements(By.xpath(cardTitle)).size();
		boolean isPresent = false;
		for(int i=1;i<=cardSize;i++) {
			String title= driver.findElement(By.xpath(cardTitleBfr+i+cardTitleAfr)).getText();			
			if(title.equalsIgnoreCase(expTitle)) {
				isPresent=true;				
				break;				
			}}if(isPresent==false) {
				Assert.assertTrue(isPresent, expTitle+" is not found." );
			}
		
		
		
	}
	
	public long getDaysDetails(String expTitle, String expButton) throws Exception {
		logInfo("Enter into getDaysDetails() method");		
		long total = 0;
		int cardSize=driver.findElements(By.xpath(cardTitle)).size();
		boolean isPresent = false;
		for(int i=1;i<=cardSize;i++) {
			String title= driver.findElement(By.xpath(cardTitleBfr+i+cardTitleAfr)).getText();					
			if(title.equalsIgnoreCase(expTitle)) {
				isPresent=true;
				boolean isdaysBtnPresent = false;
				int btns= driver.findElements(By.xpath(cardTitleBfr+i+cardBtnsList)).size();
				for(int j=1;j<=btns; j++) {
					WebElement btn=driver.findElement(By.xpath(cardTitleBfr+i+cardBtnsBfr+j+zonesEnd));
					String eachBtn=btn.getText().trim();					
					if(eachBtn.contains(expButton)) {
						isdaysBtnPresent=true;
						btn.click();
						btn.click();
						String tot = getText("xpath", cardTitleBfr+i+cardCount);
						
						tot=tot.replaceAll("\\D+", "");
						total = Long.parseLong(tot);						
						break;
						
					}}if(!isdaysBtnPresent) {
						Assert.assertTrue(isdaysBtnPresent,expButton);
					}
					
				break;				
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, expTitle+" is not found." );
		}
			
		return  total;
		
	}
	
	
	public void calculateSavedDetails() throws Exception {
		logInfo("Enter into verifySavedDetails() method");		
		long data7 = getDaysDetails(cardMoneyText, days7);
		long data30 = getDaysDetails(cardMoneyText, days30);
		long dataYear = getDaysDetails(cardMoneyText, daysYear);
		
		if(dataYear>=data30 && data30>=data7) {
			
		}else {
			System.err.println("7 Days data is greater than 30 days or Current Year");
		}
		
		
	}
	
	
	public void moneySavedDetailsOfSpanish() throws Exception {
		logInfo("Enter into moneySavedDetailsOfSpanish() method");		
		long data7 = getDaysDetails(spMoney, spLast7Days);
		long data30 = getDaysDetails(spMoney, spLast30Days);
		long dataYear = getDaysDetails(spMoney, spCurrentYear);
		
		if(dataYear>=data30 && data30>=data7) {
			
		}else {
			System.err.println("7 Days data is greater than 30 days or Current Year");
		}
		
		
	}
	
	public void waterSavedDetailsOfSpanish() throws Exception {
		logInfo("Enter into moneySavedDetailsOfSpanish() method");		
		long data7 = getDaysDetails(spWaterSaved, spLast7Days);
		long data30 = getDaysDetails(spWaterSaved, spLast30Days);
		long dataYear = getDaysDetails(spWaterSaved, spCurrentYear);
		
		if(dataYear>=data30 && data30>=data7) {
			
		}else {
			System.err.println("7 Days data is greater than 30 days or Current Year");
		}
		
		
	}
	
	public void validateDayLabel(String expTitle, String expButton) throws Exception {
		logInfo("Enter into validateDayLabel() method");		
		int cardSize=driver.findElements(By.xpath(cardTitle)).size();
		boolean isPresent = false;
		String eachBtn = null;
		String title = null;
		for(int i=1;i<=cardSize;i++) {
			title= driver.findElement(By.xpath(cardTitleBfr+i+cardTitleAfr)).getText();					
			if(title.equalsIgnoreCase(expTitle)) {
				isPresent=true;
				boolean isdaysBtnPresent = false;
				int btns= driver.findElements(By.xpath(cardTitleBfr+i+cardBtnsList)).size();
				for(int j=1;j<=btns; j++) {
					WebElement btn=driver.findElement(By.xpath(cardTitleBfr+i+cardBtnsBfr+j+zonesEnd));
					eachBtn=btn.getText().trim();					
					if(eachBtn.equalsIgnoreCase(expButton)) {
						isdaysBtnPresent=true;
						btn.click();
						btn.click();											
						break;
						
					}}if(!isdaysBtnPresent) {
						Assert.assertEquals(eachBtn,expButton);
					}
					
				break;				
			}
		}if(!isPresent) {
			Assert.assertEquals(title, expTitle );
		}		
		
	}
	
	
	public void confirmUpdatedProfile(String expSuccessMsg) throws Exception {
		logInfo("Entered into confirmModalBox() method.");
		String alertMsg = null;					
		wdWait("cssSelector", irrSuccsMsg);		
		alertMsg= getText("cssSelector", irrSuccsMsg);				
		if(alertMsg.equalsIgnoreCase(expSuccessMsg)) {			
			Assert.assertEquals(alertMsg, expSuccessMsg);			
			clickOnButton("cssSelector", succssOkBtn);	
			sleep(7000);			
			}else {
			sleep(7000);	
			clickOnButton("cssSelector", succssOkBtn);				
			Assert.assertEquals(alertMsg, expSuccessMsg);
		}	
		
	}
	
	
	
	

	
	
	
}
