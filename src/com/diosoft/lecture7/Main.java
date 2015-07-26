package com.diosoft.lecture7;

import com.diosoft.lecture7.common.Event;
import com.diosoft.lecture7.common.Person;
import com.diosoft.lecture7.service.CalendarServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        if(args.length == 0)
            throw new RuntimeException("No descriptions passed");

        logger.info("Service has been started");

        // predefined attenders
        List<Person> attenders = new ArrayList<Person>() {{
            this.add(new Person.Builder().firstName("Bobo").email("test@test.ua").phone("849384938903").build());
            this.add(new Person.Builder().firstName("John").email("John@test.ua").phone("8493845444938903").build());
            this.add(new Person.Builder().firstName("Kaka").email("Kaka@test.ua").phone("456468787897").build());
        }};

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/diosoft/lecture7/applicationContext.xml");
        CalendarServiceImpl calendarService = context.getBean("calendarService", CalendarServiceImpl.class);

        // predefined events
        for(int i = 0; i < args.length; i++)
            calendarService.addEvent(args[i], ("Test task" + i), "2015-07-25 12:00:00", "2015-07-25 13:00:00", attenders);

        for (String arg : args) System.out.println(calendarService.getEventsByName(arg));

        logger.info("Service has been stopped");
    }
}
