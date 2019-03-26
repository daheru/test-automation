package com.bodega.constants;

import com.bodega.util.PropertiesValuesUtil;

public final class ConfigConstants {
	
	private ConfigConstants() {
		
	}
	
	public static final String APPIUM_URL_SERVER = PropertiesValuesUtil.getPropertyName("APPIUM_URL_SERVER");
	
	public static final String DEVICE_NAME = PropertiesValuesUtil.getPropertyName("DEVICE_NAME");
	public static final String UDID = PropertiesValuesUtil.getPropertyName("UDID");
	public static final String PLATFORM_NAME = PropertiesValuesUtil.getPropertyName("PLATFORM_NAME");
	public static final String PLATFORM_VERSION = PropertiesValuesUtil.getPropertyName("PLATFORM_VERSION");
	public static final String ATTRIBUTE_TEXT = PropertiesValuesUtil.getPropertyName("ATTRIBUTE_TEXT");
	
	public static final String APP_PACKAGE = PropertiesValuesUtil.getPropertyName("APP_PACKAGE");
	public static final String APP_PACKAGE_VALUE = PropertiesValuesUtil.getPropertyName("APP_PACKAGE_VALUE");
	public static final String APP_ACTIVITY = PropertiesValuesUtil.getPropertyName("APP_ACTIVITY");
	public static final String APP_ACTIVITY_VALUE = PropertiesValuesUtil.getPropertyName("APP_ACTIVITY_VALUE");
	public static final String NO_RESET = PropertiesValuesUtil.getPropertyName("NO_RESET");
	public static final String NO_RESET_VALUE = PropertiesValuesUtil.getPropertyName("NO_RESET_VALUE");
	public static final String AUTOMATION_NAME = PropertiesValuesUtil.getPropertyName("AUTOMATION_NAME");
	
	public static final String APP = PropertiesValuesUtil.getPropertyName("APP");
	
	public static final String APP_VERSION = PropertiesValuesUtil.getPropertyName("APP_VERSION");
}
