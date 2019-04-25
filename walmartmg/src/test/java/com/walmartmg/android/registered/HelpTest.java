package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.HelpBusinessTest;

public class HelpTest {
	
	public static final Logger logger = Logger.getLogger( HelpTest.class );
	private static HelpBusinessTest help = new HelpBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		help.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		help.closeApp();
		help.lauchApp();
	}
	
	@Test
	public void CP115_validate_screen() {
		logger.info("Start CP115 Validate screen Help");
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		help.selectRequestMyProfile();
		help.validateScreenHelp();
	}
	
	@Test
	public void CP116_validate_call_button() {
		logger.info("Start CP116 Validate action call button");
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		help.selectRequestMyProfile();
		help.validateCallButton();
	}
	
	@Test
	public void CP117_validate_email_button() {
		logger.info("Start CP117 Validate action email button");
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		help.selectRequestMyProfile();
		help.validateEmailButton();
	}
	
	@Test
	public void CP118_validate_terms_page() {
		logger.info("Start CP118 Validate terms page");
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		help.selectRequestMyProfileTerms();
		help.validateTermsPage();
	}
	
	@Test
	public void CP129_validate_legals_page() {
		logger.info("Start CP129 Validate legals page");
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		help.selectRequestMyProfileLegal();
		help.validateLegalsPage();
	}
	
	@Test
	public void CP130_validate_logout() {
		logger.info("Start CP130 Validate logout");
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		help.selectRequestMyProfileLogut();
		
	}
}
