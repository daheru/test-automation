package com.walmartmg.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.FiltersBusinessTest;

public class FiltersTest {
	
	public static final Logger logger = Logger.getLogger( FiltersTest.class );
	public static FiltersBusinessTest filters = new FiltersBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		filters.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		filters.closeApp();
		filters.lauchApp();
	}
	
	@Test
	public void CP081_validate_filters() {
		logger.info("Start CP081 Filters");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.validateScreenFilter();
		logger.info("Termina validación");
	}
	
	@Test
	public void CP082_filter_order_by_az() {
		logger.info("Start CP082 Filter Order By A - Z");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.FilterOrderAZ();
	}
	
	@Test
	public void CP083_filter_order_by_za() {
		logger.info("Start CP083 Filter Order By Z - A");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.FilterOrderZA();
	}
	
	@Test
	public void CP084_filter_orderby_smallest_to_largest() {
		logger.info("Start CP084 Filter Order By $ - $$");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.FilterSmallestToLargest();
	}
	
	@Test
	public void CP085_filter_orderby_largest_to_smallest() {
		logger.info("Start CP085 Filter Order By $$ - $");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.FilterLargestToSmallest();
	}
	
	@Test
	public void CP086_filter_order_by_popularity () {
		logger.info("Start CP086 Filter Order By Popularity ");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.FilterPopularity();
	}
	
	@Test
	public void CP088_filter_filter_by () {
		logger.info("Start CP087 Filter Filter By ... ");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.FilterBy();
	}
}
