package com.walmartmg.business.android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenusEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class GeneralBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(GeneralBusinessTest.class.getName());

	@Step("Tap on navigation bar {navOption}")
	public void selectNavigationOption( NavigationBarEnum navigationBarEnum ) {
		waitElementVisibility(NamesMobileElements.NAV_BAR);
		MobileElement navigationElement = null;
		if (navigationBarEnum.getNavigation() == NavigationBarEnum.HOME.getNavigation()) {
			logger.info(" Seleccionando menu home");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_HOME);
		} else if (navigationBarEnum.getNavigation() == NavigationBarEnum.DEPARTMENTS.getNavigation()) {
			logger.info(" Seleccionando menu departamentos");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_DEPARTMENTS);
		} else if (navigationBarEnum.getNavigation() == NavigationBarEnum.PROFILE.getNavigation()) {
			logger.info(" Seleccionando menu perfil");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_PROFILE);
		}
		navigationElement.click();
	}

	@Step("Tap on menu {menuOptionEnum}")
	public void selectProfileMenu(ProfileMenuEnum menuOptionEnum) {
		logger.info("Seleccionando la opcion: " + menuOptionEnum.getMenu());
		waitElementVisibility(NamesMobileElements.NAV_BAR);
		List<MobileElement> menuList = findElements(NamesMobileElements.MENU_NAME);
		Assert.assertTrue("El elemento móvil no existe", menuList.size() > 0);
		boolean clicMenu = false;
		int exit = 0;
		do {
			for (MobileElement element : menuList) {
				if (element.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase().contains(menuOptionEnum.getMenu())) {
					element.click();
					clicMenu = true;
					break;
				}
			}
			if (!clicMenu) {
				scrollScreen(GeneralConstants.SCROLL_UP);
				menuList = findElements(NamesMobileElements.MENU_NAME);
				exit++;
			}
			validateMenuExist(exit);
		} while (!clicMenu);
	}

	@Step("Scroll screen")
	public void scrollScreen(int scrollType) {
		logger.info("Realizando Scroll");
		if (GeneralConstants.SCROLL_UP == scrollType) {
			tapUp();
		} else {
			tapDown();
		}
	}
	
	@Step("Validate error {errorAppMessage} from fild {fieldCont}")
	public void validateFieldErrorMessage(String errorAppMessage, String fieldCont) {
		List<MobileElement> errors = findSubElements(findElement(fieldCont), NamesMobileElements.ERROR_TEXT_FIELD);
		if (errors.size() > 0) {
			assertEquals(errorAppMessage.toLowerCase(), getElementText(errors.get(0)));
		} else {
			logger.info("No se encontraron mensajes de error");
			Assert.fail();
		}
	}

	@Step("Tap on back button")
	public void goBack() {
		waitElementVisibility(NamesMobileElements.BACK_BUTTON);
		tapOnElement(NamesMobileElements.BACK_BUTTON);
		logger.info("Tap en regresar");
	}

	@Step("Validate popup message {message}")
	public void validatePopUpMessages(String message) {
		try {
			List<MobileElement> messageElement = findElements(NamesMobileElements.POPUP_TEXT_MESSAGE);
			if (messageElement != null && messageElement.size() > 0) {
				assertEquals(message.toLowerCase(), getElementText(messageElement.get(0)));
			} else {
				logger.info("Mensaje inalcanzable");
			}
		} catch (StaleElementReferenceException err) {
			logger.info("Mensaje inalcanzable");
		}

	}

	@Step("Tap on menu")
	public void valitateDropDownMenu(MenusEnum menusEnum) {
		logger.info("Seleccionando la opcion: " + menusEnum.getMenu());
		List<MobileElement> terms = new ArrayList<MobileElement>();
		boolean clicMenu = false;
		int exit = 0;
		do {
			terms = findElements(menusEnum.getElements()[0]);
			Iterator<MobileElement> elements = terms.iterator();
			while (elements.hasNext()) {
				MobileElement element = elements.next();
				if (getElementText(element).contains(menusEnum.getMenu().toLowerCase())) {
					tapOnElement(element);
					validateSubMenu(menusEnum.getSubMenu(), menusEnum.getElements()[1]);
					clicMenu = true;
					exit = 0;
					break;
				}
			}
			if (!clicMenu) {
				scrollScreen(GeneralConstants.SCROLL_UP);
				terms = findElements(menusEnum.getElements()[0]);
				validateMenuExist(exit++);
			}
		} while (!clicMenu);
	}

	private void validateSubMenu(String[] subTermsEnum, String childItem) {
		List<MobileElement> subTerms = new ArrayList<MobileElement>();
		int indexEnum = 0, exit = 0;
		boolean clicMenu = false;
		do {
			subTerms = findElements(childItem);
			Iterator<MobileElement> iteratorElement = subTerms.iterator();
			clicMenu = false;
			while (iteratorElement.hasNext()) {
				MobileElement element = iteratorElement.next();
				if (getElementText(element).contains(subTermsEnum[indexEnum].toLowerCase())) {
					logger.info("Seleccionando la opcion: " + subTermsEnum[indexEnum]);
					tapOnElement(element);
					clicMenu = true;
					exit = 0;
					goBack();
					indexEnum ++;
				}
			}
			if( !clicMenu ) {
				scrollScreen(GeneralConstants.SCROLL_UP);
				validateMenuExist(exit++);
			}
		} while ( indexEnum < subTermsEnum.length );
	}

	private void validateMenuExist(int exit) {
		if (exit > 15) {
			assertTrue("La opciones son incorrectas o no aparecen en pantalla", Boolean.FALSE);
		}
	}
}
