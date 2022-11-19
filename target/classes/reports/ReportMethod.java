package smrtRain.reports;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import smrtRain.spanish.SpanishMethods;

public class ReportMethod  extends SpanishMethods {
	
	
	public void verifyReportTypes(String[] expReportType)throws Exception{
		logInfo("Enter into verifyReportTypes() method.");
		clickOnButton("xpath", sp_reportTypeDropDown);
		 int expReportOptionSize=expReportType.length;
		 wdWait("xpath", sp_optionDRopdown);
		 
			int infoSize=driver.findElements(By.xpath(sp_optionDRopdown)).size();
			boolean isPresnt =false;
			for(int i=1;i<=infoSize;i++) {
				WebElement infoHeader=driver.findElement(By.xpath(sp_dropdownfirst+i+sitesReportEnd));
				String ActSiteName=infoHeader.getText().trim();	
				for (int j=0; j<expReportOptionSize; j++){
	             if (ActSiteName.equals(expReportType[j])){	            	 
	            	 isPresnt=true;
	            	 break;
	             } 
	          }	      
		}
	}
	
	
	public void verifySubOptions(String[] expSubOpt)throws Exception{
		logInfo("Enter into verifySubOptions() method.");
		clickOnObject("xpath", sp_SitesPlaceHolder);
		 int expReportOptionSize=expSubOpt.length;
		 wdWait("xpath", sp_optionDRopdown);		 
			int infoSize=driver.findElements(By.xpath(sp_optionDRopdown)).size();
			boolean isPresnt =false;
			for(int i=1;i<=infoSize;i++) {
				WebElement infoHeader=driver.findElement(By.xpath(sp_dropdownfirst+i+sitesReportEnd));
				String ActSiteName=infoHeader.getText().trim();	
				for (int j=0; j<expReportOptionSize; j++){
	             if (ActSiteName.equals(expSubOpt[j])){	            	 
	            	 isPresnt=true;
	            	 break;
	             } 
	           }	      
			}
	}

	public void verifySubOptionsBasedOnReportType(String expReportType, String[] expSubOption ) throws Exception {
		logInfo("Entered into verifySubOptionsBasedOnReportType() method.");
		clickOnObject("xpath", sp_reportTypeDropDown);
		int infoSize=driver.findElements(By.xpath(sp_optionDRopdown)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			WebElement infoHeader=driver.findElement(By.xpath(sp_dropdownfirst+i+sitesReportEnd));
			String ActName=infoHeader.getText().trim();			
			if(ActName.equalsIgnoreCase(expReportType)) {	
				isPresnt = true;
				infoHeader.click();
				wdWait("xpath", sp_SitesPlaceHolder);
				clickOnObject("xpath", sp_SitesPlaceHolder);
				int subOpt = driver.findElements(By.xpath(sp_optionDRopdown)).size();
				int  exptSUbOPtSize=expSubOption.length;				
				if(subOpt==exptSUbOPtSize) {
					boolean isStatePresent=false;
					for(int j=0;j<=subOpt-1;j++) {
						WebElement subOptions=driver.findElement(By.xpath(sp_dropdownfirst+j+1+sp_dropdownlast));
						String ActSubOPtion=subOptions.getText().trim();
						sleep(1000);						
						if(expSubOption[j].equalsIgnoreCase(ActSubOPtion)) {							
							isStatePresent=true;	
							
							break;		
					}
					if(!isStatePresent) {
							Assert.assertTrue(isStatePresent,ActSubOPtion+" is not present.");
						}						
					}
					
			}else {
				System.out.println("world");
				Assert.assertEquals(subOpt, exptSUbOPtSize);
					
			}
				break;
			}
		}	
	}
	public void verifyTableHeaders(String[] EXpHeaders)throws Exception{
		logInfo("Entered into verifyTableHeaders() method.");
		wdWait("xpath", spview);
		WebElement desp= driver.findElement(By.xpath(spview));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", desp);
		sleep(2000);
		List<WebElement> headers = driver.findElements(By.xpath(sitesreportTblheaders));
		int infoSize=headers.size();
		boolean isPresnt =false;
		for(int i=0;i<=infoSize-1;i++) {
		WebElement infoHeader=driver.findElement(By.xpath(sitesreportStrat+i+1+sitesReportEnd));
		String ActHeading=infoHeader.getText().trim();	
			
			if(ActHeading.equalsIgnoreCase(EXpHeaders[i])) {
				isPresnt=true;	
				System.out.println("verified");
				break;
				
			}
			if(!isPresnt) {
				Assert.assertTrue(isPresnt, ActHeading+" is not present");
			}
		}	
		
	}
	public void verifiSites(String ExpSite)throws Exception{
		logInfo("Entered into verifiSites() method.");
		wdWait("xpath", sp_siteDrpodown);
		WebElement site=driver.findElement(By.xpath(sp_siteDrpodown));
		String actSiteName=site.getText().trim();
		boolean isPresent=false;
		if(actSiteName.equalsIgnoreCase(ExpSite)) {
			isPresent=true;
			List<WebElement> sites = driver.findElements(By.xpath(RowSites));
			int infoSize=sites.size();
			boolean isSitePresent=false;
			for(int i=0;i<=infoSize-1;i++){
				WebElement siteName=driver.findElement(By.xpath(SiteStarts+i+1+SiteEnds));	
				String ActSiteName=siteName.getText().trim();
				if(ActSiteName.equalsIgnoreCase(ExpSite)) {
					isSitePresent=true;
					System.out.println("siteVerified");
					break;
				}
				if(!isSitePresent) {
					Assert.assertTrue(isSitePresent, ActSiteName+" is not present");
				}
		}
		
	}
		else {
			Assert.assertTrue(isPresent, actSiteName);
		}
	}

	public void reportType(String expHeader) throws Exception{
		logInfo("Entered into reportType() method.");
		wdWait("xpath", sp_optionDRopdown);	 
		int infoSize=driver.findElements(By.xpath(sp_optionDRopdown)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			WebElement infoHeader=driver.findElement(By.xpath(sp_dropdownfirst+i+sitesReportEnd));
			String ActSiteName=infoHeader.getText().trim();			
				if(ActSiteName.equalsIgnoreCase(expHeader)) {
				isPresnt=true;	
				infoHeader.click();
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt,expHeader);
		}	
	}
	
	
}
