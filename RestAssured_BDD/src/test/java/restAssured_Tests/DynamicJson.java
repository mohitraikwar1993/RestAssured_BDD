package restAssured_Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonUtilities.payload;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import commonUtilities.*;
import commonUtilities.DataProviders;
public class DynamicJson extends DataProviders
{
	
	@Test(dataProvider="testdata")
	public void addBook(String isbn, String aisle)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		Response r=
				given()
					   .header("Content-Type","application/json")
					   .body(payload.addbook(isbn,aisle)).log().all()
				.when()
						.post("/Library/Addbook.php")
				.then()
						.assertThat()
						.statusCode(200).log().all()
						.extract().response();
		
		System.out.println(r.asString());			
		JsonPath js=ResusableMethods.rawToJSON(r);
		System.out.println(js.get("ID"));
		
	}
	
	
}
