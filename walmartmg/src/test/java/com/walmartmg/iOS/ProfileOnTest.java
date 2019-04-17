package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.LoginBusinessTest;
import com.walmartmg.business.iOS.ProfileOnBusinessTest;

public class ProfileOnTest {

	private LoginBusinessTest login = new LoginBusinessTest();
	private static final Logger logger = Logger.getLogger(LoginTest.class);
	public static ProfileOnBusinessTest profile_on = new ProfileOnBusinessTest();

	@AfterClass
	public static void tearDown() {
		profile_on.driverDisconect();

	}

	@Before
	public void init() {
		profile_on.closeIOSDialog();
	}

	@Test
	public void CP082_Validate_screen() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginIn();
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		profile_on.Validate_Screen_profile();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP083_Date_personal() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginIn();
		logger.info("Se da click en el icono de TU Perfil ");
		login.selectProfile();
		profile_on.Validate_DAte_Personal();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP084_Personal_data_Edit_with_invalid_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile_on.Edit_with_invalid_data("kj8474895", "uuiuf942", "");
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

}
