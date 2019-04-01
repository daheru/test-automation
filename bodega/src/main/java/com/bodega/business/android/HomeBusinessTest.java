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
		waitElementVisibility( NamesMobileElements.HOME_SEARCH_BAR );
		waitElementVisibility( NamesMobileElements.HOME_ITEM_BANNER );
		waitElementVisibility( NamesMobileElements.HOME_CARROUSEL );
		waitElementVisibility( NamesMobileElements.NAV_BAR );
		waitElementVisibility( NamesMobileElements.NAV_BAR_HOME );
		waitElementVisibility( NamesMobileElements.NAV_BAR_DEPARTMENTS );
		waitElementVisibility( NamesMobileElements.NAV_BAR_PROMOTIONS );
		waitElementVisibility( NamesMobileElements.NAV_BAR_CAR );
		waitElementVisibility( NamesMobileElements.NAV_BAR_CAR_QUANTITY );
		waitElementVisibility( NamesMobileElements.HOME_ITEM_BANNER );
		waitElementVisibility( NamesMobileElements.HOME_CARROUSEL );
		logger.info("Validando Home Page");
	}
}
