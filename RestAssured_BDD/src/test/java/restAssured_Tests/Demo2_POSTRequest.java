package restAssured_Tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationUtilities.RestUtils_UserData;
import io.restassured.RestAssured;

public class Demo2_POSTRequest {
	
	public static HashMap map=new HashMap();
	
	
	@BeforeClass
	public void postData()
	{
		map.put("FirstName", RestUtils_UserData.getFirstName());
		map.put("LastName", RestUtils_UserData.getLastName());
		map.put("UserName", RestUtils_UserData.getUserName());
		map.put("Password", RestUtils_UserData.getPassword());
		map.put("Email", RestUtils_UserData.getEmail());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
	}
	
	@Test
	public void postUserInfoTest()
	{
		given()
			.contentType("application/json")
			.body(map)
	
		.when()
			.post()
		
		.then()
			.statusCode(201)
			.and()
			.body( "SuccessCode", equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"));
		
	}

}
