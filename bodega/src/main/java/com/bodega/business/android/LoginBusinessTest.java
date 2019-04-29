package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class LoginBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private HomeBusinessTest homePage = new HomeBusinessTest();
	private static String email = "";
	private static String password = "";

	public void selectProfile() {
		generalBusinessTest.selectProfile();
	}

	public void selectLoginOption() {
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	public void initAsGuess() {
		generalBusinessTest.initAsGuess();
	}

	@Step("User write email {email} and password {pass}")
	public void login(String email, String pass) {
		this.email = email;
		this.password = pass;
		fillElement(NamesMobileElements.LOGIN_EMAIL_TEXT, email);
		fillElement(NamesMobileElements.LOGIN_PASS_TEXT, pass);
		tapOnElement(NamesMobileElements.LOGIN_LOGIN_BUTTON);
		logger.info("Escribiendo email y password");
	}

	@Step("User write email password {pass}")
	public void fillPassword(String pass) {
		this.password = pass;
		fillElement(NamesMobileElements.LOGIN_PASS_TEXT, pass);
		logger.info("Escribiendo password");
	}

	@Step("Validate login")
	public void validateLogin() {
		generalBusinessTest.selectProfile();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.PROFILE);
		waitEvent();
		waitElementVisibility(NamesMobileElements.PROFILE_EMAIL);
		MobileElement profileEmail = findElement(NamesMobileElements.PROFILE_EMAIL);
		logger.info("EMAIL: " + getElementText(profileEmail));
		assertEquals(getElementText(profileEmail), email);
		cleanData();
		logger.info("Login válido");
	}

	@Step("Tap on create account")
	public void selectCreateAccount() {
		tapOnElement(NamesMobileElements.LOGIN_CREATE_LINK);
		logger.info("Tap en Registrarse");
	}

	@Step("Create account with data: {name}, {lastName}, {email}, {pass}")
	public void createAccount(String name, String lastName, String email, String pass) {
		logger.info("Escribiendo nombre, apellido, correo y password");
		fillElement(NamesMobileElements.REG_NAME_TEXT, name);
		fillElement(NamesMobileElements.REG_LAST_NAME_TEXT, lastName);
		fillElement(NamesMobileElements.REG_EMAIL_TEXT, email);
		fillElement(NamesMobileElements.REG_PASS_TEXT, pass);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.REG_CREATE_BUTTON);
		tapOnElement( NamesMobileElements.REG_CREATE_BUTTON );
	}
	
	@Step("Validate register page")
	public void validateRegisterPage() {
		waitElementVisibility(NamesMobileElements.REG_NAME_TEXT);
		waitElementVisibility(NamesMobileElements.REG_LAST_NAME_TEXT);
		waitElementVisibility(NamesMobileElements.REG_EMAIL_TEXT);
		waitElementVisibility(NamesMobileElements.REG_PASS_TEXT);
		waitElementVisibility(NamesMobileElements.REG_PUBLICY_CHECK);
		waitElementVisibility(NamesMobileElements.REG_TERMS_LINK);
		waitElementVisibility(NamesMobileElements.REG_CREATE_BUTTON);
		logger.info("Página válida");
	}

	@Step("Tap on ¿Olvidaste tu contraseña?")
	public void selectPassRecovery(String email) {
		fillElement(NamesMobileElements.LOGIN_EMAIL_TEXT, email);
		logger.info("Escribiendo correo");
		tapOnElement(NamesMobileElements.LOGIN_FORGOT_PASS_LINK);
		logger.info("Tap en Olvidaste tu contraseña");
		generalBusinessTest.validatePopUpMessages(AppMessages.PASSWORD_RECOVERY);
	}

	public void validateErrorMessages(String message, String element) {
		generalBusinessTest.validateFieldErrorMessage(message, element);
		logger.info("Mensajes de error válidos");
	}

	public void validatePopUpMessage(String message) {
		generalBusinessTest.validatePopUpMessages(message);
	}

	public void validateHomePage() {
		homePage.validateHomePage();
		logger.info("Página válida");
	}
	
	@Step("Tap on show password")
	public void selectShowPassword() {
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS_BUTTON);
		logger.info("Tap en mostrar password");
	}

	@Step("Validate password")
	public void validatePassword() {
		assertEquals(password, getElementText(NamesMobileElements.LOGIN_PASS_TEXT));
		logger.info("Password valido");
		cleanData();
	}

	private void cleanData() {
		email = "";
		password = "";
	}
}
