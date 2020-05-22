package restAssured_Tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GetRequest {
	
	@Test
	public void getWeatherDetails()
	{
		given()
		
		.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/Bangalore")
			
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("City", equalTo("Bengaluru"))
			.header("Content-Type", "application/json")
			.header("Content-Length", "169");
		
		
		
	}

}
