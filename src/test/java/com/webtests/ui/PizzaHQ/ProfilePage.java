package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public String getLoggedInMessage(String username){
        String loggedInMessage = "";
        var headers = driver.findElements(By.tagName("h2"));
        for(WebElement header : headers){
            if(header.getText().contains(username)){
                loggedInMessage = header.getText();
            }
        }
        //clean up string
        loggedInMessage = loggedInMessage.replaceAll("person\n", "");
        return loggedInMessage;
    }
}
