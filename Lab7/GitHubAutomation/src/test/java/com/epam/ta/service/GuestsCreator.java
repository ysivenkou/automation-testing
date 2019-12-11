package com.epam.ta.service;

import com.epam.ta.model.Guests;

public class GuestsCreator {
    public static final String GUESTS_ADULTS = "testdata.guests.adult";
    public static final String GUESTS_CHILDREN = "testdata.guests.children";
    public static final String GUESTS_ROOMS = "testdata.guests.rooms";

    public static Guests withInfoFromProperty() {
        return new Guests(TestDataReader.getTestData(GUESTS_ADULTS),
                TestDataReader.getTestData(GUESTS_CHILDREN),
                TestDataReader.getTestData(GUESTS_ROOMS));
    }
}
