package com.WebAutomation.Com.Guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AppTest extends TestBase {
    private static final Logger log = LogManager.getLogger(AppTest.class);

    @Test(priority = 1)
    public void launchPage() {
        driver.get("https://demo.guru99.com/payment-gateway/index.php");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("index.php"), "Failed to load the correct page: " + currentUrl);
        log.info("Page loaded successfully: " + currentUrl);
    }

    @Test(priority = 2)
    public void verifyTitle() {
        String title = driver.getTitle();
        log.info("Title name is: " + title);
        Assert.assertNotNull(title, "Page title is null");
    }

    @Test(priority = 3)
    public void paymentGateway() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement GenerateCardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//nav [@id ='nav']/a)[2]")));
        Assert.assertTrue(GenerateCardNumber.isDisplayed(), "Course table is not visible");
        log.info("go to Generate Card Number");
        WebElement CardNumberFunction = driver.findElement(By.xpath("(//nav [@id ='nav']/a)[2]"));
        CardNumberFunction.click();
    }

    @Test(priority = 4)
    public void windowHandle() {
    	Set<String>windowHandle = driver.getWindowHandles();
    	List<String>windowlist = new ArrayList<>(windowHandle);
    	driver.switchTo().window(windowlist.get(1));
    	String currentUrl = driver.getCurrentUrl();
    	log.info("Title name is: " + currentUrl);
    	Assert.assertTrue(currentUrl.contains("cardnumber.php"), "Failed to load the correct page: " + currentUrl);
        log.info("Page loaded successfully: " + currentUrl);

    	
       
    }
    @Test(priority =6)
    public void actionClassTest() {
    	 // Create Actions object
        Actions actions = new Actions(driver);

        // Example 1: Hover over an element
        WebElement hoverElement = driver.findElement(By.cssSelector("#three > div > h4:nth-child(3)"));
        actions.moveToElement(hoverElement).perform();
        driver.close();
           
       
    }
}
