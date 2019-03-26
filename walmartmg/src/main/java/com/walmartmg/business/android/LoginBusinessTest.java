package com.walmartmg.business.android;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.enums.MenuOptionsEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(ProfileBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();

	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
	}

	public void selectMenu(String menu) {
		generalBusinessTest.selectMenuOption(menu);
	}

	public void validateLoginPage() {
		waitVisibility(NamesMobileElements.LOGIN_BUTTON);
		generalBusinessTest.validateElement(NamesMobileElements.LOGIN_BUTTON);
		generalBusinessTest.validateElement(NamesMobileElements.LOGIN_EMAIL);
		generalBusinessTest.validateElement(NamesMobileElements.LOGIN_FORGOT_PASS);
		generalBusinessTest.validateElement(NamesMobileElements.LOGIN_PASS);
	}

	public void login(String email, String password) {
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		fillElement(NamesMobileElements.LOGIN_PASS, password);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
		validateLoginErrors(email, password);
	}
	
	public void validatePopUpMessages( String message ) {
		generalBusinessTest.validatePopUpMessages( message );
	}
	
	public void validateLogin( String email ) {
		logger.info("Validando Login");
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		MobileElement userEmail = findElement( NamesMobileElements.USER_EMAIL );
		Assert.assertEquals(email, userEmail.getAttribute( ConfigConstants.ATTRIBUTE_TEXT ));
	}
	
	private void validateLoginErrors( String email, String password ) {
		logger.info("Verificando mensajes de validacion");
		if( email.isEmpty() ){
			generalBusinessTest.validateFieldErrorMessage(AppMessages.NO_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT);
		} else if( password.isEmpty() ){
			generalBusinessTest.validateFieldErrorMessage(AppMessages.NO_PASS, NamesMobileElements.LOGIN_PASS_CONT);
		}
	}
	
	public void showPassword( String password ) {
		MobileElement passField = findElement( NamesMobileElements.LOGIN_PASS );
		logger.info("Ingresando password");
		passField.sendKeys(password);
		tapOnElement( NamesMobileElements.LOGIN_SHOW_PASS );
		Assert.assertEquals( Boolean.FALSE.toString(), passField.getAttribute("password") );
	}
	
	public void forgotPassWithoutEmail(  ) {
		tapOnElement( NamesMobileElements.LOGIN_FORGOT_PASS );
		generalBusinessTest.validateFieldErrorMessage( AppMessages.NO_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT );
	}
	
	public void forgotPass( String email ) {
		logger.info("Ingresando email");
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		tapOnElement( NamesMobileElements.LOGIN_FORGOT_PASS );
	}
	
	public void createAccount(  ) {
		tapOnElement( NamesMobileElements.LOGIN_REGISTER_BUTTON );
		waitVisibility( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		MobileElement createButton = findElement( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		Assert.assertNotNull( createButton );
	}
}
