package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.commons.GeneralConstants;
import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

public class ProfileBusinessTest extends BaseDriver {
	
	public static final Logger logger = Logger.getLogger(ProfileBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
	}
	
	public void selectHelpMenu() {
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.SUPPORT.getMenu() );
	}
	
	public void validatePage() {
		generalBusinessTest.validateElement( MobileNamesConstants.HELP_TITLE );
		generalBusinessTest.validateElement( MobileNamesConstants.HELP_ICON );
		generalBusinessTest.scrollUntilShowElement(GeneralConstants.SCROLL_UP, MobileNamesConstants.HELP_EMAIL_BUTTON);
		generalBusinessTest.validateElement( MobileNamesConstants.HELP_PHONE );
		generalBusinessTest.validateElement( MobileNamesConstants.HELP_EMAIL_BUTTON );
		generalBusinessTest.validateElement( MobileNamesConstants.HELP_CALL_BUTTON );
		tapOnElement( MobileNamesConstants.HELP_CALL_BUTTON );		
	}
	
	
	
}
