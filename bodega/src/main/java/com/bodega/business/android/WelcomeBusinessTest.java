package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.constants.NamesMobileElements;
import com.bodega.util.BaseDriver;

public class WelcomeBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(WelcomeBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest login = new LoginBusinessTest();

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

	public void validateLogin(String email) {
		login.validateLogin(email);
	}

	public void validateHomePage() {
		login.validateHomePage();
	}

	public void initAsGuess() {
		generalBusinessTest.initAsGuess();
	}
}
