package com.walmartmg.iOS;


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
		tapOnElement(NamesMobileElements.Returns);
		general.validateElement(NamesMobileElements.How_to_make_return);
		general.validateElement(NamesMobileElements.Warranty);
		general.validateElement(NamesMobileElements.Canceld);
		tapOnElement(NamesMobileElements.Returns);
		
//precio /promociones
		tapOnElement(NamesMobileElements.Precio_promociones);
		 general.validateElement(NamesMobileElements.precios_bajos);
	      general.validateElement(NamesMobileElements.articulos);
	      general.validateElement(NamesMobileElements.ComprasGRanel);
		  general.validateElement(NamesMobileElements.Limitacionesdeinventario);
		  general.validateElement(NamesMobileElements.Inf_precios_contenidos);
		  tapOnElement(NamesMobileElements.Precio_promociones);
	}
//compras
	public void cond2() { 
		tapOnElement(NamesMobileElements.Billing);
		general.validateElement(NamesMobileElements.invoicing);
		tapOnElement(NamesMobileElements.Billing);
// Marketplace
		tapOnElement(NamesMobileElements.MArketplace);
		general.validateElement(NamesMobileElements.MArketplace);
		tapOnElement(NamesMobileElements.MArketplace);
			
	}
//envios 
	public void cond3() {
		    tapOnElement(NamesMobileElements.Shipping);
			general.validateElement(NamesMobileElements.costo);
			general.validateElement(NamesMobileElements.entrega);
			general.validateElement(NamesMobileElements.Horario);
		    tapOnElement(NamesMobileElements.Shipping);
		    //seguridad
		    tapOnElement(NamesMobileElements.Seguridad_Privacidad);
		    general.validateElement(NamesMobileElements.politica);
			general.validateElement(NamesMobileElements.term);
		    tapOnElement(NamesMobileElements.Seguridad_Privacidad);
		
	}		
	
///pagos
	public void   cond4() {
	      tapOnElement(NamesMobileElements.Pagos);
       	  general.validateElement(NamesMobileElements.formas);
	      general.validateElement(NamesMobileElements.tarjetaWallet);
	      general.validateElement(NamesMobileElements.threD);
		  general.validateElement(NamesMobileElements.Paypal);
		  general.validateElement(NamesMobileElements.BBVA);
		  general.validateElement(NamesMobileElements.CITI);
		 general.validateElement(NamesMobileElements.Tarjeta);
	      tapOnElement(NamesMobileElements.Pagos);

 ///preguntas frecunetes
		   tapOnElement(NamesMobileElements.Question); 
		   general.validateElement(NamesMobileElements.Question);
		   tapOnElement(NamesMobileElements.Question); 
//Tucuenta
		   tapOnElement(NamesMobileElements.Tucuenta); 
		   general.validateElement(NamesMobileElements.pregunta1);
		   general.validateElement(NamesMobileElements.pregunta2);
		   general.validateElement(NamesMobileElements.pregunta3);
		   general.validateElement(NamesMobileElements.pregunta4);
		   general.validateElement(NamesMobileElements.pregunta4);
		   tapOnElement(NamesMobileElements.Tucuenta); 
// tus pedidos 
		   tapOnElement(NamesMobileElements.TusPedidos); 
		   general.validateElement(NamesMobileElements.comprar);
		   tapOnElement(NamesMobileElements.TusPedidos); 

		   

		   
		   
	}	

	
}	

		


	    
		
	    
		
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	



