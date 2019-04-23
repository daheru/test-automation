package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.SearchBusinessTest;
import com.bodega.enums.FiltersEnum;
import com.bodega.enums.NavigationBarEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Search Module - No session")
public class SearchTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(SearchTest.class);
	private static SearchBusinessTest search = new SearchBusinessTest();

	@AfterClass
	public static void shutDown() {
		search.driverDisconect();
	}

	@Before
	public void initApp() {
		search.closeAndroidDialog();
		search.validateWelcomePage();
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		search.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Search product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Search product usign the search bar")
	public void CF046_search_product() {
		search.searchProduct("Celulares");
		search.validateSearch();
	}

	@Test
	@DisplayName("Search unexist product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Search an unexist product usign the search bar")
	public void CF000_search_unexist_product() {
		search.searchProduct("Pan");
		search.validateNoResults();
	}

	@Test
	@DisplayName("Search product by A-Z filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to search a product")
	@Description("Search product usign A-Z filter")
	public void CF047_search_by_A_Z_filter() {
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter(FiltersEnum.A_Z.getFilter());
		search.applyFilter();
		search.validateSearch();
	}

	@Test
	@DisplayName("Search product by Z-A filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to search a product")
	@Description("Search product usign Z-A filter")
	public void CF048_search_by_Z_A_filter() {
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter(FiltersEnum.Z_A.getFilter());
		search.applyFilter();
		search.validateSearch();
	}

	@Test
	@DisplayName("Search product by minnor price filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to search a product")
	@Description("Search product usign minnor price filter")
	public void CF049_search_by_minnor_price_filter() {
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter(FiltersEnum.MINNOR_PRICE.getFilter());
		search.applyFilter();
		search.validateSearch();
	}

	@Test
	@DisplayName("Search product by higher price filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to search a product")
	@Description("Search product usign higher price filter")
	public void CF050_search_by_higher_price_filter() {
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter(FiltersEnum.HIGHER_PRICE.getFilter());
		search.applyFilter();
		search.validateSearch();
	}

	@Test
	@DisplayName("Search product by popular filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to search a product")
	@Description("Search product usign popular filter")
	public void CF051_search_by_popular_filter() {
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter(FiltersEnum.POPULAR.getFilter());
		search.applyFilter();
		search.validateSearch();
	}

	@Test
	@DisplayName("Search product by subcategory filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to search a product")
	@Description("Search product usign subcategory filter")
	public void CF000_search_by_subcategory_filter() {
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS);
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectSubCategory();
		search.applyFilter();
		search.validateSearch();
	}
}
