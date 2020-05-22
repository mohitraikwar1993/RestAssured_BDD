package restAssured_Tests;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationUtilities.RestUtils_UserData;
import io.restassured.RestAssured;

public class Demo3_PUTRequest 
{
	HashMap map=new HashMap();
	int emp_id=1;
	
	@BeforeClass
	public void putData()
	{
		map.put("name",RestUtils_UserData.getEmpName());
		map.put("salary", RestUtils_UserData.getSalary());
		map.put("age",RestUtils_UserData.getAge());
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
		
	}
	
	@BeforeMethod
	public void testStarts()
	{
		Reporter.log("Before method starts", true);
	}
	@Test
	public void putUserInfoTest()
	{
		
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
			.put()
			
		.then()
			.statusCode(20)
			.log().all();
		
	}
	
	@AfterMethod
	public void testends(ITestResult t)
	{
		if(t.isSuccess())
		{
			Reporter.log("test case pass", true);
			
		}
		if(!(t.isSuccess()))
		{
			Reporter.log("test case fail", true);
			
		}
		
	}
	
	
	
}
