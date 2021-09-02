package com.navfort.stepdefs;

import com.navfort.pages.VehiclesPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class FilterVehicleTableDataStepDefs {

    VehiclesPage v = new VehiclesPage();

    @Given("the user clicks on filter icon")
    public void the_user_clicks_on_filter_icon() throws InterruptedException {
        BrowserUtils.waitForPageToLoad(10);
        Driver.get().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        BrowserUtils.waitForClickablility(v.filterIcon,10);
        BrowserUtils.waitFor(7);
        v.filterIcon.click();
    }

    @Then("Manage Filters module should be displayed")
    public void manage_Filters_module_should_be_displayed() {
        Assert.assertTrue(v.ManageFilters.isDisplayed());
    }

    @When("the user clicks on Manage Filters module")
    public void the_user_clicks_on_Manage_Filters_module() {
       BrowserUtils.waitForClickablility(v.ManageFilters,4);
       v.ManageFilters.click();
    }

    @When("the user selects {string} from Manage Filters menu")
    public void the_user_selects_from_Manage_Filters_menu(String filterName) {
        v.selectFilter(filterName);
    }

    @Then("{string} box should be displayed next to the Manage Filters module")
    public void box_should_be_displayed_next_to_the_Manage_Filters_module(String filterName) {
        BrowserUtils.waitFor(4);
        Assert.assertTrue(v.filterDisplayed(filterName));
    }

    @When("the user types {string} to the input box")
    public void the_user_types_to_the_input_box(String str) {
      v.filterSearchBox.sendKeys(str);
    }


    @Then("Only the options which include {string} should be displayed under Manage Filters")
    public void only_the_options_which_include_should_be_displayed_under_Manage_Filters(String str) {

        Assert.assertTrue(v.optionsContain(str));
    }

    @When("the user clicks on reset icon")
    public void the_user_clicks_on_reset_icon() {
        BrowserUtils.waitForClickablility(v.resetIcon,5);
        BrowserUtils.waitFor(4);
        v.resetIcon.click();
    }



    @Then("{string} box should not be displayed next to the Manage Filters module")
    public void box_should_not_be_displayed_next_to_the_Manage_Filters_module(String filterName) {
        Assert.assertFalse(v.filterDisplayed(filterName));
    }



}
