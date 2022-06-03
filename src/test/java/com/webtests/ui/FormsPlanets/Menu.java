package com.webtests.ui.FormsPlanets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Menu {

    private WebDriver driver;

    public Menu(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToFormsPage(){
        WebElement formsMenuButton = driver.findElement(By.cssSelector("[aria-label='forms']"));
        formsMenuButton.click();
    }

    public void navigateToPlanetsPage(){
        WebElement planetsMenuButton = driver.findElement(By.cssSelector("[aria-label='planets']"));
        planetsMenuButton.click();
    }

    public void navigateToHomePage(){
        WebElement homeMenuButton = driver.findElement(By.cssSelector("[aria-label='home']"));
    }

}
