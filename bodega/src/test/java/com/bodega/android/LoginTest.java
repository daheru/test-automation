package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.LoginBusinessTest;

public class LoginTest {

	private static final Logger logger = Logger.getLogger( LoginTest.class );
	public static LoginBusinessTest login = new LoginBusinessTest();
	
	@AfterClass
	public static void tearDown() {
		login.driverDisconect();
	}
	
	@Before
	public void relauchApp() {
		login.closeApp();
		login.lauchApp();
		login.closeAndroidDialog();
	}
	
	@Test
	public void login_as_guess_success() {
		logger.info("Iniciando caso de prueba: Login As Guess Success");
		login.goToLogin();
		login.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		login.validateLogin("emmanuel.dominguez@live.com.mx");
		logger.info("Finalizando caso de prueba");
	}
	
	@Test
	public void login_new_profile_success() {
		logger.info("Iniciando caso de prueba: Login New User Success");
		login.goToLogin();
		login.selectCreateAccount();
		login.createAccount("Juan", "Perez", "j@correo.com", "Juan#123");
		logger.info("Finalizando caso de prueba");
	}
	
	@Test
	public void login_password_recovery() {
		logger.info("Iniciando caso de prueba: Login Password Recovery");
		login.goToLogin();
		login.selectPassRecovery("j@correo.com");
		logger.info("Finalizando caso de prueba");
	}
	
}
