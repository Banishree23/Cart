package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount  extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	
	//Logout  link not working on website
	
	public boolean IsMyAccountExist() {
		
		try {
		
		return lnkMyAccount.isDisplayed();
		}
		
		catch(Exception e) {
			return false;
		}
		
	}

}
