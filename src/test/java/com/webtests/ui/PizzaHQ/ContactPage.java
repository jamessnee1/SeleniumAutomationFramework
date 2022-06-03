package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class ContactPage {

    private WebDriver driver;

    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void setForeName(String foreName){
        WebElement nameField = driver.findElement(By.id("forename"));
        nameField.sendKeys(foreName);
    }

    public String getForeName(){
        return driver.findElement(By.id("forename")).getText();
    }

    public void setEmail(String email){
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public String getEmail(){
        return driver.findElement(By.id("email")).getText();
    }

    public void setTelephone(String telephone){
        WebElement telephoneField = driver.findElement(By.id("telephone"));
        telephoneField.sendKeys(telephone);
    }

    public String getTelephone(){
        return driver.findElement(By.id("telephone")).getText();
    }

    public void setMessage(String message){
        WebElement messageField = driver.findElement(By.id("message"));
        messageField.sendKeys(message);
    }

    public String getMessage(){
        return driver.findElement(By.id("message")).getText();
    }

    public void clickSubmitButton(){
        WebElement submitButton = driver.findElement(By.cssSelector("[aria-label='submit']"));
        submitButton.click();

    }

    public void clickClearButton(){
        WebElement clearButton = driver.findElement(By.cssSelector("[aria-label='clear']"));
        clearButton.click();
    }

    public String getErrorMessageText(String locator){
        return driver.findElement(By.id(locator)).getText();
    }

    private void waitForPopupMessage(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-alert__content")));
    }

    public String getPopupMessageText(){
        waitForPopupMessage();
        return driver.findElement(By.className("v-alert__content")).getText();
    }


}
