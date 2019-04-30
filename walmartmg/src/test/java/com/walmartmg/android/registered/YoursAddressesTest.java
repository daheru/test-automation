package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.walmartmg.business.android.AddressesBusinessTest;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.vo.AddressVO;

public class YoursAddressesTest {
	
	public static final Logger logger = Logger.getLogger( MyProfileTest.class );
	private static AddressesBusinessTest address = new AddressesBusinessTest();
	private static AddressVO addressVO;
	
	
	@BeforeClass
	public static void init() {
		addressVO = address.initAddressVO();
	}

	
	@AfterClass
	public static void tearDown(){
		address.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		address.resetApp();
	}
	
	@Test
	public void CP100_validate_without_addresses() {
		logger.info("Start CP100 Validate without addresses");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		address.validateScreenYoursAddresses();
	}
	
	@Test
	public void CP101_validate_form() {
		logger.info("Start CP101 Validate Form");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.validateFormAddAddress();
	}
	
	@Test
	public void CP102_validate_form_with_empty_fields() {
		logger.info("Start CP102 Validate error messages with fields empty");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.pressBtnSave();
		address.validateFieldsEmpty();
	}
	
	@Test
	public void CP103_validate_invalid_data() {
		logger.info("Start CP103 Validate error messages with invalid data");
		addressVO.setAddressName("Ç·$%&$%&");
		addressVO.setAddressUserName("$·%&/(");
		addressVO.setAddressStreet("!$%&/()#");
		addressVO.setAddressOutNumber("·$%&");
		addressVO.setAddressInnerNumber("·$%&");
		addressVO.setAddressPhone("123");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.addNewDirection(addressVO);
		address.pressBtnSave();
		address.validateInvalidData();
	}
	
	//Cuenta nueva 
	@Test
	public void CP104_add_new_address() {
		logger.info("Start CP104 Add New Address");
		addressVO = address.initAddressVO();
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		address.pressBtnAdd();
		address.addNewDirection(addressVO);
		address.pressBtnSave();
		address.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}
	
	//con direcciones existentes
	@Test
	public void CP104_1_add_new_address() {
		logger.info("Start CP104 Add New Address");
		addressVO = address.initAddressVO();
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		address.pressPlusAdd();
		address.addNewDirection(addressVO);
		address.pressBtnSave();
		address.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}
	
	@Test
	public void CP105_edit_address() {
		addressVO.setAddressName("$Mi Direccion-#");
		addressVO.setAddressUserName("&Ju/an(");
		addressVO.setAddressUserLastName("P=e)r$e!z");
		addressVO.setAddressStreet("%Mi calle#");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.ruiz.walis@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		logger.info("Menu logueado");
		address.editAddress(addressVO);
		address.pressBtnSave();
		address.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}
	
	@Test
	public void CP106_delete_address() {
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestAddress();
		address.removeAddress(addressVO);
	}
}
