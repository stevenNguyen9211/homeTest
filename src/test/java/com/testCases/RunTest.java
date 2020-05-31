package com.testCases;

import org.testng.annotations.AfterTest;

import com.initPage.Base;

public class RunTest {

	@AfterTest
	public void afterTest() {
		Base.getCurrentDriver().closeBrowser();
	}

}
