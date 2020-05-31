package com.API;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.Utilities.Utilities;

import io.restassured.response.Response;

public class API {

	Utilities ulti = new Utilities();
	private Logger LOGGER = LogManager.getLogger();
	final private String endPoint = "https://my-json-server.typicode.com/typicode/demo/posts/1";

	public Map<Integer, String> get(String domain) {
		LOGGER.info("***** API GET: " + domain);
		int code = 0;
		int count = 1;
		String body = "";
		Map<Integer, String> result = new HashMap<Integer, String>();
		Response response = given().when().contentType("application/json").get(domain);
		body = response.asString();
		code = response.getStatusCode();
		count = count + 1;
		result.put(code, body);
		return result;
	}

	public void callGetEndpoint() {
		Map<Integer, String> result = get(endPoint);
		int responseCode = ulti.getFirstKeyinHashMap(result);
		String responseData = ulti.getFirstValueinHashMap(result);
		Assert.assertTrue(responseCode / 100 == 2, "Verify status code is 200");
		int idPost = ulti.getIntegerValueJson(responseData, "$.id");
		String titlePost = ulti.getValueJson(responseData, "$.title");
		Assert.assertTrue(idPost == 1);
		Assert.assertTrue(titlePost.contains("Post 1"));
	}

}
