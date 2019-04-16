package com.bodega.android.regressions;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.CarBusinessTest;
import com.bodega.business.android.DepartmentsBusinessTest;
import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.LoginBusinessTest;
import com.bodega.business.android.ProductBusinessTest;
import com.bodega.business.android.SearchBusinessTest;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.FiltersEnum;
import com.bodega.enums.NavigationBarEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;

@Feature("Regression Flows")
public class Regression_Flow_001 {

	private static final Logger logger = Logger.getLogger(Regression_Flow_001.class);
	private static GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	
	@AfterClass
	public static void shutDown() {
		general.driverDisconect();
	}

	@Before
	public void initApp() {
		general.closeAndroidDialog();
		general.validateWelcomePage();
	}

	@After
	public void relauchApp() {
		login.closeApp();
		login.lauchApp();
	}

	@Test
	@DisplayName("Regression Flow 1")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Regression Flow using diffent functionality")
	public void regresion_flow_001() {
		logger.info("Iniciando prueba de regresion");
		search.searchProduct("Videojuegos");
		search.validateNoResults();
		general.goBack();
		search.searchProduct("xbox");
		search.validateSearch();
		product.selectProduct();
		product.addProduct();
		product.addProduct();
		product.removeProduct();
		general.goBack();
		general.goBack();
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.MINNOR_PRICE.getFilter() );
		departments.applyFilter();
		product.selectProduct();
		product.addProduct();
		car.selectCar();
		car.selectContinueBuying();
		login.login("fake_mail@hotmail.es", "12345678");
		login.validatePopUpMessage( AppMessages.ACCOUNT_UNEXIST_EMAIL );
		login.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		logger.info("Prueba de regresion finalizada");
	}
}
