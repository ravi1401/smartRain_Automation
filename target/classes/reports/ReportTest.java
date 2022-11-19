package smrtRain.reports;

import org.testng.annotations.Test;

import com.lib.Priority;
@Priority(24)
public class ReportTest extends ReportMethod {
	@Test(priority=2401)
	public void sp_validateReportFunctionality() throws Exception{
		logInfo("Entered into sp_validateReportFunctionality()  test.");
		sleep(20000);
		navigateToModule(settingsPage);
		sleep(2000);
		navigateToModule(reportsPage);
		sleep(2000);
		verifyReportTypes(reportTypeList);
		reportType(siteText);
		sleep(2000);
		verifySubOptions(subOptionListSite);
		reportType(alAll);
		sleep(1000);
		verifySubOptionsBasedOnReportType(siteText,subOptionListSite);
		reportType(alAll);
		sleep(1000);
		sitesDropDownclick();
		sleep(35000);
		selectSiteFromDropdown(sitenameREport);
		sleep(2000);
		verifyTableHeaders(tblHeadersSites);
		sleep(3000);
		verifiSites(sitenameREport);
		sleep(2000);
		refreshScreen();
		sleep(10000);
		
		verifySubOptionsBasedOnReportType(waterUsage,subOptionListWaterUsage);
		reportType(alAll);
		sleep(2000);
		sitesDropDownclick();
		sleep(35000);
		selectSiteFromDropdown(reportSitename);
		sleep(2000);
		verifyTableHeaders(tblHeadersWaterUsage);
		sleep(3000);
		verifiSites(reportSitename);
		sleep(2000);
		refreshScreen();
		sleep(10000);
		
		verifySubOptionsBasedOnReportType(wether,subOptionListWeather);
		reportType(alAll);
		sleep(1000);
		sitesDropDownclick();
		sleep(35000);
		selectSiteFromDropdown(reportSitename);
		sleep(2000);
		verifyTableHeaders(tblHeadersWeather);
		sleep(3000);
		verifiSites(reportSitename);
		sleep(2000);
		refreshScreen();
		sleep(10000);
		
		verifySubOptionsBasedOnReportType(activityLog,subOptionListActivityLog);
		reportType(alAll);
		sleep(1000);
		sitesDropDownclick();
		sleep(35000);
		selectSiteFromDropdown(sitenameREport);
		sleep(2000);
		verifyTableHeaders(tblHeadersActivityLog);
		sleep(4000);
		refreshScreen();
		sleep(10000);
		
		verifyReportTypes(reportTypeList);
		reportType(rebootCount);
		sleep(1000);
		sitesDropDownclickReboot();
		sleep(35000);
		selectSiteFromDropdown(sitenameREport);
		sleep(2000);
		verifyTableHeaders(tblHeadersRebootCount);
		sleep(5000);
		refreshScreen();
		sleep(10000);
		
		verifyReportTypes(reportTypeList);
		reportType(alDevice);
		sleep(1000);
		sitesDropDownclickReboot();
		sleep(35000);
		selectSiteFromDropdown(sitenameREport);
		sleep(2000);
		verifyTableHeaders(tblHeaderDevice);
		sleep(5000);
		refreshScreen();
		sleep(10000);
		

		
	}

	
}
