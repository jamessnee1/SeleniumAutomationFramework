package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PizzaHQMenu {

    private WebDriver driver;

    public PizzaHQMenu(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToHomePage(){
        WebElement homeMenuButton = driver.findElement(By.cssSelector("[aria-label='home']"));
        homeMenuButton.click();
    }

    public void navigateToMenuPage(){
        WebElement menuMenuButton = driver.findElement(By.cssSelector("[aria-label='menu']"));
        menuMenuButton.click();
    }

    public void navigateToStoresPage(){
        WebElement storesMenuButton = driver.findElement(By.cssSelector("[aria-label='stores]"));
        storesMenuButton.click();
    }

    public void navigateToContactPage(){
        WebElement contactMenuButton = driver.findElement(By.cssSelector("[aria-label='contact']"));
        contactMenuButton.click();
    }

    public void navigateToLoginOrSignupPage(){
        WebElement loginOrSignupMenuButton = driver.findElement(By.cssSelector("[aria-label='login or signup']"));
        loginOrSignupMenuButton.click();
    }

    public void navigateToYourOrderPage(){
        WebElement yourOrderMenuButton = driver.findElement(By.cssSelector("[aria-label='your order']"));
        yourOrderMenuButton.click();
    }

    public void navigateToYourProfilePage(){
        WebElement yourProfileMenuButton = driver.findElement(By.cssSelector("[aria-label='your profile']"));
        yourProfileMenuButton.click();
    }

    public String getNumberOfCartItems(){
        String numOfItems = driver.findElement(By.cssSelector("[aria-label='your order']")).getText();
        numOfItems = numOfItems.replaceAll("\nroom_service", "").trim();
        return numOfItems;
    }

    public void logout(){
        WebElement yourProfileMenuButton = driver.findElement(By.cssSelector("[aria-label='your profile']"));

        //Create a new action
        Actions action = new Actions(driver);

        //Move mouse to element
        action.moveToElement(yourProfileMenuButton);

        WebElement logoutDropdown = driver.findElement(By.className("dd-nav-logout"));
        logoutDropdown.click();
    }
}
