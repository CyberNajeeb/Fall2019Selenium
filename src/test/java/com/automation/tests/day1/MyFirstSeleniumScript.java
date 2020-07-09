package com.automation.tests.day1;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyFirstSeleniumScript {

    @Test
    public void driverTest() {
        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        //create chromedriver object
        WebDriver driver = new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.manage().window().maximize();
        driver.get("http://google.com");
        BrowserUtils.wait(2);
        driver.quit();
    }
}
