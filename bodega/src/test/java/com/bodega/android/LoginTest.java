package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.LoginBusinessTest;

public class LoginTest {

	private static final Logger logger = Logger.getLogger( LoginTest.class );
	public static LoginBusinessTest login = new LoginBusinessTest();
	
	@AfterClass
	public static void shutDown() {
		login.driverDisconect();
	}

	@Before
	public void initApp() {
		login.closeAndroidDialog();
	}
	
	@After
	public void relauchApp() {
		login.resetApp();
	}
	
	@Test
	public void login_as_guess_success() {
		logger.info("Iniciando caso de prueba: Login as guess success");
		login.goToLogin();
		login.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		login.validateLogin("emmanuel.dominguez@live.com.mx");
		logger.info("Caso de prueba finalizado");
	}
	
	//@Test
	public void login_new_profile_success() {
		logger.info("Iniciando caso de prueba: Login new user success");
		login.goToLogin();
		login.selectCreateAccount();
		login.createAccount("Juan", "Perez", "j@correo.com", "Juan#123");
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void login_password_recovery() {
		logger.info("Iniciando caso de prueba: Login password recovery");
		login.goToLogin();
		login.selectPassRecovery("emmanuel.dominguez@live.com.mx");
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void login_new_profile_with_wrong_data() {
		logger.info("Iniciando caso de prueba: Login new profile with wrong data");
		login.goToLogin();
		login.selectCreateAccount();
		login.createAccount("1Juan", "Dominguez", "correo", "1");
		login.validateErrorMessage();
		logger.info("Caso de prueba finalizado");
	}
}