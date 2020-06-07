package com.spicejet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	Properties prop;
	//initialize browser
    public WebDriver initializeDriver() throws IOException {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Saranya\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		prop = new Properties();
		FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SpiceJet\\Data.properties");
		prop.load(fil);
		String BaseUrl = prop.getProperty("Url");
		driver.get(BaseUrl);
		return driver;
    }
    
    //Screenshot of results page
    public void getScreenShot(String name) throws IOException {
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenfile = System.getProperty("user.dir")+"\\reports\\"+name+".png";
		FileUtils.copyFile(source, new File(screenfile));
	}
}
