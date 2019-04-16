package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.MenuBusinessTest;
import com.bodega.enums.ProfileMenuEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Login Module - No session")
public class MenuTest {

	private static final Logger logger = Logger.getLogger(MenuTest.class);
	private static MenuBusinessTest main = new MenuBusinessTest();
	private static GeneralBusinessTest general = new GeneralBusinessTest();
	
	@BeforeClass
	public static void init() {
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
	@DisplayName("Scan ticket manually")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to scan my ticket")
	@Description("Scan ticket introducing numbers manually")
	public void CF011_scan_manually_ticket() {
		logger.info("Iniciando caso de prueba: Scan manually ticket");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.GET_BILL.getMenu());
		main.closeAndroidDialog();
		main.manualBill("36214691686686662445");
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate support page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use support page to ask for help or support")
	@Description("Scan ticket introducing numbers manually")
	public void CF015_CF016_validate_suppor_page() {
		logger.info("Iniciando caso de prueba: Validate Support Page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.SUPPORT.getMenu());
		main.validateSupportPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate term page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check terms")
	@Description("Check all terms on the page")
	public void CF017_CF021_validate_terms_page() {
		logger.info("Iniciando caso de prueba: Validate Terms Page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.TERMS.getMenu());
		main.validateTerms(5);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate legal page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check support page to ")
	@Description("Check all legals on the page")
	public void CF022_CF027_validate_legals_page() {
		logger.info("Iniciando caso de prueba: Validate Legals Page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LEGALS.getMenu());
		main.validateLegalsPage();
		logger.info("Caso de prueba finalizado");
	}
	
}
