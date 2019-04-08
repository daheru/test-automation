package com.walmartmg.business.iOS;

import org.apache.log4j.Logger;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.util.BaseDriver;

public class HomeBussinesTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(HomeBussinesTest.class);

	private GeneralBusinessTest general = new GeneralBusinessTest();

	// classe entera para seleccionar los 3 elementos del menu
	public void selectMenu(int menu) {
		general.selectNavigationOption(menu);
	}

	public void validateSearchPage() {
		logger.info("Validacion de buscador");
		// VALIDACION DE BUSCADOR
		waitVisibility(NamesMobileElements.HOME_BUSCADOR);
		tapOnElement(NamesMobileElements.HOME_BUSCADOR);
		waitVisibility(NamesMobileElements.HOME_CANCELAR);
		tapOnElement(NamesMobileElements.HOME_CANCELAR);
		waitVisibility(NamesMobileElements.HOME_BUSCADOR);
		logger.info("Validacion del carrito de comrpas");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		waitVisibility(NamesMobileElements.HOME_CLOSED);
		tapOnElement(NamesMobileElements.HOME_CLOSED);
		waitVisibility(NamesMobileElements.HOME_COMPRAS);
		logger.info("Validacion de  ofertas relampago y un producto");
		waitVisibility(NamesMobileElements.HOME_OFERTAS_RELAMPAGO);
		tapOnElement(NamesMobileElements.HOME_ELEMENTO_OFER1);
		waitVisibility(NamesMobileElements.HOME_ELEMENTO_OFER1);

	}

	public void searchProduct(String producto) {
		logger.info("Validacion de un producto valido");
		waitVisibility(NamesMobileElements.HOME_BUSCADOR);
		tapOnElement(NamesMobileElements.HOME_BUSCADOR);
		fillElement(NamesMobileElements.HOME_BUSCADOR, producto + "\n");

	}

	public void validateSearch() {
		logger.info("Validacion de un producto valido");
		waitVisibility(NamesMobileElements.HOME_MENSAGE_VALIDATE);
		general.validateElement(NamesMobileElements.HOME_MENSAGE_VALIDATE);
	}

	public void validateEmptySearch() {
		logger.info("Validacion de producto Invalido");
		waitVisibility(NamesMobileElements.HOME_BUSCADOR_0);
	}

	public void Cp007_Validate_Empty_cart() {
		// validacion de carrito de compra Vacio
		logger.info(" validacion del carrito de compra Vacio");
		tapOnElement(NamesMobileElements.HOME_BUTTON_ADD_CAR);
		waitVisibility(NamesMobileElements.HOME_NOT_ARTICULO);
	}

	public void Cp008_Validate_Lightning_Offer_Add_product() {
		// agregar producto
		logger.info("  agregar producto de Ofertas relampago");
		waitVisibility(NamesMobileElements.HOME_OF1);
		tapOnElement(NamesMobileElements.HOME_OF1);
		general.validateElement(NamesMobileElements.HOME_OF1);
		logger.info("  selecciona prododucto producto");
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info("se agrega producto de las ofertas relampag");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/se agrgega el mismo producto 2 veces/");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		waitVisibility(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS2);
	}

	public void Cp009Search_Add_Product(String producto) {
		logger.info("Validacion de un producto valido");
		waitVisibility(NamesMobileElements.HOME_BUSCADOR);
		tapOnElement(NamesMobileElements.HOME_BUSCADOR);
		fillElement(NamesMobileElements.HOME_BUSCADOR, producto + "\n");
		logger.info("  selecciona prododucto producto");
		waitVisibility(NamesMobileElements.HOME_SELECT_PRODUCTO);
		tapOnElement(NamesMobileElements.HOME_SELECT_PRODUCTO);
		logger.info("se agrega producto ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		// logger.info("/se valida el mensaje /");
		// waitVisibility(NamesMobileElements.);
		// FALTA NO DEJA TAP BUTTON

	}

	public void Cp011_Remove_product_from_() {
		// agregar producto
		logger.info(" Selecionar  x producto ");
		waitVisibility(NamesMobileElements.HOME_OF1);
		tapOnElement(NamesMobileElements.HOME_OF1);
		general.validateElement(NamesMobileElements.HOME_OF1);
		logger.info("  selecciona  producto de interes ");
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/se agrgega el mismo producto por segunda  vez/");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		waitVisibility(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS2);
		logger.info("/se elimina producto  agregado  /");
		waitVisibility(NamesMobileElements.HOME_AGREGAR_MENOS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MENOS_PRODUCTOS);
		logger.info("/se elimina producto  agregado por segunda vez  /");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MENOS_PRODUCTOS);
	}

	public void Cp010_Increase_product_quantity_from() {
		// agregar producto
		logger.info(" Selecionar  x producto ");
		waitVisibility(NamesMobileElements.HOME_OF1);
		tapOnElement(NamesMobileElements.HOME_OF1);
		general.validateElement(NamesMobileElements.HOME_OF1);
		logger.info("  selecciona  producto de interes ");
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/se agrgega el mismo producto por segunda  vez/");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		waitVisibility(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS2);
	}
	
	public void CP012_Validate_Cart_with_one_or_several_products_added() {
		logger.info("  selecciona  producto de interes ");
		waitVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida  BOTTON DE ELIMINAR /");
		general.validateElement(NamesMobileElements.HOME_BUTTON_ELIMINAR);
		logger.info("/SE VALIDA EL TOTAL  DE LACOMPRA /");
		general.validateElement(NamesMobileElements.HOME_SUB_TOTAL);	
		logger.info("/se valida el que aparezca el boton de continuar comprando /");
		general.validateElement(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		logger.info("FINALIZANDO CASO DE PRUEBA ");
		
	}
	public void CP013Validate_Cart_Remove_product() {
		logger.info("  selecciona  producto de interes ");
		waitVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida  BOTTON DE ELIMINAR /");
		logger.info("/se elimina producto seleccionado  /");
		waitVisibility(NamesMobileElements.HOME_BUTTON_ELIMINAR);
		tapOnElement(NamesMobileElements.HOME_BUTTON_ELIMINAR);
		logger.info("/se valida que no hay producto en el carrito de compras/");
		general.validateElement(NamesMobileElements.HOME_IMAGEN_CARTARE_ARTICULES);	
		
	}
	public void CP014Validate_Cart_Button() {
		logger.info("  selecciona  producto de interes ");
		waitVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida el que aparezca el boton de continuar comprando /");
		waitVisibility(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		tapOnElement(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		logger.info("se valida que salga la pantalla el boton de iniciar sesion  ");
		general.validateElement(NamesMobileElements.LOGIN_BUTTON);
		logger.info("se valida que Aparesca correo y password ");
		general.validateElement(NamesMobileElements.LOGIN_BUTTON);
		
		

	
	}

}
