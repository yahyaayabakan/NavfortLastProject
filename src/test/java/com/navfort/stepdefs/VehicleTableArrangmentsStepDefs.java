package com.navfort.stepdefs;

import com.navfort.pages.VehicleTableArrangmentsPage;
import com.navfort.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
            Assert.assertEquals(v.rowSize(),n1);
        }else { //else if the recordings are less than view per page value assert for less than number of row than the value on view per page

            Assert.assertTrue(v.totalRecords()<n1);
        }

    }



    @When("user should click any column {string}")
    public void user_should_click_any_column(String colName) {
                BrowserUtils.waitFor(4);
                v.navigateToColumns(colName);
                BrowserUtils.waitFor(4);
    }

    @Then("As {string} the column {string} should be sorted in ascending or descending order in default view per page condition")
    public void as_the_column_should_be_sorted_in_ascending_or_descending_order_in_default_view_per_page_condition(String userNa, String colName) throws ParseException {

        if (colName.toLowerCase().contains("date")) { //dates order checker
            //ascending order checker
            for (int j = 1; j < v.rowSize() - 1; j++){
                if(v.cellValue(j, colName, userNa).getText().trim().equals("") || v.cellValue(j + 1, colName, userNa).getText().trim().equals("")){
                    continue;
                }else {


                    Date v_date1 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).parse(v.cellValue(j, colName, userNa).getText().trim());
                    Date v_date2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).parse(v.cellValue(j + 1, colName, userNa).getText().trim());
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    BrowserUtils.waitFor(5);

                    System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText());
                    System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText());
                    System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                    Assert.assertTrue(formatter.format(v_date1).compareTo(formatter.format(v_date2)) <= 0); //check the most recent date is above the later date
                }
            }

            BrowserUtils.waitFor(5);
            v.navigateToColumns(colName);
            BrowserUtils.waitFor(5);
            //descending order checker
            for (int j = 1; j < v.rowSize() - 1; j++){
                if(v.cellValue(j, colName, userNa).getText().trim().equals("") || v.cellValue(j + 1, colName, userNa).getText().trim().equals("")){
                    continue;
                }else {



                    Date v_date1 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).parse(v.cellValue(j, colName, userNa).getText().trim());
                    Date v_date2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).parse(v.cellValue(j + 1, colName, userNa).getText().trim());
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    BrowserUtils.waitFor(5);

                    System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText());
                    System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText());
                    System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                    Assert.assertTrue(formatter.format(v_date1).compareTo(formatter.format(v_date2)) >= 0); //check the most recent date is above the later date
                }
            }

        } else if(colName.equals("License Plate")||colName.equals("Driver")||colName.equals("Location")||colName.equals("Transmission")||colName.equals("Fuel Type")||colName.equals("CO2 Emissions")||colName.equals("Horsepower")||colName.equals("Model Year")||colName.equals("Color")) {
            //checker for the given as they are strings only
            //ascending order checker
            for (int j = 1; j < v.rowSize() - 1; j++) {
                System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText());
                System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText());
                System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                BrowserUtils.waitFor(5);
                Assert.assertTrue(v.cellValue(j, colName, userNa).getText().trim().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText().trim())<=0); //if ascending

            }


            BrowserUtils.waitFor(5);
            v.navigateToColumns(colName);

            //descending order checker
            for (int j = 1; j < v.rowSize() - 1; j++) {
                System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText());
                System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText());
                System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                BrowserUtils.waitFor(5);
                Assert.assertTrue(v.cellValue(j, colName, userNa).getText().trim().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText().trim())>=0);

            }



        }else{
            //CVVI first $ character, then compare with numberformat as the numbers are 23.00 like this
            if(colName.equals("CVVI")){
                //ascending order checker
                for (int j = 1; j < v.rowSize() - 1; j++) {

                    BrowserUtils.waitFor(5);
                    if(v.cellValue(j, colName, userNa).getText().trim().equals("") || v.cellValue(j + 1, colName, userNa).getText().trim().equals("")){
                        continue;
                    }else{
                        System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText().substring(1));
                        System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText().substring(1));
                        System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                        Assert.assertTrue(NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j, colName, userNa).getText().substring(1)).intValue() <= NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j + 1, colName, userNa).getText().substring(1)).intValue()); //if ascending
                    }
                }


                BrowserUtils.waitFor(5);
                v.navigateToColumns(colName);

                //descending order checker
                for (int j = 1; j < v.rowSize() - 1; j++) {

                    BrowserUtils.waitFor(5);
                    if(v.cellValue(j, colName, userNa).getText().trim().equals("") || v.cellValue(j + 1, colName, userNa).getText().trim().equals("")){
                        continue;
                    }else {
                        System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText().substring(1));
                        System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText().substring(1));
                        System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                        Assert.assertTrue( NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j, colName, userNa).getText().trim().substring(1)).intValue()>= NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j + 1, colName, userNa).getText().trim().substring(1)).intValue());
                    }

                }
            }else{  //number formatter is used as there are numbers with 2,900, numbers that has commmas.
                //ascending order checker
                for (int j = 1; j < v.rowSize() - 1; j++) {
                    System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText());
                    System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText());
                    System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                    BrowserUtils.waitFor(5);
                    if(v.cellValue(j, colName, userNa).getText().trim().equals("") || v.cellValue(j + 1, colName, userNa).getText().trim().equals("")){
                        continue;  //as empty string cannot be parsed
                    }else{

                        Assert.assertTrue(NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j, colName, userNa).getText()).intValue() <= NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j + 1, colName, userNa).getText()).intValue()); //if ascending
                    }
                }


                BrowserUtils.waitFor(5);
                v.navigateToColumns(colName);

                //descending order checker
                for (int j = 1; j < v.rowSize() - 1; j++) {
                    System.out.println("v.cellValue(j, colName,userNa).getText() = " + v.cellValue(j, colName, userNa).getText());
                    System.out.println("v.cellValue(j + 1, colName,userNa).getText() = " + v.cellValue(j + 1, colName, userNa).getText());
                    System.out.println("v.cellValue(j, colName,userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName,userNa).getText()) = " + v.cellValue(j, colName, userNa).getText().compareToIgnoreCase(v.cellValue(j + 1, colName, userNa).getText()));
                    BrowserUtils.waitFor(5);
                    if(v.cellValue(j, colName, userNa).getText().trim().equals("") || v.cellValue(j + 1, colName, userNa).getText().trim().equals("")){
                        continue;
                    }else {
                        Assert.assertTrue( NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j, colName, userNa).getText().trim()).intValue()>= NumberFormat.getNumberInstance(Locale.UK).parse(v.cellValue(j + 1, colName, userNa).getText().trim()).intValue());
                    }

                }
            }


        }











    }




}
