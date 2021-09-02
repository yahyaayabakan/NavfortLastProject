package com.navfort.stepdefs;

import com.navfort.pages.AddEvent_1_Page;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AddEvent_1_StepDefs {

    LoginStepDefs loginStepDefs = new LoginStepDefs();
    AddEvent_1_Page addEvent_1_page = new AddEvent_1_Page();

    @When("the user enters the {string} information")
    public void the_user_enters_the_information(String userType) {
        if (userType.equals("sales_manager")) {
            try {
                loginStepDefs.the_user_enters_the_sales_manager_information();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (userType.equals("store_manager")) {
            loginStepDefs.the_user_enters_the_store_manager_information();
        }
        BrowserUtils.waitForPageToLoad(10);
    }

    @And("the user click on {string} from the list")
    public void the_user_click_on_from_the_list(String driverName) {
        BrowserUtils.waitForPageToLoad(10);
        addEvent_1_page.selectDriverByName(driverName);
    }

    @Then("user should be able to access {string} module")
    public void user_should_be_able_to_access_module(String module) {
        BrowserUtils.waitForPageToLoad(10);
        addEvent_1_page.selectEditDeleteAddEventModule(module);
    }

    @Then("the user should NOT be able to see <Add Event> module")
    public void the_user_should_NOT_be_able_to_see_Add_Event_module() {
        Assert.assertFalse("Verify Add Event modul", addEvent_1_page.addEventInGeneralInformation.isDisplayed());
    }

    @Then("user should see the next fallowing fields")
    public void user_should_see_the_next_fallowing_fields(List<String> expectedCompulsoryFields) {
        List<String> actualFieldsInAddEventWindow = BrowserUtils.getElementsAttributeText(addEvent_1_page.allFieldsInTheAddEventWindow);
        System.out.println("actualFieldsInAddEventWindow = " + actualFieldsInAddEventWindow);
        System.out.println("expectedCompulsoryFields = " + expectedCompulsoryFields);

        for (String s : expectedCompulsoryFields) {
            Assert.assertTrue("Verify if Compulsory Fields are in window", actualFieldsInAddEventWindow.contains(s));
        }
        BrowserUtils.waitForPageToLoad(10);
        addEvent_1_page.closeEventTab.click();
    }

    @When("user leave one ore more compulsory fields blank {string}, {string}, {string}")
    public void user_leave_one_ore_more_compulsory_fields_blank(String title, String organizerDisplayName, String organizerEmail) {
        addEvent_1_page.titleTextBox.sendKeys(title);
        addEvent_1_page.organizeDisplayNameTextBox.sendKeys(organizerDisplayName);
        addEvent_1_page.organizerEmailTextBox.sendKeys(organizerEmail);
        BrowserUtils.waitForPageToLoad(10);

        addEvent_1_page.saveButton.click();
    }

//    @Then("user should see {string} warning message")
//    public void user_should_see_warning_message(String expectedErrorMessage) {
//        String actualErrorMessage = addEvent_1_page.errorMessage.getText();
//
//        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
//    }

    @Then("user should see warning messages")
    public void user_should_see_warning_messages() {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue("Verify if the warning message is displaed", addEvent_1_page.errorMessage.isDisplayed());

        addEvent_1_page.closeEventTab.click();
    }

    @When("user fill all the compulsory fields {string}, {string}, {string}")
    public void user_fill_all_the_compulsory_fields(String title, String organizerDisplayName, String organizerEmail) {
        BrowserUtils.waitForPageToLoad(5);
        addEvent_1_page.titleTextBox.sendKeys(title);
        addEvent_1_page.organizeDisplayNameTextBox.sendKeys(organizerDisplayName);
        addEvent_1_page.organizerEmailTextBox.sendKeys(organizerEmail);
    }

    @Then("user should be able to add description in description box")
    public void user_should_be_able_to_add_description_in_description_box() {
        BrowserUtils.waitForPageToLoad(5);
        addEvent_1_page.descriptionBox().sendKeys("This event is created from automation test");
        BrowserUtils.waitForPageToLoad(5);
        Driver.get().switchTo().defaultContent();
        addEvent_1_page.saveButton.click();
        addEvent_1_page.setCloseEventTab();
    }

    @Then("user should see {string}")
    public void user_should_see(String string) {
        Assert.assertTrue("verify if description message is save", addEvent_1_page.successfullyAddEvent.isDisplayed());
    }


}
