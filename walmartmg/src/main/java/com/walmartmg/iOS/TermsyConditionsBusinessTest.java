package com.walmartmg.iOS;


import org.junit.Assert;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;
import com.walmartmg.util.PropertiesValuesUtil;
	

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
		tapOnElement(MobileNamesConstants.Returns);
		general.validateElement(MobileNamesConstants.How_to_make_return);
		general.validateElement(MobileNamesConstants.Warranty);
		general.validateElement(MobileNamesConstants.Canceld);
		tapOnElement(MobileNamesConstants.Returns);
		
//precio /promociones
		tapOnElement(MobileNamesConstants.Precio_promociones);
		 general.validateElement(MobileNamesConstants.precios_bajos);
	      general.validateElement(MobileNamesConstants.articulos);
	      general.validateElement(MobileNamesConstants.ComprasGRanel);
		  general.validateElement(MobileNamesConstants.Limitacionesdeinventario);
		  general.validateElement(MobileNamesConstants.Inf_precios_contenidos);
		  tapOnElement(MobileNamesConstants.Precio_promociones);
	}
//compras
	public void cond2() { 
		tapOnElement(MobileNamesConstants.Billing);
		general.validateElement(MobileNamesConstants.invoicing);
		tapOnElement(MobileNamesConstants.Billing);
// Marketplace
		tapOnElement(MobileNamesConstants.MArketplace);
		general.validateElement(MobileNamesConstants.MArketplace);
		tapOnElement(MobileNamesConstants.MArketplace);
			
	}
//envios 
	public void cond3() {
		    tapOnElement(MobileNamesConstants.Shipping);
			general.validateElement(MobileNamesConstants.costo);
			general.validateElement(MobileNamesConstants.entrega);
			general.validateElement(MobileNamesConstants.Horario);
		    tapOnElement(MobileNamesConstants.Shipping);
		    //seguridad
		    tapOnElement(MobileNamesConstants.Seguridad_Privacidad);
		    general.validateElement(MobileNamesConstants.politica);
			general.validateElement(MobileNamesConstants.term);
		    tapOnElement(MobileNamesConstants.Seguridad_Privacidad);
		
	}		
	
///pagos
	public void   cond4() {
	      tapOnElement(MobileNamesConstants.Pagos);
       	  general.validateElement(MobileNamesConstants.formas);
	      general.validateElement(MobileNamesConstants.tarjetaWallet);
	      general.validateElement(MobileNamesConstants.threD);
		  general.validateElement(MobileNamesConstants.Paypal);
		  general.validateElement(MobileNamesConstants.BBVA);
		  general.validateElement(MobileNamesConstants.CITI);
		 general.validateElement(MobileNamesConstants.Tarjeta);
	      tapOnElement(MobileNamesConstants.Pagos);

 ///preguntas frecunetes
		   tapOnElement(MobileNamesConstants.Question); 
		   general.validateElement(MobileNamesConstants.Question);
		   tapOnElement(MobileNamesConstants.Question); 
//Tucuenta
		   tapOnElement(MobileNamesConstants.Tucuenta); 
		   general.validateElement(MobileNamesConstants.pregunta1);
		   general.validateElement(MobileNamesConstants.pregunta2);
		   general.validateElement(MobileNamesConstants.pregunta3);
		   general.validateElement(MobileNamesConstants.pregunta4);
		   general.validateElement(MobileNamesConstants.pregunta4);
		   tapOnElement(MobileNamesConstants.Tucuenta); 
// tus pedidos 
		   tapOnElement(MobileNamesConstants.TusPedidos); 
		   general.validateElement(MobileNamesConstants.comprar);
		   tapOnElement(MobileNamesConstants.TusPedidos); 

		   

		   
		   
	}	

	
}	

		


	    
		
	    
		
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	



