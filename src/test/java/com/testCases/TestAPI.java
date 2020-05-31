package com.testCases;

import org.testng.annotations.Test;

import com.API.API;

public class TestAPI {
	@Test
	public void testCallAPI() {
		new API().callGetEndpoint();
	}
}
