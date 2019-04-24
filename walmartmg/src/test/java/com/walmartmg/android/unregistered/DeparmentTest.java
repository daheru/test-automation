package com.walmartmg.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.DepartmentsBusinessTest;
import com.walmartmg.enums.MenusEnum;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Department Module - No session")
public class DeparmentTest {
	
	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(DeparmentTest.class);
	private static DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	
	@AfterClass
	public static void tearnDown() {
		departments.driverDisconect();
	}

	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		departments.resetApp();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate computers department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that computers department has all categories and sub categories")
	public void CP055_validate_computers_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_COMPUTERS );
	}
	
	@Test
	@DisplayName("Validate tv department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that tv department has all categories and sub categories")
	public void CP056_validate_tv_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_TV_VIDEO );
	}
	
	@Test
	@DisplayName("Validate audio department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that audio department has all categories and sub categories")
	public void CP057_validate_audio_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_AUDIO );
	}
	
	@Test
	@DisplayName("Validate musical instruments department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that musical instrument department has all categories and sub categories")
	public void CP058_validate_musical_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_INSTRUMENTS );
	}
	
	@Test
	@DisplayName("Validate videogames department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that videogames department has all categories and sub categories")
	public void CP059_validate_videogames_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_VIDEOGAMES );
	}
	
	@Test
	@DisplayName("Validate mobiles department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that mobiles department has all categories and sub categories")
	public void CP060_validate_mobiles_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_MOBILES );
	}
	
	@Test
	@DisplayName("Validate photography department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that photograpy department has all categories and sub categories")
	public void CP061_validate_photography_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_PHOTOGRAPHY );
	}
	
	@Test
	@DisplayName("Validate forniture department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that forniture department has all categories and sub categories")
	public void CP062_validate_forniture_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_FORNITURE );
	}
	
	@Test
	@DisplayName("Validate kitchen department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that kitchen department has all categories and sub categories")
	public void CP063_validate_kitchen_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HOME_KITCHEN );
	}
	
	@Test
	@DisplayName("Validate mattress department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that mattress department has all categories and sub categories")
	public void CP064_validate_mattress_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_MATTRESSES );
	}
	
	@Test
	@DisplayName("Validate cars department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that cars department has all categories and sub categories")
	public void CP065_validate_cars_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_CARS );
	}
	
	@Test
	@DisplayName("Validate hardware store department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that hardware store department has all categories and sub categories")
	public void CP066_validate_hardware_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HARDWARE_STORE );
	}
	
	@Test
	@DisplayName("Validate fashion department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that fashion department has all categories and sub categories")
	public void CP067_validate_fashion_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_FASHION );
	}
	
	@Test
	@DisplayName("Validate health department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that health department has all categories and sub categories")
	public void CP068_validate_health_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HEALTH );
	}
	
	@Test
	@DisplayName("Validate beauty department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that beauty department has all categories and sub categories")
	public void CP069_validate_beauty_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_BEAUTY );
	}
	
	@Test
	@DisplayName("Validate sports department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that sports department has all categories and sub categories")
	public void CP070_validate_sports_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_SPORTS );
	}
	
	@Test
	@DisplayName("Validate garden department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that garden department has all categories and sub categories")
	public void CP071_validate_garden_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_GARDEN );
	}
	
	@Test
	@DisplayName("Validate babies department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that babies department has all categories and sub categories")
	public void CP072_validate_babies_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_BABIES );
	}
	
	@Test
	@DisplayName("Validate toys department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that toys department has all categories and sub categories")
	public void CP073_validate_toys_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_TOYS );
	}
	
	@Test
	@DisplayName("Validate office department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that office department has all categories and sub categories")
	public void CP074_validate_office_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_OFFICE );
	}
	
	@Test
	@DisplayName("Validate pets department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that pets department has all categories and sub categories")
	public void CP075_validate_pets_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_PETS );
	}
	
	@Test
	@DisplayName("Validate movies department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that movies department has all categories and sub categories")
	public void CP076_validate_movies_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_MOVIES );
	}
	
	@Test
	@DisplayName("Validate books department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that books department has all categories and sub categories")
	public void CP077_validate_books_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_BOOKS );
	}
	
	@Test
	@DisplayName("Validate white line department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that white line department has all categories and sub categories")
	public void CP078_validate_white_line_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_WHITE_LINE );
	}
	
	@Test
	@DisplayName("Validate electrodomestics department")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to search a product by department")
	@Description("Validate that electrodomestics department has all categories and sub categories")
	public void CP079_validate_electrodomestics_department() {
		departments.selectDepartmentOption();
		departments.validateDepartment( MenusEnum.DEP_HOME_ELECTRONICS );
	}
	
	@Test
	@DisplayName("Add product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to add a product usign department options")
	@Description("Validate that garden department has all categories and sub categories")
	public void CP080_add_product() {
		departments.selectDepartmentOption();
		departments.selectDepartment();
		departments.selectFamily();
		departments.selectProduct();
		departments.addProduct();
	}
}
