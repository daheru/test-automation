package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.ProductDetailBusinessTest;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Product Detail - Session")

public class ProductDetailTest {

@Rule
public TestName name = new TestName();

private static final Logger logger = Logger.getLogger(ProductDetailTest.class);
private static ProductDetailBusinessTest  detail= new ProductDetailBusinessTest();

@AfterClass
public static void shutDown() {
	detail.driverDisconect();
}

@Before
public void initApp() { 
	detail.closeAndroidDialog();
	detail.validateWelcomePage();
	logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
}

@After
public void relauchApp() {
	detail.resetApp();
	logger.info("Caso de prueba finalizado");
}

@Test
@DisplayName("Add special product")
@Severity(SeverityLevel.BLOCKER)
@Story("As a user I want to add a special product to car")
@Description("Try to add a special product to car")
public void CF0_add_product_detail() {
	detail.selectProfile();
	detail.selectMenu(ProfileMenuEnum.LOGIN);
	detail.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
	detail.selectNavigation(NavigationBarEnum.CAR);
	detail.deleteProducts();
	detail.searchProduct("Motocicletas");
	detail.validateSearch();
	detail.selectProduct();
	detail.addProduct();
	detail.validateCar();
}

/*

@Test
@DisplayName("Add special product and normal product")
@Severity(SeverityLevel.BLOCKER)
@Story("As a user I want to add a special product and normal product to car")
@Description("Try to add a special product to car")
public void CF042_add_special_product_and_normal_product() {
	special.selectProfile();
	special.selectMenu(ProfileMenuEnum.LOGIN);
	special.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
	special.selectNavigation(NavigationBarEnum.CAR);
	special.deleteProducts();
	special.searchProduct("Motocicletas");
	special.validateSearch();
	special.selectProduct();
	special.addProduct();
	special.goBack();
	special.goBack();
	special.searchProduct("Celulares");
	special.validateSearch();
	special.selectProduct();
	special.validateSpecialProduct();
}

@Test
@DisplayName("Add normal product and special product")
@Severity(SeverityLevel.CRITICAL)
@Story("As a user I want to add a special product to car")
@Description("Try to add a normal product and special product to car")
public void CF043_add_normal_product_and_special_product() {
	special.selectProfile();
	special.selectMenu(ProfileMenuEnum.LOGIN);
	special.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
	special.selectNavigation(NavigationBarEnum.CAR);
	special.deleteProducts();
	special.searchProduct("Celular");
	special.validateSearch();
	special.selectProduct();
	special.addProduct();
	special.goBack();
	special.goBack();
	special.searchProduct("Motocicleta");
	special.validateSearch();
	special.selectProduct();
	special.validateSpecialProduct();
}

@Test
@DisplayName("Add presale product")
@Severity(SeverityLevel.CRITICAL)
@Story("As a user I want to add a special product to car")
@Description("Try to add a presale product to car")
public void CF04r_add_presale_product() {
	special.selectProfile();
	special.selectMenu(ProfileMenuEnum.LOGIN);
	special.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
	special.selectNavigation(NavigationBarEnum.CAR);
	special.deleteProducts();
	special.searchProduct("Preventa");
	special.validateSearch();
	special.selectProduct();
	special.addProduct();
	special.validateCar();
}

@Test
@DisplayName("Increase product")
@Severity(SeverityLevel.CRITICAL)
@Story("As a user I want to add a special product to car")
@Description("Try to add a presale product to car")
public void CF000_increase_product_from_car() {
	special.selectProfile();
	special.selectMenu(ProfileMenuEnum.LOGIN);
	special.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
	special.selectNavigation(NavigationBarEnum.CAR);
	special.deleteProducts();
	special.searchProduct("Celular");
	special.validateSearch();
	special.selectProduct();
	special.addProduct();
	special.validateCar();
	special.increaseProductFromCar(5);
	special.goBack();
} */
}
