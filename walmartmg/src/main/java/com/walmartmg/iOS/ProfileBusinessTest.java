
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
		fillElement(NamesMobileElements.Profile_Name, "Maziel");
		fillElement(NamesMobileElements.Profile_Last_Name, "Chopin");
		fillElement(NamesMobileElements.Profile_Mail, "cruz88994443@hotmail.com");// cambiar los digitos
		fillElement(NamesMobileElements.Profile_Password, "080714javier");
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.Profile_AcceptTerms);
		tapOnElement(NamesMobileElements.Profile_Button);

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
		fillElement(NamesMobileElements.Profile_Name, "112341234");
		fillElement(NamesMobileElements.Profile_Last_Name, "Chopin");
		fillElement(NamesMobileElements.Profile_Mail, "hfiejier@.com");
		fillElement(NamesMobileElements.Profile_Password, "080714_javier");
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.Profile_AcceptTerms);
		tapOnElement(NamesMobileElements.Profile_Button);

	}

	// cuenta exietente
	public void exit() {
		fillElement(NamesMobileElements.Profile_Name, "Maziel");
		fillElement(NamesMobileElements.Profile_Last_Name, "Chopin");
		fillElement(NamesMobileElements.Profile_Mail, "cruz88994333@hotmail.com");
		fillElement(NamesMobileElements.Profile_Password, "080714javier");
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.Profile_AcceptTerms);
		tapOnElement(NamesMobileElements.Profile_Button);

	}

	// validacion de cuenta duplicada
	public void Va() {
		// general.validateElement(NamesMobileElements.Profile_menssage);
		String massageOKa = getText(NamesMobileElements.Profile_menssage);
		Assert.assertEquals("Ya existe un usuario registrado con este correo electrónico".toLowerCase(),
				massageOKa.toLowerCase());
		tapOnElement(NamesMobileElements.BUTTON_MINOR);
	}
}
