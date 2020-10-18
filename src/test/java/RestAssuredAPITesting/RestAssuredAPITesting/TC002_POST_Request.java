package RestAssuredAPITesting.RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	void RegistrationSuccessful()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject param=new JSONObject();
		param.put("FirstName", "Dikshit");
		param.put("LastName", "Bangera");
		param.put("UserName", "Dikshitbang");
		param.put("Password", "Dikshit123@");
		param.put("Email", "Dikshitbang@gmail.com");
		
		httprequest.header("Content-Type","application/json"); //Add a header stating the request body is a JSON
		httprequest.body(param.toJSONString()); // attach above data to the body of the request
		
		
		 //Response object
		Response response=httprequest.request(Method.POST,"/create");
		
		String responsebody=response.getBody().asString();
		//System.out.println(response.getBody());
		System.out.println(responsebody);
		
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 429);

//		String successcode=response.jsonPath().get("SuccessCode");
//		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
	}
	
}
