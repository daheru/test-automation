package com.walmartmg.business.iOS;

import java.util.jar.Attributes.Name;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

public class ProfileOnBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());

	}

	public void Validate_Screen_profile() {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" Se valida que esten los siguietnes elementos: DAtos perosonales / editar ");
		waitElementVisibility(NamesMobileElements.PERFIL_Date_personal);
		general.elementExist(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se valida que esten los siguietnes elementos: DAtos inicio sesion / cambiar contraseña ");
		waitElementVisibility(NamesMobileElements.Perfil_Date_inicio);
		general.elementExist(NamesMobileElements.PERFIL_of_password);
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
		general.elementExist(NamesMobileElements.PERFIL_Titule_date);
		general.elementExist(NamesMobileElements.PERFIL_NAME);
		general.elementExist(NamesMobileElements.PERFIL_LASTNAME);
		general.elementExist(NamesMobileElements.PERFIL_DATE);
		logger.info(" Se visualiza  y se da click  terminos y condiones  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		logger.info(" Se da visuliza links  terminos y condiones  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Links_term);
		logger.info(" Se da visualiza  boton de OK y se da click   ");
		waitElementVisibility(NamesMobileElements.PERFIL_button_ok);
		general.elementExist(NamesMobileElements.PERFIL_button_ok);
		tapOnElement(NamesMobileElements.PERFIL_button_ok);

	}
	public void Edit_with_invalid_data( String name, String Last, String date) {
		logger.info(" se da click  en 'TU PERFIL' ");
		tapOnElement(NamesMobileElements.PERFIL_Your_profile);
		logger.info(" Se valida   los DAtos perosonales  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Date_personal);
		waitElementVisibility(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se da click  Editar  ");
		tapOnElement(NamesMobileElements.PERFIL_Edit);
		logger.info(" Se visualiza  el titulo EDITA TUS DATOS PERSONALES /nombre/apellido/fechanacieminto ");
		general.elementExist(NamesMobileElements.PERFIL_Titule_date);
		fillElement(NamesMobileElements.PERFIL_NAME,name);
		fillElement(NamesMobileElements.PERFIL_LASTNAME,Last);
		fillElement(NamesMobileElements.PERFIL_LASTNAME,date);
		logger.info(" Se visualiza  y se da click  terminos y condiones  ");
		waitElementVisibility(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		tapOnElement(NamesMobileElements.PERFIL_Botton_TERMS);
		logger.info(" SE DA CLIK EN  OK   ");
		waitElementVisibility(NamesMobileElements.PERFIL_button_ok);
		tapOnElement(NamesMobileElements.PERFIL_button_ok);
		logger.info(" Se Visualiza  Mensaje de Error //Datos incorrectos, por favor verifique e intente de nuevo.//  ");
		waitElementVisibility(NamesMobileElements.PERFIL_MENSAGE_ERROR);
		general.elementExist(NamesMobileElements.PERFIL_MENSAGE_ERROR);

		
		
	
		
	
	
	}
	
	}









