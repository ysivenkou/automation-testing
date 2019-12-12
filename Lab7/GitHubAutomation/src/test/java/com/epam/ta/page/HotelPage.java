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

public class HotelPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final String HOMEPAGE_URL =
            "https://www.tripadvisor.com/Hotels/";
    private final WebDriverWait wait;

    private final int amount = 5;

    public HotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @Override
    public HotelPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        LOGGER.info("Home page opened");
        return this;
    }

    @FindBy(xpath = "//*[@class=\"age-picker\"]")
    private WebElement agePicker;

    public WebElement getAgePicker() {
        return agePicker;
    }

    public void search() {
        buttonFindHotels.click();
    }

}
