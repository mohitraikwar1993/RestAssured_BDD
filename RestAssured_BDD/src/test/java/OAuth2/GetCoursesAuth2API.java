package OAuth2;
import static io.restassured.RestAssured.given;


import javax.management.Query;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;

public class GetCoursesAuth2API 

{
	static String accesstoken;
	static String code="4/wwF2z1NMOq_ciMG_0oIphepbv47XK-OGt9imskeCJw1VfDy277Fmk9HPlN2EfMaTzllt_DGtDM8jKdXbPtlzt2M";
	
	@Test(priority=1)
	public static void getAccessToken()
	{
		
		String accesstokenRes=given().urlEncodingEnabled(false)
						.queryParams("code",code)
                       .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                       .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                       .queryParams("grant_type", "authorization_code")
                       .queryParams("state", "verifyfjdss")
                       .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                       .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

                        .when().log().all()
                        .post("https://www.googleapis.com/oauth2/v4/token").asString();
		System.out.println(accesstokenRes);
		JsonPath js=new JsonPath(accesstokenRes);
		String accesstoken=js.getString("access_token");
		System.out.println("access token="+accesstoken);
		
	
	
	
	String res=given().
	queryParam("access_token",accesstoken).log().all().
	when().
	get("https://rahulshettyacademy.com/getCourse.php").asString();
	System.out.println(res);
	
	}}	
   
   

