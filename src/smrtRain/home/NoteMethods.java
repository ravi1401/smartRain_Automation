package smrtRain.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import smrtRain.settings.SettingMethods;


public class NoteMethods extends SettingMethods{
	
	SoftAssert softAssert = new SoftAssert();	
	
	public void validateNoteObjects() throws Exception {
		logInfo("Enter into validateNoteObjects() method");
		SoftAssert sa = new SoftAssert();	
		wdWait("cssSelector", noteLabel);
		String note=driver.findElement(By.cssSelector(noteLabel)).getText();	
		String view=driver.findElement(By.cssSelector(noteViewAll)).getText();
		sa.assertEquals(note,noteText );
		sa.assertEquals(view,noteViewAllText);		
		sa.assertAll();
	}
	
	public void selectViewAll() throws Exception {
		wdWait("cssSelector", noteViewAll);
		clickOnObject("cssSelector", noteViewAll);
	}
	
	public void selectAddButton() throws Exception {
		logInfo("Enter into selectAddButton() method");
		wdWait("cssSelector", noteBtns);
		scrollDown("cssSelector", noteBtns);
		clickOnButton("cssSelector", noteBtns);		
	}
	
	public void createNoteDetails(String title, String description) throws Exception {
		logInfo("Enter into createNoteDetails() method");
		sleep(2000);		
		wdWait("cssSelector", noteDesc);
		enterText("cssSelector", umInitUser,title);
		WebElement titleField=driver.findElement(By.cssSelector(umInitUser));
		titleField.sendKeys(Keys.TAB);
		//title.sendKeys(Keys.TAB);
		enterText("cssSelector", noteDesc, description);		
		//clickOnObject("xpath", noteDpSite);		
	}
	
	public void expandTagDropdown() throws Exception {
		logInfo("Enter into expandTagDropdown() method");
		wdWait("xpath", noteDpTags);
		clickOnObject("xpath", noteDpTags);
	}
	
	public void selectTag(String expTag) throws Exception {
		logInfo("Enter into selectTag() method");			
		boolean isTagPresent=false;
		List<WebElement> opt=driver.findElements(By.cssSelector(noteOptions));
		for(WebElement option:opt) {
			String actName=option.getText().trim();			
			if(actName.equalsIgnoreCase(expTag)) {
				isTagPresent=true;				
				option.click();							
				WebElement desp= driver.findElement(By.cssSelector(umInitUser));		
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", desp);
				sleep(5000);				
				desp.sendKeys(Keys.TAB);
				desp.sendKeys(Keys.TAB);
				desp.sendKeys(Keys.TAB);
				desp.sendKeys(Keys.TAB);
				desp.sendKeys(Keys.TAB);	
				
				break;
			}
		}if(!isTagPresent) {
			clickOnObject("cssSelector", umInitUser);
			Assert.assertTrue(isTagPresent, expTag+" is not found");
		}
		
	}
	
	public void selectSite(String expSite) throws Exception {
		logInfo("Enter into selectSite() method");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		sleep(10000);
		WebElement siteDP=driver.findElement(By.cssSelector(noteDpSite));	
		
		executor.executeScript("arguments[0].click();", siteDP);	
		siteDP.click();
		sleep(5000);
//		boolean isSitePresent=false;
//		List<WebElement> opt=driver.findElements(By.cssSelector(noteOptions));
//		System.out.println("Size: "+opt.size());
//		for(int i=2;i<=opt.size()+1;i++) {
//			WebElement option=driver.findElement(By.cssSelector(noteBfrOption+i+noteAftOption));
//			String actName=option.getText().trim();			
//		    scrollDown("cssSelector", noteBfrOption+i+noteAftOption);		    
//			if(actName.equalsIgnoreCase(expSite)) {
//				isSitePresent=true;	
//				WebElement tag= driver.findElement(By.cssSelector(noteBfrOption+i+noteAftOption));
//				
//				executor.executeScript("arguments[0].click();", tag);	
//				break;
//			}
//		}if(!isSitePresent) {
//				clickOnObject("cssSelector", noteFirstOption);
//				Assert.assertTrue(isSitePresent, expSite+" is not found");
//			}
		
	}
	
	public void createNoteBtn() throws Exception {
		logInfo("Enter into createNoteBtn() method");
		sleep(5000);
		WebElement create= driver.findElement(By.cssSelector(noteCreate));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", create);		
	}
	
