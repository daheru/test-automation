package com.bodega.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bodega.constants.ConfigConstants;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.google.common.collect.ImmutableMap;

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
		List<MobileElement> mobileElement = null;
		if (element.startsWith(GeneralConstants.SLASH)) {
			mobileElement = driver.findElements(By.xpath(element));
		} else {
			mobileElement = driver.findElements(By.id(element));
		}
		return mobileElement.size() > 0 ? mobileElement.get(0) : null;
	}

	public List<MobileElement> findElements(String element) {
		if (element.startsWith(GeneralConstants.SLASH)) {
			return driver.findElements(By.xpath(element));
		}
		return driver.findElements(By.id(element));
	}

	public List<MobileElement> findSubElements(MobileElement elementParent, String elementChild) {
		if (elementChild.startsWith(GeneralConstants.SLASH)) {
			return elementParent != null ? elementParent.findElements(By.xpath(elementChild))
					: new ArrayList<MobileElement>();
		}
		return elementParent != null ? elementParent.findElements(By.id(elementChild)) : new ArrayList<MobileElement>();
	}

	public List<MobileElement> findSubElements(String elementParent, String elementChild) {
		MobileElement parent = findElement(elementParent);
		return parent != null ? findSubElements(parent, elementChild) : new ArrayList<MobileElement>();
	}

	public MobileElement findSubElement(MobileElement elementParent, String elementChild) {
		List<MobileElement> childs = new ArrayList<MobileElement>();
		if (elementParent != null && elementChild.startsWith(GeneralConstants.SLASH)) {
			childs = elementParent.findElements(By.xpath(elementChild));
		} else if (elementParent != null) {
			childs = elementParent.findElements(By.id(elementChild));
		}
		return childs.size() > 0 ? childs.get(0) : null;
	}

	public MobileElement findSubElement(String elementParent, String elementChild) {
		MobileElement parent = findElement(elementParent);
		return parent != null ? findSubElement(parent, elementChild) : null;
	}

	public MobileElement findElementByClass(String className) {
		return driver.findElement(By.className(className));
	}

	public String getElementText(String element) {
		MobileElement textboxElement = findElement(element);
		return textboxElement != null ? textboxElement.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase() : "";
	}

	public String getElementText(MobileElement element) {
		return element != null ? element.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase() : "";
	}

	public void tapOnElement(String element) {
		MobileElement tapElement = findElement(element);
		if (tapElement != null) {
			tapElement.click();
		}
	}

	public void tapOnElement(MobileElement element) {
		if (element != null) {
			element.click();
		}
	}

	public void fillElement(String element, String text) {
		MobileElement textboxElement = findElement(element);
		if (textboxElement != null) {
			textboxElement.clear();
			textboxElement.click();
			textboxElement.sendKeys(text);
		}
	}

	public String getAttribute(String element, String attribute) {
		MobileElement elementMobile = findElement(element);
		if (elementMobile != null) {
			return elementMobile.getAttribute(attribute);
		}
		return GeneralConstants.EMPTY;
	}

	public String getAttribute(MobileElement element, String attribute) {
		if (element != null) {
			return element.getAttribute(attribute);
		}
		return GeneralConstants.EMPTY;
	}

	public void waitElementVisibility(String element) {
		boolean elementExist = false;
		try {
			if (element.startsWith(GeneralConstants.SLASH)) {
				elementExist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))) == null
						|| false ? false : true;
			} else {
				elementExist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))) == null
						|| false ? false : true;
			}
		} finally {
			assertTrue("El elemento " + element + " no existe", elementExist);
		}
	}

	public boolean elementExist(String element) {
		MobileElement elements = findElement(element);
		if (elements == null) {
			return false;
		}
		return true;
	}

	public void tapUp() {
		actions.press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(width, endPoint));
		actions.release();
		actions.perform();
	}

	public void tapDown() {
		actions.press(PointOption.point(width, endPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(width, startPoint));
		actions.release();
		actions.perform();
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void resetApp() {
		driver.resetApp();
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

	public void closeIOSDialog() {
		driver.executeScript("mobile: alert", ImmutableMap.of("action", "accept", "buttonLabel", "Allow"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		} finally {
			driver.executeScript("mobile: alert", ImmutableMap.of("action", "accept", "buttonLabel", "Allow"));
		}
	}
	
	public void driverDisconect() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		} finally {
			driver.quit();
			driver = null;
		}
	}

	public void waitEvent() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
	}

	public void assertEquals(String expected, String actual) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError error) {
			logger.error(error.getMessage());
			logger.error("Caso de prueba finalizado");
			Assert.fail("Caso de prueba finalizado con errores: " + error.getMessage());
		}
	}

	public void assertEquals(int expected, int actual) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError error) {
			logger.error(error.getMessage());
			logger.error("Caso de prueba finalizado con errores");
			Assert.fail("Caso de prueba finalizado con errores: " + error.getMessage());
		}
	}

	public void assertTrue(String error, boolean condition) {
		try {
			Assert.assertTrue(condition);
		} catch (AssertionError err) {
			logger.error(error);
			logger.error("Caso de prueba finalizado");
			Assert.fail("Caso de prueba finalizado con errores: " + error);
		}
	}

	public void searchOnAndroid() {
		hideKeyboard();
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
	}

	public void takeScreenShot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\vn0swlc\\Screenshot.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void scrollUntilShowElement(int scrollType, String element) {		
		int exit = 0;
		while(!elementExist(element) && exit++ < 15) {
			if (GeneralConstants.SCROLL_UP == scrollType) {
				tapUp();
			} else {
				tapDown();
			}
		}
	}

	private void initAndroid() {
		caps.setCapability(ConfigConstants.APP_PACKAGE, ConfigConstants.APP_PACKAGE_VALUE);
		caps.setCapability(ConfigConstants.APP_ACTIVITY, ConfigConstants.APP_ACTIVITY_VALUE);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigConstants.AUTOMATION_NAME);
		caps.setCapability("noReset", false);
	}

	private void initIOS() {
		caps.setCapability(MobileCapabilityType.APP, ConfigConstants.APP);
	}

	private void initPropsWindow() {
		if (size == null) {
			size = driver.manage().window().getSize();
		}
		width = (int) (size.width * 0.03);
		startPoint = (int) (size.getHeight() * 0.5);
		endPoint = (int) (size.getHeight() * 0.3);
	}

	private void initDriver() {
		try {
			if (GeneralConstants.ANDROID.toLowerCase().equals(ConfigConstants.PLATFORM_NAME.toLowerCase())) {
				initAndroid();
				driver = new AndroidDriver<MobileElement>(new URL(ConfigConstants.APPIUM_URL_SERVER), caps);
			} else {
				initIOS();
				driver = new IOSDriver<MobileElement>(new URL(ConfigConstants.APPIUM_URL_SERVER), caps);
			}
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
