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

    public String getImgAltText(){
        WebElement img = el.findElement(By.tagName("img"));
        return img.getAttribute("alt");
    }

    public boolean getMenuTileVeganStatus(){
        WebElement status = el.findElement(By.cssSelector("[aria-label='Badge']"));
        if(status.getAttribute("class").equalsIgnoreCase("v-badge__badge orange")){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean getMenuTileVegetarianStatus(){
        WebElement status = el.findElement(By.cssSelector("[aria-label='Badge']"));
        if(status.getAttribute("class").equalsIgnoreCase("v-badge__badge green")){
            return true;
        }
        else {
            return false;
        }
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

    public boolean getMenuTileNewStatus(){
        if(el.findElement(By.tagName("span")).getText().equalsIgnoreCase("New")){
            return true;
        }
        else {
            return false;
        }
    }

}
