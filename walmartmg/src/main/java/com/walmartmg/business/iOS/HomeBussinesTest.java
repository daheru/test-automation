package com.walmartmg.business.iOS;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;

public class HomeBussinesTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(HomeBussinesTest.class);

	private GeneralBusinessTest general = new GeneralBusinessTest();

	// classe entera para seleccionar los 3 elementos del menu
	public void selectHome() {
		general.selectNavigationOption(NavigationBarEnum.HOME);
	}
	
	public void selectDepartments() {
		general.selectNavigationOption(NavigationBarEnum.DEPARTMENTS);
	}

	public void validateSearchPage() {
		logger.info("Validacion de buscador");
		// VALIDACION DE BUSCADOR
		waitElementVisibility(NamesMobileElements.HOME_BUSCADOR);
		tapOnElement(NamesMobileElements.HOME_BUSCADOR);
		waitElementVisibility(NamesMobileElements.HOME_CANCELAR);
		tapOnElement(NamesMobileElements.HOME_CANCELAR);
		waitElementVisibility(NamesMobileElements.HOME_BUSCADOR);
		logger.info("Validacion del carrito de comrpas");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		waitElementVisibility(NamesMobileElements.HOME_CLOSED);
		tapOnElement(NamesMobileElements.HOME_CLOSED);
		waitElementVisibility(NamesMobileElements.HOME_COMPRAS);
		logger.info("Validacion de  ofertas relampago y un producto");
		waitElementVisibility(NamesMobileElements.HOME_OFERTAS_RELAMPAGO);
		tapOnElement(NamesMobileElements.HOME_ELEMENTO_OFER1);
		waitElementVisibility(NamesMobileElements.HOME_ELEMENTO_OFER1);

	}

	public void searchProduct(String producto) {
		logger.info("Validacion de un producto ");
		waitElementVisibility(NamesMobileElements.HOME_BUSCADOR);
		tapOnElement(NamesMobileElements.HOME_BUSCADOR);
		fillElement(NamesMobileElements.HOME_BUSCADOR, producto + "\n");

	}

	public void validateSearch() {
		logger.info("Validacion de un producto valido");
		waitElementVisibility(NamesMobileElements.HOME_MENSAGE_VALIDATE);
		waitElementVisibility(NamesMobileElements.HOME_MENSAGE_VALIDATE);
	}

	public void validateEmptySearchProduct() {
		logger.info("Validacion de producto Invalido");
		waitElementVisibility(NamesMobileElements.HOME_BUSCADOR_0);
	}

	public void validate_Empty_cart() {
		// validacion de carrito de compra Vacio
		logger.info(" validacion del carrito de compra Vacio");
		tapOnElement(NamesMobileElements.HOME_BUTTON_ADD_CAR);
		waitElementVisibility(NamesMobileElements.HOME_NOT_ARTICULO);
	}

	public void validate_Lightning_Offer_Add_product() {
		// agregar producto
		logger.info("  agregar producto de Ofertas relampago");
		waitElementVisibility(NamesMobileElements.HOME_OF1);
		tapOnElement(NamesMobileElements.HOME_OF1);
		waitElementVisibility(NamesMobileElements.HOME_OF1);
		logger.info("  selecciona prododucto producto");
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info("se agrega producto de las ofertas relampag");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("se ¡valida mensaje de agrego producto");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("se agrega el mismo producto 2 veces");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		logger.info(" se valida el  se gundo mensaje se actualizo el producto");
		waitElementVisibility(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS2);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);

	}

	public void search_Add_Product(String producto) {
		logger.info("Validacion de un producto valido");
		waitElementVisibility(NamesMobileElements.HOME_BUSCADOR);
		tapOnElement(NamesMobileElements.HOME_BUSCADOR);
		fillElement(NamesMobileElements.HOME_BUSCADOR, producto + "\n");
		logger.info("  selecciona prododucto producto");
		waitElementVisibility(NamesMobileElements.HOME_SELECT_BUSCADOR);
		tapOnElement(NamesMobileElements.HOME_SELECT_BUSCADOR);
		logger.info("se agrega producto ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		// logger.info("/se valida el mensaje /");
		// waitElementVisibility(NamesMobileElements.);
		// FALTA NO DEJA TAP BUTTON

	}

	public void remove_product_from_() {
		// agregar producto
		logger.info(" Selecionar  x producto ");
		waitElementVisibility(NamesMobileElements.HOME_OF1);
		tapOnElement(NamesMobileElements.HOME_OF1);
		waitElementVisibility(NamesMobileElements.HOME_OF1);
		logger.info("  selecciona  producto de interes ");
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		waitElementVisibility(NamesMobileElements.HOME_AGREGAR_COMPRA);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/se agrgega el mismo producto por segunda  vez/");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		waitElementVisibility(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS2);
		logger.info("/se elimina producto  agregado  /");
		waitElementVisibility(NamesMobileElements.HOME_AGREGAR_MENOS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MENOS_PRODUCTOS);
		logger.info("/se elimina producto  agregado por segunda vez  /");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MENOS_PRODUCTOS);
	}

	public void increase_product_quantity_from() {
		// agregar producto
		logger.info(" Selecionar  x producto ");
		waitElementVisibility(NamesMobileElements.HOME_OF1);
		tapOnElement(NamesMobileElements.HOME_OF1);
		waitElementVisibility(NamesMobileElements.HOME_OF1);
		logger.info("  selecciona  producto de interes ");
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/se agrgega el mismo producto por segunda  vez/");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS);
		waitElementVisibility(NamesMobileElements.HOME_AGREGAR_MAS_PRODUCTOS2);
	}

	public void validate_Cart_with_one_or_several_products_added() {
		logger.info("  selecciona  producto de interes ");
		waitElementVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		waitElementVisibility(NamesMobileElements.HOME_AGREGAR_COMPRA);
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida  BOTTON DE ELIMimar /");
		waitElementVisibility(NamesMobileElements.HOME_BUTTON_ELIMINAR);
		logger.info("/SE VALIDA EL TOTAL  DE LACOMPRA /");
		waitElementVisibility(NamesMobileElements.HOME_SUB_TOTAL);
		logger.info("/se valida el que aparezca el boton de continuar comprando /");
		waitElementVisibility(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		

	}

	public void validate_Cart_Remove_product() {
		logger.info("  selecciona  producto de interes ");
		waitElementVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		//waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida  BOTTON DE ELIMINAR /");
		logger.info("/se elimina producto seleccionado  /");
		waitElementVisibility(NamesMobileElements.HOME_BUTTON_ELIMINAR);
		tapOnElement(NamesMobileElements.HOME_BUTTON_ELIMINAR);
		tapOnElement(NamesMobileElements.HOME_BUTTON_ELIMINAR);
		logger.info("/se valida que no hay producto en el carrito de compras/");
		waitElementVisibility(NamesMobileElements.HOME_IMAGEN_CARTARE_ARTICULES);

	}

	public void validate_Cart_Button() {
		logger.info("  selecciona  producto de interes ");
		waitElementVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida el que aparezca el boton de continuar comprando y se da clicl en el  /");
		waitElementVisibility(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		tapOnElement(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		logger.info("se valida que salga la pantalla el boton de iniciar sesion  ");
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
		logger.info("se valida que Aparesca correo y password ");
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
	}
	
	public void Validate_secure_payment_screen(){
		logger.info("  selecciona  producto de interes ");
		waitElementVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida el que aparezca el boton de continuar comprando y se da clicl en el  /");
		waitElementVisibility(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		tapOnElement(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		logger.info("se valida que salga la pantalla pago seguro  ");
		waitElementVisibility(NamesMobileElements.SECURE_PAYMENT);
		
		
	}	
	
	public void Validate_screen(){
		logger.info("  selecciona  producto de interes ");
		waitElementVisibility(NamesMobileElements.HOME_PRODT);
		tapOnElement(NamesMobileElements.HOME_PRODT);
		logger.info(" Agrega  producto al carrito de compras  ");
		tapOnElement(NamesMobileElements.HOME_AGREGAR_COMPRA);
		logger.info("/se valida el mensaje del producto agregado/");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_AGREGADO);
		logger.info("/PRODUCTO AGREGADO AL  CARRITO DE COMPRAS /");
		tapOnElement(NamesMobileElements.HOME_COMPRAS);
		logger.info("/se valida el que aparezca el boton de continuar comprando y se da clicl en el  /");
		waitElementVisibility(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		tapOnElement(NamesMobileElements.HOME_CONTINUAR_COMPRANDO);
		logger.info("se valida que salga la pantalla pago seguro  ");
		waitElementVisibility(NamesMobileElements.SECURE_PAYMENT);
		
	}

}
