package smrtRain.home;

import java.text.DecimalFormat;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(1)
public class GeneralTests extends GeneralMethods{
	
	
	@Test(priority=101)
	public void loginWithValidCredentials() throws Exception {	
		logInfo("Enter into loginWithValidCredentials() tests.");			
		loginCredenditals(adminUser, adminPassword);			 
//		editProfile();
//		chooseLanguage(lanEng);
//		confirmUpdatedProfile(succProfileMsg);
		
		}
	
	@Test(priority=102)
	public void verifyAllTabs() throws Exception {
		logInfo("Enter into verifyAllTabs() tests.");
		navigateToModule(homePage);
		
		}
	
	@Test(priority=111)
	public void waterSavedDetails() throws Exception {
		logInfo("Enter into waterSavedDetails() tests.");
		navigateToModule(homePage);
		sleep(7000);
		getCardTitle(cardWaterText);		
		calculateSavedDetails();
		
		}
	
	@Test(priority=112)
	public void moneySavedDetails() throws Exception {
		logInfo("Enter into moneySavedDetails() tests.");
		navigateToModule(homePage);
		getCardTitle(cardMoneyText);
		getDaysDetails(cardMoneyText, daysYear);
		calculateSavedDetails();
		
		}
	
	@Test(priority=113)
	public void verifyDaysButtons() throws Exception {
		logInfo("Enter into verifyDaysButtons() tests.");		
		getCardTitle(cardMoneyText);
		validateDayLabel(cardMoneyText, daysYear);
		
		}
	

}
