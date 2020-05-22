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
public class StaticJson extends DataProviders
{
	static String ID; 
	@Test()
	public void addBook() throws IOException
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		Response r=
				given()
					   .header("Content-Type","application/json")
					   .body(ResusableMethods.GenerateStringFromResouce("C:\\Users\\Beauty\\Documents\\addbook.json")).log().all()
				.when()
						.post("/Library/Addbook.php")
				.then()
						.assertThat()
						.statusCode(200).log().all()
						.extract().response();
		
		System.out.println(r.asString());			
		JsonPath js=ResusableMethods.rawToJSON(r);
		ID=js.get("ID");
		System.out.println(ID);
		
	}
	
	@Test()
	public void delBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res=
				given()
					.header("Content-Type","application/json")
					.body(payload.deleteBook(ID))
				.when()
					.post("/Library/DeleteBook.php")
				.then()
					.assertThat()
					.statusCode(200).log().all()
					.extract().response();
					
		System.out.println(res.asString());
		
		
	}
	
	@Test()
	public void getbook()
	{
		
RestAssured.baseURI="http://216.10.245.166";
		
		Response res=
				given()
					.header("Content-Type","application/json")
					
				.when()
					.post("/Library/GetBook.php?ID="+ID)
				.then()
					.assertThat()
					.statusCode(404).log().all()
					.extract().response();
					
		System.out.println(res.asString());	
	}
	
	
}
