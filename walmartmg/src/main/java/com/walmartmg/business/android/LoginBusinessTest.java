package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(ProfileBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private String email;

	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
	}

	public void selectMenuLogin() {
		generalBusinessTest.selectProfileMenu(ProfileMenuEnum.LOGIN.getMenu());
	}

	public void validateLoginPage() {
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
		waitElementVisibility(NamesMobileElements.LOGIN_EMAIL);
		waitElementVisibility(NamesMobileElements.LOGIN_FORGOT_PASS);
		waitElementVisibility(NamesMobileElements.LOGIN_PASS);
	}

	public void login(String email, String password) {
		this.email = email;
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		fillElement(NamesMobileElements.LOGIN_PASS, password);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
		validateLoginErrors(email, password);
	}

	public void validatePopUpMessages(String message) {
		generalBusinessTest.validatePopUpMessages(message);
	}

	public void validateLogin() {
		logger.info("Validando Login");
		generalBusinessTest.selectProfileMenu(ProfileMenuEnum.PROFILE.getMenu());
		MobileElement userEmail = findElement(NamesMobileElements.USER_EMAIL);
		assertEquals(email, userEmail.getAttribute(ConfigConstants.ATTRIBUTE_TEXT));
	}

	private void validateLoginErrors(String email, String password) {
		logger.info("Verificando mensajes de validacion");
		if (email.isEmpty()) {
			generalBusinessTest.validateFieldErrorMessage(AppMessages.NO_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT);
		} else if (password.isEmpty()) {
			generalBusinessTest.validateFieldErrorMessage(AppMessages.NO_PASS, NamesMobileElements.LOGIN_PASS_CONT);
		}
	}

	public void showPassword(String password) {
		MobileElement passField = findElement(NamesMobileElements.LOGIN_PASS);
		logger.info("Ingresando password");
		passField.sendKeys(password);
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS);
		assertEquals(Boolean.FALSE.toString(), passField.getAttribute("password"));
	}

	public void forgotPassWithoutEmail() {
		tapOnElement(NamesMobileElements.LOGIN_FORGOT_PASS);
		generalBusinessTest.validateFieldErrorMessage(AppMessages.NO_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT);
	}

	public void forgotPass(String email) {
		logger.info("Ingresando email");
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		tapOnElement(NamesMobileElements.LOGIN_FORGOT_PASS);
	}

	public void createAccount() {
		tapOnElement(NamesMobileElements.LOGIN_REGISTER_BUTTON);
		waitElementVisibility(NamesMobileElements.ACCOUNT_CREATE_BUTTON);
		assertTrue("El elemnto no existe", elementExist(NamesMobileElements.ACCOUNT_CREATE_BUTTON));
	}
}
