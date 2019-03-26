package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenuOptionsEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.TermsEnum;
import com.walmartmg.util.BaseDriver;

public class ProfileBusinessTest extends BaseDriver {
	
	public static final Logger logger = Logger.getLogger(ProfileBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
	}
	
	public void selectMenu( String menu ) {
		generalBusinessTest.selectMenuOption( menu );
	}
	
	public void validateHelpPage() {
		generalBusinessTest.validateElement( NamesMobileElements.HELP_TITLE );
		generalBusinessTest.validateElement( NamesMobileElements.HELP_ICON );
		generalBusinessTest.scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.HELP_EMAIL_BUTTON);
		generalBusinessTest.validateElement( NamesMobileElements.HELP_PHONE );
		generalBusinessTest.validateElement( NamesMobileElements.HELP_EMAIL_BUTTON );
		generalBusinessTest.validateElement( NamesMobileElements.HELP_CALL_BUTTON );	
	}
	
	public void validateCallUs() {
		waitVisibility( NamesMobileElements.HELP_CALL_BUTTON );
		tapOnElement( NamesMobileElements.HELP_CALL_BUTTON );
	}

	public void validateWriteUs() {
		waitVisibility( NamesMobileElements.HELP_EMAIL_BUTTON );
		tapOnElement( NamesMobileElements.HELP_EMAIL_BUTTON );
	}
	
	public void validateMenu(boolean isLogged) {
		if( isLogged ) {
			
		} else {
			generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption( MenuOptionsEnum.CREATE_PROFILE.getMenu() );
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption( MenuOptionsEnum.GET_BILL.getMenu() );
			closeAndroidDialog();
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption( MenuOptionsEnum.SUPPORT.getMenu() );
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption( MenuOptionsEnum.TERMS.getMenu() );
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption( MenuOptionsEnum.LEGALS.getMenu() );
			generalBusinessTest.goBack();
		}
	}
	
	public void validateTermsPage() {
		generalBusinessTest.selectTermsOption( TermsEnum.RETURNS );
		generalBusinessTest.selectTermsOption( TermsEnum.DELIVERY );
		generalBusinessTest.selectTermsOption( TermsEnum.PAYMENTS );
		generalBusinessTest.selectTermsOption( TermsEnum.ORDERS );
		generalBusinessTest.selectTermsOption( TermsEnum.ACCOUNT );
		generalBusinessTest.selectTermsOption( TermsEnum.FAQ );
		generalBusinessTest.selectTermsOption( TermsEnum.SECURITY );
		generalBusinessTest.selectTermsOption( TermsEnum.MARKETPLACE );
		generalBusinessTest.selectTermsOption( TermsEnum.BILLING );
		generalBusinessTest.selectTermsOption( TermsEnum.PROMOTIONS );
	}
	
}
