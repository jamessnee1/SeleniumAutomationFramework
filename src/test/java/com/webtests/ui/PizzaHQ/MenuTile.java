package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuTile {

    private WebElement el;

    public MenuTile(WebElement el){
        this.el = el;
    }

    public WebElement getWebElement(){
        return el;
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

    public String getMenuTileRating(){
        List<WebElement> ratingButtons = el.findElements(By.tagName("button"));
        int rating = 0;
        for(WebElement button : ratingButtons){
            if(button.getText().equalsIgnoreCase("star")){
                rating++;
            }
        }

        return String.valueOf(rating);
    }

    public void rateMenuItem(String rating){
        //Get the rating button equivalent to the rating input
        List<WebElement> ratingButtons = el.findElements(By.tagName("button"));

        for(WebElement button : ratingButtons){
            if(button.getAttribute("aria-label").equalsIgnoreCase("Rating " + rating + " of 5")){
                //If button is readonly, click will not be allowed
                try{
                    button.click();
                }
                catch(ElementClickInterceptedException e){
                    System.out.println("Click error: " + e.getMessage());
                }
            }
        }

    }

    public void clickOrder(){
        el.findElement(By.className("v-btn__content")).click();
    }

}
