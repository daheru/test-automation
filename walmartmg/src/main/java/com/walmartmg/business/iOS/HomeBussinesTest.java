package com.walmartmg.business.iOS;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;

public class HomeBussinesTest extends BaseDriver {

	public GeneralBusinessTest general = new GeneralBusinessTest();

	// classe entera para seleccionar los 3 elementos del menu
	public void selectMenu(int menu) {

		general.selectNavigationOption(menu);

	}

	public void validate() {
		// VALIDACION DE BUSCADOR
		tapOnElement(NamesMobileElements.BUSCADOR);
		waitElementVisibility(NamesMobileElements.CANCELAR);
		tapOnElement(NamesMobileElements.CANCELAR);
		waitElementVisibility(NamesMobileElements.BUSCADOR);
		// VALIDACION DE CARITOCOMPRAS
		tapOnElement(NamesMobileElements.COMPRAS);
		waitElementVisibility(NamesMobileElements.CLOSED);
		tapOnElement(NamesMobileElements.CLOSED);
		waitElementVisibility(NamesMobileElements.COMPRAS);
		// VALIDACIO DE OFERTAS RELAMPAGO Y UN ELEMENTO
		waitElementVisibility(NamesMobileElements.OFERTAS_RELAMPAGO);
		tapOnElement(NamesMobileElements.ELEMENTO_OFER1);
		waitElementVisibility(NamesMobileElements.ELEMENTO_OFER1);

	}

	public void vaCp002() {
		// VALIDACION DE BUSCADOR PRODUCTO VALIDO
		tapOnElement(NamesMobileElements.BUSCADOR);
		fillElement(NamesMobileElements.BUSCADOR, "pantalla 55 4k " + "\n");

	}

	public void cp003() {
		// VALIDACION DE BUSCADOR PRODUCTO INVALIDO
		tapOnElement(NamesMobileElements.BUSCADOR);
		fillElement(NamesMobileElements.BUSCADOR, "MAYONESA " + "\n");
		// VALIDACION DE PRODUCTO INVALIDO
		waitElementVisibility(NamesMobileElements.BUSCADOR_0);
	}

	public void cp007() {
		// validacion de carrito de compra Vacio
		tapOnElement(NamesMobileElements.BUTTON_ADD_CAR);
		waitElementVisibility(NamesMobileElements.NOT_ARTICULO);
	}

	public void Cp008() {
		// agregar producto

		tapOnElement(NamesMobileElements.OF1);
		waitElementVisibility(NamesMobileElements.OF1);
		tapOnElement(NamesMobileElements.PRODT);
		// se agrega producto de las ofertas relampago
		tapOnElement(NamesMobileElements.AGREGAR_COMPRA);
		// validacion de agregar producto
		waitElementVisibility(NamesMobileElements.PRODUCT_AGREGADO);
		// se agrgega el mismo producto 2 veces
		tapOnElement(NamesMobileElements.AGREGAR_MAS_PRODUCTOS);
		tapOnElement(NamesMobileElements.AGREGAR_MAS_PRODUCTOS);
		waitElementVisibility(NamesMobileElements.AGREGAR_MAS_PRODUCTOS2);

	}

}
