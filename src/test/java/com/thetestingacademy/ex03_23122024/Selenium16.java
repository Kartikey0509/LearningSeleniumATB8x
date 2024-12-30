package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium16 {

    @Test
    public void testMethod01(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // HTML element -> Web Element - Selenium
        // Web Element  Find - Interact with It

        // How to find the elements
        // Selenium
        // Selenium
        // Basic -> ID, NAME, CLASS NAME, TAGName,
        // Advance -> Css Selector, Xpath



        driver.quit();


    }
}
