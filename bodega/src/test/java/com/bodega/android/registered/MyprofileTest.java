package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.MyprofileBusinessTest;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.MenuOptionsEnum;

public class MyprofileTest {

	public static final Logger logger = Logger.getLogger(MyprofileBusinessTest.class);
	public static MyprofileBusinessTest myprofile = new MyprofileBusinessTest();
	public static GeneralBusinessTest general = new GeneralBusinessTest();

	@BeforeClass
	public static void init() {

	}

	@AfterClass
	public static void tearDown() {
		myprofile.driverDisconect();
	}

	@Before
	public void intapp() {
		myprofile.closeAndroidDialog();
		general.validateWelcomePage();
	}

	@After
	public void reinicio() {
		myprofile.resetApp();

	}

	@Test
	public void CF009_edit_myprofile() {
		logger.info("Iniciando caso de prueba: Update my profile data");
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.PROFILE.getMenu());
		myprofile.editProfile("Ramiro", "Duarte", "01011995", "H");
		myprofile.saveProfile();
	}
	
	@Test
	public void CF010_edit_mypassword() {
		logger.info("Iniciando caso de prueba: PassWord my profile data");
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.PROFILE.getMenu());
		myprofile.editPassword("Edominguez#1234", "Edominguez#1235");
		myprofile.savePassword();
	}

	@Test
	public void CF011_edit_phone () {
		logger.info("Iniciando caso de prueba: Phone my profile data");
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.PROFILE.getMenu());
		myprofile.editPhone("5573137390", "5556136545"); 
		myprofile.savePhone(); 
	}
	
	@Test
	public void CF011_edit_phone_secondary () {
		logger.info("Iniciando caso de prueba: Phone_secundary my profile data");
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.PROFILE.getMenu());
		myprofile.editPhone_Secundary("5573137385"); 
		myprofile.savePhone_Secundary();
	}
	
	@Test
	public void edit_phone2 () {
		logger.info("Iniciando caso de prueba: Phone my profile data");
		myprofile.login("emmanuel.dominguez@axity.com", "Edominguez#1235");
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.PROFILE.getMenu());
		myprofile.editPhone2("5573137390", "5556136545", "456"); 
		myprofile.savePhone2(); 
	}
	
}
