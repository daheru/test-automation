package com.walmartmg.business.iOS;


import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;
	

public class TermsyConditionsBusinessTest   extends BaseDriver{
	
	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
		
	}
	public void selectMenu() {
		general.selectProfileMenu(ProfileMenuEnum.TERMS.getMenu());
		
	}

	
//devoluciones 
	public void cond() {
		tapOnElement(NamesMobileElements.RET);
		waitElementVisibility(NamesMobileElements.HOW);
		waitElementVisibility(NamesMobileElements.WAR);
		waitElementVisibility(NamesMobileElements.CAN);
		tapOnElement(NamesMobileElements.RET);
		
//precio /promociones
		tapOnElement(NamesMobileElements.PRECIO);
		 waitElementVisibility(NamesMobileElements.PRECIO_BAJOS);
	      waitElementVisibility(NamesMobileElements.ARTICULOS);
	      waitElementVisibility(NamesMobileElements.COMPRASGRANEL);
		  waitElementVisibility(NamesMobileElements.LINVENTARIO);
		  waitElementVisibility(NamesMobileElements.INF_CONTENIDOS);
		  tapOnElement(NamesMobileElements.PRECIO);
	}
//compras
	public void cond2() { 
		tapOnElement(NamesMobileElements.BILLING);
		waitElementVisibility(NamesMobileElements.INVOICING);
		tapOnElement(NamesMobileElements.BILLING);
// Marketplace
		tapOnElement(NamesMobileElements.MARKETPALCE);
		waitElementVisibility(NamesMobileElements.MARKETPALCE);
		tapOnElement(NamesMobileElements.MARKETPALCE);
			
	}
//envios 
	public void cond3() {
		    tapOnElement(NamesMobileElements.SHIPPING);
			waitElementVisibility(NamesMobileElements.COSTO);
			waitElementVisibility(NamesMobileElements.ENTREGA);
			waitElementVisibility(NamesMobileElements.HORARIO);
		    tapOnElement(NamesMobileElements.SHIPPING);
		    //seguridad
		    tapOnElement(NamesMobileElements.SEGURIDAD_PRIVACIDAD);
		    waitElementVisibility(NamesMobileElements.POLITICA);
			waitElementVisibility(NamesMobileElements.TERM);
		    tapOnElement(NamesMobileElements.SEGURIDAD_PRIVACIDAD);
		
	}		
	
///pagos
	public void   cond4() {
	      tapOnElement(NamesMobileElements.PAGOS);
       	  waitElementVisibility(NamesMobileElements.FORMAS);
	    //  waitElementVisibility(NamesMobileElements.PAGO_SEGURO);
	      waitElementVisibility(NamesMobileElements.TARJETAWALLET);
	      waitElementVisibility(NamesMobileElements.THRED);
		  waitElementVisibility(NamesMobileElements.PAYPAL);
		  waitElementVisibility(NamesMobileElements.BBVA);
		  waitElementVisibility(NamesMobileElements.CITI);
		 waitElementVisibility(NamesMobileElements.TARJETA);
	      tapOnElement(NamesMobileElements.PAGOS);

 ///preguntas frecunetes
		   tapOnElement(NamesMobileElements.QUESTION); 
		   waitElementVisibility(NamesMobileElements.QUESTION);
		   tapOnElement(NamesMobileElements.QUESTION); 
//Tucuenta
		   tapOnElement(NamesMobileElements.TUCUENTA); 
		   waitElementVisibility(NamesMobileElements.P1);
		   waitElementVisibility(NamesMobileElements.P2);
		   waitElementVisibility(NamesMobileElements.P3);
		   waitElementVisibility(NamesMobileElements.P4);
		   waitElementVisibility(NamesMobileElements.P5);
		   tapOnElement(NamesMobileElements.TUCUENTA); 
// tus pedidos 
		   tapOnElement(NamesMobileElements.TUSPEDIDOS); 
		   waitElementVisibility(NamesMobileElements.COMPRAR);
		   waitElementVisibility(NamesMobileElements.INVITADO);
		 waitElementVisibility(NamesMobileElements.PEDIDO);
		  waitElementVisibility(NamesMobileElements.ENVIO);
		 waitElementVisibility(NamesMobileElements.RASPEIDOS);
		   waitElementVisibility(NamesMobileElements.HISTPEIDOS);
		   tapOnElement(NamesMobileElements.TUSPEDIDOS); 

		   

		   
		   
	}	

	
}	

		


	    
		
	    
		
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	



