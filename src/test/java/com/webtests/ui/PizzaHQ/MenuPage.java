package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class MenuPage {

    private WebDriver driver;

    public MenuPage(WebDriver driver){
        this.driver = driver;
    }

    private List<WebElement> getTabButtons(){
        return driver.findElements(By.className("v-tab"));

    }

    public void clickTabButton(String tabText){
        List<WebElement> tabs = getTabButtons();
        for(WebElement tab : tabs){
            //WebElement tab contains extra information in text attribute
            if(tab.getText().contains(tabText)){
                tab.click();
            }
        }

    }

    private List<WebElement> getAllSideMenuTiles(){
        List<WebElement> sideMenuTiles = driver.findElements(By.xpath("//*[contains(@class, 'menuItem side')]"));
        return sideMenuTiles;
    }

    private List<WebElement> getAllPizzaMenuTiles(){
        List<WebElement> pizzaMenuTiles = driver.findElements(By.xpath("//*[contains(@class, 'menuItem pizza')]"));
        return pizzaMenuTiles;
    }

    private List<WebElement> getAllDrinkMenuTiles(){
        List<WebElement> drinkMenuTiles = driver.findElements(By.xpath("//*[contains(@class, 'menuItem drink')]"));
        return drinkMenuTiles;
    }

    public MenuTile getSideMenuTileByName(String name){
        List<WebElement> tiles = getAllSideMenuTiles();
        for(WebElement tile : tiles){
            MenuTile menuItem = new MenuTile(tile);
            if(menuItem.getMenuTileHeading().equalsIgnoreCase(name)){
                return menuItem;
            }
        }
        return null;
    }

    public MenuTile getPizzaMenuTileByName(String name){
        List<WebElement> tiles = getAllPizzaMenuTiles();
        for(WebElement tile : tiles){
            MenuTile menuItem = new MenuTile(tile);
            if(menuItem.getMenuTileHeading().equalsIgnoreCase(name)){
                return menuItem;
            }
        }
        return null;
    }

    public MenuTile getDrinkMenuTileByName(String name){
        List<WebElement> tiles = getAllDrinkMenuTiles();
        for(WebElement tile : tiles){
            MenuTile menuItem = new MenuTile(tile);
            if(menuItem.getMenuTileHeading().equalsIgnoreCase(name)){
                return menuItem;
            }
        }
        return null;
    }
}
