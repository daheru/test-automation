package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.MenusEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class GeneralBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(GeneralBusinessTest.class.getName());

	public void selectNavigationOption(int navOption) {
		waitElementVisibility(NamesMobileElements.NAV_BAR);
		MobileElement navigationElement = null;
		if (navOption == NavigationBarEnum.HOME.getNavigation()) {
			logger.info(" Seleccionando menu home");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_HOME);
		} else if (navOption == NavigationBarEnum.DEPARTMENTS.getNavigation()) {
			logger.info(" Seleccionando menu departamentos");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_DEPARTMENTS);
		} else if (navOption == NavigationBarEnum.PROFILE.getNavigation()) {
			logger.info(" Seleccionando menu perfil");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_PROFILE);
		}
		navigationElement.click();
	}

	public void selectMenuOption(String menuOptionEnum) {
		logger.info("Seleccionando la opcion: " + menuOptionEnum);
		waitElementVisibility(NamesMobileElements.NAV_BAR);
		List<MobileElement> menuList = findElements(NamesMobileElements.MENU_NAME);
		Assert.assertTrue("El elemento móvil no existe", menuList.size() > 0);
		boolean clicMenu = false;
		int exit = 0;
		do {
			for (MobileElement element : menuList) {
				if (element.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase().contains(menuOptionEnum)) {
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

	public void scrollScreen(int scrollType) {
		logger.info("Realizando Scroll");
		if (GeneralConstants.SCROLL_UP == scrollType) {
			tapUp();
		} else {
			tapDown();
		}
	}

	public void scrollUntilShowElement(int scrollType, String element) {
		if (GeneralConstants.SCROLL_UP == scrollType) {
			while (findElements(element).size() == 0) {
				tapUp();
			}
		} else {
			while (findElements(element).size() == 0) {
				tapDown();
			}
		}
	}

	public void validateFieldErrorMessage(String errorAppMessage, String fieldCont) {
		List<MobileElement> errors = findSubElements(findElement(fieldCont), NamesMobileElements.ERROR_TEXT_FIELD);
		if (errors.size() > 0) {
			assertEquals(errorAppMessage.toLowerCase(), getElementText(errors.get(0)));
		} else {
			logger.info("No se encontraron mensajes de error");
			Assert.fail();
		}
	}

	public void validateElement(String fieldName) {
		assertTrue("El elemento no existe", elementExist(fieldName));
	}

	public void goBack() {
		tapOnElement(NamesMobileElements.BACK_BUTTON);
	}

	public void validatePopUpMessages(String message) {
		List<MobileElement> messageElement = findElements(NamesMobileElements.POPUP_TEXT_MESSAGE);
		if ( messageElement != null ) {
			assertEquals(message.toLowerCase(), getElementText(messageElement.get(0)));
		} else {
			logger.info("Mensaje inalcanzable");
		}
	}

	public void valitateMenuAndSubMenus(MenusEnum menusEnum) {
		logger.info("Seleccionando la opcion: " + menusEnum.getMenu());

		List<MobileElement> terms = findElements(NamesMobileElements.TERMS_ITEM);
		boolean clicMenu = false;
		int exit = 0;
		do {
			for (int i = 0; i < terms.size(); i++) {
				if (terms.get(i).getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
						.contains(menusEnum.getMenu().toLowerCase())) {
					terms.get(i).click();
					validateSubTerm(menusEnum.getSubMenu());
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
			validateMenuExist(exit);
		} while (!clicMenu);
	}

	private void validateSubTerm(String[] subTermsEnum) {
		List<MobileElement> subTerms = findElements(NamesMobileElements.TERMS_ITEM_CHILD);
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
				subTerms = findElements(NamesMobileElements.TERMS_ITEM_CHILD);
				index=0;
				exit++;
			}
		}
		Assert.assertEquals(subTermsEnum.length, index);
	}
	
	private void validateMenuExist(int exit) {
		if (exit > 15) {
			Assert.assertTrue("El elemento móvil no existe", Boolean.FALSE);
		}
	}
}
