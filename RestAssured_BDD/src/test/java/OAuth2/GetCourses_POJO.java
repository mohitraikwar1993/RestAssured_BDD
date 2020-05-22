package OAuth2;
import static io.restassured.RestAssured.given;

import java.util.List;

import javax.management.Query;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;

import POJO.Api;
import POJO.GetCourse;
import POJO.WebAutomation;
@Test
public class GetCourses_POJO 

{
	static String accesstoken;
	static String code="4/wwEjuBpIdV66HPSVx3PQFZO74rHq4z3AHZAS6nNl64fYd329LqmuJAf0p_CH53Hrr8gplt9Qc-HYAGFh4B6W7Jc";
	
	public static void getAccessToken()
	{
		
		String accesstokenRes=
				given()
					.queryParams("code",code)
                    .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                    .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
     
                    
                    .queryParams("grant_type", "authorization_code")
                    .queryParams("state", "verifyfjdss")
                    .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                    .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

               .when()
               		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		System.out.println(accesstokenRes);
		JsonPath js=new JsonPath(accesstokenRes);
		String accesstoken=js.getString("access_token");
		System.out.println("access token="+accesstoken);
		
	
	
	
		GetCourse d=
				 given().
				queryParam("access_token",accesstoken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
				
				//System.out.println(course);
				
						
				List<POJO.WebAutomation> wb=d.getCourses().getWebAutomation();
				for(int i=0;i<wb.size();i++)
					
				{
					System.out.println(wb.get(i).getCourseTitle());
				}
				
				List<Api> ap=d.getCourses().getApi();
				for(int i=0;i<ap.size();i++)
				{
					if(ap.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
						System.out.println(ap.get(i).getPrice());
					}
				}
			
				
	}
	
}	
   
   

