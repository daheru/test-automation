package com.walmartmg.business.android;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.commons.PropertiesConstants;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class.getName());
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void login(String email, String password){
		goLogin();
		if( !email.isEmpty() ) {
			logger.info("Ingresando email");
			fillElement(MobileNamesConstants.LOGIN_EMAIL, email);
		}
		if( !password.isEmpty() ) {
			logger.info("Ingresando password");
			fillElement(MobileNamesConstants.LOGIN_PASS, password);
		}
		logger.info("Tap en iniciar sesion");
		tapOnElement( MobileNamesConstants.LOGIN_BUTTON );
	}
	
	public void validateLogin( String email ) {
		logger.info("Validando Login");
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		MobileElement userEmail = findElement( MobileNamesConstants.USER_EMAIL );
		Assert.assertEquals(email, userEmail.getAttribute( PropertiesConstants.ATTRIBUTE_TEXT ));
	}
	
	public void validateErrorMessages( String email, String password ) {
		logger.info("Verificando mensajes de validacion");
		if( email.isEmpty() && password.isEmpty() ){
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.NAME_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.PASS_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
		} else if( !email.isEmpty() && password.isEmpty() ){
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.PASS_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
		} else if( email.isEmpty() && !password.isEmpty() ){
			generalBusinessTest.validateErrorMessages( MobileNamesConstants.NAME_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
		} else {
			generalBusinessTest.validateMessage();
		}
	}
	
	public void logout( ) {
		logger.info("Tap en cerrar sesion");
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGOUT.getMenu() );
	}
	
	public void validateLogout( ) {
		logger.info("Validando Login");
		tapOnElement(MobileNamesConstants.HOME_CAR);
		tapOnElement(MobileNamesConstants.BACK_BUTTON);
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
		tapOnElement( MobileNamesConstants.SHOW_PASS );
		Assert.assertEquals( Boolean.FALSE.toString(), passField.getAttribute("password") );
	}
	
	public void forgotPass_Without_Email(  ) {
		goLogin();
		tapOnElement( MobileNamesConstants.FORGOT_PASS );
		generalBusinessTest.validateErrorMessages( MobileNamesConstants.NAME_FIELD, MobileNamesConstants.ERROR_TEXT_FIELD );
	}
	
	public void forgotPass( String email ) {
		goLogin();
		logger.info("Ingresando email");
		fillElement(MobileNamesConstants.LOGIN_EMAIL, email);
		tapOnElement( MobileNamesConstants.FORGOT_PASS );
		generalBusinessTest.validateMessage();
	}
	
	public void createAccount(  ) {
		goLogin();
		tapOnElement( MobileNamesConstants.REGISTER_BUTTON );
		waitVisibility( MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		MobileElement createButton = findElement( MobileNamesConstants.ACCOUNT_CREATE_BUTTON );
		Assert.assertNotNull( createButton );
	}
	
	private void goLogin() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
	}	
}
