package com.example.softwareengineeringprototype3.production;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {

    Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = new Calendar();
        calendar.setEvent("Assignment 1 Due", 20241203);
    }

    @AfterEach
    void tearDown() {
        calendar = null;
    }

    @Test
    void setEvent() {
        String event = "Software Engineering Exam";
        calendar.setEvent(event, 20241004);
        assertEquals("Software Engineering Exam", calendar.getEvents().get(20241004));
    }

    @Test
    void getEventOnDate() {
        calendar.setEvent("", 20000101);

        assertEquals("Assignment 1 Due", calendar.getEventOnDate(20241203));
        assertEquals("No Events", calendar.getEventOnDate(00000000));
        assertEquals("No Events", calendar.getEventOnDate(20000101));
    }

    @Test
    void reminder() {
        calendar.setEvent("Assignment 1 Demo", 20241303);
        assertEquals(calendar.reminder(20241103), "'Assignment 1 Due' - Tomorrow");
        assertEquals(calendar.reminder(20241203), "'Assignment 1 Due' - Today, 'Assignment 1 Demo' - Tomorrow");
        assertEquals(calendar.reminder(20241303), "'Assignment 1 Demo' - Today");
        assertEquals(calendar.reminder(20241403), "No Events Today or Tomorrow");
        assertEquals(calendar.reminder(20000000), "No Events Today or Tomorrow");
    }

    @Test
    void getDay() {
        assertEquals(12, calendar.getDay(20241204));
        assertEquals(4, calendar.getDay(20240403));
    }

    @Test
    void getMonth() {
        assertEquals(11, calendar.getMonth(20241211));
        assertEquals(4, calendar.getMonth(20240504));
    }

    @Test
    void getYear() {
        assertEquals(2024, calendar.getYear(20241211));
        assertEquals(1900, calendar.getYear(19000504));
    }

}