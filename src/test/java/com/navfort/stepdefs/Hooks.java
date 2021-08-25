package com.navfort.stepdefs;

import com.navfort.pages.ContactsPage;
import com.navfort.pages.DashboardPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE");
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }

    @Before("@abc")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After("@abc")
    public void closeDb(){
        System.out.println("\tdisconnecting to database...");

    }


    public static class NavigationMenuStepDefs {
        @When("the user navigates to Fleet, Vehicles")
        public void the_user_navigates_to_Fleet_Vehicles() {
            //selenium code
            System.out.println("the user navigates to Fleet, Vehicles");
        }

        @Then("the title should be Vehicles")
        public void the_title_should_be_Vehicles() {
            System.out.println("Expected and Actual title are matching");
        }

        @When("the user navigates to Marketing, Campaigns")
        public void the_user_navigates_to_Marketing_Campaigns() {
            System.out.println("the user navigates to Marketing, Campaigns");

        }

        @Then("title should be Campaigns")
        public void title_should_be_Campaigns() {
            System.out.println("Expected and Actual title are matching");
        }

        @When("the user navigates to Activities, Calendar Events")
        public void the_user_navigates_to_Activities_Calendar_Events() {
            System.out.println("the user navigates to Activities, Calendar Events");

        }

        @Then("title should be Calendars")
        public void title_should_be_Calendars() {
            System.out.println("Expected and Actual title are matching");
        }


        @When("the user navigates to {string} {string}")
        public void the_user_navigates_to(String tab, String module) {
            new DashboardPage().navigateToModule(tab,module);
        }


        @Then("default page number should be {int}")
        public void default_page_number_should_be(Integer expectedPageNum) {
            BrowserUtils.waitFor(3);
            ContactsPage contactsPage = new ContactsPage();
            Integer actualNumber =Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

            Assert.assertEquals(expectedPageNum,actualNumber);
        }



    }
}
