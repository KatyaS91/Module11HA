package tests;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

/**
 * Created by Katsiaryna_Skarzhyns on 2/12/2018.
 */
public class BaseTest {

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}
}