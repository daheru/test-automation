package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.SearchBusinessTest;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.FiltersEnum;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.enums.NavigationBarEnum;

public class SearchTest {
	
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
	}

	@After
	public void relauchApp() {
		search.closeApp();
		search.lauchApp();
	}
	
	@Test
	public void CF058_search_product() {
		logger.info("Iniciando caso de prueba: Search product");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.searchProduct("Celulares");
		search.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF000_search_unexist_product() {
		logger.info("Iniciando caso de prueba: Search unexist product");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.searchProduct("Pan");
		search.validateNoResults();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF059_search_by_A_Z_filter() {
		logger.info("Iniciando caso de prueba: Search by A-Z");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter( FiltersEnum.A_Z.getFilter() );
		search.applyFilter();
		search.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF060_search_by_Z_A_filter() {
		logger.info("Iniciando caso de prueba: Search by Z-A");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter( FiltersEnum.MINNOR_PRICE.getFilter() );
		search.applyFilter();
		search.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF061_search_by_minnor_price_filter() {
		logger.info("Iniciando caso de prueba: Search by minnor price");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter( FiltersEnum.MINNOR_PRICE.getFilter() );
		search.applyFilter();
		search.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF062_search_by_higher_price_filter() {
		logger.info("Iniciando caso de prueba: Search by higher price");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter( FiltersEnum.HIGHER_PRICE.getFilter() );
		search.applyFilter();
		search.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF063_search_by_popular_filter() {
		logger.info("Iniciando caso de prueba: Search by popular");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectFilter( FiltersEnum.POPULAR.getFilter() );
		search.applyFilter();
		search.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF000_search_by_subcategory_filter() {
		logger.info("Iniciando caso de prueba: Search by subcategory");
		search.selectProfile();
		search.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		search.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.selectNavigation(NavigationBarEnum.DEPARTMENTS.getNavigation());
		search.searchProduct("Computadora");
		search.validateSearch();
		search.tapOnFilter();
		search.selectSubCategory();
		search.applyFilter();
		search.validateSearch();
		logger.info("Caso de prueba finalizado");
	}
	
}
