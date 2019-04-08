package com.walmartmg.constants;

import com.walmartmg.util.PropertiesValuesUtil;

public class AppMessages {

	private AppMessages() {
		
	}
	
	public static final String ADD_PRODUCT = PropertiesValuesUtil.getPropertyName("ADD_PRODUCT");
	public static final String DELETE_PRODUCT = PropertiesValuesUtil.getPropertyName("DELETE_PRODUCT");
	public static final String UPDATE_PRODUCT = PropertiesValuesUtil.getPropertyName("UPDATE_PRODUCT");
	public static final String UNEXPECTED_ERROR = PropertiesValuesUtil.getPropertyName("UNEXPECTED_ERROR");
	public static final String NO_EMAIL = PropertiesValuesUtil.getPropertyName("NO_EMAIL");
	public static final String NO_PASS = PropertiesValuesUtil.getPropertyName("NO_PASS");
	public static final String LOGIN_FAIL = PropertiesValuesUtil.getPropertyName("LOGIN_FAIL");
	public static final String EMPTY_FIELD = PropertiesValuesUtil.getPropertyName("EMPTY_FIELD");
	public static final String INVALID_ACCOUNT_NAME = PropertiesValuesUtil.getPropertyName("INVALID_ACCOUNT_NAME");
	public static final String INVALID_ACCOUNT_LAST_NAME = PropertiesValuesUtil.getPropertyName("INVALID_ACCOUNT_LAST_NAME");
	public static final String INVALID_ACCOUNT_EMAIL = PropertiesValuesUtil.getPropertyName("INVALID_ACCOUNT_EMAIL");
	public static final String INVALID_ACCOUNT_PASS = PropertiesValuesUtil.getPropertyName("INVALID_ACCOUNT_PASS");
	public static final String ACCOUNT_EXIST_EMAIL = PropertiesValuesUtil.getPropertyName("ACCOUNT_EXIST_EMAIL");
	public static final String CREATE_ACCOUNT_SUCCESS = PropertiesValuesUtil.getPropertyName("CREATE_ACCOUNT_SUCCESS");
	public static final String ACCOUNT_UNEXIST_EMAIL = PropertiesValuesUtil.getPropertyName("ACCOUNT_UNEXIST_EMAIL");
	
}
