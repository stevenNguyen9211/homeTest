package com.webpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.common.collect.Ordering;
import com.initPage.Base;
import com.initPage.WebPage;

public class OperationPage {
	WebPage page = null;

	final private String statusInactive = "inactive";
	By adminTab = By.xpath("//*[@id='basic-nav-dropdown']");
	By filter = By.xpath("//button[contains(@class,'btn-filter module')]");
	By titlePopUpFilter = By.xpath("//*[@class='modal-title' and text()='Filters']");
	By selStatus = By.xpath("//*[@id='formControlsSelect']");
	By btnApplyFilter = By.xpath("//button[contains(@class,'btn-filter btn')]");
	By filterTagInactive = By.xpath("//*[contains(@class,'filter__item') and text()='Inactive']");
	By colFirtName = By.xpath("//*[@title='First Name']");
	By tableStuden = By.xpath("//table[contains(@class,'table-body')]");
	By listStudent = By.xpath("//table[contains(@class,'table-body')]//tr");
	By listFirtName = By.xpath("//table[contains(@class,'table-body')]//td[6]");

	public OperationPage() {
		page = Base.getCurrentDriver();
		page.checkLoadPage(3000);
	}

	public OperationPage verifyIsLogin() {
		Assert.assertTrue(page.existsElement(adminTab), "Verify user logs in successfully");
		return this;
	}

	public OperationPage openFilter() {
		page.click(filter);
		page.waiting_presence_element(titlePopUpFilter);
		return this;
	}

	public OperationPage selectFilterByStatus(String status) {
		page.click(selStatus);
		page.waiting_presence_element(titlePopUpFilter);
		page.selectByValue(selStatus, status);
		page.waiting(1000);
		page.click(btnApplyFilter);
		page.waiting_presence_element(filterTagInactive);
		return this;
	}

	public OperationPage selectStatusInactive() {
		selectFilterByStatus(statusInactive);
		return this;
	}

	public OperationPage sortFirstName() {
		page.click(colFirtName);
		page.waiting(1000);
		int numberStudents = page.numberElement(listStudent);
		List<String> listFirtNameString = new ArrayList<String>();
		for (int i = 0; i < numberStudents; i++) {
			String temp = page.getText(listFirtName, String.valueOf(i + 1));
			listFirtNameString.add(temp);
		}
		boolean isSorted = Ordering.natural().isOrdered(listFirtNameString);
		Assert.assertTrue(isSorted, "Verify the FirstName is sorted by Alphabet");
		return this;
	}
}
