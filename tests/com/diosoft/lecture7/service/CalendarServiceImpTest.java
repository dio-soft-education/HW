package com.diosoft.lecture7.service;

import com.diosoft.lecture7.common.Event;
import com.diosoft.lecture7.common.Person;
import com.diosoft.lecture7.datastore.DataStore;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CalendarServiceImpTest {

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

        // invoke method on class to test
        testClass.removeEvent(inputValue);

        // assert return value

        // verify mock expectations
        verify(dataStore,times(2)).removeEvent(inputValue);

    }

//    @Test
//    public void testGetEventsByName() throws Exception {
//        // initialize variable inputs
//        Event expectedEvent = new Event();
//        List<Event> expectedValue = Arrays.asList(expectedEvent);
//
//        String inputValue = "Stand-up";
//
//        // initialize mocks
//        DataStore dataStore = mock(DataStore.class);
//
////        doThrow(new NullPointerException())
////
////                .when(dataStore).getEventsByTitle(inputValue);
//
//        when(dataStore.getEventsByTitle(inputValue))
//                .thenReturn(expectedValue);
//
//        // initialize class to test
//        CalendarService testClass  = new CalendarServiceImp(dataStore);
//
//        // invoke method on class to test
//        List<Event> returnedValue = testClass.searchByTitle(inputValue);
//
//        // assert return value
//
//        assertEquals(expectedValue,returnedValue);
//
//        // verify mock expectations
//    }
//
//    @Test
//    public void testRemove() throws Exception {
//        // initialize variable inputs
//        UUID inputValue = UUID.randomUUID();
//
//
//        // initialize mocks
//
//        // initialize class to test
//        CalendarService calendarServiceImp = new CalendarServiceImpl(null);
//        CalendarService testClass = spy(calendarServiceImp);
//
//        // invoke method on class to test
//        testClass.removeEvent(inputValue);
//
//        // assert return value
//
//        // verify mock expectations
//        verify(testClass).logInfo(inputValue);
//
//    }
}