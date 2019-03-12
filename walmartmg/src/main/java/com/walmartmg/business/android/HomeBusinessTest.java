package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.commons.GeneralConstants;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class HomeBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(HomeBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectHomeOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.HOME.getNavigation() );
	}
	
	public void validateElements() {
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_CAR );
		waitVisibility( MobileNamesConstants.HOME_OFFERS_FILTER );
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_OFFERS_FILTER );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , MobileNamesConstants.HOME_PRODUCT_LIST);
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_PRODUCT_LIST );
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_SCAN );
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_SEARCH_BUTTON );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_DEPARTMENTS );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_HOME );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_PROFILE );
	}
	
	public void searchProduct(String product) {
		waitVisibility( MobileNamesConstants.HOME_OFFERS_FILTER );
		tapOnElement( MobileNamesConstants.HOME_SEARCH_BUTTON );
		fillElement( MobileNamesConstants.HOME_SEARCH_FIELD, product + "\\n");
	}
	
	public void validateSearch() {
		waitVisibility( MobileNamesConstants.SEARCH_RESULT_LIST );
		MobileElement productContainter = findElement( MobileNamesConstants.SEARCH_RESULT_LIST );
		List<MobileElement> products = findSubElements(productContainter, MobileNamesConstants.SEARCH_RESULT_ELEMENT);
		Assert.assertTrue( products.size() > 0 );
	}
	
	public void validateInvalidSearch() {
		waitVisibility( MobileNamesConstants.SEARCH_WITHOUT_RESULT );
		generalBusinessTest.validateElement( MobileNamesConstants.SEARCH_WITHOUT_RESULT_HEADER );
		generalBusinessTest.validateElement( MobileNamesConstants.SEARCH_WITHOUT_RESULT_ICON );
		generalBusinessTest.validateElement( MobileNamesConstants.SEARCH_WITHOUT_RESULT_BOTTOM );		
	}
	
	public void scanProduct() {
		waitVisibility( MobileNamesConstants.HOME_OFFERS_FILTER );
		tapOnElement( MobileNamesConstants.HOME_SCAN );
	}
	
	public void validateScanPage() {
		if( elementExist( MobileNamesConstants.ANDROID_DIALOG_CONT ) ) {
			tapOnElement( MobileNamesConstants.ANDROID_NATIVE_ALLOW );
		}
		waitVisibility( MobileNamesConstants.SCAN_CONTAINER );
		generalBusinessTest.validateElement( MobileNamesConstants.SCAN_TITLE );
		generalBusinessTest.validateElement( MobileNamesConstants.SCAN_MESSAGE );
		generalBusinessTest.validateElement( MobileNamesConstants.SCAN_BOX );
	}
	
	public void selectCar() {
		waitVisibility( MobileNamesConstants.HOME_OFFERS_FILTER );
		tapOnElement( MobileNamesConstants.HOME_CAR );
	}
	
	public void validateEmptyCar() {
		waitVisibility( MobileNamesConstants.HOME_EMPTY_CAR );
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_EMPTY_CAR_ICON );
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_EMPTY_CAR_BUTTON );
	}
	
	public void validateStartingBuy() {
		waitVisibility( MobileNamesConstants.HOME_EMPTY_CAR );
		tapOnElement( MobileNamesConstants.HOME_EMPTY_CAR_BUTTON );
		validateElements();
	}
	
	public void selectProduct( ) {
		waitVisibility( MobileNamesConstants.HOME_OFFERS_FILTER );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , MobileNamesConstants.HOME_PRODUCT_LIST);
		List<MobileElement> products = findElements( MobileNamesConstants.HOME_PRODUCT_CONTAINER );
		products.get(0).click();
	}
	
	public void validateProduct() {
		waitVisibility( MobileNamesConstants.PRODUCT_CONTAINER );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_TITLE );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, MobileNamesConstants.PRODUCT_IMAGE );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_IMAGE );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, MobileNamesConstants.PRODUCT_DESC );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_PRICE );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_SELL_BY );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_UPC );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_ADD );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_PROMO );
		generalBusinessTest.validateElement( MobileNamesConstants.PRODUCT_DESC );
	}
	
	public void addProduct() {
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_DOWN, MobileNamesConstants.PRODUCT_TITLE );
		tapOnElement( MobileNamesConstants.PRODUCT_ADD );
		waitVisibility( MobileNamesConstants.WARNING_MESSAGE );
	}
	
	public void validateCar( int numProducts ) {
		waitVisibility( MobileNamesConstants.CAR_CONTAINER );
		MobileElement productContainer = findElement( MobileNamesConstants.CAR_CONTAINER );
		List<MobileElement> products = findSubElements( productContainer, MobileNamesConstants.CAR_ITEM );
		waitVisibility( MobileNamesConstants.CAR_BUY_BUTTON );
		Assert.assertEquals(numProducts, products.size());
	}
	
	public void goBack() {
		generalBusinessTest.goBack();
	}
	
	public void deleteProduct() {
		MobileElement productContainer = findElement( MobileNamesConstants.CAR_CONTAINER );
		List<MobileElement> products = findSubElements( productContainer, MobileNamesConstants.CAR_DELETE_ITEM );
		products.get(0).click();
		MobileElement deleteDialog = findElement( MobileNamesConstants.CAR_DELETE_DIALOG );
		findSubElements( deleteDialog, MobileNamesConstants.CAR_CONFIRM_BUTTON ).get(0).click();
		waitVisibility( MobileNamesConstants.WARNING_MESSAGE );
		validateEmptyCar();
	}
	
	public void validateBuy() {
		generalBusinessTest.findElement( MobileNamesConstants.CAR_BUY_BUTTON );
		tapOnElement( MobileNamesConstants.CAR_BUY_BUTTON );
		waitVisibility( MobileNamesConstants.LOGIN_BUTTON );
	}

}
