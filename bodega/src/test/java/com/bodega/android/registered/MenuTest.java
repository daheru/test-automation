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

@Feature("Menu Module - Session")
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
		general.driverDisconect();
	}

	@Before
	public void initApp() {
		general.closeAndroidDialog();
		general.validateWelcomePage();
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		general.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Add new address as a favorite")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Add new address with favorite option selected")
	public void CF012_add_new_address_as_favorite() {
		addressVO = main.initAddressVO();
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		main.selectAddAddress();
		addressVO.setMainAddress(true);
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
		addressVO = main.initAddressVO();
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		main.selectAddAddress();
		addressVO.setMainAddress(false);
		main.addNewDirection(addressVO);
		main.saveDirection();
		main.validateAddress(addressVO, AppMessages.ADD_ADDRESS);
	}
	
	@Test
	@DisplayName("Edit main address")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Edit user's main address information")
	public void CF013_edit_main_address() {
		addressVO = main.initAddressVO();
		addressVO.setAddressName("Mi direccion");
		addressVO.setAddressPhone("5512345678");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		addressVO.setMainAddress(true);
		main.editAddress(addressVO);
		main.saveDirection();
		main.validateAddress(addressVO, AppMessages.EDIT_ADDRESS);
	}

	@Test
	@DisplayName("Delete address")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to manage my address information")
	@Description("Delete an addrees from address page")
	public void CF014_delete_address() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		main.removeAddress(addressVO);
		main.validateRemoveAddress();
	}

	@Test
	@DisplayName("View orders")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my orders")
	@Description("Check that user's order appear")
	public void CF015_view_orders() {
		// juan@correo.com 12345678
		// emmanuel.dominguez@live.com.mx Edominguez#1234
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ORDERS);
		main.validateOrderPage();
	}

	@Test
	@DisplayName("View orders detail")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my orders")
	@Description("Show orders detail")
	public void CF016_view_order_detail() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ORDERS);
		String orderNumber[] = main.orderDetail();
		main.validateOrderDetail(orderNumber);
	}

	@Test
	@DisplayName("View notifications")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to see my notifications")
	@Description("Show orders detail")
	public void CF017_view_notifications() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.NOTIFICATIONS);
	}

	@Test
	@DisplayName("Scan ticket manually")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to scan my ticket")
	@Description("Scan ticket introducing numbers manually")
	public void CF019_scan_manually_ticket() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.GET_BILL);
		main.closeAndroidDialog();
		main.manualBill("36214691686686662445");
	}

	@Test
	@DisplayName("Validate support page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to use support page to ask for help or support")
	@Description("Scan ticket introducing numbers manually")
	public void CF023_CF024_validate_suppor_page() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.SUPPORT);
		main.validateSupportPage();
	}

	@Test
	@DisplayName("Validate term page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check terms")
	@Description("Check all terms on the page")
	public void CF025_CF029_validate_terms_page() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.TERMS);
		main.validateTerms(5);
	}

	@Test
	@DisplayName("Validate legal page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to check support page to ")
	@Description("Check all legals on the page")
	public void CF030_CF035_validate_legals_page() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LEGALS);
		main.validateLegalsPage();
	}
	
	@Test
	@DisplayName("Logout")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to logout")
	@Description("Use the logout button in the app")
	public void CF306_logout() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGOUT);
		main.validateLogout();
	}

	@Test
	@DisplayName("Add address without data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Trying create a new direction without data")
	public void CF115_add_address_without_data() {
		addressVO = new AddressVO();
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
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
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		main.validateEmptyAddressPage();
	}
	
	@Test
	@DisplayName("View orders empty page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to see my orders")
	@Description("See the orders page without orders")
	public void CF000_view_orders_empty_page() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ORDERS);
		main.validateEmptyOrderPage();
	}
	
	@Test
	@DisplayName("Add address with invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Try to add a new address with invalid data")
	public void CF000_add_address_invalid_data() {
		addressVO.setAddressName("$Mi Direccion-#");
		addressVO.setAddressUserName("&Ju/an(");
		addressVO.setAddressUserLastName("P=e)r$e!z");
		addressVO.setAddressStreet("%Mi calle#");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		main.selectAddAddress();
		main.addNewDirection(addressVO);
		main.saveDirection();
		main.validateAddressInvalidMessages();
	}
	
	@Test
	@DisplayName("Edit address with invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to manage my address information")
	@Description("Try to edit an address with invalid data")
	public void CF000_edit_address_invalid_data() {
		addressVO.setAddressName("$Mi Direccion-#");
		addressVO.setAddressUserName("&Ju/an(");
		addressVO.setAddressUserLastName("P=e)r$e!z");
		addressVO.setAddressStreet("%Mi calle#");
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		main.editAddress(addressVO);
		main.saveDirection();
		main.validateAddressInvalidMessages();
	}
	
	@Test
	@DisplayName("Select address as a favorite")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to select an address as a favorite")
	@Description("Select an address as a favorite")
	public void CF000_select_address_as_favorite() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.ADDRESS);
		main.selectAsMainAddress();
		main.validateFavoriteAddress();
	}
	
	@Test
	@DisplayName("Validate menu session")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to use my profile menu")
	@Description("Validate that profile menu with session has all elements")
	public void CF000_validate_menu_with_login() {
		main.selectProfile();
		main.selectMenu(ProfileMenuEnum.LOGIN);
		main.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		main.selectProfile();
		main.validateMenu(true);
	}
}
