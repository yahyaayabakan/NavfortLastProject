package com.navfort.stepdefs;

import com.navfort.pages.VehicleTableArrangmentsPage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VehicleTableArrangmentsStepDefs {

    VehicleTableArrangmentsPage v = new VehicleTableArrangmentsPage();
    @When("user clicks on view per page drop down")
    public void user_clicks_on_view_per_page_drop_down() {
        BrowserUtils.waitFor(4);
        v.viewPerPageBtn.click(); //simply clicks on the arrow on the view per page drop down
    }

    @Then("rows or vehicle numbers should be displayed")
    public void rows_or_vehicle_numbers_should_be_displayed() {
        for (WebElement n : v.rowsOptions ) {
            Assert.assertTrue(n.isDisplayed()); //Asserts the display of 10,25,50,100 on the drop down
        }
    }

    @When("user clicks the reset button")
    public void user_clicks_the_reset_button() {
        //v.NumOfRowsFromDropDown(50).click();//it gets third that is 50 from dropdown list and clicks it
        BrowserUtils.waitFor(4);
        v.resetBtn.click(); //when reset clicked the default value should be 25
    }

    @Then("rows or vehicle numbers displayed should be {string}")
    public void rows_or_vehicle_numbers_displayed_should_be(String str) {
        String expected = v.viewPerPageBtn.getText(); //after the reset is clicked the value is 25
        Assert.assertEquals(expected,str); // actual = 25 is asserted with expected = 25
    }

    @When("user selects {string} from the dropdown list")
    public void user_selects_from_the_dropdown_list(String str) {
        int n = Integer.parseInt(str);
        BrowserUtils.waitFor(3);
        v.NumOfRowsFromDropDown(n).click(); //takes the values 10,25,50,100 and clicks them. To display rows.
    }



    @Then("user should be able to display {int} rows or vehicle numbers if the number of vehicles registered is equal to or greater than {int}")
    public void user_should_be_able_to_display_rows_or_vehicle_numbers_if_the_number_of_vehicles_registered_is_equal_to_or_greater_than(Integer int1, Integer int2) {
        int n1 = int1;
        if(v.totalRecords()>n1){ //check the total recordings, if greater divid and get the quint.
            for (int i = 1; i <=v.totalRecords()/n1; i++) {   // continue the loop until the quint
               Assert.assertEquals(v.rowSize(), n1);
               v.nextBtn.click();
               if (v.totalRecords() % n1 == 0) {  // if evenly divisable always check for equlity
                   Assert.assertEquals(v.rowSize(), n1);
               } else {//else if not evenly divisible always check for less number of rows than the value on the view per page
                   Assert.assertTrue(v.rowSize()<n1);
               }
           }

        }else if(v.totalRecords()==n1){  //if recondings is equal to view per page assert
            System.out.println("second if");
            Assert.assertEquals(v.rowSize(),n1);
        }else { //else if the recordings are less than view per page value assert for less than number of row than the value on view per page
            System.out.println("third if");
            Assert.assertTrue(v.totalRecords()<n1);
        }

    }



    @When("user should click any column {string}")
    public void user_should_click_any_column(String colName) {
                BrowserUtils.waitFor(4);
                v.navigateToColumns(colName);
                BrowserUtils.waitFor(4);
    }

    @Then("the column {string} should be sorted in ascending or descending order")
    public void the_column_should_be_sorted_in_ascending_or_descending_order(String colName) throws ParseException {

//        if (colName.contains("DATE")) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            for (int j = 1; j < v.rowSize() - 1; j++){
//                Date date1 = format.parse(v.cellValue(j, colName).getText()); //first value from the list
//                Date date2 = format.parse(v.cellValue(j + 1, colName).getText()); //second value from the list
//                Assert.assertTrue(date1.after(date2)); //check the most recent date is above the later date
//            }
//
//            BrowserUtils.waitFor(4);
//            v.navigateToColumns(colName);
//            BrowserUtils.waitFor(4);
//
//            for (int j = 1; j < v.rowSize() - 1; j++){
//                Date date1 = format.parse(v.cellValue(j, colName).getText()); //first value from the list
//                Date date2 = format.parse(v.cellValue(j + 1, colName).getText()); //second value from the list
//                Assert.assertTrue(date1.before(date2)); //check the most recent date is above the later date
//            }
//
//        } else {
            for (int j = 1; j < v.rowSize() - 1; j++) {
                BrowserUtils.waitFor(4);
                Assert.assertTrue(v.cellValue(j, colName).getText().compareToIgnoreCase(v.cellValue(j + 1, colName).getText()) <= 0); //if ascending
                BrowserUtils.waitFor(4);

            }


            BrowserUtils.waitFor(4);
            v.navigateToColumns(colName);
            BrowserUtils.waitFor(4);

            for (int j = 1; j < v.rowSize() - 1; j++) {
                BrowserUtils.waitFor(4);
                Assert.assertTrue(v.cellValue(j, colName).getText().compareToIgnoreCase(v.cellValue(j + 1, colName).getText()) >= 0);
                BrowserUtils.waitFor(4);
            }
//        }
    }




}
