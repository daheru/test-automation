package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;

public class SpecialProductBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(SpecialProductBusinessTest.class);
	private LoginBusinessTest login = new LoginBusinessTest();
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();

	public void validateWelcomePage() {
		general.validateWelcomePage();
	}

	public void selectProfile() {
		general.selectProfile();
	}

	public void selectMenu(String menu) {
		general.selectMenuOption(menu);
	}

	public void selectNavigation(int option) {
		general.selectNavigationOption(option);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

	public void searchProduct(String product) {
		search.searchProduct(product);
	}

	public void validateSearch() {
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
	}

	public void goBack() {
		general.goBack();
	}

	public void deleteProducts() {
		logger.info("Eliminando productos");
		while (!elementExist(NamesMobileElements.CAR_EMPTY_CAR)
				&& elementExist(NamesMobileElements.CAR_PRODUCT_DELETE)) {
			tapOnElement(NamesMobileElements.CAR_PRODUCT_DELETE);
			waitElementVisibility(NamesMobileElements.CAR_DIALOG_CONFIRM);
			tapOnElement(NamesMobileElements.CAR_DIALOG_CONFIRM);
		}
		goBack();
	}

	public void selectProduct() {
		product.selectProduct();
	}

	public void addProduct() {
		product.addProduct();
	}

	public void validateCar() {
		car.validateCar();
	}

	public void validateSpecialProduct() {
		logger.info("Validando mensaje");
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		tapOnElement(NamesMobileElements.PRODUCT_ADD_BUTTON);
		general.validatePopUpMessages(AppMessages.SPECIAL_PRODUCT_VALIDATION);
	}
}
