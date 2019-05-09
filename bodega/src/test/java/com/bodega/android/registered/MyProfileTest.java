package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.ProfileBusinessTest;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.ProfileMenuEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("My Profile Module - Session")
public class MyProfileTest {

	@Rule
	public TestName name = new TestName();
	public static final Logger logger = Logger.getLogger(ProfileBusinessTest.class);
	public static ProfileBusinessTest myprofile = new ProfileBusinessTest();

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
		myprofile.validateWelcomePage();
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
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editProfile("Ramiro", "Duarte", "01011995", "H");
		myprofile.saveProfile();
		myprofile.validateProfileUpdate();
	}

	@Test
	@DisplayName("Edit my password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile information")
	@Description("Edit user´s password")
	public void CF010_edit_mypassword() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPassword(GeneralConstants.TEST_PASS, GeneralConstants.TEST_PASS_CHANGE);
		myprofile.savePassword();
		myprofile.validatePasswordChange();
		myprofile.editPassword(GeneralConstants.TEST_PASS_CHANGE, GeneralConstants.TEST_PASS);
		myprofile.savePassword();
		myprofile.validatePasswordChange();
	}

	@Test
	@DisplayName("Edit phone")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile information")
	@Description("Edit user´s phone")
	public void CF011_edit_phone() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPhone(true, true, GeneralConstants.FIJO);
		myprofile.savePhone();
		myprofile.validatePhoneUpdate();
	}

	@Test
	@DisplayName("Edit secondaty phone")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to manage my profile information")
	@Description("Edit user´s secondaty phone")
	public void CF011_edit_phone_secondary() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPhone(false, true, GeneralConstants.MOVIL);
		myprofile.savePhone();
		myprofile.validatePhoneUpdate();
	}

	@Test
	@DisplayName("Validate my profile invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user fill fields with invalid data")
	public void CF000_myprofile_invalid_data() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editProfile("$Marcos", "&Alonso", "01011995", "H");
		myprofile.saveProfile();
		myprofile.validateInvalidData();
	}
	
	@Test
	@DisplayName("Validate my profile invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user fill fields with invalid data")
	public void CF000_myprofile_invalid_age() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editProfile("Ramiro", "Duarte", "01012015", "H");
		myprofile.saveProfile();
		myprofile.validateAge();
	}
	
	@Test
	@DisplayName("Validate change password empty data")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user put a empty current password")
	public void CF000_myprofile_empty_password() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPassword(GeneralConstants.EMPTY, GeneralConstants.TEST_PASS_CHANGE);
		myprofile.savePassword();
		myprofile.validateInvalidPasswordChange();
	}
	
	@Test
	@DisplayName("Validate change password empty data")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user put a invalid current password")
	public void CF000_myprofile_invalid_password() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPassword(GeneralConstants.INVALID_PASS, GeneralConstants.TEST_PASS_CHANGE);
		myprofile.savePassword();
		myprofile.validateInvalidPasswordChange();
	}
	
	@Test
	@DisplayName("Validate change password empty data")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user put a empty new password")
	public void CF000_myprofile_empty_new_password() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPassword(GeneralConstants.TEST_PASS, GeneralConstants.EMPTY);
		myprofile.savePassword();
		myprofile.validateInvalidPasswordChange();
	}
	
	@Test
	@DisplayName("Validate change password empty data")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user put a invalid new password")
	public void CF000_myprofile_invalid_new_password() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPassword(GeneralConstants.TEST_PASS, GeneralConstants.INVALID_PASS);
		myprofile.savePassword();
		myprofile.validateInvalidPasswordChange();
	}
	
	@Test
	@DisplayName("Validate change password same data")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user put same data for old and new password")
	public void CF000_myprofile_same_password() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPassword(GeneralConstants.TEST_PASS_CHANGE, GeneralConstants.TEST_PASS_CHANGE);
		myprofile.savePassword();
		myprofile.validateSamePasswordChange();
	}
	
	@Test
	@DisplayName("Validate empty phone")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to manage my profile information")
	@Description("Validate when user fill phone without data")
	public void CF000_edit_phone_empty() {
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.LOGIN);
		myprofile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		myprofile.selectProfile();
		myprofile.selectMenu(ProfileMenuEnum.PROFILE);
		myprofile.editPhone();
		myprofile.savePhone();
		myprofile.validateEmptyPhone();
	}
}
