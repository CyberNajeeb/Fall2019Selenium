package com.automation.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * CHEAP SPOONS
 * 1.go to https://amazon.com
 * 2.search for "wooden spoon"
 * 3.click on Price option Under $25 on the left
 * 4.verify that all results are cheaper than $25
 */
public class LessThan25 {

    private WebDriver driver;// = Driver.getDriver();


    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        driver.findElement(By.linkText("Under $25")).click();

        //we collect only dollar values from the price of every item
        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        //we convert collection of web elements into collection of strings
        List<String> pricesText = BrowserUtils.getTextFromWebElements(prices);
        System.out.println(pricesText);
        for (String price : pricesText) {

            //we convert every price as a string into integer
            int priceConverted = Integer.parseInt(price);

            //checking if the price of every item is under 25
            Assert.assertTrue(priceConverted < 25);
        }
        driver.quit();
    }

    static int num = 0;

    public static void main(String[] args) {

//        try {
//            num++;
//            System.out.println("num = " + num);
//            main(null);
//        }catch (StackOverflowError error) {
//        }
//        finally {
//            System.out.println("Stack is full!!");
//        }

        List<String> names = new ArrayList<>(Arrays.asList("Ahmet", "Mehmet", "Najeeb", "Maria", "Marina", "Zaki"));
        names.removeIf(n -> n.endsWith("et"));
        System.out.println(names);

        List<String> l1 = new ArrayList<>(Arrays.asList("Ahmet", "Mehmet", "Najeeb", "Maria", "Marina", "Zaki"));
        List<String> l2 = new ArrayList<>(Arrays.asList());
//        names3.addAll(names2).(n1 -> n1.startsWith("M"));
        l1.forEach(A -> {
            if (A.startsWith("M")) {
                l2.add(A);
            }
        });
        System.out.println(l2);
        l1.removeIf(L1->L1.startsWith("M"));
        System.out.println(l1+" after remove");

    }

}

