package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.ProfileBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("My Profile Module - No session")
public class MyProfileTest {
	
	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger( MyProfileTest.class );
	private static ProfileBusinessTest myprofile = new ProfileBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		myprofile.driverDisconect();
	}	
	
	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		myprofile.resetApp();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate my profile page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate that my profile page has all elements")
	public void CP090_validate_screen_my_profile() {
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenMyPorfile();
	}
	
	// Personal Details
	@Test
	@DisplayName("Validate personal detail page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate that personal detail page has all elements")
	public void CP091_validate_screen_personal_details() {
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenPersonalDetails();
	}
	
	@Test
	@DisplayName("Personal detail with invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate when user tries to change his personal detail with invalid data")
	public void CP092_enter_invalid_data() {
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.enterDataPersonalDetails("1234$%&/", "12345%&/(", "11/11/2001");
		myprofile.validateMessageAlert();
	}
	
	@Test
	@DisplayName("Personal detail")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate when user tries to change his personal detail")
	public void CP093_enter_valid_data() {
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.enterDataPersonalDetails("Alejandra", "Ruiz", "11/11/1976");
		myprofile.validateMessageUpdate();
	}
	
	// Logon Data 
	@Test 
	@DisplayName("Validate logout")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate when user tap on logout button")
	public void CP094_validate_screen_logon_data(){
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenLogonData();
	}
	
	@Test 
	@DisplayName("Validate logout")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate when user tap on logout button")
	public void CP095_empty_field() {
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		myprofile.selectRequestMyProfile();
		myprofile.emptyFieldLogonData();
		myprofile.validateMessagePassword(" ", " ");
	}
	
	@Test
	@DisplayName("Change password invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate when user try to change his password with invalid data")
	public void CP096_enter_invalid_data() {
		logger.info("Start CP096 Validate message invalid Logon Data");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		myprofile.selectRequestMyProfile();
		myprofile.enterDataLogonData("123", "123ed");
		myprofile.validateMessageInvalidLogon();
	}
	
	@Test
	@DisplayName("Change password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate when user try to change his password")
	public void CP097_enter_valid_data() {
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		myprofile.selectRequestMyProfile();
		myprofile.enterDataLogonData("12345678", "12345679");
		myprofile.validateMessageUpdate();
	}
	
	//Telephone information
	@Test
	@DisplayName("Validate phone info page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile")
	@Description("Validate that phone info page has ")
	public void CP098_validate_screen_phone_info() {
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenPhoneInf();
		logger.info("Se valida pantalla");
		
	}
	
	@Test
	public void CP099_enter_valid_phone_info() {
		logger.info("Start CP099 Enter valid phone information");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.enterPhoneValid("6574839263", "1234543456", "123");
	}
}
