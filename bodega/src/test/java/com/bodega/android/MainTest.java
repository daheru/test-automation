package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bodega.business.android.MainBusinessTest;
import com.bodega.vo.AddressVO;

public class MainTest {

	public static final Logger logger = Logger.getLogger(MainTest.class);
	public static MainBusinessTest main = new MainBusinessTest();
	public static AddressVO addressVO;

	@BeforeClass
	public static void init() {
		addressVO = new AddressVO("Prueba 1", "Juan", "Perez", "Av Rodolfo Gaona 46", "456", "", "11200", 
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
	
	//@After
	public void relauchApp() {
		main.resetApp();
	}

	@Test
	public void add_new_address_as_favorite() {
		logger.info("Iniciando caso de prueba: New Adress As Favorite");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenuDirections();
		main.addNewDirection( addressVO );
		main.selectAsMainAddress(true);
		main.saveDirection();
		main.validateAddressAsFavorite(true, addressVO.getAddressName());
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void edit_main_address( ) {
		logger.info("Iniciando caso de prueba: Edit Address");
		addressVO.setAddressName("Prueba Modificacion");
		addressVO.setAddressPhone("5512345678");
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenuDirections();
		main.editAddress( addressVO );
		main.saveDirection( );
		main.validateAddressAsFavorite(true, addressVO.getAddressName());
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void delete_address() {
		logger.info("Iniciando caso de prueba: Edit Address");
		

				
		logger.info("Caso de prueba finalizado");
	}
		
}
