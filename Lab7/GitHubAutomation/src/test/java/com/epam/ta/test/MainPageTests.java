package com.epam.ta.test;

import com.epam.ta.model.Date;
import com.epam.ta.model.Place;
import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.page.MainPage;
import com.epam.ta.service.PlaceCreator;
import com.epam.ta.service.UserCreator;
import com.epam.ta.util.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class MainPageTests extends CommonConditions {

    @Test(description = "Test searches accomodation with only location specified")
    public void locationSpecifiedTest() {
        Place testPlace = PlaceCreator.withInfoFromProperty();

        MainPage page = new MainPage(driver).openPage();
        page.insertLocation(testPlace);
        page.search();
        Place expectedPlace = PlaceCreator.withInfoFromProperty();
        Assert.assertTrue(page.checkCurrentLocation(expectedPlace));
    }

    @Test(description = "Test checks incrementing of Adults field by pushing '+' button")
    public void incrementTest(){
        MainPage page = new MainPage(driver).openPage();
        page.insertGuestsAdults();
        int currentAdultsNumber = Integer.parseInt(page.getAdultsNumber());
        page.adultsInremention();
        int newAdultsNumber = Integer.parseInt(page.getAdultsNumber());
        Assert.assertEquals(currentAdultsNumber+1, newAdultsNumber);
    }

    @Test(description = "check autoincremention of rooms amount")
    public void roomTest() {
        int trueAmount = 5;
        MainPage page = new MainPage(driver).openPage();
        page.insertGuestsAdults(4);
        page.insertGuestsRooms(17);
        int roomsAmount = Integer.valueOf(page.getAdultsNumber());
        Assert.assertEquals(roomsAmount, trueAmount);
    }

    @Test(description = "check having age picker for children")
    public void childAgeTest() {
        MainPage page = new MainPage(driver).openPage();
        page.insertGuestsChildren(1);
        Assert.assertNotNull(page.getAgePicker());
    }

    @Test(description = "find hotels")
    public void findHotelsTest() {
        int trueAmount = 5;
        MainPage page = new MainPage(driver).openPage();
        Date date = new Date("Dec 26", "Jan 15");
        page.insertLocation(new Place("Budapest"));
        page.insertCheckinDate(date.getStartDate());
        page.insertCheckinDate(date.getEndDate());
        page.insertGuestsAdults(3);
        page.search();
    }
}

