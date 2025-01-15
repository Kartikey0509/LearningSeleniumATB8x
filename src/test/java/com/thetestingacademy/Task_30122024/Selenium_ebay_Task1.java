package com.thetestingacademy.Task_30122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium_ebay_Task1 {

    @Test
    public void testMethod01() throws Exception{

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

       WebElement searchBox= driver.findElement(By.cssSelector("#gh-ac"));
       searchBox.sendKeys("mac mini");

       WebElement searchBtn = driver.findElement(By.id("gh-btn"));
       searchBtn.click();

       List<WebElement> productTitles = driver.findElements(By.xpath("//div[@class='s-item__title']"));
       List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='s-item__price']"));

       int size = Math.min(productTitles.size(), productPrices.size());

        for (int i = 0; i < size; i++) {

            System.out.println("Title:-" + productTitles.get(i).getText() +"---->" + productPrices.get(i).getText());
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
