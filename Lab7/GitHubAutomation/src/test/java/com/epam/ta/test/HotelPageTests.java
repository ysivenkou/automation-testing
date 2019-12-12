package com.epam.ta.test;

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


public class HotelPageTests extends CommonConditions {

    @Test(description = "test chechboxes")
    public void checkboxesTest() {
        Place testPlace = PlaceCreator.withInfoFromProperty();


    }




}