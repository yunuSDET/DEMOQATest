package com.demoqa.pages;

import com.demoqa.utility.Driver;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStorePage {

    public BookStorePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchBox")
    public WebElement searchBox;


    @FindBy(id = "basic-addon2")
    public WebElement searchButton;


    @FindBy(xpath = "//div[@class='rt-tr-group']/div[@role='row']/div[2]")
    public List<WebElement> bookTitles;

    @FindBy(xpath = "//div[@class='rt-tr-group']/div[@role='row']/div[3]")
    public List<WebElement> authors;



    @FindBy(xpath = "//div[@class='rt-tr-group']/div[@role='row']/div[4]")
    public List<WebElement> publishers;


    public Map<Integer,List<String>> getBookMap(){

        Map<Integer,List<String>> bookMap=new HashMap<>();
        int size=bookTitles.size();

        for (int i = 0; i < size; i++) {
            List<String> bookInfos=new ArrayList<>();
            if(bookTitles.get(i).getText().isBlank()) break;
            bookInfos.add(bookTitles.get(i).getText());
            bookInfos.add(authors.get(i).getText());
            bookInfos.add(publishers.get(i).getText());
            bookMap.put(i,bookInfos);
        }


    return bookMap;

    }


}
