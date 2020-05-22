package commonUtilities;

import com.google.common.io.Files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.hamcrest.Matchers;
import io.restassured.path.json.*;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ResusableMethods 
{

	public static XmlPath rawToXML(Response r)
	{
		String x=r.asString();
		XmlPath xp=new XmlPath(x);
		return xp;
	}
	
	public static JsonPath rawToJSON(Response r)
	{
		String j=r.asString();
		JsonPath xp=new JsonPath(j);
		return xp;
	}
	
	public static String GenerateStringFromResouce(String path) throws IOException
	{
		
	
		return new String(java.nio.file.Files.readAllBytes(Paths.get(path)));
		
	}
	
	public static String getPropertyVal(String key) 
	{
		String val="";
		try
		{
		Properties p=new Properties();
		p.load(new FileInputStream("./JiraInfo.properties"));
		val=p.getProperty(key);
		System.out.println(val);
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return val;
		
	}
	
	
	public static String getSessionID() throws FileNotFoundException, IOException
	{
		
		RestAssured.baseURI=getPropertyVal("BaseURL");
		Response res=
		given()
			   .header("ContenType","application/json")
			   .body("{ \"username\": \"raikmohit\", \"password\": \"Mohit@9806\" }")
			   
		.when()
			.post(ResusableMethods.getPropertyVal("Res_SessionID"))
			
		.then()
			.assertThat()
			.statusCode(201)
			.extract().response();
	
		JsonPath js=rawToJSON(res);
		String sid=js.get("");
		System.out.println("session id ="+sid);
		return sid;
	}
}
