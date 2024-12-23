package com.example.softwareengineeringprototype3.production;

import java.util.Date;
import java.util.HashMap;

public class Calendar {
    //date is yyyyddmm

    private HashMap<Integer, String> eventsMarked = new HashMap<>();

    public void setEvent(String event, int date) {
        if (event != "")
            eventsMarked.put(date, event);
    }

    public HashMap<Integer, String> getEvents() {
        return eventsMarked;
    }

    public String getEventOnDate(int date) {
        String event = eventsMarked.get(date);

        if (event != null)
            return event;
        return "No Events";
    }

    //reminder for events on currentDate or day after
    public String reminder(int currentDate) {
        String listOfEvents = "";
        String today = eventsMarked.get(currentDate);
        String tomorrow = eventsMarked.get(currentDate+100);

        if (today != null)
            listOfEvents += "'" + today + "' - Today";

        if (today != null && tomorrow != null)
            listOfEvents += ", ";

        if (tomorrow != null)
            listOfEvents += "'" + tomorrow + "' - Tomorrow";

        if (listOfEvents.equals(""))
            return "No Events Today or Tomorrow";

        return listOfEvents;
    }

    public int getMonth(int date) {
        return (date%100);
    }

    public int getDay(int date) {
        return ((date%10000)-(date%100))/100;
    }

    public int getYear(int date) {
        return ((date)-(date%10000))/10000;
    }

}
