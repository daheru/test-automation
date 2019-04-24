package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

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
	
	@Rule
	public TestName name = new TestName();
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
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		departments.resetApp();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate promotions")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to see the promotions")
	@Description("Validate promotions list is showed when a user tap on promotions")
	public void CF049_validate_promotions() {
		departments.selectNavigation( NavigationBarEnum.PROMOTIONS );
		departments.validateProducts();
		departments.goBack();
		departments.validateHome();
	}
	
	@Test
	@DisplayName("Validate departments")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to choice a department")
	@Description("Validate department list is showed when a user tap on departments")
	public void CF050_validate_departments() {
		departments.selectNavigation( NavigationBarEnum.DEPARTMENTS );
		departments.validateDepartments();
	}
	
	@Test
	@DisplayName("Validate show all")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to see all products when a user tap on show all")
	@Description("Validate product list is showed when a user tap on show all")
	public void CF051_validate_show_all() {
		departments.selectNavigation( NavigationBarEnum.HOME );
		departments.selectShowAll();
		departments.validateProducts();
	}
	
	@Test
	@DisplayName("Search by A-Z filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign A-Z filter")
	public void CF052_search_by_A_Z_filter() {
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.A_Z.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
	}
	
	@Test
	@DisplayName("Search by Z-A filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign Z-A filter")
	public void CF053_search_by_Z_A_filter() {
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.Z_A.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
	}
	
	@Test
	@DisplayName("Search by minnor price filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign minnor price filter")
	public void CF054_search_by_minnor_price_filter() {
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.MINNOR_PRICE.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
	}
	
	@Test
	@DisplayName("Search by higher price filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign higher price filter")
	public void CF055_search_by_higher_price_filter() {
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.HIGHER_PRICE.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
	}
	
	@Test
	@DisplayName("Search by popular filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Sort product list usign popular filter")
	public void CF056_search_by_popular_filter() {
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		departments.selectDepartment();
		departments.selectCategory();
		departments.tapOnFilter();
		departments.selectFilter( FiltersEnum.POPULAR.getFilter() );
		departments.applyFilter();
		departments.validateSearch();
	}
	
	@Test
	@DisplayName("Valida tool bar title")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to choice a filter to sort the product list")
	@Description("Validate that title in toolbar is the same than department filter")
	public void CF000_validate_tool_bar_title() {
		departments.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		departments.selectDepartment();
		departments.selectCategory();
		departments.validateTitleToolbar();
	}
}
