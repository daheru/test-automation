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
		generalBusinessTest.validateElements( MobileNamesConstants.HOME_CAR );
		waitVisibility( MobileNamesConstants.HOME_OFFERS_FILTER );
		generalBusinessTest.validateElements( MobileNamesConstants.HOME_OFFERS_FILTER );
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , MobileNamesConstants.HOME_PRODUCT_LIST);
		generalBusinessTest.validateElements( MobileNamesConstants.HOME_PRODUCT_LIST );
		generalBusinessTest.validateElements( MobileNamesConstants.HOME_SCAN );
		generalBusinessTest.validateElements( MobileNamesConstants.HOME_SEARCH_BUTTON );
		generalBusinessTest.validateElements( MobileNamesConstants.NAV_BAR_DEPARTMENTS );
		generalBusinessTest.validateElements( MobileNamesConstants.NAV_BAR_HOME );
		generalBusinessTest.validateElements( MobileNamesConstants.NAV_BAR_PROFILE );
	}
	
	public void searchProduct(String product) {
		waitVisibility( MobileNamesConstants.HOME_OFFERS_FILTER );
		findElement( MobileNamesConstants.HOME_SEARCH_BUTTON ).click();
		findElement( MobileNamesConstants.HOME_SEARCH_FIELD ).sendKeys( product + "\n" );
	}
	
	public void validateSearch() {
		waitVisibility( MobileNamesConstants.SEARCH_RESULT_LIST );
		MobileElement productContainter = findElement( MobileNamesConstants.SEARCH_RESULT_LIST );
		List<MobileElement> products = findSubElements(productContainter, MobileNamesConstants.SEARCH_RESULT_ELEMENT);
		Assert.assertTrue( products.size() > 0 );
	}
	
	public void validateInvalidSearch() {
		waitVisibility( MobileNamesConstants.SEARCH_WITHOUT_RESULT );
		generalBusinessTest.validateElements( MobileNamesConstants.SEARCH_WITHOUT_RESULT_HEADER );
		generalBusinessTest.validateElements( MobileNamesConstants.SEARCH_WITHOUT_RESULT_ICON );
		generalBusinessTest.validateElements( MobileNamesConstants.SEARCH_WITHOUT_RESULT_BOTTOM );		
	}
	
	public void scanProduct() {
		findElement( MobileNamesConstants.HOME_SCAN ).click();
	}
	
	public void validateScanPage() {
		if( elementExist( MobileNamesConstants.ANDROID_DIALOG_CONT ) ) {
			findElement( MobileNamesConstants.ANDROID_NATIVE_ALLOW ).click();	
		}
		waitVisibility( MobileNamesConstants.SCAN_CONTAINER );
		generalBusinessTest.validateElements( MobileNamesConstants.SCAN_TITLE );
		generalBusinessTest.validateElements( MobileNamesConstants.SCAN_MESSAGE );
		generalBusinessTest.validateElements( MobileNamesConstants.SCAN_BOX );
	}

}
