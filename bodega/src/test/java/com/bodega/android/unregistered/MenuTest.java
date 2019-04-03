package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.MenuBusinessTest;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.vo.AddressVO;

public class MenuTest {

	public static final Logger logger = Logger.getLogger(MenuTest.class);
	public static MenuBusinessTest main = new MenuBusinessTest();
	public static GeneralBusinessTest general = new GeneralBusinessTest();
	public static AddressVO addressVO;

	@BeforeClass
	public static void init() {
		addressVO = new AddressVO("Mi direccion ", "Juan", "Perez", "Av Rodolfo Gaona 46", "456", "", "11200",
				"Lomas de Sotelo", "Entre calle 1 y calle 2", "Plaza Toreo", "Movil", "5555555555", true);
	}

	@AfterClass
	public static void shutDown() {
		main.driverDisconect();
	}

	@Before
	public void initApp() {
		main.closeAndroidDialog();
		general.validateWelcomePage();
	}

	@After
	public void relauchApp() {
		main.resetApp();
	}

	@Test
	public void CF011_scan_manually_ticket() {
		logger.info("Iniciando caso de prueba: Scan manually ticket");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.GET_BILL.getMenu());
		main.closeAndroidDialog();
		main.manualBill("36214691686686662445");
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF015_CF016_validate_suppor_page() {
		logger.info("Iniciando caso de prueba: Validate Support Page");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.SUPPORT.getMenu());
		main.validateSupportPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF017_CF021_validate_terms_page() {
		logger.info("Iniciando caso de prueba: Validate Terms Page");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.TERMS.getMenu());
		main.validateTerms(5);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF022_CF027_validate_legals_page() {
		logger.info("Iniciando caso de prueba: Validate Legals Page");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LEGALS.getMenu());
		main.validateLegalsPage();
		logger.info("Caso de prueba finalizado");
	}
	
}
