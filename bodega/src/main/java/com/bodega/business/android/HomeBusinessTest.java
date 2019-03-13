package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.commons.MobileNamesConstants;
import com.bodega.commons.NavigationBarEnum;
import com.bodega.util.BaseDriver;

public class HomeBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger( HomeBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectHomeOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.HOME.getNavigation() );
	}
	
	public void validateElements() {
		generalBusinessTest.validateElement( MobileNamesConstants.HOME_SEARCH_BAR );
		waitVisibility( MobileNamesConstants.HOME_ITEM_BANNER );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_HOME );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_DEPARTMENTS );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_PROMOTIONS );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_CAR );
		generalBusinessTest.validateElement( MobileNamesConstants.NAV_BAR_CAR_QUANTITY );
	}
	
	
}
