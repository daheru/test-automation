package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.HomeBussinesTest;
import com.walmartmg.business.iOS.LoginBusinessTest;
import com.walmartmg.enums.NavigationBarEnum;

public class HomeTest {
	private LoginBusinessTest login = new LoginBusinessTest();
	private static final Logger logger = Logger.getLogger(HomeTest.class);
	public static HomeBussinesTest home = new HomeBussinesTest();

	@AfterClass
	public static void tearDown() {
		home.driverDisconect();

	}

	@Before
	public void init() {
		home.closeIOSDialog();
	}

	@Test
	public void CP001_search_elements_validation_page() {
		logger.info(" Iniciando caso de prueba: Search elements validation page");
		home.selectHome();
		home.validateSearchPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CPOO2_search_valid_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.searchProduct("pantalla 55 4k");
		home.validateSearch();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CPOO3_search_invalid_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		logger.info("Ingresando producto invalido");
		home.searchProduct("Mayonesa");
		home.validateEmptySearchProduct();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP007_Validate_Empty_cart() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectDepartments();
		home.validate_Empty_cart();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP008_Lightning_Offers_Add_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.validate_Lightning_Offer_Add_product();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP009Search_Add_Product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.search_Add_Product("Refrigerador");
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP011_Remove_product_from_Product_detail() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.remove_product_from_();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP010_Increase_product_quantity_from() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.increase_product_quantity_from();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP0012_Cart_with_one_or_several_products_added() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.validate_Cart_with_one_or_several_products_added();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test // *
	public void CP013Validate_Cart_Remove_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.validate_Cart_Remove_product();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP014Cart_Button_Continue_with_the_purchase() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.validate_Cart_Button();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP106_validate_Secure_payment() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectHome();
		home.Validate_secure_payment_screen();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	/// login

	@Test
	public void CP152_Perform_the_search_for_valid_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de PERFIL");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		logger.info("Se da click en el icono de HOME ");
		home.selectHome();
		home.searchProduct("pantalla 55 4k");
		home.validateSearch();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP153_Perform_the_search_for_an_invalid_product_with_a_logued_account() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		logger.info("Se da click en el icono de HOME ");
		home.selectHome();
		logger.info("Ingresando producto invalido");
		home.searchProduct("Mayonesa");
		home.validateEmptySearchProduct();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP155_Validate_Empty_cart_with_logeada_account() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		logger.info("Se da click en el icono de HOME ");
		home.validate_Empty_cart();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP156_Offers_Lightning_Add_product_with_login() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		logger.info("Se da click en el icono de HOME ");
		home.validate_Lightning_Offer_Add_product();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test /// incompleto por error en xpath
	public void CP157_Serch_product_Add_product_with_login() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		home.selectHome();
		home.search_Add_Product("Refrigerador");
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP158_Remove_product_from_Product_detail() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		home.selectHome();
		home.remove_product_from_();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP159_Increase_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		home.selectHome();
		home.increase_product_quantity_from();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP160_Validate_Cart_with_one_or_several_products() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		home.selectHome();
		home.validate_Cart_with_one_or_several_products_added();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP161_Remove_one_or_several_products_added_to_the_cart() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		home.selectHome();
		home.validate_Cart_Remove_product();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}
	
	@Test
	public void CP162_Validate_screen_payment() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.validateLoginIn();
		home.selectHome();
		home.Validate_secure_payment_screen();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	
	}
	
	
	
	
}
