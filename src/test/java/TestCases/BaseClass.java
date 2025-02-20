package TestCases;

import org.testng.annotations.AfterClass;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseClass {

	public Properties p;
	public static WebDriver Driver;
	public Logger logger;
	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"master","regression","sanity"})
	@Parameters({"os","browser"})	
	public void setup(String os,String br) throws IOException {
	logger =LogManager.getLogger(this.getClass()); 
		
		FileReader file = new FileReader(".\\src\\test\\resources\\configure.properties");
		p=new Properties();
		p.load(file);
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			
			
			if(os.equalsIgnoreCase("windows")){
			capabilities.setPlatform(Platform.WIN11);
			}
			
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
		
			}
			else {
				System.out.println("No matching...");
				return;
			}
			
			
			
			//browser
			
			switch(br.toLowerCase()) {
			
			case "chrome" : capabilities.setBrowserName("Chrome");break;
			case "edge" : capabilities.setBrowserName("Edge");break;
			case "firefox" : capabilities.setBrowserName("Firefox");break;
			default : System.out.println("no matching");
			return;
			
			}
			
			Driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
	
		switch(br.toLowerCase()) {
		
		case "chrome" : Driver = new ChromeDriver();break;
		case "edge"  : Driver = new EdgeDriver();break;
		case "firefox" : Driver = new FirefoxDriver();break;
		default : System.out.println("Invalid enter");
		return;
		
		}
		}

		
		Driver.get(p.getProperty("Ecom")); 
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
	}
	
	
	@AfterClass(groups = {"master","regression","sanity"})
	void close(){
		Driver.quit();
		
	}
	
	
	public String randomalphabets()	{				
		String alphabets  = RandomStringUtils.randomAlphabetic(5);
		return alphabets;
     }
	
	public String randomnumeric() {
		String numeric  = RandomStringUtils.randomNumeric(10);
		return numeric;
	}
	
	public String randomNumAlpha() {
		String alphabets  = RandomStringUtils.randomAlphabetic(3);
		String numeric  = RandomStringUtils.randomNumeric(3);
		return(alphabets+"@"+numeric);
		
	}
	
	
	public String captureScreen(String tname) throws IOException//tname is a faildetestmethod name for ss name
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// timeStamp 
		TakesScreenshot takesScreenshot = (TakesScreenshot) Driver;	
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilepath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		
		File targetFile = new File(targetFilepath); //converting string to file formate
		
		sourceFile.renameTo(targetFile);
		return targetFilepath;
		
	}

}
