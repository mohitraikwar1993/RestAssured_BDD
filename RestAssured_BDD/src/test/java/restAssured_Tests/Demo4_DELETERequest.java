package restAssured_Tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETERequest {
	
	@Test
	public void deleteEmployeeRecord()
	{
		int empid=1;
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/"+empid;
		
		Response resp=
		given()
			
		.when()
			.delete()
			
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		String jsonResp=resp.asString();
		Assert.assertEquals(jsonResp.contains("successfully! deleted Records"), true);
		
		
	}
	
	
	
	
	
	

}
