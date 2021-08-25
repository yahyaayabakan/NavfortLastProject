package com.navfort.stepdefs;

import com.navfort.pages.VehiclesPage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;


import java.util.List;


public class GridSettingsStepDefs {
    @When("the user clicks to grid settings button")
    public void the_user_clicks_to_grid_settings_button() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        BrowserUtils.waitForClickablility(vehiclesPage.gridSettingsButton,10);
        vehiclesPage.gridSettingsButton.click();
    }

    @Then("Column names in grid settings should include following options")
    public void column_names_in_grid_settings_should_include_following_options(List<String> gridOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(new VehiclesPage().columnNames);
        Assert.assertEquals(actualOptions,gridOptions);
    }

    @When("the user clicks and type any {string}")
    public void the_user_clicks_and_type_any(String columnName) {
       VehiclesPage vehiclesPage = new VehiclesPage();
       vehiclesPage.quickSearch.sendKeys(columnName);
    }


    @Then("column name should be found")
    public void column_name_should_be_found() {
        Assert.assertTrue(new VehiclesPage().filterMatch.isDisplayed());
    }

    @When("the user unselect all column checkbox")
    public void the_user_unselect_all_column_checkbox() {
        for (int i = 0; i < new VehiclesPage().allCheckboxes.size(); i++) {
            new VehiclesPage().allCheckboxes.get(i).click();
        }
    }
    @Then("Id should be displayed on table")
    public void id_should_be_displayed_on_table() {
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.closeGridButton.click();
        Assert.assertTrue(vehiclesPage.idTable.isDisplayed());
    }




}
