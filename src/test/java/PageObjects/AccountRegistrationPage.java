package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@name='firstname']")
	WebElement FirstNametxtbox;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement LastNametxtbox;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement Emailtxtbox;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement Telephonetxtbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Passwordxtbox;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement ConfirmPasswordtxtbox;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continu']")
	WebElement Continuebtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement confCOntinue;
	
	
	public void setFirstName(String fname) {
		FirstNametxtbox.sendKeys(fname);
		
		
	}
	
	public void setLastName(String lname) {
		LastNametxtbox.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		Emailtxtbox.sendKeys(email);
	}
	
	public void setTelephone(String tphone) {
		Telephonetxtbox.sendKeys(tphone);
	}
	
	public void setPassword(String pwd) {
		Passwordxtbox.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cpwd) {
		ConfirmPasswordtxtbox.sendKeys(cpwd);
	}
	
	public void CheckPolicy() {
		chkdPolicy.click();
		
	}
	
	public void ClickContinuebtn() {
		Continuebtn.click();
		
	//	Continuebtn.submit();
		
	//	Actions act = new Actions(driver);
	//	act.moveToElement(Continuebtn).click().perform();
		
		
	}
	
	
	public void ClickconfCOntinue() {
		confCOntinue.click();
		
	}
	
	
	public String getConfirmationMsg() {
		try {
		 return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return e.getMessage();
		
	}
	
	
	
	
	

	



}


}
