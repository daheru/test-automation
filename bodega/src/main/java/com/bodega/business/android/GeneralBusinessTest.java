package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.constants.ConfigConstants;
import com.bodega.enums.LegalsEnum;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class GeneralBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(GeneralBusinessTest.class.getName());
	
	public void selectNavigationOption( int navOption ) {
		waitVisibility( NamesMobileElements.NAV_BAR );
		MobileElement navigationElement = null;
		if( navOption == NavigationBarEnum.HOME.getNavigation() ) {
			logger.info(" Seleccionando menu home");
			navigationElement = findElement( NamesMobileElements.NAV_BAR_HOME );
		} else if( navOption == NavigationBarEnum.DEPARTMENTS.getNavigation() ){
			logger.info(" Seleccionando menu departamentos");
			navigationElement = findElement( NamesMobileElements.NAV_BAR_DEPARTMENTS );
		} else if( navOption == NavigationBarEnum.PROMOTIONS.getNavigation() ){
			logger.info(" Seleccionando menu perfil");
			navigationElement = findElement( NamesMobileElements.NAV_BAR_PROMOTIONS );
		} else if( navOption == NavigationBarEnum.CAR.getNavigation() ){
			logger.info(" Seleccionando menu perfil");
			navigationElement = findElement( NamesMobileElements.NAV_BAR_CAR );
		} 
		navigationElement.click();
	}
	
	public void selectMenuOption( String menuOptionEnum ) {
		logger.info("Seleccionando la opcion: " + menuOptionEnum);
		List<MobileElement> menuList = findElements( NamesMobileElements.MENU_NAME );
		boolean clicMenu = false;
		do{
			for( MobileElement element : menuList ) {
				if( element.getAttribute( ConfigConstants.ATTRIBUTE_TEXT ).toLowerCase().contains( menuOptionEnum ) ){
					element.click();
					clicMenu = true;
					break;
				}
			}
			if( !clicMenu ) {
				scrollScreen( GeneralConstants.SCROLL_UP );
				menuList = findElements( NamesMobileElements.MENU_NAME );
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
	
	public void validateFieldErrorMessage(String errorAppMessage, String fieldCont) {
		List<MobileElement> errors = findSubElements(findElement(fieldCont), NamesMobileElements.ERROR_TEXT_FIELD);
		if( errors.size() > 0 ) {
			MobileElement errorMessage = findSubElements(findElement(fieldCont), NamesMobileElements.ERROR_TEXT_FIELD)
					.get(0);
			Assert.assertEquals(errorAppMessage.toLowerCase(), getText(errorMessage));
		}
	}
	
	public void validateElement( String fieldName ) {
		Assert.assertTrue( elementExist(fieldName) );
	}
	
	public void goBack( ) {
		tapOnElement( NamesMobileElements.BACK_BUTTON );
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
	
	public void selectProfile() {
		tapOnElement( NamesMobileElements.HOME_PROFILE );
	}
	
	public void initAsGuess() {
		tapOnElement( NamesMobileElements.WELCOME_LINK_GUESS );
	}
	
	public void validatePopUpMessages(String message) {
		try {
			List<MobileElement> messageElement = findElements(NamesMobileElements.WARNING_TEXT_MESSAGE);
			if (messageElement.size() > 0) {
				Assert.assertEquals(message.toLowerCase(), getText(messageElement.get(0)).toLowerCase());
			}
		} catch (Exception e) {
			logger.info("Unreachable message");
		}
	}
	
	public void validateWelcomePage() {
		if( elementExist( NamesMobileElements.WELCOME_MAMA_LUCHA ) ) {
			tapOnElement( NamesMobileElements.WELCOME_LINK_GUESS );
		}
	}
	
	public void selectLegalOption(LegalsEnum termEnum) {
		logger.info("Seleccionando la opcion: " + termEnum.getTerm());

		List<MobileElement> terms = findElements(NamesMobileElements.LEGALS_ITEM);
		boolean clicMenu = false;
		int exit = 0;
		do {
			for (int i = 0; i < terms.size(); i++) {
				if (terms.get(i).getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
						.contains(termEnum.getTerm().toLowerCase())) {
					terms.get(i).click();
					validateSubTerm(termEnum.getSubTerm());
					clicMenu = true;
					terms.get(i).click();
					break;
				}
			}
			if (!clicMenu) {
				scrollScreen(GeneralConstants.SCROLL_UP);
				terms = findElements(NamesMobileElements.MENU_NAME);
				exit++;
			}
			if( exit > 10 ) {
				clicMenu = true;
				Assert.assertTrue(Boolean.FALSE);
			}
		} while (!clicMenu);
	}
	
	private void validateSubTerm(String[] subTermsEnum) {
		List<MobileElement> subTerms = findElements(NamesMobileElements.LEGALS_SUB_ITEM);
		int index = 0;
		int exit = 0;
		for (;index < subTermsEnum.length && exit < 10;) {
			if (subTerms.get(index).getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
					.contains(subTermsEnum[index].toLowerCase())) {
				subTerms.get(index).click();
				goBack();
				index++;
			} else {
				scrollScreen(GeneralConstants.SCROLL_UP);
				subTerms = findElements(NamesMobileElements.LEGALS_SUB_ITEM);
				index=0;
				exit++;
			}
		}
		Assert.assertEquals(subTermsEnum.length, index);
	}
}
