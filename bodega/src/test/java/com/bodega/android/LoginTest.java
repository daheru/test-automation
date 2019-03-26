package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.LoginBusinessTest;
import com.bodega.enums.MenuOptionsEnum;

public class LoginTest {

	private static final Logger logger = Logger.getLogger( LoginTest.class );
	public static LoginBusinessTest login = new LoginBusinessTest();
	public static GeneralBusinessTest general = new GeneralBusinessTest();
	
	@AfterClass
	public static void shutDown() {
		login.driverDisconect();
	}

	@Before
	public void initApp() {
		login.closeAndroidDialog();
		general.validateWelcomePage();
	}
	
	@After
	public void relauchApp() {
		login.closeApp();
		login.lauchApp();
	}
		
	@Test
	public void CF006_login() {
		logger.info("Iniciando caso de prueba: Login first time");
		login.selectProfile();
		login.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		login.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		login.validateLogin("emmanuel.dominguez@live.com.mx");
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void create_account() {
		logger.info("Iniciando caso de prueba: Login new user success");
		login.selectProfile();
		login.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		login.selectCreateAccount();
		login.createAccount("Juan", "Perez", "j@correo.com", "Juan#123");
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF008_login_password_recovery() {
		logger.info("Iniciando caso de prueba: Login password recovery");
		login.selectProfile();
		login.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		login.selectPassRecovery("emmanuel.dominguez@live.com.mx");
		logger.info("Caso de prueba finalizado");
	}
	
	//@Test
	public void login_new_profile_with_wrong_data() {
		logger.info("Iniciando caso de prueba: Login new profile with wrong data");
		login.selectProfile();
		login.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		login.selectCreateAccount();
		login.createAccount("1Juan", "Dominguez", "correo", "1");
		login.validateErrorMessage();
		logger.info("Caso de prueba finalizado");
	}
}
