package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Emailtxtbox;
	
	@FindBy(xpath="//div[@class='form-group']//input[@type='password']")
	WebElement Passwordtxtbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LOginbtn;
	
	public void setEmail(String email) {
		Emailtxtbox.sendKeys(email);
		
		
	}
	
	public void setPassword(String pwd) {
		Passwordtxtbox.sendKeys(pwd);
		
		
	}
	
	public void clickLogin() {
		LOginbtn.click();
		
		
	}
	
public void teardown1() {   
	
		
		
		
		driver.quit();
		
	}
	

}
