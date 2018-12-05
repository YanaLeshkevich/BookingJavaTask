package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    private static final String US_LANGUAGE = "English (US)";
    private static final String ALT_ATTRIBUTE = "alt";

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchCountryField;

    @FindBy(xpath = "//li[@data-label='Florence, Tuscany, Italy']")
    private WebElement firstCountryInTheList;

    @FindBy(xpath = "//div[@class='xp__dates-inner xp__dates__checkin']")
    private WebElement checkInField;

    @FindBy(xpath = "//td[@data-date='2018-12-29']")
    private WebElement checkInDate;

    @FindBy(xpath = "//div[@class='xp__dates-inner xp__dates__checkout']")
    private WebElement checkOutField;

    @FindBy(xpath = "//div[@class='bui-calendar__content']//td[@data-date='2018-12-30']")
    private WebElement checkOutDate;

    @FindBy(xpath = "//button[@data-sb-id='main']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@data-id='language_selector']")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@id='current_language_foldout']/div[2]//li[@class='lang_en-us']/a")
    private WebElement englishLanguageButton;

    @FindBy(xpath = "//li[@class='user_center_option uc_language js-uc-language ']/a/img")
    private WebElement selectedLanguage;

    @FindBy(xpath = "//a[@class='xpb__link' and @data-ga-track='click|Product Expansion|airport_taxis|rideways (index)']")
    private WebElement airportTaxisButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void enterSearchCountry(String country){
        searchCountryField.click();
        searchCountryField.clear();
        searchCountryField.sendKeys(country);
    }

    public void chooseTheFirstCountry(){
        firstCountryInTheList.click();
    }

    public void clickOnCheckInField(){
        Actions action = new Actions(driver);
        action.clickAndHold(checkInField).build().perform();
    }

    public void chooseCheckInDate(){
        waitUntilFoundElement(checkInDate);
        checkInDate.click();
    }

    public void clickOnCheckOutField(){
        Actions action = new Actions(driver);
        action.clickAndHold(checkOutField).build().perform();
    }

    public void chooseCheckOutDate(){
        waitUntilFoundElement(checkOutDate);
        checkOutDate.click();
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickLanguageButton(){
        languageButton.click();
    }

    public boolean checkIfLanguageIsNotEnglish(){
        String language = selectedLanguage.getAttribute(ALT_ATTRIBUTE);
        System.out.println("Selected language is: " + language);

        return !US_LANGUAGE.equals(language);
    }

    public void chooseEnglishLanguage(){
        englishLanguageButton.click();
    }

    public void clickAirportTaxisButton(){
        airportTaxisButton.click();
    }
}
