package smrtRain.sites;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.lib.TestBase;


public class SiteMethods extends TestBase{
	
	JavascriptExecutor jse= (JavascriptExecutor)driver;
	
	public void createNewSite(String siteName, String serialNumber) throws Exception {
		logInfo("Entered into createNeweSite method.");		
		wdWait(css, newSiteBtn);
		clickOnObject(css, newSiteBtn);
		wdWait(xpath, siteNameText);
		clearText(xpath, siteNameText);
		clearText(xpath, siteSerialNoText);
		enterText(xpath, siteNameText, siteName);
		enterText(xpath, siteSerialNoText, serialNumber);				
		clearText("name", noOfZonesField);
		String zoneSize = String.valueOf(noOfZonesSize);
		enterText("name", noOfZonesField, zoneSize);	
		selectTimeZone(timeZonePacific);
		
	}
	
	
	public String getProfileName() throws Exception {
		logInfo("Entered into getProfileName method.");	
		wdWait(css, profiler);
		String prof=getTextInSmallerCase(css, profiler);	
		return prof;
		
	}
	
	public void verifyMandatoryFields() throws Exception {
		logInfo("Entered into createNeweSite method.");	
		SoftAssert soft = new SoftAssert();
		clickOnObject(css, newSiteBtn);
		wdWait(xpath, siteNameText);
		clearText(xpath, siteNameText);
		clickOnButton(css, getLocation);
		wdWait(css, reqMsg);
		scrollDown(xpath, siteNameText);
		String actSiteAlert = getText(css, reqMsg);			
		soft.assertEquals(actSiteAlert, reqSiteMsg);
		enterText(xpath, siteNameText, "SiteTest");
		scrollDown(xpath, siteSerialNoText);
		clearText(xpath, siteSerialNoText);
//		clickOnButton(css, getLocation);
//		wdWait(css, reqMsg);
//		scrollDown(xpath, siteNameText);
//		scrollDown(xpath, siteNameText);
//		scrollDown(xpath, siteNameText);
//		enterText(xpath, siteNameText, "SiteTest");
//		clearText(xpath, siteNameText);
//		enterText(xpath, siteNameText, "SiteTest");
//		enterText(xpath, siteSerialNoText, serialNumber);	
//		clearText(xpath, siteSerialNoText);
//		sleep(4000);
//		String actSerialAlert = getText(css, reqMsg);		
//		System.out.println("actSerialAlert "+actSerialAlert);
//		soft.assertEquals(actSerialAlert, reqSerialMsg);
		enterText(xpath, siteSerialNoText, serialNumber);	
		selectTimeZone(timeZonePacific);
//		
//		clearText("name", noOfZonesField);
//		clickOnButton(css, getLocation);
//		wdWait(css, reqMsg);
//		String actNoOfZonesAlert = getText(css, reqMsg);
//		System.out.println(actNoOfZonesAlert);
//		soft.assertEquals(actNoOfZonesAlert, reqZonesMsg);
//		enterText("name", noOfZonesField, "3");		
//		clickOnButton(css, getLocation);	
		soft.assertAll();		
	}
	
	public void controllerTypes(String[] contTypes) throws Exception {
		logInfo("Entered into controllerTypes() method.");
		wdWait(xpath, contTypeDP);
		clickOnObject(xpath, contTypeDP);
		int expectedtypeSize=3, typesSize=contTypes.length;
		String controllerName = null;		
		int actContTypeSize=driver.findElements(By.cssSelector(countryOptions)).size(); 
		threadSleep(3000);
		System.out.println("actContTypeSize "+actContTypeSize +" "+typesSize);
		boolean isPresent=false;
		if(actContTypeSize==typesSize) {
			
			for(int i=0;i<3;i++) {
				WebElement controller= driver.findElement(By.cssSelector(countryOptionsBfr+(i+1)+countryOptionsAft));
				controllerName=controller.getText().trim();            
                if(controllerName.equalsIgnoreCase(contTypes[i])) { 
                	isPresent=true;            	
                	
                }if(!isPresent) {
                	System.out.println(controllerName);  
                	driver.findElement(By.cssSelector(countryOptionsBfr+1+countryOptionsAft)).click();
                	Assert.assertTrue(isPresent, controllerName +" is not present");
                }
			}
			
			
		}else {
			driver.findElement(By.cssSelector(countryOptionsBfr+1+countryOptionsAft)).click();
			Assert.assertEquals(actContTypeSize, expectedtypeSize);
		}driver.findElement(By.cssSelector(countryOptionsBfr+1+countryOptionsAft)).click();
		
	}
	
	public void selectionAndVericationOfControllers(String controllerype,String zonesCount)throws Exception{
        logInfo("Entered into selectionAndVericationOfControllers() method.");
        wdWait(xpath, contTypeDP);
        clickOnObject(xpath, contTypeDP);
        List<WebElement> controllersTypes = driver.findElements(By.cssSelector(countryOptions));        
        boolean isController=false;
        for(int i=1;i<=controllersTypes.size();i++) {
            threadSleep(1000);
            WebElement controller= driver.findElement(By.cssSelector(countryOptionsBfr+i+countryOptionsAft));
            String controllerName=controller.getText().trim();            
                if(controllerName.equalsIgnoreCase(controllerype)) {                    
                    controller.click();
                    isController=true;
                    threadSleep(2000);
                    String getController=getText(xpath, controllerTypeField);
                    boolean isPresent=false;
                    if(getController.equalsIgnoreCase(controllerype)) {
                        String maxZones=getAttribute(xpath,zonesCountField,"max");                       
                        if(maxZones.equalsIgnoreCase(zonesCount)) {
                            isPresent=true;
                            break;
                        }
                        break;
                    }
                    else {
                        Assert.assertTrue(isPresent, getController+" value not same");
                    }
                    break;
                }
        }
        if(isController==false) {
            Assert.assertTrue(isController, controllerype+" is not present");
        }
    }
	
	
	public void handleAddSite() throws Exception {
		logInfo("Entered into handleAddSite() method.");
		clickOnObject(css, newSiteBtn);
		wdWait(xpath, siteNameText);
		enterText(xpath, siteNameText, "SiteTest");
		
	}
	
	public void verifyAddressFields() throws Exception {
		logInfo("Entered into verifyAddressFields() method.");
		SoftAssert soft = new SoftAssert();
		clearText("name", address1Field);		
		clickOnButton(css, getLocation);
		sleep(4000);
		wdWait(css, reqMsg);
		String actAddress1 = getText(css, reqMsg);		
		//soft.assertEquals(actAddress1, regAddress1);
		enterText("name", address1Field, address1);
		clearText("name", address2Field);
		clickOnButton(css, getLocation);
		
		wdWait(css, reqMsg);
		String actAddress2 = getText(css, reqMsg);		
		//l.;'[hjsoft.assertEquals(null, actAddress2);
		enterText("name", address2Field, address2USA);
		soft.assertAll();	
		
	}
	
	public void verifyStates(String expCountry, String[] statesOrProvince) throws Exception {
		logInfo("Entered into verifyStates() method.");
		clickOnObject("name", address2Field);
		clickOnObject(xpath, countryField);
		List<WebElement> contries = driver.findElements(By.cssSelector(countryOptions));
		for(WebElement country:contries) {
			String countryName= country.getText().trim();			
			if(countryName.equalsIgnoreCase(expCountry)) {				
				country.click();
				wdWait(xpath, stateField);
				clickOnObject(xpath, stateField);
				threadSleep(3000);
				List<WebElement> state = driver.findElements(By.cssSelector(stateOptions));
				int actSstatesSize=state.size(), exptStatesSize=statesOrProvince.length;
				System.out.println("actSstatesSize "+actSstatesSize +"  exptStatesSize "+exptStatesSize);
				if(exptStatesSize==actSstatesSize) {
					boolean isStatePresent=false;					
					for(WebElement st:state) {
						String states=st.getText().trim();						
						for(int i=0;i<actSstatesSize;i++) {
							if(statesOrProvince[i].equalsIgnoreCase(states)) {
								isStatePresent=true;															
								break;
								
							}
							
						}if(!isStatePresent) {
							Assert.assertTrue(isStatePresent,states+" is not present.");
						}						
					}
					
				}else {
//					scrollDown(xpath, btnCloseZone);
//					clickOnObject(xpath, btnCloseZone);
					Assert.assertEquals(actSstatesSize, exptStatesSize);
			}
				
//				scrollDown(xpath, btnCloseZone);
//				clickOnObject(xpath, btnCloseZone);
				break;
			}
		}	
	}
	
	
	public void verifyCityBasedOnStateOrProvince(String stateOrProvince,int citySize,String propertyFileName) throws Exception {
		logInfo("Entered into verifyCityBasedStateOrProvince() method.");
		String expCity =null,actCity =null;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wdWait(xpath, stateField);
		WebElement stateFld= driver.findElement(By.xpath(stateField));		
		JavascriptExecutor execut = (JavascriptExecutor)driver;
		execut.executeScript("arguments[0].click();", stateFld);
		boolean isStatePresent=false;
		List<WebElement> state = driver.findElements(By.cssSelector(countryOptions));
		for(WebElement st:state) {
			String stateName=st.getText().trim();
			System.out.println(stateName);
			if(stateName.equalsIgnoreCase(stateOrProvince)) {
				threadSleep(3000);
				st.click();
				waitTilldisableOfElement(5);
				threadSleep(3000);
				wdWait(xpath, cityField);
				WebElement desp= driver.findElement(By.xpath(cityField));		
				JavascriptExecutor executore = (JavascriptExecutor)driver;
				executore.executeScript("arguments[0].click();", desp);
				//clickOnObject(xpath, cityField);
				List<WebElement> citiesList = driver.findElements(By.cssSelector(countryOptions));
				int actCitySize=citiesList.size();				
				boolean isCityPresent=false;						
						for(int i=2;i<citySize;i++) {
							expCity = getAttributeOptionsFromProperty(propertyFileName, stateOrProvince+i);
							WebElement cityName=driver.findElement(By.cssSelector(countryOptionsBfr+i+countryOptionsAft));
							scrollDown(css, countryOptionsBfr+i+countryOptionsAft);
							actCity =cityName.getText().trim();
							if(expCity.equalsIgnoreCase(actCity)) {
							isCityPresent=true;								
							}else {								
								WebElement cityName2=driver.findElement(By.cssSelector(countryOptionsBfr+(i-1)+countryOptionsAft));
								executor.executeScript("arguments[0].click();", cityName2);											
								scrollDown(xpath, btnCloseZone);
								clickOnObject(xpath, btnCloseZone);						
								Assert.assertEquals(actCity,expCity);
							}
						}if(isCityPresent==false) {	
							scrollDown(css, pointer);
							clickOnObject(css, pointer);
							Assert.assertEquals(actCity,expCity);
						}break;
					}
		}		
		WebElement cityName=driver.findElement(By.cssSelector(countryOptionsBfr+(citySize-(citySize-2))+countryOptionsAft));		
		executor.executeScript("arguments[0].click();", cityName);	
	}
	
