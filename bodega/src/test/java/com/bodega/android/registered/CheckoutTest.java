package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.CheckoutBusinessTest;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Checkout Module - Session")
public class CheckoutTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(CheckoutTest.class);
	private static CheckoutBusinessTest checkout = new CheckoutBusinessTest();

	@AfterClass
	public static void shutDown() {
		checkout.driverDisconect();
	}

	@Before
	public void initApp() {
		checkout.closeAndroidDialog();
		checkout.validateWelcomePage();
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		checkout.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Product out stock")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to buy a product")
	@Description("Validate that change order page has all elements")
	public void CF000_product_out_stock() {
		checkout.selectProfile();
		checkout.selectMenu(ProfileMenuEnum.LOGIN);
		checkout.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		checkout.selectNavigationOption(NavigationBarEnum.CAR);
		checkout.deleteProducts();
		checkout.searchProduct("00019256349673");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.tapOnCar();
		checkout.validateCar();
		checkout.tapOnBuy();
		checkout.tapOnShippingAddress();
		checkout.validateOrderChangePage();
	}
	
	@Test
	@DisplayName("Product in stock")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to buy a product")
	@Description("Validate that change order page has all elements")
	public void CF000_product_in_stock() {
		checkout.selectProfile();
		checkout.selectMenu(ProfileMenuEnum.LOGIN);
		checkout.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		checkout.selectNavigationOption(NavigationBarEnum.CAR);
		checkout.deleteProducts();
		checkout.searchProduct("00000004203614");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.tapOnCar();
		checkout.validateCar();
		checkout.tapOnBuy();
		checkout.tapOnShippingAddress();
		checkout.storePayment();
		checkout.tapOnGoToOrder();
		checkout.validateOrderPage();
		checkout.tapOnFinishOrder();
	}
	
	@Test
	@DisplayName("In stock and out stock products")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to buy a product")
	@Description("Validate that change order page has all elements")
	public void CF000_product_in_stock_and_out_stock() {
		checkout.selectProfile();
		checkout.selectMenu(ProfileMenuEnum.LOGIN);
		checkout.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		checkout.selectNavigationOption(NavigationBarEnum.CAR);
		checkout.deleteProducts();
		checkout.searchProduct("00000004203614");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.goBack();
		checkout.goBack();
		checkout.searchProduct("00019256349673");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.tapOnCar();
		checkout.validateCar();
		checkout.tapOnBuy();
		checkout.tapOnShippingAddress();
		checkout.validateOrderChangePage();
	}

	@Test
	@DisplayName("Pick up product on store by store area")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to buy a product")
	@Description("Buy a product selecting pick up on store by store area")
	public void CF000_buy_product_pickup_store_area() {
		checkout.selectProfile();
		checkout.selectMenu(ProfileMenuEnum.LOGIN);
		checkout.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		checkout.selectNavigationOption(NavigationBarEnum.CAR);
		checkout.deleteProducts();
		checkout.searchProduct("00000004203614");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.tapOnCar();
		checkout.validateCar();
		checkout.tapOnBuy();
		checkout.tapOnSelectStore();
		checkout.searchStore("Av");
		checkout.tapOnAddress();
		checkout.validateShippingStore();
		checkout.fillWhoReceive("Laura", "Lopez", "5664772891");
		checkout.tapOnPaymentMethod();
		checkout.storePayment();
		checkout.validatePreOrderPage();
		checkout.tapOnGoToOrder();
		checkout.validateOrderPage();
		checkout.tapOnFinishOrder();
	}
	
	@Test
	@DisplayName("Pick up product on store by zipcode")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to buy a product")
	@Description("Buy a product selecting pick up on store by zipcode")
	public void CF000_buy_product_pickup_zipcode() {
		checkout.selectProfile();
		checkout.selectMenu(ProfileMenuEnum.LOGIN);
		checkout.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		checkout.selectNavigationOption(NavigationBarEnum.CAR);
		checkout.deleteProducts();
		checkout.searchProduct("00000004203614");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.tapOnCar();
		checkout.validateCar();
		checkout.tapOnBuy();
		checkout.tapOnSelectStore();
		checkout.searchStore("11220");
		checkout.tapOnAddress();
		checkout.validateShippingStore();
		checkout.fillWhoReceive("Laura", "Lopez", "5664772891");
		checkout.tapOnPaymentMethod();
		checkout.storePayment();
		checkout.validatePreOrderPage();
		checkout.tapOnGoToOrder();
		checkout.validateOrderPage();
		checkout.tapOnFinishOrder();
	}
	
	@Test
	@DisplayName("Not credit card registered")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to buy a product")
	@Description("Buy a product without credit card registered")
	public void CF000_buy_product_without_credit_card() {
		// Modificar caso para que se cree un usuario dinamicamente
		
		checkout.selectProfile();
		checkout.selectMenu(ProfileMenuEnum.LOGIN);
		checkout.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		checkout.selectNavigationOption(NavigationBarEnum.CAR);
		checkout.deleteProducts();
		checkout.searchProduct("00000004203614");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.tapOnCar();
		checkout.validateCar();
		checkout.tapOnBuy();
		checkout.tapOnShippingAddress();
		checkout.addCreditCard("5555555555554444", "Benito Juarez", "0130", "123");
		checkout.isSameAddress(true, true);
		checkout.tapOnGoToPreOrder();
		checkout.validatePreOrderPage();
		checkout.tapOnGoToOrder();
		checkout.validateOrderPage();
		checkout.tapOnFinishOrder();
	}
	
	@Test
	@DisplayName("Credit card registered")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to buy a product")
	@Description("Buy a product without credit card registered")
	public void CF000_buy_product_with_credit_card() {
		checkout.selectProfile();
		checkout.selectMenu(ProfileMenuEnum.LOGIN);
		checkout.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		checkout.selectNavigationOption(NavigationBarEnum.CAR);
		checkout.deleteProducts();
		checkout.searchProduct("00000004203614");
		checkout.tapOnProduct();
		checkout.addProduct();
		checkout.tapOnCar();
		checkout.validateCar();
		checkout.tapOnBuy();
		checkout.tapOnShippingAddress();
		checkout.selectCreditCardPayment();
		checkout.validatePreOrderPage();
		checkout.tapOnGoToOrder();
		checkout.validateOrderPage();
		checkout.tapOnFinishOrder();
	}
}
