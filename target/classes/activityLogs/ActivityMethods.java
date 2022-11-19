package smrtRain.activityLogs;

import org.testng.asserts.SoftAssert;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import smrtRain.sites.SiteMethods;

public class ActivityMethods extends SiteMethods{
	
	public void verifyActivityGrid() throws Exception {
		logInfo("Entered into verifyActivityGrid() method.");
		SoftAssert sa = new SoftAssert();
		waitTilldisableOfElement(5);
		wdWait("cssSelector", alTitle);
		scrollDown("cssSelector", alTitle);
		String getTitle=getText("cssSelector", alTitle);		
		sa.assertEquals(getTitle, alTitText);
		String getRefresh=getText("cssSelector", alRfresh);
		sa.assertEquals(getRefresh, alRefrshText);
		String getShow=getText("cssSelector", alShowMore);
		sa.assertEquals(getShow, alshowText);		
		sa.assertAll();
	}
	
	public void verifyGridHeaders() throws Exception {
		logInfo("Entered into verifyGridHeaders() method.");
		getColNames(alSNoText);
		getColNames(alEmp);
		getColNames(alSite);
		getColNames(alDescp);
		getColNames(alActivity);
		//getColNames("Logged ("+timeZonePacific+")");
		getColNames(alAck);
		getColNames(alPack);
	}
	
