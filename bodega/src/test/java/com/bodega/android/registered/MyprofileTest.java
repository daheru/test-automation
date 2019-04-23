package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.MyprofileBusinessTest;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.ProfileMenuEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("My Profile Module - Session")
public class MyprofileTest {

	@Rule
	public TestName name = new TestName();
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
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void reinicio() {
		myprofile.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Edit my profile")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile information")
	@Description("Edit user´s profile information")
	public void CF009_edit_myprofile() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE.getMenu());
		myprofile.editProfile("Ramiro", "Duarte", "01011995", "H");
		myprofile.saveProfile();
	}

	@Test
	@DisplayName("Edit my password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile information")
	@Description("Edit user´s password")
	public void CF010_edit_mypassword() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE.getMenu());
		myprofile.editPassword("Edominguez#1234", "Edominguez#1235");
		myprofile.savePassword();
	}

	@Test
	@DisplayName("Edit phone")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile information")
	@Description("Edit user´s phone")
	public void CF011_edit_phone() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE.getMenu());
		myprofile.editPhone("5573137390", "5556136545");
		myprofile.savePhone();
	}

	@Test
	@DisplayName("Edit secondaty phone")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to manage my profile information")
	@Description("Edit user´s secondaty phone")
	public void CF011_edit_phone_secondary() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE.getMenu());
		myprofile.editPhone_Secundary("5573137385");
		myprofile.savePhone_Secundary();
	}
	
	@Test
	public void edit_phone2 () {
		logger.info("Iniciando caso de prueba: Phone my profile data");
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		myprofile.login("emmanuel.dominguez@axity.com", "Edominguez#1235");
		myprofile.selectProfile();
		myprofile.selectMenu(MenuOptionsEnum.PROFILE.getMenu());
		myprofile.editPhone2("5573137380", "5576136545", "456"); 
		myprofile.savePhone2(); 
	}
	
}
