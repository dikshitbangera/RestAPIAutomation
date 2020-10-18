package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssuredAPITesting_BaseClass.TestBase;
import io.restassured.http.Method;

public class TC006_GET_EmployeeRecord extends TestBase {
	
	@BeforeClass
	public void beforetest() {
	
		response=httprequest.request(Method.GET, "/employees");
	}
	
	@Test
	public void responsebodyvalidtion() {
		String responsebody=response.getBody().asString();
		System.out.println("The response body is "+responsebody);
		Assert.assertEquals(responsebody.contains(empid),true);
		
	}
	
	
	@Test
	public void contenttype() {
		String contenttype=response.getContentType();
		System.out.println("The content type is "+contenttype);
		Assert.assertEquals(contenttype, "application/json;charset=utf-8");
	}
	
	
	@Test
	public void getserver() {
		String servertype=response.header("Server");
		System.out.println("The server Type is "+servertype);
		Assert.assertEquals(servertype, "nginx/1.16.0");
	}
	
	@Test 
	public void responsetime() {
		Long time=response.getTime();
		//System.out.println("The response time is "+time);
		
		if(time<6000) {
			System.out.println("The response time is "+time);
		}
		else {
			Assert.assertTrue(false);		}
	
	}
	
	@Test 
	public void contentlenght() {
		
		String length=response.getHeader("Content-Length");
		Assert.assertTrue(Integer.parseInt(length)<1500);
		
	}
	
}
