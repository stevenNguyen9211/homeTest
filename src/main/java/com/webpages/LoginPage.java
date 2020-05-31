package com.webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.initPage.Base;
import com.initPage.WebPage;

public class LoginPage {

	final private static String HOMEPAGE_URL = "http://ktvn-test.s3-website.us-east-1.amazonaws.com";
	WebPage page = null;

	By loginForm = By.xpath("//*[contains(@class,'form__login')]");
	By inputEmail = By.xpath("//input[@id='formHorizontalEmail']");
	By loginPassword = By.xpath("//input[@id='formHorizontalPassword']");
	By btnLogin = By.xpath("//*[contains(@class,'login__btn')]");

	public LoginPage goToLoginPage() {
		page = Base.getCurrentDriver();
		page.openLink(HOMEPAGE_URL);
		page.checkLoadPage(2000);
		return this;
	}

	public LoginPage verifyLoginFormIsDisplayed() {
		Assert.assertTrue(page.waiting_presence_element(loginForm), "Verify login form is displayed");
		return this;
	}

	public LoginPage fillLoginForm() {
		page.writeText(inputEmail, "admin@test.com");
		page.writeText(loginPassword, "test123");
		page.waiting(1000);
		page.click(btnLogin);
		return this;

	}
}
