package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehicleTableArrangmentsPage extends BasePage {

    @FindBy(xpath = "//button[@data-toggle='dropdown']")
    public WebElement viewPerPageBtn;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> rowsOptions;

    @FindBy(xpath = "//a[@title='Reset']/i[@class='fa-refresh']")
    public WebElement resetBtn;

    @FindBy(xpath = "//tbody/tr[@class='grid-row']")
    public List<WebElement> rowCount;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> TotalrowCount;

    @FindBy(xpath = "//i[contains(text(),'Next')]")
    public WebElement nextBtn;

    @FindBy(xpath = "//label[contains(.,'Total of')]")
    public WebElement totalRecordings;

    @FindBy(xpath = "//th[contains(@class, 'descending')]/a/span[@class='caret']")
    public WebElement descendingOrd;

    @FindBy(xpath = "//th[contains(@class, 'ascending')]/a/span[@class='caret']")
    public WebElement ascendingOrd;

    @FindBy(xpath = "//tbody/tr[1]/td")
    public List<WebElement> colCount;


    //gives us the list of drop down options on our web, it starts 1=>10,2=>25,3=>50,4=>100
    public WebElement NumOfRowsFromDropDown(int dropdownNum) {
        BrowserUtils.waitFor(3);
        if (dropdownNum == 10) {
            return Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])[1]"));
        } else if (dropdownNum == 25) {
            return Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])[2]"));
        } else if (dropdownNum == 50) {
            return Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])[3]"));
        } else {
            return Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])[4]"));
        }
    }

    public int rowSize() {
        BrowserUtils.waitFor(2);
        return rowCount.size();
    }

    public int TotalRowSize() {
        BrowserUtils.waitFor(2);
        return TotalrowCount.size();
    }

    public int totalColSize() {
        BrowserUtils.waitFor(2);
        return colCount.size();
    }


    public int totalRecords() {
        String[] s = totalRecordings.getText().split(" ");
        return Integer.parseInt(s[2].trim());
    }


    public void navigateToColumns(String colName) {
        String colLocator = "//span[@class='grid-header-cell__label' and contains(.,'" + colName + "')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(colLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(colLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).click(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(colLocator), 5);
        }

    }


    public WebElement cellValue(int rowNumber, String colName,String userNa) {
        int colNum = 0;
        WebElement el = null;
        if(userNa.equalsIgnoreCase("driver")) {
            switch (colName) {
                case "License Plate":
                    colNum = 1;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Driver":
                    colNum = 3;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Location":
                    colNum = 4;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Chassis Number":
                    colNum = 5;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Model Year":
                    colNum = 6;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Last Odometer":
                    colNum = 7;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Immatriculation Date":
                    colNum = 8;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "First Contract Date":
                    colNum = 9;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "CVVI":
                    colNum = 10;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Seats Number":
                    colNum = 11;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Doors Number":
                    colNum = 12;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Color":
                    colNum = 13;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Transmission":
                    colNum = 14;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Fuel Type":
                    colNum = 15;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "CO2 Emissions":
                    colNum = 16;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Horsepower":
                    colNum = 17;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Horsepower Taxation":
                    colNum = 18;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Power (kW)":
                    colNum = 19;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;

            }
        }else {
            switch (colName) {
                case "License Plate":
                    colNum = 2;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Driver":
                    colNum = 4;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Location":
                    colNum = 5;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Chassis Number":
                    colNum = 6;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Model Year":
                    colNum = 7;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Last Odometer":
                    colNum = 8;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Immatriculation Date":
                    colNum = 9;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "First Contract Date":
                    colNum = 10;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "CVVI":
                    colNum = 11;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Seats Number":
                    colNum = 12;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Doors Number":
                    colNum = 13;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Color":
                    colNum = 14;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Transmission":
                    colNum = 15;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Fuel Type":
                    colNum = 16;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "CO2 Emissions":
                    colNum = 17;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Horsepower":
                    colNum = 18;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Horsepower Taxation":
                    colNum = 19;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
                case "Power (kW)":
                    colNum = 20;
                    el = Driver.get().findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + colNum + "]"));
                    break;
            }
        }
        return el;

    }




}
