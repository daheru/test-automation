package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class ProductDetailBusinessTest extends BaseDriver {
	
	public static final Logger logger = Logger.getLogger(ProductDetailBusinessTest.class);
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

	public void selectMenu(ProfileMenuEnum menu) {
		general.selectMenuOption(menu);
	}

	public void selectNavigation(NavigationBarEnum option) {
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

	@Step("Delete product")
	public void deleteProducts() {
		car.deleteProducts();
	}

	public void selectProduct() {
		product.selectProduct();
	}

	public void addProduct() {
		product.addProduct();
	}

	public void validateCar() {
		car.selectCar();
		car.validateCar();
	}

	@Step("Validate special product car")
	public void validateSpecialProductCar() {
		assertEquals(1, car.getUpcs().size());
	}
	
	@Step("Validate special product")
	public void validateSpecialProduct() {
		logger.info("Validando mensaje");
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		tapOnElement(NamesMobileElements.PRODUCT_ADD_BUTTON);
		general.validatePopUpMessages(AppMessages.SPECIAL_PRODUCT_VALIDATION);
		validateSpecialProductCar();
	}
	
	@Step("Increase product quantity")
	public void increaseProductFromCar(int quantity) {
		waitElementVisibility(NamesMobileElements.CAR_SPINNER);
		tapOnElement(NamesMobileElements.CAR_SPINNER);
		List<MobileElement> comboValues = findElements(NamesMobileElements.COMBO_OPTIONS);
		for (MobileElement comboValue : comboValues) {
			if (getElementText(comboValue).toLowerCase().contains(String.valueOf(quantity))) {
				comboValue.click();
				break;
			}
		}
		general.validatePopUpMessages(AppMessages.CAR_UPDATE);
		waitElementVisibility(NamesMobileElements.CAR_PRODUCT_ITEM);
		MobileElement parentElement = findElement(NamesMobileElements.CAR_PRODUCT_ITEM);
		String productName = getElementText(findSubElement(parentElement, NamesMobileElements.CAR_PRODUCT_NAME));
		car.getUpcs().put(productName, quantity);
	}
}
