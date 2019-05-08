package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class AccountBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger( AccountBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE );
	}
	
	public void selectCreateAccount() {
		generalBusinessTest.selectMenuOption( ProfileMenuEnum.CREATE_PROFILE );
	}
	
	@Step("Validate account page")
	public void validateElements() {
		logger.info("Validando elementos");
		waitElementVisibility( NamesMobileElements.ACCOUNT_NAME_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_LASTNAME_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_EMAIL_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_PASS_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_SHOW_PASS );
		waitElementVisibility( NamesMobileElements.ACCOUNT_TERMS_LINK );
		waitElementVisibility( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		waitElementVisibility( NamesMobileElements.ACCOUNT_LOGIN_LINK );
	}
	
	@Step("Create account with {name}, {lastname}, {email}, {pass}")
	public void createAccount( String name, String lastname, String email, String pass ) {
		logger.info("Creando cuenta");
		fillElement( NamesMobileElements.ACCOUNT_NAME_TEXT, name);
		fillElement( NamesMobileElements.ACCOUNT_LASTNAME_TEXT, lastname);
		fillElement( NamesMobileElements.ACCOUNT_EMAIL_TEXT, email);
		scrollUntilShowElement( GeneralConstants.SCROLL_UP, NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		fillElement( NamesMobileElements.ACCOUNT_PASS_TEXT, pass);
		tapOnElement( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
	}
	
	@Step("Validate empty fields")
	public void validateEmptyFields() {
		logger.info("Validando datos vacios");
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_LASTNAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_EMAIL_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_PASS_CONT);
	}
	
	@Step("Validate invalid fields")
	public void validateInvalidData() {
		logger.info("Validando datos invalidos");
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_NAME, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_LAST_NAME, NamesMobileElements.ACCOUNT_LASTNAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_EMAIL, NamesMobileElements.ACCOUNT_EMAIL_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_PASS, NamesMobileElements.ACCOUNT_PASS_CONT); 
	}
	
	@Step("Validate exist email")
	public void validateExistEmail() {
		logger.info("Validando email existente");
		generalBusinessTest.validatePopUpMessages( AppMessages.ACCOUNT_EXIST_EMAIL ); 
	}
	
	@Step("Validate account created")
	public void validateCreateAccount() {
		generalBusinessTest.validatePopUpMessages( AppMessages.CREATE_ACCOUNT_SUCCESS );
		selectProfileOption();
		generalBusinessTest.selectMenuOption( ProfileMenuEnum.PROFILE );
	}
	
	@Step("Show password")
	public void showPassword( String password ) {
		fillElement( NamesMobileElements.ACCOUNT_PASS_TEXT, password);
		tapOnElement( NamesMobileElements.LOGIN_SHOW_PASS );
		Assert.assertEquals( Boolean.FALSE.toString(), findElement(NamesMobileElements.ACCOUNT_PASS_TEXT).getAttribute("password") );
	}
	
	@Step("Tap on terms link")
	public void tapTermsLink( ) {
		tapOnElement( NamesMobileElements.ACCOUNT_TERMS_LINK );
	}
	
	@Step("Validate terms")
	public void validateTerms(int elementNum) {
		MobileElement menuTerm = findElement( NamesMobileElements.LIST_TERMS );
		List<MobileElement> terms = findSubElements( menuTerm, NamesMobileElements.LIST_TERM_ELEMENT );
		Assert.assertEquals(elementNum, terms.size());
		for( MobileElement element : terms) {
			element.click();
			tapOnElement( NamesMobileElements.BACK_BUTTON );
		}
	}
	
	@Step("Tap on login link")
	public void tapLoginLink( ) {
		tapOnElement( NamesMobileElements.ACCOUNT_LOGIN_LINK );
	}
	
	@Step("Validate login success")
	public void validateLogin( ) {
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
	}
	
	public String randomMail() {
		String email = generalBusinessTest.randomString(10, true, true);
		return email + "@correo.com";
	}
	
}
