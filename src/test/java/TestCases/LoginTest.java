package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import TestUtils.BaseTest;

public class LoginTest extends BaseTest {
	
	@Test(dataProvider= "getLoginData")
	public void positiveLogin(HashMap<String,String> input)
	{
		loginPage.loginMethod(input.get("username"),input.get("password"));
	}
	
	@DataProvider(name="getLoginData")
	public Object[][] getData() throws IOException, ParseException
	{
		JSONParser jsonparser=new JSONParser();
		FileReader reader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\LoginData.json");
		Object obj = jsonparser.parse(reader);
		JSONObject userloginsJsonobj = (JSONObject)obj;
		JSONArray array = (JSONArray) userloginsJsonobj.get("loginData");
		
		final int limit = array.size();
	    Object[][] maps = new Object[limit][1];
	    for(int i = 0; i < limit; i++) {
	        maps[i][0] = array.get(i);
	    }
			
	    return maps;
	} 
	
	
//	@DataProvider(name="getLoginData")
//	public Object[][] getData() throws IOException
//	{
//		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\LoginData.json");
//		//return new Object[][]  {{data.get(0)}, {data.get(1) }};
//		final int limit = data.size();
//	    Object[][] maps = new Object[limit][1];
//	    for(int i = 0; i < limit; i++) {
//	        maps[i][0] = data.get(i);
//	    }
//			
//	    return maps;
//	} 

}
