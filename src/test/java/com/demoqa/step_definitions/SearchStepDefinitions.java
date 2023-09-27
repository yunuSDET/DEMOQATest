package com.demoqa.step_definitions;

import com.demoqa.pages.BasePage;
import com.demoqa.pages.BookStorePage;
import com.demoqa.utility.BrowserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SearchStepDefinitions {

    BasePage basePage=new BasePage();
    BookStorePage bookStorePage=new BookStorePage();

    @Given("user is on the Book Store page")
    public void user_is_on_the_book_store_page() {

        BrowserUtility.scrollByVerticalAutomaticallyAndClick(basePage.linkBookStore);
    }
    @When("user enters {string} into search box")
    public void user_enters_into_search_box(String string) {
        bookStorePage.searchBox.sendKeys(string);
    }
    @Then("listed book infos should contain {string}")
    public void listed_book_infos_should_contain(String string) {


        Map<Integer, List<String>> bookMap = bookStorePage.getBookMap();

        for (int i = 0; i < bookMap.size(); i++) {

            boolean contains=false;
            for (String each : bookMap.get(i)) {
               if(each.toLowerCase().contains(string.toLowerCase()) )
               {
                   contains=true;
               }
            }
            Assert.assertTrue(contains);
        }


    }




}
