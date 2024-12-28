package com.thetestingacademy.Task_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium01Task {

    @Test
    public void testMethod01() throws Exception{

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(edgeOptions);

        driver.get("https://katalon-demo-cura.herokuapp.com/");

       WebElement makeAptBtn= driver.findElement(By.id("btn-make-appointment"));
       makeAptBtn.click();

        Thread.sleep(3000);

      WebElement user= driver.findElement(By.name("username"));
      user.sendKeys("John Doe");

      WebElement pswd= driver.findElement(By.id("txt-password"));
      pswd.sendKeys("ThisIsNotAPassword");

      WebElement loginBtn = driver.findElement(By.id("btn-login"));
      loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
       Thread.sleep(3000);
        driver.quit();

    }
}
