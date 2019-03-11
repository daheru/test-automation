package com.bodega.util;

import java.io.InputStream;
import java.util.Properties;

import com.bodega.commons.GeneralConstants;

public class PropertiesValuesUtil {
	
	private static Properties properties = null;
	
	private final static String APPIUM_SELENIUM_PROPS = "AppiumSelenium.properties";
	private final static String ANDROID_PROPERTIES = "Appium-Android.properties";
	private final static String IOS_PROPERTIES = "Appium-IOS.properties";
	
	static {
		
		try {
			InputStream in = PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( APPIUM_SELENIUM_PROPS );
			properties = new Properties();
			properties.load( in );
			Properties propertiesPlatform = new Properties();
			if( GeneralConstants.ANDROID.toLowerCase().equals(getPropertyName("PLATFORM_NAME").toLowerCase()) ) {
				propertiesPlatform.load( PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( ANDROID_PROPERTIES ) );
			} else {
				propertiesPlatform.load( PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( IOS_PROPERTIES ) );
			}
			properties.putAll( propertiesPlatform );
		} catch ( Exception ex ) {
			throw new RuntimeException( "Error en la lectura del archivo de propiedades " + APPIUM_SELENIUM_PROPS, ex );
		}
		
	}
	
	public static String getPropertyName( String propertyName ) {
		return properties.getProperty( propertyName );
	}
}
