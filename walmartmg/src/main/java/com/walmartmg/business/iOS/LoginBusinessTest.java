
package com.walmartmg.business.iOS;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

public class LoginBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);

	}

	public void selectMenu() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);

	}

//contraseña_correcta 	
	public void login(String email, String pass) {
		logger.info("ingresando correo ");
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		logger.info("ingresando Password ");
		fillElement(NamesMobileElements.LOGIN_PASS, pass);
		logger.info("se visualiza el passworsd oculto ");
		waitElementVisibility(NamesMobileElements.LOGIN_SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
	}

//validacion mensaje_de_contraseña_correcta
	public void validateLoginIn() {
		logger.info("se visualiza el mensaje de password correcto  ");
		waitElementVisibility(NamesMobileElements.LOGIN_MENSSAGE_OK);
		waitElementVisibility(NamesMobileElements.LOGIN_MENSSAGE_OK);

	}

	//// validacion Contraseña_incorrecta_mensaje_de_contraseña.
	public void validateLoginfail() {
		logger.info("se visualiza el mensaje incorrecto  ");
		String massageFail = getElementText(NamesMobileElements.LOGIN_MENSSAGE_FAIL);
		logger.info("El correo o la contraseña no son correctos.");
		Assert.assertEquals("El correo o la contraseña no son correctos.".toLowerCase(), massageFail.toLowerCase());
		logger.info("se visualiza el mensaje incorrecto  ");
	}

//  password incorrecto menor a 8 caracteres  
	public void loginminor() {
		logger.info("se ingresa el correo  ");
		fillElement(NamesMobileElements.LOGIN_EMAIL, "dj_fran_@hotmail.es");
		logger.info("se ingresa la contraseña menor a 8 digitos ");
		fillElement(NamesMobileElements.LOGIN_PASS, "Regina");
		waitElementVisibility(NamesMobileElements.LOGIN_SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
	}
//validacion 	
	public void validateMinor() {
		logger.info("se valida el mensaje de error que muestra elsistema ");
		String massageFail = getElementText(NamesMobileElements.LOGIN_MENSSAGE_MINOR);
		Assert.assertEquals("Ocurrio un error, favor de intentar nuevamente".toLowerCase(), massageFail.toLowerCase());
		logger.info("FINALIZA CASO DE PRUEBA ");
	}

//mail incorrecto 
	public void mailfail() {
		logger.info("se ingresa el correo   ");
		fillElement(NamesMobileElements.LOGIN_EMAIL, "dj_fran_@hotmail.com");
		logger.info("se ingresa el password   ");
		fillElement(NamesMobileElements.LOGIN_PASS, "emilze080714");
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
		Vmail();
	}

//validacion del mail 
	public void Vmail() {
		logger.info("se valida que el correo proporcionado es inavalido   ");
		String massageFail = getElementText(NamesMobileElements.LOGIN_MENSSAGE_FAIL);
		logger.info("El correo o la contraseña no son correctos.");
		Assert.assertEquals("El correo o la contraseña no son correctos.".toLowerCase(), massageFail.toLowerCase());
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	public void RegNotuser() {
		logger.info("Validando mensaje de error");
		waitElementVisibility(NamesMobileElements.LOGIN_MENSSAGE_USERNOTEXIST);
		String massageFail = getElementText(NamesMobileElements.LOGIN_MENSSAGE_USERNOTEXIST);
		assertEquals("Este usuario no está registrado. Regístrate ahora.".toLowerCase(), massageFail.toLowerCase());
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	////////

	public void Validate_profile() {
		logger.info("SE VALIDA LA PANTALLA DE PERFIL    ");
		elementExist(NamesMobileElements.LOGIN_IN);
		logger.info("SE VALIDA  EL ELEMENTO INICIAR SESION    ");
		elementExist(NamesMobileElements.LOGIN_ACCOUNT);
		logger.info("SE VALIDA EL ELEMENTO CREAR CUENTA  ");
		elementExist(NamesMobileElements.LOGIN_HELP);
		logger.info("SE VALIDA EL ELEMENTO AYUDA     ");
		elementExist(NamesMobileElements.LOGIN_LEGAL);
		logger.info("SE VALIDA EL ELEMENTO  LEGALES   ");
		elementExist(NamesMobileElements.LOGIN_TERMS);
		logger.info("SE VALIDA EL ELEMENTO TERMINOS/CONDICIONES    ");

	}

	public void Validate_Page_Log_in() {
		logger.info("SE VALIDA PANTALLA DE INICIAR SESION  ");
		logger.info("SE VALIDA ELEMENTO EMAIL   ");
		elementExist(NamesMobileElements.LOGIN_EMAIL);
		logger.info("SE VALIDA ELEMENTO CONTRASEÑA   ");
		elementExist(NamesMobileElements.LOGIN_PASS);
		logger.info("SE VALIDA ELEMENTO SE VALIDA  SHOW PASS ");
		elementExist(NamesMobileElements.LOGIN_SHOW_PASS);
		logger.info("SE VALIDA BOTON INGRESAR   ");
		elementExist(NamesMobileElements.LOGIN_BUTTON);
		logger.info("SE VALIDA ELEMENTO OLVIDASTE TU CONTRASEÑA  ");
		elementExist(NamesMobileElements.LOGIN_FORGOT2);
		logger.info("SE VALIDA ELEMENTO CREAR CUeNTA   ");
		elementExist(NamesMobileElements.LOGIN_CREATE_BUTTON);
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	public void Mail_Forgot() {
		logger.info("se ingresa el correo");
		fillElement(NamesMobileElements.LOGIN_EMAIL, "dj_fran_@hotmail.es");
		waitElementVisibility(NamesMobileElements.LOGIN_FORGOT2);
		tapOnElement(NamesMobileElements.LOGIN_FORGOT2);
		logger.info("se valida el  mensaje de Se enviará un correo a tu cuenta registrada.");
		waitElementVisibility(NamesMobileElements.LOGIN_ALERT);
		elementExist(NamesMobileElements.LOGIN_ALERT);
		logger.info("se da click en ACEPTAR");
		tapOnElement(NamesMobileElements.LOGIN_ALERT_BUTTON);
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	public void Validate_link_Create_account() {
		logger.info("SE VALIDA PANTALLA DE INICIAR SESION  ");
		logger.info("SE VALIDA ELEMENTO EMAIL   ");
		elementExist(NamesMobileElements.LOGIN_EMAIL);
		logger.info("SE VALIDA ELEMENTO CONTRASEÑA   ");
		elementExist(NamesMobileElements.LOGIN_PASS);
		logger.info("SE VALIDA ELEMENTO SE VALIDA  SHOW PASS ");
		elementExist(NamesMobileElements.LOGIN_SHOW_PASS);
		logger.info("SE VALIDA BOTON INGRESAR   ");
		elementExist(NamesMobileElements.LOGIN_BUTTON);
		logger.info("SE VALIDA ELEMENTO OLVIDASTE TU CONTRASEÑA  ");
		elementExist(NamesMobileElements.LOGIN_FORGOT2);
		logger.info("da click  ELEMENTO CREAR CUeNTA   ");
		tapOnElement(NamesMobileElements.LOGIN_CREATE_BUTTON);
		waitElementVisibility(NamesMobileElements.LOGIN_CREATE_BUTTON);

	}

}
