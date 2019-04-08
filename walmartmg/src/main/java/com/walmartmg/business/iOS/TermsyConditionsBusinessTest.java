package com.walmartmg.business.iOS;


import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenuOptionsEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;
	

public class TermsyConditionsBusinessTest   extends BaseDriver{
	
	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
		
	}
	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.TERMS.getMenu());
		
	}

	
//devoluciones 
	public void cond() {
		tapOnElement(NamesMobileElements.PROFILE_RET);
		general.validateElement(NamesMobileElements.PROFILE_HOW);
		general.validateElement(NamesMobileElements.PROFILE_WAR);
		general.validateElement(NamesMobileElements.PROFILE_CAN);
		tapOnElement(NamesMobileElements.PROFILE_RET);
		
//precio /promociones
		tapOnElement(NamesMobileElements.PROFILE_PRECIO);
		 general.validateElement(NamesMobileElements.PROFILE_PRECIO_BAJOS);
	      general.validateElement(NamesMobileElements.PROFILE_ARTICULOS);
	      general.validateElement(NamesMobileElements.PROFILE_COMPRASGRANEL);
		  general.validateElement(NamesMobileElements.PROFILE_LINVENTARIO);
		  general.validateElement(NamesMobileElements.PROFILE_INF_CONTENIDOS);
		  tapOnElement(NamesMobileElements.PROFILE_PRECIO);
	}
//compras
	public void cond2() { 
		tapOnElement(NamesMobileElements.PROFILE_BILLING);
		general.validateElement(NamesMobileElements.PROFILE_INVOICING);
		tapOnElement(NamesMobileElements.PROFILE_BILLING);
// Marketplace
		tapOnElement(NamesMobileElements.PROFILE_MARKETPALCE);
		general.validateElement(NamesMobileElements.PROFILE_MARKETPALCE);
		tapOnElement(NamesMobileElements.PROFILE_MARKETPALCE);
			
	}
//envios 
	public void cond3() {
		    tapOnElement(NamesMobileElements.PROFILE_SHIPPING);
			general.validateElement(NamesMobileElements.PROFILE_COSTO);
			general.validateElement(NamesMobileElements.PROFILE_ENTREGA);
			general.validateElement(NamesMobileElements.PROFILE_HORARIO);
		    tapOnElement(NamesMobileElements.PROFILE_SHIPPING);
		    //seguridad
		    tapOnElement(NamesMobileElements.PROFILE_SEGURIDAD_PRIVACIDAD);
		    general.validateElement(NamesMobileElements.PROFILE_POLITICA);
			general.validateElement(NamesMobileElements.PROFILE_TERM);
		    tapOnElement(NamesMobileElements.PROFILE_SEGURIDAD_PRIVACIDAD);
		
	}		
	
///pagos
	public void   cond4() {
	      tapOnElement(NamesMobileElements.PROFILE_PAGOS);
       	  general.validateElement(NamesMobileElements.PROFILE_FORMAS);
	    //  general.validateElement(NamesMobileElements.PAGO_SEGURO);
	      general.validateElement(NamesMobileElements.PROFILE_TARJETAWALLET);
	      general.validateElement(NamesMobileElements.PROFILE_THRED);
		  general.validateElement(NamesMobileElements.PROFILE_PAYPAL);
		  general.validateElement(NamesMobileElements.PROFILE_BBVA);
		  general.validateElement(NamesMobileElements.PROFILE_CITI);
		 general.validateElement(NamesMobileElements.PROFILE_TARJETA);
	      tapOnElement(NamesMobileElements.PROFILE_PAGOS);

 ///preguntas frecunetes
		   tapOnElement(NamesMobileElements.PROFILE_QUESTION); 
		   general.validateElement(NamesMobileElements.PROFILE_QUESTION);
		   tapOnElement(NamesMobileElements.PROFILE_QUESTION); 
//Tucuenta
		   tapOnElement(NamesMobileElements.PROFILE_TUCUENTA); 
		   general.validateElement(NamesMobileElements.PROFILE_P1);
		   general.validateElement(NamesMobileElements.PROFILE_P2);
		   general.validateElement(NamesMobileElements.PROFILE_P3);
		   general.validateElement(NamesMobileElements.PROFILE_P4);
		   general.validateElement(NamesMobileElements.PROFILE_P5);
		   tapOnElement(NamesMobileElements.PROFILE_TUCUENTA); 
// tus pedidos 
		   tapOnElement(NamesMobileElements.PROFILE_TUSPEDIDOS); 
		   general.validateElement(NamesMobileElements.PROFILE_COMPRAR);
		   general.validateElement(NamesMobileElements.PROFILE_INVITADO);
		 general.validateElement(NamesMobileElements.PROFILE_PEDIDO);
		  general.validateElement(NamesMobileElements.PROFILE_ENVIO);
		 general.validateElement(NamesMobileElements.PROFILE_RASPEIDOS);
		   general.validateElement(NamesMobileElements.PROFILE_HISTPEIDOS);
		   tapOnElement(NamesMobileElements.PROFILE_TUSPEDIDOS); 

		   

		   
		   
	}	

	
}	

		


	    
		
	    
		
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	



