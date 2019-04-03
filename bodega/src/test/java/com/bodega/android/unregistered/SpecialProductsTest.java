package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.SpecialProductsBusiness;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.enums.NavigationBarEnum;

public class SpecialProductsTest {
	
	public static final Logger logger = Logger.getLogger(SpecialProductsTest.class);
	public static SpecialProductsBusiness special = new SpecialProductsBusiness();
	
	@AfterClass
	public static void shutDown() {
		special.driverDisconect();
	}

	@Before
	public void initApp() {
		special.closeAndroidDialog();
		special.validateWelcomePage();
	}

	@After
	public void relauchApp() {
		special.resetApp();
	}
	
	@Test
	public void CF041_add_special_product() {
		logger.info("Iniciando caso de prueba: Add special product");
		special.selectNavigation( NavigationBarEnum.CAR.getNavigation() );
		special.deleteProducts();
		special.searchProduct("Motocicletas");
		special.validateSearch();
		special.selectProduct();
		special.addProduct();
		special.validateCar();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF042_add_special_product_and_normal_product() {
		logger.info("Iniciando caso de prueba: Add special product and normal product");
		special.selectNavigation( NavigationBarEnum.CAR.getNavigation() );
		special.deleteProducts();
		special.searchProduct("Motocicletas");
		special.validateSearch();
		special.selectProduct();
		special.addProduct();
		special.validateCar();
		special.searchProduct("Celulares");
		special.validateSearch();
		special.selectProduct();
		special.validateSpecialProduct();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF043_add_normal_product_and_special_product() {
		logger.info("Iniciando caso de prueba: Add normal product and special product");
		special.selectNavigation( NavigationBarEnum.CAR.getNavigation() );
		special.deleteProducts();
		special.searchProduct("Celular");
		special.validateSearch();
		special.selectProduct();
		special.addProduct();
		special.validateCar();
		special.searchProduct("Motocicleta");
		special.validateSearch();
		special.selectProduct();
		special.validateSpecialProduct();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF04r_add_presale_product() {
		logger.info("Iniciando caso de prueba: Add presale product");
		special.selectNavigation( NavigationBarEnum.CAR.getNavigation() );
		special.deleteProducts();
		special.searchProduct("Preventa");
		special.validateSearch();
		special.selectProduct();
		special.addProduct();
		special.validateCar();
		logger.info("Caso de prueba finalizado");
	}

}
