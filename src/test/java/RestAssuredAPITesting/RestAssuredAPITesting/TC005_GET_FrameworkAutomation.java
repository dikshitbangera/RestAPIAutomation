package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssuredAPITesting_BaseClass.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC005_GET_FrameworkAutomation extends TestBase {
	
	
	@BeforeClass
	public void beforeTest() {
		
		logger.info("**********Started with TC005****************");
	
		response=httprequest.request(Method.GET,"/employees");
		
	}
	
	@Test
	public void responsebodyvalidation() {
		String responsebody=response.getBody().asString();
		System.out.println("The response body is "+responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	
	
	@Test
	public void contentencodingvalidtion() {
		String content=response.header("Content-Encoding");
		System.out.println("The content encoding is "+content);
		Assert.assertEquals(content, "gzip");
	}
	
	@Test
	public void statuscodevalidation() {
		int status=response.getStatusCode();
		System.out.println("The status code is "+status);
		Assert.assertEquals(status, 200);
	}

	
	@Test
	public void responsetimevalidation() {
		Long responsetime=response.getTime();
		
		if(responsetime<5000) {
			System.out.println("Th-*e response time is "+responsetime);
		}
		
		else {
			
			Assert.assertTrue(false);

	
		}
	}
	
}
