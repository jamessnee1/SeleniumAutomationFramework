package com.webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetTile {

    private WebElement el;

    public PlanetTile(WebElement el){
        this.el = el;
    }

    public String getPlanetTileHeading(){
        return el.findElement(By.tagName("h2")).getText();
    }

    public long getPlanetDistance(){
        String distance = el.findElement(By.className("distance")).getText();
        distance = distance.replaceAll(" km", "");
        distance = distance.replaceAll(",", "");
        return Long.parseLong(distance);
    }

    public String getPlanetDistanceAsString(){
        return el.findElement(By.className("distance")).getText();
    }

    public String getPlanetRadius(){
        return el.findElement(By.className("radius")).getText();
    }

    public void clickExploreButton(){
        el.findElement(By.className("my-3 v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary darken-1")).click();
    }

}
