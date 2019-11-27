package by.bsu.lab4;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.format.DateTimeFormatter;

public class HomePage {
    private final String HOMEPAGE_URL = "https://www.tripadvisor.com/hotels/";
    private final int WAIT_TIMEOUT_SECONDS = 30;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(HOMEPAGE_URL);
        PageFactory.initElements(this.driver, this);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }


}
