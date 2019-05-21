package com.automation.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.constants.ConfigConstants;
import com.automation.constants.GeneralConstants;

/**
 * BaseDriver has encapsulated methods which provides appium and selenium
 * functionality
 * 
 * @author vn0swlc
 *
 */
public class BaseWeb {

	private static WebDriver driver;
	private static WebDriverWait wait;

	private static final Logger logger = Logger.getLogger(BaseWeb.class.getName());

	/**
	 * <p>
	 * {@code BaseWeb} constructor depends on compilation profile.
	 * </p>
	 * <p>
	 * Every profile gives a specific information to execute every test
	 * </p>
	 * <p>
	 * You can check {@link pom.xml} to verify and configure execution profiles
	 * </p>
	 */
	public BaseWeb() {
		if (driver == null) {
			initDriver();
			initWait();
		}
	}

	/**
	 * <p>
	 * Find a web element
	 * </p>
	 * 
	 * @param element the id of web element
	 * @return if {@code element} exist return WebElement, if not exist return
	 *         {@code null}
	 */
	protected WebElement findElement(String element) {
		List<WebElement> elements = driver.findElements(By.id(element));
		return elements.size() > 0 ? elements.get(0) : null;
	}

	/**
	 * <p>
	 * Find a list of web elements
	 * </p>
	 * 
	 * <p>
	 * Return a WebElement list with the same id
	 * </p>
	 * 
	 * @param element the id of web element
	 * @return if {@code element} exist return a WebElement list, if {@code element}
	 *         not exist return a empty list
	 */
	protected List<WebElement> findElements(String element) {
		return driver.findElements(By.id(element));
	}

	/**
	 * <p>
	 * Find a list of sub elements
	 * </p>
	 * 
	 * <p>
	 * Return a WebElement list with the same id which share the same WebElement
	 * parent
	 * </p>
	 * 
	 * @param parentElement the WebElement object
	 * @param childElement  the id of mobile element
	 * @return the WebElement list
	 */
	protected List<WebElement> findSubElements(WebElement parentElement, String childElement) {
		return parentElement != null ? parentElement.findElements(By.id(childElement)) : new ArrayList<WebElement>();
	}

	/**
	 * <p>
	 * Find a list of sub elements
	 * </p>
	 * 
	 * <p>
	 * Return a WebElement list with the same id which share the same WebElement
	 * parent
	 * </p>
	 * 
	 * @param parentElement the id of web element
	 * @param childElement  the id of web element
	 * @return the WebElement list
	 */
	protected List<WebElement> findSubElements(String parentElement, String childElement) {
		WebElement parent = findElement(parentElement);
		return parent != null ? findSubElements(parent, childElement) : new ArrayList<WebElement>();
	}

	/**
	 * <p>
	 * Find a sub web element
	 * </p>
	 * 
	 * <p>
	 * Return a WebElement who has specific parent element
	 * </p>
	 * 
	 * @param parentElement the WebElement object
	 * @param childElement  the id of web element
	 * @return if {@code childElement} exist return a WebElement, if not exist
	 *         return {@code null}
	 */
	protected WebElement findSubElement(WebElement parentElement, String childElement) {
		List<WebElement> childs = parentElement.findElements(By.id(childElement));
		return childs.size() > 0 ? childs.get(0) : null;
	}

	/**
	 * <p>
	 * Find a sub mobile element
	 * </p>
	 * 
	 * <p>
	 * Return a WebElement who has specific parent element
	 * </p>
	 * 
	 * @param parentElement the id of web element
	 * @param childElement  the id of web element
	 * @return if {@code childElement} exist return a WebElement, if not exist
	 *         return {@code null}
	 */
	protected WebElement findSubElement(String elementParent, String elementChild) {
		WebElement parent = findElement(elementParent);
		return parent != null ? findSubElement(parent, elementChild) : null;
	}

	/**
	 * <p>
	 * Get element text
	 * </p>
	 * 
	 * <p>
	 * Get the value of text attribute for the web element
	 * </p>
	 * 
	 * @param element the text of web element
	 * @return the {@code String} of text attribute
	 */
	protected String getElementText(String element) {
		WebElement textboxElement = findElement(element);
		return textboxElement != null ? textboxElement.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase() : "";
	}

	/**
	 * <p>
	 * Get element text
	 * </p>
	 * 
	 * <p>
	 * Get the value of text attribute for the web element
	 * </p>
	 * 
	 * @param element the WebElement object
	 * @return the {@code String} of text attribute
	 */
	protected String getElementText(WebElement element) {
		return element != null ? element.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase() : "";
	}

	/**
	 * <p>
	 * Click on web element
	 * </p>
	 * 
	 * <p>
	 * This method execute the click action on the web page
	 * </p>
	 * 
	 * @param element the id of web element
	 */
	protected void clickOnElement(String element) {
		WebElement tapElement = findElement(element);
		if (tapElement != null) {
			tapElement.click();
		}
	}

