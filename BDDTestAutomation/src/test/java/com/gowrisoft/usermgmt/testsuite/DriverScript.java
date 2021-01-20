package com.gowrisoft.usermgmt.testsuite;
import com.cucumber.listener.Reporter;
import com.gowrisoft.usermgmt.utility.ApplicationIndependent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/FeatureFiles",
		glue={"com.gowrisoft.usermgmt.stepdefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/gowrisoft-extent-reports/ResultReport.html"},
		
		tags ={"@Execute"}
		)
public class DriverScript {
	
private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void writeExtentReport() 
    {    	Reporter.loadXMLConfig(ApplicationIndependent.getReportConfigPath());

    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

}
