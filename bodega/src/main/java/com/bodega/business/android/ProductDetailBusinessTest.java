package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;

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

	public void selectNavigation(NavigationBarEnum navigationBarEnum) {
		general.selectNavigationOption(navigationBarEnum);
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

	public void selectProduct() {
		product.selectProduct();
	}

	public void validateCaracteristics() {
		logger.info("Validando caracteristicas");
		String productName = getElementText(NamesMobileElements.PRODUCT_DETAIL_NAME);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_DESC);
		tapOnElement(NamesMobileElements.PRODUCT_DETAIL_DESC);
		assertEquals(productName, getElementText(NamesMobileElements.PRODUCT_DETAIL_NAME));
	}

	public void validateMSI() {
		logger.info("Validando meses sin intereses");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_MSI);
		tapOnElement(NamesMobileElements.PRODUCT_DETAIL_MSI);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_MSI_CONT);
	}

	public void addProduct() {
		product.addProduct();
	}

	public void selectCar() {
		car.selectCar();
	}

	public void validateCar() {
		car.validateCar();
	}

	public void deleteProducts() {
		car.deleteProducts();
	}
	
	public void validateSellers() {
		logger.info("Validando vendedores");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_DESC);
		List<MobileElement> sellers = findElements(NamesMobileElements.PRODUCT_DETAIL_SELLERS_CONT);
		for (MobileElement seller : sellers) {
			tapOnElement(seller);
			String sellerPrice = getElementText(
					findSubElement(seller, NamesMobileElements.PRODUCT_DETAIL_SELLERS_PRICE));
			String sellerName = getElementText(
					findSubElement(seller, NamesMobileElements.PRODUCT_DETAIL_SELLERS_SELL_BY));
			scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.PRODUCT_DETAIL_PRICE);
			tapUp();
			String productPrice = getElementText(
					findSubElement(NamesMobileElements.PRODUCT_DETAIL_CONT, NamesMobileElements.PRODUCT_DETAIL_PRICE));
			String productSeller = getElementText(
					findSubElement(NamesMobileElements.PRODUCT_DETAIL_CONT, NamesMobileElements.PRODUCT_DETAIL_SELLER));
			assertEquals(sellerPrice, productPrice);
			assertEquals(sellerName, productSeller);
		}
	}
}
