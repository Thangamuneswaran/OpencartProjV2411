package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.GetUtility;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class LoginTesting 
{
@Test (dataProvider ="logindata")
public void loginTest(String userName,String password)
{
	System.out.println("Usernameis"+ userName+ "password is"+ password);
}

@DataProvider(name="logindata")
public Object[] getdata() throws IOException
{
return GetUtility.getExcelData(".\\testData\\testDataExcel.xlsx","Sheet1");	
}
}
