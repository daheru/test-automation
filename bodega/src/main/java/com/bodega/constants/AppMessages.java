package com.bodega.constants;

import com.bodega.util.PropertiesValuesUtil;

public class AppMessages {

	private AppMessages() {
		
	}
	
	public static final String PASSWORD_RECOVERY = PropertiesValuesUtil.getPropertyName("PASSWORD_RECOVERY");
	public static final String REMOVE_ADDRESS = PropertiesValuesUtil.getPropertyName("REMOVE_ADDRESS");
	public static final String ADD_ADDRESS = PropertiesValuesUtil.getPropertyName("ADD_ADDRESS");
	public static final String INVALID_EMAIL = PropertiesValuesUtil.getPropertyName("INVALID_EMAIL");
	public static final String UNEXPECTED_ERROR = PropertiesValuesUtil.getPropertyName("UNEXPECTED_ERROR");
	public static final String EMPTY_FIELD = PropertiesValuesUtil.getPropertyName("EMPTY_FIELD");
	public static final String EDIT_ADDRESS = PropertiesValuesUtil.getPropertyName("EDIT_ADDRESS");
	public static final String UNEXIST_EMAIL = PropertiesValuesUtil.getPropertyName("UNEXIST_EMAIL");
	public static final String WRONG_LOGIN_DATA = PropertiesValuesUtil.getPropertyName("WRONG_LOGIN_DATA");
}
