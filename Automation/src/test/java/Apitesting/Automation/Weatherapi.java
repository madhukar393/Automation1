package Apitesting.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Weatherapi {
	@Test
	void weather()//get request
	{
		//specify base URI
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	//request obj
	RequestSpecification httpRequest= RestAssured.given();
	//response obj
	Response response=httpRequest.request(Method.GET,"/Karimnagar");
	//print response in console window
	String responsebody=response.getBody().asString();
	System.out.println("response body is:"+responsebody);
	//status code validation
	int statuscode=response.getStatusCode();
	System.out.println("statuscode code is:"+statuscode);
	Assert.assertEquals(statuscode, 200);
	//status line verification
	String statusline=response.getStatusLine();
	System.out.println("status line is:"+statusline);
	Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	


}
	@Test
	void registercustomerapi()//post request
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httprequest =RestAssured.given();
		//response body
		//request payload sending along with post method
		JSONObject requestparams= new JSONObject();
		requestparams.put("firstname", "madhukar");
		requestparams.put("lastname", "Guggilapu");
		requestparams.put("username", "madhukar");
		requestparams.put("password", "madhukar123");
		requestparams.put("email", "madhukar015@gmail.com");
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparams.toJSONString());
		Response response=httprequest.request(Method.POST,"/register");
		String responsebody=response.getBody().asString();
		System.out.println("response body is:"+responsebody);
		
		int statuscode=response.getStatusCode();
		System.out.println("statuscode code is:"+statuscode);
		Assert.assertEquals(statuscode, 201);
		//success code validation
		String susscesscode=response.jsonPath().get("successcode");
		Assert.assertEquals(susscesscode, "OPPERATION-SUCCESS");
		
		
		
	}
	
}