package smrtRain.advanceConfig;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;

@Priority(4)
public class AdvanceConfigTests extends AdvanceConfigMethods{
	
	@Test(priority=401)
	public void validateAdvanceConfigLabels() throws Exception {		
		logInfo("Entered into validateAdvanceConfigLabels() method.");
		threadSleep(20000);	
		navigateToModule(settingsPage);
		threadSleep(10000);	
		navigateToModule(sitesPage);
		threadSleep(20000);		
		selectExistingSite(existSiteFM50);   //newSiteName   "488_GreenFields" "Argenta Apartments B"
		threadSleep(10000);	
		selectMenuIconInSite(iconZone);
		threadSleep(10000);
		createAdvanceZone(advanceZoneName);
		selectZoneNumber();				
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");		
		validateLabels();
		subHeaders(advConHeaderBaseTab);
		subHeaders(advConHeaderEffcyTab);
		subHeaders(advConHeaderRunTimeTab);
		subHeaders(advConHeaderTotalsTab);
		sideHeaders(advSoil);
		sideHeaders(advRoot);
		sideHeaders(advSlope);
		irrigationAmount();
		baseRunTimeSubTabs(totIrrAmtLab);
		baseRunTimeSubTabs(preRate);
		//baseRunTimeSubTabs(advConHeaderBaseTab);
		selectOptionUnderStepper(soilClayLoam);
		isSelectedSoilType(soilClayLoam);
		validateFollowInstructions1stQuestion(followInstrSubText);
		
	}
	
	
	@Test(priority=402)
	public void verifySoilTypeDetermineForSandyLoam() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSandyLoam() method.");		
		continueFollowInstructions1stQuestion();		
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnYes, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?		
		actionButton(btnYes);
		identifySoilType(detSandyLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilSandyLoam);		
		
	}
	
	@Test(priority=403)
	public void verifySoilTypeDetermineForSiltLoam() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSiltLoam() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnYes, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?			
		actionButton(btnNo, descSmooth);		
		actionButton(btnYes);
		identifySoilType(detSiltLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilSiltLoam);		
		
	}
	
	@Test(priority=404)
	public void verifySoilTypeDetermineForLoam() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForLoam() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnYes, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?			
		actionButton(btnNo, descSmooth);	
		//Does gritty feeling predominate?			
		actionButton(btnNo, descNeitherGritty);
		actionButton(btnYes);
		identifySoilType(detLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilLoam);		
		
	}
	
	
	@Test(priority=405)
	public void verifySoilTypeDetermineForSandyClayLoam() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSandyClayLoam() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnYes, descExelyWet);		
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?			
	
		
		
		actionButton(btnYes);
		identifySoilType(detSandyClayLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilSandyClayLoam);		
		
	}
	
	
	@Test(priority=406)
	public void verifySoilTypeDetermineForSiltyClayLoam() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSiltyClayLoam() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnYes, descExelyWet);		
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?
		actionButton(btnNo, descSmooth);		
		actionButton(btnYes);
		identifySoilType(detSiltyClayLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilSiltyClayLoam);		
		
	}
	
	
	@Test(priority=407)
	public void verifySoilTypeDetermineForClayLoam() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForClayLoam() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnYes, descExelyWet);		
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?
		actionButton(btnNo, descSmooth);		
		
		actionButton(btnNo, descNeitherGritty);	
		
		actionButton(btnYes);
		identifySoilType(detClayLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilClayLoam);		
		
	}
	
	@Test(priority=408)
	public void verifySoilTypeDetermineForSandyClay() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForClayLoam() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnContinue, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?
		actionButton(btnYes);
		identifySoilType(detSandyClay);
		sideHeaders(advSoil);
		isSelectedSoilType(soilSandyClay);		
		
	}
	
	
	@Test(priority=409)
	public void verifySoilTypeDetermineForSiltyClay() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSiltyClay() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnContinue, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?
		actionButton(btnNo, descSmooth);		
		actionButton(btnYes);
		identifySoilType(detSiltyClay);
		sideHeaders(advSoil);
		isSelectedSoilType(soilSiltyClay);		
		
	}
	
	
	@Test(priority=410)
	public void verifySoilTypeDetermineForClay() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForLoam2() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnContinue, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);
		//Does gritty feeling predominate?
		actionButton(btnNo, descSmooth);			
		actionButton(btnNo, descNeitherGritty);			
		actionButton(btnYes);
		identifySoilType(detClay);
		sideHeaders(advSoil);
		isSelectedSoilType(soilClay);		
		
	}
	
	
	//@Test(priority=411)
	public void verifySoilTypeDetermineForSandyLoam2() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForLoam2() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnContinue, desc1inchRibbon);
