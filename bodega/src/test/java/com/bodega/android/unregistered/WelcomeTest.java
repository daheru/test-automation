package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.android.registered.LoginTest;
import com.bodega.business.android.WelcomeBusinessTest;
import com.bodega.constants.GeneralConstants;

public class WelcomeTest {
	
	private static final Logger logger = Logger.getLogger( LoginTest.class );
	public static WelcomeBusinessTest welcome = new WelcomeBusinessTest();
	
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
	public void CF001_login_first_time() {
		logger.info("Iniciando caso de prueba: Login first time");
		welcome.loginWelcomePage();
		welcome.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		welcome.validateLogin();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF002_create_account_first_time() {
		logger.info("Iniciando caso de prueba: Create account first time");
		welcome.createAccountWelcomePage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF003_init_as_a_guess() {
		logger.info("Iniciando caso de prueba: Iniciar como invitado");
		welcome.initAsGuess();
		welcome.validateHomePage();
		logger.info("Caso de prueba finalizado");
	}
	
}
