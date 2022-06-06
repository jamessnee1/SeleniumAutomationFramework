package com.webtests.ui.PizzaHQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YourOrderPage {

    private WebDriver driver;

    public YourOrderPage(WebDriver driver){
        this.driver = driver;
    }

    private List<WebElement> getTableRows(){
        WebElement tableRows = driver.findElement(By.tagName("tbody"));
        return tableRows.findElements(By.tagName("tr"));

    }

    private List<WebElement> getTableColumns(WebElement tableRow){
        return tableRow.findElements(By.tagName("td"));
    }

    public String getSubtotalByName(String name){
        String subtotal = "";
        List<WebElement> tableRows = getTableRows();
        for(WebElement row : tableRows){
            List<WebElement> tableCols = getTableColumns(row);
            String prodName = tableCols.get(1).getText();
            if(prodName.equalsIgnoreCase(name)){
                subtotal = tableCols.get(2).getText();
            }
        }
        return subtotal;
    }
}
