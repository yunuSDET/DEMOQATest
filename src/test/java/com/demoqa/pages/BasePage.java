package com.demoqa.pages;

import com.demoqa.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Login']")
    public WebElement linkLogin;

    @FindBy(xpath = "//span[.='Book Store']")
    public WebElement linkBookStore;


    @FindBy(xpath = "//span[.='Profile']")
    public WebElement linkProfile;


    @FindBy(id = "submit")
    public WebElement linkLogout;


    @FindBy(id = "userName-value")
    public WebElement userNameValue;



    public void logout(){
        linkLogout.click();
    }

    

}
