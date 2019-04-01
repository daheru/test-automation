package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.FiltersEnum;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class SearchBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(SearchBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest login = new LoginBusinessTest();
	public String filterSelected = "";

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
		waitElementVisibility(NamesMobileElements.HOME_ITEM_BANNER);
		tapOnElement(NamesMobileElements.HOME_SEARCH_BAR);
		fillElement(NamesMobileElements.HOME_SEARCH_BAR, product);
		searchOnAndroid();
		logger.info("Buscando producto");
	}

	public void selectDepartment() {
		waitElementVisibility(NamesMobileElements.DEPARTMENT_DEPARTMENT_LIST);
		List<MobileElement> departments = findElements(NamesMobileElements.DEPARTMENT_ITEM_TEXT);
		tapOnElement(departments.get(0));
		logger.info("Seleccionado Departamento");
	}

	public void selectCategory() {
		waitElementVisibility(NamesMobileElements.DEPARTMENT_CAT_LIST);
		List<MobileElement> categoties = findElements(NamesMobileElements.DEPARTMENT_CAT_ITEM);
		tapOnElement(categoties.get(0));
		logger.info("Seleccionado Categoria");
	}

	public void tapOnFilter() {
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
		tapOnElement(NamesMobileElements.SEARCH_FILTER_BUTTON);
		logger.info("Seleccionado Filtro");
	}

	public void selectFilter(String... filters) {
		waitElementVisibility( NamesMobileElements.FILTER_LIST_CATEGORY);
		for (String filter : filters) {
			if (filterSelected.isEmpty()) {
				filterSelected = filter;
			}
			tapOnElement(filter);
		}
		logger.info("Aplicando filtros");
	}

	public void applyFilter() {
		waitElementVisibility(NamesMobileElements.FILTER_APPLY_BUTTON);
		tapOnElement(NamesMobileElements.FILTER_APPLY_BUTTON);
		logger.info("Buscando productos");
	}
	
	public void selectSubCategory() {
		waitElementVisibility( NamesMobileElements.FILTER_LIST_CATEGORY);
		List<MobileElement> categories = findElements( NamesMobileElements.FILTER_LIST_ITEM );
		tapOnElement( categories.get(0) );
		waitElementVisibility( NamesMobileElements.FILTER_ITEM_CHECK);
		List<MobileElement> subCategories = findElements( NamesMobileElements.FILTER_ITEM_CHECK );
		tapOnElement( subCategories.get(0) );
	}
}
