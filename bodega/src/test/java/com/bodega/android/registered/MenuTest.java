package com.bodega.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.MenuBusinessTest;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.enums.ProfileMenuEnum;
import com.bodega.vo.AddressVO;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Login Module - Session")
public class MenuTest {
	
	@Rule public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(MenuTest.class);
	private static MenuBusinessTest main = new MenuBusinessTest();
	private static GeneralBusinessTest general = new GeneralBusinessTest();
	private static AddressVO addressVO;

	@BeforeClass
	public static void init() {
		addressVO = main.initAddressVO();
	}

	@AfterClass
	public static void shutDown() {
		main.driverDisconect();
	}

	@Before
	public void initApp() {
		main.closeAndroidDialog();
		general.validateWelcomePage();
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		logger.info("Caso de prueba finalizado");
		main.resetApp();
	}

	@Test
	@DisplayName("Add new address as a favorite")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Add new address with favorite option selected")
	public void CF012_add_new_address_as_favorite() {
		addressVO = main.initAddressVO();
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		main.addNewDirection(addressVO);
		main.saveDirection();
		main.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}

	@Test
	@DisplayName("Add new address")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Add new address whitout favorite option selected")
	public void CF012_add_new_address() {
		logger.info("Iniciando caso de prueba: New Adress");
		addressVO = main.initAddressVO();
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		addressVO.setMainAddress(false);
		main.addNewDirection(addressVO);
		main.saveDirection();
		main.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Edit main address")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Edit user's main address information")
	public void CF013_edit_main_address() {
		logger.info("Iniciando caso de prueba: Edit Address");
		addressVO = main.initAddressVO();
		addressVO.setAddressName("Mi direccion");
		addressVO.setAddressPhone("5512345678");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		addressVO.setMainAddress(true);
		main.editAddress(addressVO);
		main.saveDirection();
		main.validateAddress(addressVO, AppMessages.EDIT_ADDRESS);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Delete address")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to manage my address information")
	@Description("Delete an addrees from address page")
	public void CF014_delete_address() {
		logger.info("Iniciando caso de prueba: Remove address");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		main.removeAddress(addressVO);
		main.validateRemoveAddress();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("View orders")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my orders")
	@Description("Check that user's order appear")
	public void CF015_view_orders() {
		logger.info("Iniciando caso de prueba: View orders");
		// juan@correo.com 12345678
		// emmanuel.dominguez@live.com.mx Edominguez#1234
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ORDERS.getMenu());
		main.validateOrderPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("View orders detail")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my orders")
	@Description("Show orders detail")
	public void CF016_view_order_detail() {
		logger.info("Iniciando caso de prueba: View order detail");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ORDERS.getMenu());
		String orderNumber[] = main.orderDetail();
		main.validateOrderDetail(orderNumber);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("View notifications")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to see my notifications")
	@Description("Show orders detail")
	public void CF017_view_notifications() {
		logger.info("Iniciando caso de prueba: View notifications");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.NOTIFICATIONS.getMenu());
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Scan ticket manually")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to scan my ticket")
	@Description("Scan ticket introducing numbers manually")
	public void CF019_scan_manually_ticket() {
		logger.info("Iniciando caso de prueba: Scan manually ticket");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.GET_BILL.getMenu());
		main.closeAndroidDialog();
		main.manualBill("36214691686686662445");
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate support page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use support page to ask for help or support")
	@Description("Scan ticket introducing numbers manually")
	public void CF023_CF024_validate_suppor_page() {
		logger.info("Iniciando caso de prueba: Validate Support Page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.SUPPORT.getMenu());
		main.validateSupportPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate term page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check terms")
	@Description("Check all terms on the page")
	public void CF025_CF029_validate_terms_page() {
		logger.info("Iniciando caso de prueba: Validate Terms Page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.TERMS.getMenu());
		main.validateTerms(5);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate legal page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check support page to ")
	@Description("Check all legals on the page")
	public void CF030_CF035_validate_legals_page() {
		logger.info("Iniciando caso de prueba: Validate Legals Page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LEGALS.getMenu());
		main.validateLegalsPage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Logout")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to logout")
	@Description("Use the logout button in the app")
	public void CF306_logout() {
		logger.info("Iniciando caso de prueba: Logout success");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGOUT.getMenu());
		main.validateLogout();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Add address without data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Trying create a new direction without data")
	public void CF115_add_address_without_data() {
		addressVO = new AddressVO();
		logger.info("Iniciando caso de prueba: Add address without data");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		main.saveDirection();
		main.validateAddressEmptyMessages();
	}
	
	@Test
	@DisplayName("Validate empty address page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("See the address page without address'")
	public void CF000_validate_empty_address_page() {
		logger.info("Iniciando caso de prueba: validate empty address page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		addressVO.setMainAddress(false);
		main.addNewDirection(addressVO);
		main.saveDirection();
		main.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("View orders empty page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to see my orders")
	@Description("See the orders page without orders")
	public void CF000_view_orders_empty_page() {
		logger.info("Iniciando caso de prueba: View orders empty page");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ORDERS.getMenu());
		main.validateEmptyOrderPage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Add address with invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Try to add a new address with invalid data")
	public void CF000_add_address_invalid_data() {
		logger.info("Iniciando caso de prueba: Add address invalid data");
		addressVO.setAddressName("$Mi Direccion-#");
		addressVO.setAddressUserName("&Ju/an(");
		addressVO.setAddressUserLastName("P=e)r$e!z");
		addressVO.setAddressStreet("%Mi calle#");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		main.addNewDirection(addressVO);
		main.saveDirection();
		main.validateAddressInvalidMessages();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Edit address with invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Try to edit an address with invalid data")
	public void CF000_edit_address_invalid_data() {
		logger.info("Iniciando caso de prueba: Edit address invalid data");
		addressVO.setAddressName("$Mi Direccion-#");
		addressVO.setAddressUserName("&Ju/an(");
		addressVO.setAddressUserLastName("P=e)r$e!z");
		addressVO.setAddressStreet("%Mi calle#");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN.getMenu());
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS.getMenu());
		main.editAddress(addressVO);
		main.saveDirection();
		main.validateAddressInvalidMessages();
		logger.info("Caso de prueba finalizado");
	}
}
