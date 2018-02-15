package tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Katsiaryna_Skarzhyns on 2/12/2018.
 */
public class GitRestAssuredTests {

	private String token = "cd29a762d6d9167bbdef4af71045e5c950934433";
	private String gistId = "cf68b988e5a047021e96309ddd335b1d";

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		RestAssured.baseURI = "https://api.github.com/gists/";
	}

	@Test(groups = "P0")
	public void verifyStatusCode_GET() {
		Response response = given().when().get(gistId +"?access_token=" + token);
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200, "The status code isn't success");
	}

	@Test(groups = "P0", priority = 1)
	public void deleteGist_DELETE() {
		Response response = given().when().delete(gistId +"?access_token=" + token);
		Assert.assertEquals(response.statusCode(), 204, "The status code isn't not content");
	}

	@Test(groups = "P0")
	public void createGist_POST() {
		Response response = given().params("fileweqwe.txt", "myfile.txt", "description", "sdsdsd", "public", "true").contentType("application/json").headers("Authorization: ", "token " +token).when().post();
		Assert.assertEquals(response.statusCode(), 201, "The status code isn't created");
	}
}
//PUT-POST
