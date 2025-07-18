package BaseClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class TestBaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"sanity","regression","Master"})
	@Parameters({"os","browser"})
	
public void setUp(String os,String br) throws IOException {
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
				p= new Properties();
		p.load(file);
		
		logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) 
		{
		case "chrome" :driver = new ChromeDriver();break;
		case "edge" :driver = new EdgeDriver();break;
		case "firefox" :driver = new FirefoxDriver();break;
		default: System.out.println("Invalid browser namee");return;
		}
		
		
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURl"));
		driver.manage().window().maximize();
	}
		
	


	
	@AfterClass
	public void teardown() {   
	
		
		
		
		driver.quit();
		
	}
	
	
public String randomeString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
public String randomeNumber() {
		
		String generatednumeric = RandomStringUtils.randomNumeric(0);
		return generatednumeric;
	}

public String randomepassword() {
	
	String generatednumeric = RandomStringUtils.randomNumeric(3);
			String generatedstring = RandomStringUtils.randomAlphabetic(5);
	return (generatednumeric +"@" +generatedstring) ;
}

public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;

}


}
