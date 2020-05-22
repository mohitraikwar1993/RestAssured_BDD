package restAssured_Tests;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GetRequest2 {
	
	@Test
	public void getWeatherDetails()
	{
		Response res=given().log().all()
		
		.when()
			.get("http://dummy.restapiexample.com/api/v1/employees")
			
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat()
			.header("Content-Type", "application/json;charset=utf-8").log().all()
			.extract().response();
		 
		String s=res.asString();
		JsonPath js=new JsonPath(s);
		
		int count=js.get("data.size()");
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			//System.out.println(js.get("data["+i+"].employee_name"));
			if(js.get("data["+i+"].employee_name").equals("Sonya Frost"))
					{
					System.out.println(js.get("data["+i+"].employee_age"));
					}
			
		}
		
		
		
		
	}

}
