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
		tapOnElement(NamesMobileElements.RET);
		general.validateElement(NamesMobileElements.HOW);
		general.validateElement(NamesMobileElements.WAR);
		general.validateElement(NamesMobileElements.CAN);
		tapOnElement(NamesMobileElements.RET);
		
//precio /promociones
		tapOnElement(NamesMobileElements.PRECIO);
		 general.validateElement(NamesMobileElements.PRECIO_BAJOS);
	      general.validateElement(NamesMobileElements.ARTICULOS);
	      general.validateElement(NamesMobileElements.COMPRASGRANEL);
		  general.validateElement(NamesMobileElements.LINVENTARIO);
		  general.validateElement(NamesMobileElements.INF_CONTENIDOS);
		  tapOnElement(NamesMobileElements.PRECIO);
	}
//compras
	public void cond2() { 
		tapOnElement(NamesMobileElements.BILLING);
		general.validateElement(NamesMobileElements.INVOICING);
		tapOnElement(NamesMobileElements.BILLING);
// Marketplace
		tapOnElement(NamesMobileElements.MARKETPALCE);
		general.validateElement(NamesMobileElements.MARKETPALCE);
		tapOnElement(NamesMobileElements.MARKETPALCE);
			
	}
//envios 
	public void cond3() {
		    tapOnElement(NamesMobileElements.SHIPPING);
			general.validateElement(NamesMobileElements.COSTO);
			general.validateElement(NamesMobileElements.ENTREGA);
			general.validateElement(NamesMobileElements.HORARIO);
		    tapOnElement(NamesMobileElements.SHIPPING);
		    //seguridad
		    tapOnElement(NamesMobileElements.SEGURIDAD_PRIVACIDAD);
		    general.validateElement(NamesMobileElements.POLITICA);
			general.validateElement(NamesMobileElements.TERM);
		    tapOnElement(NamesMobileElements.SEGURIDAD_PRIVACIDAD);
		
	}		
	
///pagos
	public void   cond4() {
	      tapOnElement(NamesMobileElements.PAGOS);
       	  general.validateElement(NamesMobileElements.FORMAS);
	    //  general.validateElement(NamesMobileElements.PAGO_SEGURO);
	      general.validateElement(NamesMobileElements.TARJETAWALLET);
	      general.validateElement(NamesMobileElements.THRED);
		  general.validateElement(NamesMobileElements.PAYPAL);
		  general.validateElement(NamesMobileElements.BBVA);
		  general.validateElement(NamesMobileElements.CITI);
		 general.validateElement(NamesMobileElements.TARJETA);
	      tapOnElement(NamesMobileElements.PAGOS);

 ///preguntas frecunetes
		   tapOnElement(NamesMobileElements.QUESTION); 
		   general.validateElement(NamesMobileElements.QUESTION);
		   tapOnElement(NamesMobileElements.QUESTION); 
//Tucuenta
		   tapOnElement(NamesMobileElements.TUCUENTA); 
		   general.validateElement(NamesMobileElements.P1);
		   general.validateElement(NamesMobileElements.P2);
		   general.validateElement(NamesMobileElements.P3);
		   general.validateElement(NamesMobileElements.P4);
		   general.validateElement(NamesMobileElements.P5);
		   tapOnElement(NamesMobileElements.TUCUENTA); 
// tus pedidos 
		   tapOnElement(NamesMobileElements.TUSPEDIDOS); 
		   general.validateElement(NamesMobileElements.COMPRAR);
		   general.validateElement(NamesMobileElements.INVITADO);
		 general.validateElement(NamesMobileElements.PEDIDO);
		  general.validateElement(NamesMobileElements.ENVIO);
		 general.validateElement(NamesMobileElements.RASPEIDOS);
		   general.validateElement(NamesMobileElements.HISTPEIDOS);
		   tapOnElement(NamesMobileElements.TUSPEDIDOS); 

		   

		   
		   
	}	

	
}	

		


	    
		
	    
		
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	



