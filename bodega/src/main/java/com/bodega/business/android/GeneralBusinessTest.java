package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bodega.commons.GeneralConstants;
import com.bodega.commons.MobileNamesConstants;
import com.bodega.commons.NavigationBarEnum;
import com.bodega.commons.PropertiesConstants;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class GeneralBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(GeneralBusinessTest.class.getName());
	
	public void selectNavigationOption( int navOption ) {
		waitVisibility( MobileNamesConstants.NAV_BAR );
		MobileElement navigationElement = null;
		if( navOption == NavigationBarEnum.HOME.getNavigation() ) {
			logger.info(" Seleccionando menu home");
			navigationElement = findElement( MobileNamesConstants.NAV_BAR_HOME );
		} else if( navOption == NavigationBarEnum.DEPARTMENTS.getNavigation() ){
			logger.info(" Seleccionando menu departamentos");
			navigationElement = findElement( MobileNamesConstants.NAV_BAR_DEPARTMENTS );
		} else if( navOption == NavigationBarEnum.PROMOTIONS.getNavigation() ){
			logger.info(" Seleccionando menu perfil");
			navigationElement = findElement( MobileNamesConstants.NAV_BAR_PROMOTIONS );
		} else if( navOption == NavigationBarEnum.CAR.getNavigation() ){
			logger.info(" Seleccionando menu perfil");
			navigationElement = findElement( MobileNamesConstants.NAV_BAR_CAR );
		} 
		navigationElement.click();
	}
	
	public void selectMenuOption( String menuOptionEnum ) {
		logger.info("Seleccionando la opcion: " + menuOptionEnum);
		List<MobileElement> menuList = findElements( MobileNamesConstants.MENU_NAME );
		boolean clicMenu = false;
		do{
			for( MobileElement element : menuList ) {
				if( element.getAttribute( PropertiesConstants.ATTRIBUTE_TEXT ).toLowerCase().contains( menuOptionEnum ) ){
					element.click();
					clicMenu = true;
					break;
				}
			}
			if( !clicMenu ) {
				scrollScreen( GeneralConstants.SCROLL_UP );
				menuList = findElements( MobileNamesConstants.MENU_NAME );
			}
		}while( !clicMenu );
	}
	
	public void scrollScreen( int scrollType ) {
		logger.info("Realizando Scroll");	
		if( GeneralConstants.SCROLL_UP == scrollType ){
			tapUp();
		} else {
			tapDown();
		}
	}
	
	public void validateElement( String fieldName ) {
		Assert.assertTrue( elementExist(fieldName) );
	}
	
	public void goBack( ) {
		tapOnElement( MobileNamesConstants.BACK_BUTTON );
	}
	
	public void scrollUntilShowElement( int scrollType, String element ) {
		if( GeneralConstants.SCROLL_UP == scrollType ){
			while( findElements(element).size() == 0  ) {
				tapUp();
			}
		} else {
			while( findElements(element).size() == 0  ) {
				tapDown();
			}
		}
	}
	
	public void validateErrorMessages( ) {
		List<MobileElement> errorMessages = findElements( MobileNamesConstants.TEXT_INPUT_ERROR );
		Assert.assertTrue( errorMessages.size() > 0 );
	}
	
	public void selectProfile() {
		tapOnElement( MobileNamesConstants.HOME_PROFILE );
	}
	
	public void initAsGuess() {
		tapOnElement( MobileNamesConstants.WELCOME_LINK_GUESS );
	}
	
	public void validateMessage( ) {
		if( PropertiesConstants.PLATFORM_NAME.toLowerCase().equals( GeneralConstants.ANDROID.toLowerCase() ) ) {
			waitVisibility( MobileNamesConstants.WARNING_MESSAGE_TEXT );
			String messageText = findElement( MobileNamesConstants.WARNING_MESSAGE_TEXT ).getAttribute( PropertiesConstants.ATTRIBUTE_TEXT );
			Assert.assertFalse( messageText.toLowerCase().contains( GeneralConstants.ERROR.toLowerCase() ) );
		} else {
			//Select element
			//Click to close
		}
	}
}
