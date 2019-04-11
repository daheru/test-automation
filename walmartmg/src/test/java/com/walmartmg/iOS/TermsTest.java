package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.TermsBusinessTest;

public class TermsTest {
	private static final Logger logger = Logger.getLogger(TermsBusinessTest.class);


	public static TermsBusinessTest Terms = new TermsBusinessTest();

	@AfterClass
	public static void tearDown() {
		Terms.driverDisconect();

	}
	@Before
	public void init() {
		Terms.closeIOSDialog();
	}

	@Test // validacion de LEGALES
	public void CP034_Validate_legal() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		Terms.selectProfile();
		Terms.selectMenu();
		Terms.Validate();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

}
