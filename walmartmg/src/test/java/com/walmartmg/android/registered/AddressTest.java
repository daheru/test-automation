package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.AddressesBusinessTest;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.vo.AddressVO;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

public class AddressTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(ProfileTest.class);
	private static AddressesBusinessTest address = new AddressesBusinessTest();
	private static AddressVO addressVO;

	@BeforeClass
	public static void init() {
		addressVO = address.initAddressVO();
	}

	@AfterClass
	public static void tearDown() {
		address.driverDisconect();
	}

	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void resetApp() {
		address.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate profile without address")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate when a user does not have address")
	public void CP100_validate_without_addresses() {
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.validateScreenYoursAddresses();
	}

	@Test
	@DisplayName("Validate add address page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate add address page")
	public void CP101_validate_form() {
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.validateFormAddAddress();
	}

	@Test
	@DisplayName("Validate add address without data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate add address when users do not put information")
	public void CP102_validate_form_with_empty_fields() {
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.pressBtnSave();
		address.validateFieldsEmpty();
	}

	@Test
	@DisplayName("Validate add address with invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate add address when users put invalid information")
	public void CP103_validate_invalid_data() {
		addressVO.setAddressName("Ç·$%&$%&");
		addressVO.setAddressUserName("$·%&/(");
		addressVO.setAddressStreet("!$%&/()#");
		addressVO.setAddressOutNumber("·$%&");
		addressVO.setAddressInnerNumber("·$%&");
		addressVO.setAddressPhone("123");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.addNewDirection(addressVO);
		address.pressBtnSave();
		address.validateInvalidData();
	}

	@Test
	@DisplayName("Validate add address")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate when users add new address")
	public void CP104_add_new_address() {
		addressVO = address.initAddressVO();
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.addNewDirection(addressVO);
		address.pressBtnSave();
		address.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}

	@Test
	@DisplayName("Validate add address page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate add address page")
	public void CP104_1_add_new_address() {
		addressVO = address.initAddressVO();
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.pressPlusAdd();
		address.addNewDirection(addressVO);
		address.pressBtnSave();
		address.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}

	@Test
	@DisplayName("Validate edit address")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate when users edit an address")
	public void CP105_edit_address() {
		addressVO.setAddressName("$Mi Direccion-#");
		addressVO.setAddressUserName("&Ju/an(");
		addressVO.setAddressUserLastName("P=e)r$e!z");
		addressVO.setAddressStreet("%Mi calle#");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.editAddress(addressVO);
		address.pressBtnSave();
		address.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}

	@Test
	@DisplayName("Validate delete address")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my addresses")
	@Description("Validate when users delete an address")
	public void CP106_delete_address() {
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		address.selectRequestAddress();
		address.removeAddress(addressVO);
	}
}
