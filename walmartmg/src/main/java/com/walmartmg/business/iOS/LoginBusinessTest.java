
package com.walmartmg.business.iOS;

import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

public class LoginBusinessTest extends BaseDriver {

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());

	}

	public void selectMenu() {
		general.selectProfileMenu(ProfileMenuEnum.LOGIN.getMenu());

	}

//contraseña_correcta 	
	public void login(String email, String pass) {
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		fillElement(NamesMobileElements.LOGIN_PASS, pass);
		waitElementVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
	}

//validacion mensaje_de_contraseña_correcta
	public void validateLoginSuccessful() {
		waitElementVisibility(NamesMobileElements.MENSSAGE_OK);
		waitElementVisibility(NamesMobileElements.MENSSAGE_OK);

	}

	//// validacion Contraseña_incorrecta_mensaje_de_contraseña.
	public void validateLoginfail() {
		String massageFail = getElementText(NamesMobileElements.MENSSAGE_FAIL);
		Assert.assertEquals("El correo o la contraseña no son correctos.".toLowerCase(), massageFail.toLowerCase());
		tapOnElement(NamesMobileElements.BUTTON_FAIL);
	}

//  password incorrecto menor a 8 caracteres  
	public void loginminor() {
		fillElement(NamesMobileElements.LOGIN_EMAIL, "dj_fran_@hotmail.es");
		fillElement(NamesMobileElements.LOGIN_PASS, "Regina");
		waitElementVisibility(NamesMobileElements.SHOW_PASS);
		tapOnElement(NamesMobileElements.SHOW_PASS);

		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
	}
//validacion 	

	public void validateMinor() {
		String massageFail = getElementText(NamesMobileElements.MENSSAGE_MINOR);
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
		waitElementVisibility(NamesMobileElements.MENSSAGE_FAIL);
		// tapOnElement(NamesMobileElements.BUTTON_FAIL);
		waitElementVisibility(NamesMobileElements.BUTTON_FAIL);

	}

	public void RegNotuser() {
		String massageFail = getElementText(NamesMobileElements.MENSSAGE_USERNOTEXIST);
		Assert.assertEquals("Este usuario no está registrado. Regístrate ahora.".toLowerCase(),
				massageFail.toLowerCase());
		tapOnElement(NamesMobileElements.BUTTON_FAIL);

	}

}
