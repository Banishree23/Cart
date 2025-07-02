package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.TestBaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.Dataprovider;

public class TC003_Login_DDT extends TestBaseClass {
	
	@Test(dataProvider= "Logindata",dataProviderClass= Dataprovider.class)
	public void loginddt(String email,String pwd,String exp) {
		
		try {
		
		logger.info("Starting  TC003_Login_DDT");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("clickMyAccount");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		hp.clickLogin();
		logger.info("clickLogin");
		
		
		
		if (exp.equalsIgnoreCase("valid")) {
			
			
			lp.teardown1();
			Assert.assertTrue(true);
		}
		
		else {
			Assert.assertTrue(false);
		}
		
if (exp.equalsIgnoreCase("invalid")) {
			
			
			lp.teardown1();
			Assert.assertTrue(false);
		}
		
		else {
			Assert.assertTrue(true);
		}
	
	}
		
		catch(Exception e){
			
			Assert.fail();
			
		}

}
}
