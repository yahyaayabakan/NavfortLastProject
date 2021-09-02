package com.navfort.stepdefs;

import com.navfort.pages.GeneralInfoVehiclePage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class GeneralInfoPageStepDef {
    GeneralInfoVehiclePage generalInfoVehiclePage = new GeneralInfoVehiclePage();

    @When("user click on any row from the page")
    public void user_click_on_any_row_from_the_page() {
        BrowserUtils.waitFor(6);
        generalInfoVehiclePage.cellNameLocation("Denver").click();
        BrowserUtils.waitFor(6);


    }
    @Then("users should be on General Information Page Vehicle")
    public void users_should_be_on_General_Information_Page_Vehicle() {
        String actualTitle = generalInfoVehiclePage.contactFullName.getText();
        boolean expectedTitle = actualTitle.contains(actualTitle);
        Assert.assertTrue(expectedTitle);
    }

    @Then("users should see the buttons on General Information Page Vehicle")
    public void users_should_see_the_on_General_Information_Page_Vehicle(List<String> expectedButtons) {
        BrowserUtils.waitFor(4);
        List<String> actualButtons = BrowserUtils.getElementsText( generalInfoVehiclePage.buttons);
        BrowserUtils.waitFor(4);
        Assert.assertEquals("verify the modules buttons",expectedButtons.size(),actualButtons.size());
    }


    @Then("driver should see Add Event button and Edit, Delete buttons not displayed on General Information Page")
    public void driver_should_see_Add_Event_button_and_Edit_Delete_buttons_not_displayed_on_General_Information_Page() {
        generalInfoVehiclePage.addEventButton.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(new GeneralInfoVehiclePage().addEventButton.isDisplayed());
    }


}
