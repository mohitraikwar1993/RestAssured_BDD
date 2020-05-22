package commonUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) {
		String val="";
		try
		{
		Properties p=new Properties();
		p.load(new FileInputStream("./RestAssured_BDD/JiraInfo.properties"));
		val=p.getProperty("BaseURL");
		System.out.println(val);
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		

	}

}
