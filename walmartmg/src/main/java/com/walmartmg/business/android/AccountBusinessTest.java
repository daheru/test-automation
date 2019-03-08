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
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_NAME_TEXTBOX );
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_LASTNAME_TEXTBOX );
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_EMAIL_TEXTBOX );
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX );
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_SHOW_PASS );
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_TERMS_LINK );
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		generalBusinessTest.validateElements( MobileNamesConstants.ACCOUNT_LOGIN_LINK );
	}
	
	public void createAccount( String name, String lastname, String email, String pass ) {
		MobileElement inputElement = null;
		if( !name.isEmpty() ) {
			inputElement = findElement( MobileNamesConstants.ACCOUNT_NAME_TEXTBOX );
			inputElement.sendKeys(name);
		}
		if( !lastname.isEmpty() ) {
			inputElement = findElement( MobileNamesConstants.ACCOUNT_LASTNAME_TEXTBOX );
			inputElement.sendKeys(lastname);
		}
		if( !email.isEmpty() ) {
			inputElement = findElement( MobileNamesConstants.ACCOUNT_EMAIL_TEXTBOX );
			inputElement.sendKeys(email);
		}
		if( !pass.isEmpty() ) {
			inputElement = findElement( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX );
			inputElement.sendKeys(pass);
		}
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		findElement( MobileNamesConstants.ACCOUNT_CREATE_BUTTON ).click();
	}
	
	public void validateErrorMessages( String name, String lastname, String email, String pass ) {
		if( name.isEmpty() ) {
			generalBusinessTest.validateMessages( MobileNamesConstants.ACCOUNT_NAME_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		}
		if( lastname.isEmpty() ) {
			generalBusinessTest.validateMessages( MobileNamesConstants.ACCOUNT_LASTNAME_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		}
		if( email.isEmpty() ) {
			generalBusinessTest.validateMessages( MobileNamesConstants.ACCOUNT_EMAIL_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		}
		if( pass.isEmpty() ) {
			generalBusinessTest.validateMessages( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX, MobileNamesConstants.ERROR_TEXT_FIELD );
		} 
	}
	
	public void showPassword( String password ) {
		MobileElement passField = findElement( MobileNamesConstants.ACCOUNT_PASS_TEXTBOX );
		passField.sendKeys(password);
		findElement( MobileNamesConstants.SHOW_PASS ).click();
		Assert.assertEquals( Boolean.FALSE.toString(), passField.getAttribute("password") );
	}
	
	public void tapTermsLink( ) {
		findElement( MobileNamesConstants.ACCOUNT_TERMS_LINK ).click();
	}
	
	public void validateTerms(int elementNum) {
		MobileElement menuTerm = findElement( MobileNamesConstants.LIST_TERMS );
		List<MobileElement> terms = findSubElements( menuTerm, MobileNamesConstants.LIST_TERM_ELEMENT );
		Assert.assertEquals(elementNum, terms.size());
		for( MobileElement element : terms) {
			element.click();
			findElementByXpath( MobileNamesConstants.BACK_BUTTON ).click();
		}
	}
	
	public void tapLoginLink( ) {
		findElement( MobileNamesConstants.ACCOUNT_LOGIN_LINK ).click();
	}
	
	public void validateLogin( ) {
		MobileElement loginButton = findElement( MobileNamesConstants.LOGIN_BUTTON );
		Assert.assertNotNull( loginButton );
	}
	
}
