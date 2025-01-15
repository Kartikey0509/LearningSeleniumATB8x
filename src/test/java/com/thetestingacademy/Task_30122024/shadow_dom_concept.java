package com.thetestingacademy.Task_30122024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class shadow_dom_concept {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");
        driver=new EdgeDriver(edgeOptions);
    }
//shadow host connects shadow dom to the main dom
    @Description("Learn the concept of shadow root.")
    @Test
    public void shadow_concept() throws InterruptedException {

        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true                                                                                                                                                                                      );", element_to_scroll);

        Thread.sleep(7000);

        WebElement inputBoxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");
        assert inputBoxPizza != null;
        inputBoxPizza.sendKeys("farmhouse");

//        String url = js.executeScript("return document.URL;").toString();
//        System.out.println(url);
//        String title = js.executeScript("return document.title;").toString();
//        System.out.println(title);
        //js.executeScript("window.scrollBy(0,500);")
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
