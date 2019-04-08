package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Test;

import com.walmartmg.business.iOS.HomeBussinesTest;
import com.walmartmg.enums.NavigationBarEnum;

public class HomeTest {

	private static final Logger logger = Logger.getLogger(HomeTest.class);
	public static HomeBussinesTest home = new HomeBussinesTest();

	@AfterClass
	public static void tearDown() {
		home.driverDisconect();

	}

	@Test
	public void CP001_search_elements_validation_page() {
		logger.info("===> Iniciando caso de prueba: Search elements validation page");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		home.validateSearchPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CPOO2_search_valid_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		home.searchProduct("pantalla 55 4k");
		home.validateSearch();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CPOO3_search_invalid_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		logger.info("Ingresando producto invalido");
		home.searchProduct("Mayonesa");
		home.validateEmptySearch();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP007_Validate_Empty_cart() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(1);
		home.Cp007_Validate_Empty_cart();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP008_Lightning_Offers_Add_product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(1);
		home.Cp008_Validate_Lightning_Offer_Add_product();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP009Search_Add_Product() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		home.Cp009Search_Add_Product("Refrigerador");
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP011_Remove_product_from_Product_detail() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		home.Cp011_Remove_product_from_();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP010_Increase_product_quantity_from() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		home.Cp010_Increase_product_quantity_from();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP0012_Cart_with_one_or_several_products_added() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		home.CP012_Validate_Cart_with_one_or_several_products_added();

	}

	@Test
	public void CP014Cart_Button_Continue_with_the_purchase() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		home.selectMenu(NavigationBarEnum.HOME.getNavigation());
		home.CP014Validate_Cart_Button();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
		
		

	public static HomeBussinesTest home = new HomeBussinesTest();

	}
}

	}

	@Test
	public void CP001() {
		home.selectMenu(1);
		home.validate();

	}

	@Test
	public void CPOO2() {
		home.selectMenu(1);
		home.vaCp002();

	}

	@Test
	public void CPOO3() {
		home.selectMenu(1);
		home.cp003();

	}

	@Test
	public void CP007() {
		home.selectMenu(1);
		home.cp007();

	}

	@Test
	public void CP008() {
		home.selectMenu(1);
		home.Cp008();

	}

}
