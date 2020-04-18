package utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;

import com.mongodb.diagnostics.logging.Logger;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testbase_class {
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empid="";
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		
		
	}

}
