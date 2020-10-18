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

public class TC007_POST_CreateEmployeeRecord{

String empname=RestUtils.randomname();
String empage=RestUtils.randomage();
String empsalary=RestUtils.randomsalary();
	
public Response response;
	
	
	@BeforeClass
	void beforetest() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest=RestAssured.given();
		
		
		JSONObject param=new JSONObject();
		param.put("name", empname);
		param.put("salary",empsalary);
		param.put("age", empage);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(param.toJSONString());
		
		response=httprequest.request(Method.POST,"/create");

		
		
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
	
	

	
	
	
	
	
	
}
