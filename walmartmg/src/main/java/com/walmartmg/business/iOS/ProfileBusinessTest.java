
package com.walmartmg.business.iOS;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;

public class ProfileBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();

	
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);

	}

	public void selectMenu() {
		general.selectMenuOption(ProfileMenuEnum.CREATE_PROFILE);

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
	
//****	///////////LOGON /////////////////////
	
	public void Validate_Screen_profile() {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" Se valida que esten los siguietnes elementos: DAtos perosonales / editar ");
		waitElementVisibility(NamesMobileElements.PERFIL_Date_personal);
		elementExist(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se valida que esten los siguietnes elementos: DAtos inicio sesion / cambiar contraseña ");
		waitElementVisibility(NamesMobileElements.Perfil_Date_inicio);
		elementExist(NamesMobileElements.PERFIL_of_password);
		logger.info(" Se valida que esten los siguietnes elementos: informacion telefonica  / editar ");
		waitElementVisibility(NamesMobileElements.PERFIL_Inf_tel);

	}

	public void Validate_DAte_Personal() {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" Se valida   los DAtos perosonales  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Date_personal);
		waitElementVisibility(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se da click  Editar  ");
		tapOnElement(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se visualiza  el titulo EDITA TUS DATOS PERSONALES /nombre/apellido/fechanacieminto ");
		elementExist(NamesMobileElements.PERFIL_Titule_date);
		elementExist(NamesMobileElements.PERFIL_NAME);
		elementExist(NamesMobileElements.PERFIL_LASTNAME);
		elementExist(NamesMobileElements.PERFIL_DATE);
		logger.info(" Se visualiza  y se da click  terminos y condiones  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		logger.info(" Se da visuliza links  terminos y condiones  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Links_term);
		logger.info(" Se da visualiza  boton de OK y se da click   ");
		waitElementVisibility(NamesMobileElements.PERFIL_button_ok);
		elementExist(NamesMobileElements.PERFIL_button_ok);
		tapOnElement(NamesMobileElements.PERFIL_button_ok);

	}

	public void Edit_with_invalid_data(String name, String Last, String date) {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" Se valida   los DAtos perosonales  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Date_personal);
		waitElementVisibility(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se da click  Editar  ");
		tapOnElement(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se visualiza  el titulo EDITA TUS DATOS PERSONALES /nombre/apellido/fechanacieminto ");
		elementExist(NamesMobileElements.PERFIL_Titule_date);
		fillElement(NamesMobileElements.PERFIL_NAME, name);
		fillElement(NamesMobileElements.PERFIL_LASTNAME, Last);
		fillElement(NamesMobileElements.PERFIL_DATE, date);
		logger.info(" Se visualiza  y se da click  terminos y condiones  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		logger.info(" SE DA CLIK EN  OK   ");
		waitElementVisibility(NamesMobileElements.PERFIL_button_ok);
		tapOnElement(NamesMobileElements.PERFIL_button_ok);
		logger.info(" Se Visualiza  Mensaje de Error //Datos incorrectos, por favor verifique e intente de nuevo.//  ");
		waitElementVisibility(NamesMobileElements.PERFIL_MENSAGE_ERROR);
		elementExist(NamesMobileElements.PERFIL_MENSAGE_ERROR);

	}

	public void Validate_Data_Personal(String name, String Last) {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" Se valida   los DAtos perosonales  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Date_personal);
		waitElementVisibility(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se da click  Editar  ");
		tapOnElement(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se visualiza  el titulo EDITA TUS DATOS PERSONALES /nombre/apellido/fechanacieminto ");
		elementExist(NamesMobileElements.PERFIL_Titule_date);
		fillElement(NamesMobileElements.PERFIL_NAME, name);
		fillElement(NamesMobileElements.PERFIL_LASTNAME, Last);

		logger.info(" Se visualiza  y se da click  terminos y condiones  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		logger.info(" SE DA CLIK EN  OK   ");
		waitElementVisibility(NamesMobileElements.PERFIL_button_ok);
		tapOnElement(NamesMobileElements.PERFIL_button_ok);
		logger.info(" Se Visualiza  Mensaje  //La Actualización del Perfil ha sido Exitosa");
		waitElementVisibility(NamesMobileElements.PERFIL_MENSAGE_OK);

	}

	public void Logon_date() {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" se da click  en 'DAtos de inicio sesion' ");
		elementExist(NamesMobileElements.Perfil_Date_inicio);
		logger.info(" se da click  en 'Cambiar COntraseña ");
		tapOnElement(NamesMobileElements.PERFIL_CHANGE_PASSWORD);
		logger.info(" se valida los  siguientes  campos ");
		logger.info(" se valida que  este en la seccion DATOS INICIO SESION ");
		waitElementVisibility(NamesMobileElements.PERFIL_PAGE_DATE_INICIO);
		logger.info(" se valida los   boton de ok  ");
		waitElementVisibility(NamesMobileElements.PERFIL_button_ok);
		logger.info(" se valida correo de la cuenta  ");
		waitElementVisibility(NamesMobileElements.PERFIL_MAIL);
		String massageFail = getElementText(NamesMobileElements.PERFIL_MAIL);
		Assert.assertEquals("dj_fran_@hotmail.es".toLowerCase(), massageFail.toLowerCase());
		logger.info(" se valida el campo contraseña actual ");
		waitElementVisibility(NamesMobileElements.PERFIL_CURRENT_PASSWORD);
		logger.info(" se valida el campo nueva contraseña  ");
		waitElementVisibility(NamesMobileElements.PERFIL_PASSWORD_NEW);

	}

	public void Error_Messages() {
		logger.info(" se da click en   boton de ok  ");
		tapOnElement(NamesMobileElements.PERFIL_button_ok);
		logger.info(" se validad los mensajes de error ");

	}

	public void When_Entering_Incorrect_Data(String Current, String New) {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" se da click  en 'DAtos de inicio sesion' ");
		elementExist(NamesMobileElements.Perfil_Date_inicio);
		logger.info(" se da click  en 'Cambiar COntraseña ");
		tapOnElement(NamesMobileElements.PERFIL_CHANGE_PASSWORD);
		logger.info(" se valida los  siguientes  campos ");
		logger.info(" se valida que  este en la seccion DATOS INICIO SESION ");
		waitElementVisibility(NamesMobileElements.PERFIL_PAGE_DATE_INICIO);
		logger.info(" se valida los   boton de ok  ");
		waitElementVisibility(NamesMobileElements.PERFIL_button_ok);
		logger.info(" se valida correo de la cuenta  ");
		waitElementVisibility(NamesMobileElements.PERFIL_MAIL);
		String massageFail = getElementText(NamesMobileElements.PERFIL_MAIL);
		Assert.assertEquals("dj_fran_@hotmail.es".toLowerCase(), massageFail.toLowerCase());
		logger.info(" se valida el campo contraseña actual ");
		waitElementVisibility(NamesMobileElements.PERFIL_CURRENT_PASSWORD);
		fillElement(NamesMobileElements.PERFIL_CURRENT_PASSWORD, Current);
		logger.info(" se valida el campo nueva contraseña  ");
		fillElement(NamesMobileElements.PERFIL_PASSWORD_NEW, New);
		tapOnElement(NamesMobileElements.LOGIN_SHOW_PASS);

	}

	public void Incorrect_data() {
		logger.info(" se da click en   boton de ok  ");
		tapOnElement(NamesMobileElements.PERFIL_button_ok);
		logger.info(" se validad los mensajes de error ");
	}

	public void Correct_data() {
		logger.info(" se da click en   boton de ok  ");
		tapOnElement(NamesMobileElements.PERFIL_button_ok);
		logger.info(" se valida el mensaje cambio de contraseña   ");
		waitElementVisibility(NamesMobileElements.PERFIL_MENSAGE_PASS_OK);
		elementExist(NamesMobileElements.PERFIL_MENSAGE_PASS_OK);

	}

	public void Validate_Telephone_information_screen() {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" se da click  en 'infomacion telefonica ' ");
		waitElementVisibility(NamesMobileElements.PERFIL_Inf_tel);
		waitElementVisibility(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se da click  Editar  ");
		List<MobileElement> editButtons = findElements(NamesMobileElements.PERFIL_Edit);
		tapOnElement(editButtons.get(1));
		logger.info(" Se visualiza el  numero de telefono movil  ");
		findElement(NamesMobileElements.PERFIL_MOVIL1);
		logger.info(" Se visualiza el  numero de telefono Fijo  ");
		findElement(NamesMobileElements.PERFIL_MOVIL2);
		logger.info(" se visualiza   boton de ok  ");
		findElement(NamesMobileElements.PERFIL_button_ok);

	}

	public void When_Editing_Telephone_Information(String Tel, String cell) {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" se da click  en 'infomacion telefonica ' ");
		waitElementVisibility(NamesMobileElements.PERFIL_Inf_tel);
		waitElementVisibility(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se da click  Editar  ");
		List<MobileElement> editButtons = findElements(NamesMobileElements.PERFIL_Edit);
		tapOnElement(editButtons.get(1));
		logger.info(" Se visualiza el  numero de telefono movil  ");
		findElement(NamesMobileElements.PERFIL_MOVIL1);
		logger.info(" Se edita el numero de movil");
		fillElement(NamesMobileElements.PERFIL_MOVIL1, Tel);
		logger.info(" Se visualiza el  numero de telefono Fijo  ");
		findElement(NamesMobileElements.PERFIL_MOVIL2);
		logger.info(" Se edita el numero de movil");
		fillElement(NamesMobileElements.PERFIL_MOVIL2, cell);
		logger.info(" se visualiza   boton de ok  ");
		findElement(NamesMobileElements.PERFIL_button_ok);
		logger.info(" se da click   boton de ok  ");
		tapOnElement(NamesMobileElements.PERFIL_button_ok);
	}

	public void validate_mensage() {
		logger.info(" se valida  mensaje ok   ");
		waitElementVisibility(NamesMobileElements.PERFIL_MENSAGE_ok);
		String massageFail = getElementText(NamesMobileElements.PERFIL_MENSAGE_ok);
		Assert.assertEquals("La Actualización del Perfil ha sido Exitosa".toLowerCase(), massageFail.toLowerCase());
	}

	public void Screen_validate() {
		logger.info(" se da click  en 'TUs DIRRECIONES ' ");
		tapOnElement(NamesMobileElements.PERFIL_ADDRES);
		logger.info(" se da valida que esten los elementos  ");
		logger.info(" se da valida que esten las  la dirrecion Principal ");
		findElement(NamesMobileElements.PERFIL_ADRRES_ONE);
		logger.info(" se da valida que esten en rojo la  dirrecion principal");
		findElement(NamesMobileElements.PERFIL_FAVOR_ADDRES_RED);
		logger.info(" se da valida que esten las  la dirrecion Secundaria  ");
		findElement(NamesMobileElements.PERFIL_ADDRES_TWO);
		logger.info(" se da valida que no este  en rojo la  dirrecion secundaria");
		findElement(NamesMobileElements.PERFIL_FAVOR_ADRRES);
		logger.info(" se da valida que este el  voto de agregar mas DIRREIONES ");
		findElement(NamesMobileElements.PERFIL_BUTTON_MAS);

	}

	public void Messages_with_empty_form() {
		logger.info(" se da click  en 'TUs DIRRECIONES ' ");
		tapOnElement(NamesMobileElements.PERFIL_ADDRES);
		logger.info(" se da valida que este el  Boton de agregar mas DIRREIONES ");
		findElement(NamesMobileElements.PERFIL_BUTTON_MAS);
		tapOnElement(NamesMobileElements.PERFIL_BUTTON_MAS);
	}

	public void Validate_error_mensage() {
		logger.info(" se abre para agregar una  dirrecion nueva  ' ");
		logger.info(" se da cliek en   Ok  para guardar cambios  ' ");
		findElement(NamesMobileElements.PERFIL_BOTTON_OK);
		tapOnElement(NamesMobileElements.PERFIL_BOTTON_OK);
		logger.info("se valida  mensaje  de error por  **campos requeridos** ");
	}

	public void Validate_date_capturing_correct(String ad, String na, String la, String st) {
		logger.info(" se da click  en 'TUs DIRRECIONES ' ");
		tapOnElement(NamesMobileElements.PERFIL_ADDRES);
		logger.info(" se da valida que este el  Boton de agregar mas DIRREIONES ");
		findElement(NamesMobileElements.PERFIL_BUTTON_MAS);
		tapOnElement(NamesMobileElements.PERFIL_BUTTON_MAS);
		logger.info(" se visualiza los siguientes campos para llenar");
		waitElementVisibility(NamesMobileElements.PERFIL_NAME_ADDRES);
		fillElement(NamesMobileElements.PERFIL_NAME_ADDRES, ad);
		waitElementVisibility(NamesMobileElements.PERFIL_NAME1);
		fillElement(NamesMobileElements.PERFIL_NAME1, na);
		waitElementVisibility(NamesMobileElements.PERFIL_LASTNAME2);
		fillElement(NamesMobileElements.PERFIL_LASTNAME2, la);
		waitElementVisibility(NamesMobileElements.PERFIL_STREET);
		fillElement(NamesMobileElements.PERFIL_STREET, st);

	}

	/////////////////////// falta 95 96 97 98 ////

	public void With_a_new_account() {
		logger.info(" se da click  en 'TUS Pedidos ' ");
		tapOnElement(NamesMobileElements.PERFIL_YOUR_ORDERS);
		logger.info("Se visualiza en pantalla Imagen ,Aún no tienes ningún pedido");
		findElement(NamesMobileElements.PERFIL_PAGE_NO_ORDER);
		String massageFail = getElementText(NamesMobileElements.PERFIL_PAGE_NO_ORDER);
		Assert.assertEquals("Aún no tienes ningún pedido ".toLowerCase(), massageFail.toLowerCase());

	}

	public void List_orders() {
		logger.info(" se da click  en 'TUS Pedidos ' ");
		tapOnElement(NamesMobileElements.PERFIL_YOUR_ORDERS);
		logger.info("Se visualiza en pantalla los pedidos realizados ");
		findElement(NamesMobileElements.PERFIL_PAGE_NO_ORDER);
		logger.info("Se visualiza en pantalla el detalle del pedido ");
		tapOnElement(NamesMobileElements.PERFIL_DETAIL);
	}
	

	public void Validate_HELP() {
		logger.info(" se da click  en 'AYUDA ' ");
		tapOnElement(NamesMobileElements.PROFILE_BUTTON_HELP);
		logger.info(" se valida el contenido de AYUDA ' ");
		logger.info("VALIDACION  DE ¿NECESITAS AYUDA? ");
		String massageOK = getElementText(NamesMobileElements.PROFILE_HELP);
		Assert.assertEquals("¿Necesitas ayuda?".toLowerCase(), massageOK.toLowerCase());
		logger.info("VALIDACION DE NUMERO  TELEFONO ");
		String massageOK1 = getElementText(NamesMobileElements.PROFILE_HELP_TEL);
		Assert.assertEquals("Llama al 01 800 925 6278".toLowerCase(), massageOK1.toLowerCase());
		logger.info("VALIDACION  LLAMANOS ");
		String massageOK2 = getElementText(NamesMobileElements.PROFILE_HELP_TEXT_LLAMANOS);
		Assert.assertEquals("Llámanos".toLowerCase(), massageOK2.toLowerCase());
		logger.info("VALIDACION ESCRIBENOS ");
		String massageOK3 = getElementText(NamesMobileElements.PROFILE_HELP_TEXT_MAIL);
		Assert.assertEquals("Escríbenos".toLowerCase(), massageOK3.toLowerCase());
	}

	public void Call_Us() {
		logger.info("SE DA CLICK EN EL ICONO DE LLAMANOS");
		tapOnElement(NamesMobileElements.PROFILE_CALL_BUTTON);
		waitElementVisibility(NamesMobileElements.PROFILE_CANCEL);
		tapOnElement(NamesMobileElements.PROFILE_CANCEL);
		logger.info(" FIN LLAMANOS  ");

	}

	public void Mail_button() {
		logger.info("SE DA CLICK EN EL ICONO DE MAIL");
		tapOnElement(NamesMobileElements.PROFILE_MAIL_BUTTON);
		waitElementVisibility(NamesMobileElements.PROFILE_CANCEL2);
		tapOnElement(NamesMobileElements.PROFILE_CANCEL2);
		logger.info(" FIN MAIL ");
	}

	public void Validate_legal() {
		logger.info("SE DA CLICK EN EL ICONO DE legal");
		waitElementVisibility(NamesMobileElements.PROFILE_LEGAL_LOGO);
		tapOnElement(NamesMobileElements.PROFILE_LEGAL_LOGO);
		logger.info(" SE  VE AVISO DE PRIVACIDAD ");
		waitElementVisibility(NamesMobileElements.PROFILE_PRIVACY_NOTICE1);
		logger.info("CLICK EN AVISO");
		tapOnElement(NamesMobileElements.PROFILE_PRIVACY_NOTICE1);
		logger.info("SE  VE AVISO DE PRIVACIDAD ");
		logger.info("SE  VE  VERSION APP ");
		elementExist(NamesMobileElements.PROFILE_VERSION);
	}

	public void click_terms() {
		logger.info("SE DA CLICK EN EL ICONO DE TERMINOS Y CONDICIONES ");
		waitElementVisibility(NamesMobileElements.PROFILE_TERMS);
		tapOnElement(NamesMobileElements.PROFILE_TERMS);
		
	}
	public void VALIDATE_TERMS_COND () {
		logger.info("SE VALIDA APARTADO DE DEVOLUCIONES ");
		tapOnElement(NamesMobileElements.PROFILE_RET);
		logger.info("SE VALIDA ELEMENTOS DEVOLUCIONES");
		waitElementVisibility(NamesMobileElements.PROFILE_HOW);
		waitElementVisibility(NamesMobileElements.PROFILE_WAR);
		waitElementVisibility(NamesMobileElements.PROFILE_CAN);
		tapOnElement(NamesMobileElements.PROFILE_RET);
		logger.info("FINALIZA APARTADO DE DEVOLUCIONES ");
//precio /promociones
		logger.info("SE VALIDA APARTADO DE PRECIO/PROMOCIONES ");
		tapOnElement(NamesMobileElements.PROFILE_PRECIO);
		logger.info("SE VALIDA ELEMENTOS PRECIO/PROMOCIONES");
		waitElementVisibility(NamesMobileElements.PROFILE_PRECIO_BAJOS);
		waitElementVisibility(NamesMobileElements.PROFILE_ARTICULOS);
		waitElementVisibility(NamesMobileElements.PROFILE_COMPRASGRANEL);
		waitElementVisibility(NamesMobileElements.PROFILE_LINVENTARIO);
		waitElementVisibility(NamesMobileElements.PROFILE_INF_CONTENIDOS);
		tapOnElement(NamesMobileElements.PROFILE_PRECIO);
		logger.info("FINALIZA APARTADO DE PRECIO/PROMOCIONES ");
//compras
		logger.info("SE VALIDA APARTADO DE FACTURACION ");
		tapOnElement(NamesMobileElements.PROFILE_BILLING);
		logger.info("SE VALIDA ELEMENTOS FACTURACION");
		waitElementVisibility(NamesMobileElements.PROFILE_INVOICING);
		tapOnElement(NamesMobileElements.PROFILE_BILLING);
		logger.info("FINALIZA APARTADO DE FACTURACION ");
// Marketplace
		logger.info(" APARTADO MARKETPLACE ");
		tapOnElement(NamesMobileElements.PROFILE_MARKETPALCE);
		logger.info("SE VALIDA ELEMENTOS MARKETPLACE");
		waitElementVisibility(NamesMobileElements.PROFILE_MARKETPALCE);
		tapOnElement(NamesMobileElements.PROFILE_MARKETPALCE);
		logger.info("FINALIZA APARTADO DE MARKETPLACE ");
//envios 
		logger.info(" APARTADO ENVIOS ");
		tapOnElement(NamesMobileElements.PROFILE_SHIPPING);
		logger.info("SE VALIDA ELEMENTOS ENVIOS");
		waitElementVisibility(NamesMobileElements.PROFILE_COSTO);
		waitElementVisibility(NamesMobileElements.PROFILE_ENTREGA);
		waitElementVisibility(NamesMobileElements.PROFILE_HORARIO);
		tapOnElement(NamesMobileElements.PROFILE_SHIPPING);
		logger.info("FINALIZA APARTADO MARKETPLACE ");
		// seguridad
		logger.info(" APARTADO SEGURIDAD ");
		tapOnElement(NamesMobileElements.PROFILE_SEGURIDAD_PRIVACIDAD);
		logger.info("SE VALIDA ELEMENTOS SEGURIDAD");
		waitElementVisibility(NamesMobileElements.PROFILE_POLITICA);
		waitElementVisibility(NamesMobileElements.PROFILE_TERM);
		tapOnElement(NamesMobileElements.PROFILE_SEGURIDAD_PRIVACIDAD);
		logger.info("FINALIZA APARTADO SEGURIDAD ");
///pagos
		logger.info("SE VALIDA APARTADO PAGOS");
		tapOnElement(NamesMobileElements.PROFILE_PAGOS);
		logger.info("SE VALIDA ELEMENTOS PAGOS");
		waitElementVisibility(NamesMobileElements.PROFILE_FORMAS);
		waitElementVisibility(NamesMobileElements.PROFILE_PAGO_SEGURO);
		waitElementVisibility(NamesMobileElements.PROFILE_TARJETAWALLET);
		waitElementVisibility(NamesMobileElements.PROFILE_THRED);
		waitElementVisibility(NamesMobileElements.PROFILE_PAYPAL);
		waitElementVisibility(NamesMobileElements.PROFILE_BBVA);
		waitElementVisibility(NamesMobileElements.PROFILE_CITI);
		waitElementVisibility(NamesMobileElements.PROFILE_TARJETA);
		tapOnElement(NamesMobileElements.PROFILE_PAGOS);
		logger.info(" APARTADO finaliza PAGOS ");
/// preguntas frecunetes
		logger.info("SE VALIDA  APARTADO PREGUNTAS FRECUENTES ");
		tapOnElement(NamesMobileElements.PROFILE_QUESTION);
		logger.info("SE VALIDA ELEMENTOS PREGUNTAS FRECUENTAS");
		waitElementVisibility(NamesMobileElements.PROFILE_QUESTION);
		tapOnElement(NamesMobileElements.PROFILE_QUESTION);
		logger.info("FINALIZA APARTADO PREGUNTAS FRECUENTES ");
//Tucuenta
		logger.info("SE VALIDA APARTADO TU CUENTA");
		tapOnElement(NamesMobileElements.PROFILE_TUCUENTA);
		logger.info("SE VALIDA ELEMENTOS DENTRO DE CUENTA");
		waitElementVisibility(NamesMobileElements.PROFILE_P1);
		waitElementVisibility(NamesMobileElements.PROFILE_P2);
		waitElementVisibility(NamesMobileElements.PROFILE_P3);
		waitElementVisibility(NamesMobileElements.PROFILE_P4);
		waitElementVisibility(NamesMobileElements.PROFILE_P5);
		tapOnElement(NamesMobileElements.PROFILE_TUCUENTA);
		logger.info("FINALIZA APARTADO TU CUENTA");
// tus pedidos 
		logger.info("SE VALIDA APARTADO TUSPEDIDOS");
		tapOnElement(NamesMobileElements.PROFILE_TUSPEDIDOS);
		logger.info("SE VALIDA ELEMENTOS TUS PEDIDOS ");
		waitElementVisibility(NamesMobileElements.PROFILE_COMPRAR);
		waitElementVisibility(NamesMobileElements.PROFILE_INVITADO);
		waitElementVisibility(NamesMobileElements.PROFILE_PEDIDO);
		waitElementVisibility(NamesMobileElements.PROFILE_ENVIO);
		waitElementVisibility(NamesMobileElements.PROFILE_RASPEIDOS);
		waitElementVisibility(NamesMobileElements.PROFILE_HISTPEIDOS);
		tapOnElement(NamesMobileElements.PROFILE_TUSPEDIDOS);
		logger.info("FINALIZA APARTADO TUS PEDIDOS ");
	}
	public void  closed_sesion() {
		logger.info("SE DA CLICK EN EL CERRAR SESION ");
		waitElementVisibility(NamesMobileElements.PROFILE_SING_OFF);
		tapOnElement(NamesMobileElements.PROFILE_SING_OFF);
		logger.info("SE pantalla principal del  home  ");
	}
	

}


	
	
	
	
	
	
	
	
	

