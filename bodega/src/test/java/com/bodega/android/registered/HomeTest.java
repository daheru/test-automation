package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.HomeBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Home Module - Session")
public class HomeTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(HomeBusinessTest.class);
	private static HomeBusinessTest home = new HomeBusinessTest();
	private static GeneralBusinessTest general = new GeneralBusinessTest();

	@AfterClass
	public static void shutDown() {
		home.driverDisconect();
	}

	@Before
	public void initApp() {
		home.closeAndroidDialog();
		general.validateWelcomePage();
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		home.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate home page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to see home page")
	@Description("Validate that home page has all elements")
	public void CF005_validate_home_page() {
		home.selectHomeOption();
		home.validateHomePage();
	}

}
