package smrtRain.spanish;
import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;

import smrtRain.advanceConfig.AdvanceConfigMethods;
@Priority(23)
public class SpanishAdv extends AdvanceConfigMethods {
	SpanishMethods spanMeth =new SpanishMethods();
	@Test(priority=2301)
	public void sp_validateZonesLabels() throws Exception{
		logInfo("Entered into sp_validateZonesLabels() test.");
		sleep(2000);
		navigateToModule(spSetting);
		sleep(2000);
		navigateToModule(spReports);
		sleep(10000);
		navigateToModule(spSites);
		sleep(30000);
		selectSiteFromAllSites(newSiteName);
		sleep(3000);
		selectMenuIconInSite(iconMap);
		selectMenuIconInSite(iconZone);
		spanMeth.validateZones();
		spanMeth.validateAddZones();
		spanMeth.validateAdvConfigpopup();
		sleep(3000);
		spanMeth.validateAdvanceConfig();
		spanMeth.validateInstructions1stQuestion(sp_HelpSubHeader);
		subHeaders(sp_BaseRunTimeLab);
		//subHeaders(sp_EfficiencyAdjLab);
		//subHeaders(sp_RunTimeAdjLab);
		//subHeaders(sp_RuntimeTotallab);
		sideHeaders(sp_SoilTYpeLab);
		sideHeaders(sp_RootDepthLab);
		sideHeaders(sp_slopeLab);
		spanMeth.Sidelabels();
		baseRunTimeSubTabs(sp_TotalIrrigationAmtLab);
		//baseRunTimeSubTabs(sp_precipitionRateLab);
		selectOptionUnderStepper(soilClayLoam);
		selectOptionUnderStepper(rd3Inc);
		selectOptionUnderStepper(slopeOption);
		
		
	}
	@Test(priority=2302)
	public void sp_validatePrecipitationLab() throws Exception{
		logInfo("Entered into sp_validatePrecipitationLab() test.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		sleep(2000);
		spanMeth.validatePrecipition();
		precipitationRateRadios(irrRotor);
		precipitationRateRadios(irrSpray);
		precipitationRateRadios(irrDrip);
		sleep(2000);
		precipitationRateRadios(sp_equilateralLab);
		precipitationRateRadios(sp_rectangularLab);
		spanMeth.validateDropDownProcipition();
		selectManufacturerDetails(manufacturer, irrManuOpt);
		selectManufacturerDetails(series, dripSeries);
		selectManufacturerDetails(model, dripModel);
		selectManufacturerDetails(psi, dripPSI);
		selectNozzle(dripSeries+" "+dripModel);
		spanMeth.validateBaseRun();
		subHeaders(sp_EfficiencyAdjLab);
		spanMeth.validateLabelsEfficiencyAdjustment();
		getIrrTypeEfficiency();
		efficiencyType(veryGood);
		subHeaders(sp_RunTimeAdjLab);
		plantTypeUnderRunTimeAdjust(sp_adjustLandscape);
		spanMeth.validateAdjustLandscape();
		plantTypeUnderRunTimeAdjust(sp_adjustPercentage);
		spanMeth.validateAdjustPercentage();
		percentage(expPercenatge);
		subHeaders(sp_RuntimeTotallab);
		sleep(5000);
		spanMeth.validateUnderRuntimeTotal();
		closeAdvanceConfigPopup();
		closeZone();
	}
}
