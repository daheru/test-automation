package com.bodega.android.init;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.AccountBusinessTest;
import com.bodega.business.android.CarBusinessTest;
import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.LoginBusinessTest;
import com.bodega.business.android.MenuBusinessTest;
import com.bodega.business.android.ProductBusinessTest;
import com.bodega.business.android.SearchBusinessTest;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.ProfileMenuEnum;
import com.bodega.vo.AddressVO;

public class CasesInitialization {

	private static GeneralBusinessTest general = new GeneralBusinessTest();
	private MenuBusinessTest menu = new MenuBusinessTest();
	private AccountBusinessTest account = new AccountBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	
	@AfterClass
	public static void shutDown() {
		general.driverDisconect();
	}

	@Before
	public void initApp() {
		general.closeAndroidDialog();
		general.validateWelcomePage();
	}

	@After
	public void relauchApp() {
		general.resetApp();
	}
	
	@Test
	public void createUser() {
		general.selectProfile();
		general.selectMenuOption(ProfileMenuEnum.CREATE_PROFILE);
		account.createAccount("Luis", "Lopez", GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		account.validateCreateAccount();
	}
	
	@Test
	public void addAddress() {
		AddressVO address = menu.initAddressVO();
		general.selectProfile();
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
		login.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		general.selectProfile();
		general.selectMenuOption(ProfileMenuEnum.ADDRESS);
		menu.selectAddAddress();
		menu.addNewDirection(address);
		menu.saveDirection();
		menu.validateAddress(address, AppMessages.ADD_ADDRESS);
	}
	
	//@Test
	public void createOrder() {
		general.selectProfile();
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
		login.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		search.searchProduct("camaras");
		product.selectProduct();
		product.addProduct();
		car.selectCar();
		car.validateCar();
		car.selectContinueBuying();
	}
}
