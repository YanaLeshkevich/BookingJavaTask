package stepsDefinition;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HotelPage;
import pages.MainPage;
import pages.SearchResultPage;

public class SearchAccommodationsSteps {

    private static final String COUNTRY = "Florence, Tuscany, Italy";
    private static final String CITY = "Florence";
    private static final String ADULTS_COUNT = "4 adults";
    private static final String HOME_PAGE = "https://www.booking.com/";

    private WebDriver driver;

    public SearchAccommodationsSteps(BaseUtil baseUtil) {
        this.driver = baseUtil.getDriver();
    }

    @Given("^User is on home page$")
    public void userIsOnHomePage() throws Throwable {
        System.out.println("User is on home page");
        driver.get(HOME_PAGE);
    }

    @When("^User change the language$")
    public void userChangeTheLanguage() throws Throwable {
        System.out.println("User change the language");
        MainPage mainPage = new MainPage(driver);
        boolean languageIsNotEnglish = mainPage.checkIfLanguageIsNotEnglish();
        if (languageIsNotEnglish) {
            mainPage.clickLanguageButton();
            mainPage.chooseEnglishLanguage();
        }
    }

    @And("^User choose country$")
    public void userChooseCountry() throws Throwable {
        System.out.println("User choose country");
        MainPage mainPage = new MainPage(driver);
        mainPage.enterSearchCountry(COUNTRY);
        mainPage.chooseTheFirstCountry();
    }

    @And("^Choose the dates for travel$")
    public void chooseTheDatesForTravel() throws Throwable {
        System.out.println("Choose the dates for travel");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCheckInField();
        mainPage.chooseCheckInDate();
        mainPage.clickOnCheckOutField();
        mainPage.chooseCheckOutDate();
    }

    @And("^Click Search button$")
    public void clickSearchButton() throws Throwable {
        System.out.println("Click Search button");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearchButton();
    }

    @Then("^Verify that user on the country page$")
    public void verifyThatUserOnTheCountryPage() throws Throwable {
        System.out.println("Verify that user on the country page");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkCountryPage(CITY);
    }


    @When("^User sort by free cancellation$")
    public void userSortByFavorableOffer() throws Throwable {
        System.out.println("User only sorts hotels by only show available properties");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickAvailableFreeCancellationCheckBox();
    }

    @And("^Click on the first hotel$")
    public void clickOnTheFirstHotel() throws Throwable {
        System.out.println("Click on the first hotel");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOnTheFirstHotelOnThePage();
    }

    @Then("^Verify there are free rooms$")
    public void verifyThereAreFreeRooms() throws Throwable {
        System.out.println("Verify there are free rooms");
        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.checkIfFreeRoomIsThere();
    }

    @When("^User sort by price option one$")
    public void userSortByPrice() throws Throwable {
        System.out.println("User sort by price");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickLowPriceOption1();
    }

    @And("^Sort by (\\d+)hour Front Desk$")
    public void sortByHourFrontDesk(int arg0) throws Throwable {
        System.out.println("Sort by 24hour Front Desk");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickFrontDeskCheckBox();
    }

    @Then("^Verify number of hotels with actually numbers of hotels$")
    public void verifyNumberOfHotelsWithActuallyNumbersOfHotels() throws Throwable {
        System.out.println("Verify number of hotels with actually numbers of hotels");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkHotelsList();
    }

    @When("^Sort result by lower price$")
    public void sortResultByLowerPrice() throws Throwable {
        System.out.println("Sort result by lower price");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickSortByLowerPrice();
    }

    @Then("^Verify items order by price$")
    public void verifyItemsOrderByPrice() throws Throwable {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.getHotelsPriceListElements();
    }

    @When("^Sort result by stars$")
    public void sortResultByStars() throws Throwable {
        System.out.println("Sort result by stars");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickStarsButton();
    }

    @Then("^Verify items order stars$")
    public void verifyItemsOrderStars() throws Throwable {
        System.out.println("Verify items order stars");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.getStarsListElements();
    }

    @When("^Sort result by Distance from Downtown$")
    public void sortResultByDistanceFromDowntown() throws Throwable {
        System.out.println("Sort result by Distance from Downtown");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOnDistanceFromDowntownButton();
    }

    @Then("^Verify items order by Distance from Downtown$")
    public void verifyItemsOrderByDistanceFromDowntown() throws Throwable {
        System.out.println("Verify items order by Distance from Downtown");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.getDistanceFromDowntownElements();
    }

    @When("^Change number of adults$")
    public void changeNumberOfAdults() throws Throwable {
        System.out.println("Change number of adults");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickAdultsButton();
        searchResultPage.chooseAdultsNumber(ADULTS_COUNT);
    }

    @Then("^Verify number of adults on the hotel page$")
    public void verifyNumberOfAdultsOnTheHotelPage() throws Throwable {
        System.out.println("Verify number of adults on the hotel page");
        HotelPage hotelPage = new HotelPage(driver);
        hotelPage.checkAdultsNumber(ADULTS_COUNT);
    }

    @And("^Sort by availability hotel$")
    public void sortByAvailabilityHotel() throws Throwable {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickAvailabilityButton();
    }
}
