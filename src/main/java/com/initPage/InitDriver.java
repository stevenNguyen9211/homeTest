package com.initPage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class InitDriver {

	private Logger LOGGER = LogManager.getLogger();
	public WebDriver wDriver = null;

	public InitDriver() {
		String browserDriver = System.getProperty("user.dir") + "/src/main/resources/";
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		

		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--whitelisted-ips");
		chromeOption.addArguments("--no-sandbox");
		chromeOption.addArguments("--disable-extensions");

		switch (os) {
		case "win":
			System.setProperty("webdriver.chrome.driver", browserDriver + "chromedriver.exe");
			break;
		case "mac":
			System.setProperty("webdriver.chrome.driver", browserDriver + "chromedriver_mac");
			break;
		default:
			LOGGER.info("There is no webdriver that is matched to selection");
		}

		wDriver = new ChromeDriver(chromeOption);
		wDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wDriver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return wDriver;
	}

	public SessionId getSessionID() {
		return ((RemoteWebDriver) (this.wDriver)).getSessionId();
	}

}
