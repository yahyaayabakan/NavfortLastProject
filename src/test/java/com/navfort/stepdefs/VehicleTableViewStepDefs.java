package com.navfort.stepdefs;

import com.navfort.pages.*;

import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;


public class VehicleTableViewStepDefs {

    @Then("user can see all vehicle info")
    public void user_can_see_all_vehicle_info() {


        TableViewPage tableViewPage = new TableViewPage();

        tableViewPage.vehiclesInfo();


    }

    @Then("user should see total page number")
    public void user_should_see_total_page_number() {

        DashboardPage dashboardPage = new DashboardPage();
        TableViewPage tableViewPage = new TableViewPage();

        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualNumber = tableViewPage.getPageNumber();
        String expectedNumber = "Of 1 |";

        Assert.assertEquals(expectedNumber, actualNumber);
    }


    @Then("user clicks > button to go to next page")
    public void user_clicks_button_to_go_to_next_page() {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        TableViewPage tableViewPage = new TableViewPage();
        tableViewPage.goNext();

    }

    @Then("the user should see total recordings of vehicles")
    public void the_user_should_see_total_recordings_of_vehicles() {


        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        TableViewPage tableViewPage = new TableViewPage();
        String actual = tableViewPage.getTotalRecordsVehicles();
        String expected = "Total Of 20 Records";

        Assert.assertEquals(expected, actual);


    }

    @Then("user can download table data in XLS or CSV format from Export Grid")
    public void user_can_download_table_data_in_XLS_or_CSV_format_from_Export_Grid() {


        TableViewPage tableViewPage = new TableViewPage();

        tableViewPage.clickGrid();
        tableViewPage.clickCSV();
        String actualDownConf = tableViewPage.downConf();
        String expected = "Export started successfully. You will receive email notification upon completion.";
        Assert.assertEquals(expected, actualDownConf);


    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        Driver.get().get(ConfigurationReader.get("url"));

        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (userType.equals("store manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }
        new LoginPage().login(username, password);


    }

    @And("the user clicks < button to go to previous page")
    public void the_user_clicks_button_to_go_to_previous_page() {

        TableViewPage tableViewPage = new TableViewPage();
        tableViewPage.goBack();
    }


}


