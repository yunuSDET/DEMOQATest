package com.demoqa.step_definitions;

import com.demoqa.pages.BasePage;
import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.EachBookPage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.utility.BrowserUtility;
import com.demoqa.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class AddDeleteBooksStepDefinitions {

BookStorePage bookStorePage=new BookStorePage();
EachBookPage eachBookPage=new EachBookPage();
String bookTitle="";
BasePage basePage=new BasePage();
ProfilePage profilePage=new ProfilePage();

    @When("user clicks the link of {string} in the book title column")
    public void user_clicks_the_link_of_in_the_book_title_column(String string) {
        bookTitle=string;

        WebElement link = Driver.getDriver().findElement(By.partialLinkText(string));
        BrowserUtility.scrollByVerticalAutomaticallyAndClick(link);


    }
    @Then("user should be land on the page of selected book")
    public void user_should_be_land_on_the_page_of_selected_book() {
        Assert.assertTrue(eachBookPage.bookTittle.getText().toLowerCase().contains(bookTitle.toLowerCase()));
    }
    @When("user clicks add to your collection button")
    public void user_clicks_add_to_your_collection_button() {
        BrowserUtility.scrollByVerticalAutomaticallyAndClick(eachBookPage.buttonAddToYourCollection);
    }
    @When("user accepts alert")
    public void user_accepts_alert() {
        BrowserUtility.waitUntilAlertOccurs();
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Then("added book named {string} should listed profile page")
    public void added_book_named_should_listed_profile_page(String string) {

        BrowserUtility.scrollByVerticalAutomaticallyAndClick(basePage.linkProfile);


        boolean equals=false;
        for (WebElement eachTitle : profilePage.titles) {
            if(eachTitle.getText().equalsIgnoreCase(bookTitle)) equals=true;
        }

        Assert.assertTrue(equals);


    }






    @When("user clicks the delete icon of {string} in the book action column")
    public void user_clicks_the_delete_icon_of_in_the_book_action_column(String string) {
        for (int i = 0; i < profilePage.titles.size(); i++) {
            if(profilePage.titles.get(i).getText().equalsIgnoreCase(string)) {
                profilePage.deleteLinks.get(i).click();
                return;
            }
        }

        Assert.fail("Book is not listed or deleted");

    }
    @When("user clicks the ok button to accept")
    public void user_clicks_the_ok_button_to_accept() {
     BrowserUtility.waitForVisibilityOf(profilePage.deleteBookOkButton);
     profilePage.deleteBookOkButton.click();
    }
    @Then("the book named {string} should be deleted")
    public void the_book_named_should_be_deleted(String string) {


        boolean listed=false;
        for (WebElement eachTitle : profilePage.titles) {
            if(eachTitle.getText().equalsIgnoreCase(bookTitle)) listed=true;
        }

        Assert.assertFalse(listed);
    }


}
