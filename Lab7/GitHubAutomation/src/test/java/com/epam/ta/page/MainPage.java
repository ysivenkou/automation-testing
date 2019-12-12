package com.epam.ta.page;

import com.epam.ta.model.Date;
import com.epam.ta.model.Place;
import com.epam.ta.service.PlaceCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class MainPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL =
            "https://www.tripadvisor.com/Hotels/";
    private final WebDriverWait wait;

    private final int amount = 5;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Home page opened");
        return this;
    }

    @FindBy(xpath = "//button[@id=\"SUBMIT_HOTELS\"")
    private WebElement buttonFindHotels;

    @FindBy(xpath = "//input[@class=\"typeahead_input\"]")
    private WebElement locationInputField;

    @FindBy(xpath = "//span[@data-datetype=\"CHECKIN\"")
    private final WebElement checkinSelectButton;

    @FindBy(xpath = "//span[@data-datetype=\"CHECKOUT\"")
    private final WebElement checkoutSelectButton;

    @FindBy(xpath = "/html/body/span/div[3]/div/div[2]/div[3]/span[1]/span[21]")
    private final WebElement checkinDateDec;

    @FindBy(xpath = "/html/body/span/div[3]/div/div[2]/div[3]/span[1]/span[30]")
    private final WebElement checkoutDateDec;

    @FindBy(xpath = "//div[@data-prwidget-name=\"ibex_trip_search_rooms_guests\"")
    private WebElement guestsSelectButton;

    @FindBy(xpath = "/html/body/span/div[3]/div/div[1]/div/span[1]/span[2]")
    private WebElement roomsIncrement;

    @FindBy(xpath = "/html/body/span/div[3]/div/div[2]/div/span[1]/span[2]")
    private WebElement adultsIncrement;

    @FindBy(xpath = "/html/body/span/div[3]/div/div[3]/div/span[1]/span[2]")
    private WebElement childrensIncrement;

    @FindBy(xpath = "//*[@id=\"guestsAdults\"]")
    private WebElement adultsNumber;

    @FindBy(xpath = "//*[@class=\"age-picker\"]")
    private WebElement agePicker;

    public WebElement getAgePicker() {
        return agePicker;
    }

    public void search() {
        buttonFindHotels.click();
    }

    public void adultsInremention() {
        adultsIncrement.click();
    }

    public void childrensInremention() {
        childrensIncrement.click();
    }

    public void roomsInremention() { roomsIncrement.click(); }

    public void insertLocation(Place place){
        locationInputField.sendKeys(place.getLocation());
        LOGGER.info(place.getLocation() + " selected");
    }

    public void insertCheckinDate(Date date){
        checkinSelectButton.click();
        checkinDateDec.click();
        LOGGER.info(date.getStartDate() + " selected");
    }

    public void insertCheckoutDate(Date date){
        checkoutSelectButton.click();
        checkoutDateDec.click();
        LOGGER.info(date.getStartDate() + " selected");
    }


    public void insertGuestsAdults(int amount){
        guestsSelectButton.click();
        for (int i = 0; i < amount; i++){
            adultsInremention();
        }
        LOGGER.info(amount + " guests selected");
    }

    public void insertGuestsChildren(int amount){
        guestsSelectButton.click();
        for (int i = 0; i < amount; i++){
            childrensInremention();
        }
        LOGGER.info(amount + " guests selected");
    }

    public void insertGuestsRooms(int amount){
        guestsSelectButton.click();
        for (int i = 0; i < amount; i++){
            adultsInremention();
        }
        LOGGER.info(amount + " rooms selected");
    }

    public boolean checkCurrentLocation(Place expectedPlace){
        WebElement element = insertLocation(expectedPlace);
        String text = element.getAttribute("value");
        if(text == expectedPlace.getLocation())
            return true;
        return false;
    }

    public String getAdultsNumber(){
        WebElement element = adultsNumber;
        String adultsNumber = element.getAttribute("value");
        LOGGER.info(adultsNumber);
        return adultsNumber;
    }

    public WebElement getAdultsIncrement() {
        return adultsIncrement;
    }

}
