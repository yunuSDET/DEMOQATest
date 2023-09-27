package com.demoqa.pages;

import com.demoqa.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage {

    public ProfilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[@class='rt-tr-group']/div[@role='row']/div[2]")
    public List<WebElement> titles;

    @FindBy(xpath = "//div[@class='rt-tr-group']/div[@role='row']/div[5]//span")
    public List<WebElement> deleteLinks;

    @FindBy(id = "closeSmallModal-ok")
    public WebElement deleteBookOkButton;


    @FindBy(css = "[aria-label='rows per page']")
    public WebElement selectObject;


}
