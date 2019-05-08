package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.qameta.allure.Step;

public class HomeBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(HomeBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();

	public void login(String email, String pass) {
		login.login(email, pass);
	}

	public void selectProfileOption() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	public void selectHomeOption() {
		general.selectNavigationOption(NavigationBarEnum.HOME);
	}

	@Step("Validate home page")
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

	@Step("Tap on scan product icon")
	public void scanProduct() {
		logger.info("Escaneando producto");
		waitElementVisibility(NamesMobileElements.HOME_OFFERS_FILTER);
		tapOnElement(NamesMobileElements.HOME_SCAN);
	}

	@Step("Validate scan page")
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

	@Step("Validate starting buy")
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

	public void validateCar() {
		car.validateCar();
	}

	public void goBack() {
		general.goBack();
	}

	public void deleteProduct() {
		car.deleteProduct();
	}
	
	public void deleteProducts() {
		car.deleteProducts();
	}

	@Step("Cancel delete product")
	public void cancelDeleteProduct() {
		car.cancelDeleteProduct();
	}

	public void removeProduct() {
		product.removeProduct();
	}

	public void validateBuy() {
		car.validateContinue();
	}
}
