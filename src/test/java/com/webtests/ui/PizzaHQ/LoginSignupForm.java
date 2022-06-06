package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginSignupForm {

    private WebDriver driver;

    public LoginSignupForm(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        WebElement usernameField = driver.findElement(By.id("gen-" + generateCurrentDate() + "-username"));
        usernameField.sendKeys(username);
    }

    public void setPassword(String password){
        WebElement passwordField = driver.findElement(By.id("gen-" + generateCurrentDate() + "-password"));
        passwordField.sendKeys(password);
    }

    public void clickSignupButton(){
        WebElement signupButton = driver.findElement(By.linkText("Sign Up"));
        signupButton.click();
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(By.cssSelector("[aria-label='login']"));
        loginButton.click();
    }

    public void clickCancelButton(){
        WebElement cancelButton = driver.findElement(By.cssSelector("[aria-label='cancel']"));
        cancelButton.click();
    }

    public String getErrorMessageText(){
        WebElement errorMessage = driver.findElement(By.className("v-alert__content"));
        return errorMessage.getText();
    }

    public void dismissErrorMessage(){
        WebElement dismissErrorButton = driver.findElement(By.className("v-alert__dismissible"));
        dismissErrorButton.click();
    }

    public String generateCurrentDate(){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        return dt.format(now);
    }
}
