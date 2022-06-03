package com.webtests.ui.FormsPlanets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PlanetsPage {

    private WebDriver driver;


    public PlanetsPage(WebDriver driver) {
        this.driver = driver;
    }

    private List<WebElement> getPlanetTiles(){
        return driver.findElements(By.className("planet"));
    }

    private List<PlanetTile> getAllPlanetTiles(){
        List<WebElement> planetsList = getPlanetTiles();
        List<PlanetTile> planetTileList = new ArrayList<PlanetTile>();
        for(WebElement tile : planetsList){
            PlanetTile pt = new PlanetTile(tile);
            planetTileList.add(pt);
        }
        return planetTileList;
    }

    public String getPlanetFurthestFromSun(){
        long furthestDistance = 0;
        String furthestPlanetName = "";
        List<PlanetTile> planetTiles = getAllPlanetTiles();
        for(PlanetTile planet : planetTiles){
            var distance = planet.getPlanetDistance();

            if(distance > furthestDistance){
                furthestDistance = planet.getPlanetDistance();
                furthestPlanetName = planet.getPlanetTileHeading();
            }
        }
        return furthestPlanetName;
    }

    public PlanetTile findPlanetTileByName(String name) {
        PlanetTile foundPlanetTile = null;
        var tiles = getPlanetTiles();
        for(WebElement tile : tiles){
            var currentTile = new PlanetTile(tile);
            if(currentTile.getPlanetTileHeading().equalsIgnoreCase(name)){
                foundPlanetTile = currentTile;
                break;
            }
        }

        return foundPlanetTile;
    }
}
