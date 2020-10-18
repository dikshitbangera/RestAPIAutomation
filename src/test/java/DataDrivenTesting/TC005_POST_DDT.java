package DataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.XLSUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_POST_DDT {

	@Test(dataProvider="TestData")
	public void postnewddt(String ename,String esal, String eage) {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		//create request object
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject param=new JSONObject();
		param.put("name", ename);
		param.put("salary", esal);
		param.put("age", eage);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(param.toJSONString());
		
		
		//create response object
		Response response=httprequest.request(Method.POST,"/create");
		
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
		
		
		
	}
	
	@DataProvider(name="TestData")
	public String[][] testdataddt() throws IOException {
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/RestAssured_Data.xlsx";
		int rowcount=XLSUtils.getRowCount(path, "Sheet1");
		int colcount=XLSUtils.getCellCount(path, "Sheet1", 1);
		
		String [][] empdata=new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				empdata[i-1][j]=XLSUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		//String[][] addnew= {{"Nivith","18000","20"},{"Nikhil","12000","24"}};
		return empdata;
	}
	
	
}
