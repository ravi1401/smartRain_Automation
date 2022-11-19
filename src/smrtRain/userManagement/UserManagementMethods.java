package smrtRain.userManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.lib.TestBase;

import smrtRain.activityLogs.ActivityMethods;
import smrtRain.sites.SiteMethods;
import java.util.List;


public class UserManagementMethods extends SiteMethods{	
	
	ActivityMethods am = new ActivityMethods();
	
	public void invitation(String email, String expOrganisation) throws Exception {
		logInfo("Enter into invitation() method");
		wdWait("cssSelector", umInitUser);
		clearText("cssSelector", umInitUser);
		Thread.sleep(5000);
		enterText("cssSelector", umInitUser,email);
		wdWait("xpath", umOrgdropdown);
		clickOnObject("xpath", umOrgdropdown);
		wdWait("cssSelector", umOrgList);
		List<WebElement> org=driver.findElements(By.cssSelector(umOrgList));
		if(org.size()==0) {
			Assert.assertNull("Not selected organization dropdown");
		}else {
			boolean isPresent =false;
			for(WebElement orgs:org) {
				String organization=orgs.getText().trim();
				if(organization.equalsIgnoreCase(expOrganisation)) {
					isPresent=true;
					orgs.click();
					clickOnButton("cssSelector", umSubmit);
					break;
				}
			}if(!isPresent) {
				Assert.assertTrue(isPresent,expOrganisation+" is not found.");
			}
		}
		
	}
	
	/***    Verifies email from section and also its Status   ***/
	public void getInvitedEmail(String expMailId, String expStatus) throws Exception {
		logInfo("Enter into getInvitedEmail) method");
		wdWait("xpath", usersSection);
		List<WebElement> email = driver.findElements(By.xpath(userSecEmail));
		int sect= email.size();
		boolean isMailPresent=false;
		for(int i=1;i<=sect;i++) {
			WebElement emails=driver.findElement(By.xpath(userSecEmailBfr+i+userSecEmailAft));
			scrollDown("xpath", userSecEmailBfr+i+userSecEmailAft);
			String mailId=emails.getText().trim();			
			if(mailId.equalsIgnoreCase(expMailId)) {
				isMailPresent=true;
				WebElement stat=driver.findElement(By.xpath(userSecEmailBfr+i+userSecStatusAft));
				String getStatus=stat.getText().trim();
				Assert.assertEquals(getStatus, expStatus);
				break;
			}
		}if(!isMailPresent) {
			Assert.assertTrue(isMailPresent,expMailId +" is not present");
		}
		
	}
	
	/***    Verifies email from section and Select Archive  ***/
	public void selectArchive(String expMailId) throws Exception {
		logInfo("Enter into getInvitedEmail) method");
		wdWait("xpath", usersSection);
		List<WebElement> email = driver.findElements(By.xpath(userSecEmail));
		int sect= email.size();
		boolean isMailPresent=false;
		for(int i=1;i<=sect;i++) {
			WebElement emails=driver.findElement(By.xpath(userSecEmailBfr+i+userSecEmailAft));
			scrollDown("xpath", userSecEmailBfr+i+userSecEmailAft);
			String mailId=emails.getText().trim();				
			if(mailId.equalsIgnoreCase(expMailId)) {
				isMailPresent=true;
				boolean isStatusPresent = false;
				WebElement stat=driver.findElement(By.xpath(userSecEmailBfr+i+userSecArchAft));
				String arch=stat.getText().trim();
				if(arch.equalsIgnoreCase("ARCHIVE")) {
					isStatusPresent=true;
					stat.click();
					break;
				}if(!isStatusPresent) {
					Assert.assertTrue(isStatusPresent, "ARCHIVE is not present");
				}
				
				break;
			}
		}if(!isMailPresent) {
			Assert.assertTrue(isMailPresent,expMailId +" is not present");
		}
		
	}
	
	
	public void confirmStatusModelBox(String expMsg) throws Exception {
		logInfo("Entered into confirmStatusModelBox() method.");	
		boolean isPresent=false;	
		waitTilldisableOfElement(7);
		wdWait("cssSelector", revokeConfirm);
		String conMsg=getText("cssSelector", revokeConfirm);		
		if(conMsg.contains(expMsg)) {
			isPresent=true;
			clickOnButton("cssSelector", zonDelYes);	
			waitTilldisableOfElement(10);
		}else{
			clickOnButton("cssSelector", zonDelYes);
			sleep(1000);
			confirmModalBox(userStats);
			Assert.assertTrue(isPresent,expMsg+ " : is not populated");
		}		
	}
	
