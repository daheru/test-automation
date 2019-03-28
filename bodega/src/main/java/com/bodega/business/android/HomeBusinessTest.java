package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.util.BaseDriver;

public class HomeBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger( HomeBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void initAsGuess() {
		generalBusinessTest.initAsGuess();
	}
	
	public void selectHomeOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.HOME.getNavigation() );
	}
	
	public void validateHomePage() {
		logger.info("Validando Home Page");
		generalBusinessTest.validateElement( NamesMobileElements.HOME_SEARCH_BAR );
		waitElementVisibility( NamesMobileElements.HOME_ITEM_BANNER );
		waitElementVisibility( NamesMobileElements.HOME_CARROUSEL );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_HOME );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_DEPARTMENTS );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_PROMOTIONS );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_CAR );
		generalBusinessTest.validateElement( NamesMobileElements.NAV_BAR_CAR_QUANTITY );
		generalBusinessTest.validateElement( NamesMobileElements.HOME_ITEM_BANNER );
		generalBusinessTest.validateElement( NamesMobileElements.HOME_CARROUSEL );
	}
	
	
}
