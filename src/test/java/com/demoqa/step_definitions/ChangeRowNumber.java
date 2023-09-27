package com.demoqa.step_definitions;

import com.demoqa.pages.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class ChangeRowNumber {

    ProfilePage profilePage =new ProfilePage();



    @When("use change row number as {string}")
    public void use_change_row_number_as(String string) {

        Select select=new Select(profilePage.selectObject);
        select.selectByValue(string);
    }
    @Then("new row number should be {string}")
    public void new_row_number_should_be(String string) {
        Assert.assertEquals(Integer.parseInt(string), profilePage.titles.size());
    }




}
