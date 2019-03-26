package com.bodega.constants;

import com.bodega.util.PropertiesValuesUtil;

public class AppMessages {

	private AppMessages() {
		
	}
	
	public static final String PASSWORD_RECOVERY = PropertiesValuesUtil.getPropertyName("PASSWORD_RECOVERY");
	public static final String REMOVE_ADDRESS = PropertiesValuesUtil.getPropertyName("REMOVE_ADDRESS");
	public static final String ADD_ADDRESS = PropertiesValuesUtil.getPropertyName("ADD_ADDRESS");
}
