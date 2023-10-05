package com.demoqa.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(

        plugin ={
                "html:target/reports/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/demoqa/step_definitions",
        dryRun = false,
        tags = "@smoke"

)


public class CukesRunner {

}



