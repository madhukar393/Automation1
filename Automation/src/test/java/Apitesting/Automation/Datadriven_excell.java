package Apitesting.Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import utilities.Excel_methods;

public class Datadriven_excell {
	@Test(dataProvider="empdataprovider1")
	void datadrivent(String ename,String esalary,String eage)

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
	Assert.assertEquals(responsebody.contains("ename"),true);
	System.out.println("body:"+responsebody);
	Assert.assertEquals(responsebody.contains("esalary"),true);
	Assert.assertEquals(responsebody.contains("eage"),true);
 int statuscode=	response.getStatusCode();
 System.out.println("status:"+statuscode);
Assert.assertEquals(statuscode, 200);
	}
	
	@DataProvider(name="empdataprovider1")
	String[][] getempdata() throws Exception
	{
		//read data from excel
		String path="C:/Users/AVRNWA/eclipse-workspace/madhukarg/Automation/Xldata/employeedetails_excel.xlsx";
	int rownum=	Excel_methods.getRoeCount(path, "Sheet1");
	int columcount=Excel_methods.getcellcount(path, "Sheet1", 1);
	String empdata[][] = new String[rownum][columcount];
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<=columcount;i++) {
			empdata[i - 1][j] =Excel_methods.getcelldata(path,"Sheet1", i, j);
		
		}
	}
	return(empdata);
	
	
		
		
	}

}
