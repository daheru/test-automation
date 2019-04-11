package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.ProfileBusinessTest;

public class ProfileTest {
	private static final Logger logger = Logger.getLogger(LoginTest.class);
	public static ProfileBusinessTest profile = new ProfileBusinessTest();

	@AfterClass
	public static void tearDown() {
		profile.driverDisconect();

	}

	@Before
	public void init() {
		profile.closeIOSDialog();
	}

	@Test
	public void CP023_Validate_Create_account() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Create_account_menu();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP024_Create_account_Validate_empty_fields() {
		profile.selectProfile();
		profile.selectMenu();
		profile.Validate_empty_fields();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}
	
	@Test 
	public void CP025_Create_account_Incorrect_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("1234","12234rnmv","jaid@hotk","9di");
		profile.validate_data();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
		
	}
	@Test
	public void CP026_Creat_Password_length() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("javier","miranda","miranda@hotmail.com","12344");
		profile.validate_data2();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
		
	}
	@Test // mensaje de error cuenta ya existente
	public void CP027_Create_user_exists_registered_in_the_app() {
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("maziel","chopin","dj_fran_@hotmail.es","080714javier");
		profile.Validata_mail();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}
	
	@Test
	public void CP029_Create_account_Validate_log_in() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Create_account_Login_in();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}
	
	
	
	

	@Test 
	public void CP030_Create_Validate_the_registration_of_a_new_user() {
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("maziel","chopin","cruz88996443@hotmail.com","080714javier");
		profile.vUser();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	
	

	

}
