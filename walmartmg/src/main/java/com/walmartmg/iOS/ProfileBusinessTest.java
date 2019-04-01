
package com.walmartmg.iOS;

import org.junit.Assert;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenuOptionsEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

public class ProfileBusinessTest extends BaseDriver {

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());

	}

	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.CREATE_PROFILE.getMenu());

	}

	// 7 crear cuenta de usuario nuevo
	public void Accounts() {
		fillElement(NamesMobileElements.PROFILE_NAME, "Maziel");
		fillElement(NamesMobileElements.PROFILE_LAST_NAME, "Chopin");
		fillElement(NamesMobileElements.PROFILE_MAIL, "cruz88994443@hotmail.com");// cambiar los digitos
		fillElement(NamesMobileElements.PROFILE_PASSWORD, "080714javier");
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.PROFILE_ACCEPTTERMS);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);

	}

	// validacion de creacion de cuenta
	public void vUser() {

		general.validateElement(NamesMobileElements.MENSSAGE_OK);

		// String massageOK = getText(NamesMobileElements.MENSSAGE_OK);
		// Assert.assertTrue( massageOK.toLowerCase().contains("tu registro está
		// completo".toLowerCase()));

	}

	// mensaje de error
	public void menssage() {
		fillElement(NamesMobileElements.PROFILE_NAME, "112341234");
		fillElement(NamesMobileElements.PROFILE_LAST_NAME, "Chopin");
		fillElement(NamesMobileElements.PROFILE_MAIL, "hfiejier@.com");
		fillElement(NamesMobileElements.PROFILE_PASSWORD, "080714_javier");
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.PROFILE_ACCEPTTERMS);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);

	}

	// cuenta exietente
	public void exit() {
		fillElement(NamesMobileElements.PROFILE_NAME, "Maziel");
		fillElement(NamesMobileElements.PROFILE_LAST_NAME, "Chopin");
		fillElement(NamesMobileElements.PROFILE_MAIL, "cruz88994333@hotmail.com");
		fillElement(NamesMobileElements.PROFILE_PASSWORD, "080714javier");
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.PROFILE_ACCEPTTERMS);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);
		

	}

	// validacion de cuenta duplicada
	public void Va() {
		// general.validateElement(NamesMobileElements.Profile_menssage);
		String massageOKa = getText(NamesMobileElements.PROFILE_MENSAGGE);
		Assert.assertEquals("Ya existe un usuario registrado con este correo electrónico".toLowerCase(),
				massageOKa.toLowerCase());
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);
	}
}
