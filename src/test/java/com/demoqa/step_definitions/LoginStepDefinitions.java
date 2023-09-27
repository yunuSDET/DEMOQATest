package com.demoqa.step_definitions;

import com.demoqa.pages.LoginPage;
import com.demoqa.utility.BrowserUtility;
import com.demoqa.utility.ConfigurationReader;
import com.demoqa.utility.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();

    String userName= ConfigurationReader.getProperties("userName");
    String password= ConfigurationReader.getProperties("password");


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String loginPage= ConfigurationReader.getProperties("urlLogin");
        Driver.getDriver().get(loginPage);

    }



    @When("user enters correct userName")
    public void user_enters_correct_user_name() {
        loginPage.inputUserName.sendKeys(userName);
    }
    @When("user enters correct password")
    public void user_enters_correct_password() {
        loginPage.inputPassword.sendKeys(password);
    }




    @When("user click login button")
    public void user_click_login_button() {
        loginPage.buttonLogin.click();
    }


    @Then("user should see userName on the profile page")
    public void user_should_see_user_name_on_the_profile_page() {
        //User should land on the profile page
        BrowserUtility.waitUntilUrlContains("profile");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("profile"));

        //User should see userName on the page
        try{
            Assert.assertTrue(loginPage.userNameValue.isDisplayed());
        }catch (RuntimeException e){
            Assert.fail("User could not login");
        }

    }



    @When("user hits the enter")
    public void user_hits_the_enter() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
    }




    @When("user enters {string} as userName")
    public void user_enters_as_user_name(String string) {
        loginPage.inputUserName.sendKeys(string);
    }
    @When("user enters {string} as password")
    public void user_enters_as_password(String string) {
        loginPage.inputPassword.sendKeys(string);
    }
    @Then("input boxes should be red lined")
    public void input_boxes_should_be_red_lined() {
        String classValueOfUserNameInputBox=loginPage.inputUserName.getAttribute("class");
        Assert.assertTrue(classValueOfUserNameInputBox.contains("is-invalid"));

        String classValueOfPasswordInputBox=loginPage.inputPassword.getAttribute("class");
        Assert.assertTrue(classValueOfPasswordInputBox.contains("is-invalid"));

    }





    @Then("Invalid username or password error should occur")
    public void invalid_username_or_password_error_should_occur() {
        Assert.assertTrue(loginPage.resultString.getText().contains("Invalid"));
    }
    
    
    


}
