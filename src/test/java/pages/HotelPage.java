package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HotelPage extends PageBase {

    @FindBy(xpath = "//table[@class='hprt-table  hprt-table-long-language ']")
    private WebElement freeRoomTable;

    @FindBy(xpath = "//a[contains(@class,'av-summary-guests')]")
    private WebElement adultsTiile;

    public HotelPage(WebDriver driver) {
        super(driver);
    }

    public void checkIfFreeRoomIsThere() {
        changeWindowTab();
        Assert.assertTrue(freeRoomTable.isDisplayed());
    }

    public void checkAdultsNumber(String adultsNumber){
        changeWindowTab();
        System.out.println("Class: " + adultsTiile.getText());
        Assert.assertEquals(adultsTiile.getText(), adultsNumber, "Not correct number of adults!");
    }
}