	public void invitedSearch(String searchUser) throws Exception {
		logInfo("Entered into invitedSearch() method.");
		wdWait("xpath", appUserSerch);
		scrollDown("xpath", appUserSerch);
		clearText("xpath", appUserSerch);
		enterText("xpath", appUserSerch, searchUser);
		submitObject("xpath", appUserSerch);
		
	}
	
	public void verfiySearchResults(String expText) throws Exception {
		logInfo("Entered into verfiySearchResults() method.");
		wdWait("xpath", usersSection);
		List<WebElement> email = driver.findElements(By.xpath(userSecEmail));
		boolean isTextPresent=false;
		int sect= email.size();
		for(int i=1;i<=sect;i++) {
			WebElement text=driver.findElement(By.xpath(userSecEmailBfr+i+userSecEmailAft));
			scrollDown("xpath", userSecEmailBfr+i+userSecEmailAft);
			String actText=text.getText().toLowerCase().trim();			
			if(actText.contains(expText)) {
				isTextPresent=true;
					
			}else if(!(actText.contains(expText))){
				String siteText=driver.findElement(By.xpath(userSecEmailBfr+i+userSecSiteAft)).getText().toLowerCase().trim();
				if(siteText.contains(expText)) {
					isTextPresent=true;					
				}else if(!siteText.contains(expText)) {
					String organizationText=driver.findElement(By.xpath(userSecEmailBfr+i+userSecOrgAft)).getText().toLowerCase().trim();
					if(organizationText.contains(expText)) {
						isTextPresent=true;						
					}else {
						//boolean textInRole=false;
						String roleText=driver.findElement(By.xpath(userSecEmailBfr+i+userSecRoleAft)).getText().toLowerCase().trim();
						if(roleText.contains(expText)) {
							isTextPresent=true;							
						}if(!isTextPresent) {
							Assert.assertTrue(isTextPresent,expText+" is not found in all fields");
						}
					}
				}				
			}
	
		}if(!isTextPresent) {
			Assert.assertTrue(isTextPresent,expText+" is not found");
		}
	}	
	
	public void getLabelsOfInvitedUsers() throws Exception {
		logInfo("Entered into getLabelsOfInvitedUsers() method.");
		wdWait("xpath", appUserSerch);
		scrollDown("xpath", appUserSerch);
		clearText("xpath", appUserSerch);
		wdWait("xpath", userSectLabels);
		List<WebElement> lab= driver.findElements(By.xpath(userSectLabels));
		if(lab.size()==6){
		for(WebElement labels:lab) {
			String labelName=labels.getText().trim();			
			switch (labelName){			
			case "EMAIL ADDRESS":							
				break;
			case "STATUS":				
				break;
			case "INVITED AT":				
				break;
			case "SITE":				
				break;
			case "ORGANIZATION":				
				break;
			case "ROLE":				
				break;
			default:				
				Assert.assertNull(labelName);
				break;			
				}
			}
		}
	}
		
	public void applicationUsersLabels() throws Exception {
		logInfo("Entered into applicationUsersLabels() method.");
		SoftAssert sa= new SoftAssert();
		wdWait("xpath", appUsrTitle);
		String appTitle=getText("xpath", appUsrTitle);			
		sa.assertEquals(appTitle, appTitleText);
		String searchText =getAttribute("xpath", invitedSerch, "placeholder") ;
		sa.assertEquals(searchText, "Search");	
		sa.assertAll();
	}
	
