package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bodega.business.android.MainBusinessTest;
import com.bodega.commons.MenuOptionsEnum;
import com.bodega.vo.AddressVO;

public class MainTest {

	public static final Logger logger = Logger.getLogger(MainTest.class);
	public static MainBusinessTest main = new MainBusinessTest();
	public static AddressVO addressVO;

	@BeforeClass
	public static void init() {
		addressVO = new AddressVO("Direccion ", "Juan", "Perez", "Av Rodolfo Gaona 46", "456", "", "11200", 
				"Lomas Hermosa", "Entre walmart", "Plaza Toreo", "Movil", "5555555555");
	}
	
	@AfterClass
	public static void shutDown() {
		main.driverDisconect();
	}

	@Before
	public void initApp() {
		main.closeAndroidDialog();
	}
	
	@After
	public void relauchApp() {
		main.resetApp();
	}

	@Test
	public void add_new_address_as_favorite() {
		logger.info("Iniciando caso de prueba: New Adress As Favorite");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.ADDRESS.getMenu() );
		main.addNewDirection( addressVO );
		main.selectAsMainAddress(true);
		main.saveDirection();
		main.validateAddressAsFavorite(true, addressVO.getAddressName());
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void edit_main_address( ) {
		logger.info("Iniciando caso de prueba: Edit Address");
		addressVO.setAddressName("Mi direccion");
		addressVO.setAddressPhone("5512345678");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.ADDRESS.getMenu() );
		main.editAddress( addressVO );
		main.saveDirection( );
		main.validateAddressAsFavorite(true, addressVO.getAddressName());
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void remove_address() {
		logger.info("Iniciando caso de prueba: Remove address");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.ADDRESS.getMenu() );
		main.removeAddress( addressVO );
		main.validateRemoveAddress();		
		logger.info("Caso de prueba finalizado");
	}
	
	//@Test
	public void view_orders() {
		logger.info("Iniciando caso de prueba: View orders");
		//juan@correo.com 12345678
		//emmanuel.dominguez@live.com.mx Edominguez#1234
		main.login("juan@correo.com", "12345678");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.ORDERS.getMenu() );
		main.validateOrderPage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void view_order_detail() {
		logger.info("Iniciando caso de prueba: View order detail");
		//juan@correo.com 12345678
		//emmanuel.dominguez@live.com.mx Edominguez#1234
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.ORDERS.getMenu() );
		String orderNumber[] = main.orderDetail();
		main.validateOrderDetail(orderNumber);
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void view_notifications() {
		logger.info("Iniciando caso de prueba: View notifications");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.NOTIFICATIONS.getMenu() );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void scan_manually_ticket() {
		logger.info("Iniciando caso de prueba: Scan manually ticket");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.GET_BILL.getMenu() );
		main.closeAndroidDialog();
		main.manualBill("36214691686686662445");
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void validate_suppor_page() {
		logger.info("Iniciando caso de prueba: Validate Support Page");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.SUPPORT.getMenu() );
		main.validateSupportPage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void validate_terms_page() {
		logger.info("Iniciando caso de prueba: Validate Terms Page");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.TERMS.getMenu() );
		main.validateTerms(5);
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void logout_success() {
		logger.info("Iniciando caso de prueba: Logout success");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu( MenuOptionsEnum.LOGOUT.getMenu() );
		main.validateLogout();
		logger.info("Caso de prueba finalizado");
	}
	
}
