package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.walmartmg.business.android.AddressesBusinessTest;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.vo.AddressVO;

public class YoursAddressesTest {
	
	public static final Logger logger = Logger.getLogger( MyProfileTest.class );
	private static AddressesBusinessTest address = new AddressesBusinessTest();
	private static GeneralBusinessTest general = new GeneralBusinessTest();
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
		address.closeApp();
		address.lauchApp();
	}
	
	@Test
	public void CP100_validate_without_addresses() {
		logger.info("Start CP100 Validate without addresses");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestMyProfile();
		address.validateScreenYoursAddresses();
	}
	
	@Test
	public void CP101_validate_form() {
		logger.info("Start CP101 Validate Form");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestMyProfile();
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
		address.selectRequestMyProfile();
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
		addressVO.setAddressZipcode("**00");
		addressVO.setAddressPhone("123");
		address.selectProfileOption();
		address.selectMenuLogin();
		address.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		address.selectRequestMyProfile();
		address.pressBtnAdd();
		
	}

}
