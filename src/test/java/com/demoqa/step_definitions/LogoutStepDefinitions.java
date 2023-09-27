package com.demoqa.step_definitions;

import com.demoqa.pages.BasePage;

import com.demoqa.pages.LoginPage;
import com.demoqa.utility.BrowserUtility;
import com.demoqa.utility.ConfigurationReader;
import com.demoqa.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefinitions {

LoginPage loginP=new LoginPage();
BasePage basePage=new BasePage();

    @Given("user is logged in")
    public void user_is_logged_in() {

        String loginPage= ConfigurationReader.getProperties("urlLogin");
        Driver.getDriver().get(loginPage);

        loginP.login();



        //User should land on the profile page
        BrowserUtility.waitUntilUrlContains("profile");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("profile"));

        //User should see userName on the page
        try{
            Assert.assertTrue(loginP.userNameValue.isDisplayed());  //we could use any page object for this assertion
        }catch (RuntimeException e){
            Assert.fail("User could not login");
        }


    }
    @When("user click the logout button on the right top of the any page")
    public void user_click_the_logout_button_on_the_right_top_of_the_any_page() {
        basePage.linkLogout.click();
    }
    @Then("user should be logged out")
    public void user_should_be_logged_out() {

        //User should land on login page
        BrowserUtility.waitUntilUrlContains("login");

    }



}
