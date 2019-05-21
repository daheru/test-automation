package com.automation.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesValuesUtil {
	
	private static Properties properties = null;
	
	private final static String CONFIG_PROPS = "Config.properties";
	private final static String WEB_ELEMENTS = "Web-Elements.properties";
	private final static String APP_MESSAGES = "AppMessages.properties";
	
	static {
		
		try {
			InputStream in = PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( CONFIG_PROPS );
			properties = new Properties();
			properties.load( in );
			Properties propertiesPlatform = new Properties();
			propertiesPlatform.load( PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( WEB_ELEMENTS ) );
			propertiesPlatform.load( PropertiesValuesUtil.class.getClassLoader().getResourceAsStream( APP_MESSAGES ) );
			properties.putAll( propertiesPlatform );
		} catch ( Exception ex ) {
			throw new RuntimeException( "Error en la lectura del archivo de propiedades " + CONFIG_PROPS, ex );
		}
		
	}
	
	public static String getPropertyName( String propertyName ) {
		return properties.getProperty( propertyName ) != null ? properties.getProperty( propertyName ) : "";
	}
}
