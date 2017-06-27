package de.hyperconnect;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Test1 {
 
    private WebDriver driver;
 
    @BeforeClass
    public void beforeClass() {
    	
    	// Optional, if not specified, WebDriver will search your path for chromedriver.
    	//System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
    	
    	//force English as Chrome language
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--lang=en");
    	
        driver = new ChromeDriver(options);
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
 
    @Test
    public void verifySearchButton() {
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get("https://www.google.com");
 
        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));
 
        String text = search_button.getAttribute("value");
 
        Assert.assertEquals(text, search_text, "Text not found!");
    }
}