package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.HelpBusinessTest;
import com.walmartmg.constants.GeneralConstants;

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
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		help.selectRequestMyProfile();
		help.validateScreenHelp();
	}
	
	@Test
	@DisplayName("Validate call button")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to ask for help")
	@Description("Validate that help button works")
	public void CP116_validate_call_button() {
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		help.selectRequestMyProfile();
		help.validateCallButton();
	}
	
	@Test
	@DisplayName("Validate email button")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to ask for help")
	@Description("Validate that help button works")
	public void CP117_validate_email_button() {
		help.selectProfileOption();
		help.selectMenuLogin();
		help.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		help.selectRequestMyProfile();
		help.validateEmailButton();
	}
}
