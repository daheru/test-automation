package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.commons.GeneralConstants;
import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class AccountBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger( AccountBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
	}
	
	public void selectCreateAccount() {
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.CREATE_PROFILE.getMenu() );
	}
	
	public void validateElements() {
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_NAME_TEXTBOX );
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_LASTNAME_TEXTBOX );
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_EMAIL_TEXTBOX );
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX );
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_SHOW_PASS );
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_TERMS_LINK );
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		generalBusinessTest.validateElement( MobileNamesConstants.ACCOUNT_LOGIN_LINK );
	}
	
	public void createAccount( String name, String lastname, String email, String pass ) {
		if( !name.isEmpty() ) {
			fillElement( MobileNamesConstants.ACCOUNT_NAME_TEXTBOX, name);
		}
		if( !lastname.isEmpty() ) {
			fillElement( MobileNamesConstants.ACCOUNT_LASTNAME_TEXTBOX, lastname);
		}
		if( !email.isEmpty() ) {
			fillElement( MobileNamesConstants.ACCOUNT_EMAIL_TEXTBOX, email);
		}
		if( !pass.isEmpty() ) {
			fillElement( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX, pass);
		}
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		tapOnElement( MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
	}
	
	public void validateErrorMessages( String name, String lastname, String email, String pass ) {
		if( name.isEmpty() ) {
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.ACCOUNT_NAME_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		}
		if( lastname.isEmpty() ) {
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.ACCOUNT_LASTNAME_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		}
		if( email.isEmpty() ) {
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.ACCOUNT_EMAIL_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		}
		if( pass.isEmpty() ) {
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		} 
	}
	
	public void showPassword( String password ) {
		fillElement( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX, password);
		tapOnElement( MobileNamesConstants.SHOW_PASS );
		Assert.assertEquals( Boolean.FALSE.toString(), findElement(MobileNamesConstants.ACCOUNT_PASS_TEXTBOX).getAttribute("password") );
	}
	
	public void tapTermsLink( ) {
		tapOnElement( MobileNamesConstants.ACCOUNT_TERMS_LINK );
	}
	
	public void validateTerms(int elementNum) {
		MobileElement menuTerm = findElement( MobileNamesConstants.LIST_TERMS );
		List<MobileElement> terms = findSubElements( menuTerm, MobileNamesConstants.LIST_TERM_ELEMENT );
		Assert.assertEquals(elementNum, terms.size());
		for( MobileElement element : terms) {
			element.click();
			tapOnElement( MobileNamesConstants.BACK_BUTTON );
		}
	}
	
	public void tapLoginLink( ) {
		tapOnElement( MobileNamesConstants.ACCOUNT_LOGIN_LINK );
	}
	
	public void validateLogin( ) {
		MobileElement loginButton = findElement( MobileNamesConstants.LOGIN_BUTTON );
		Assert.assertNotNull( loginButton );
	}
	
}
