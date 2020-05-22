package commonUtilities;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="testdata")
	public static Object[][] dataset()
	{
	return new Object[][] {{"shatvika","111"},{"Mohini","11"},{"kaveri","111"}};
	}


}
