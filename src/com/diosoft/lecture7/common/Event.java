package com.diosoft.lecture7.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@JsonDeserialize(builder = Event.Builder.class)
public class Event implements Serializable {

    private final String name;
    private final String description;
    private final List<Person> attenders;
    private final GregorianCalendar startTime;
    private final GregorianCalendar endTime;
    private final String uuid;

    private Event(Builder obj) {
        this.name = obj.name;
        this.description = obj.description;
        this.attenders = obj.attenders;
        this.startTime = obj.startTime;
        this.endTime = obj.endTime;
        this.uuid = obj.uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getAttenders() {
        return attenders;
    }

    public GregorianCalendar getStartTime() {
        return startTime;
    }

    public GregorianCalendar getEndTime() {
        return endTime;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (getName() != null ? !getName().equals(event.getName()) : event.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(event.getDescription()) : event.getDescription() != null)
            return false;
        if (getAttenders() != null ? !getAttenders().equals(event.getAttenders()) : event.getAttenders() != null)
            return false;
        if (getStartTime() != null ? !getStartTime().equals(event.getStartTime()) : event.getStartTime() != null)
            return false;
        return !(getEndTime() != null ? !getEndTime().equals(event.getEndTime()) : event.getEndTime() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getAttenders() != null ? getAttenders().hashCode() : 0);
        result = 31 * result + (getStartTime() != null ? getStartTime().hashCode() : 0);
        result = 31 * result + (getEndTime() != null ? getEndTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", attenders=" + attenders +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder {

        private String name;
        private String description;
        private List<Person> attenders;
        private GregorianCalendar startTime;
        private GregorianCalendar endTime;
        private String uuid;

        public Builder() {}

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder startTime(String startTime) {
            this.startTime = this.getTime(startTime);
            return this;
        }

        public Builder endTime(String endTime) {
            this.endTime = this.getTime(endTime);
            return this;
        }

        public Builder attenders(List<Person> attenders) {
            this.attenders = attenders;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Event build() {
            uuid = uuid == null ? UUID.randomUUID().toString(): uuid;
            return new Event(this);
        }

        public Event build(Event event) {
            uuid = uuid == null ? UUID.randomUUID().toString(): uuid;
            name = event.getName();
            description = event.getDescription();
            attenders = event.getAttenders();
            startTime = event.getStartTime();
            endTime = event.getEndTime();

            return new Event(this);
        }

        private GregorianCalendar getTime(String time) {
            GregorianCalendar converted = null;
            try {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = format.parse(time);
                converted = new GregorianCalendar();
                converted.setTime(date);
            }
            catch(Exception e) {
                try {
                    Date date = new Date(Long.parseLong(time));
                    converted = new GregorianCalendar();
                    converted.setTime(date);
                }
                catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            return converted;
        }

    }
}
