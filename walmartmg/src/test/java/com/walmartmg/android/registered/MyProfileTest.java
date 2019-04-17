package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.registered.MyProfileBusinessTest;

public class MyProfileTest {
	
	public static final Logger logger = Logger.getLogger( MyProfileTest.class );
	private static MyProfileBusinessTest myprofile = new MyProfileBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		myprofile.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		myprofile.closeApp();
		myprofile.lauchApp();
	}
	
	@Test
	public void CP090_validate_screen_my_profile() {
		logger.info("Start CP090 Validate screen My Perfile");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenMyPorfile();
	}
	
	// Personal Details
	@Test
	public void CP091_validate_screen_personal_details() {
		logger.info("Start CP091 Validate screen Personal Detail");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenPersonalDetails();
	}
	
	@Test
	public void CP092_enter_invalid_data() {
		logger.info("Start CP092 Enter invalid data in Personal Detail");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.enterDataPersonalDetails("1234$%&/", "12345%&/(", "11/11/2001");
		myprofile.validateMessageAlert();
	}
	
	@Test
	public void CP093_enter_valid_data() {
		logger.info("Start CP093 Enter valid data in Personal Detail");
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
	public void CP094_validate_screen_logon_data(){
		logger.info("Start CP094 Validate Screen Logon data");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenLogonData();
	}
	
	@Test 
	public void CP095_empty_field() {
		logger.info("Start CP095 Validate message in Empty Field");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.emptyFieldLogonData();
		myprofile.validateMessagePassword(" ", " ");
		logger.info("Se validan mensajes");
	}
	
	@Test
	public void CP096_enter_invalid_data() {
		logger.info("Start CP096 Validate message invalid Logon Data");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.enterDataLogonData("123", "123ed");
		logger.info("Se valida mensaje");
		myprofile.validateMessageInvalidLogon();
	}
	
	@Test
	public void CP097_enter_valid_data() {
		logger.info("Start CP097 Validate message valid Logon Data");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.enterDataLogonData("12345678", "12345679");
		logger.info("Se valida mensaje");
		myprofile.validateMessageUpdate();
	}
	
	//Telephone information
	@Test
	public void CP098_validate_screen_phone_info() {
		logger.info("Start CP098 Validate screen phone information");
		myprofile.selectProfileOption();
		myprofile.selectMenuLogin();
		myprofile.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		myprofile.selectRequestMyProfile();
		myprofile.validateScreenPhoneInf();
		logger.info("Se valida pantalla");
		
	}
	
	@Test
	public void CP099_enter_valid_phone_info() {
		
	}
	
	
}
