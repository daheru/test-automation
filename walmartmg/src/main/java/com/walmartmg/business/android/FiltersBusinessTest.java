package com.walmartmg.business.android;

import java.text.Collator;
import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.FiltersEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class FiltersBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(InvoiceBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private static String filterSelected = "";

	public void selectNavitionOption(NavigationBarEnum navigationBarEnum) {
		general.selectNavigationOption(navigationBarEnum);
	}

	public void selectProfileMenuOption(ProfileMenuEnum profileMenuEnum) {
		general.selectMenuOption(profileMenuEnum);
	}

	// Select department
	public void selectDepartment() {
		logger.info("Selecciona un departamento");
		departments.selectDepartment();
	}

	// Select family
	public void selectFamily() {
		logger.info("Selecciona una familia");
		departments.selectFamily();
	}

	// Select filters
	public void pressLinkFilter() {
		logger.info("Seleccionar link filtro");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
	}

	public void login(String email, String pass) {
		login.login(email, pass);
	}

	public void selectMenuLogin() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	// Validate Screen Filter
	@Step("Validate filter page")
	public void validateScreenFilter() {
		logger.info("Tap en filtrar");
		waitElementVisibility(NamesMobileElements.FILTERS_CONT);
		waitElementVisibility(NamesMobileElements.FILTERS_FILTER_BY);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_AZ);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_ZA);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_GREATERTHAN);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_LESSTHAN);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_POPULARITY);
		waitElementVisibility(NamesMobileElements.FILTERS_PRICE);
		waitElementVisibility(NamesMobileElements.FILTERS_FILTER_BY);
		waitElementVisibility(NamesMobileElements.FILTERS_BUTTON);
	}

	@Step("Select filter")
	public void selectFilter(FiltersEnum filter) {
		waitElementVisibility(NamesMobileElements.FILTERS_CONT);
		filterSelected = filter.getFilter();
		tapOnElement(filter.getFilter());
	}

	@Step("Apply filter")
	public void applyFilter() {
		logger.info("Buscando productos");
		waitElementVisibility(NamesMobileElements.FILTERS_BUTTON);
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}

	@Step("Tap on sub category filter")
	public void filterBy() {
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY);
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY_BRAND);
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY_CHECK);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}

	@Step("Validate search")
	public void validateSearch() {
		logger.info("Validando lista de productos");
		waitElementVisibility(NamesMobileElements.SEARCH_RESULT_LIST);
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
				assertTrue("Los productos no estan ordenados",
						productList.size() > 0 && comparador.compare(getElementText(productList.get(0)),
								getElementText(productList.get(productList.size() - 1))) > 0);
			} else if (FiltersEnum.HIGHER_PRICE.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_PRICE);
				higherPrice = productList.size() > 0
						? Double.parseDouble(getElementText(productList.get(0)).replaceAll("[^\\d.]", ""))
						: 0;
				lowerPrice = productList.size() > 0 ? Double.parseDouble(
						getElementText(productList.get(productList.size() - 1)).replaceAll("[^\\d.]", "")) : 0;
				assertTrue("Los productos no estan ordenados", higherPrice >= lowerPrice);
			} else if (FiltersEnum.MINNOR_PRICE.getFilter().equals(filterSelected)) {
				productList = findElements(NamesMobileElements.SEARCH_PRODUCT_PRICE);
				higherPrice = productList.size() > 0 ? Double.parseDouble(
						getElementText(productList.get(productList.size() - 1)).replaceAll("[^\\d.]", "")) : 0;
				lowerPrice = productList.size() > 0
						? Double.parseDouble(getElementText(productList.get(0)).replaceAll("[^\\d.]", ""))
						: 0;
				assertTrue("Los productos no estan ordenados", higherPrice >= lowerPrice);
			}
		}
		filterSelected = "";
	}
}
