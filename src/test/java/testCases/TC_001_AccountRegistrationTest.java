package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.BasePage;
import PageObjects.HomePage;
import BaseClass.TestBaseClass;

public class TC_001_AccountRegistrationTest extends TestBaseClass


{
	
	
	@Test(groups={"regression","Master"})
	public void verify_account_registration() {
		try {
		
		logger.info("Starting  TC_001_AccountRegistrationTest");
		
		HomePage pg = new HomePage(driver);
		pg.clickMyAccount();
		logger.info("clickMyAccount");
		
		pg.clickREgister();
		logger.info("clickREgister");
		
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		logger.info("Entering customer details");
		
		ap.setFirstName("Banishree");
		ap.setLastName("Achary");
		String ran = randomeString() + "@gmail.com";
  ap.setEmail(ran);	
  System.out.println(ran);
	//ap.setEmail("randomeString()" + "@gmail.com");
		ap.setTelephone("7064190793");
		
		String password = randomepassword();
		System.out.println(password);
		ap.setPassword("Banishree");
		ap.setConfirmPassword("Banishree");
		ap.CheckPolicy();
		ap.ClickContinuebtn();
		
		logger.info("validating expected message");
		String confmsg = ap.getConfirmationMsg();
		System.out.println(confmsg);
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e){
			logger.error("test failed");
			logger.debug("Debug logs");
			Assert.fail();
		
		}
		
		logger.info("Finihing  TC_001_AccountRegistrationTest");
		
		
	}
	
	
}
