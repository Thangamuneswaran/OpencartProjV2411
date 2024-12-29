package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("**** Starting TC001 ****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("**** Clicked on MyAccount Link ****");
		
		hp.clickRegister();	
		
		logger.info("**** Clicked on Register Link ****");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("**** Validating expected message.. ****");
		
		String confmsg=regpage.getConfirmationMsg();		
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}	
		catch(Exception e) {
			logger.error("**** Test failed ****");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("**** Finishing TC001 ****");
	}
	
}
