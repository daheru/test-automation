
package com.walmartmg.iOS;

import org.junit.Assert;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenuOptionsEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

public class LoginBusinessTest extends BaseDriver {

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());

	}

	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.LOGIN.getMenu());

	}

//contraseña_correcta 	
	public void login(String email, String pass) {
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		fillElement(NamesMobileElements.LOGIN_PASS, pass);
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
	}

//validacion mensaje_de_contraseña_correcta
	public void validateLoginSuccessful() {
		waitVisibility(NamesMobileElements.MENSSAGE_OK);
		general.validateElement(NamesMobileElements.MENSSAGE_OK);

	}

	//// validacion Contraseña_incorrecta_mensaje_de_contraseña.
	public void validateLoginfail() {
		String massageFail = getText(NamesMobileElements.MENSSAGE_FAIL);
		Assert.assertEquals("El correo o la contraseña no son correctos.".toLowerCase(), massageFail.toLowerCase());
		tapOnElement(NamesMobileElements.BUTTON_FAIL);
	}

//  password incorrecto menor a 8 caracteres  
	public void loginminor() {
		fillElement(NamesMobileElements.LOGIN_EMAIL, "dj_fran_@hotmail.es");
		fillElement(NamesMobileElements.LOGIN_PASS, "Regina");
		waitVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);

		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
	}
//validacion 	

	public void validateMinor() {
		String massageFail = getText(NamesMobileElements.MENSSAGE_MINOR);
		Assert.assertEquals("Ocurrio un error, favor de intentar nuevamente".toLowerCase(), massageFail.toLowerCase());
		tapOnElement(NamesMobileElements.BUTTON_FAIL);
	}

//mail incorrecto 
	public void mailfail() {
		fillElement(NamesMobileElements.LOGIN_EMAIL, "dj_fran_@hotmail.com");
		fillElement(NamesMobileElements.LOGIN_PASS, "080714regina");
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
		Vmail();
	}

//validacion del mail 
	public void Vmail() {
		general.validateElement(NamesMobileElements.MENSSAGE_FAIL);
		// tapOnElement(NamesMobileElements.BUTTON_FAIL);
		general.validateElement(NamesMobileElements.BUTTON_FAIL);

	}

	public void RegNotuser() {
		String massageFail = getText(NamesMobileElements.MENSSAGE_USERNOTEXIST);
		Assert.assertEquals("Este usuario no está registrado. Regístrate ahora.".toLowerCase(),
				massageFail.toLowerCase());
		tapOnElement(NamesMobileElements.BUTTON_FAIL);

	}

}
