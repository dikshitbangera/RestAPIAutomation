package RestAssuredAPITesting.RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssuredAPITesting_BaseClass.TestBase;
import Utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_PUT_UpdateEmployeeRecord extends TestBase {

	

String empname=RestUtils.randomname();
String empsalary=RestUtils.randomsalary();
String empage=RestUtils.randomage();

	
	
	
	@BeforeClass
	void beforetest() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject param=new JSONObject();
		param.put("name", empname );
		param.put("salary", empsalary);
		param.put("age", empage);
		
		httprequest.header("Content-Type","applicatio/json");
		httprequest.body(param.toJSONString());
		
		Response response=httprequest.request(Method.PUT, "/update/"+empid);
		
		//Response response=httprequest.request(Method.DELETE, "/delete/");
	
		
	}
	
	
	@Test
	public void responsebodyvalidtion() {
		String postbody=response.getBody().asString();
		System.out.println("The response body is "+postbody);
		
	}
	
	@Test
	public void getstatusline() {
		String statusline=response.getStatusLine();
		System.out.println("The status line is "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 201 Created");
	}
	
	@Test
	public void chechdata() {
		String responsebody=response.getBody().asString();
		Assert.assertEquals(responsebody.contains(empname), true);
		Assert.assertEquals(responsebody.contains(empsalary), true);
		Assert.assertEquals(responsebody.contains(empage), true);
	}
}
