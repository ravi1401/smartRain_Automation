package smrtRain.settings;

import org.testng.annotations.Test;

import com.lib.Priority;



@Priority (15)
public class SiteNotificationTests extends SettingMethods{
	
	@Test(priority= 1501)
	public void setting_AddNotification() throws Exception {
		 logInfo("Entered into setting_AddNotification() test.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(10000);
		settingHeader(siteNotification);
//		addNotification();
//		//validateLabelOfAddNotification();
//	validateSubHeadings(subHeadrs);
//	addNotifications();
//	confirmationMessage("Notification successfully added");
	}
	
	
	

}
