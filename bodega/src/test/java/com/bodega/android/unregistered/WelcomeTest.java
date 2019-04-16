package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.WelcomeBusinessTest;
import com.bodega.constants.GeneralConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Welcome Module")
public class WelcomeTest {
	
	private static final Logger logger = Logger.getLogger( WelcomeTest.class );
	private static WelcomeBusinessTest welcome = new WelcomeBusinessTest();
	
	@AfterClass
	public static void shutDown() {
		welcome.driverDisconect();
	}

	@Before
	public void initApp() {
		welcome.closeAndroidDialog();
	}
	
	@After
	public void relauchApp() {
		welcome.resetApp();
	}
	
	@Test
	@DisplayName("Login from Mama Lucha page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I use the app first time")
	@Description("Login in the app using login button")
	public void CF001_login_first_time() {
		logger.info("Iniciando caso de prueba: Login first time");
		welcome.loginWelcomePage();
		welcome.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		welcome.validateLogin();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Create account from Mama Lucha page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I use the app first time")
	@Description("Create an account in the app using create account button")
	public void CF002_create_account_first_time() {
		logger.info("Iniciando caso de prueba: Create account first time");
		welcome.createAccountWelcomePage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Init as a guess")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I use the app first time")
	@Description("Init as a guess in the app using Continuar como invitado link")
	public void CF003_init_as_a_guess() {
		logger.info("Iniciando caso de prueba: Iniciar como invitado");
		welcome.initAsGuess();
		welcome.validateHomePage();
		logger.info("Caso de prueba finalizado");
	}
	
}
