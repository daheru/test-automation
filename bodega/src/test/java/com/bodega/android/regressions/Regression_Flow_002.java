package com.bodega.android.regressions;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.CarBusinessTest;
import com.bodega.business.android.DepartmentsBusinessTest;
import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.HomeBusinessTest;
import com.bodega.business.android.LoginBusinessTest;
import com.bodega.business.android.MenuBusinessTest;
import com.bodega.business.android.ProductBusinessTest;
import com.bodega.vo.AddressVO;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;

@Feature("Regression Flows")
public class Regression_Flow_002 {

	private static final Logger logger = Logger.getLogger(Regression_Flow_002.class);
	private static GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	private HomeBusinessTest home = new HomeBusinessTest();
	private MenuBusinessTest menu = new MenuBusinessTest();
	private static AddressVO address;

	@AfterClass
	public static void shutDown() {
		general.driverDisconect();
		address = new AddressVO("Mi direccion ", "Maria", "Tester", "Av Rodolfo Gaona 46", "456", "", "11200",
				"Lomas de Sotelo", "Entre calle 1 y calle 2", "Plaza Toreo", "Movil", "5555555555", true);
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
	public void regresion_flow_002() {
		logger.info("Iniciando prueba de regresion");
		home.tapOnBanner();
		product.selectProduct();
		product.addProduct();
		general.goBack();
		general.goBack();
		general.tapUp();
		general.tapUp();
		departments.selectShowAll();
		product.selectProduct();
		product.addProduct();
		product.addProduct();
		product.removeProduct();
		car.selectCar();
		car.validateCar();
		car.selectContinueBuying();
		String email = general.randomString(10, true, true);
		String pass = general.randomString(8, true, true);
		login.selectCreateAccount();
		login.createAccount("Maria", "Tester", email + "@correo.com", pass);
		car.validateCar();
		car.selectContinueBuying();
		menu.addNewDirection(address);
		logger.info("Prueba de regresion finalizada");
	}
}
