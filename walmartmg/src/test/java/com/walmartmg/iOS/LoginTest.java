package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.LoginBusinessTest;

public class LoginTest {
	private static final Logger logger = Logger.getLogger(LoginTest.class);

	public static LoginBusinessTest login = new LoginBusinessTest();

	@AfterClass
	public static void tearDown() {
		login.driverDisconect();
	}

	@Before
	public void init() {
		login.closeIOSDialog();
	}

	@Test
	public void CP015_Validate_Menu_options() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.Validate_profile();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP016_CP017_Validate_Log_in() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.Validate_Page_Log_in();

	}

	@Test // pasword incorrecto password incorrecto
	public void CP018_PassFail() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "Regina080714");
		login.validateLoginfail();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test // mail incorrecto /validacion de correo
	public void CP018_Validatemail() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.mailfail();
		login.Vmail();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test // password incorrecto menor a 8 caracteres
	public void CP0019loginminor() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.loginminor();
		login.validateMinor();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test // CORREO NO EXITENTE
	public void XCP00_notRegs() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.es", "12345678");
		login.RegNotuser();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP020_Login_Validate_Forgot_your_password() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.Mail_Forgot();

	}

	@Test
	public void CP021_Login_Validate_link_Create_account_() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.Validate_link_Create_account();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test // pass correcto Validar Crear cuenta //Crear cuenta/Correo existente
	public void CP022_loginIn() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginIn();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}
	
	
	

}
