package com.walmartmg.business.iOS;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

public class HelpBusinessTest extends BaseDriver {
	private static final Logger logger = Logger.getLogger(HelpBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {

		general.selectNavigationOption(NavigationBarEnum.PROFILE);

	}

	public void selectMenu() {
		general.selectMenuOption(ProfileMenuEnum.SUPPORT);

	}

	public void helpPage() {
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
}
