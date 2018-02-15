package tests;

import beangist.Gist;
import beangist.GistContent;
import beangist.GistFile;
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

	private String token = "bbacb8c6943c551a7a4a51ad9bca76461f36ebbe";
	private String gistId = "cf68b988e5a047021e96309ddd335b1d";
	private Gist gist = new Gist();

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		RestAssured.baseURI = "https://api.github.com/gists/";
		
		GistContent content = new GistContent();
		content.setContent("file content");
		GistFile file = new GistFile();
		file.setFile(content);
		gist.setDescription("some description");
		gist.setPublic(true);
		gist.setFiles(file);
	}

	@Test(groups = "P0")
	public void verifyStatusCode_GET() {
		Response response = given().when().get(gistId +"?access_token=" + token);
		int actualStatusCode = response.statusCode();
		Assert.assertEquals(actualStatusCode, 200, "The status code isn't success");
	}

	@Test(groups = "P0")
	public void starGist_PUT() {
		Response response = given().when().put(gistId + "/star" +"?access_token=" + token);
		Assert.assertEquals(response.statusCode(), 204, "The status code there is a content");
	}

	@Test(groups = "P0", priority = 1)
	public void deleteGist_DELETE() {
		Response response = given().when().delete(gistId +"?access_token=" + token);
		Assert.assertEquals(response.statusCode(), 204, "The status code isn't not content");
	}

	@Test(groups = "P0")
	public void createGist_POST() {
		Response response = given().contentType("application/json").headers("Authorization: ", "token " +token).when().post("body", gist);
		Assert.assertEquals(response.statusCode(), 201, "The status code isn't created");
	}
}