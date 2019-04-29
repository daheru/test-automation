package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.LoginBusinessTest;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Login Module")
public class LoginTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(LoginTest.class);
	private static LoginBusinessTest login = new LoginBusinessTest();
	private static GeneralBusinessTest general = new GeneralBusinessTest();

	@AfterClass
	public static void shutDown() {
		login.driverDisconect();
	}

	@Before
	public void initApp() {
		login.closeAndroidDialog();
		general.validateWelcomePage();
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		login.closeApp();
		login.lauchApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Login")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app with my email and password")
	@Description("Login in the application with email and password")
	public void CF006_login() {
		login.selectProfile();
		login.selectLoginOption();
		login.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		login.validateLogin();
	}

	@Test
	@DisplayName("Validate create account page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use the create account page")
	@Description("Validate create account page")
	public void CF000_create_account_validat_page() {
		login.selectProfile();
		login.selectLoginOption();
		login.selectCreateAccount();
		login.validateRegisterPage();
	}

	@Test
	@DisplayName("Password recovery")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to recover my password usign my email")
	@Description("Recover password using user's email")
	public void CF008_login_password_recovery() {
		login.selectProfile();
		login.selectLoginOption();
		login.selectPassRecovery(GeneralConstants.TEST_EMAIL);
	}

	@Test
	@DisplayName("Password recovery error")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to recover my password usign my email")
	@Description("Validate invalid email when I try to recover my password")
	public void CF000_login_password_recovery_error() {
		login.selectProfile();
		login.selectLoginOption();
		login.selectPassRecovery("wrongemail.com");
		login.validateErrorMessages(AppMessages.INVALID_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT);
	}

	@Test
	@DisplayName("Login with invalid email")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to login in the app with my email and password")
	@Description("Validate invalid email when I try to login in the app")
	public void CF109_login_invalid_email() {
		login.selectProfile();
		login.selectLoginOption();
		login.login("wrongemail.com", "12345678");
		login.validateErrorMessages(AppMessages.INVALID_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT);
	}

	@Test
	@DisplayName("Login with unexist email")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to login in the app with my email and password")
	@Description("Validate unexist email when I try to login in the app")
	public void CF000_login_unexist_email() {
		login.selectProfile();
		login.selectLoginOption();
		login.login("unexist@email.com", "12345678");
		login.validatePopUpMessage(AppMessages.UNEXIST_EMAIL);
	}

	@Test
	@DisplayName("Login with wrong password")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to login in the app with my email and password")
	@Description("Validate wrong password when I try to login in the app")
	public void CF110_login_wrong_pass() {
		login.selectProfile();
		login.selectLoginOption();
		login.login(GeneralConstants.TEST_EMAIL, "12345678");
		login.validatePopUpMessage(AppMessages.WRONG_LOGIN_DATA);
	}

	@Test
	@DisplayName("Login with invalid password")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to login in the app with my email and password")
	@Description("Validate wrong password when I try to login in the app")
	public void CF000_login_invalid_pass() {
		login.selectProfile();
		login.selectLoginOption();
		login.login(GeneralConstants.TEST_EMAIL, "123");
		login.validatePopUpMessage(AppMessages.UNEXPECTED_ERROR);
	}

	@Test
	@DisplayName("Show password")
	@Severity(SeverityLevel.MINOR)
	@Story("As a user I want to see my wrote password")
	@Description("Show wrote user's password")
	public void CF000_show_password() {
		login.selectProfile();
		login.selectLoginOption();
		login.fillPassword("12345678");
		login.selectShowPassword();
		login.validatePassword();
	}

	/*
	@Test
	@DisplayName("Create new profile with invalid data")
	@Severity(SeverityLevel.MINOR)
	@Story("As a user I want to create a new account in the app")
	@Description("Create a new account with invalida data")
	public void create_new_account_with_invalid_data() {
		login.selectProfile();
		login.selectLoginOption();
		login.selectCreateAccount();
		login.createAccount("1Juan", "Dominguez", "correo", "1");
		login.tapDown();
		login.tapDown();
		login.validateErrorMessages(AppMessages.INVALID_ACCOUNT_NAME, NamesMobileElements.ACCOUNT_NAME_CONT);
		login.validateErrorMessages(AppMessages.INVALID_ACCOUNT_EMAIL, NamesMobileElements.ACCOUNT_EMAIL_CONT);
		login.validateErrorMessages(AppMessages.INVALID_ACCOUNT_PASS, NamesMobileElements.ACCOUNT_PASS_CONT);
	}
	*/
}
