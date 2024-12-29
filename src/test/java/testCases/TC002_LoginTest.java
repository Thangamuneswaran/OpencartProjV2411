package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
 
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("***** Starting TC002  *****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		Boolean targetPage=myacc.isMyAccountPageExists();
		
		//Assert.assertEquals(true, targetPage, "Login Failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***** Finishing TC002  *****");
	}
}
