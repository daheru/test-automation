package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.OrdersBusinessTest;
import com.walmartmg.constants.GeneralConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

public class OrdersTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(ProfileTest.class);
	private static OrdersBusinessTest orders = new OrdersBusinessTest();

	@AfterClass
	public static void tearDown() {
		orders.driverDisconect();
	}

	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void resetApp() {
		orders.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate orders page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my orders")
	@Description("Validate that orders page has all elements")
	public void CP107_validate_screen_your_orders() {
		orders.selectProfileOption();
		orders.selectMenuLogin();
		orders.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		orders.selectRequestMyProfile();
		orders.validateScreenYouOrders();
	}

	@Test
	@DisplayName("Validate start buying")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my orders")
	@Description("Validate that star buying button works")
	public void CP108_validate_btnstart_your_orders() {
		orders.selectProfileOption();
		orders.selectMenuLogin();
		orders.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		orders.selectRequestMyProfile();
		orders.validateBtnStartYouOrders();
	}

	@Test
	@DisplayName("Validate list orders")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my orders")
	@Description("Validate that user's order list works")
	public void CP109_validate_screen_list_orders() {
		orders.selectProfileOption();
		orders.selectMenuLogin();
		orders.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		orders.selectRequestMyProfile();
		orders.validateListYouOrders();
	}
}