//		actionButton(btnYes, descExelyWet);
//		//Excessively wet a small pinch of soil in palm and rub with forefinger.
//		actionButton(btnContinue, descGritty);	
//		actionButton(btnYes);
//		identifySoilType(detSandyLoam);
//		sideHeaders(advSoil);
//		isSelectedSoilType(soilSandyLoam);		
		
	}
	
	
	//@Test(priority=412)
	public void verifySoilTypeDetermineForSiltLoam2() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSiltLoam2() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnNo, desc1inchRibbon);
		actionButton(btnYes, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);	
		//Does gritty feeling predominate?
		actionButton(btnNo, descSmooth);		
		actionButton(btnYes);
		identifySoilType(detSiltLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilSiltLoam);			
		
	}
	
	
	//@Test(priority=413)
	public void verifySoilTypeDetermineForLoam3() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForLoam3() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnNo, desc1inchRibbon);
		actionButton(btnYes, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);	
		//Does gritty feeling predominate?
		actionButton(btnNo, descSmooth);
		//Neither grittiness nor smoothness predominates
		actionButton(btnNo, descNeitherGritty);			
		actionButton(btnYes);
		identifySoilType(detLoam);
		sideHeaders(advSoil);
		isSelectedSoilType(soilLoam);		
		
	}
	
	
	//@Test(priority=414)
	public void verifySoilTypeDetermineForSandyClayLoam2() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSandyClayLoam2() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnNo, desc1inchRibbon);
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnYes, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);	
		actionButton(btnYes);
		identifySoilType(detSandyClayLoam);
		sideHeaders(advSoil);		
		isSelectedSoilType(soilSandyClayLoam);	
		
	}
	
	
	//@Test(priority=415)
	public void verifySoilTypeDetermineForSandyClay2() throws Exception {		
		logInfo("Entered into verifySoilTypeDetermineForSandyClayLoam2() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnYes,descPlaceSoilInThumb);
		//Place ball of soil between thumb and forefinger
		actionButton(btnContinue, descSoilRibbon);
		//Does the soil form a ribbon?
		actionButton(btnYes, desc1inchRibbon);
		//Does the soil make a ribbon 1" or less before breaking?
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);	
		//Does the soil make a ribbon 2\" or longer before breaking?
		actionButton(btnNo, desc1inchRibbon);
		actionButton(btnNo, descRibbon1to2);
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnNo, descRibbonMoreThan2);			
		//Does the soil make a ribbon 1\" to 2\" before breaking?
		actionButton(btnYes, descExelyWet);
		//Excessively wet a small pinch of soil in palm and rub with forefinger.
		actionButton(btnContinue, descGritty);	
		actionButton(btnYes);
		identifySoilType(detSandyClay);
		sideHeaders(advSoil);		
		isSelectedSoilType(soilSandyClay);	
		
	}
	
	
	@Test(priority=416)
	public void verifySoilTypeSandRepeatedCycle() throws Exception {
		logInfo("Entered into verifySoilTypeSandRepeatedCycle() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnNo, descIsDry);
		actionButton(btnYes, descSlowWater);
		//Add water slowly. Knead soil to wet all aggregates. Soil is at the proper
		actionButton(btnContinue, descSoilRemainBall);
		//Does the soil remain in a ball when squeezed?
		actionButton(btnNo, descIsDry);	
		actionButton(btnNo, descIsWet);	
		actionButton(btnNo);
		identifySoilType(detSand);
		sideHeaders(advSoil);		
		isSelectedSoilType(soilSand);	
		
		
	}
	
	@Test(priority=417)
	public void verifySoilTypeDetermineForSand() throws Exception {
		logInfo("Entered into verifySoilTypeDetermineForSand() method.");
		sideHeaders(advSoil);
		continueFollowInstructions1stQuestion();
		//Does the soil remain in a ball when squeezed? 
		actionButton(btnNo, descIsDry);
		actionButton(btnNo, descIsWet);	
		actionButton(btnNo);
		identifySoilType(detSand);
		sideHeaders(advSoil);		
		isSelectedSoilType(soilSand);			
	}
	
	
	@Test(priority=418)	
	public void advConfigSoilClayRotorRect() throws Exception {
		logInfo("Entered into advConfigSoilClayRotorRect() method.");
		int expPercenatge= TestBase.generateRandomNumberInRange(10,500);
		sideHeaders(advSoil);	
		verifyOptionsInSoilType(13,soilTypeOpt);
		selectOptionUnderStepper(soilSandyClayLoam);
		sideHeaders(advRoot);
		verifyOptionsInRootDepth(12,rootDepthOpt);
		selectOptionUnderStepper(rd3Inc);	
		sideHeaders(advSlope);
		verifyOptionsInSlope(4, slopeOpt);
		selectOptionUnderStepper(slopeOption);
		double getInches = calculateTotalIrrigationAmt(rd3);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);
		precipitationRateRadios(irrSpray);
		precipitationRateRadios(irrDrip);
		precipitationRateRadios(irrRotor);		
		precipitationRateRadios(precpRadEquil);
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, rotorManuOpt);
		selectManufacturerDetails(series, rotorSeries);
		//selectManufacturerDetails(model, rotorModel);
		selectManufacturerDetails(psi, rotorPSI);		
		selectNozzle(rotorSeries);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time
		
		subHeaders(advConHeaderEffcyTab);	
		getIrrTypeEfficiency();
		efficiencyType(good);
		double getRunTimeMultipler = runTimeMultiplier(irrRotor, good);		
		double effAdjustmentValue= calculateEfficiencyAdjustment(totalBase,getRunTimeMultipler);
		validateEfficiencyAdjust(effAdjustmentValue);
		subHeaders(advConHeaderRunTimeTab);	
		plantTypeUnderRunTimeAdjust(adjustLandScp);
		plantTypeUnderRunTimeAdjust(adjustPercent);		
		percentage(expPercenatge);
		//calculateRuntimePercentage(totalBase,expPercenatge);
		double expRuntTimeAdjustment =calculateRuntimePercentage(totalBase,expPercenatge);		
		validateRunTimeAdjust(expRuntTimeAdjustment);
		subHeaders(advConHeaderRunTimeTab+concat1+expRuntTimeAdjustment+concat2);

		subHeaders(advConHeaderTotalsTab);
		
		
		//runtimeTotalsEachValue(rtTotalBase,totalBase);
		//runtimeTotalsEachValue(rtTotalEff,effAdjustmentValue);
		//closeAdvanceConfigPopup();
		selectApply();		
		closeZone();
	}
	
	@Test(priority=419)	
	public void advConfigSandDripRect() throws Exception {
		logInfo("Entered into advConfigSandDripRect() method.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		threadSleep(3000);	
		selectMenuIconInSite(iconZone);
		threadSleep(3000);
		createAdvanceZone(advanceZoneName);
		selectZoneNumber();	
		threadSleep(3000);	
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");
		selectOptionUnderStepper(soilSandyLoam);		
		selectOptionUnderStepper(rd12Inc);			
		selectOptionUnderStepper(slopeOption);		
		double getInches = calculateTotalIrrigationAmt(rd12);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);	
		precipitationRateRadios(irrDrip);
		
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, irrManuOpt);
		selectManufacturerDetails(series, dripSeries);
		selectManufacturerDetails(model, dripModel);
		selectManufacturerDetails(psi, dripPSI);		
		selectNozzle(dripSeries+" "+dripModel);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time		
		subHeaders(advConHeaderEffcyTab);		
		getIrrTypeEfficiency();
		efficiencyType(veryGood);
		double getRunTimeMultipler = runTimeMultiplier(irrDrip, veryGood);		
		double effAdjustmentValue= calculateEfficiencyAdjustment(totalBase,getRunTimeMultipler);
		validateEfficiencyAdjust(effAdjustmentValue);
		
		subHeaders(advConHeaderRunTimeTab);	
		plantTypeUnderRunTimeAdjust(adjustLandScp);
		plantTypeUnderRunTimeAdjust(adjustPercent);		
		percentage(expPercenatge);
		double expRuntTimeAdjustment =calculateRuntimePercentage(totalBase,expPercenatge);
		validateRunTimeAdjust(expRuntTimeAdjustment);
		subHeaders(advConHeaderRunTimeTab+concat1+expRuntTimeAdjustment+concat2);
		subHeaders(advConHeaderTotalsTab);	
		
		selectApply();
		closeZone();			
	}
	
	@Test(priority=420)	
	public void advConfigSandRotorRect() throws Exception {
		logInfo("Entered into advConfigSandDripRect() method.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		threadSleep(5000);	
		selectMenuIconInSite(iconZone);
		threadSleep(5000);
		createAdvanceZone(advanceZoneName);
		selectZoneNumber();	
		threadSleep(5000);	
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");
		selectOptionUnderStepper(soilSand);		
		selectOptionUnderStepper(rd2Inc);			
		selectOptionUnderStepper(slopeOption);		
		double getInches = calculateTotalIrrigationAmt(rd2);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);	
		precipitationRateRadios(irrSpray);
		
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, rotorManuHunter);
		selectManufacturerDetails(series, rotorHuntSeries);
		selectManufacturerDetails(model, rotorHuntModel);
		selectManufacturerDetails(psi, rotorHuntPSI);		
		selectNozzle(rotorHuntSeries+" "+rotorHuntModel);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time		
		subHeaders(advConHeaderEffcyTab);		
		getIrrTypeEfficiency();
		efficiencyType(poor);
		double getRunTimeMultipler = runTimeMultiplier(irrSpray, poor);		
		double effAdjustmentValue= calculateEfficiencyAdjustment(totalBase,getRunTimeMultipler);
		validateEfficiencyAdjust(effAdjustmentValue);
		
		subHeaders(advConHeaderRunTimeTab);	
		plantTypeUnderRunTimeAdjust(adjustLandScp);
		plantTypeUnderRunTimeAdjust(adjustPercent);		
		percentage(expPercenatge);
		double expRuntTimeAdjustment =calculateRuntimePercentage(totalBase,expPercenatge);
		validateRunTimeAdjust(expRuntTimeAdjustment);
		subHeaders(advConHeaderRunTimeTab+concat1+expRuntTimeAdjustment+concat2);
		subHeaders(advConHeaderTotalsTab);	
		selectApply();
		closeZone();			
	}
	
	@Test(priority=421)
	public void advConfigLoamDripRect() throws Exception {
		logInfo("Entered into advConfigLoamDripRect() method.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		threadSleep(5000);	
		selectMenuIconInSite(iconZone);
		threadSleep(5000);
		createAdvanceZone(advanceZoneLoamName);
		selectZoneNumber();	
		threadSleep(5000);	
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");
		selectOptionUnderStepper(soilLoam);		
		selectOptionUnderStepper(rd2Inc);			
		selectOptionUnderStepper(slopeOption);		
		double getInches = calculateTotalIrrigationAmt(rd2);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);	
		precipitationRateRadios(irrRotor);		
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, rotorManuHunter);
		selectManufacturerDetails(series, rotorHuntSeries2);
		selectManufacturerDetails(model, rotorHuntModel2);
		selectManufacturerDetails(psi, rotorHuntPSI2);		
		selectNozzle(rotorHuntSeries2+" "+rotorHuntModel2);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time		
		subHeaders(advConHeaderEffcyTab);		
		getIrrTypeEfficiency();
		efficiencyType(effXclent);
		double getRunTimeMultipler = runTimeMultiplier(irrRotor, effXclent);		
		double effAdjustmentValue= calculateEfficiencyAdjustment(totalBase,getRunTimeMultipler);
		double getEfficencyAdjustment =validateEfficiencyAdjust(effAdjustmentValue);
		
		subHeaders(advConHeaderRunTimeTab);			
		plantTypeUnderRunTimeAdjust(adjustPercent);		
		percentage(expPercenatge);
		double expRuntTimeAdjustment =calculateRuntimePercentage(totalBase,expPercenatge);
		double getRunTimeAdjustment = validateRunTimeAdjust(expRuntTimeAdjustment);
		subHeaders(advConHeaderRunTimeTab+concat1+expRuntTimeAdjustment+concat2);
		subHeaders(advConHeaderTotalsTab);	
		int runTimeTotal =calculateRunTimeTotal(totalBase, getEfficencyAdjustment, getRunTimeAdjustment);
		validateSRRecommenedRange(totalBase,runTimeTotal);
		minutesText();
		subHeaders(advConHeaderTotalsTab+concat1+runTimeTotal+concat2);		
		selectApply();
		addZoneFinalBtn();
		confirmModalBox(succssMsgText);		
		isZonePresent(advanceZoneLoamName);
	
		
		
	}
	
	@Test(priority=422)	
	public void advConfigClaySprayRect() throws Exception {
		logInfo("Entered into advConfigClaySprayRect() method.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		threadSleep(5000);	
		selectMenuIconInSite(iconProgram);
		selectMenuIconInSite(iconZone);
		threadSleep(5000);
		createAdvanceZone(advZoneClayName);
		selectZoneNumber();	
		threadSleep(5000);	
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");
		selectOptionUnderStepper(soilClay);		
		selectOptionUnderStepper(rd12Inc);			
		selectOptionUnderStepper(slopeOption);		
		double getInches = calculateTotalIrrigationAmt(rd12);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);	
		precipitationRateRadios(irrSpray);		
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, rotorManuWeather);
		selectManufacturerDetails(series, rotorWeatSeries);
		selectManufacturerDetails(model, rotorWeatModel);
		selectManufacturerDetails(psi, rotorWeatPSI);		
		selectNozzle(rotorWeatSeries+" "+rotorWeatModel);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time		
		subHeaders(advConHeaderEffcyTab);		
		getIrrTypeEfficiency();
		efficiencyType(effXclent);
		double getRunTimeMultipler = runTimeMultiplier(irrSpray, effXclent);		
		double effAdjustmentValue= calculateEfficiencyAdjustment(totalBase,getRunTimeMultipler);
		double getEfficencyAdjustment =validateEfficiencyAdjust(effAdjustmentValue);
		
		subHeaders(advConHeaderRunTimeTab);			
		plantTypeUnderRunTimeAdjust(adjustPercent);		
		percentage(expPercenatge);
		double expRuntTimeAdjustment =calculateRuntimePercentage(totalBase,expPercenatge);
		double getRunTimeAdjustment = validateRunTimeAdjust(expRuntTimeAdjustment);
		subHeaders(advConHeaderRunTimeTab+concat1+expRuntTimeAdjustment+concat2);
		subHeaders(advConHeaderTotalsTab);	
		int runTimeTotal =calculateRunTimeTotal(totalBase, getEfficencyAdjustment, getRunTimeAdjustment);
		validateSRRecommenedRange(totalBase,runTimeTotal);
		subHeaders(advConHeaderTotalsTab+concat1+runTimeTotal+concat2);		
		selectApply();
		addZoneFinalBtn();
		confirmModalBox(succssMsgText);	
		isZonePresent(advZoneClayName);
	}
	
	@Test(priority=423)
	public void advConfigSkipEffAdjustment() throws Exception {
		logInfo("Entered into advConfigSkipEffAdjustment() method.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		threadSleep(5000);	
		selectMenuIconInSite(iconProgram);
		selectMenuIconInSite(iconZone);
		threadSleep(5000);
		createAdvanceZone(advSkipName);
		selectZoneNumber();	
		threadSleep(4000);	
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");
		selectOptionUnderStepper(soilSiltyClay);		
		selectOptionUnderStepper(rd3Inc);			
		selectOptionUnderStepper(slopeOption);		
		double getInches = calculateTotalIrrigationAmt(rd3);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);	
		precipitationRateRadios(irrRotor);		
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, rotorManuIrrtol);
		selectManufacturerDetails(series, rotorIrrtolSeries);
		//selectManufacturerDetails(model, rotorWeatModel);
		selectManufacturerDetails(psi, rotorIrrtolPSI);		
		selectNozzle(rotorIrrtolSeries);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time		
		subHeaders(advConHeaderEffcyTab);			
		validateEfficiencyAdjustment(zeroMin);
		subHeaders(advConHeaderEffcyTab+concat1+0+concat2);	
		skipEffeciencyAdjust();	
		plantTypeUnderRunTimeAdjust(adjustPercent);	
		validateRunTimeAdjust(0);
		subHeaders(advConHeaderRunTimeTab+concat1+0+concat2);
		percentage(expPercenatge);
		double expRuntTimeAdjustment =calculateRuntimePercentage(totalBase,expPercenatge);
		double getRunTimeAdjustment = validateRunTimeAdjust(expRuntTimeAdjustment);
		subHeaders(advConHeaderRunTimeTab+concat1+expRuntTimeAdjustment+concat2);
		subHeaders(advConHeaderTotalsTab);	
		int runTimeTotal =calculateRunTimeTotal(totalBase, 0, getRunTimeAdjustment);
		validateSRRecommenedRange(totalBase,runTimeTotal);
		subHeaders(advConHeaderTotalsTab+concat1+runTimeTotal+concat2);	
		selectApply();
		addZoneFinalBtn();
		confirmModalBox(succssMsgText);			
		isZonePresent(advSkipName);			
	}
	
	@Test(priority=424)	
	public void advConfigSkipRunTimeAdjustment() throws Exception {
		logInfo("Entered into advConfigSkipRunTimeAdjustment() method.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		threadSleep(5000);	
		selectMenuIconInSite(iconProgram);
		selectMenuIconInSite(iconZone);
		threadSleep(5000);
		createAdvanceZone(advSkipRTName);
		selectZoneNumber();	
		threadSleep(4000);	
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");
		selectOptionUnderStepper(soilClay);		
		selectOptionUnderStepper(rd12Inc);			
		selectOptionUnderStepper(slopeOption);		
		double getInches = calculateTotalIrrigationAmt(rd12);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);	
		precipitationRateRadios(irrSpray);		
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, rotorManuWeather);
		selectManufacturerDetails(series, rotorWeatSeries);
		selectManufacturerDetails(model, rotorWeatModel);
		selectManufacturerDetails(psi, rotorWeatPSI);		
		selectNozzle(rotorWeatSeries+" "+rotorWeatModel);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time		
		subHeaders(advConHeaderEffcyTab);			
		validateEfficiencyAdjustment(zeroMin);
		subHeaders(advConHeaderEffcyTab+concat1+0+concat2);
		efficiencyType(fair);
		double getRunTimeMultipler = runTimeMultiplier(irrSpray, fair);		
		double effAdjustmentValue= calculateEfficiencyAdjustment(totalBase,getRunTimeMultipler);
		double getEfficencyAdjustment =validateEfficiencyAdjust(effAdjustmentValue);
		
		subHeaders(advConHeaderRunTimeTab);		
		//subHeaders(advConHeaderRunTimeTab+concat1+0+concat2);
		plantTypeUnderRunTimeAdjust(adjustPercent);		
		skipRunTime();	
		int runTimeTotal =calculateRunTimeTotal(totalBase, getEfficencyAdjustment, 0);
		validateSRRecommenedRange(totalBase,runTimeTotal);
		subHeaders(advConHeaderTotalsTab+concat1+runTimeTotal+concat2);	
		selectApply();
		addZoneFinalBtn();
		confirmModalBox(succssMsgText);			
		isZonePresent(advSkipRTName);
		validateZoneFlowTime(advSkipRTName,runTimeTotal);	
			
	}
	
	//@Test(priority=425)	
	public void advConfigReset() throws Exception {
		logInfo("Entered into advConfigReset() method.");
		int expPercenatge=TestBase.generateRandomNumberInRange(10,100);
		threadSleep(5000);	
		selectMenuIconInSite(iconProgram);
		selectMenuIconInSite(iconZone);
		threadSleep(5000);
		createAdvanceZone(advSkipName);
		selectZoneNumber();	
		threadSleep(4000);
		selectLargeButtonsInCreateZone(btnAdvanceConfig);
		handleRunTimeAlert("Ok");
		selectOptionUnderStepper(soilSiltyClay);		
		selectOptionUnderStepper(rd3Inc);			
		selectOptionUnderStepper(slopeOption);		
		double getInches = calculateTotalIrrigationAmt(rd3);		
		baseRunTimeSubTabs(irrAmtValueBfr+getInches+irrAmtValueAft);
		baseRunTimeSubTabs(preRate);	
		precipitationRateRadios(irrRotor);		
		precipitationRateRadios(precpRadRect);
		selectManufacturerDetails(manufacturer, rotorManuIrrtol);
		selectManufacturerDetails(series, rotorIrrtolSeries);
		//selectManufacturerDetails(model, rotorWeatModel);
		selectManufacturerDetails(psi, rotorIrrtolPSI);		
		selectNozzle(rotorIrrtolSeries);
		baseRunTimeSubTabs(baseRunTime);
		double totalBase= getBaseRunTime();  //retrieve Total Base Run time		
		subHeaders(advConHeaderEffcyTab);			
		validateEfficiencyAdjustment(zeroMin);
		subHeaders(advConHeaderEffcyTab+concat1+0+concat2);	
		skipEffeciencyAdjust();	
		plantTypeUnderRunTimeAdjust(adjustPercent);	
		validateRunTimeAdjust(0);
		subHeaders(advConHeaderRunTimeTab+concat1+0+concat2);
		percentage(expPercenatge);
		double expRuntTimeAdjustment =calculateRuntimePercentage(totalBase,expPercenatge);
		double getRunTimeAdjustment = validateRunTimeAdjust(expRuntTimeAdjustment);
		subHeaders(advConHeaderRunTimeTab+concat1+expRuntTimeAdjustment+concat2);
		subHeaders(advConHeaderTotalsTab);	
		int runTimeTotal =calculateRunTimeTotal(totalBase, 0, getRunTimeAdjustment);
		validateSRRecommenedRange(totalBase,runTimeTotal);
		subHeaders(advConHeaderTotalsTab+concat1+runTimeTotal+concat2);	
		resetAdvanceConfig();
		closeAdvanceConfigPopup();
		closeZone();
		
		
	
	}
	

}
