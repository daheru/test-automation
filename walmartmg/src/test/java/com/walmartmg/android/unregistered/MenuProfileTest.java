package com.walmartmg.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.MenuProfileBusinessTest;
import com.walmartmg.enums.ProfileMenuEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Profile Module - No session")
public class MenuProfileTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(MenuProfileTest.class);
	private static MenuProfileBusinessTest profile = new MenuProfileBusinessTest();

	@AfterClass
	public static void tearnDown() {
		profile.driverDisconect();
	}

	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		profile.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate menu no session")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that profile menu without session has all elements")
	public void CPO17_validate_menu_without_login() {
		profile.selectProfile();
		profile.validateMenu(false);
	}
	
	@Test
	@DisplayName("Validate help page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that help page has all elements")
	public void CP039_validate_help_page() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.SUPPORT);
		profile.validateHelpPage();
	}
	
	@Test
	@DisplayName("Validate call us page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that call us element works correctly")
	public void CP040_validate_help_callus() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.SUPPORT);
		profile.validateCallUs();
	}
	
	@Test
	@DisplayName("Validate write us page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that write us works correctly")
	public void CP041_validate_help_writeus() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.SUPPORT);
		profile.validateWriteUs();
	}
	
	@Test
	@DisplayName("Validate terms page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that terms page has all elements")
	public void CP042_CP052_validate_terms_and_conds() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.TERMS);
		profile.validateTermsPage();
	}
	
	@Test
	@DisplayName("Validate legals page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that legals page has all elements")
	public void CF030_CF035_validate_legals_page() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LEGALS);
		profile.validateLegalsPage();
	}
}
