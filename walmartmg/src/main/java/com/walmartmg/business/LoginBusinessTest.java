package com.walmartmg.business;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MovileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class.getName());
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void login(String email, String password){
		goLogin();
		if( !email.isEmpty() ) {
			MobileElement emailField = findElement( MovileNamesConstants.LOGIN_EMAIL );
			logger.info("Ingresando email");
			emailField.sendKeys(email);
		}
		if( !password.isEmpty() ) {
			MobileElement passField = findElement( MovileNamesConstants.LOGIN_PASS );
			logger.info("Ingresando password");
			passField.sendKeys(password);
		}
		MobileElement loginBtn = findElement( MovileNamesConstants.LOGIN_BUTTON );
		logger.info("Tap en iniciar sesion");
		loginBtn.click();
	}
	
	public void validateLogin( String email ) {
		logger.info("Validando Login");
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		MobileElement userEmail = findElement( MovileNamesConstants.USER_EMAIL );
		Assert.assertEquals(email, userEmail.getAttribute("text"));
	}
	
	public void validateErrorMessages( String email, String password ) {
		logger.info("Verificando mensajes de validacion");
		if( email.isEmpty() && password.isEmpty() ){
			generalBusinessTest.validateMessages( MovileNamesConstants.NAME_FIELD, MovileNamesConstants.ERROR_TEXT_FIELD );
			generalBusinessTest.validateMessages( MovileNamesConstants.PASS_FIELD, MovileNamesConstants.ERROR_TEXT_FIELD );
		} else if( !email.isEmpty() && password.isEmpty() ){
			generalBusinessTest.validateMessages( MovileNamesConstants.PASS_FIELD, MovileNamesConstants.ERROR_TEXT_FIELD );
		} else if( email.isEmpty() && !password.isEmpty() ){
			generalBusinessTest.validateMessages( MovileNamesConstants.NAME_FIELD, MovileNamesConstants.ERROR_TEXT_FIELD );
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
		findElement( MovileNamesConstants.CAR ).click();
		findElementByXpath( MovileNamesConstants.BACK_BUTTON ).click();
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		MobileElement loginButton = findElement( MovileNamesConstants.LOGIN_BUTTON );
		Assert.assertNotNull( loginButton );
	}

	public void showPassword( String password ) {
		goLogin();
		MobileElement passField = findElement( MovileNamesConstants.LOGIN_PASS );
		logger.info("Ingresando password");
		passField.sendKeys(password);
		findElement( MovileNamesConstants.SHOW_PASS ).click();
		Assert.assertEquals( Boolean.FALSE.toString(), passField.getAttribute("password") );
	}
	
	public void forgotPass_Without_Email(  ) {
		goLogin();
		findElement( MovileNamesConstants.FORGOT_PASS ).click();
		generalBusinessTest.validateMessages( MovileNamesConstants.NAME_FIELD, MovileNamesConstants.ERROR_TEXT_FIELD );
	}
	
	public void forgotPass( String email ) {
		goLogin();
		MobileElement emailField = findElement( MovileNamesConstants.LOGIN_EMAIL );
		logger.info("Ingresando email");
		emailField.sendKeys(email);
		findElement( MovileNamesConstants.FORGOT_PASS ).click();
		validateWarningMessage();
	}
	
	public void createAccount(  ) {
		goLogin();
		findElement( MovileNamesConstants.REGISTER_BUTTON ).click();
		waitVisibility( MovileNamesConstants.CREATE_BUTTON );
		MobileElement createButton = findElement( MovileNamesConstants.CREATE_BUTTON );
		Assert.assertNotNull( createButton );
	}
	
	private void goLogin() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
	}
	
	private void validateWarningMessage( ) {
		waitVisibility( MovileNamesConstants.WARNING_MESSAGE );
		MobileElement messageError = findElement( MovileNamesConstants.WARNING_MESSAGE );
		Assert.assertNotNull( messageError );
	}
	
}
