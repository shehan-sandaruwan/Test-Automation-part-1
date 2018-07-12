package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
                        // write your code here
                    System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32 (4)\\chromedriver.exe");
                    WebDriver obj = new ChromeDriver();
                        //step 01 open url
                    obj.get("https://ikman.lk/");

                        //click on the property link
                    obj.findElement(By.cssSelector("body > div.app-content > div.home-top > div > div.home-focus > div > div:nth-child(1) > div:nth-child(2) > a")).click();

                        //click on the house
                    obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div:nth-child(3) > div > ul > li > ul:nth-child(2) > li > ul > li.ui-link-tree-item.cat-411 > a > span")).click();

                        //click on the colombo

                    obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div:nth-child(4) > div > ul > li > ul > li.ui-link-tree-item.loc-1506 > a > span")).click();

                        //set values with numbers
                    obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-price > a > span")).click();
                    obj.findElement(By.cssSelector("#filters\\5b 0\\5d \\5b minimum\\5d")).sendKeys("5000000");

                    obj.findElement(By.cssSelector("#filters\\5b 0\\5d \\5b maximum\\5d")).sendKeys("7500000");

                        //click on Apply filter button
                    obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-price.is-open > div > div:nth-child(6) > div > div > button")).click();

                        //open bed
                    obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-enum.filter-bedrooms > a > span")).click();

                        // select number of beds
                    obj.findElement(By.cssSelector("#filters2values-3")).click();
                        //
                    int housesWithThreeBeds = Integer.parseInt(obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-enum.filter-bedrooms.is-open > div > ul > li.ui-link-tree-item.bedrooms-3 > a > span")).getText());
                    System.out.println("number of beds ads found " + housesWithThreeBeds);


                    //list to store the prices
                    List<String> priceOfTheHouses = new ArrayList<>();

                    //iterate through all the pages
                     for (int i=0; i<housesWithThreeBeds/25 + 1; i++){

                    //put the results to an array

                    WebElement serpItems = obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div.row.lg-g > div.col-12.lg-9 > div"));
                    List<WebElement> listItems = serpItems.findElements(By.className("ui-item"));
                    List<String> numBeds = new ArrayList<>();
                     for (WebElement item : listItems) {
                         priceOfTheHouses.add(item.findElement(By.className("item-info")).getText());
                         numBeds.add(item.findElement(By.className("item-meta")).getText());

                     }

                    if(i!=housesWithThreeBeds/25){
                        obj.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div.row.lg-g > div > div > div > div > div > a.col-6.lg-3.pag-next")).click();
                     }
                    for (int l=0;l<priceOfTheHouses.size();l++){
                        System.out.println("Ad Number "+(l+1)+ " price is:"+priceOfTheHouses.get(l));
                    }

                    //validate price
                    for(int k = 0;k<priceOfTheHouses.size();k++) {
                         int price = Integer.parseInt(priceOfTheHouses.get(k).replace("Rs ","").replace(",",""));
                         if(price>=5000000 && price<=7500000){
                             System.out.println("price is in selected range");
                         }
                         else{
                             System.out.println("price is not in selected range");
                         }
                    }

                    for(int m = 0;m<numBeds.size();m++){
                         int bed =  Integer.parseInt(numBeds.get(m).substring(6,7));
                         if(bed == 3){
                             System.out.println("Beds are in selected range");
                         }
                         else{
                             System.out.println("Beds are not in selected range");
                         }
                    }
                }
            }
        }
