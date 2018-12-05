package stepsDefinition;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AirportTaxisPage;
import pages.MainPage;

import java.util.ArrayList;

public class SearchAirportTaxiSteps {


    private WebDriver driver;

    private static final String CITY_AIRPORT = "Florence";
    private static final String DROPOFF_LOCATION = "PLUS Florence Hostel & Hotel";
    private static final Integer PASSENGERS_NUMBER = 4;

    public SearchAirportTaxiSteps(BaseUtil baseUtil) {
        this.driver = baseUtil.getDriver();
    }

    @When("^User choose Airport taxi$")
    public void userChooseAirportTaxi() throws Throwable {
        System.out.println("User choose Airport taxi");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAirportTaxisButton();
    }

    @And("^Write Pick-up and Drop-off locations$")
    public void writePickUpAndDropOffLocations() throws Throwable {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println("Write Pick-up and Drop-off locations");
        AirportTaxisPage airportTaxisPage = new AirportTaxisPage(driver);
        airportTaxisPage.writePickupLocation(CITY_AIRPORT);
        airportTaxisPage.chooseItemPickupFromTheList();
        airportTaxisPage.writeDropoffLocationLabel(DROPOFF_LOCATION);
        airportTaxisPage.chooseItemDropoffFromTheList();
        airportTaxisPage.clickChangeDate();
        airportTaxisPage.chooseDateForTaxi();
        airportTaxisPage.chooseTheNumberOfThePassengers(PASSENGERS_NUMBER);
    }

    @And("^Click Search button for taxi$")
    public void clickSearchButtonForTaxi() throws Throwable {
        System.out.println("Click Search button for taxi");
        AirportTaxisPage airportTaxisPage = new AirportTaxisPage(driver);
        airportTaxisPage.clickSearchButton();
    }

    @Then("^Verify the number of passengers on the taxi form$")
    public void verifyTheNumberOfPassengersOnTheTaxiForm() throws Throwable {
        System.out.println("Verify the number of passengers on the taxi form");
        AirportTaxisPage airportTaxisPage = new AirportTaxisPage(driver);
        airportTaxisPage.checkPassengersCountInTaxiForm(PASSENGERS_NUMBER);
    }
}
