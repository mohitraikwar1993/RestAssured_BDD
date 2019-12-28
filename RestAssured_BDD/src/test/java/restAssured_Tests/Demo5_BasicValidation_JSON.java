package restAssured_Tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Demo5_BasicValidation_JSON
{
	@Test(priority=1)
	public void testStatusCode()
	{
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
			
		.then()
			.statusCode(200);
		
	}
	
	@Test(priority=2)
	public void testlogging()
	{
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
			
		.then()
			.log().all();	
	}
	
	@Test(priority=3)
	public void testSingleContent()
	{
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
			
		.then()
			.body("title" , equalTo("nesciunt quas odio"))
			.log().all();	
		
	}
	
	@Test(priority=4)
	public void testMultipleContent()
	{
		given()
		.when()
			.get("http://jsonplaceholder.typicode.com/posts")
			
		.then()
			.body("id" , hasItems(5,1,7,8))
			.log().all();	
		
	}
	
	
}
