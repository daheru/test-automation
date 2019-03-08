package com.walmartmg.business;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class.getName());
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void login(String email, String password){
		goLogin();
		if( !email.isEmpty() ) {
			MobileElement emailField = findElement( MobileNamesConstants.LOGIN_EMAIL );
			logger.info("Ingresando email");
			emailField.sendKeys(email);
		}
		if( !password.isEmpty() ) {
			MobileElement passField = findElement( MobileNamesConstants.LOGIN_PASS );
			logger.info("Ingresando password");
			passField.sendKeys(password);
		}
		MobileElement loginBtn = findElement( MobileNamesConstants.LOGIN_BUTTON );
		logger.info("Tap en iniciar sesion");
		loginBtn.click();
	}
	
	public void validateLogin( String email ) {
		logger.info("Validando Login");
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		MobileElement userEmail = findElement( MobileNamesConstants.USER_EMAIL );
		Assert.assertEquals(email, userEmail.getAttribute("text"));
	}
	
	public void validateErrorMessages( String email, String password ) {
		logger.info("Verificando mensajes de validacion");
		if( email.isEmpty() && password.isEmpty() ){
			generalBusinessTest.validateMessages( MobileNamesConstants.NAME_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
			generalBusinessTest.validateMessages( MobileNamesConstants.PASS_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
		} else if( !email.isEmpty() && password.isEmpty() ){
			generalBusinessTest.validateMessages( MobileNamesConstants.PASS_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
		} else if( email.isEmpty() && !password.isEmpty() ){
			generalBusinessTest.validateMessages( MobileNamesConstants.NAME_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
		} else {
			validateWarningMessage();
		}
	}
	
	public void logout( ) {
		logger.info("Tap en cerrar sesion");
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGOUT.getMenu() );
	}
	
	public void validateLogout( ) {
		logger.info("Validando Login");
		findElement( MobileNamesConstants.CAR ).click();
		findElementByXpath( MobileNamesConstants.BACK_BUTTON ).click();
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		MobileElement loginButton = findElement( MobileNamesConstants.LOGIN_BUTTON );
		Assert.assertNotNull( loginButton );
	}

	public void showPassword( String password ) {
		goLogin();
		MobileElement passField = findElement( MobileNamesConstants.LOGIN_PASS );
		logger.info("Ingresando password");
		passField.sendKeys(password);
		findElement( MobileNamesConstants.SHOW_PASS ).click();
		Assert.assertEquals( Boolean.FALSE.toString(), passField.getAttribute("password") );
	}
	
	public void forgotPass_Without_Email(  ) {
		goLogin();
		findElement( MobileNamesConstants.FORGOT_PASS ).click();
		generalBusinessTest.validateMessages( MobileNamesConstants.NAME_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
	}
	
	public void forgotPass( String email ) {
		goLogin();
		MobileElement emailField = findElement( MobileNamesConstants.LOGIN_EMAIL );
		logger.info("Ingresando email");
		emailField.sendKeys(email);
		findElement( MobileNamesConstants.FORGOT_PASS ).click();
		validateWarningMessage();
	}
	
	public void createAccount(  ) {
		goLogin();
		findElement( MobileNamesConstants.REGISTER_BUTTON ).click();
		waitVisibility( MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		MobileElement createButton = findElement( MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		Assert.assertNotNull( createButton );
	}
	
	private void goLogin() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
	}
	
	private void validateWarningMessage( ) {
		waitVisibility( MobileNamesConstants.WARNING_MESSAGE );
		MobileElement messageError = findElement( MobileNamesConstants.WARNING_MESSAGE );
		Assert.assertNotNull( messageError );
	}
	
}
