package com.walmartmg.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.constants.ConfigConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseDriver {

	private DesiredCapabilities caps;
	private static AppiumDriver<MobileElement> driver;
	private static int startPoint;
	private static int endPoint;
	private static int width;
	private Dimension size;
	private static WebDriverWait wait;
	private static TouchAction actions;

	private static final Logger logger = Logger.getLogger(BaseDriver.class.getName());

	public BaseDriver() {
		if (driver == null) {
			logger.info("Inicializando...");
			// Inicializar la configuracion de Appium Driver
			caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigConstants.DEVICE_NAME);
			caps.setCapability(MobileCapabilityType.UDID, ConfigConstants.UDID);
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigConstants.PLATFORM_NAME);
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigConstants.PLATFORM_VERSION);
			initDriver();
			initPropsWindow();
			initWait();
			initActions();
		}
	}

	public MobileElement findElement(String element) {
		if (element.startsWith(GeneralConstants.SLASH)) {
			return driver.findElement(By.xpath(element));
		}
		return driver.findElement(By.id(element));
	}

	public void tapOnElement(String element) {
		if (element.startsWith(GeneralConstants.SLASH)) {
			driver.findElement(By.xpath(element)).click();
		} else {
			driver.findElement(By.id(element)).click();
		}
	}
	
	public void tapOnElement(MobileElement element) {
        element.click();
    }
	
	public void fillElement( String element, String text ) {
		if( element.startsWith( GeneralConstants.SLASH ) ) {
			driver.getKeyboard();
			driver.findElement( By.xpath(element) ).sendKeys(text);
		} else {
			driver.findElement(By.id(element)).sendKeys(text);
		}
	}

	public List<MobileElement> findSubElements(MobileElement elementParent, String element) {
		if (element.startsWith(GeneralConstants.SLASH)) {
			return elementParent.findElements(By.xpath(element));
		}
		return elementParent.findElements(By.id(element));
	}
	
	public List<MobileElement> findElements(String element) {
		if (element.startsWith(GeneralConstants.SLASH)) {
			return driver.findElements(By.xpath(element));
		}
		return driver.findElements(By.id(element));
	}

	public WebElement waitVisibility(String element) {
		if (element.startsWith(GeneralConstants.SLASH)) {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		}
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}

	public boolean elementExist(String element) {
		List<MobileElement> elements = findElements(element);
		if (elements.size() > 0) {
			return true;
		}
		return false;
	}
	
	public String getText(String element) {
        return findElement(element).getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase();
    }

    public String getText(MobileElement element) {
        return element.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase();
    }
	
	public void tapUp( ) {
		actions.press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint));
		actions.release();
		actions.perform();
	}

	public void tapDown() {
		actions.press(PointOption.point(width, endPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(width, startPoint));
		actions.release();
		actions.perform();
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void lauchApp() {
		driver.launchApp();
	}

	public void closeApp() {
		driver.closeApp();
	}

	public void closeAndroidDialog() {
		if (elementExist(NamesMobileElements.DIALOG_CONTENT)) {
			tapOnElement(NamesMobileElements.DIALOG_ALLOW);
		}
	}

	public void desconectarDriver() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		} finally {
			driver.quit();
			driver = null;
		}
	}

	private void initAndroid() {
		// Inicializar caracteristicas de Android
		caps.setCapability(ConfigConstants.APP_PACKAGE, ConfigConstants.APP_PACKAGE_VALUE);
		caps.setCapability(ConfigConstants.APP_ACTIVITY, ConfigConstants.APP_ACTIVITY_VALUE);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigConstants.AUTOMATION_NAME);
		caps.setCapability(ConfigConstants.NO_RESET, ConfigConstants.NO_RESET_VALUE);
	}

	private void initIOS() {
		// Inicializar caracteristicas de IOS
		caps.setCapability(MobileCapabilityType.APP, ConfigConstants.APP);
	}

	private void initPropsWindow() {
		// Inicializar Propiedades de Ventana para el calculo del scroll
		if (size == null) {
			size = driver.manage().window().getSize();
		}
		width = size.width / 2;
		startPoint = (int) (size.getHeight() * 0.5);
		endPoint = (int) (size.getHeight() * 0.3);
	}

	private void initDriver() {
		// Inicializar driver
		try {
			// Seleccionar las configuraciones dependiendo el dispositivo
			if (GeneralConstants.ANDROID.toLowerCase().equals(ConfigConstants.PLATFORM_NAME.toLowerCase())) {
				initAndroid();
				driver = new AndroidDriver<MobileElement>(new URL(ConfigConstants.APPIUM_URL_SERVER), caps);
			} else {
				initIOS();
				driver = new IOSDriver<MobileElement>(new URL(ConfigConstants.APPIUM_URL_SERVER), caps);
			}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
		}
	}

	private void initWait() {
		wait = new WebDriverWait(driver, 20);
	}

	private void initActions() {
		actions = new TouchAction(driver);
	}
}
