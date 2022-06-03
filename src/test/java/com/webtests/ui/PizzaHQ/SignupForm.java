package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignupForm {

    private WebDriver driver;

    public SignupForm(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        List<WebElement> textFields = driver.findElements(By.xpath("//input[contains(@id, 'input')]"));
        textFields.get(0).sendKeys(username);
    }

    public void clearUsername(){
        List<WebElement> textFields = driver.findElements(By.xpath("//input[contains(@id, 'input')]"));
        textFields.get(0).sendKeys(Keys.CONTROL + "a");
        textFields.get(0).sendKeys(Keys.DELETE);
    }

    public void setPassword(String password){
        List<WebElement> textFields = driver.findElements(By.xpath("//input[contains(@id, 'input')]"));
        textFields.get(1).sendKeys(password);
    }

    public void clearPassword(){
        List<WebElement> textFields = driver.findElements(By.xpath("//input[contains(@id, 'input')]"));
        textFields.get(1).sendKeys(Keys.CONTROL + "a");
        textFields.get(1).sendKeys(Keys.DELETE);
    }

    public void setConfirmPassword(String password){
        List<WebElement> textFields = driver.findElements(By.xpath("//input[contains(@id, 'input')]"));
        textFields.get(2).sendKeys(password);
    }

    public void clearConfirmPassword(){
        List<WebElement> textFields = driver.findElements(By.xpath("//input[contains(@id, 'input')]"));
        textFields.get(2).sendKeys(Keys.CONTROL + "a");
        textFields.get(2).sendKeys(Keys.DELETE);
    }

    public void clickSignupButton(){
        WebElement signupButton = driver.findElement(By.cssSelector("[aria-label='signup']"));
        signupButton.click();
    }

    public void clickCancelButton(){
        WebElement cancelButton = driver.findElement(By.cssSelector("[aria-label='cancel']"));
        cancelButton.click();
    }

    public void waitForErrorMessageText(int timeoutSeconds, String locator){
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    public String getErrorMessageText(String locator){
        waitForErrorMessageText(5, locator);
        WebElement errorMessage = driver.findElement(By.id(locator));
        return errorMessage.getText();
    }

    private void waitForPopupMessage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("popup-message")));
    }

    public String getPopupMessageText(){
        waitForPopupMessage();
        return driver.findElement(By.className("popup-message")).getText();
    }
}
