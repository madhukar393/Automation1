package Apitesting.Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Datadriven_array {
	@Test(dataProvider="empdataprovider")
	void newdata(String ename,String esalary,String eage)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject requestparams= new JSONObject();
	requestparams.put("name", "ename");
	requestparams.put("salary", "esalary");
	requestparams.put("age", "eage");
	httprequest.header("Content-Type","application/json");
	httprequest.body(requestparams.toJSONString());
	Response response=httprequest.request(Method.POST,"/create");
	String responsebody=response.getBody().asString();
	System.out.println("rsp"+responsebody);
	Assert.assertEquals(responsebody.contains("ename"),true);
	//System.out.println("body:"+responsebody);
	Assert.assertEquals(responsebody.contains("esalary"),true);
	Assert.assertEquals(responsebody.contains("eage"),true);
 int statuscode=	response.getStatusCode();
 System.out.println("status:"+statuscode);
Assert.assertEquals(statuscode, 200);
	}
	  @DataProvider(name="empdataprovider")
	String [][] getEmpData()
	{
		String empdata[][]= { {"madhu","3000","40"},{"sravv","5000","30"},{"nag","6000","47"}};
		return(empdata);
	

}
}