	public void confirmNote() throws Exception {
		logInfo("Enter into confirmNote() method");	
		SoftAssert sa = new SoftAssert();
		wdWait("xpath", noteConfMsg);
		String header= getText("xpath", noteConfMsg);
		System.out.println(header);
		//String subHeader= getText("xpath", noteConfSubMsg);
		sa.assertEquals(header, noteConfsubMsgText);
		//sa.assertEquals(subHeader, noteConfsubMsgText);
		clickOnButton("cssSelector", noteConfClose);	
		driver.navigate().refresh();
		sa.assertAll();
		
	}
	
	public void validateTagsUnderHomeScreen(String expSite, String title, String descp) throws Exception {
		logInfo("Enter into validateTagsUnderHomeScreen() method");
		sleep(10000);
		wdWait("xpath", noteList);
		boolean isSitePresent=false;
		int siteList= driver.findElements(By.xpath(noteList)).size();
		for(int i=1;i<=siteList;i++) {
			String actSite=driver.findElement(By.xpath(noteListBfr+i+noteListAfr)).getText().trim();
			scrollDown("xpath", noteListBfr+i+noteListAfr);
			if(actSite.equalsIgnoreCase(expSite)) {
				isSitePresent=true;				
				int titleCount=driver.findElements(By.xpath(noteListBfr+i+noteListTitle)).size();
				System.out.println("titleCount "+titleCount);
				boolean isTitlePresent=false;
				for(int k=1;k<=titleCount;k++) {
				String titleMsg=driver.findElement(By.xpath(noteListBfr+i+noteListDescpMid+k+noteListTitleAft)).getText().trim();
				System.out.println("titleMsg :"+titleMsg);
				if(titleMsg.equalsIgnoreCase(title)){
					isTitlePresent=true;
					boolean isSubPresent=false;
					List<WebElement> subMsg=driver.findElements(By.xpath(noteListBfr+i+noteListDescp));
					int subSize= subMsg.size();
					System.out.println("subSize :"+subSize);
					for(int j=1;j<=subSize;j++) {
						String titleSubMsg=driver.findElement(By.xpath(noteListBfr+i+noteListDescpMid+j+noteListDescpAft)).getText().trim();
						System.out.println("Note SubMsg :"+titleSubMsg);
						if(titleSubMsg.equalsIgnoreCase(descp)) {
							isSubPresent=true;	
							System.out.println("entered here'");
							break;		
							}}if(!isSubPresent) {
								closeNotes();
								Assert.assertEquals(isSubPresent, descp);
							}
					
					break;
				}
				}if(!isTitlePresent) {
					closeNotes();
					Assert.assertTrue(isTitlePresent, title);
				}
				
						
				break;
			}
			
		}
		if(!isSitePresent) {
			
			Assert.assertTrue(isSitePresent,expSite+ " -site is not present.");
		}
		
	}
	
	
	public void validateTagsUnderSite(String title, String descp) throws Exception {
		logInfo("Enter into validateTagsUnderSite() method");
		sleep(10000);
		int i=1;
		wdWait("xpath", noteList);				
				int titleCount=driver.findElements(By.xpath(noteListBfr+i+noteListTitle)).size();
				System.out.println("titleCount "+titleCount);
				boolean isTitlePresent=false;
				for(int k=1;k<=titleCount;k++) {
				String titleMsg=driver.findElement(By.xpath(noteListBfr+i+noteListDescpMid+k+noteListTitleAft)).getText().trim();
				System.out.println("titleMsg :"+titleMsg);
				if(titleMsg.equalsIgnoreCase(title)){
					isTitlePresent=true;
					boolean isSubPresent=false;
					List<WebElement> subMsg=driver.findElements(By.xpath(noteListBfr+i+noteListDescp));
					int subSize= subMsg.size();
					System.out.println("subSize :"+subSize);
					for(int j=1;j<=subSize;j++) {
						String titleSubMsg=driver.findElement(By.xpath(noteListBfr+i+noteListDescpMid+j+noteListDescpAft)).getText().trim();
						System.out.println("Note SubMsg :"+titleSubMsg);
						if(titleSubMsg.equalsIgnoreCase(descp)) {
							isSubPresent=true;	
							System.out.println("entered here'");
							break;		
							}}if(!isSubPresent) {
								closeNotes();
								Assert.assertEquals(isSubPresent, descp);
							}
					
					break;
				}
				}if(!isTitlePresent) {
					closeNotes();
					Assert.assertTrue(isTitlePresent, title);
				}			
			}
			
		
		
		
	
	
	public void closeNotes() {		
		List<WebElement> btns=driver.findElements(By.xpath(noteClose));
		for(WebElement btn :btns) {
			String name= btn.getText().trim();
			if(name.equalsIgnoreCase("Close")) {
				btn.click();
				break;
			}
		}
		
	}
	

	
	
	
	
}
