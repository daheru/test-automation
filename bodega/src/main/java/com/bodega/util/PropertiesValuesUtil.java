package com.bodega.util;

import java.io.InputStream;
import java.util.Properties;

import com.bodega.constants.GeneralConstants;

public class PropertiesValuesUtil {
	
	private static Properties properties = null;
	
	private final static String CONFIG_PROPS = "Config.properties";
	private final static String ANDROID_ELEMENTS = "Android-Elements.properties";
	private final static String IOS_ELEMENTS = "IOS-Elements.properties";
	private final static String APP_MESSAGES = "AppMessages.properties";
	
	static {
		
		try {
			InputStream in = PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( CONFIG_PROPS );
			properties = new Properties();
			properties.load( in );
			Properties propertiesPlatform = new Properties();
			if( GeneralConstants.ANDROID.toLowerCase().equals(getPropertyName("PLATFORM_NAME").toLowerCase()) ) {
				propertiesPlatform.load( PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( ANDROID_ELEMENTS ) );
			} else {
				propertiesPlatform.load( PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( IOS_ELEMENTS ) );
			}
			propertiesPlatform.load( PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( APP_MESSAGES ) );
			properties.putAll( propertiesPlatform );
		} catch ( Exception ex ) {
			throw new RuntimeException( "Error en la lectura del archivo de propiedades " + CONFIG_PROPS, ex );
		}
		
	}
	
	public static String getPropertyName( String propertyName ) {
		return properties.getProperty( propertyName );
	}
}
