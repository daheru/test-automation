package com.walmartmg.iOS;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

public class HomeBussinesTest extends BaseDriver {

	public GeneralBusinessTest general = new GeneralBusinessTest();

	//  classe entera para  seleccionar los 3  elementos del menu
	public void selectMenu(int menu) {
		
		general.selectNavigationOption(menu);

	}

	public void validate() {
		// VALIDACION DE BUSCADOR
		tapOnElement(NamesMobileElements.BUSCADOR);
		waitVisibility(NamesMobileElements.CANCELAR);
		tapOnElement(NamesMobileElements.CANCELAR);
		general.validateElement(NamesMobileElements.BUSCADOR);
		// VALIDACION DE CARITOCOMPRAS
		tapOnElement(NamesMobileElements.COMPRAS);
		waitVisibility(NamesMobileElements.CLOSED);
		tapOnElement(NamesMobileElements.CLOSED);
		general.validateElement(NamesMobileElements.COMPRAS);
        //VALIDACIO DE OFERTAS RELAMPAGO Y UN ELEMENTO 
		general.validateElement(NamesMobileElements.OFERTAS_RELAMPAGO);
		tapOnElement(NamesMobileElements.ELEMENTO_OFER1);
		general.validateElement(NamesMobileElements.ELEMENTO_OFER1);

	}

	public void vaCp002() {
		// VALIDACION DE BUSCADOR PRODUCTO VALIDO 
			tapOnElement(NamesMobileElements.BUSCADOR);
		    fillElement(NamesMobileElements.BUSCADOR, "pantalla 55 4k "+"\n");
		   
	
	}
	
	public void  cp003() {
		//VALIDACION DE BUSCADOR PRODUCTO INVALIDO
		tapOnElement(NamesMobileElements.BUSCADOR);
	    fillElement(NamesMobileElements.BUSCADOR, "MAYONESA "+"\n");
	 //   VALIDACION DE PRODUCTO INVALIDO 
	    waitVisibility(NamesMobileElements.BUSCADOR_0);
	}
    public void cp007() {
    	//validacion de carrito de compra Vacio 
    	tapOnElement(NamesMobileElements.BUTTON_ADD_CAR);
	    waitVisibility(NamesMobileElements.NOT_ARTICULO);
    }

   public void Cp008() {
	   // agregar  producto 
	   
	   tapOnElement(NamesMobileElements.OF1);
		general.validateElement(NamesMobileElements.OF1);
		  tapOnElement(NamesMobileElements.PRODT);
		  // se agrega producto de las ofertas relampago 
		  tapOnElement(NamesMobileElements.AGREGAR_COMPRA);
		  //validacion de agregar producto
		  waitVisibility(NamesMobileElements.PRODUCT_AGREGADO);
		  // se agrgega el mismo producto 2 veces
	      tapOnElement(NamesMobileElements.AGREGAR_MAS_PRODUCTOS);
	      tapOnElement(NamesMobileElements.AGREGAR_MAS_PRODUCTOS);
		  waitVisibility(NamesMobileElements.AGREGAR_MAS_PRODUCTOS2);




   }
    

}
