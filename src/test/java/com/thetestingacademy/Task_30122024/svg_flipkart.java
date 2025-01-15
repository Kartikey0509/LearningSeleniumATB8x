package com.thetestingacademy.Task_30122024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class svg_flipkart {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver=new EdgeDriver(edgeOptions);
    }

    @Description("Verify after search, results are visible")
    @Test
    public void flipkart_search(){

     String URL = "https://www.flipkart.com/";
      driver.get(URL);
      driver.findElement(By.name("q")).sendKeys("macmini");

      //local-name() & name() are same and default function in Selenium to find any tag
        List<WebElement> svgSearchBtn = driver.findElements(By.xpath("//*[name()='svg']"));
            svgSearchBtn.get(0).click();
            List<WebElement> titles= driver.findElements(By.xpath("//div[contains(@data-id, 'CPU')]/div/a[2]"));
            for (WebElement title:titles){
                System.out.println(title.getText());
            }
    }

    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
