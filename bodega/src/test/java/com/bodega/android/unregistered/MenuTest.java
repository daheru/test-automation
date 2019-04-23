package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.MenuBusinessTest;
import com.bodega.enums.ProfileMenuEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Menu Module - No session")
public class MenuTest {

	@Rule
	public TestName name = new TestName();
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
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		main.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Scan ticket manually")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to scan my ticket")
	@Description("Scan ticket introducing numbers manually")
	public void CF011_scan_manually_ticket() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.GET_BILL);
		main.closeAndroidDialog();
		main.manualBill("36214691686686662445");
	}

	@Test
	@DisplayName("Validate support page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use support page to ask for help or support")
	@Description("Scan ticket introducing numbers manually")
	public void CF015_CF016_validate_suppor_page() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.SUPPORT);
		main.validateSupportPage();
	}

	@Test
	@DisplayName("Validate term page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check terms")
	@Description("Check all terms on the page")
	public void CF017_CF021_validate_terms_page() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.TERMS);
		main.validateTerms(5);
	}

	@Test
	@DisplayName("Validate legal page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check support page to ")
	@Description("Check all legals on the page")
	public void CF022_CF027_validate_legals_page() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LEGALS);
		main.validateLegalsPage();
	}
	
	@Test
	@DisplayName("Validate menu no session")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that profile menu without session has all elements")
	public void CF000_validate_menu_without_login() {
		main.selectProfile();
		main.validateMenu(false);
	}
}
