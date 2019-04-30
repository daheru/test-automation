package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.HelpBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

public class HelpTest {
	
	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger( HelpTest.class );
	private static HelpBusinessTest help = new HelpBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		help.driverDisconect();
	}	
	
	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void resetApp() {
		help.resetApp();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate help page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to ask for help")
	@Description("Validate that help pass has all elements")
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
	@DisplayName("Validate call button")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to ask for help")
	@Description("Validate that help button works")
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
	@DisplayName("Validate email button")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to ask for help")
	@Description("Validate that help button works")
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
	@DisplayName("Validate term page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a usert I want to know about use terms on the app")
	@Description("Validate that term page has all elements")
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
	@DisplayName("Validate legals page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a usert I want to know about use terms on the app")
	@Description("Validate that computers department has all categories and sub categories")
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
	@DisplayName("Validate computers department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that computers department has all categories and sub categories")
	public void CP130_validate_logout() {
		logger.info("Start CP130 Validate logout");
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		help.selectRequestMyProfileLogut();
		
	}
}
