package com.walmartmg.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.DepartmentsBusinessTest;
import com.walmartmg.enums.MenusEnum;

public class DeparmentTest {
	
	private static final Logger logger = Logger.getLogger(DeparmentTest.class);
	private static DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	
	@AfterClass
	public static void tearnDown() {
		departments.driverDisconect();
	}

	@Before
	public void reloadApp() {
		departments.closeApp();
		departments.lauchApp();
	}
	
	@Test
	public void CP055_validate_computers_department() {
		logger.info("===> Iniciando caso de prueba: validate computers department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_COMPUTERS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP056_validate_tv_department() {
		logger.info("===> Iniciando caso de prueba: validate tv and video department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_TV_VIDEO );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP057_validate_audio_department() {
		logger.info("===> Iniciando caso de prueba: validate audio department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_AUDIO );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP058_validate_musical_department() {
		logger.info("===> Iniciando caso de prueba: validate musical instruments department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_INSTRUMENTS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP059_validate_videogames_department() {
		logger.info("===> Iniciando caso de prueba: validate videogames department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_VIDEOGAMES );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP060_validate_mobiles_department() {
		logger.info("===> Iniciando caso de prueba: validate mobiles department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_MOBILES );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP061_validate_photography_department() {
		logger.info("===> Iniciando caso de prueba: validate photography department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_PHOTOGRAPHY );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP062_validate_forniture_department() {
		logger.info("===> Iniciando caso de prueba: validate forniture department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_FORNITURE );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP063_validate_kitchen_department() {
		logger.info("===> Iniciando caso de prueba: validate kitchen department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HOME_KITCHEN );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP064_validate_mattress_department() {
		logger.info("===> Iniciando caso de prueba: validate mattress department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_MATTRESSES );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP065_validate_cars_department() {
		logger.info("===> Iniciando caso de prueba: validate cars department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_CARS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP066_validate_hardware_department() {
		logger.info("===> Iniciando caso de prueba: validate hardware department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HARDWARE_STORE );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP067_validate_fashion_department() {
		logger.info("===> Iniciando caso de prueba: validate fashion department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_FASHION );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP068_validate_health_department() {
		logger.info("===> Iniciando caso de prueba: validate health department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HEALTH );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP069_validate_beauty_department() {
		logger.info("===> Iniciando caso de prueba: validate beauty department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_BEAUTY );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP070_validate_sports_department() {
		logger.info("===> Iniciando caso de prueba: validate sports department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_SPORTS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP071_validate_garden_department() {
		logger.info("===> Iniciando caso de prueba: validate garden department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_GARDEN );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP072_validate_babies_department() {
		logger.info("===> Iniciando caso de prueba: validate babies department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_BABIES );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP073_validate_toys_department() {
		logger.info("===> Iniciando caso de prueba: validate toys department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_TOYS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP074_validate_office_department() {
		logger.info("===> Iniciando caso de prueba: validate office department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_OFFICE );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP075_validate_pets_department() {
		logger.info("===> Iniciando caso de prueba: validate pets department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_PETS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP076_validate_movies_department() {
		logger.info("===> Iniciando caso de prueba: validate movies department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_MOVIES );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP077_validate_books_department() {
		logger.info("===> Iniciando caso de prueba: validate books department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_BOOKS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP078_validate_white_line_department() {
		logger.info("===> Iniciando caso de prueba: validate white line department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_WHITE_LINE );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP079_validate_electrodomestics_department() {
		logger.info("===> Iniciando caso de prueba: validate electrodomestics department");
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HOME_ELECTRONICS );
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP080_add_product() {
		logger.info("===> Iniciando caso de prueba: add product");
		departments.selectDepartmentOption();
		departments.selectDepartment();
		departments.selectFamily();
		departments.selectProduct();
		departments.addProduct();
		logger.info("Caso de prueba finalizado");
	}
}
