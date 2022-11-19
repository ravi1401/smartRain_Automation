package smrtRain.userManagement;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(14)
public class UserManagementTests extends UserManagementMethods {
	
	@Test(priority=1400)
	public void inviteUser() throws Exception {
		logInfo("Entered into inviteUser() test.");
		sleep(20000);
		navigateToModule(settingsPage);
		sleep(10000);
		navigateToModule(userManagementPage);
		sleep(10000);
		invitation(mailId,"CBRE");
		confirmModalBox(umSuccsMsg);		
	}
	
	//@Test(priority=1401)
	public void validateInviteUserDetails() throws Exception {
		logInfo("Entered into validateInviteUserDetails() test.");
		Thread.sleep(10000);
		navigateToModule(reportsPage);
		navigateToModule(sitesPage);
		verifyMandatoryFieldsOfInviteUser();
		invitation(mailId,"Landscaper");
		
		confirmModalBox(umSuccsMsg);
		
	}
	
	@Test(priority=1402)
	public void verifyStatusOfInvitedUser() throws Exception {
		logInfo("Entered into verifyStatusOfInvitedUser() test.");
//		sleep(10000);
//		navigateToModule(settingsPage);
		sleep(7000);
		navigateToModule(userManagementPage);		
		getInvitedEmail(mailId,userStatPen);		
	}
	
	@Test(priority=1403)
	public void changeUserStatusToRevoke() throws Exception {
		logInfo("Entered into changeUserStatusToRevoke() test.");		
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		navigateToModule(userManagementPage);		
		selectArchive(mailId);
		confirmStatusModelBox(userConfMsg+mailId+userConfMsgEnd);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		navigateToModule(userManagementPage);		
		getInvitedEmail(mailId,userStatRev);	
	}
	
	@Test(priority=1404)
	public void searchInvitedUsers() throws Exception {
		logInfo("Entered into searchInvitedUsers() test.");
		String text="test";
		invitedSearch(text);
		verfiySearchResults(text);
	}
	
	@Test(priority=1405)
	public void validateLabels() throws Exception {
		logInfo("Entered into validateLabels() test.");
		getLabelsOfInvitedUsers();
		applicationUsersLabels();
		appUsersTableLabels();
	}
	
	@Test(priority=1406)
	public void changeUserFromDeactiveToActive() throws Exception {
		logInfo("Entered into changeUserFromDeactiveToActive() test.");	
		sleep(20000);
		navigateToModule(settingsPage);
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(7000);
		String userMail= inactiveUser();
		System.out.println("val: "+userMail);
		
		activateBtn(umActivate);		
		confirmStatusModelBox(actText+userMail);     //+userConfMsgEnd
		sleep(7000);
		confirmModalBox(userStats);
		sleep(6000);
		getStatus(umDeactivate);
		activateBtn(umDeactivate);		
		confirmStatusModelBox(deactText+userMail);     //+userConfMsgEnd
		confirmModalBox(userStats);
		navigateToModule(homePage);
		am.showMore();
		am.overlayHeaderFunctions(alRfsh);
		am.verifyDataFromColumn(4, alDescp,userMail+logActStatus); 
		
	}	
	@Test(priority=1407)
	public void changeUserFromActiveToDeactive() throws Exception {
		logInfo("Entered into changeUserFromActiveToDeactive() test.");	
		sleep(20000);
		navigateToModule(settingsPage);
		sleep(10000);
		navigateToModule(userManagementPage);
		sleep(4000);
		String userName=getProfileName();
		selectActiveUser();
		String actMailId= getEmail();
		System.out.println("actMailId : " + actMailId);
		activateBtn(umDeactivate);		
		confirmStatusModelBox(deactText+actMailId);   //userConfMsgEnd
		sleep(3000);
		confirmModalBox(userStats);
		getStatus(umActivate);
		activateBtn(umActivate);		
		confirmStatusModelBox(actText+actMailId);  //+userConfMsgEnd
		sleep(4000);
		confirmModalBox(userStats);
		navigateToModule(homePage);
		am.showMore();
		am.overlayHeaderFunctions(alRfsh);
		int statusRow = am.verifyDataFromColumn(4, alDescp,actMailId+logInactStatus); 
		am.isDataPresentInColumn(statusRow, alEmp, userName);	
		am.isDataPresentInColumn(statusRow, alActivity, textEmp);	
	}
	
	
	
	
	
	
	
	
	
	
	

}