	public void iterateForCities(int iterateSize,String propertyFileName,String propertyName) {
		logInfo("Entered into iterateForCities() method.");
		for(int i=0;i<iterateSize;i++) {
			getAttributeOptionsFromProperty(propertyFileName, propertyName+i);
			
		}
		
		
		
	}
	
	public void verifyCityBasedOnStateOrProvince_old(String stateOrProvince, String[] cities) throws Exception {
		logInfo("Entered into verifyCityBasedStateOrProvince() method.");
		List<WebElement> state = driver.findElements(By.cssSelector(countryOptions));
		for(WebElement st:state) {
			String stateName=st.getText().trim();
			if(stateName.equalsIgnoreCase(stateOrProvince)) {
				st.click();
				wdWait(xpath, cityField);
				clickOnObject(xpath, cityField);
				List<WebElement> citiesList = driver.findElements(By.cssSelector(countryOptions));
				int actCitySize=citiesList.size(), expCities=cities.length;
				if(actCitySize==expCities) {
					boolean isCityPresent=false;
					for(WebElement city :citiesList) {
						String actCity =city.getText().trim();						
						for(int i=0;i<actCitySize;i++) {
							if(actCity.equalsIgnoreCase(cities[i])) {
								
							}
							
						}
						
						
					}
					
					
					
					
					
				}else {
					Assert.assertEquals(actCitySize, expCities);
					
				}
				
				
				
				
				break;
			}
			
		}
		
		
	}
	
	
	public void selectStateOrProvince(String statesOrProvince) throws Exception {
		logInfo("Entered into verifyStates() method.");
			wdWait(xpath, stateField);
			clickOnObject(xpath, stateField);
			wdWait(css, countryOptions);
			List<WebElement> state = driver.findElements(By.cssSelector(countryOptions));
			boolean isStatePresent=false;
			for(WebElement st:state) {
			String states=st.getText().trim();						
			if(statesOrProvince.equalsIgnoreCase(states)) {
			isStatePresent=true;
			st.click();			
			break;							
				}
							
			}if(!isStatePresent) {
				Assert.assertTrue(isStatePresent,statesOrProvince+" is not present.");
		}
	}
	
	public void selectCityBasedOnStateOrProvince(String stateOrProvince, String expCity) throws Exception {
		logInfo("Entered into verifyCityBasedStateOrProvince() method.");
		wdWait(xpath, stateField);
		clickOnObject(xpath, stateField);
		wdWait(css, countryOptions);
		List<WebElement> state = driver.findElements(By.cssSelector(countryOptions));
		for(WebElement st:state) {
			String stateName=st.getText().trim();
			if(stateName.equalsIgnoreCase(stateOrProvince)) {
			st.click();
			sleep(5000);
			waitTilldisableOfElement(5);
			scrollDown(xpath, stateField);
			wdWait(xpath, cityField);
			clickOnObject(xpath, cityField);
			sleep(3000);
			List<WebElement> citiesList = driver.findElements(By.cssSelector(countryOptions));
			boolean isCityPresent=false;
			for(WebElement city :citiesList) {
				String actCity =city.getText().trim();
				if(actCity.equalsIgnoreCase(expCity)) {
					isCityPresent=true;
					city.click();
					break;					
				}
				
			}if(!isCityPresent)	{
				Assert.assertTrue(isCityPresent,expCity+" is not found");
			}	
				break;
		 }
			
		}		
	}
	
	
	
	public void verifyTimeZoneOptions(String[] zoneOptions) throws Exception {
		logInfo("Entered into verifyTimeZoneOptions method.");
		wdWait(css, timeZoneField);
		clickOnObject(css, timeZoneField);
		List<WebElement> zones = driver.findElements(By.cssSelector(timeZoneOption));
		int size = zoneOptions.length;
		boolean isPresent=true;
		int i = 0;
		sleep(2000);
		for(WebElement zone:zones) {
			for(i=0;i<size;i++) {
			String actZoneName=zone.getText();
			if(actZoneName.equalsIgnoreCase(zoneOptions[i])) {
				isPresent=false;				
				Assert.assertEquals(isPresent,zoneOptions[i]+" is still present");
				break;
			}		
		}if(!isPresent) {
			System.out.println(zoneOptions[i]+"Not present");
		}clickOnObject("name", "timezone");
		}		
	}
	
	public void selectTimeZone(String timeZone) throws Exception {
		logInfo("Entered into selectTimeZone method.");
		sleep(3000);
		scrollDown(xpath, siteNameText);
		wdWait(xpath, timeZoneField);
		clickOnObject(xpath, timeZoneField);
		wdWait(css, timeZoneOption);
		List<WebElement> zones = driver.findElements(By.cssSelector(timeZoneOption));
		boolean isPresent=false;
		for(WebElement zone:zones) {
			String actZoneName=zone.getText().trim();
			if(actZoneName.equalsIgnoreCase(timeZone)) {
				isPresent=true;
				zone.click();
				//zone.sendKeys(Keys.TAB);
				//clickOnObject(css, timeZoneField);
				
				break;
			}		
		}if(isPresent==false)	{
			Assert.assertEquals(isPresent, timeZone+" is not present");
		}
	}
	
	public void sitePhoto() {
		logInfo("Entered into sitePhoto() method.");
		List<WebElement> upload = driver.findElements(By.xpath(photoUpload));
		for(WebElement photo: upload) {
			photo.sendKeys(uploadFilePath);
			
			break;
		}
		
	}
	
	//
	public void chanceOfRain() {
		
		
	}
	
	
	public void selectInviteUserButton() throws Exception {
		logInfo("Entered into inviteTheUser() method.");
		wdWait(css, inviteUsersBtn);
		clickOnObject(css, inviteUsersBtn);	
	}
	
	public void verifyMandatoryFieldsOfInviteUser() throws Exception {
		logInfo("Entered into validateWaterCost method.");
		SoftAssert sa = new SoftAssert();
		selectInviteUserButton();
		wdWait("name", invEmail);
		String title= getText(css, invUserLabel);		
		clearText("name", invEmail);
		//validate email alert msg
		sleep(2000);
		String emailAlert= getText(css, reqMsg);
		sa.assertEquals(emailAlert, invEmailAlrt);
		enterText("name", invEmail,mailId);
		clickOnObject(xpath, invRole);
		
		//clickOnObject(xpath, invRole);
//		clickOnObject("name", invEmail);
//		String roleAlert= getText(css, reqMsg);
//		System.out.println("roleAlert "+roleAlert);
//		sa.assertEquals(roleAlert, invRoleAlrt);
		
		sa.assertAll();
		
		
		}
	
	public void addressDetails(String expCountry) throws Exception	{
		logInfo("Entered into addressDetails() method.");
		clearText("name", address1Field);
		clearText("name", address2Field);	
		clearText("name", zipCodeField);
		enterText("name", address1Field, address1);
		sleep(5000);
		wdWait(xpath, countryField);
		clickOnObject(xpath, countryField);
		sleep(5000);
		boolean isCountry=false;
		wdWait(css, countryOptions);
		List<WebElement> contries = driver.findElements(By.cssSelector(countryOptions));
		for(WebElement country:contries) {
			String countryName= country.getText().trim();			
			if(countryName.equalsIgnoreCase(expCountry)) {
				isCountry=true;
				country.click();				
				switch (expCountry){				
				case "CANADA":
					enterText("name", address2Field, add2Canda);
					selectCityBasedOnStateOrProvince(stateCanada, cityCanada);					
					enterText("name", zipCodeField, zipCodeCanada);
					break;
					
				case "UNITED STATES":
					enterText("name", address2Field, address2USA);						
					selectCityBasedOnStateOrProvince(stateUSA, cityUSA);					
					enterText("name", zipCodeField, zipCodeUSA);
					break;
					
				default :
					Assert.assertEquals(countryName, expCountry+" does not matched");
					break;
					
				}
				
				break;
				
			}
		}if(!isCountry) {
			Assert.assertEquals(isCountry, expCountry+" is not present");
		
			}		
		
		
		selectWeatherSource();
		scrollDown("name", address1Field);
		String text = getText(css, getLocation);		
		WebElement btn = driver.findElement(By.cssSelector(getLocation));		
		btn.click();
//		clickOnButton(css, getLocation);
//		clickOnButton(css, getLocation);
//		clickOnButton(css, getLocation);
		
		}
	
	
	public void selectWeatherSource() {
		logInfo("Entered into selectWeatherSource() method.");	
		clickOnObject(css, wetherSourc);
		List<WebElement> wether = driver.findElements(By.cssSelector(wetherOptions));
		int opted =TestBase.generateRandomNumberInRange(1, wether.size());
			WebElement opt = driver.findElement(By.cssSelector(wetherOptionsBfr+opted+wetherOptionsAft));
			opt.click();			
		}
	
