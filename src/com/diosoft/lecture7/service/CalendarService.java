package com.diosoft.lecture7.service;

import com.diosoft.lecture7.common.Event;
import com.diosoft.lecture7.common.Person;

import java.util.List;

public interface CalendarService {

    void addEvent(String name, String description, String startTime, String endTime, List<Person> attenders);

    Event removeEvent(Event event);

    Event addAttender(Event event, Person... newPersons);

    List<Event> getEventsByName(String name);
}
