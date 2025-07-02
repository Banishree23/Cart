package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.TestBaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccount;

public class TC_002_LoginTest  extends TestBaseClass {
	
	@Test(groups={"sanity","Master"})
	public void verifyLogin() {
		logger.info("Starting TC_002_LoginTest");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		//String ran = randomeString() + "@gmail.com";
		lp.setEmail(p.getProperty("Email"));
		
		//String password = randomepassword();
		lp.setPassword(p.getProperty("Password"));
		System.out.println(p.getProperty("Password"));
		lp.clickLogin();
		
		
		MyAccount ma = new MyAccount(driver);
	boolean targetPage =	ma.IsMyAccountExist();
	Assert.assertTrue(targetPage);
		}
		
		catch(Exception e) {
			Assert.fail();
		}
	
	logger.info("Finished TC_002");
	}

}
