package restAssured_Tests.JIRA_Scripts;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.hamcrest.Matchers;
import io.restassured.path.json.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import commonUtilities.*;
import commonUtilities.ResusableMethods;

public class Create_NewBug 
{
	
@Test
public void createBug() throws FileNotFoundException, IOException
	{
		System.out.println(ResusableMethods.getPropertyVal("BaseURL"));
		RestAssured.baseURI=ResusableMethods.getPropertyVal("BaseURL");
		Response res=
		given()
			.contentType(ContentType.JSON)
			.header("Cookie", "JSESSIONID="+ResusableMethods.getSessionID())
			.body(" {\r\n" + 
					"   	\"fields\": \r\n" + 
					"   	{\r\n" + 
					"        \"project\": \r\n" + 
					"        {\r\n" + 
					"            \"key\":\"REST\"\r\n" + 
					"        },\r\n" + 
					"         \"summary\": \"Our 1st BUG using script\",\r\n" + 
					"        \"issuetype\": \r\n" + 
					"        {\r\n" + 
					"            \"name\": \"Bug\"\r\n" + 
					"        },\r\n" + 
					"         \"description\": \"Creating bug through Rest API\"\r\n" + 
					"    	\r\n" + 
					"     }\r\n" + 
					" }\r\n" + 
					" ").log().all()
		
		.when()
			.post(ResusableMethods.getPropertyVal("Res_CreateBug"))
		
		.then()
			.assertThat()
			.statusCode(201).log().all()
			.extract().response();
			
			JsonPath js=ResusableMethods.rawToJSON(res);
			String id=js.get("id");
			
	
	
	
	
	
	
	
	}
	

	
	
}
