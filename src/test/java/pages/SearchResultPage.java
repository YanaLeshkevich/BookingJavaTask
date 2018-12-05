package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends PageBase {

    @FindBy(xpath = "//div[@data-id='filter_fc']//a[@data-id='fc-2']")
    private WebElement availableFreeCancellationCheckBox;

    @FindBy(xpath = "//div[@id='hotellist_inner']/div[1]//a[@class='hotel_name_link url']")
    private WebElement theFirstHotelLink;

    @FindBy(xpath = "//a[@data-id='pri-1']")
    private WebElement priceOption1CheckBox;

    @FindBy(xpath = "//div[@id='filter_24hr_reception']/div[@class='filteroptions']")
    private WebElement frontDeskCheckBox;

    @FindAll({@FindBy(xpath = "//div[@class='js_rackrate_animation_anchor smart_price_style gray-icon  b_bigger_tag   animated']/strong")})
    private List<WebElement> priceList;

    @FindBy(xpath = "//li[@class=' sort_category   sort_price ']")
    private WebElement priceButton;

    @FindBy(xpath = "//div[@class='sr_header ']/h1")
    private WebElement countryHeaderTitle;

    @FindBy(xpath = "//div[@id='filter_class']//a[@data-id='class-5']")
    private WebElement starsButton;

    @FindAll({@FindBy(xpath = "//div[@class='sr_item_main_block']/i//span[@class='invisible_spoken']")})
    private List<WebElement> starsList;

    @FindBy(xpath = "//li[@class=' sort_category   sort_distance_from_landmark ']/a")
    private WebElement distanceFromDowntownButton;

    @FindAll({@FindBy(xpath = "//span[@class='distfromdest jq_tooltip']")})
    private List<WebElement> distanceFromDowntownList;

    @FindAll({@FindBy(xpath = "//div[@class='sr_item_main_block']/div/a[contains(@class, 'district_link') and contains(text(), 'Florence')]")})
    private List<WebElement> hotelsList;

    @FindBy(xpath = "//select[@id='group_adults']")
    private WebElement adultsButton;

    @FindBy(xpath = "//div[@class='sr-usp-overlay__container']")
    private WebElement hidingElement;

    @FindAll({@FindBy(xpath = "//a[@data-id='oos-1']")})
    private List<WebElement> availabilityButtons;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickAvailableFreeCancellationCheckBox() {
        availableFreeCancellationCheckBox.click();
    }

    public void clickOnTheFirstHotelOnThePage() {
        waitUntilElementDisappeared(hidingElement);
        theFirstHotelLink.click();
    }

    public void clickLowPriceOption1(){
        priceOption1CheckBox.click();
    }

    public void clickFrontDeskCheckBox(){
        frontDeskCheckBox.click();
    }

    public void clickSortByLowerPrice(){
        priceButton.click();
    }

    public void getHotelsPriceListElements() {
        waitUntilElementDisappeared(hidingElement);

        Integer previousPrice = 0;
        for (WebElement priceElement : priceList) {
            String text = priceElement.getText();
            Assert.assertNotNull(text, "Price field is empty");
            String priceStr = text.split(" ")[1];
            Integer price = Integer.valueOf(priceStr);

            Assert.assertTrue(price > previousPrice, "Price isn't in order!");
            previousPrice = price;
        }
    }

    public void checkCountryPage(String country){
        String text = countryHeaderTitle.getText();
        Assert.assertNotNull(text, "Country header title is empty");
        String header = text.split(":")[0];

        Assert.assertEquals(header, country, "It's a wrong page for this country/city!");
    }

    public void clickStarsButton(){
        starsButton.click();
    }

    public void getStarsListElements(){
        waitUntilElementDisappeared(hidingElement);

        Integer hotelNumberOfStars = 5;
        for (WebElement starElement : starsList) {
            String startElementText = starElement.getText();
            Assert.assertNotNull(startElementText, "Stars field is empty");
            String starNumberStr = startElementText.split("-")[0];
            Integer starNumber = Integer.valueOf(starNumberStr);

            Assert.assertEquals(starNumber, hotelNumberOfStars, "The hotels were found with not correct number of stars!");
        }
    }

    public void clickOnDistanceFromDowntownButton(){
        distanceFromDowntownButton.click();
    }

    public void getDistanceFromDowntownElements() {
        waitUntilElementDisappearedLocatedBy(By.xpath("//div[@class='sr-usp-overlay__container']"));

        Integer previousDistance = 0;
        for (WebElement distanceElement : distanceFromDowntownList) {
            String distanceElementText = distanceElement.getText();
            Assert.assertNotNull(distanceElementText, "Distance field is empty");
            String distanceStr = distanceElementText.split(" ")[0];
            Integer distance = Integer.valueOf(distanceStr);

            Assert.assertTrue(distance > previousDistance, "Distance isn't in order!");
            previousDistance = distance;
        }
    }

    public void checkHotelsList() {
        waitUntilElementDisappeared(hidingElement);

        String hotelElementText = countryHeaderTitle.getText();
        Assert.assertNotNull(hotelElementText, "Hotels' field is empty");
        String numberOfHotelsStr = hotelElementText.split(" ")[1];
        Integer numberOfHotels = Integer.valueOf(numberOfHotelsStr);

        Integer hotelsCount = hotelsList.size();
        Assert.assertEquals(hotelsCount, numberOfHotels, "Numbers of hotels isn't correct");
    }

    public void clickAdultsButton(){
        adultsButton.click();
    }

    public void chooseAdultsNumber(String adultsNumber){
        Select adultsDropDown = new Select(adultsButton);
        adultsDropDown.selectByVisibleText(adultsNumber);
    }

    public void clickAvailabilityButton(){
        Assert.assertFalse(availabilityButtons.isEmpty(), "The Availability button is not found");
        availabilityButtons.get(0).click();
    }
}
