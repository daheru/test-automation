package com.walmartmg.business.iOS;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

public class TermsyConditionsBusinessTest extends BaseDriver {
	private static final Logger logger = Logger.getLogger(TermsyConditionsBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);

	}

	public void selectMenu() {
		general.selectMenuOption(ProfileMenuEnum.TERMS);

	}

//devoluciones 
	public void cond() {
		logger.info(" APARTADO DE DEVOLUCIONES ");
		tapOnElement(NamesMobileElements.PROFILE_RET);
		waitElementVisibility(NamesMobileElements.PROFILE_HOW);
		waitElementVisibility(NamesMobileElements.PROFILE_WAR);
		waitElementVisibility(NamesMobileElements.PROFILE_CAN);
		tapOnElement(NamesMobileElements.PROFILE_RET);
		logger.info(" FINALIZA APARTADO DE DEVOLUCIONES ");

//precio /promociones
		logger.info(" APARTADO DE PRECIO/PROMOCIONES ");
		tapOnElement(NamesMobileElements.PROFILE_PRECIO);
		waitElementVisibility(NamesMobileElements.PROFILE_PRECIO_BAJOS);
		waitElementVisibility(NamesMobileElements.PROFILE_ARTICULOS);
		waitElementVisibility(NamesMobileElements.PROFILE_COMPRASGRANEL);
		waitElementVisibility(NamesMobileElements.PROFILE_LINVENTARIO);
		waitElementVisibility(NamesMobileElements.PROFILE_INF_CONTENIDOS);
		tapOnElement(NamesMobileElements.PROFILE_PRECIO);
		logger.info(" FINALIZA APARTADO DE PRECIO/PROMOCIONES ");

	}

//compras
	public void cond2() {
		logger.info(" APARTADO DE FACTURACION ");
		tapOnElement(NamesMobileElements.PROFILE_BILLING);
		waitElementVisibility(NamesMobileElements.PROFILE_INVOICING);
		tapOnElement(NamesMobileElements.PROFILE_BILLING);
		logger.info(" FINALIZA APARTADO DE FACTURACION ");

// Marketplace
		logger.info(" APARTADO MARKETPLACE ");
		tapOnElement(NamesMobileElements.PROFILE_MARKETPALCE);
		waitElementVisibility(NamesMobileElements.PROFILE_MARKETPALCE);
		tapOnElement(NamesMobileElements.PROFILE_MARKETPALCE);
		logger.info(" FINALIZA APARTADO DE MARKETPLACE ");

	}

//envios 
	public void cond3() {
		logger.info(" APARTADO ENVIOS ");
		tapOnElement(NamesMobileElements.PROFILE_SHIPPING);
		waitElementVisibility(NamesMobileElements.PROFILE_COSTO);
		waitElementVisibility(NamesMobileElements.PROFILE_ENTREGA);
		waitElementVisibility(NamesMobileElements.PROFILE_HORARIO);
		tapOnElement(NamesMobileElements.PROFILE_SHIPPING);
		logger.info(" FINALIZA APARTADO MARKETPLACE ");

		// seguridad
		logger.info(" APARTADO SEGURIDAD ");
		tapOnElement(NamesMobileElements.PROFILE_SEGURIDAD_PRIVACIDAD);
		waitElementVisibility(NamesMobileElements.PROFILE_POLITICA);
		waitElementVisibility(NamesMobileElements.PROFILE_TERM);
		tapOnElement(NamesMobileElements.PROFILE_SEGURIDAD_PRIVACIDAD);
		logger.info("  FINALIZA APARTADO SEGURIDAD ");

	}

///pagos
	public void cond4() {
		logger.info(" APARTADO PAGOS");
		tapOnElement(NamesMobileElements.PROFILE_PAGOS);
		waitElementVisibility(NamesMobileElements.PROFILE_FORMAS);
		// waitElementVisibility(NamesMobileElements.PAGO_SEGURO);
		waitElementVisibility(NamesMobileElements.PROFILE_TARJETAWALLET);
		waitElementVisibility(NamesMobileElements.PROFILE_THRED);
		waitElementVisibility(NamesMobileElements.PROFILE_PAYPAL);
		waitElementVisibility(NamesMobileElements.PROFILE_BBVA);
		waitElementVisibility(NamesMobileElements.PROFILE_CITI);
		waitElementVisibility(NamesMobileElements.PROFILE_TARJETA);
		tapOnElement(NamesMobileElements.PROFILE_PAGOS);
		logger.info(" APARTADO finaliza PAGOS ");

		/// preguntas frecunetes
		logger.info(" APARTADO PREGUNTAS FRECUENTES ");
		tapOnElement(NamesMobileElements.PROFILE_QUESTION);
		waitElementVisibility(NamesMobileElements.PROFILE_QUESTION);
		tapOnElement(NamesMobileElements.PROFILE_QUESTION);
		logger.info("FINALIZA APARTADO PREGUNTAS FRECUENTES ");

//Tucuenta
		logger.info(" APARTADO TU CUENTA");
		tapOnElement(NamesMobileElements.PROFILE_TUCUENTA);
		waitElementVisibility(NamesMobileElements.PROFILE_P1);
		waitElementVisibility(NamesMobileElements.PROFILE_P2);
		waitElementVisibility(NamesMobileElements.PROFILE_P3);
		waitElementVisibility(NamesMobileElements.PROFILE_P4);
		waitElementVisibility(NamesMobileElements.PROFILE_P5);
		tapOnElement(NamesMobileElements.PROFILE_TUCUENTA);
		logger.info(" FINALIZA APARTADO TU CUENTA");

// tus pedidos 
		logger.info(" APARTADO TUSPEDIDOS");
		tapOnElement(NamesMobileElements.PROFILE_TUSPEDIDOS);
		waitElementVisibility(NamesMobileElements.PROFILE_COMPRAR);
		waitElementVisibility(NamesMobileElements.PROFILE_INVITADO);
		waitElementVisibility(NamesMobileElements.PROFILE_PEDIDO);
		waitElementVisibility(NamesMobileElements.PROFILE_ENVIO);
		waitElementVisibility(NamesMobileElements.PROFILE_RASPEIDOS);
		waitElementVisibility(NamesMobileElements.PROFILE_HISTPEIDOS);
		tapOnElement(NamesMobileElements.PROFILE_TUSPEDIDOS);
		logger.info(" FINALIZA APARTADO TUS PEDIDOS ");

	}
}
