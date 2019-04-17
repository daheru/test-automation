package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.HelpBusinessTest;

public class HelpTest {
	private static final Logger logger = Logger.getLogger(HelpTest.class);

	public static HelpBusinessTest Help = new HelpBusinessTest();

	@AfterClass
	public static void tearDown() {
		Help.driverDisconect();
	}

	@Before
	public void init() {
		Help.closeIOSDialog();
	}

	@Test // Entrar apartado de ayuda
	public void CP031_Validate_help() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		Help.selectProfile();
		Help.selectMenu();
		Help.helpPage();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}
	@Test // Entrar apartado  de ayuda
	public void CP032_CP033_Validate_Call_Us_AND_MAIL() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		Help.selectProfile();
		Help.selectMenu();
		Help.Call_Us();
		Help.Mail_button();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	
	
	}
}
