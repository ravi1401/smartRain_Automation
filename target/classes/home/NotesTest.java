package smrtRain.home;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(21)
public class NotesTest extends NoteMethods{
	
	
	@Test(priority=2101)
	public void addNewNotesFromHome() throws Exception {	
		logInfo("Enter into addNewNotesFromHome() tests");	
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(homePage);
		selectAddButton();
		createNoteDetails(expTagAlerts+noteTitle, noteTitle+noteDescrip);
		selectSite(newSiteName);
//		expandTagDropdown();
//		selectTag(expTagAlerts);
//		selectTag(expTagDevice);
//		createNoteBtn();
//		confirmNote();
		
			
		}
	
	@Test(priority=2102)
	public void verifyMandatoryFields() throws Exception {	
		logInfo("Enter into verifyMandatoryFields() tests");	
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(homePage);
		validateNoteObjects();
		
		}
	
	
	@Test(priority=2103)
	public void checkNewNotesInListView() throws Exception {	
		logInfo("Enter into checkNewNotesInListView() tests");
//		sleep(20000);	
//		navigateToModule(alertsPage);
//		sleep(10000);
//		navigateToModule(homePage);
//		sleep(10000);
		selectViewAll();
		validateTagsUnderHomeScreen(newSiteName,expTagAlerts+noteTitle, noteTitle+noteDescrip);
		closeNotes();
			
		}
	
	@Test(priority=2104)
	public void IsNotesAddedInSite() throws Exception {	
		logInfo("Enter into IsNotesAddedInSite() tests");	
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);				
		navigateToModule(sitesPage);
		sleep(20000);
		searchAndSelectExistingSite(newSiteName);    
		sleep(10000);
		selectViewAll();
		validateTagsUnderSite(expTagAlerts+noteTitle, noteTitle+noteDescrip);		
		closeNotes();
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);	
		int noteRow =verifyDataFromColumn(5, alDescp,noteCreateLog+expTagAlerts+noteTitle); 		
		selectExactPacketFromLogsTable(noteRow, alSeeNote);		
		getPacketData(noteTitle+noteDescrip);
		closePacket();
			
		}
	
	@Test(priority=2105)
	public void addNotesInSiteAndViewInList() throws Exception {	
		logInfo("Enter into addNotesInSiteAndViewInList() tests");	
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(userManagementPage);
		sleep(10000);
		
			
		}
	
	

}
