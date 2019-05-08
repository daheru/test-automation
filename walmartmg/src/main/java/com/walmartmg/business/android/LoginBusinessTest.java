package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class LoginBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(MenuProfileBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private String email;

	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	@Step("Validate login page")
	public void validateLoginPage() {
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
		waitElementVisibility(NamesMobileElements.LOGIN_EMAIL);
		waitElementVisibility(NamesMobileElements.LOGIN_FORGOT_PASS);
		waitElementVisibility(NamesMobileElements.LOGIN_PASS);
	}

	@Step("Tap on login with {email} and {password}")
	public void login(String email, String password) {
		this.email = email;
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		fillElement(NamesMobileElements.LOGIN_PASS, password);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
		validateLoginErrors(email, password);
	}

	public void validatePopUpMessages(String message) {
		try {
			List<MobileElement> messageElement = findElements(NamesMobileElements.POPUP_TEXT_MESSAGE);
			if (messageElement != null && messageElement.size() > 0) {
				assertTrue("Mensaje incorrecto", message.toLowerCase().contains(getElementText(messageElement.get(0))));
			} else {
				logger.info("Mensaje inalcanzable");
			}
		} catch (StaleElementReferenceException err) {
			logger.info("Mensaje inalcanzable");
		}
	}

	@Step("Validate login")
	public void validateLogin() {
		logger.info("Validando Login");
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.PROFILE);
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

	@Step("Tap on show password")
	public void showPassword(String password) {
		MobileElement passField = findElement(NamesMobileElements.LOGIN_PASS);
		logger.info("Ingresando password");
		passField.sendKeys(password);
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS);
		assertEquals(Boolean.FALSE.toString(), passField.getAttribute("password"));
	}

	@Step("Tap on forgot password without email")
	public void forgotPassWithoutEmail() {
		tapOnElement(NamesMobileElements.LOGIN_FORGOT_PASS);
		generalBusinessTest.validateFieldErrorMessage(AppMessages.NO_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT);
	}

	@Step("Tap on forgot password with {email}")
	public void forgotPass(String email) {
		logger.info("Ingresando email");
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		tapOnElement(NamesMobileElements.LOGIN_FORGOT_PASS);
	}

	@Step("Tap on create account")
	public void createAccount() {
		tapOnElement(NamesMobileElements.LOGIN_REGISTER_BUTTON);
		waitElementVisibility(NamesMobileElements.ACCOUNT_CREATE_BUTTON);
		assertTrue("El elemento no existe", elementExist(NamesMobileElements.ACCOUNT_CREATE_BUTTON));
	}

	@Step("Validate error login")
	public void validateErrorLogin() {
		waitElementVisibility(NamesMobileElements.LOGIN_ERROR);
		assertEquals(getElementText(NamesMobileElements.LOGIN_ERROR), AppMessages.LOGIN_FAIL);
	}

	@Step("Validate empty messages")
	public void validateEmptyMessages(String email, String pass) {
		if(email.isEmpty()) {
			generalBusinessTest.validateFieldErrorMessage(AppMessages.INVALID_ACCOUNT_EMAIL,NamesMobileElements.LOGIN_EMAIL_CONT);
		}
		if(pass.isEmpty()) {
			generalBusinessTest.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.LOGIN_PASS_CONT);
		}
	}
}