	public void selectWeatherSource(String weatherType) {
		logInfo("Entered into selectWeatherSource() method.");	
		clickOnObject(css, wetherSourc);
		boolean isPresent=false;
		List<WebElement> wether = driver.findElements(By.cssSelector(wetherOptions));
		for(WebElement whether :wether) {
			String labels =whether.getText().trim();
			if(labels.equalsIgnoreCase(weatherType)) {
				isPresent=true;
				whether.click();
				break;				
			}
					
		}if(!isPresent) {
			Assert.assertTrue(isPresent,weatherType );
		}					
		}
		
	
	
	
	public void openNewSiteAndSelectCountry(String expCountry) throws Exception {
		logInfo("Entered into openNewSiteAndSelectCountry method.");		
		wdWait(css, newSiteBtn);
		clickOnObject(css, newSiteBtn);
		waitTilldisableOfElement(5);
		enterText(xpath, siteNameText, "sampleSite");		
		wdWait(xpath, countryField);
		scrollDown("name", address1Field);
		sleep(3000);
		WebElement desp= driver.findElement(By.xpath(countryField));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", desp);
		//clickOnObject(xpath, countryField);		
		List<WebElement> contries = driver.findElements(By.cssSelector(countryOptions));
		for(WebElement country:contries) {
			String countryName= country.getText().trim();			
			if(countryName.equalsIgnoreCase(expCountry)) {				
				country.click();
				Thread.sleep(3000);
				
				//clickOnObject(xpath, stateField);
				break;
				
			}
		}if (contries.size()==0) {
			clickOnObject(css, pointer);
			Assert.assertNotNull(expCountry+" is not able to selected.");
		}
		
	}
	
	public void verifyCountries(String[] countryList) throws Exception {
		logInfo("Entered into verifyCountries method.");	
		wdWait(xpath, countryField);
		clickOnObject(xpath, countryField);	
		Thread.sleep(2000);
		int countSize =countryList.length;		
		List<WebElement> contries = driver.findElements(By.cssSelector(countryOptions));
		int actSize= contries.size();		
		if(actSize==2) {
		for(WebElement country:contries) {
			boolean isCountry=false;
			String countryName= country.getText().trim();
			for( int i=0;i<=countSize-1;i++){
				if(countryList[i].equalsIgnoreCase(countryName)) {
					isCountry=true;		
//					clickOnObject(xpath, siteNameText);
					//clickOnObject(xpath, countryField);
					break;		
				}				
			}if(isCountry==false) {
					Assert.assertTrue(isCountry, countryName+" is not present");
					
					}
			}refreshScreen();
		}else {
		Assert.assertEquals(actSize, "2");
		}	
	}
	
	
	public String getLatitude() throws Exception {
		logInfo("Entered into createSiteFormGetLocation() method.");	
		wdWait("id", latitudeField);
		String latitude = getAttribute("id", latitudeField, "value");		
		return latitude;
		
		
	}
	
	public String getLongitude() throws Exception {
		logInfo("Entered into createSiteFormGetLocation() method.");	
		wdWait("id", latitudeField);		
		String longitude = getAttribute("id", longitudeField, "value");
		return longitude;
		
	}
	
	public void createSiteFromGetLocation() throws Exception {
		logInfo("Entered into createSiteFromGetLocation() method.");		
//		wdWait("id", latitudeField);		
//		wdWait(css, dateIcon);
		clickOnObject(css, dateIcon);
		wdWait(css, presentDate);
		clickOnObject(css, presentDate);	
		sleep(5000);
		List <WebElement> getWeeks = driver.findElements(By.cssSelector(selectAllOpt));		
		for (WebElement all :getWeeks) {
			if(!(all.isSelected())) {				
				all.click();
				break;
			}else {
				logInfo("Already all week is selected");
				break;
			}
		}		
		wdWait(css, createBtn);
		clickOnButton(css, createBtn);
		waitTilldisableOfElement(30);
		sleep(5000);
			
	}	
	
	public void rainSensor() throws Exception {
		logInfo("Entered into rainSensor() method.");
		wdWait(xpath, rainSensorField);
		clickOnObject(xpath, rainSensorField);
		wdWait(css, zoneOptions);
		List<WebElement> opt= driver.findElements(By.cssSelector(zoneOptions));
		int i=TestBase.generateRandomNumberInRange(1, opt.size());
		WebElement option =driver.findElement(By.cssSelector(zoneOptionsBfr+i+zoneOptionsAft));
		option.click();		
	}
	
	public void rainSensor(String optRainSensor) throws Exception {
		logInfo("Entered into rainSensor() method.");
		sleep(5000);
		wdWait(xpath, rainSensorField);
		scrollDown(xpath, rainSensorField);
		boolean isPresnt=false;
		clickOnObject(xpath, rainSensorField);
		sleep(2000);
		wdWait(css, zoneOptions);
		List<WebElement> opt= driver.findElements(By.cssSelector(zoneOptions));
		for(WebElement rain :opt) {
			String rainsensor=rain.getText().trim();			
			if(rainsensor.equalsIgnoreCase(optRainSensor)) {
				isPresnt=true;
				rain.click();				
				break;				
			}
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt,optRainSensor);
		}
	}
	
	
	public void organisation(String expOrganisation) throws Exception {
		logInfo("Entered into organisation() method.");
		wdWait(xpath, organSite);
		clickOnObject(xpath, organSite);
		wdWait(css, umOrgList);
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
					clickOnButton(css, umSubmit);
					break;
				}
			}if(!isPresent) {
				Assert.assertTrue(isPresent,expOrganisation+" is not found.");
			}
		}
		
	}
	
