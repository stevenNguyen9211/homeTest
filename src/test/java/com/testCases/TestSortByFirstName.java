package com.testCases;

import org.testng.annotations.Test;

import com.webpages.LoginPage;
import com.webpages.OperationPage;

public class TestSortByFirstName extends RunTest {
	@Test
	public void TestSorting() {
		new LoginPage().goToLoginPage().fillLoginForm();
		new OperationPage().sortFirstName();
	}
}
