package com.bodega.business.android;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;

import com.bodega.base.BaseDriver;
import com.bodega.constants.ConfigConstants;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.MenusEnum;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class GeneralBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(GeneralBusinessTest.class.getName());

	@Step("Tap on navigation option {navOption}")
	public void selectNavigationOption( NavigationBarEnum navOption) {
		waitElementVisibility(NamesMobileElements.NAV_BAR);
		MobileElement navigationElement = null;
		if (navOption.getNavigation() == NavigationBarEnum.HOME.getNavigation()) {
			logger.info("Seleccionando menu home");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_HOME);
		} else if (navOption.getNavigation() == NavigationBarEnum.DEPARTMENTS.getNavigation()) {
			logger.info("Seleccionando menu departamentos");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_DEPARTMENTS);
		} else if (navOption.getNavigation() == NavigationBarEnum.PROMOTIONS.getNavigation()) {
			logger.info("Seleccionando menu perfil");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_PROMOTIONS);
		} else if (navOption.getNavigation() == NavigationBarEnum.CAR.getNavigation()) {
			logger.info("Seleccionando menu perfil");
			navigationElement = findElement(NamesMobileElements.NAV_BAR_CAR);
		}
		navigationElement.click();
	}

	@Step("Tap on menu option {menuOptionEnum}")
	public void selectMenuOption(ProfileMenuEnum menuOptionEnum) {
		logger.info("Seleccionando la opcion: " + menuOptionEnum.getMenu());
		waitElementVisibility(NamesMobileElements.MENU_NAME);
		List<MobileElement> menuList = findElements(NamesMobileElements.MENU_NAME);
		assertTrue("El elemento no existe", menuList.size() > 0);
		boolean clicMenu = false;
		int exit = 0;
		do {
			for (MobileElement element : menuList) {
				if (getElementText(element).contains(menuOptionEnum.getMenu())) {
					tapOnElement(element);
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

	@Step("Validate error field messages {errorAppMessage} for {fieldCont}")
	public void validateFieldErrorMessage(String errorAppMessage, String fieldCont) {
		List<MobileElement> errors = findSubElements(findElement(fieldCont), NamesMobileElements.ERROR_TEXT_FIELD);
		if (errors.size() > 0) {
			assertEquals(errorAppMessage.toLowerCase(), getElementText(errors.get(0)));
		} else {
			logger.error("No se encontraron mensajes de error para: " + fieldCont);
			Assert.fail("No se encontraron mensajes de error para: " + fieldCont);
		}
	}

	@Step("Tap on Back")
	public void goBack() {
		logger.info("Seleccionando regresar");
		waitElementVisibility(NamesMobileElements.BACK_BUTTON);
		tapOnElement(NamesMobileElements.BACK_BUTTON);
	}

	@Step("Tap on profile option")
	public void selectProfile() {
		logger.info("Seleccionando perfil");
		waitElementVisibility(NamesMobileElements.HOME_PROFILE);
		tapOnElement(NamesMobileElements.HOME_PROFILE);
	}

	@Step("Tap on continuar como invitado")
	public void initAsGuess() {
		waitElementVisibility(NamesMobileElements.WELCOME_LINK_GUESS);
		tapOnElement(NamesMobileElements.WELCOME_LINK_GUESS);
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

	@Step("Validate Mama Lucha page")
	public void validateWelcomePage() {
		logger.info("Validando Welcome Page");
		if (elementExist(NamesMobileElements.WELCOME_MAMA_LUCHA)) {
			tapOnElement(NamesMobileElements.WELCOME_LINK_GUESS);
		}
	}

	@Step("Validate menu and submenu")
	public void valitateMenuAndSubMenus(MenusEnum menusEnum) {
		logger.info("Seleccionando la opcion: " + menusEnum.getMenu());
		List<MobileElement> terms = findElements(NamesMobileElements.LEGALS_ITEM);
		Assert.assertTrue("El elemento móvil no existe", terms.size() > 0);
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

	@Step("Random name")
	public String randomString(int length, boolean useLetters, boolean useNumbers) {
	    return RandomStringUtils.random(length, useLetters, useNumbers);
	}
	
	private void validateSubTerm(String[] subTermsEnum) {
		List<MobileElement> subTerms = findElements(NamesMobileElements.LEGALS_SUB_ITEM);
		int index = 0;
		int exit = 0;
		for (; index < subTermsEnum.length && exit < 10;) {
			if (subTerms.get(index).getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
					.contains(subTermsEnum[index].toLowerCase())) {
				subTerms.get(index).click();
				goBack();
				index++;
			} else {
				scrollScreen(GeneralConstants.SCROLL_UP);
				subTerms = findElements(NamesMobileElements.LEGALS_SUB_ITEM);
				index = 0;
				exit++;
			}
		}
		assertEquals(subTermsEnum.length, index);
	}

	private void validateMenuExist(int exit) {
		if (exit > 15) {
			assertTrue("El elemento móvil no existe", Boolean.FALSE);
		}
	}
}
