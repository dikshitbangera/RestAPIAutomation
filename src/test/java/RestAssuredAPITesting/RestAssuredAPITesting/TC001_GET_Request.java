package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getweatherDetails() 
	{
		//Specify base URI
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response Object
		Response response=httprequest.request(Method.GET,"/employees");
		
		//print reponse in console
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
		
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("status"));
	
		System.out.println(jsonpath.get("data"));
		
		
		
//		String status=response.jsonPath().get("status");
//		Assert.assertEquals(status, "success");
		
//		int statuscode=response.getStatusCode();
//		Assert.assertEquals(statuscode,"200");
		
//		String statusline=response.getStatusLine();
//		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
	}
	
	
	
}
