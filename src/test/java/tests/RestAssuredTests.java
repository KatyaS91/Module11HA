package tests;

import beanuser.User;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Katsiaryna_Skarzhyns on 2/12/2018.
 */
public class RestAssuredTests extends BaseTest {

	@Test(groups = "P0")
	public void verifyStatusCode() {
		Response response = given().get("/users").andReturn();
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200, "The status code isn't success");
	}

	@Test(groups = "P0")
	public void verifyResponseHeader() {
		Response response = given().get("/users").andReturn();
		String header = response.getHeader("content-type");
		Assert.assertTrue(header.contains("application/json"), "Application/json header isn't presented");
		Assert.assertTrue(header.contains("charset=utf-8"), "Charset isn't presented");
	}

	@Test(groups = "P0")
	public void verifyResponseBody() {
		Response response = given().get("/users").andReturn();
		User[] users = response.as(User[].class);
		Assert.assertEquals(users.length, 10, "The status code isn't success");
	}
}