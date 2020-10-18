package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Authentication {

	
	@Test
	public void authentication() {
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		auth.setUserName("abc");
		auth.setPassword("pswd");
		RestAssured.authentication=auth;
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET,"/");
		String body=response.getBody().asString();
		System.out.println(body);
	}
}
