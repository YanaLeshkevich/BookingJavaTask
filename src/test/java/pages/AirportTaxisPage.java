package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AirportTaxisPage extends PageBase {

    @FindBy(id = "pickupLocation")
    private WebElement pickupLocationLabel;

    @FindBy(xpath = "//input[@id='dropoffLocation']")
    private WebElement dropoffLocationLabel;

    @FindBy(xpath = "//ul[@id='dropoffLocation-items']//a")
    private WebElement itemDropoffFromTheList;

    @FindBy(xpath = "//ul[@id='pickupLocation-items']//a")
    private WebElement itemPickupFromTheList;

    @FindBy(xpath = "//button[@class='rw-btn__primary rw-search__btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='rw-search-date-field']/a[@aria-label='pickup date input field']/span")
    private WebElement dateField;

    @FindBy(xpath = "//a[contains(text(),'29')]")
    private WebElement dateForTaxi;

    @FindAll({@FindBy(xpath = "//li[@class='rw-search-result__item rw-search-result__item--passengers']/span[@class='with-space']")})
    private List<WebElement> listOfPassengersOnTheTaxiForm;

    @FindBy(xpath = "//select[@id='passengers']")
    private WebElement passengersField;

    private Select passengersDropDown = new Select(passengersField);

    public AirportTaxisPage(WebDriver driver) {
        super(driver);
    }

    public void writePickupLocation(String pickupLocation){
        pickupLocationLabel.click();
        pickupLocationLabel.clear();
        pickupLocationLabel.sendKeys(pickupLocation);
    }

    public void writeDropoffLocationLabel(String dropoffLocation){
        dropoffLocationLabel.click();
        dropoffLocationLabel.clear();
        dropoffLocationLabel.sendKeys(dropoffLocation);
    }

    public void chooseItemDropoffFromTheList(){
        itemDropoffFromTheList.click();
    }

    public void chooseItemPickupFromTheList(){
        itemPickupFromTheList.click();
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickChangeDate(){
        dateField.click();
    }

    public void chooseDateForTaxi(){
        dateForTaxi.click();
    }

    public void chooseTheNumberOfThePassengers(Integer passengersNumber){
        String pasengers = String.valueOf(passengersNumber);
        passengersDropDown.selectByValue(pasengers);
    }

    public void checkPassengersCountInTaxiForm(Integer passengersNumber){
        for (WebElement passengersStr : listOfPassengersOnTheTaxiForm) {
            Integer passengers = Integer.valueOf(passengersStr.getText());
            Assert.assertTrue(passengers >= passengersNumber,
                    "Taxi capacity is not suitable for so many people!");
        }
    }
}
