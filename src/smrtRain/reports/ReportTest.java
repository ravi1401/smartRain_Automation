package smrtRain.reports;

import org.testng.annotations.Test;

import com.lib.Priority;
@Priority(24)
public class ReportTest extends ReportMethod {
	@Test(priority=2401)
	public void sp_validateReportFunctionality() throws Exception{
		logInfo("Entered into sp_validateReportFunctionality()  test.");
		threadSleep(20000);
		navigateToModule(settingsPage);
		threadSleep(2000);
		navigateToModule(reportsPage);
		threadSleep(2000);
		verifyReportTypes(reportTypeList);
		reportType(siteText);
		threadSleep(2000);
		verifySubOptions(subOptionListSite);
		reportType(alAll);
		threadSleep(1000);
		verifySubOptionsBasedOnReportType(siteText,subOptionListSite);
		reportType(alAll);
		threadSleep(1000);
		sitesDropDownclick();
		threadSleep(35000);
		selectSiteFromDropdown(sitenameREport);
		threadSleep(2000);
		verifyTableHeaders(tblHeadersSites);
		threadSleep(3000);
		verifiSites(sitenameREport);
		threadSleep(2000);
		refreshScreen();
		threadSleep(10000);
		
		verifySubOptionsBasedOnReportType(waterUsage,subOptionListWaterUsage);
		reportType(alAll);
		threadSleep(2000);
		sitesDropDownclick();
		threadSleep(35000);
		selectSiteFromDropdown(reportSitename);
		threadSleep(2000);
		verifyTableHeaders(tblHeadersWaterUsage);
		threadSleep(3000);
		verifiSites(reportSitename);
		threadSleep(2000);
		refreshScreen();
		threadSleep(10000);
		
		verifySubOptionsBasedOnReportType(wether,subOptionListWeather);
		reportType(alAll);
		threadSleep(1000);
		sitesDropDownclick();
		threadSleep(35000);
		selectSiteFromDropdown(reportSitename);
		threadSleep(2000);
		verifyTableHeaders(tblHeadersWeather);
		threadSleep(3000);
		verifiSites(reportSitename);
		threadSleep(2000);
		refreshScreen();
		threadSleep(10000);
		
		verifySubOptionsBasedOnReportType(activityLog,subOptionListActivityLog);
		reportType(alAll);
		threadSleep(1000);
		sitesDropDownclick();
		threadSleep(35000);
		selectSiteFromDropdown(sitenameREport);
		threadSleep(2000);
		verifyTableHeaders(tblHeadersActivityLog);
		threadSleep(4000);
		refreshScreen();
		threadSleep(10000);
		
		verifyReportTypes(reportTypeList);
		reportType(rebootCount);
		threadSleep(1000);
		sitesDropDownclickReboot();
		threadSleep(35000);
		selectSiteFromDropdown(sitenameREport);
		threadSleep(2000);
		verifyTableHeaders(tblHeadersRebootCount);
		threadSleep(5000);
		refreshScreen();
		threadSleep(10000);
		
		verifyReportTypes(reportTypeList);
		reportType(alDevice);
		threadSleep(1000);
		sitesDropDownclickReboot();
		threadSleep(35000);
		selectSiteFromDropdown(sitenameREport);
		threadSleep(2000);
		verifyTableHeaders(tblHeaderDevice);
		threadSleep(5000);
		refreshScreen();
		threadSleep(10000);
		

		
	}

	
}