	public void appUsersTableLabels() {
		logInfo("Entered into appUsersTableLabels() method.");
		List<WebElement> col= driver.findElements(By.xpath(appUsrtableHeader));
		if(col.size()==4){
		for(WebElement columns:col) {
			String colName= columns.getText().trim();
			switch (colName) {
			case "STATUS":				
				break;
			case "NAME":
				break;
			case "EMAIL ADDRESS":
				break;
			case "LAST ACCESSED":
				break;
			default:
			   Assert.assertNull(colName);
			   break;
			  }			
			}		
		}	
	}
	

	
	public void retrieveDataOfApplicationUsers(String expHeader, String expValue) throws Exception {
		logInfo("Entered into getStatusOfUser() method.");
		waitTilldisableOfElement(5);		
		wdWait("xpath", appUsrtableHeader);
		scrollDown("cssSelector", appPagination);
		boolean isHeadrPrsnt=false;
		List<WebElement> tabHdr=driver.findElements(By.xpath(appUsrtableHeader));
		for(int i=1;i<=tabHdr.size();i++) {
			String head= driver.findElement(By.xpath(appTabHead+i+"]")).getText().trim();			
			if(head.equalsIgnoreCase(expHeader)) {
				isHeadrPrsnt=true;
				int pageSize=0;	
				int pagCount=driver.findElements(By.cssSelector(pagNumber)).size();				
				boolean isDataPresent=false;
				if(pageSize<=pagCount+1) {					
					List<WebElement> rowCount= driver.findElements(By.cssSelector(appRows+i+appRowsAft));
					int rowSize=rowCount.size();				
					for(int j=2;j<=rowSize+1;j++) {		
						WebElement data=driver.findElement(By.cssSelector(appRowsBfr+j+appRowMid+i+appRowsAft));
						String dataValue=data.getText().trim();							
						if(dataValue.equalsIgnoreCase(expValue)) {
							isDataPresent=true;								
							break;
							
						}	
						
					}
						clickOnObject("cssSelector", appPagination);
						sleep(4000);
						pageSize+=1;
					}
					if(!isDataPresent) {
						Assert.assertTrue(isDataPresent, expValue+" : value is not present.");
					}
					
					
					
				
				break;
			}
			
			
		}if(!isHeadrPrsnt) {
			Assert.assertTrue(isHeadrPrsnt,expHeader+" header is not present.");
		}
		
		
		
		
		
	}
		
	
	public void changeStatusOfUser(String expHeader, String expValue) throws Exception {
		logInfo("Entered into getStatusOfUser() method.");
		wdWait("xpath", appUsrtableHeader);
		boolean isHeadrPrsnt=false;
		List<WebElement> tabHdr=driver.findElements(By.xpath(appUsrtableHeader));
		for(int i=1;i<=tabHdr.size();i++) {
			String head= driver.findElement(By.xpath(appTabHead+i+"]")).getText().trim();
			if(head.equalsIgnoreCase(expHeader)) {
				isHeadrPrsnt=true;
				System.out.println("head "+head);				
				List<WebElement> rowCount= driver.findElements(By.cssSelector(appRows+i+appRowsAft));
				int rowSize=rowCount.size();
				boolean isDataPresent=false;
				for(int j=2;j<=rowSize+1;j++) {					
					WebElement data=driver.findElement(By.cssSelector(appRowsBfr+j+appRowMid+i+appRowsAft));
					String dataValue=data.getText().trim();					
						if(dataValue.equalsIgnoreCase(expValue)) {
							isDataPresent=true;							
							data.click();
							waitTilldisableOfElement(5);
							break;
						}
					}						
					if(!isDataPresent) {						
						Assert.assertTrue(isDataPresent, expValue+" is not present");
					}break;	
				}
			
		}if(!isHeadrPrsnt) {
			Assert.assertTrue(isHeadrPrsnt,expHeader+" header is not present.");
		}		
	}
	
	
	public String inactiveUser() throws Exception {
		logInfo("Entered into getStatusOfUser() method.");		
		wdWait("cssSelector", userSearch);
		clearText("cssSelector", userSearch);
		enterText("cssSelector", userSearch, "inactive");		
		int rowCount= driver.findElements(By.cssSelector(appRows+3+appRowsAft)).size();
		int row=TestBase.generateRandomNumberInRange(2, rowCount);
		System.out.println(row);
		WebElement value =driver.findElement(By.cssSelector(appRowsBfr+row+appRowMid+3+appRowsAft));		
		String email=value.getText().trim();
		value.click();
		waitTilldisableOfElement(5);
		return email;			
	}
	
	public void selectActiveUser() throws Exception {
		logInfo("Entered into getStatusOfUser() method.");		
		wdWait("cssSelector", userSearch);			
		List<WebElement> row= driver.findElements(By.cssSelector(activeUsers));
		for(WebElement mail:row) {
			mail.click();		
			break;
		}	
			
	}
	
	public String getEmail() throws Exception {
		wdWait("cssSelector", umEmail);
		sleep(3000);
		String actEmail =getText("cssSelector", umEmail);
		return actEmail;
	}
	
	
		
		
	public void activateBtn(String btnName) throws Exception {
		logInfo("Entered into activateBtn() method.");
		waitTilldisableOfElement(5);
		sleep(5000);
		wdWait("xpath", appUsrBtn);
		boolean isPresent=false;
		List<WebElement> btn=driver.findElements(By.xpath(appUsrBtn));
		for(WebElement btns:btn) {
			String actName=btns.getText().trim();			
			if(actName.equalsIgnoreCase(btnName)) {
				isPresent=true;
				btns.click();
				Thread.sleep(3000);
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,btnName+" is not present.");
		}
		
	}
	
	public void getStatus(String status) throws Exception {
		logInfo("Entered into getStatus() method.");
		wdWait("xpath", appUsrBtn);
		boolean isPresent=false;
		List<WebElement> btn=driver.findElements(By.xpath(appUsrBtn));
		for(WebElement btns:btn) {
			String actName=btns.getText().trim();
			if(actName.equalsIgnoreCase(status)) {
				isPresent=true;				
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,status+" is not found.");
		}
		
	}
	
	
	

}
