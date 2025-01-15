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

public class complex_svg_MapofIndia {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver=new EdgeDriver(edgeOptions);
    }
    @Description("Verify Map of India, find U.P. and click on it.")
    @Test
    public void svg_india_search_click(){

        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[name()='g']/*[name()='g']/*[local-name()='path']"));
        for (WebElement state: states){
            System.out.println(state.getDomAttribute("aria-label"));
            if(state.getDomAttribute("aria-label").contains("Uttar Pradesh")){
                System.out.println("---Found the State----");
                state.click();
            }
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
