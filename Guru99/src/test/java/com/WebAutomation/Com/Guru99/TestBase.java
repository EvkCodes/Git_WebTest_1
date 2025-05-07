    package com.WebAutomation.Com.Guru99;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.io.FileHandler;
    import org.testng.ITestResult;
    import org.testng.annotations.*;
	import java.io.File;
	import java.io.IOException;
	

	public class TestBase {

	    protected WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @AfterMethod
	    public void captureScreenshotOnFailure(ITestResult result) {
	    	 if (ITestResult.FAILURE == result.getStatus()) {
	             TakesScreenshot ts = (TakesScreenshot) driver;
	             File src = ts.getScreenshotAs(OutputType.FILE);
	             String filePath = "D:/Selenium/WorkSpace/Guru99/src/screenshots/" + result.getName() + ".png";
	             try {
	                 FileHandler.copy(src, new File(filePath));
	                 System.out.println("Screenshot saved at: " + filePath);
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	         }	        
	    }
	    
	    @AfterClass
	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
	    	System.out.println("Next Step");
	    }
	}



