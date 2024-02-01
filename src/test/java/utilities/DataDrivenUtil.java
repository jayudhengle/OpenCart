package utilities;

import org.testng.annotations.DataProvider;

public class DataDrivenUtil 
{
	@DataProvider(name = "loginDetails")
	public String [][] dataDrivenFunction()
	{
		String [][] dp = {
				{"jayudhengle@gmail.com", "jayu12345"},
				{"jayudhengle1@gmail.com", "jayu123"}
		};
		return dp;
	}
}
