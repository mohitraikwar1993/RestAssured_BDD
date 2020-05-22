package commonUtilities;

public class payload {
	
	public static String addbook(String isbn,String aisle)
	{
		String b="{\r\n\r\n\"name\":\"Learn Appium Automation with Java8\",\r\n\"isbn\":\""+isbn+"\",\r\"aisle\":\""+aisle+"\",\r\"author\":\"Mohity\"\r\n}\r\n \r\n";
		return b;
	}
	
	public static String deleteBook(String ID)
	{
		return new String("{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+ID+"\"\r\n" + 
				" \r\n" + 
				"}");
	}
	
	
}