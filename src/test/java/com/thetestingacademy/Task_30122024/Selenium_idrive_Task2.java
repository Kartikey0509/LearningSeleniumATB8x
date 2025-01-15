package com.thetestingacademy.Task_30122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Selenium_idrive_Task2 {

    @Test
    public void testMethod01() throws Exception{

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        Thread.sleep(3000);
        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(3000);
         WebElement email = driver.findElement(By.id("username"));
         email.sendKeys("augtest_040823@idrive.com");

         WebElement pswd = driver.findElement(By.id("password"));
         pswd.sendKeys("123456");

         WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
         signInBtn.click();

         Thread.sleep(15000);

         WebElement msg = driver.findElement(By.xpath("//h5[@class='id-card-title']"));
         System.out.println("Free trial message is : " +msg.getText());
        Assert.assertEquals(msg.getText(), "Your free trial has expired");

         Thread.sleep(3000);
         driver.quit();

    }
}
