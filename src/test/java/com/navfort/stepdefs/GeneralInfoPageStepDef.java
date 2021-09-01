package com.navfort.stepdefs;

import com.navfort.pages.GeneralInfoVehiclePage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GeneralInfoPageStepDef {
    @When("user click on any row from the page")
    public void user_click_on_any_row_from_the_page() {
    new GeneralInfoVehiclePage().cellNameLocation("Denver").click();
    BrowserUtils.waitForClickablility(new GeneralInfoVehiclePage().cellNameLocation("DC"),3);

    }
    @Then("users should be on General Information Page Vehicle")
    public void users_should_be_on_General_Information_Page_Vehicle() {
        String actualTitle = new GeneralInfoVehiclePage().contactFullName.getText();
        boolean expectedTitle = actualTitle.contains(actualTitle);
        Assert.assertTrue(expectedTitle);
    }

    @Then("users should see the buttons Edit, Delete and Add Event on General Information Page Vehicle")
    public void users_should_see_the_buttons_Edit_Delete_and_Add_Event_on_General_Information_Page_Vehicle() {
        new GeneralInfoVehiclePage().cellNameLocation("Denver").click();
        BrowserUtils.waitFor(4);
        new GeneralInfoVehiclePage().EditDeleteAddEventBtns();
    }

    @Then("driver should see Add Event button and Edit, Delete buttons not displayed on General Information Page")
    public void driver_should_see_Add_Event_button_and_Edit_Delete_buttons_not_displayed_on_General_Information_Page() {
        new GeneralInfoVehiclePage().cellNameLocation("Denver").click();
        BrowserUtils.waitFor(3);
        new GeneralInfoVehiclePage().addEventButton.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(new GeneralInfoVehiclePage().addEventButton.isDisplayed());
    }


}
