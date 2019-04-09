package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.FiltersEnum;

import io.appium.java_client.MobileElement;

public class SearchBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(SearchBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private String filterSelected = "";

	public void validateWelcomePage() {
		generalBusinessTest.validateWelcomePage();
	}

	public void selectProfile() {
		generalBusinessTest.selectProfile();
	}

	public void selectMenu(String menu) {
		generalBusinessTest.selectMenuOption(menu);
	}

	public void selectNavigation(int option) {
		generalBusinessTest.selectNavigationOption(option);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

	public void validateSearch() {
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
		if (!filterSelected.isEmpty()) {
			List<MobileElement> productList;
			float higherPrice = 0f;
			float lowerPrice = 0f;
			if (FiltersEnum.A_Z.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_NAME);
				assertTrue("Los productos no estan ordenados", getElementText(productList.get(0))
						.compareTo(getElementText(productList.get(productList.size() - 1))) < 0);
			} else if (FiltersEnum.Z_A.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_NAME);
				assertTrue("Los productos no estan ordenados", getElementText(productList.get(0))
						.compareTo(getElementText(productList.get(productList.size() - 1))) > 0);
			} else if (FiltersEnum.HIGHER_PRICE.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_PRICE);
				higherPrice = Float.parseFloat(getElementText(productList.get(0)).replaceAll("[^\\d.]", ""));
				lowerPrice = Float.parseFloat(getElementText(productList.get(productList.size() - 1)).replaceAll("[^\\d.]", ""));
				assertTrue("Los productos no estan ordenados", higherPrice >= lowerPrice);
			} else if (FiltersEnum.MINNOR_PRICE.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_PRICE);
				higherPrice = Float.parseFloat(getElementText(productList.get(productList.size() - 1)).replaceAll("[^\\d.]", ""));
				lowerPrice = Float.parseFloat(getElementText(productList.get(0)).replaceAll("[^\\d.]", ""));
				assertTrue("Los productos no estan ordenados", higherPrice >= lowerPrice);
			}
		}
		filterSelected = "";
		logger.info("Validando lista de productos");
	}

	public void validateNoResults() {
		waitElementVisibility( NamesMobileElements.SEARCH_NO_PRODUCT_LABEL );
		waitElementVisibility( NamesMobileElements.SEARCH_NO_PRODUCT_ICON );
	}
	
	public void searchProduct(String product) {
		logger.info("Buscando producto");
		waitElementVisibility(NamesMobileElements.HOME_SEARCH_BAR);
		tapOnElement(NamesMobileElements.HOME_SEARCH_BAR);
		fillElement(NamesMobileElements.HOME_SEARCH_BAR, product);
		searchOnAndroid();
	}

	public void tapOnFilter() {
		logger.info("Seleccionado Filtro");
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
		tapOnElement(NamesMobileElements.SEARCH_FILTER_BUTTON);
	}

	public void selectFilter(String... filters) {
		logger.info("Aplicando filtros");
		waitElementVisibility( NamesMobileElements.FILTER_LIST_CATEGORY);
		for (String filter : filters) {
			if (filterSelected.isEmpty()) {
				filterSelected = filter;
			}
			tapOnElement(filter);
		}
	}

	public void applyFilter() {
		logger.info("Buscando productos");
		waitElementVisibility(NamesMobileElements.FILTER_APPLY_BUTTON);
		tapOnElement(NamesMobileElements.FILTER_APPLY_BUTTON);
	}
	
	public void selectSubCategory() {
		logger.info("Seleccionando sub categoria");
		waitElementVisibility( NamesMobileElements.FILTER_LIST_CATEGORY);
		List<MobileElement> categories = findElements( NamesMobileElements.FILTER_LIST_ITEM );
		tapOnElement( categories.get(0) );
		waitElementVisibility( NamesMobileElements.FILTER_ITEM_CHECK);
		List<MobileElement> subCategories = findElements( NamesMobileElements.FILTER_ITEM_CHECK );
		tapOnElement( subCategories.get(0) );
	}
}
