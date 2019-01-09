package com.tirebuyer.framework;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = "com/tirebuyer/stepdefs", features = "src/main/resources/com/tirebuyer/features", plugin = {
		"html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
		"pretty:target/cucumber-pretty.txt" }, monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}