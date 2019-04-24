package com.bodega.business.android;

import java.text.Collator;
import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.FiltersEnum;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class SearchBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(SearchBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private static String filterSelected = "";

	public void validateWelcomePage() {
		generalBusinessTest.validateWelcomePage();
	}

	public void selectProfile() {
		generalBusinessTest.selectProfile();
	}

	public void selectMenu(ProfileMenuEnum menu) {
		generalBusinessTest.selectMenuOption(menu);
	}

	public void selectNavigation(NavigationBarEnum option) {
		generalBusinessTest.selectNavigationOption(option);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

	@Step("Validate search")
	public void validateSearch() {
		logger.info("Validando lista de productos");
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
		if (!filterSelected.isEmpty()) {
			double higherPrice = 0;
			double lowerPrice = 0;
			List<MobileElement> productList;
			Collator comparador = Collator.getInstance();
			comparador.setStrength(Collator.TERTIARY);
			waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_NAME);
			if (FiltersEnum.A_Z.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_NAME);
				assertTrue("Los productos no estan ordenados",
						productList.size() > 0 && comparador.compare(getElementText(productList.get(0)),
								getElementText(productList.get(productList.size() - 1))) < 0);
			} else if (FiltersEnum.Z_A.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_NAME);
				assertTrue("Los productos no estan ordenados", productList.size() > 0 && comparador.compare(getElementText(productList.get(0)),
						getElementText(productList.get(productList.size() - 1))) > 0);
			} else if (FiltersEnum.HIGHER_PRICE.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_PRICE);
				higherPrice = productList.size() > 0 ? Double.parseDouble(getElementText(productList.get(0)).replaceAll("[^\\d.]", "")) : 0;
				lowerPrice = productList.size() > 0 ? Double.parseDouble(getElementText(productList.get(productList.size() - 1)).replaceAll("[^\\d.]", "")) : 0;
				assertTrue("Los productos no estan ordenados", higherPrice >= lowerPrice);
			} else if (FiltersEnum.MINNOR_PRICE.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_PRICE);
				higherPrice = productList.size() > 0 ? Double.parseDouble(getElementText(productList.get(productList.size() - 1)).replaceAll("[^\\d.]", "")) : 0;
				lowerPrice = productList.size() > 0 ? Double.parseDouble(getElementText(productList.get(0)).replaceAll("[^\\d.]", "")) : 0;
				assertTrue("Los productos no estan ordenados", higherPrice >= lowerPrice);
			}
		}
		filterSelected = "";
	}

	@Step("Validate no results page")
	public void validateNoResults() {
		waitElementVisibility(NamesMobileElements.SEARCH_NO_PRODUCT_LABEL);
		waitElementVisibility(NamesMobileElements.SEARCH_NO_PRODUCT_ICON);
	}

	@Step("Search product {product}")
	public void searchProduct(String product) {
		logger.info("Buscando producto");
		waitElementVisibility(NamesMobileElements.HOME_SEARCH_BAR);
		tapOnElement(NamesMobileElements.HOME_SEARCH_BAR);
		fillElement(NamesMobileElements.HOME_SEARCH_BAR, product);
		searchOnAndroid();
	}

	@Step("Tap on filter")
	public void tapOnFilter() {
		logger.info("Seleccionado Filtro");
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
		tapOnElement(NamesMobileElements.SEARCH_FILTER_BUTTON);
	}

	@Step("Tap filter {filters}")
	public void selectFilter(String... filters) {
		logger.info("Aplicando filtros");
		waitElementVisibility(NamesMobileElements.FILTER_LIST_CATEGORY);
		for (String filter : filters) {
			if (filterSelected.isEmpty()) {
				filterSelected = filter;
			}
			tapOnElement(filter);
		}
	}

	@Step("Apply filter")
	public void applyFilter() {
		logger.info("Buscando productos");
		waitElementVisibility(NamesMobileElements.FILTER_APPLY_BUTTON);
		tapOnElement(NamesMobileElements.FILTER_APPLY_BUTTON);
	}

	@Step("Tap on subcategory")
	public void selectSubCategory() {
		logger.info("Seleccionando sub categoria");
		waitElementVisibility(NamesMobileElements.FILTER_LIST_CATEGORY);
		List<MobileElement> categories = findElements(NamesMobileElements.FILTER_LIST_ITEM);
		tapOnElement(categories.get(0));
		waitElementVisibility(NamesMobileElements.FILTER_ITEM_CHECK);
		List<MobileElement> subCategories = findElements(NamesMobileElements.FILTER_ITEM_CHECK);
		tapOnElement(subCategories.get(0));
	}
}
