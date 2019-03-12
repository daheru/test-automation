package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.commons.MenuOptionsEnum;
import com.bodega.commons.MobileNamesConstants;
import com.bodega.commons.NavigationBarEnum;
import com.bodega.util.BaseDriver;

public class WelcomeBusinessTest extends BaseDriver {
	
	public static final Logger logger = Logger.getLogger( WelcomeBusinessTest.class );
	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	public void initGuess() {
		findElement( MobileNamesConstants.WELCOME_LINK_GUESS ).click();
	}
	
	public void validateHome() {
		waitVisibility( MobileNamesConstants.HOME_ITEM_BANNER );
		waitVisibility( MobileNamesConstants.HOME_CARROUSEL );
		general.validateElement( MobileNamesConstants.HOME_SEARCH_BAR );
		general.validateElement( MobileNamesConstants.HOME_PROFILE );
		general.validateElement( MobileNamesConstants.NAV_BAR );
		general.validateElement( MobileNamesConstants.NAV_BAR_HOME );
		general.validateElement( MobileNamesConstants.NAV_BAR_DEPARTMENTS );
		general.validateElement( MobileNamesConstants.NAV_BAR_PROMOTIONS );
		general.validateElement( MobileNamesConstants.NAV_BAR_CAR );
		general.validateElement( MobileNamesConstants.HOME_ITEM_BANNER );
		general.validateElement( MobileNamesConstants.HOME_CARROUSEL );
	}

	public void selectMenus() {
		general.selectNavigationOption( NavigationBarEnum.HOME.getNavigation() );
		general.selectNavigationOption( NavigationBarEnum.DEPARTMENTS.getNavigation() );
		general.selectNavigationOption( NavigationBarEnum.PROMOTIONS.getNavigation() );
		general.selectNavigationOption( NavigationBarEnum.CAR.getNavigation() );
		general.goBack();
	}
	
	public void selectProfile() {
		findElement( MobileNamesConstants.HOME_PROFILE ).click();
	}
	
	public void validateMenu() {
		waitVisibility( MobileNamesConstants.HOME_ITEM_BANNER );
		waitVisibility( MobileNamesConstants.HOME_CARROUSEL );
		general.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		general.goBack();
		general.selectMenuOption( MenuOptionsEnum.CREATE_PROFILE.getMenu() );
		general.goBack();
		general.selectMenuOption( MenuOptionsEnum.GET_BILL.getMenu() );
		general.goBack();
		general.selectMenuOption( MenuOptionsEnum.SUPPORT.getMenu() );
		general.goBack();
		general.selectMenuOption( MenuOptionsEnum.TERMS.getMenu() );
		general.goBack();
		general.selectMenuOption( MenuOptionsEnum.LEGALS.getMenu() );
		general.goBack();
	}
}
