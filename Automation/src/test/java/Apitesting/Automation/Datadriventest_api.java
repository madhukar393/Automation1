package Apitesting.Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Datadriventest_api {
	@Test
	void postnewelployee() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestparams= new JSONObject();
	requestparams.put("name", "madhu");
	requestparams.put("salary", "7000");
	requestparams.put("age", "30");
	httprequest.header("Content-Type","application/json");
	httprequest.body(requestparams.toJSONString());
	Response response=httprequest.request(Method.POST,"/create");
	String responsebody=response.getBody().asString();
	Assert.assertEquals(responsebody.contains("madhu"),true);
	System.out.println("body:"+responsebody);
	Assert.assertEquals(responsebody.contains("7000"),true);
	Assert.assertEquals(responsebody.contains("30"),true);
 int statuscode=	response.getStatusCode();
 System.out.println("status:"+statuscode);
Assert.assertEquals(statuscode, 200);
	
	
	
		
	}

}
