package com.walmartmg.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.commons.GeneralConstants;
import com.walmartmg.commons.MovileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class GeneralBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(GeneralBusinessTest.class.getName());
	
	public void selectNavigationOption( int navOption ) {
		waitVisibility( MovileNamesConstants.NAV_BAR );
		MobileElement navigationElement = null;
		if( navOption == NavigationBarEnum.HOME.getNavigation() ) {
			logger.info(" Seleccionando menu home");
			navigationElement = findElement( MovileNamesConstants.MENU_HOME );
		} else if( navOption == NavigationBarEnum.DEPARTMENTS.getNavigation() ){
			logger.info(" Seleccionando menu departamentos");
			navigationElement = findElement( MovileNamesConstants.MENU_DEPARTMENTS );
		} else if( navOption == NavigationBarEnum.PROFILE.getNavigation() ){
			logger.info(" Seleccionando menu perfil");
			navigationElement = findElement( MovileNamesConstants.MENU_PROFILE );
		} 
		navigationElement.click();
	}
	
	public void selectMenuOption( String menuOptionEnum ) {
		logger.info("Seleccionando la opcion: " + menuOptionEnum);
		waitVisibility( MovileNamesConstants.NAV_BAR );
		List<MobileElement> menuList = findElements( MovileNamesConstants.MENU_NAME );
		boolean clicMenu = false;
		do{
			for( MobileElement element : menuList ){
				if( element.getAttribute("text").toLowerCase().contains( menuOptionEnum ) ){
					element.click();
					clicMenu = true;
					break;
				}
			}
			if( !clicMenu ){
				scrollScreen( GeneralConstants.SCROLL_UP );
				menuList = findElements( MovileNamesConstants.MENU_NAME );
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
}
