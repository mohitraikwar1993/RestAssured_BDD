package automationUtilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils_UserData {
	
	public static String getFirstName() 
	{	
		String generatedString= RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);	
	}
	
	public static String getLastName()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(1);
		return("Swan"+generatedString);
	}
	
	public static String getUserName()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(3);
		return("John"+generatedString); 
	}
	
	public static String getPassword()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(3);
		return("John"+generatedString); 
	}
	
	public static String getEmail()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(3);
		return(generatedString+"@gmail.com"); 
	}
	
	public static String getEmpName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return ("Mohit"+generatedString);
	}
	
	public static String getSalary()
	{
		String generatedString=RandomStringUtils.randomNumeric(5);
		return generatedString;
		
	}
	
	public static String getAge()
	{
		String	generatedString=RandomStringUtils.randomNumeric(2);
		return generatedString;
		
	}
	
}
