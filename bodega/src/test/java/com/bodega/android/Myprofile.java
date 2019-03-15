package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bodega.business.android.MyprofileBusinessTest;
import com.bodega.vo.AddressVO;

public class Myprofile {
	
	public static final Logger logger = Logger.getLogger( MyprofileBusinessTest.class );
	public static MyprofileBusinessTest myprofile = new MyprofileBusinessTest();
	
/*	public static myprofileVO myprofileVO;
	
	
	@BeforeClass
	public static void init() {
		myprofileVO = new myprofileVO("Mi primera direccion", "Juan", "Perez", "Av Rodolfo Gaona 46", "456", "", "11200", 
				"Lomas Hermosa", "Entre walmart", "Plaza Toreo", "Movil", "5555555555");/*
	}
	
	@AfterClass
	public static void tearDown() {
		myprofile.driverDisconect();
	}
	
	@Before
	public void relauchApp() {
		myprofile.closeApp();
		myprofile.lauchApp();
		myprofile.closeAndroidDialog();
	}

@Test
public void add_new_address_as_favorite() {
	logger.info("Iniciando caso de prueba: Update my profile data");
	myprofile.myprofile("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
	myprofile.selectProfile();
	myprofile.selectMenuDirections();
/*	myprofile.addNewDirection( addressVO );
	myprofile.selectAsMainAddress(true);
	myprofile.saveDirection();
	myprofile.validateAddressAsFavorite(true, addressVO.getAddressName());*/
	logger.info("Caso de prueba finalizado");
}

		
	}	



