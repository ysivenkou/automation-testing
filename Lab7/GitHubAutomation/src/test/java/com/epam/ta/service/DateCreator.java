package com.epam.ta.service;

import com.epam.ta.model.Date;

public class DateCreator {
    public static final String DATE_DATESTART = "testdata.date.checkin";
    public static final String DATE_DATEEND = "testdata.date.checkout";

    public static Date withInfoFromProperty() {
        return new Date(TestDataReader.getTestData(DATE_DATESTART),
                TestDataReader.getTestData(DATE_DATEEND));
    }
}
