package com.demoqa.step_definitions;

import com.demoqa.pages.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class ChangeRowNumber {

    ProfilePage profilePage =new ProfilePage();
    @When("use change row number as {int}")
    public void use_change_row_number_as(Integer int1) {
        Select select=new Select(profilePage.selectObject);
        select.selectByValue(int1+"");
    }
    @Then("new row number should be {int}")
    public void new_row_number_should_be(Integer int1) {
        Assert.assertEquals(int1,(Integer) profilePage.titles.size());

    }



}
