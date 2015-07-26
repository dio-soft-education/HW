package com.diosoft.lecture7.datastore;

import com.diosoft.lecture7.common.Event;

import java.util.List;

public interface DataStore {

    void addEvent(Event inputValue);

    void removeEvent(Event inputValue);

    List<Event> getEventsByName(String inputValue);
}
