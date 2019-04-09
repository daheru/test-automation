package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.NamesMobileElements;

public class WelcomeBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(WelcomeBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();

	public void loginWelcomePage() {
		logger.info("Tap en el boton Login");
		tapOnElement(NamesMobileElements.WELCOME_LOGIN_BUTTON);
	}

	public void createAccountWelcomePage() {
		logger.info("Tap en el boton Crear Cuenta");
		tapOnElement(NamesMobileElements.WELCOME_CREATE_BUTTON);
	}

	public void login(String email, String pass) {
		login.login(email, pass);
	}

	public void validateLogin() {
		login.validateLogin();
	}

	public void validateHomePage() {
		login.validateHomePage();
	}

	public void initAsGuess() {
		generalBusinessTest.initAsGuess();
	}
}
