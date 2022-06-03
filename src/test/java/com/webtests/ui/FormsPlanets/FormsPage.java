package com.webtests.ui.FormsPlanets;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FormsPage {

    //private ChromeDriver driver;
    private WebDriver driver;

    public FormsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name){
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys(name);
    }

    public String getName(){
        return driver.findElement(By.id("name")).getText();
    }

    public void setEmail(String email){
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public String getEmail(){
        return driver.findElement(By.id("email")).getText();
    }

    public void setState(String state){
        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys(state);
    }

    public String getState(){
        return driver.findElement(By.id("state")).getText();
    }

    public void clickAgreeButton(){
        WebElement agreeButton = driver.findElement(By.cssSelector("[for=agree]"));
        agreeButton.click();
    }

    public void clickSubmitButton(){
        //Submit button
        List<WebElement> submitButton = driver.findElements(By.className("v-btn"));
        WebElement foundBtn = null;
        for(WebElement button : submitButton){
            if(button.getText().equalsIgnoreCase("SUBMIT")){
                foundBtn = button;
                button.click();
            }
        }
        if(foundBtn == null){
            throw new NotFoundException("Could not find button!");
        }
    }

    private void waitForPopupMessage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("popup-message")));
    }

    public String getPopupMessageText(){
        waitForPopupMessage();
        return driver.findElement(By.className("popup-message")).getText();
    }

    public String getErrorMessageText(String locator){
        return driver.findElement(By.id(locator)).getText();
    }

}
