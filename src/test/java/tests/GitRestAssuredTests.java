package tests;

import beangist.Gist;
import beangist.GitFile;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Katsiaryna_Skarzhyns on 2/12/2018.
 */
public class GitRestAssuredTests {

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		RestAssured.baseURI = "https://github.com";
	}

	@Test(groups = "P0")
	public void verifyStatusCode() {
		Response response = given().get("/KatyaS91?tab=repositories").andReturn();
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200, "The status code isn't success");
	}

	@Test(groups = "P0")
	public void verifyGistsCount() {
		RequestSpecification request = given();
		Gist requestParams = new Gist();
		GitFile file = new GitFile();
		file.setContent("sdsdfsdfsdfsdf");
		requestParams.setFile(file);
		requestParams.setDescription("Test");
		requestParams.setPublic(false);
		request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		Response response = request.post("/gists");
		Assert.assertEquals(response.getStatusCode(), 200, "The status code isn't success");
	}
}
