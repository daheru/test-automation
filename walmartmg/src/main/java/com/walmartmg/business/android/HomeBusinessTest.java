package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;

public class HomeBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(HomeBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();

	public void selectHomeOption() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.HOME.getNavigation());
	}

	public void validateElements() {
		logger.info("Validando página de home");
		waitElementVisibility(NamesMobileElements.HOME_CAR);
		waitElementVisibility(NamesMobileElements.HOME_OFFERS_FILTER);
		waitElementVisibility(NamesMobileElements.HOME_OFFERS_FILTER);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.HOME_PRODUCT_LIST);
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_LIST);
		waitElementVisibility(NamesMobileElements.HOME_SCAN);
		waitElementVisibility(NamesMobileElements.HOME_SEARCH_BUTTON);
		waitElementVisibility(NamesMobileElements.NAV_BAR_DEPARTMENTS);
		waitElementVisibility(NamesMobileElements.NAV_BAR_HOME);
		waitElementVisibility(NamesMobileElements.NAV_BAR_PROFILE);
	}

	public void searchProduct(String product) {
		search.searchProduct(product);
	}

	public void validateSearch() {
		search.validateSearch();
	}

	public void validateEmptySearch() {
		search.validateEmptySearch();
	}

	public void scanProduct() {
		logger.info("Escaneando producto");
		waitElementVisibility(NamesMobileElements.HOME_OFFERS_FILTER);
		tapOnElement(NamesMobileElements.HOME_SCAN);
	}

	public void validateScanPage() {
		logger.info("Validando página del scaner");
		if (elementExist(NamesMobileElements.ANDROID_DIALOG_CONT)) {
			tapOnElement(NamesMobileElements.ANDROID_NATIVE_ALLOW);
		}
		waitElementVisibility(NamesMobileElements.SCAN_CONTAINER);
		waitElementVisibility(NamesMobileElements.SCAN_TITLE);
		waitElementVisibility(NamesMobileElements.SCAN_MESSAGE);
		waitElementVisibility(NamesMobileElements.SCAN_BOX);
	}

	public void selectCar() {
		car.selectCar();
	}

	public void validateEmptyCar() {
		car.validateEmptyCar();
	}

	public void validateStartingBuy() {
		logger.info("Validando empezar a comprar");
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_CAR);
		tapOnElement(NamesMobileElements.CAR_EMPTY_CAR_BUTTON);
		validateElements();
	}

	public void selectProduct() {
		product.selectHomeProduct();
	}

	public void validateProduct() {
		product.validateProduct();
	}

	public void addProduct() {
		product.addProduct();
	}

	public void validatePopUpMessages(String message) {
		generalBusinessTest.validatePopUpMessages(message);
	}

	public void validateCar() {
		car.validateCar();
	}

	public void goBack() {
		generalBusinessTest.goBack();
	}

	public void deleteProduct() {
		car.deleteProduct();
	}

	public void cancelDeleteProduct() {
		car.cancelDeleteProduct();
		car.validateCar();
	}

	public void removeProduct() {
		product.removeProduct();
	}

	public void validateBuy() {
		car.validateContinue();
	}

}
