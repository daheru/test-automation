package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class HomeBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(HomeBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectHomeOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.HOME.getNavigation() );
	}
	
	public void validateElements() {
		generalBusinessTest.validateElement( NamesMobileElements.HOME_CAR );
		waitVisibility( NamesMobileElements.HOME_OFFERS_FILTER );
		generalBusinessTest.validateElement( NamesMobileElements.HOME_OFFERS_FILTER );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.HOME_PRODUCT_LIST);
		generalBusinessTest.validateElement( NamesMobileElements.HOME_PRODUCT_LIST );
		generalBusinessTest.validateElement( NamesMobileElements.HOME_SCAN );
		generalBusinessTest.validateElement( NamesMobileElements.HOME_SEARCH_BUTTON );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_DEPARTMENTS );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_HOME );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_PROFILE );
	}
	
	public void searchProduct(String product) {
		waitVisibility( NamesMobileElements.HOME_OFFERS_FILTER );
		tapOnElement( NamesMobileElements.HOME_SEARCH_BUTTON );
		fillElement( NamesMobileElements.HOME_SEARCH_FIELD, product + "\\n");
	}
	
	public void validateSearch() {
		waitVisibility( NamesMobileElements.SEARCH_RESULT_LIST );
		MobileElement productContainter = findElement( NamesMobileElements.SEARCH_RESULT_LIST );
		List<MobileElement> products = findSubElements(productContainter, NamesMobileElements.SEARCH_RESULT_ELEMENT);
		Assert.assertTrue( products.size() > 0 );
	}
	
	public void validateInvalidSearch() {
		waitVisibility( NamesMobileElements.SEARCH_WITHOUT_RESULT );
		generalBusinessTest.validateElement( NamesMobileElements.SEARCH_WITHOUT_RESULT_HEADER );
		generalBusinessTest.validateElement( NamesMobileElements.SEARCH_WITHOUT_RESULT_ICON );
		generalBusinessTest.validateElement( NamesMobileElements.SEARCH_WITHOUT_RESULT_BOTTOM );		
	}
	
	public void scanProduct() {
		waitVisibility( NamesMobileElements.HOME_OFFERS_FILTER );
		tapOnElement( NamesMobileElements.HOME_SCAN );
	}
	
	public void validateScanPage() {
		if( elementExist( NamesMobileElements.ANDROID_DIALOG_CONT ) ) {
			tapOnElement( NamesMobileElements.ANDROID_NATIVE_ALLOW );
		}
		waitVisibility( NamesMobileElements.SCAN_CONTAINER );
		generalBusinessTest.validateElement( NamesMobileElements.SCAN_TITLE );
		generalBusinessTest.validateElement( NamesMobileElements.SCAN_MESSAGE );
		generalBusinessTest.validateElement( NamesMobileElements.SCAN_BOX );
	}
	
	public void selectCar() {
		waitVisibility( NamesMobileElements.HOME_OFFERS_FILTER );
		tapOnElement( NamesMobileElements.HOME_CAR );
	}
	
	public void validateEmptyCar() {
		waitVisibility( NamesMobileElements.HOME_EMPTY_CAR );
		generalBusinessTest.validateElement( NamesMobileElements.HOME_EMPTY_CAR_ICON );
		generalBusinessTest.validateElement( NamesMobileElements.HOME_EMPTY_CAR_BUTTON );
	}
	
	public void validateStartingBuy() {
		waitVisibility( NamesMobileElements.HOME_EMPTY_CAR );
		tapOnElement( NamesMobileElements.HOME_EMPTY_CAR_BUTTON );
		validateElements();
	}
	
	public void selectProduct( ) {
		waitVisibility( NamesMobileElements.HOME_OFFERS_FILTER );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.HOME_PRODUCT_LIST);
		List<MobileElement> products = findElements( NamesMobileElements.HOME_PRODUCT_CONTAINER );
		tapOnElement( products.get(0) );
	}
	
	public void validateProduct() {
		waitVisibility( NamesMobileElements.PRODUCT_CONTAINER );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_TITLE );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_IMAGE );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_IMAGE );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DESC );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_PRICE );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_SELL_BY );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_UPC );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_ADD );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_PROMO );
		generalBusinessTest.validateElement( NamesMobileElements.PRODUCT_DESC );
	}
	
	public void addProduct() {
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_DOWN, NamesMobileElements.PRODUCT_TITLE );
		tapOnElement( NamesMobileElements.PRODUCT_ADD );
		validatePopUpMessages( AppMessages.ADD_PRODUCT );
	}
	
	public void validatePopUpMessages( String message ) {
		generalBusinessTest.validatePopUpMessages( message );
	}
	
	public void validateCar( int numProducts ) {
		selectCar();
		waitVisibility( NamesMobileElements.CAR_CONTAINER );
		MobileElement productContainer = findElement( NamesMobileElements.CAR_CONTAINER );
		List<MobileElement> products = findSubElements( productContainer, NamesMobileElements.CAR_ITEM );
		waitVisibility( NamesMobileElements.CAR_BUY_BUTTON );
		Assert.assertEquals(numProducts, products.size());
	}
	
	public void goBack() {
		generalBusinessTest.goBack();
	}
	
	public void deleteProduct() {
		MobileElement productContainer = findElement( NamesMobileElements.CAR_CONTAINER );
		List<MobileElement> products = findSubElements( productContainer, NamesMobileElements.CAR_DELETE_ITEM );
		products.get(0).click();
		MobileElement deleteDialog = findElement( NamesMobileElements.CAR_DELETE_DIALOG );
		findSubElements( deleteDialog, NamesMobileElements.CAR_CONFIRM_BUTTON ).get(0).click();
		validatePopUpMessages( AppMessages.DELETE_PRODUCT );
	}
	
	public void validateBuy() {
		generalBusinessTest.findElement( NamesMobileElements.CAR_BUY_BUTTON );
		tapOnElement( NamesMobileElements.CAR_BUY_BUTTON );
		waitVisibility( NamesMobileElements.LOGIN_BUTTON );
	}

}
