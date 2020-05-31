package com.initPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPage {

	private Logger LOGGER = LogManager.getLogger();
	private InitDriver webdriver = null;
	private WebDriver driver = null;

	public WebPage() {
		webdriver = new InitDriver();
		driver = webdriver.getDriver();
	}

	public void waiting(int milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			LOGGER.error("Interrupted!: " + e);
			LOGGER.catching(e);
			Thread.currentThread().interrupt();
		}
	}

	public SessionId getSessionID() {
		return this.webdriver.getSessionID();
	}

	public void checkLoadPage(int timeOutInSeconds) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsCommand = "return document.readyState";

		// Validate readyState before doing any waits
		if (js.executeScript(jsCommand).toString().equals("complete")) {
			return;
		}

		for (int i = 0; i < timeOutInSeconds; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (js.executeScript(jsCommand).toString().equals("complete")) {
				break;
			}
		}
	}

	/**
	 * Checking exist element by element location.
	 * 
	 * @param elementLocation
	 */
	public boolean existsElement(By elementLocation) {
		try {
			driver.findElement(elementLocation);
		} catch (NoSuchElementException e) {
			LOGGER.warn("Element is not found: " + elementLocation.toString());
			return false;
		}
		LOGGER.info("Element is found: " + elementLocation.toString());
		return true;
	}

	/**
	 * Waiting a element in 30s or until this element is presence.
	 * 
	 * @param elementLocation
	 */
	public boolean waiting_presence_element(By elementLocation) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			LOGGER.info("WAITING " + elementLocation + " after 30s waiting");
			wait.until(ExpectedConditions.presenceOfElementLocated(elementLocation));
			return true;
		} catch (TimeoutException e) {
			LOGGER.error("Not found " + elementLocation + " after 30s waiting");
			LOGGER.catching(e);
			return false;
		}
	}

	/**
	 * Open link
	 * 
	 * @param url
	 */
	public void openLink(String url) {
		driver.get(url);
		LOGGER.info("Successfully open URL:" + url);
	}

	/**
	 * get current url
	 */
	public String getUrl() {
		String url = driver.getCurrentUrl();
		LOGGER.info("Current page url: " + url);
		return url;
	}

	public void click(By elementLocation) {
		LOGGER.info("Click " + elementLocation);
		WebElement ele = driver.findElement(elementLocation);
		if (ele != null) {
			try {
				ele.click();
			} catch (ElementClickInterceptedException e) {
				LOGGER.info("Wait 5s and click again " + elementLocation + "on page");
				waiting(5000);
				ele.click();
			}
			waiting(2000);
		} else {
			LOGGER.error("NOT FOUND " + elementLocation + "on page");
		}
	}

	public void writeText(By elementLocation, String text) {
		WebElement ele = driver.findElement(elementLocation);
		LOGGER.info("WRITE " + text);
		if (ele != null) {
			ele.sendKeys(text);
		} else {
			LOGGER.error("NOT FOUND " + elementLocation + "on page");
		}
	}

	public void selectByValue(By elementLocation, String value) {
		Select selectEle = new Select(driver.findElement(elementLocation));
		LOGGER.info("Select dropdown list by value " + value);
		if (value != null) {
			selectEle.selectByValue(value);
		} else {
			LOGGER.error("NOT FOUND value" + elementLocation + "on dropdown list");
		}
	}

	public void closeBrowser() {
		LOGGER.info("Close Session");
		driver.quit();
	}

	public int numberElement(By elementLocation) {
		LOGGER.info("GET NUMBER ELEMENT " + elementLocation);
		return driver.findElements(elementLocation).size();
	}

	public String getSelectorAsString(By elementLocation) {
		String str = elementLocation.toString();
		return str.substring(str.indexOf("/"), str.length());
	}

	public String getText(By elementLocation, String index) {
		LOGGER.info("GET TEXT AT " + elementLocation);
		String strElementLocation = String.format(elementLocation.toString(), index);
		String[] element = strElementLocation.split(" ");
		String strType = element[0];
		String strQuery = strElementLocation.substring(strType.length() + 1);

		switch (strType) {
		case "By.xpath:":
			elementLocation = By.xpath(strQuery);
			break;
		case "By.id:":
			elementLocation = By.id(strQuery);
			break;
		case "By.name:":
			elementLocation = By.name(strQuery);
			break;
		case "By.linkText:":
			elementLocation = By.linkText(strQuery);
			break;
		}
		WebElement ele = driver.findElement(elementLocation);
		String text = "";
		if (ele != null) {
			text = ele.getText();
			LOGGER.info("TEXT: " + text);
		} else {
			LOGGER.error("NOT FOUND " + elementLocation + "on page");
			text = "NOT FOUND";
		}
		return text;
	}

}
