package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonLogin {

	static String filePath="\\src\\test\\java\\Browsers.properties";
	static String propertyName = "browser";
	static String propertyName1 = "URL";
	WebDriver driver;
	
//	public CommonLogin(WebDriver driver2) {
//		this.driver=driver2;
//	}
	public WebDriver commonLoginPage(WebDriver driver) throws IOException {
		//Code for closing chrome being automated by automation software...
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
				
				
			    String browserName= getFileProperties(filePath,propertyName );
			    
			    if(browserName.equals("chrome")) {
			    WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver(options);  //Argument of chromeOptions..
			    maximizeWindow(driver);
			    getURL(driver);
			    return driver;
			    }
			    if(browserName.equals("edge")) {
				    WebDriverManager.firefoxdriver().setup();
				    driver = new FirefoxDriver(); //Argument of chromeOptions..
				    return driver;
				    }
			    return driver;
			   
			}
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void getURL(WebDriver driver) throws IOException {
		driver.get(getFileProperties(filePath, propertyName1));
	}
	
	public String getFileProperties(String filePath, String propertyName11) throws IOException {
		//Basic code from properties file....
		Properties pro = new Properties();
		 FileInputStream path = new FileInputStream(
					System.getProperty("user.dir") + filePath);
		pro.load(path);
		return pro.getProperty(propertyName11);
	}
	
	public static String takeScreenShotforFail(String takeScreenShot, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File fl = new File(System.getProperty("user.dir") + "\\reports\\" + takeScreenShot + ".png");
		FileUtils.copyFile(source, fl);
		return System.getProperty("user.dir") + "\\reports\\" + takeScreenShot + ".png";
	}
	
    }


