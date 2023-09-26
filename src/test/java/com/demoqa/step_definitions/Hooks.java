package com.demoqa.step_definitions;

import com.demoqa.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In the class we will be able to pass pre-  post- conditions to each scenario and each step
 */
public class Hooks {

    //import from io.cucumber.java not from junit

   // @Before
    public void setUpScenario(){

        Driver.getDriver();
        System.out.println("====Setting up browser using cucumber @Before");
    }

   // @Before("@db")
    public void setUpScenarioForDatabase(){
        System.out.println("====This will only apply to scenarios with @db tag");
    }

    @After
    public void tearDownScenario(Scenario scenario){

        //scenario.isFailed() ==> if scenario fails this method will return true boolean value

        if(scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "Screenshot"+scenario.getName());
        }



        Driver.closeDriver();
        System.out.println("====Closing browser using cucumber @After");
    }

    //@BeforeStep
    public void setupStep(){
        System.out.println("This will be implemented before each step");
    }

   // @AfterStep
    public void afterStep(){
        System.out.println("This will be implemented after each step");

    }


}
