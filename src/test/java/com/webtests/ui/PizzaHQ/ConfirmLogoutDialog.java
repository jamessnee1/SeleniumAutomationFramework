package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmLogoutDialog {

    private WebDriver driver;

    public ConfirmLogoutDialog(WebDriver driver){
        this.driver = driver;
    }

    public void clickYes(){
        WebElement yesButton = driver.findElement(By.cssSelector("[aria-label='yes']"));
        yesButton.click();
    }

    public void clickCancel(){
        WebElement cancelButton = driver.findElement(By.cssSelector("[aria-label='cancel']"));
        cancelButton.click();
    }
}
