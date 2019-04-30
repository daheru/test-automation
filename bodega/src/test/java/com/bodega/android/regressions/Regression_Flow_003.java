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
import com.bodega.business.android.SearchBusinessTest;
import com.bodega.enums.FiltersEnum;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;
import com.bodega.vo.AddressVO;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;

@Feature("Regression Flows")
public class Regression_Flow_003 {

	private static final Logger logger = Logger.getLogger(Regression_Flow_003.class);
	private static GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	private HomeBusinessTest home = new HomeBusinessTest();
	private MenuBusinessTest menu = new MenuBusinessTest();
	private static AddressVO address;

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
		login.resetApp();
	}

	@Test
	@DisplayName("Regression Flow 1")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Regression Flow using diffent functionality")
	public void regression_flow_003() {
		address = new AddressVO("Mi direccion ", "Maria", "Tester", "Av Rodolfo Gaona 46", "456", "", "11200",
				"Lomas de Sotelo", "Entre calle 1 y calle 2", "Plaza Toreo", "Movil", "5555555555", true);
		logger.info("Iniciando prueba de regresion");
		login.selectProfile();
		login.selectLoginOption();
		login.login("correo_test@correo.com", "Juan#123");
		general.selectNavigationOption(NavigationBarEnum.CAR);
		car.deleteProducts();
		general.selectNavigationOption(NavigationBarEnum.DEPARTMENTS);
		departments.selectDepartment();
		departments.selectCategory();
		product.selectProduct();
		general.goBack();
		departments.tapOnFilter();
		departments.selectFilter(FiltersEnum.Z_A);
		departments.applyFilter();
		product.selectProduct();
		product.addProduct();
		car.selectCar();
		car.validateCar();
		general.goBack();
		general.goBack();
		general.goBack();
		general.goBack();
		home.selectHomeOption();
		search.searchProduct("camaras");
		product.selectProduct();
		product.addProduct();
		general.goBack();
		general.goBack();
		login.selectProfile();
		menu.selectMenu(ProfileMenuEnum.ADDRESS);
		menu.selectAsMainAddress();
		address.setAddressUserName("Maria");
		address.setAddressStreet("Golfo de Bengala");
		address.setAddressZipcode("11410");
		address.setAddressNeighbornhood("Tacuba");
		menu.editAddress(address);
		menu.saveDirection();
		general.goBack();
		general.goBack();
		general.selectNavigationOption(NavigationBarEnum.CAR);
		car.validateCar();
		car.selectContinueBuying();
	}
}
