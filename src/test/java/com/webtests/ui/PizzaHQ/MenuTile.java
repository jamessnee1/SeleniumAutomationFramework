package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuTile {

    private WebElement el;

    public MenuTile(WebElement el){
        this.el = el;
    }

    public String getMenuTileHeading(){
        return el.findElement(By.className("name")).getText();
    }

    public String getMenuTileDescription() {
        return el.findElement(By.className("description")).getText();
    }

    public String getMenuTileKilojoules(){
        return el.findElement(By.className("kilojoules")).getText();
    }

    public String getMenuTilePrice(){
        return el.findElement(By.className("price")).getText();
    }
}
