package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void googleMapTest()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Request object
		
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		
		Response response=httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s" );
		
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is "+responsebody);
		Assert.assertEquals(responsebody.contains("REQUEST_DENIED"),true);
		
		
		String encoding=response.header("Content-Encoding");
		System.out.println("The content encoding is "+encoding);
		Assert.assertEquals(encoding, "gzip");
		
		
		String content_type=response.contentType();
		System.out.println("The content Type is "+content_type);
		Assert.assertEquals(content_type, "application/xml; charset=UTF-8");
		
		//To print all headers
		Headers allheader=response.headers();
		
		for(Header header:allheader) {
			System.out.println(header.getName()+ "     "+header.getValue());
		}
		
		
		//New TC to check each value of JSON body
		
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("Content-Type"));
		
		
	}
	
	
}