	/**
	 * <p>
	 * Click on web element
	 * <p>
	 * 
	 * <p>
	 * This method execute the click action on the web page
	 * </p>
	 * 
	 * @param element the WebElement object
	 */
	protected void clickOnElement(WebElement element) {
		if (element != null) {
			element.click();
		}
	}

	/**
	 * <p>
	 * Fill web element with given information
	 * <p>
	 * 
	 * <p>
	 * This method execute the sendKeys action on the web page
	 * </p>
	 * 
	 * @param element the id of mobile element
	 * @param text    the data that will be entered
	 * 
	 */
	protected void fillElement(String element, String text) {
		WebElement textboxElement = findElement(element);
		if (textboxElement != null) {
			textboxElement.clear();
			textboxElement.sendKeys(text);
		}
	}

	/**
	 * <p>
	 * Get the attribute value
	 * <p>
	 * 
	 * <p>
	 * Obtain the value of the given WebElemnt attribute
	 * </p>
	 * 
	 * @param element   the id of web element
	 * @param attribute the name of web element attribute
	 * 
	 */
	protected String getAttribute(String element, String attribute) {
		WebElement elementMobile = findElement(element);
		if (elementMobile != null) {
			return elementMobile.getAttribute(attribute);
		}
		return GeneralConstants.EMPTY;
	}

	/**
	 * <p>
	 * Get the attribute value
	 * <p>
	 * 
	 * <p>
	 * Obtain the value of the given WebElemnt attribute
	 * </p>
	 * 
	 * @param element   the WebElement object
	 * @param attribute the name of web element attribute
	 * 
	 */
	protected String getAttribute(WebElement element, String attribute) {
		if (element != null) {
			return element.getAttribute(attribute);
		}
		return GeneralConstants.EMPTY;
	}

	/**
	 * <p>
	 * Wait 20 seconds for a Web Element appears
	 * </p>
	 * <p>
	 * If element not appears an assert is launched
	 * </p>
	 * 
	 * @param element the id of web element
	 */
	protected void waitElementVisibility(String element) {
		boolean elementExist = false;
		try {
			elementExist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))) == null || false
					? false
					: true;
		} finally {
			assertTrue("El elemento " + element + " no existe", elementExist);
		}
	}

	/**
	 * <p>
	 * Verify if element exist
	 * </p>
	 * 
	 * @param element the id of web element
	 * @return {@code true} if element exist, {@code false} if element not exist
	 */
	protected boolean elementExist(String element) {
		WebElement elements = findElement(element);
		if (elements == null) {
			return false;
		}
		return true;
	}

	/**
	 * <p>
	 * Disconect driver
	 * </p>
	 * <p>
	 * Execute quit driver action. It's very important to call this method at the
	 * end of every test suit
	 * </p>
	 * 
	 */
	public void driverDisconect() {
		driver.quit();
		driver = null;
	}

	/**
	 * <p>
	 * Wait Event
	 * </p>
	 * <p>
	 * Wait 3 seconds until a new action is executed
	 * </p>
	 * 
	 */
	protected void waitEvent() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * <p>
	 * Customized assert equals. If assert is false log the problem, throws and
	 * assert fail
	 * </p>
	 * <p>
	 * and stop the test
	 * </p>
	 * 
	 * @param expected the expected param
	 * @param actual   the actual param
	 * 
	 */
	protected void assertEquals(String expected, String actual) {
		try {
			Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());
		} catch (AssertionError error) {
			logger.error(error.getMessage());
			logger.error("Caso de prueba finalizado");
			Assert.fail("Caso de prueba finalizado con errores: " + error.getMessage());
		}
	}

	/**
	 * <p>
	 * Customized assert equals. If assert is false log the problem, throws and
	 * assert fail
	 * </p>
	 * <p>
	 * and stop the test
	 * </p>
	 * 
	 * @param expected the expected param to compare with actual
	 * @param actual   the actual param to compare with expected
	 * 
	 */
	protected void assertEquals(int expected, int actual) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError error) {
			logger.error(error.getMessage());
			logger.error("Caso de prueba finalizado con errores");
			Assert.fail("Caso de prueba finalizado con errores: " + error.getMessage());
		}
	}

	/**
	 * <p>
	 * Customized assert true. If assert is false log the problem, throws and assert
	 * fail
	 * </p>
	 * <p>
	 * and stop the test
	 * </p>
	 * 
	 * @param error     the error that will be showed if the assert fails
	 * @param condition the condition that assert will validate
	 * 
	 */
	protected void assertTrue(String error, boolean condition) {
		try {
			Assert.assertTrue(condition);
		} catch (AssertionError err) {
			logger.error(error);
			logger.error("Caso de prueba finalizado");
			Assert.fail("Caso de prueba finalizado con errores: " + error);
		}
	}

	protected void navigationBack() {
		driver.navigate().back();
	}

	private void initWeb() {
		if (ConfigConstants.PLATFORM_NAME.toLowerCase().equals(GeneralConstants.CHROME.toLowerCase())) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	private void initDriver() {
		initWeb();
		driver.get(ConfigConstants.WEB_PAGE);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	private void initWait() {
		wait = new WebDriverWait(driver, 20);
	}
}
