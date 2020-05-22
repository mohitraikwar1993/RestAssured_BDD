package MapAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import POJO.AddPlace;
import POJO.Location;

public class AddPlaceMap
{

	@Test
	public static void getlocation()
	{
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace ad=new AddPlace();
		ad.setAccuracy(50);
		ad.setAddress("29, side layout, cohen 09");
		ad.setLanguage("French-IN");
		ad.setName("Frontline house");
		ad.setPhone_number("(+91) 983 893 3937");
		ad.setWebsite("http://google.com");
		Location lc=new Location();
		lc.setLat(-38.383494);
		lc.setLng(33.427362);
		ad.setLocation(lc);
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		ad.setTypes(list);
		
		
		RequestSpecification resp=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		ResponseSpecification respop=new ResponseSpecBuilder().expectStatusCode(200).build();
		
		String res=given().log().all().spec(resp)
		//.queryParam("key","qaclick123")
		//.contentType(ContentType.JSON)
		.body(ad)
		.when()
		.post("/maps/api/place/add/json")
		.then()
		.spec(respop).extract().response().asString();
		System.out.println(res);
       
		
		
		
		
		
		
		
		
	
	}
	
}
