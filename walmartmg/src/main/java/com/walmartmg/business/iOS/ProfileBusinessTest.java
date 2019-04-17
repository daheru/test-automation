
package com.walmartmg.business.iOS;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

public class ProfileBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();

	
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);

	}

	public void selectMenu() {
		general.selectProfileMenu(ProfileMenuEnum.CREATE_PROFILE);

	}

	public void Create_account_menu() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("SE VALIDA  ELEMENTOs DE CREAR CUENTA ");
		logger.info("SE VALIDA  ELEMENTO Nombre ");
		waitElementVisibility(NamesMobileElements.PROFILE_NAME);
		elementExist(NamesMobileElements.PROFILE_NAME);
		logger.info("SE VALIDA  ELEMENTO Apellido ");
		waitElementVisibility(NamesMobileElements.PROFILE_LAST_NAME);
		elementExist(NamesMobileElements.PROFILE_LAST_NAME);
		logger.info("SE VALIDA  ELEMENTO Email ");
		elementExist(NamesMobileElements.PROFILE_MAIL);
		waitElementVisibility(NamesMobileElements.PROFILE_MAIL);
		logger.info("SE VALIDA  ELEMENTO Contraseña");
		elementExist(NamesMobileElements.PROFILE_PASSWORD);
		waitElementVisibility(NamesMobileElements.PROFILE_PASSWORD);
		logger.info("SE VALIDA  ELEMENTO Se visualice COntraseña  ");
		elementExist(NamesMobileElements.LOGIN_SHOW_PASS);
		waitElementVisibility(NamesMobileElements.LOGIN_SHOW_PASS);
		logger.info("SE VALIDA  ELEMENTO TErminos y Condiciones ");
		elementExist(NamesMobileElements.PROFILE_ACCEPTTERMS);
		waitElementVisibility(NamesMobileElements.PROFILE_ACCEPTTERMS);
		logger.info("SE VALIDA  ELEMENTO Boton Crear cuenta ");
		elementExist(NamesMobileElements.PROFILE_BUTTON);
		waitElementVisibility(NamesMobileElements.PROFILE_BUTTON);
		logger.info("SE VALIDA  ELEMENTO link iniciar sesion  ");
		elementExist(NamesMobileElements.PROFILE_LOG_IN);
		waitElementVisibility(NamesMobileElements.PROFILE_LOG_IN);

	}

	public void Validate_empty_fields() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("SE VALIDA  ELEMENTOs DE CREAR CUENTA ");
		elementExist(NamesMobileElements.PROFILE_NAME);
		elementExist(NamesMobileElements.PROFILE_LAST_NAME);
		elementExist(NamesMobileElements.PROFILE_MAIL);
		elementExist(NamesMobileElements.PROFILE_PASSWORD);
		elementExist(NamesMobileElements.LOGIN_SHOW_PASS);
		elementExist(NamesMobileElements.PROFILE_ACCEPTTERMS);
		elementExist(NamesMobileElements.PROFILE_LOG_IN);
		elementExist(NamesMobileElements.PROFILE_BUTTON);
		logger.info("SE VALIDA  Y SE DA CLICK EN EL BOTON DE CREAR CUENTA ESTE DESACTIVADO");
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);

	}

	public void Data(String name, String lastname, String mail, String password) {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("escribiendo datos para crear una cuenta   ");
		fillElement(NamesMobileElements.PROFILE_NAME, name);
		fillElement(NamesMobileElements.PROFILE_LAST_NAME, lastname);
		fillElement(NamesMobileElements.PROFILE_MAIL, mail);
		fillElement(NamesMobileElements.PROFILE_PASSWORD, password);
		waitElementVisibility(NamesMobileElements.LOGIN_SHOW_PASS);
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS);
	}

	public void validate_data() {
		logger.info("SE VALIDA Mensajes de Error al dar click en CREAR CUENTA  ");
		tapOnElement(NamesMobileElements.PROFILE_ACCEPTTERMS);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);
		logger.info("SE VALIDA los mensajes  de Error por cada uno de los elementos   ");
		waitElementVisibility(NamesMobileElements.PROFILE_BUTTON);
	}

	public void validate_data2() {
		logger.info("Se valida  acepta terminos/condiciones   ");
		tapOnElement(NamesMobileElements.PROFILE_ACCEPTTERMS);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);
		logger.info("SE VALIDA el  Error por contraseña menor a 8 caracteres  ");
		waitElementVisibility(NamesMobileElements.PROFILE_BUTTON);
	}

	// validacion de creacion de cuenta
	public void vUser() {
		logger.info("Se valida  acepta terminos/condiciones   ");
		tapOnElement(NamesMobileElements.PROFILE_ACCEPTTERMS);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);
		waitElementVisibility(NamesMobileElements.LOGIN_MENSSAGE_OK);

	}

	public void Validata_mail() {
		logger.info("Se valida  acepta terminos/condiciones   ");
		tapOnElement(NamesMobileElements.PROFILE_ACCEPTTERMS);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);
		logger.info("Ya existe un usuario registrado con este correo electr\\u00f3nico\"   ");
		elementExist(NamesMobileElements.PROFILE_MENSAGGE);
		waitElementVisibility(NamesMobileElements.PROFILE_BUTTON);
		tapOnElement(NamesMobileElements.PROFILE_BUTTON);
	}

	public void Create_account_Login_in() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("SE VALIDA  ELEMENTOs DE CREAR CUENTA ");
		logger.info("SE VALIDA  ELEMENTO Nombre ");
		waitElementVisibility(NamesMobileElements.PROFILE_NAME);
		elementExist(NamesMobileElements.PROFILE_NAME);
		logger.info("SE VALIDA  ELEMENTO Apellido ");
		waitElementVisibility(NamesMobileElements.PROFILE_LAST_NAME);
		elementExist(NamesMobileElements.PROFILE_LAST_NAME);
		logger.info("SE VALIDA  ELEMENTO Email ");
		elementExist(NamesMobileElements.PROFILE_MAIL);
		waitElementVisibility(NamesMobileElements.PROFILE_MAIL);
		logger.info("SE VALIDA  ELEMENTO Contraseña");
		elementExist(NamesMobileElements.PROFILE_PASSWORD);
		waitElementVisibility(NamesMobileElements.PROFILE_PASSWORD);
		logger.info("SE VALIDA  ELEMENTO Se visualice COntraseña  ");
		elementExist(NamesMobileElements.LOGIN_SHOW_PASS);
		waitElementVisibility(NamesMobileElements.LOGIN_SHOW_PASS);
		logger.info("SE VALIDA  ELEMENTO TErminos y Condiciones ");
		elementExist(NamesMobileElements.PROFILE_ACCEPTTERMS);
		waitElementVisibility(NamesMobileElements.PROFILE_ACCEPTTERMS);
		logger.info("SE VALIDA  ELEMENTO Boton Crear cuenta ");
		elementExist(NamesMobileElements.PROFILE_BUTTON);
		waitElementVisibility(NamesMobileElements.PROFILE_BUTTON);
		logger.info("SE VALIDA  ELEMENTO link iniciar sesion  ");
		elementExist(NamesMobileElements.PROFILE_LOG_IN);
		logger.info("SE da clink iniciar sesion  ");
		tapOnElement(NamesMobileElements.PROFILE_LOG_IN);
	}
}
