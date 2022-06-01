package com.webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UIElement {

    private static UIElement instance = null;

    private ChromeDriver driver;

    private UIElement(ChromeDriver driver){
        this.driver = driver;
    }

    public static UIElement getInstance(ChromeDriver driver){
        if(instance == null){
            instance = new UIElement(driver);
        }

        return instance;
    }


    private WebElement locateButton(String by, String locator){
        WebElement element = null;
        switch(by){
            case "id":
                element = driver.findElement(By.id(locator));
                break;
            case "name":
                element = driver.findElement(By.name(locator));
                break;
            case "class":
                element = driver.findElement(By.className(locator));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(locator));
                break;
            default:
                System.err.println("Error: Button could not be found!");
                break;
        }

        return element;
    }

    public void clickButton(String by, String locator){
        locateButton(by, locator).click();
    }


}
