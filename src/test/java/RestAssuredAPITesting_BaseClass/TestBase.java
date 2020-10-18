package RestAssuredAPITesting_BaseClass;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

public static Logger logger;
public static RequestSpecification httprequest;
public static Response response;
public String empid="23"; // hard coded value
	
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("restAPIAutomation");
		DOMConfigurator.configure("log4j.xml");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
	}
	
	@AfterClass
	public void teardown() {
		logger.info("*******The logs ends here*******");
	}
	
}
