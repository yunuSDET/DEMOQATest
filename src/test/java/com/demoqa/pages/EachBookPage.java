package com.demoqa.pages;

import com.demoqa.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EachBookPage  {

    public EachBookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[contains(text(),'Add')]")
    public WebElement buttonAddToYourCollection;


    @FindBy(xpath = "//button[contains(text(),'Back')]")
    public WebElement buttonBackToBookStore;


    @FindBy(xpath = "//div[@class='profile-wrapper']/div[2]/div[2]")
    public WebElement bookTittle;






}