	public void getColNames(String expHeader) throws Exception {
		logInfo("Entered into getColNames() method.");
		boolean isPresent=false;
		wdWait("cssSelector", alColHeads);
		List<WebElement> col=driver.findElements(By.cssSelector(alColHeads));
		if(col.size()==8) {
			for(WebElement columns: col) {
				String name = columns.getText().trim();
				if(name.equalsIgnoreCase(expHeader)) {
					isPresent=true;
					break;
				}
			}
			
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expHeader+" : is not found");
		}	
	}
	
	public void overlayHeaderFunctions(String expFunction) throws InterruptedException {
		logInfo("Entered into overlayHeaderFunctions() method.");
		
		sleep(5000);
		waitTilldisableOfElement(8);
		boolean isPresent=false;
		List<WebElement> funct=driver.findElements(By.xpath(alExport));		
		for(WebElement functions: funct) {
			String functName=functions.getText().trim();			
			if(functName.equalsIgnoreCase(expFunction)) {
				isPresent=true;
				functions.click();
				break;				
			}			
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expFunction+" is not found");
		}
	}
	
	public void showMore() throws Exception {
		logInfo("Entered into showMore() method.");
		wdWait("cssSelector", alShowMore);
		clickOnButton("cssSelector", alShowMore);
		threadSleep(4000);
		waitTilldisableOfElement(7);
	}
	
	public String selectPacketFromLogsTable(String headerName, String expValue) throws Exception {
		logInfo("Entered into selectPacketFromLogsTable() method.");
		wdWait("xpath", alRows);
		boolean isPresent=false;
		String getData = null;
		int colns=driver.findElements(By.cssSelector(alColHeads)).size();
		int rows=driver.findElements(By.xpath(alRows)).size();		
		for(int i=1;i<=colns;i++) {
			WebElement colHeader=driver.findElement(By.cssSelector(alColHeadsBfr+i+")"));
			String colHeadName=colHeader.getText().trim();
			if(colHeadName.contains(headerName)) {
				isPresent=true;
				boolean isCellPresent=false;
				for(int j=1;j<=rows;j++) {
					WebElement cellData =driver.findElement(By.xpath(alRowsBfr2+j+alRowsMid+i+alRowsAft));
					String actData=cellData.getText().trim();
					if(actData.equalsIgnoreCase(expValue)) {
						isCellPresent=true;
						cellData.click();
						wdWait("cssSelector", alOkBtn);
						String btn = getText("cssSelector", alOkBtn);
						Assert.assertEquals(btn, "OK");
						clickOnButton("cssSelector", alOkBtn);
						break;
					}
				}if(!isCellPresent) {
					Assert.assertTrue(isCellPresent,expValue+ ": cell data is not found");
				}
				break;
			}			
		}if(!isPresent) {
			Assert.assertTrue(isPresent, headerName+" is not found");
		}		
		return getData;
	}
	
	public String getDatafromLastRow(String headerName) throws Exception {
		logInfo("Entered into getDataOfSiteCreated() method.");
		wdWait("xpath", alRows);
		boolean isPresent=false;
		String getData = null;
		int colns=driver.findElements(By.cssSelector(alColHeads)).size();
		for(int i=1;i<=colns;i++) {
			WebElement colHeader=driver.findElement(By.cssSelector(alColHeadsBfr+i+")"));
			String colHeadName=colHeader.getText().trim();
			if(colHeadName.contains(headerName)) {
				isPresent=true;
				int getRows= driver.findElements(By.xpath(alRows)).size();
				WebElement cell = driver.findElement(By.xpath(alRowsBfr2+getRows+alRowsMid+i+alRowsAft));
				getData=cell.getText().trim();
				break;
			}			
		}if(!isPresent) {
			Assert.assertTrue(isPresent, headerName+" is not found");
		}		
		return getData;
	}
	
	public void logsOfSiteCreated(String expSite) throws Exception {
		logInfo("Entered into logsOfSiteCreated() method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath", profDesg);
		String getProfile=getText("xpath", profDesg).toLowerCase();
		String actAdmin= getDatafromLastRow(alEmp);		
		sa.assertEquals(actAdmin, getProfile);
		String siteName= getDatafromLastRow(alSite);		
		sa.assertEquals(siteName, expSite);		
		String siteDesc= getDatafromLastRow(alDescp);		
		sa.assertEquals(siteDesc, desText+expSite);		
		sa.assertAll();
	}
	
	public void activityObjects(String expLabel) throws Exception {
		logInfo("Entered into activityObjects() method.");
		wdWait("cssSelector", alLabel);
		boolean isLabelPresent=false;
		List<WebElement> obj=driver.findElements(By.cssSelector(alLabel));
		for(WebElement objs:obj) {
			String actLabel=objs.getText().trim();
			if(actLabel.equalsIgnoreCase(expLabel)) {
				isLabelPresent=true;				
				break;
			}
		}if(!isLabelPresent) {
			Assert.assertTrue(isLabelPresent,expLabel+" is not found.");
		}		
	}
	
	public void categoryOption(String option) throws Exception {
		logInfo("Entered into categoryOption() method.");
		waitTilldisableOfElement(4);
		sleep(5000);
		wdWait("xpath", alCatObj);
		clickOnObject("xpath", alCatObj);
		boolean isPresent=false;
		wdWait("cssSelector", countryOptions);
		List<WebElement> opt= driver.findElements(By.cssSelector(countryOptions));
		for(WebElement optn:opt) {
			String actOptions=optn.getText().trim();			
			if(actOptions.equalsIgnoreCase(option)) {
				isPresent=true;				
				optn.click();
				clickOnButton("cssSelector", alGo);
				waitTilldisableOfElement(3);
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,option+" is not found");
		}		
	}
	
	public void verifyDataFromColumn(String headerName, String expResult) throws Exception {
		logInfo("Entered into verifyDataFromColumns() method.");
		waitTilldisableOfElement(5);
		wdWait("xpath", alRows);
		boolean isPresent=false;
		String getData = null;
		int colns=driver.findElements(By.cssSelector(alColHeads)).size();
		for(int i=1;i<=colns;i++) {
			WebElement colHeader=driver.findElement(By.cssSelector(alColHeadsBfr+i+")"));
			String colHeadName=colHeader.getText().trim();
			if(colHeadName.contains(headerName)) {
				isPresent=true;
				int getRows= driver.findElements(By.xpath(alRows)).size();
				boolean isdataPresent=false;
				if(getRows==0) {
					String noResults= getText("cssSelector", alNoResults);
					Assert.assertEquals(noResults, alNoResltsText);
					break;
					}else {
						for(int j=1;j<=getRows;j++) {
						WebElement cell = driver.findElement(By.xpath(alRowsBfr2+j+alRowsMid+i+alRowsAft));
						getData=cell.getText().trim();						
						if(getData.equalsIgnoreCase(expResult)) {
							
							isdataPresent=true;
							
							}
						}
					}
				if(!isdataPresent) {
					Assert.assertTrue(isdataPresent, expResult+" is not present");
				}
				break;
			}			
		}if(!isPresent) {
			Assert.assertTrue(isPresent, headerName+" is not found");
		}	
	}
	
	public void searchByInput(String value) throws Exception {
		logInfo("Entered into searchByInput() method.");		
		wdWait("xpath", alSearch);
		clearText("xpath", alSearch);
		enterText("xpath", alSearch, value);
		submitObject("xpath", alSearch);
		submitObject("cssSelector", alSearchIcon);		
	}
	
	public int verifyDataFromColumn(int maxSizeRows, String headerName, String expResult) throws Exception {
		logInfo("Entered into verifyDataFromColumns() method.");
		waitTilldisableOfElement(5);
		threadSleep(4000);
		expResult=expResult.toLowerCase();
		wdWait("xpath", alRows);
		int j=0;
		boolean isPresent=false;
		String getData = null;
		int colns=driver.findElements(By.cssSelector(alColHeads)).size();
		for(int i=1;i<=colns;i++) {
			WebElement colHeader=driver.findElement(By.cssSelector(alColHeadsBfr+i+")"));
			String colHeadName=colHeader.getText().trim();			
			if(colHeadName.contains(headerName)) {
				isPresent=true;
				int getRows= driver.findElements(By.xpath(alRows)).size();
				boolean isdataPresent=false;
				if(getRows==0) {
					String noResults= getText("cssSelector", alNoResults);
					Assert.assertEquals(noResults, alNoResltsText);
					break;
					}else {
						for( j=1;j<=maxSizeRows;j++) {
						WebElement cell = driver.findElement(By.xpath(alRowsBfr2+j+alRowsMid+i+alRowsAft));
						getData=cell.getText().trim().toLowerCase();						
						if(getData.contains(expResult)) {							
							isdataPresent=true;							
							break;
							}
						}
					}
				if(!isdataPresent) {
					Assert.assertTrue(isdataPresent, expResult+" is not present");
				}
				break;
			}			
		}if(!isPresent) {
			Assert.assertTrue(isPresent, headerName+" is not found");
		}	
		return j;
	}
	
	
	public void verifyDataFromColDescription(int maxSizeRows, String expResult) throws Exception {
		logInfo("Entered into verifyDataFromColDescription() method.");
		waitTilldisableOfElement(5);
		wdWait("xpath", alRows);
		int j=0;		
		String getData = null;		
			WebElement colHeader=driver.findElement(By.cssSelector(alColHeadsBfr+4+")"));
			String colHeadName=colHeader.getText().trim();				
				int getRows= driver.findElements(By.xpath(alRows)).size();
				boolean isdataPresent=true;
				if(getRows==0) {
					String noResults= getText("cssSelector", alNoResults);
					Assert.assertEquals(noResults, alNoResltsText);					
					}else {
						for( j=1;j<=maxSizeRows;j++) {
						WebElement cell = driver.findElement(By.xpath(alRowsBfr2+j+alRowsMid+4+alRowsAft));
						getData=cell.getText().trim();							
						if(getData.contains(expResult)) {							
							isdataPresent=false;	
							Assert.assertTrue(isdataPresent, expResult+ " is present");
							break;
							}
						}if(isdataPresent) {
							
						}
					}				
					
			}
	
	
	public void selectExactPacketFromLogsTable(int j, String expValue) throws Exception {
		logInfo("Entered into selectPacketFromLogsTable() method.");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wdWait("xpath", alRows);		
		String getData = null;
		int colns=driver.findElements(By.cssSelector(alColHeads)).size();
		int rows=driver.findElements(By.xpath(alRows)).size();			
			WebElement colHeader=driver.findElement(By.cssSelector(alColHeadsBfr+8+")"));
			String colHeadName=colHeader.getText().trim();			
				boolean isCellPresent=false;
				String packLocator=alRowsBfr2+j+alRowsMid+8+alRowsAft;				
					scrollDown("xpath", packLocator);
					WebElement cellData =driver.findElement(By.xpath(packLocator));
					String actData=cellData.getText().trim();				
					if(actData.equalsIgnoreCase(expValue)) {
						isCellPresent=true;
						cellData.click();						
						//js.executeScript("arguments[0].click();", cellData);
						
					}
				if(!isCellPresent) {
					Assert.assertTrue(isCellPresent,expValue+ ": cell data is not found");
				}	
	}
	
	public void isDataPresentInColumn(int j, String headerName, String expValue) throws Exception {
		logInfo("Entered into isDataPresentInColumn() method.");
		wdWait("xpath", alRows);
		int colns=driver.findElements(By.cssSelector(alColHeads)).size();		
		boolean isHeaderPresent=false;
		for(int i=1;i<=colns;i++) {	
			WebElement colHeader=driver.findElement(By.cssSelector(alColHeadsBfr+i+")"));
			String colHeadName=colHeader.getText().trim();				
			if(colHeadName.contains(headerName)) {
				isHeaderPresent=true;
				boolean isCellPresent=false;
				String packLocator=alRowsBfr2+j+alRowsMid+i+alRowsAft;
				scrollDown("xpath", packLocator);
				String cellData =driver.findElement(By.xpath(packLocator)).getText().trim();
				System.out.println("cellDatadd :  "+cellData);
				if(cellData.contains(expValue)) {
					isCellPresent=true;	
					break;
					}
				if(!isCellPresent) {
					Assert.assertTrue(isCellPresent,expValue+ ": cell data is not found");
				}	
				
				break;
			}	
			}if(!isHeaderPresent) {
				Assert.assertTrue(isHeaderPresent,headerName+ " is not present");
			
			}					
		}
		
	public void closePacket() throws Exception {
		logInfo("Entered into closePacket() method.");
		sleep(2000);
		wdWait("cssSelector", alOkBtn);
		String btn = getText("cssSelector", alOkBtn);		
		Assert.assertEquals(btn, "OK");
		clickOnButton("cssSelector", alOkBtn);
	}
	
	
	public void getPacketData(String expDetails) throws Exception {
		logInfo("Entered into getPacketData() method.");
		wdWait("cssSelector", packDetail);
		String packDet= getText("cssSelector", packDetail);		
		if(packDet.contains(expDetails)) {
			
		}else {
			closePacket();
			Assert.assertEquals(packDet, expDetails);
		}		
	}
	
	public void noOfDays(int weekDay) {
		logInfo("Entered into noOfDays() method.");
		int day=weekDay+1;
		
		
		if(day==8) {
			//dayFriday
			
		}else if(day==2)  {
			
		}
		else if(day==3)  {
			
		}else if(day==4)  {
			
		}else if(day==5)  {
			
		}else if(day==6)  {
			
		}else if(day==7)  {
			
		}
		
	}
	

}
