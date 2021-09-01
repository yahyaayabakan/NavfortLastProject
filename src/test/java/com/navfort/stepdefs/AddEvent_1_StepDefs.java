package com.navfort.stepdefs;

import com.navfort.pages.AddEvent_1_Page;
import com.navfort.utilities.BrowserUtils;
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
        }else if (userType.equals("store_manager")){
            loginStepDefs.the_user_enters_the_store_manager_information();
        }
    }

    @And("the user click on {string} from the list")
    public void the_user_click_on_from_the_list(String driverName) {
        addEvent_1_page.selectDriverByName(driverName);
    }

    @Then("user should be able to access {string} module")
    public void user_should_be_able_to_access_module(String module) {
        addEvent_1_page.selectEditDeleteAddEventModule(module);
    }

    @Then("the user should not be able to see <Add Event> module")
    public void the_user_should_not_be_able_to_see_Add_Event_module() {
        Assert.assertFalse("Verify Add Event modul",addEvent_1_page.addEventInGeneralInformation.isDisplayed());
    }

    @Then("user should see the next fallowing fields")
    public void user_should_see_the_next_fallowing_fields(List<String> expectedCompulsoryFields) {
        List<String> actualFieldsInAddEventWindow = BrowserUtils.getElementsText(addEvent_1_page.allFieldsInTheAddEventWindow);
        Assert.assertTrue("Verify if Compulsory Fields are in window",actualFieldsInAddEventWindow.contains(expectedCompulsoryFields));
    }


}
