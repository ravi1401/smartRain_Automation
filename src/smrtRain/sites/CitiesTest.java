package smrtRain.sites;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(9)
public class CitiesTest extends SiteMethods{
	
	@Test(priority=901)
	public void verifyCitiesOfStateAlbama() throws Exception {
		logInfo("Entered into verifyCitiesOfStateAlbama() test.");
		threadSleep(10000);		
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stAlabama);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stAlabama,noOfCities,usaCities);	
	
	}
	@Test(priority=902)
	public void verifyCitiesOfStateAlaska() throws Exception {
		logInfo("Entered into verifyCitiesOfStateAlaska() test.");
		threadSleep(25000);	
		navigateToModule(homePage);
		threadSleep(10000);
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stAlaska);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stAlaska,noOfCities,usaCities);	
	
	}
	@Test(priority=903)
	public void verifyCitiesOfStateArizona() throws Exception {
		logInfo("Entered into verifyCitiesOfStateArizona() test.");
		threadSleep(10000);		
		navigateToModule(settingsPage);
		threadSleep(10000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stArizona);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stArizona,noOfCities,usaCities);	
	
	}
	
	@Test(priority=904)
	public void verifyCitiesOfStateArkansas() throws Exception {
		logInfo("Entered into verifyCitiesOfStateArkansas() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stArkansas);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stArkansas,noOfCities,usaCities);		
	}
	
	@Test(priority=905)
	public void verifyCitiesOfStateCalifornia() throws Exception {
		logInfo("Entered into verifyCitiesOfStateCalifornia() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stCalifornia);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stCalifornia,noOfCities,usaCities);	
	
	}
	
	@Test(priority=906)
	public void verifyCitiesOfStateColorado() throws Exception {
		logInfo("Entered into verifyCitiesOfStateColorado() test.");
		threadSleep(3000);			
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stColorado);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stColorado,noOfCities,usaCities);	
	
	}
	
	@Test(priority=907)
	public void verifyCitiesOfStateConnecticut() throws Exception {
		logInfo("Entered into verifyCitiesOfStateConnecticut() test.");
		threadSleep(3000);				
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stConnecticut);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stConnecticut,noOfCities,usaCities);	
	
	}
	
	@Test(priority=908)
	public void verifyCitiesOfStateDelaware() throws Exception {
		logInfo("Entered into verifyCitiesOfStateDelaware() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stDelaware);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stDelaware,noOfCities,usaCities);	
	
	}
	
	@Test(priority=909)
	public void verifyCitiesOfStateFlorida() throws Exception {
		logInfo("Entered into verifyCitiesOfStateFlorida() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stFlorida);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stFlorida,noOfCities,usaCities);	
	
	}
	
	@Test(priority=910)
	public void verifyCitiesOfStateGeorgia() throws Exception {
		logInfo("Entered into verifyCitiesOfStateGeorgia() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stGeorgia);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stGeorgia,noOfCities,usaCities);	
	
	}
	
	@Test(priority=911)
	public void verifyCitiesOfStateHawaii() throws Exception {
		logInfo("Entered into verifyCitiesOfStateHawaii() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stHawaii);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stHawaii,noOfCities,usaCities);	
	
	}
	
	@Test(priority=912)
	public void verifyCitiesOfStateIdaho() throws Exception {
		logInfo("Entered into verifyCitiesOfStateIdaho() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stIdaho);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stIdaho,noOfCities,usaCities);	
	
	}
	
	@Test(priority=913)
	public void verifyCitiesOfStateIllinois() throws Exception {
		logInfo("Entered into verifyCitiesOfStateIllinois() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stIllinois);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stIllinois,noOfCities,usaCities);	
	
	}
	
	@Test(priority=914)
	public void verifyCitiesOfStateIndiana() throws Exception {
		logInfo("Entered into verifyCitiesOfStateIndiana() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stIndiana);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stIndiana,noOfCities,usaCities);	
	
	}
	
	@Test(priority=915)
	public void verifyCitiesOfStateIowa() throws Exception {
		logInfo("Entered into verifyCitiesOfStateIowa() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);	
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stIowa);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stIowa,noOfCities,usaCities);	
	
	}
	
	@Test(priority=916)
	public void verifyCitiesOfStateKansas() throws Exception {
		logInfo("Entered into verifyCitiesOfStateKansas() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stKansas);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stKansas,noOfCities,usaCities);	
	
	}
	
	@Test(priority=917)
	public void verifyCitiesOfStateKentucky() throws Exception {
		logInfo("Entered into verifyCitiesOfStateKentucky() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stKentucky);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stKentucky,noOfCities,usaCities);	
	
	}
	
	@Test(priority=918)
	public void verifyCitiesOfStateLouisiana() throws Exception {
		logInfo("Entered into verifyCitiesOfStateLouisiana() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stLouisiana);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stLouisiana,noOfCities,usaCities);		
	}
	
	@Test(priority=919)
	public void verifyCitiesOfStateMaine() throws Exception {
		logInfo("Entered into verifyCitiesOfStateMaine() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMaine);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMaine,noOfCities,usaCities);	
	
	}
	
	@Test(priority=920)
	public void verifyCitiesOfStateMaryland() throws Exception {
		logInfo("Entered into verifyCitiesOfStateMaryland() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMaryland);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMaryland,noOfCities,usaCities);	
	
	}
	
	@Test(priority=921)
	public void verifyCitiesOfStateMassachusetts() throws Exception {
		logInfo("Entered into verifyCitiesOfStateMassachusetts() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMassachusetts);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMassachusetts,noOfCities,usaCities);	
	
	}
	
	@Test(priority=922)
	public void verifyCitiesOfStateMichigan() throws Exception {
		logInfo("Entered into verifyCitiesOfStateMichigan() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMichigan);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMichigan,noOfCities,usaCities);	
	
	}
	
	@Test(priority=923)
	public void verifyCitiesOfStateMinnesota() throws Exception {
		logInfo("Entered into verifyCitiesOfStateMinnesota() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMinnesota);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMinnesota,noOfCities,usaCities);	
	
	}
	
	@Test(priority=924)
	public void verifyCitiesOfStateMississippi() throws Exception {
		logInfo("Entered into verifyCitiesOfStateMississippi() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMississippi);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMississippi,noOfCities,usaCities);	
	
	}
	
	@Test(priority=925)
	public void verifyCitiesOfStateNorthCarolina() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNorthCarolina() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNorthCarolina);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNorthCarolina,noOfCities,usaCities);	
	
	}
	
	@Test(priority=926)
	public void verifyCitiesOfStateMissouri() throws Exception {
		logInfo("Entered into verifyCitiesOfStateMissouri() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMissouri);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMissouri,noOfCities,usaCities);	
	
	}
	
	@Test(priority=927)
	public void verifyCitiesOfStateMontana() throws Exception {
		logInfo("Entered into verifyCitiesOfStateIMontana() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stMontana);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stMontana,noOfCities,usaCities);	
	
	}
	
	@Test(priority=928)
	public void verifyCitiesOfStateNebraska() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNebraska() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNebraska);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNebraska,noOfCities,usaCities);	
	
	}
	
	@Test(priority=929)
	public void verifyCitiesOfStateNevada() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNevada() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNevada);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNevada,noOfCities,usaCities);	
	
	}
	
	@Test(priority=930)
	public void verifyCitiesOfStateNewHampshire() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNewHampshire() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNewHampshire);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNewHampshire,noOfCities,usaCities);	
	
	}
	
	@Test(priority=931)
	public void verifyCitiesOfStateNewJersey() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNewJersey() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNewJersey);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNewJersey,noOfCities,usaCities);	
	
	}
	
	@Test(priority=932)
	public void verifyCitiesOfStateNewMexico() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNewMexico() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNewMexico);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNewMexico,noOfCities,usaCities);		
	}
	
	@Test(priority=933)
	public void verifyCitiesOfStateNewYork() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNewYork() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNewYork);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNewYork,noOfCities,usaCities);	
	
	}
	
	@Test(priority=934)
	public void verifyCitiesOfStateNorthDakota() throws Exception {
		logInfo("Entered into verifyCitiesOfStateNorthDakota() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stNorthDakota);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stNorthDakota,noOfCities,usaCities);	
	
	}
	
	@Test(priority=935)
	public void verifyCitiesOfStateOhio() throws Exception {
		logInfo("Entered into verifyCitiesOfStateOhio() test.");
		threadSleep(10000);		
		navigateToModule(reportsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stOhio);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		navigateToModule(sitesPage);		
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stOhio,noOfCities,usaCities);	
	
	}
	
	@Test(priority=936)
	public void verifyCitiesOfStateOklahoma() throws Exception {
		logInfo("Entered into verifyCitiesOfStateOklahoma() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stOklahoma);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stOklahoma,noOfCities,usaCities);	
	
	}
	
	@Test(priority=937)
	public void verifyCitiesOfStateOregon() throws Exception {
		logInfo("Entered into verifyCitiesOfStateOregon() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stOregon);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stOregon,noOfCities,usaCities);	
	
	}
	
	@Test(priority=938)
	public void verifyCitiesOfStatePennsylvania() throws Exception {
		logInfo("Entered into verifyCitiesOfStatePennsylvania() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stPennsylvania);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stPennsylvania,noOfCities,usaCities);	
	
	}
	
	@Test(priority=939)
	public void verifyCitiesOfStateRhodeIsland() throws Exception {
		logInfo("Entered into verifyCitiesOfStateRhodeIsland() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stRhodeIsland);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stRhodeIsland,noOfCities,usaCities);	
	
	}
	
	@Test(priority=940)
	public void verifyCitiesOfStateSouthCarolina() throws Exception {
		logInfo("Entered into verifyCitiesOfStateSouthCarolina() test.");
		threadSleep(7000);		
		navigateToModule(reportsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stSouthCarolina);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stSouthCarolina,noOfCities,usaCities);	
	
	}
	
	@Test(priority=941)
	public void verifyCitiesOfStateSouthDakota() throws Exception {
		logInfo("Entered into verifyCitiesOfStateSouthDakota() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stSouthDakota);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stSouthDakota,noOfCities,usaCities);	
	
	}
	
	@Test(priority=942)
	public void verifyCitiesOfStateTennessee() throws Exception {
		logInfo("Entered into verifyCitiesOfStateTennessee() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stTennessee);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stTennessee,noOfCities,usaCities);	
	
	}
	
	@Test(priority=943)
	public void verifyCitiesOfStateTexas() throws Exception {
		logInfo("Entered into verifyCitiesOfStateTexas() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stTexas);
		System.out.println("noOfCities "+noOfCities);
		threadSleep(3000);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stTexas,noOfCities,usaCities);	
	
	}
	
	@Test(priority=944)
	public void verifyCitiesOfStateUtah() throws Exception {
		logInfo("Entered into verifyCitiesOfStateUtah() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stUtah);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stUtah,noOfCities,usaCities);	
	
	}
	
	@Test(priority=945)
	public void verifyCitiesOfStateVermont() throws Exception {
		logInfo("Entered into verifyCitiesOfStateVermont() test.");
		threadSleep(3000);				
		navigateToModule(settingsPage);
		threadSleep(5000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stVermont);
		System.out.println("noOfCities "+noOfCities);
		threadSleep(3000);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stVermont,noOfCities,usaCities);	
	
	}
	
	@Test(priority=946)
	public void verifyCitiesOfStateVirginia() throws Exception {
		logInfo("Entered into verifyCitiesOfStateVirginia() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stVirginia);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stVirginia,noOfCities,usaCities);	
	
	}
	
	@Test(priority=947)
	public void verifyCitiesOfStateWashington() throws Exception {
		logInfo("Entered into verifyCitiesOfStateWashington() test.");
		threadSleep(3000);				
		navigateToModule(settingsPage);
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stWashington);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stWashington,noOfCities,usaCities);	
	
	}
	
	@Test(priority=948)
	public void verifyCitiesOfStateWestVirginia() throws Exception {
		logInfo("Entered into verifyCitiesOfStateWestVirginia() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stWestVirginia);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stWestVirginia,noOfCities,usaCities);	
	
	}
	
	@Test(priority=949)
	public void verifyCitiesOfStateWisconsin() throws Exception {
		logInfo("Entered into verifyCitiesOfStateWisconsin() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stWisconsin);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stWisconsin,noOfCities,usaCities);	
	
	}
	
	@Test(priority=950)
	public void verifyCitiesOfStateWyoming() throws Exception {
		logInfo("Entered into verifyCitiesOfStateWyoming() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stWyoming);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stWyoming,noOfCities,usaCities);	
	
	}
	
	
	
    @Test(priority=951)
	public void verifyMuncipaltiesOfProvinceAB() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceAB() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prAB);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prAB,noOfCities,canMunc);	
	
	}	
	@Test(priority=952)
	public void verifyMuncipaltiesOfProvinceBC() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceBC() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prBC);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prBC,noOfCities,canMunc);	
	
	}
	
	@Test(priority=953)
	public void verifyMuncipaltiesOfProvinceMB() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceMB() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prMB);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prMB,noOfCities,canMunc);	
	
	}
	
	@Test(priority=954)
	public void verifyMuncipaltiesOfProvinceNB() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceNB() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prNB);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prNB,noOfCities,canMunc);	
	
	}
	
	@Test(priority=955)
	public void verifyMuncipaltiesOfProvinceNL() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceNL() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prNL);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prNL,noOfCities,canMunc);	
	
	}
	
	@Test(priority=956)
	public void verifyMuncipaltiesOfProvinceNT() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceNT() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prNT);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prNT,noOfCities,canMunc);	
	
	}
	
	@Test(priority=957)
	public void verifyMuncipaltiesOfProvinceNS() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceNS() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prNS);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prNS,noOfCities,canMunc);	
	
	}
	
	@Test(priority=958)
	public void verifyMuncipaltiesOfProvinceNU() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceNU() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prNU);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prNU,noOfCities,canMunc);	
	
	}
	@Test(priority=959)
	public void verifyMuncipaltiesOfProvinceON() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceON() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prON);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prON,noOfCities,canMunc);	
	
	}
	
	@Test(priority=960)
	public void verifyMuncipaltiesOfProvincePE() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvincePE() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prPE);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prPE,noOfCities,canMunc);	
	
	}
	@Test(priority=961)
	public void verifyMuncipaltiesOfProvinceQC() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceQC() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prQC);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prQC,noOfCities,canMunc);	
	
	}
	
	@Test(priority=962)
	public void verifyMuncipaltiesOfProvinceSK() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceSK() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prSK);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prSK,noOfCities,canMunc);	
	
	}
	
	@Test(priority=963)
	public void verifyMuncipaltiesOfProvinceYT() throws Exception {
		logInfo("Entered into verifyMuncipaltiesOfProvinceYT() test.");
		threadSleep(3000);		
		navigateToModule(settingsPage);		
		threadSleep(3000);
		int noOfCities =storeDataInProrpertyFile(canMunc,prYT);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryCanada);		
	    verifyCityBasedOnStateOrProvince(prYT,noOfCities,canMunc);	
	
	}
	
	

}
