package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.MenuProfileBusinessTest;
import com.walmartmg.constants.GeneralConstants;
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
	@DisplayName("Validate menu with session")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that profile menu with session has all elements")
	public void CP089_validate_menu_with_login() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LOGIN);
		profile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		profile.selectProfile();
		profile.validateMenu(true);
	}
	
	@Test
	@DisplayName("Validate terms page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that terms page has all elements")
	public void CP118_CP128_validate_terms_and_conds() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LOGIN);
		profile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.TERMS);
		profile.validateTermsPage();
	}
	
	@Test
	@DisplayName("Validate legals page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that legals page has all elements")
	public void CF129_validate_legals_page() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LOGIN);
		profile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LEGALS);
		profile.validateLegalsPage(7);
	}
	
	@Test
	@DisplayName("Validate logout")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to use my profile menu")
	@Description("Validate when user try to logout")
	public void CF130_logout() {
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LOGIN);
		profile.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		profile.selectProfile();
		profile.selectMenu(ProfileMenuEnum.LOGOUT);
		profile.validateHomePage();
	}
}
