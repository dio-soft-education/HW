package com.diosoft.lecture11.datastore;

import com.diosoft.lecture11.common.Event;
import com.diosoft.lecture11.common.Person;
import com.diosoft.lecture11.service.CalendarService;
import com.diosoft.lecture11.service.CalendarServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlDataStoreExportImplTest {

    @Test
    public void testExportDataStore() throws Exception {
        List<Event> list = new ArrayList<Event>();
        list.add(new Event.Builder()
            .name("John")
            .description("Test")
            .startTime("2015-07-25 12:00:00")
            .endTime("2015-07-25 13:00:00")
            .attenders(new ArrayList<Person>() {{
                this.add(new Person.Builder().firstName("Kaka").email("Kaka@test.ua").phone("456468787897").build());
            }})
            .build()
        );
        list.add(new Event.Builder(list.get(0)).name("Bob").build());
        list.add(new Event.Builder(list.get(0)).name("Keel").description("Test2").build());
        list.add(new Event.Builder(list.get(0)).name("Rob").description("Test4").build());

        DataStore dataStore = new CalendarDataStoreImpl("D:\\Projects\\HW\\src\\com\\diosoft\\lecture11\\events.db");
        CalendarService testClass = new CalendarServiceImpl(dataStore);

        for(Iterator<Event> it = list.iterator(); it.hasNext();) {
            testClass.addEvent(it.next());
        }

        DataStoreExport export = new XmlDataStoreExportImpl(dataStore);
        export.exportDataStore("D:\\Projects\\HW\\src\\com\\diosoft\\lecture11\\export\\xml.zip");
    }
}