//	public void validateZoneFields() throws Exception {
//		logInfo("Entered into verifyZoneLabels() method.");
//		SoftAssert sa = new SoftAssert();
//		wdWait(css, addZone);
//		String actTitle= getText(css, header);
//		sa.assertEquals(actTitle, zoneHeaderTile);
//		
//		sa.assertAll();
//		
//	}
	
	public void createZone(String zoneName) throws Exception {
		logInfo("Entered into createZone() method.");		
		String leamedFlow= TestBase.generateRandomNumberInRange(-4,1)+"";				
		selectZoneButton(zoneHeaderTile);
		System.out.println("leamedFlow "+leamedFlow);
			
		waitTilldisableOfElement(5);
//		clearText(xpath, zoneNameField);
//		clickOnObject(xpath, zoneNameField);
		enterText(xpath, zoneNameField,zoneName);
//		clearText("name", zoneCurrentFlow);
//		clearText("name", zoneLeamedFlow);
//		clearText("name", zonePercntFlow);
		enterText("name", zoneCurrentFlow, FlowRate);		
		enterText("name", zoneLeamedFlow,leamedFlow);			
		//enterText("name", zonePercntFlow, "20");		
	}
	
	
	
	public void selectZoneButton(String buttonName) {
		logInfo("Entered into selectZoneButton() method.");		
		boolean isPresent =false;		
		List <WebElement> btn = driver.findElements(By.cssSelector(addZone));
		for(WebElement buttons:btn) {
			if(buttons.getText().equalsIgnoreCase(buttonName)) {
				isPresent=true;
				buttons.click();
				break;
			}
		}if(!isPresent) {
			Assert.assertEquals(isPresent, buttonName+" is not present");
		}
		
	}
	
	
	
	
	public void verifyZonesNumber(int enteredZones) {
		logInfo("Entered into verifyZonesNumber() method.");
		clickOnObject(css, zoneNumb);
		List<WebElement> zones = driver.findElements(By.xpath(zoneNumberList));
		int actSize = zones.size()+1;		
		if(!(actSize==enteredZones)) {
			Assert.assertEquals(actSize, enteredZones);
		}
		clickOnObject(css, zoneNumb);
		
	}
	
	public void selectZoneNumber() {
		logInfo("Entered into verifyZonesNumber() method.");
		clickOnObject(css, zoneNumb);
		//clickOnObject(css, overLay);
		List<WebElement> zones = driver.findElements(By.xpath(zoneNumberList));				
		for(WebElement zone:zones) {			
			zone.click();
			break;
		}	
	}
	
	public void selectLastZoneNumber() {
		logInfo("Entered into selectLastZoneNumber() method.");
		clickOnObject(css, zoneNumb);
		//clickOnObject(css, overLay);
		int zones = driver.findElements(By.xpath(zoneNumberList)).size();				
		WebElement lastZone=driver.findElement(By.cssSelector(countryOptionsBfr+zones+countryOptionsAft));
		lastZone.click();
	}
	
	
	public void irrigationType(String[] irrigationType) throws Exception {
		logInfo("Entered into irrigationType() method.");
		wdWait(css, labIrrigation);
		String irrigationTypeLabel = getTextInSmallerCase(css, labIrrigation);
		Assert.assertEquals(irrigationTypeLabel, labIrrigationTitle);		
		boolean isTypePresent= false;		
		int irrSize= irrigationType.length-1;
		List<WebElement> types = driver.findElements(By.cssSelector(irrgationType));		
		for(WebElement type : types) {
			String typeLabel = type.getText().trim();				
				for( int i=0;i<=irrSize;i++) {
					if(irrigationType[i].equalsIgnoreCase(typeLabel)) {						
						isTypePresent=true;		
						break;					
				}				
			}if(isTypePresent==false) {
				Assert.assertTrue(isTypePresent, typeLabel +" is not present");
			}
		}	
		
	}
	
	
	public void addZoneFinalBtn() throws Exception {
		logInfo("Entered into addZoneFinalBtn() method.");
		wdWait(xpath, irrFinalAddBtn);
		clickOnButton(xpath, irrFinalAddBtn);		
	}	
	
	public void confirmModalBox(String expSuccessMsg) throws Exception {
		logInfo("Entered into confirmModalBox() method.");
		String alertMsg = null;				
		sleep(10000);
		wdWait(css, irrSuccsMsg);		
		alertMsg= getText(css, irrSuccsMsg);				
		if(alertMsg.equalsIgnoreCase(expSuccessMsg)) {	
			sleep(7000);	
			Assert.assertEquals(alertMsg, expSuccessMsg);			
			clickOnButton(css, succssOkBtn);						
			}
		else {
			sleep(7000);	
			clickOnButton(css, succssOkBtn);				
			Assert.assertEquals(alertMsg, expSuccessMsg);
		}	
		
	}
	
	
	/******Select Large Button by passing parametres (Advance Config button) in New Site   
	 * @throws Exception ****/
	public void selectLargeButtonsInCreateZone(String btnName) throws Exception {
		logInfo("Entered into selectAdvanceConfig() method.");
		sleep(1000);
		scrollDown(css, advConfBtn);
		wdWait(css, advConfBtn);
		boolean isBtnPresent =false;
		List <WebElement> buttons = driver.findElements(By.cssSelector(advConfBtn));
		for(WebElement button:buttons) {
			String larButtons = button.getText().trim();
			if (larButtons.equalsIgnoreCase(btnName)) {
				isBtnPresent=true;
				button.click();
				break;
			}			
		}if(!isBtnPresent) {
			Assert.assertTrue(isBtnPresent,btnName+ " is not present" );
		}
		
		
	}
	
	public void selectExistingZone(String expZoneName) throws Exception {
		logInfo("Entered into selectExistingZone() method.");
		wdWait(xpath, zoneName);
		int NoZone=driver.findElements(By.xpath(zoneName)).size();
		String expUpperZone = expZoneName.toUpperCase();
		boolean isZonePresent=false;
		for(int i=1;i<=NoZone;i++) {
			String zoneName= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr)).getText().trim();			
			if(zoneName.contains(expUpperZone)) {
				isZonePresent=true;
				WebElement zoneBtn=driver.findElement(By.xpath(zoneNameBfr+i+zoneGridbtn));
				zoneBtn.click();				
				break;
			}
		}if(!isZonePresent) {
			Assert.assertTrue(isZonePresent, expZoneName+" is not present");
		}		
	}
	
	public void selectZoneRandomly() throws Exception {
		logInfo("Entered into selectZoneRandomly() method.");
		wdWait(xpath, zoneName);
		int NoZone=driver.findElements(By.xpath(zoneName)).size();	
		int i =5; // TestBase.generateRandomNumberInRange(1, NoZone);	
		System.out.println("i is "+ i);
		String zoneName= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr)).getText().trim();	
		WebElement zoneBtn=driver.findElement(By.xpath(zoneNameBfr+i+zoneGridbtn));
		System.out.println(zoneName);
		zoneBtn.click();	
		threadSleep(3000);
		String editLabel = driver.findElement(By.xpath(editZone)).getText().trim();
		Assert.assertEquals("EDIT", editLabel);
					
	}
	
	public String getFirstZoneName() {
		
		String zoneName= driver.findElement(By.xpath(zoneNameBfr+1+zoneNameAfr)).getText().trim();
		return zoneName;
		
	}
	
	public int getZoneFlowTime(String expZoneName, int expPercntage) throws Exception {
		logInfo("Entered into getZoneFlowTime() method.");
		wdWait(xpath, zoneName);
		int zonesRunTime=0;
		int NoZone=driver.findElements(By.xpath(zoneName)).size();
		boolean isZonePresent=false;
		for(int i=1;i<=NoZone;i++) {
			String zoneName= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr)).getText().trim();
			
			if(zoneName.contains(expZoneName)) {
				isZonePresent=true;
				String runTime=driver.findElement(By.xpath(zoneNameBfr+i+zoneRuntimeAft)).getText().trim();
				float convert=Float.parseFloat(runTime);
				float exactPercentage=(convert*expPercntage)/100;
				zonesRunTime=Math.round(exactPercentage);			
				break;
			}
		}if(!isZonePresent) {
			Assert.assertTrue(isZonePresent, expZoneName+" is not present");
		}		
		return zonesRunTime;
	}
	
	
	public void validateZoneFlowTime(String expZoneName, int expRunTime) throws Exception {
		logInfo("Entered into validateZoneFlowTime() method.");
		String expZone=expZoneName.toUpperCase();
		wdWait(xpath, zoneName);		
		int noZone=driver.findElements(By.xpath(zoneName)).size();
		boolean isZonePresent=false;
		for(int i=1;i<=noZone;i++) {
			String zoneName= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr)).getText().trim();			
			if(zoneName.contains(expZone)) {
				isZonePresent=true;
				String runTime=driver.findElement(By.xpath(zoneNameBfr+i+zoneRuntimeAft)).getText().trim();
				int flowTime=Integer.parseInt(runTime);							
				Assert.assertEquals(flowTime, expRunTime);			
				break;
			}
		}if(!isZonePresent) {
			Assert.assertTrue(isZonePresent, expZone+" is not present");
		}		
		
	}
	
	public void isZonePresent(String expZone) throws Exception {
		logInfo("Entered into isZonePresent() method.");
		wdWait(xpath, zoneName);
		String expZoneName=expZone.toUpperCase();
		int NoZone=driver.findElements(By.xpath(zoneName)).size();
		boolean isPresent=false;		
		for(int i=1;i<=NoZone;i++) {
			String zoneName= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr)).getText().trim();
			if(zoneName.contains(expZoneName)) {
				isPresent=true;							
				break;
			}
		} if(!isPresent) {
			Assert.assertTrue(isPresent,expZoneName );
		}
		
	}
	
	public void zoneNotToPresent(String expZoneName) throws Exception {
		logInfo("Entered into isZonePresent() method.");
		wdWait(xpath, zoneName);
		int NoZone=driver.findElements(By.xpath(zoneName)).size();
		boolean isPresent=true;		
		for(int i=1;i<=NoZone;i++) {
			String zoneName= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr)).getText().trim();			
			if(zoneName.contains(expZoneName)) {
				isPresent=false;					
				Assert.assertTrue(isPresent,expZoneName + " is not to present" );
				break;
			}
		} if(!isPresent) {
			System.out.println("is not present");			
		}		
	}
	
	public String getZoneNumber(String expZoneName) throws Exception {
		logInfo("Entered into getZoneNumber() method.");
		wdWait(xpath, zoneName);
		String expZone=expZoneName.toLowerCase().trim();		
		String zoneNumber =null;
		int NoZone=driver.findElements(By.xpath(zoneName)).size();				
		for(int i=1;i<=NoZone;i++) {
			WebElement name= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr));
			String zoneName=name.getText().trim().toLowerCase();					
			scrollDown(xpath, zoneNameBfr+i+zoneNameAfr);	
			threadSleep(300);	
			if(zoneName.contains(expZone)) {					
				zoneNumber = zoneName.substring(zoneName.indexOf("(")+1,zoneName.indexOf(")"));	
				break;
			}
		}
		return zoneNumber;
		
	}
	
	public String getZoneDuration(String expZoneName) throws Exception {
		logInfo("Entered into getZoneNumber() method.");
		wdWait(xpath, zoneName);
		String expZone=expZoneName.toLowerCase().trim();		
		String zoneDuration =null;
		int NoZone=driver.findElements(By.xpath(zoneName)).size();				
		for(int i=1;i<=NoZone;i++) {
			WebElement name= driver.findElement(By.xpath(zoneNameBfr+i+zoneNameAfr));
			String zoneName=name.getText().trim().toLowerCase();					
			scrollDown(xpath, zoneNameBfr+i+zoneNameAfr);	
			threadSleep(300);	
			if(zoneName.contains(expZone)) {
				 zoneDuration = driver.findElement(By.xpath(zoneNameBfr+i+zoneDurationAf)).getText();
				
				break;
			}
		}
		return zoneDuration;
		
	}
	
	public int getNoOfZonesFromGrid() throws Exception {
		logInfo("Entered into selectExistingZone() method.");
		wdWait(xpath, zoneName);
		int NoZone=driver.findElements(By.xpath(zoneName)).size();		
		return NoZone;	
	}	
	
	public ArrayList<String> getAllZoneNumbers() throws Exception {	
		logInfo("Entered into getAllZoneNumbers() method.");
		ArrayList<String> zonesList = new ArrayList<String>();			
		String eachZone;
		int size= getNoOfZonesFromGrid();
		for(int i=0;i<size;i++) {
			String zoneName= driver.findElement(By.xpath(zoneNameBfr+(i+1)+zoneNameAfr)).getText().trim();
			String lastBrac = zoneName.substring(zoneName.indexOf("(")+1,zoneName.indexOf(")"));
//			String regex="[^\\d]+";
//			String zonal= lastBrac.replaceAll(regex, "");	
			eachZone=lastBrac.toString();			
			zonesList.add(eachZone); 			
			}				
		return zonesList;
	}
	
	public String retrieveAllZoneNumbers() throws Exception {
		logInfo("Entered into retrieveAllZoneNumbers() method.");
		StringBuilder sb = new StringBuilder();		
		ArrayList<String> numbers=getAllZoneNumbers();
		for(String str:numbers) {
			sb.append(str).append(", ");
		}		
		sb.setLength(sb.length()-1);
		String zonesList= sb.toString().substring(0, sb.length()-1);
		return zonesList;		
	}
	
	public ArrayList<Integer> getAllZoneRunTimes(int expPercntage, String multiOrNonMulti ) throws Exception {
		logInfo("Entered into getAllZoneRunTimes() method.");
		ArrayList<Integer> zonesRunTime = new ArrayList<Integer>();			
		String eachRun;
		float exactPercentage=0;
		int size= getNoOfZonesFromGrid();
		for(int i=0;i<size;i++) {
			String runTime=driver.findElement(By.xpath(zoneNameBfr+(i+1)+zoneRuntimeAft)).getText().trim();
			eachRun=runTime.toString();
			float convert=Float.parseFloat(eachRun);
			exactPercentage=(convert*expPercntage)/100;
			int roundPercent=Math.round(exactPercentage);	
			int runTimeBy = 0;
			if(multiOrNonMulti==multiRun) {
				if(!(roundPercent%3==0)) {
					int remainder= (roundPercent%3);					
					int requiredInt =3-remainder;
					int addedValue= roundPercent+requiredInt;					
					runTimeBy= addedValue/3;					
				}else {
					runTimeBy=roundPercent/3;
				}				
			}else if(multiOrNonMulti==nonMulti) {				
				runTimeBy= roundPercent;
			}			
			zonesRunTime.add(runTimeBy);			
		}
		
		return zonesRunTime;
		
	}
	
	
	
	public String retrieveAllZoneRunTimes(int expPercntage, String multiOrNonMulti) throws Exception {
		logInfo("Entered into  retrieveAllZoneRunTimes() method.");
		StringBuilder sb = new StringBuilder();		
		ArrayList<Integer> times=getAllZoneRunTimes(expPercntage, multiOrNonMulti );
		for(Integer str:times) {
			sb.append(str).append(", ");
		}		
		sb.setLength(sb.length()-1);
		String zonesDuration= sb.toString().substring(0, sb.length()-1);
		return zonesDuration;		
	}
	
	public void zoneStatus(String updateOrDelete) throws Exception {
		logInfo("Entered into zoneStatus() method.");
		SoftAssert sa= new SoftAssert();
		wdWait(xpath, zoneStatus);
		List<WebElement> stat= driver.findElements(By.xpath(zoneStatus));
		for(WebElement status:stat) {
			String statusType=status.getText().trim();
			if(statusType.equalsIgnoreCase(updateOrDelete)) {
				status.click();				
				switch (updateOrDelete){
				case "Update":					
					wdWait(css, zoneTitle);
					String title=getText(css, zoneTitle);					
					sa.assertEquals(title, zoneTitleText);
					
//					selectLargeButtonsInCreateZone(zoneUpdate);
//					waitTilldisableOfElement(20);
//					wdWait(css, confMsg);
//					String conMsg=getText(css, confMsg);
//					sa.assertEquals(conMsg, zonUpdateMsg);
//					clickOnButton(xpath, dialogYes);					
					break;
					
				case "Delete":
					wdWait(css, zoneDetContent);
					String content=getText(css, zoneDetContent);
					sa.assertEquals(content, zoneDetContentMsg);
					clickOnButton(css, zonDelYes);
					wdWait(css, confMsg);
					String msg=getText(css, confMsg);
					sa.assertEquals(msg, zonDelConfMsg);
					clickOnButton(xpath, dialogYes);
					sleep(7000);
					break;
					
				default:
					Assert.assertNotNull(updateOrDelete);
					break;
				
				}break;
				
			}
		}sa.assertAll();
	}
	
	
	public void deleteZone(String deleteMsg) throws Exception {
		logInfo("Entered into deleteZone() method.");
		SoftAssert sa= new SoftAssert();
		wdWait(xpath, zoneStatus);
		String del=deleteMsg.trim().toUpperCase(), delete ="Delete".trim().toUpperCase();
		
		boolean isPresentMsg=false;
		List<WebElement> stat= driver.findElements(By.xpath(zoneStatus));
		for(WebElement status:stat) {
			String statusType=status.getText().trim().toUpperCase();
			if(statusType.equalsIgnoreCase(delete)) {
				isPresentMsg=true;
				status.click();					
				wdWait(css, zoneDetContent);
				String content=getText(css, zoneDetContent);
				boolean result = content.equalsIgnoreCase(deleteMsg) || content.equalsIgnoreCase(zoneDetContentText);
				//sa.assertEquals(content, deleteMsg);
				assertTrue(result);
				clickOnButton(css, zonDelYes);
				deleteConfirm();					
				break;				
			}
		}if(!isPresentMsg) {
			selectMenuIconInSite(iconZone);
			Assert.assertTrue(isPresentMsg, deleteMsg+" is not present");
		}
		
		
		
		
		sa.assertAll();
	}


	public void deleteConfirm() throws Exception {
		logInfo("Entered into deleteConfirm() method.");
		SoftAssert sa= new SoftAssert();
		wdWait(css, confMsg);
		String msg=getText(css, confMsg);
		sa.assertEquals(msg, zonDelConfMsg);
		clickOnButton(xpath, dialogYes);
		sleep(7000);
		sa.assertAll();
		
	}
	
	
	
	
	
	public void verifyDefaultFlowData(String typeOfFlow) throws Exception {
		logInfo("Entered into verifyDefaultFlowData() method.");
		SoftAssert soft = new SoftAssert();
		wdWait(css, irrgationType);
		List<WebElement> types = driver.findElements(By.cssSelector(irrgationType));		
		for(WebElement type : types) {
			String typeLabel = type.getText().trim();	
			if(typeLabel.equalsIgnoreCase(typeOfFlow)) {	
				type.click();
				String actDuration = getAttribute("name", irrDuration,"value");
				String actGPM= getAttribute("name", irrGPM,"value");
				switch(typeOfFlow) {					
				case "Spray 15 m":
					String actHeadsSpray= getAttribute("name", irrHeads,"value");
					String actNozzleSpray= getAttribute("name", irrNozzle,"value");
					soft.assertEquals(actDuration, "15");
					soft.assertEquals(actGPM, irrGPMData);
					soft.assertEquals(actHeadsSpray, "20");
					soft.assertEquals(actNozzleSpray, "1.75");
					break;
					
				case "Rotor 45 m":
					String actHeadsRotor= getAttribute("name", irrHeads,"value");
					String actNozzleRotor= getAttribute("name", irrNozzle,"value");
					soft.assertEquals(actDuration, "45");
					soft.assertEquals(actGPM, "45");
					soft.assertEquals(actHeadsRotor, "15");
					soft.assertEquals(actNozzleRotor, "3");
					break;
					
				case "Drip 60 m":					
					soft.assertEquals(actDuration, "60");
					soft.assertEquals(actGPM, "10");
					List <WebElement> nozzles = driver.findElements(By.xpath(irrTypeSize));
					if(!(nozzles.size()==2)) {
						System.err.println("Addtional fields are displaying");
						Assert.assertNotSame(nozzles.size(), 2);
					}
					
					break;	
				default:
					Assert.assertNotNull(typeOfFlow);
					break;
					 
				
				
				}
			}
		}soft.assertAll();
		
	}
	
	
	public void changeStatusToActive() throws Exception {
		logInfo("Entered into changeStatusToActive() method.");
		selectMenuIconInSite(iconSiteConfig);
		
	}
	
	public void validateSiteConfigLabels() throws Exception {
		logInfo("Entered into validateSiteConfigLabels() method.");
		selectMenuIconInSite(iconSiteConfig);
		wdWait(css, pageTitle);
		String actSiteConfigText = getText(css, pageTitle);
		
		String actSuspOptText = getText(css, secTitleSuspend);
		
		//verifyBtnsInDeviceDetailsSection(deviceForceBtn);
		verifyBtnsInDeviceDetailsSection(networkInfo);
		verifyBtnsInDeviceDetailsSection(deviceInfoBtn);
		verifyBtnsInDeviceDetailsSection(deviceFirmware);
		
	
		
	}
	
	public void verifyBtnsInDeviceDetailsSection(String expectedBtn) {
		logInfo("Entered into validateSiteConfigLabels() method.");
		boolean isBtnPresent= false;		
		List<WebElement>btns = driver.findElements(By.cssSelector(deviceDetailBtns));
		for(WebElement btn:btns) {
			String actBtn=btn.getText().trim();
			
			if(actBtn.equals(expectedBtn.trim())) {
				isBtnPresent=true;
				break;
			}
			
		}if(!isBtnPresent) {
			Assert.assertTrue(isBtnPresent, expectedBtn+" is not present");
		}
	}
	
	public void updateDeviceActiveStatus() throws Exception {
		logInfo("Entered into validateSiteConfigLabels() method.");	
			String actForceBtn=getText(css, devicForce);
			if(actForceBtn.equalsIgnoreCase(deviceForceBtn.trim())) {
				clickOnObject(css, devicForce);				
				String modalText=getText(css, statusDialog);
				Assert.assertEquals(modalText, statusDialogText);
				clickOnButton(xpath, dialogYes);
				wdWait(css, confMsg);
				String actConfMsg= getText(css, confMsg);				
				clickOnButton(css, confOkBtn);
				}
			else if(actForceBtn.equalsIgnoreCase(deviceForceInactiveBtn.trim())){
				System.out.println("Already Device status is as Active");
			}else {
				Assert.assertEquals(actForceBtn, deviceForceBtn+" is not found");
			}
				
				
	}
	
	
	
	public void verifyZoneDetailsFields() throws Exception {
		logInfo("Entered into verifyZoneDetailsFields() method.");	
		wdWait(css, zonDetailsTitle);
		String title= getText(css, zonDetailsTitle);
		Assert.assertEquals(title, zonDetTitleText);
		ZonDetailSubTitle(zonDetContLastText);
		ZonDetailSubTitle(zonDetContNextText);
		ZonDetailSubTitle(zonDetContAlertText);
		ZonDetailSubTitle(zonDetContFlowText);
		
	}
	
	
	public void ZonDetailSubTitle(String expSubTitle) throws Exception {
		logInfo("Entered into ZonDetailSubTitle() method.");
		wdWait(css, zoneDetContents);			
		boolean ispresent=false;		
		List<WebElement> subTitle = driver.findElements(By.cssSelector(zoneDetContents));
		for (WebElement subTit : subTitle) {
			String actSubTitle =subTit.getText().trim();			
				if(expSubTitle.equalsIgnoreCase(actSubTitle.trim())) {
					ispresent=true;					
					break;
				}
			
		}if(!ispresent) {
			Assert.assertTrue(ispresent, expSubTitle);
		}
	}
	
	/******** ZONE DETAILS-  Get current flow as Per GPM                      ****************/
	public String getCurrentFlowRate() throws Exception {
		logInfo("Entered into getCurrentFlowRate() method.");
		wdWait(css, zonDetCurtFlowRate);	
		String flowRate = "0 GPM";
		int flowPresnt=driver.findElements(By.cssSelector(zonDetCurtFlowRate)).size();
		if(flowPresnt==0) {
			
		}else {
			flowRate= getText(css, zonDetCurtFlowRate);	
			
		}
			
		return flowRate;
		
	}
	public void handleStartFlowRate(String expMinutes) throws Exception {
		logInfo("Entered into handleStartFlowRate() method.");
		wdWait(xpath, zonDetStart);
		clickOnObject(xpath, zonDetStart);
		wdWait(xpath, zonDetFlowOk);
		selectMinutesRadioBtn(expMinutes);	
		
	}	
	
	public void selectMinutesRadioBtn(String expMinutes) throws Exception {
		logInfo("Entered into selectMinutesRadioBtn() method.");
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		boolean isMintPresent =false;
		List<WebElement> minutes= driver.findElements(By.xpath(zonDetMinutes));		
		for(int i=1;i<=minutes.size();i++ ) {
				String minuteText= driver.findElement(By.xpath(zonMinBfr+i+zonMinAfr)).getText().trim();				
				if(minuteText.equalsIgnoreCase(expMinutes)) {
					   isMintPresent=true;		
					  // clickOnObject(xpath, zonMinBfr+i+zonMinChkBoxAfr);
					   WebElement chckBox=driver.findElement(By.xpath(zonMinBfr+i+zonMinChkBoxAfr));
					   js.executeScript("arguments[0].click();", chckBox);							  				   
					   WebElement learn=driver.findElement(By.xpath(learnedFlowChk));
					   if(expMinutes.equalsIgnoreCase(expOtherMinutes)) {
						   enterText(css, otherMinutes, "1");
						   
					   }
						break;
					}					
				}if(!isMintPresent) {
					Assert.assertEquals(isMintPresent,expMinutes);
				}
				
				//clickOnButton(xpath, zonDetFlowOk);
				WebElement btn = driver.findElement(By.xpath(zonDetFlowOk));
				js.executeScript("arguments[0].click();", btn);
								
	}	
	
	public void waitOnZoneMinutes() throws InterruptedException {
		logInfo("Entered into waitOnZoneMinutes() method.");
		waitTilldisableOfElement(60);
		sleep(14000);
	}
	
	
	public void verifyFlowRateMinutes(String[] expMinutes) throws Exception {
		logInfo("Entered into verifyFlowRateMinutes() method.");
		wdWait(xpath, zonDetStart);
		scrollDown(xpath, zonDetStart);
		clickOnObject(xpath, zonDetStart);
		String minuteText = null;
		wdWait(xpath, zonDetFlowOk);
		int size = expMinutes.length;
		boolean isMintPresent =false;
		if(size==4) {
			List<WebElement> minutes= driver.findElements(By.xpath(zonDetMinutes));
			for(WebElement minute :minutes ) {
				minuteText= minute.getText().trim();
				for( int i=0;i<size; i++) {	
					if(minuteText.equals(expMinutes[i])) {
						isMintPresent=true;						
						break;
					}				
			}if(!isMintPresent) {
				Assert.assertEquals(isMintPresent, expMinutes);
				}			
			}		
		}			
			clickOnButton(xpath, zonDetFlowCancel);			
			
		}

			
	
	
	public void stopTheFlow() throws Exception {
		logInfo("Entered into stopTheFlow() method.");
		
		wdWait(xpath, zonDetStop);
		WebElement stop=driver.findElement(By.xpath(zonDetStop));
		String actText=stop.getText().trim();
		System.out.println("stp text :"+actText);
		if(actText.equalsIgnoreCase("Stop")) {
		clickOnButton(xpath, zonDetStop);
		waitOnLoadingSpinner(8);
		}else {
			System.out.println("Error");
			Assert.assertNotEquals(actText, "Stop");
		}
	}
	
	
	public void validateRunAllZones() throws Exception {
		logInfo("Entered into validateRunAllZones() method.");
		wdWait(xpath, runAllZonesBtn);
		clickOnButton(xpath, runAllZonesBtn);
		clickOnButton(xpath, zonDetFlowCancel);
		
		
	}
	
	/****SITE FUNCTIONS - select RunZone Tab and selects checkboxes of zones.********/
	public void selectRunZonesTab() throws Exception {
		logInfo("Entered into selectZonesFromDropDown() method.");
		wdWait(xpath, runZonesBtn);
		System.out.println("test :"+ getText(xpath, runZonesBtn));
		clickOnButton(xpath, runZonesBtn);
		//clickOnButton(xpath, zonDetFlowCancel);
		
		
	}
	/****SITE FUNCTIONS Run Zones - Labels validations **************/
	public void runZonesLabelsValidation() throws Exception {
		logInfo("Entered into runZonesLabelsValidation() method.");
		SoftAssert sa= new SoftAssert();
		threadSleep(9000);
		wdWait(css, zonDetSelMinLab);
		String title= getText(css, zonDetSelMinLab);
		sa.assertEquals(title, zoneText);
		threadSleep(4000);
		String dropDownLabel = getText(css, zoneMandLabel);
		sa.assertEquals(dropDownLabel, zoneText2);
		sa.assertAll();
		
	}
	
	public int zonesGridList() throws Exception {
		logInfo("Entered into zonesGridList() method.");
		wdWait(css, zoneGrid);
		List<WebElement> zonesList = driver.findElements(By.cssSelector(zoneGrid));
		int noOfZones = zonesList.size();
		return noOfZones;
	}
	 
	public int getNoOfZonesFromRunZones(String expZoneName) throws Exception {
		logInfo("Entered into getNoOfZonesFromRunZones() method.");		
		Actions action = new Actions(driver);
		wdWait(css, zoneDropDownArrow);
		boolean isDpPresent=false;
		List<WebElement> dp= driver.findElements(By.cssSelector(zoneDropDownArrow));
		for(WebElement dps:dp) {
			String name=dps.getText().trim();				
			if(name.equalsIgnoreCase("zones")) {
				isDpPresent=true;
				dps.click();
				break;
			}
		}if(!isDpPresent) {
			Assert.assertTrue(isDpPresent," zones is not present.");
		}
		sleep(2000);
		wdWait(css, zoneDropDown);
		boolean isZonePresent=false;
		List<WebElement> dd=driver.findElements(By.cssSelector(zoneDropDown));
		int sizeOfDropDown = dd.size();		
		for(WebElement zoneName: dd) {			
			if(zoneName.getText().trim().equalsIgnoreCase(expZoneName.trim())) {
			isZonePresent=true;
			zoneName.click();
			sleep(3000);			
			action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
			//clickOnObject(css, zonDetSelMinLab);
			
			break;
			}
		}if(!isZonePresent) {
			Assert.assertEquals(isZonePresent, expZoneName+ " is not present");
		}		
		return sizeOfDropDown;
	}
	
	public int getNoOfZonesFromRunZones_old(String expZoneName) throws Exception {
		logInfo("Entered into getNoOfZonesFromRunZones() method.");
		Actions action = new Actions(driver);
		wdWait(css, zoneDropDownArrow);
		boolean isDpPresent=false;
		List<WebElement> dp= driver.findElements(By.cssSelector(zoneDropDownArrow));
		for(WebElement dps:dp) {
			String name=dps.getText().trim();				
			if(name.equalsIgnoreCase("zones")) {
				isDpPresent=true;
				dps.click();
				break;
			}
		}if(!isDpPresent) {
			Assert.assertTrue(isDpPresent," zones is not present.");
		}
		sleep(2000);
		wdWait(css, zoneDropDown);
		boolean isZonePresent=false;
		List<WebElement> dd=driver.findElements(By.cssSelector(zoneDropDown));
		int sizeOfDropDown = dd.size();
		for(WebElement zoneName: dd) {
			if(zoneName.getText().trim().equalsIgnoreCase(expZoneName.trim())) {
			isZonePresent=true;
			action.click(zoneName).keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
			
			break;
			}
		}if(!isZonePresent) {
			Assert.assertEquals(isZonePresent, expZoneName+ " is not present");
		}		
		return sizeOfDropDown;
	}
	
	/***Zone Details - getSelected zone from DropDown */
	public String getSelectedZoneFromDropdown() throws Exception {
		logInfo("Entered into getSelectedZoneFromDropdown() method.");
		String actSelectedZone= getText(css, zoneselectedZone);		
		return actSelectedZone;
		
	}
	
	
	public void stopRunZones() throws Exception {
		logInfo("Entered into stopRunZones() method.");
	
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		scrollDown(css, zoneStop);
		sleep(2000);
		clickOnButton(css, zoneStop);	
		
//		String stopZoneBtn= getText(css, zoneStop);		
//		
//		WebElement button= driver.findElement(By.cssSelector(zoneStop));
//		js.executeScript("arguments[0].click();", button);
//		sleep(4000);
//		driver.navigate().refresh();		
	}
	
	
	public void runZonesStop() throws Exception {
		logInfo("Entered into runZonesStop() method.");		
		scrollDown(css, zoneStop);
		sleep(5000);
		clickOnButton(css, zoneStop);	
		
		
	}
	
	public void irrigationTypeDuration() throws Exception {
		logInfo("Entered into irrigationTypeDuration() method.");
		wdWait("name", irrDuration);
		clearText("name", irrDuration);
		enterText("name", irrDuration,"12");
				
	}
	
	public void isAddBtnEnabled() throws Exception {
		logInfo("Entered into isAddBtnEnabled() method.");	
		wdWait(css, zoneAddFinlBtn);
		WebElement btn= driver.findElement(By.cssSelector(zoneAddFinlBtn));
		if(btn.isEnabled()) {
			addZoneFinalBtn();
			confirmModalBox(succssMsgText);		
			
		}else {			
			String actAddBtn=btn.getText().trim();			
			clickOnObject(xpath, btnCloseZone);	
			
		}
		
	}
	
	public void confirmStatusModelBox(String expMsg) throws Exception {
		logInfo("Entered into confirmStatusModelBox() method.");	
		boolean isPresent=false;	
		//waitTilldisableOfElement(4);
		sleep(8000);
		wdWait(css, skipConfMsg);
		String conMsg=getText(css, skipConfMsg);			
		if(conMsg.contains(expMsg)) {
			isPresent=true;
			clickOnButton(css, zonDelYes);						
		}else{
			clickOnButton(css, zonDelYes);
			waitTilldisableOfElement(20);
			wdWait(css, confMsg);
			clickOnButton(css, confMsg);	
			sleep(4000);
			clickOnButton(xpath, dialogYes);	
			Assert.assertEquals(conMsg,expMsg);
		}
	}
	
	public void deleteConfirmation() throws Exception {
	logInfo("Entered into deleteConfirmation() method.");		
	Thread.sleep(7000);
	waitTilldisableOfElement(20);
	wdWait(css, confMsg);
	String conMsg=getText(css, confMsg);	
	if(conMsg.contains("Successfully deleted the")) {
		clickOnButton(xpath, dialogYes);	
	} else {
		clickOnButton(xpath, dialogYes);	
	}
		threadSleep(5000);
	}	
	
	
	public void getHeaderTitle(String expTitle) throws Exception {
		logInfo("Entered into getHeaderTitle() method.");
		wdWait(css, invUserLabel);
		String title= getText(css, invUserLabel);		
		Assert.assertEquals(title, expTitle);
	}
	
	public void labelEditSite(String expTitle) throws Exception {
		logInfo("Entered into labelEditSite() method.");
		wdWait(css, labelEdit);
		String title= getText(css, labelEdit);		
		Assert.assertEquals(title, expTitle);
	}
	
	public void selectUpdateOrDelete(String status) throws Exception {
		logInfo("Entered into selectUpdateOrDelete() method.");
		waitTilldisableOfElement(2);
		wdWait(css, progUpdOrDel);
		boolean isPresent=false;
		List<WebElement> st= driver.findElements(By.cssSelector(progUpdOrDel));
		for(WebElement stat:st) {
			String actStatus=stat.getText().trim();			
			if(actStatus.equalsIgnoreCase(status)) {
				isPresent=true;
				stat.click();				
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,status+" :is not present");
		}
		
	}
	
	public void selectDotsToUpdateSiteDetails() throws Exception {
		logInfo("Entered into selectDotsToUpdateSiteDetails() method.");
		waitTilldisableOfElement(5);		
		scrollDown(css, siteUpdateDots);
		Thread.sleep(4000);
		wdWait(css, siteUpdateDots);		
		clickOnObject(css, siteUpdateDots);		
	}	
	
	
	public void confirmSaveChanges(String expMsg) throws Exception {
		logInfo("Entered into confirmSaveChanges() method.");	
		boolean isPresent=false;	
		//waitTilldisableOfElement(7);
		Thread.sleep(4000);
		wdWait(css, saveChange);
		String conMsg=getText(css, saveChange);		
		if(conMsg.contains(expMsg)) {
			isPresent=true;
			clickOnButton(css, okButton);	
			waitTilldisableOfElement(10);
		}else{
			clickOnButton(css, okButton);
			sleep(3000);
			confirmModalBox(userStats);
			Assert.assertTrue(isPresent,expMsg+ " : is not populated");
		}		
	}	
	
	public void handleConfirmModal(String expSuccessMsg) throws Exception {
		logInfo("Entered into handleConfirmModal() method.");					
		sleep(10000);
		int descp= driver.findElements(By.cssSelector(confirmLabel)).size();		
		if(descp==1) {
			wdWait(css, confirmLabel);				
			String alertMsg= getText(css, confirmLabel);				
			if(alertMsg.equalsIgnoreCase(expSuccessMsg)) {			
				Assert.assertEquals(alertMsg, expSuccessMsg);
				clickOnButton(xpath, zonDetFlowOk);	
				sleep(4000);
				waitTilldisableOfElement(5);
				}else {
					 clickOnButton(xpath, zonDetFlowOk);						 
					 waitTilldisableOfElement(5);
					 clickOnButton(xpath, dialogYes);	
					 Assert.assertEquals(alertMsg, expSuccessMsg);
				}			
		}else {
			String actConMsg=getText(css, confMsg);				
			clickOnButton(css, confOkBtn);
			//clickOnButton(xpath, dialogYes);	
			confirmPopup(siteDelSucess);			
			waitTilldisableOfElement(5);
			System.out.println("Act Msg"+actConMsg);
			Assert.assertEquals(actConMsg, expSuccessMsg);			
		}			
	}
	
	public void getWeatherSourceLabel(String expWeatherSource) throws Exception {
		logInfo("Entered into getWeatherSourceLabel() method.");	
		sleep(4000);
		wdWait(xpath, weatherSourceLabel);
		String actText =getText(xpath, weatherSourceLabel);		
		Assert.assertEquals(actText, expWeatherSource);
		
	}
	
	public void getRecentSites() throws Exception {
		logInfo("Entered into getRecentSites() method.");	
		sleep(30000);
		wdWait(css, recentSites);
		int recentCount=driver.findElements(By.cssSelector(recentSites)).size();	
		System.out.println(recentCount+" size");
		if(recentCount==0) {
			Assert.assertNull("Should have recent Sites");
		}else {
		for(int i=1;i<=recentCount;i++) {
			
			String siteName =getText(css, recentSitesBfr+i+recentSitesAft);
			
		}
		}
	}
	
	public void verifyRecentSites(String expSite) throws Exception {
		logInfo("Entered into verifyRecentSites() method.");	
		wdWait(css, recentSites);
		String actsiteName = null;
		int recentCount=driver.findElements(By.cssSelector(recentSites)).size();		
		boolean isSitePresnt=false;
		if(recentCount==0) {
			Assert.assertNull("Should have recent Sites");
		}else {			
		for(int i=1;i<=recentCount;i++) {		
			actsiteName =getText(css, recentSitesBfr+i+recentSitesAft);			
			if(actsiteName.equalsIgnoreCase(expSite)) {
				isSitePresnt=true;
				System.out.println(i+ "   "+actsiteName);
				break;
			}
		}if(!isSitePresnt) {
			Assert.assertEquals(isSitePresnt, expSite);
			}
		}
	}
	
	public void verifyRecentSitePosition(int i, String expSite) throws Exception {
		logInfo("Entered into verifyRecentSitePosition() method.");	
		wdWait(css, recentSites);
		String actsiteName = null;
		int recentCount=driver.findElements(By.cssSelector(recentSites)).size();		
		boolean isSitePresnt=false;
		if(recentCount==0) {
			Assert.assertNull("Should have recent Sites");
		}else {				
			actsiteName =getText(css, recentSitesBfr+i+recentSitesAft);			
			if(actsiteName.equalsIgnoreCase(expSite)) {
				isSitePresnt=true;
				System.out.println(i+ "   "+actsiteName);
			
		}if(!isSitePresnt) {
			Assert.assertEquals(isSitePresnt, expSite);
			}
		}
	}
	
	
	public int getCountOfSites() throws Exception {
		logInfo("Entered into getCountOfSites() method.");	
		wdWait(css, recentSites);		
		int recentCount=driver.findElements(By.cssSelector(recentSites)).size();		
		return recentCount;
	}
	
	
	public String openSiteFromRecent() throws Exception {
		logInfo("Entered into openSiteFromRecent() method.");	
		wdWait(css, recentSites);	
		String actsiteName = null ;
		int recentCount=driver.findElements(By.cssSelector(recentSites)).size();		
		if(recentCount==0) {
			Assert.assertNull("Should have recent Sites");
		}else {			
			int i=TestBase.generateRandomNumberInRange(1, recentCount);
			System.out.println(i);
			actsiteName =getText(css, recentSitesBfr+i+recentSitesAft);	
			clickOnObject(css, recentSitesBfr+i+recentSitesAft);			
		}
		return actsiteName;
						
	}
	
	
	public void selectPartnerTabs(String partnerIcon) throws Exception {
		logInfo("Entered into selectPartnerTabs() method.");
		waitTilldisableOfElement(7);
		wdWait(xpath, partnerIcons);
		boolean isPresent = false;
		List <WebElement> menu = driver.findElements(By.xpath(partnerIcons));
		for(WebElement icons: menu) {
			String selectIcons = icons.getAttribute("src");
			if(selectIcons.contains(partnerIcon)) {
				isPresent=true;						
				icons.click();
				waitTilldisableOfElement(10);
				break;
				
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,partnerIcon +" is not present");
		}					
	}
	
	
	public void confirmMapAlert(String expMsg) throws Exception {
		logInfo("Entered into confirmMapAlert() method.");	
		boolean isPresent=false;			
		sleep(8000);
		wdWait(css, mapAlert);
		String conMsg=getText(css, mapAlert);			
		if(conMsg.equalsIgnoreCase(expMsg)) {
			isPresent=true;
			clickOnButton(css, zonDelYes);						
		}if(!isPresent){
			clickOnButton(css, zonDelYes);				
			Assert.assertEquals(conMsg,expMsg);
		}
	}
	
	public void selectFilter(String expFilter, String option) throws Exception {
		logInfo("Entered into selectFilter() method.");	
		boolean isPresent=false;
		wdWait(css, filterLabels);
		int filterSize=driver.findElements(By.cssSelector(filterLabels)).size();
		for(int i=1;i<=filterSize;i++) {
			String filterName=getText(css, filterLabelBfr+i+filterLabelAft);
			if(filterName.contains(expFilter)) {
				isPresent=true;
				clickOnButton(css, filterLabelBfr+i+filterDropDownAft);
				sleep(3000);
				selectExpectedDetailsFromDD(option);
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expFilter +" filter is not present");
		}
		
	}
	
	public void dynamicSelectionFromDropdown() throws Exception {
		logInfo("Entered into dynamicSelectionFromDropdown() method.");
		wdWait(css, zoneOptions);		
		int opt = driver.findElements(By.cssSelector(zoneOptions)).size();
		System.out.println(opt);
		if(opt==0) {
			System.err.println("options are not available");
		}else if(opt==1){			
			WebElement option =driver.findElement(By.cssSelector(zoneOptionsBfr+2+zoneOptionsAft));
			System.out.println("1 is "+option.getText());
			option.click();
		}else {
			System.out.println("ewrwe");
			int i=TestBase.generateRandomNumberInRange(3, opt+1);
			WebElement option =driver.findElement(By.cssSelector(zoneOptionsBfr+i+zoneOptionsAft));
			option.click();
		}
	}
	
	public void selectExpectedDetailsFromDD(String expOption) throws Exception {
		logInfo("Entered into selectExpectedDetailsFromDD() method.");
		wdWait(css, zoneOptions);		
		sleep(3000);
		boolean isPresentData=false;
		String optName=null;
		int opt = driver.findElements(By.cssSelector(zoneOptions)).size();		
		if(opt==0) {
			System.err.println("options are not available");
			
		}else {
			sleep(3000);
			for(int i=2;i<=opt+1;i++) {				
			WebElement option =driver.findElement(By.cssSelector(zoneOptionsBfr+i+zoneOptionsAft));
			optName=option.getText().trim();			
			if(optName.equalsIgnoreCase(expOption)) {
				isPresentData=true;
				scrollDown(css, zoneOptionsBfr+(i-1)+zoneOptionsAft);
				option.click();				
				sleep(6000);	  							
				break;
			}

		}if(!isPresentData) {
			selectFilter(filSort, "Descending");
			Assert.assertEquals(optName, expOption);
			}
		}
	}
	
	
	public void selectExpectedDetailsFromDD_OLD(String expOption) throws Exception {
		logInfo("Entered into selectExpectedDetailsFromDD() method.");
		wdWait(css, zoneOptions);		
		sleep(3000);
		boolean isPresentData=false;
		String optName=null;
		int opt = driver.findElements(By.cssSelector(zoneOptions)).size();
		System.out.println("count is :"+opt);
		if(opt==0) {
			System.err.println("options are not available");
			
		}else {
			for(int i=2;i<=opt+1;i++) {				
			WebElement option =driver.findElement(By.cssSelector(zoneOptionsBfr+i+zoneOptionsAft));
			optName=option.getText().trim();
			scrollDown(css, zoneOptionsBfr+i+zoneOptionsAft);
			System.out.println("optName :"+optName);
			if(optName.equalsIgnoreCase(expOption)) {
				isPresentData=true;
				option.click();				
				sleep(6000);	
	    		String wndBeforeWindow = driver().getWindowHandle();	    		
	    		for(String w : driver().getWindowHandles()){
	    			if(!w.equalsIgnoreCase(wndBeforeWindow)){
	    		           driver.switchTo().window(w);
	    		           System.out.println("child");
	    			}else {
	    				driver.switchTo().defaultContent();	    			
	    				WebElement search= driver.findElement(By.cssSelector(umSearch));	
	    				System.out.println("enter "+search.getAttribute("placeholder"));
	    				search.sendKeys("hello");
	    				search.sendKeys(Keys.TAB);
	    			}
	    		}   							
				break;
			}
			WebElement tabbing =driver.findElement(By.cssSelector(zoneOptionsBfr+i+checkBoxAft));
			tabbing.sendKeys(Keys.TAB);
			sleep(5000);
			System.out.println("execute ");
		}if(!isPresentData) {
			Assert.assertEquals(optName, expOption);
			}
		}
	}
	
	public void apply() throws Exception {
		logInfo("Entered into apply() method.");		
		sleep(5000);
		wdWait(css, umSearch);
		WebElement serch= driver.findElement(By.cssSelector(umSearch));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", serch);
		enterText(css, umSearch, "test");
		clearText(css, umSearch);
		sleep(5000);	
		int size=driver.findElements(By.cssSelector(filterApply)).size();
		if(size==0) {
			Assert.assertEquals(size, 1);
		}else {
			scrollDown(css, filterApply);
			int greySize=driver.findElements(By.cssSelector(filterApplyGreyed)).size();
			if(greySize==1) {
				System.err.println("Apply button is greyed, No filters are selected .");
				Assert.assertEquals(1, 0);
			}else {				
				WebElement applyBtn= driver.findElement(By.cssSelector(filterApply));		
				executor.executeScript("arguments[0].click();", applyBtn);
				
			}		
		}	
	}
	
	
	public void filterClose() throws Exception {
		logInfo("Entered into filterClose() method.");
		int size=driver.findElements(By.cssSelector(filterClose)).size();
		if(size==0) {
			System.out.println("filter is not avaialble");
		}else {
			scrollDown(css, filterClose);
			clickOnObject(css, filterClose);
		}
		
		
	}
	
	public String getSelectedState() throws Exception {
		logInfo("Entered into getSelectedState() method.");
		sleep(4000);
		scrollDown(name, address1Field);
		String actState=getText(xpath, getState);
		System.out.println("state: "+actState);
		return actState;
		
	}
	
	//retrieves present day rainy chances.
	public double getCurrentDayRainChance() throws Exception {
		logInfo("Entered into getCurrentDayRainChance() method.");
		int rainSize=driver.findElements(By.xpath(rainChance)).size();
		double rainPercent = 0.00;
		if(rainSize==0) {
			int rainsSize=driver.findElements(By.xpath(chanceOfRainReport)).size();
			if(rainsSize==1) {
				String chance=getText(xpath, chanceOfRainReport);
				String rainy = chance.replaceAll("[^0-9]", "");
				rainPercent=Double.parseDouble(rainy);	
			}			
		}else if (rainSize==1) {
		wdWait(xpath, rainChance);
		scrollDown(xpath, rainChance);
		String rain=getText(xpath, rainChance);		
		if(rain.length()>1) {
			String rainy = rain.replaceAll("[^0-9]", "");
			rainPercent=Double.parseDouble(rainy);
		}else {
			rainPercent=0.00;
		}		
		}
		return rainPercent;		
		
	}
	
	//retrieves present day ET value.
		public double getCurrentDayET() throws Exception {
			logInfo("Entered into getCurrentDayET() method.");
			int etSize=driver.findElements(By.xpath(ETAtSite)).size();
			double et=0.00;
			if(etSize==1) {
				wdWait(xpath, ETAtSite);
				String rain=getText(xpath, ETAtSite);
				System.out.println("ET "+rain);
			    String rainy = rain.replaceAll("[^0-9]", "");
				et=Double.parseDouble(rainy);
				
			}
			
		
			return et;
			
		}
		
	//retrieves present day ET value.
	public int getCurrentDayWind() throws Exception {
		logInfo("Entered into getCurrentDayWind() method.");
		wdWait(xpath, windAtWeather);
		String windMPH=getText(xpath, windAtWeather);
		String wind = windMPH.replaceAll("[^0-9]", "");
		int et=Integer.parseInt(wind);
		return et;
		
	}
	
	public void inputWindSpeed(int expWind) throws Exception {
		logInfo("Entered into inputWindSpeed() method.");
		String text= Integer.toString(expWind);
		wdWait(xpath, windSliderStatus);
		List<WebElement> slider=driver.findElements(By.xpath(windSliderStatus));
		if(!(slider.size()==0)) {
		String windStatus=getAttribute(xpath, windSliderStatus, ariaChecked);
		System.out.println(windStatus);
		if(windStatus.equalsIgnoreCase("false")) {
			System.out.println("its a false");
			clickOnObject(xpath, windSlider);
		}else {
			
		}
		
		
		clearText(xpath, windInput);
		enterText(xpath, windInput, text);
		
		}else {	
			System.err.println("Wind Speed Toggle is not present.");
			Assert.assertEquals(slider.size(),1);		
		}
	
	}
	
	public void inputChanceOfRain(double expChanceOfRain) throws Exception {
		logInfo("Entered into inputChanceOfRain() method.");
		String text= Double.toString(expChanceOfRain);
		wdWait(xpath, rainSliderStatus);
		List<WebElement> slider=driver.findElements(By.xpath(rainSliderStatus));
		if(!(slider.size()==0)) {
		String rainStaus=getAttribute(xpath, rainSliderStatus, ariaChecked);
		System.out.println(rainStaus);
		if(rainStaus.equalsIgnoreCase("false")) {			
			clickOnObject(xpath, rainSlider);
		}		
		clearText(name, rainField);
		enterText(name, rainField, text);
		
		}else {	
			System.err.println("Rain Sensor Toggle is not present.");
			Assert.assertEquals(slider.size(),1);		
		}
	
	}	
	
	public void updateSiteWithConfirmMsg() throws Exception {
		logInfo("Entered into selectSiteUpdateBtn() method.");
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		wdWait(xpath, updateBtn);	
		scrollDown(css, umOrgList);
		System.out.println("sdd "+getText(xpath, updateBtn));
		clickOnButton(xpath, updateBtn);
		WebElement update= driver.findElement(By.xpath(updateBtn));
		js.executeScript("arguments[0].click();", update);		
		confirmModalBox(succssUpdateMsg);			
	}
	
	public void chanceOfRainForAllDays() throws Exception {
		logInfo("Entered into chanceOfRainForAllDays() method.");		
		List<WebElement> backArrow= driver.findElements(By.cssSelector(backArrowWeather));
		if(backArrow.size()>0) {
			clickOnObject(css, backArrowWeather); 
		}
		
		int chanceOfRain= driver.findElements(By.xpath(daysList)).size();
		for(int i=1;i<=chanceOfRain; i++) {
			String eachChance= daysList+"["+i+"]"+chanceOfRainforDays;
			String chanceRainPerDay =getText(xpath , eachChance);	
			String [] split = chanceRainPerDay.split(" ");
			String cor= split[0];
			//String onlyNum = chanceRainPerDay.replaceAll("^0-9", "");
			
			//String rainy = chanceRainPerDay.replaceAll("[^0-9]", "");
			int rainPercent=Integer.parseInt(cor);				
		}
		
		
		
		
		
	}
	
	
	
	
	
}
