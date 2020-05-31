package com.testCases;

import org.testng.annotations.Test;

import com.webpages.LoginPage;
import com.webpages.OperationPage;

public class TestFilterByStatus extends RunTest {
	@Test
	public void TestFilter() {
		new LoginPage().goToLoginPage().fillLoginForm();
		new OperationPage().verifyIsLogin().openFilter().selectStatusInactive();
	}
}
