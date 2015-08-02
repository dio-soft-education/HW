package com.diosoft.lecture11.datastore;

import com.diosoft.lecture11.common.Event;
import com.diosoft.lecture11.common.Person;
import com.diosoft.lecture11.service.CalendarService;
import com.diosoft.lecture11.service.CalendarServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

public class CalendarDataStoreImplTest {

    @Test
    public void testAddEvent() throws Exception {
        // initialize variable inputs
        Event inputValue = new Event.Builder()
                .name("John")
                .description("Test")
                .startTime("2015-07-25 12:00:00")
                .endTime("2015-07-25 13:00:00")
                .attenders(new ArrayList<Person>() {{
                    this.add(new Person.Builder().firstName("Kaka").email("Kaka@test.ua").phone("456468787897").build());
                }})
                .build();

        // initialize mocks
        DataStore dataStore = mock(DataStore.class);

        // initialize class to test
        CalendarService testClass  = new CalendarServiceImpl(dataStore);

        testClass.addEvent(inputValue);

        // verify mock expectations
        verify(dataStore,times(1)).addEvent(inputValue);

        // invoke method on class to test
        testClass.removeEvent(inputValue);

        // verify mock expectations
        verify(dataStore,times(1)).removeEvent(inputValue);

        testClass  = new CalendarServiceImpl(
                new CalendarDataStoreImpl("D:\\Projects\\HW\\src\\com\\diosoft\\lecture11\\events.db"));

        testClass.addEvent(inputValue);
        List<Event> list = testClass.getEventsByName(inputValue.getName());
        Event expected = null;
        Iterator<Event> it = list.iterator();
        while(it.hasNext()) {
            Event event = it.next();
            if(inputValue.getUuid() == event.getUuid()) {
                expected = event;
                break;
            }
        }

        Assert.assertEquals(inputValue, expected);
    }

    @Test
    public void testRemoveEvent() throws Exception {

    }

    @Test
    public void testGetEventsByName() throws Exception {

    }
}