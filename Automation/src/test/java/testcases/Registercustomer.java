package testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Registercustomer {
	@Test
	void registercustomerapi()//post request
	{
		RestAssured.baseURI="https://reqres.in/api/customer/";
		RequestSpecification httprequest =RestAssured.given();
		//response body
		//request payload sending along with post method
		JSONObject requestparams= new JSONObject();
		requestparams.put("FirstName", "madhukar");
		requestparams.put("LastName", "Guggilapu");
		requestparams.put("UserName", "madhukar1");
		requestparams.put("Password", "madhukar123");
		requestparams.put("Email", "madhukar015@gmail.com");
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparams.toJSONString());
		//httpRequest.body(requestParams.toJSONString());
		Response response=httprequest.request(Method.POST);
		System.out.println("response body is:"+response);
		
		String responsebody=response.getBody().asString();
		System.out.println("response body:"+responsebody);
		
		
		int statuscode=response.getStatusCode();
		System.out.println("statuscode code is:"+statuscode);
		Assert.assertEquals(statuscode, 201);
		//success code validation
		String susscesscode=response.jsonPath().get("successcode");
		//Assert.assertEquals(susscesscode, "cloudflare");
		
		
		
	}

}
