package com.thetestingacademy.Task_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task02 {

    @Test
    public void testMethod01() throws Exception{

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver= new EdgeDriver(edgeOptions);

        driver.get("https://awesomeqa.com/practice.html");
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/practice.html");

        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("Kartikey");

        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("Srivastava");

        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();

        WebElement experience = driver.findElement(By.id("exp-6"));
        experience.click();

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("28122024");

        WebElement profession = driver.findElement(By.id("profession-1"));
        profession.click();

        WebElement autoTool = driver.findElement(By.id("tool-0"));
        autoTool.click();

        Select select = new Select(driver.findElement(By.name("continents")));
        select.selectByIndex(2);
        select.selectByVisibleText("Asia");
      //  select.selectByValue("Australia");
        List<WebElement> webElementsList = select.getOptions();
        System.out.println(webElementsList.size());


        Thread.sleep(3000);
        driver.quit();

    }
}
