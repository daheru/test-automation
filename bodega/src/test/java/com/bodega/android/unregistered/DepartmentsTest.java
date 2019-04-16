package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.DepartmentsBusinessTest;
import com.bodega.enums.FiltersEnum;
import com.bodega.enums.NavigationBarEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Departments Module - No session")
public class DepartmentsTest {
	
	private static final Logger logger = Logger.getLogger(DepartmentsTest.class);
	private static DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	
	@AfterClass
	public static void shutDown() {
		departments.driverDisconect();
	}

	@Before
	public void initApp() {
		departments.closeAndroidDialog();
		departments.validateWelcomePage();
	}

	@After
	public void relauchApp() {
		departments.resetApp();
	}
	
	@Test
	@DisplayName("Validate promotions")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to see the promotions")
	@Description("Validate promotions list is showed when a user tap on promotions")
	public void CF049_validate_promotions() {
		logger.info("===> Iniciando caso de prueba: Validate promotions");
		departments.selectNavigation( NavigationBarEnum.PROMOTIONS.getNavigation() );
		departments.validateProducts();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate departments")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to choice a department")
	@Description("Validate department list is showed when a user tap on departments")
	public void CF050_validate_departments() {
		logger.info("===> Iniciando caso de prueba: Validate departments");
		departments.selectNavigation( NavigationBarEnum.DEPARTMENTS.getNavigation() );
		departments.validateDepartments();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate show all")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to see all products when a user tap on show all")
	@Description("Validate product list is showed when a user tap on show all")
	public void CF051_validate_show_all() {
		logger.info("===> Iniciando caso de prueba: Validate departments");
		departments.selectNavigation( NavigationBarEnum.HOME.getNavigation() );
		departments.selectShowAll();
		departments.validateProducts();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Search by A-Z filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign A-Z filter")
	public void CF052_search_by_A_Z_filter() {
		logger.info("===> Iniciando caso de prueba: Search by A-Z");
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.A_Z.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Search by Z-A filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign Z-A filter")
	public void CF053_search_by_Z_A_filter() {
		logger.info("===> Iniciando caso de prueba: Search by Z-A");
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.Z_A.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Search by minnor price filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign minnor price filter")
	public void CF054_search_by_minnor_price_filter() {
		logger.info("===> Iniciando caso de prueba: Search by minnor price");
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.MINNOR_PRICE.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Search by higher price filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign higher price filter")
	public void CF055_search_by_higher_price_filter() {
		logger.info("===> Iniciando caso de prueba: Search by higher price");
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.HIGHER_PRICE.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Search by popular filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign popular filter")
	public void CF056_search_by_popular_filter() {
		logger.info("===> Iniciando caso de prueba: Search by popular");
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.POPULAR.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
}
