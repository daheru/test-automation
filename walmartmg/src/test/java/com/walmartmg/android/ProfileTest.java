package com.walmartmg.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.ProfileBusinessTest;
import com.walmartmg.enums.ProfileMenuEnum;

public class ProfileTest {

	public static final Logger logger = Logger.getLogger(ProfileTest.class);
	public static ProfileBusinessTest profile = new ProfileBusinessTest();

	@AfterClass
	public static void tearnDown() {
		profile.driverDisconect();
	}

	@Before
	public void reloadApp() {
		profile.closeApp();
		profile.lauchApp();
	}

	@Test
	public void CPO17_validate_menu_without_login() {
		logger.info("===> Iniciando caso de prueba: Validate menu without login");
		profile.selectProfile();
		profile.validateMenu(false);
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP039_validate_help_page() {
		logger.info("===> Iniciando caso de prueba: Validate help page");
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.SUPPORT.getMenu());
		profile.validateHelpPage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP040_validate_help_callus() {
		logger.info("===> Iniciando caso de prueba: Validate help call us");
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.SUPPORT.getMenu());
		profile.validateCallUs();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP041_validate_help_writeus() {
		logger.info("===> Iniciando caso de prueba: Validate help write us");
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.SUPPORT.getMenu());
		profile.validateWriteUs();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP042_CP052_validate_terms_and_conds() {
		logger.info("===> Iniciando caso de prueba: Validate terms and conditions");
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.TERMS.getMenu());
		profile.validateTermsPage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF030_CF035_validate_legals_page() {
		logger.info("===> Iniciando caso de prueba: Validate Legals Page");
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LEGALS.getMenu());
		profile.validateLegalsPage();
		logger.info("Caso de prueba finalizado");
	}
}
