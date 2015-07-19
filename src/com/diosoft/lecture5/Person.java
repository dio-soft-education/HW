package com.diosoft.lecture5;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    //local code review (vtegza): should be private @ 19.07.15
    public Person(Builder obj) {
        this.firstName = obj.firstName;
        this.lastName = obj.lastName;
        this.phone = obj.phone;
        this.email = obj.email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String phone;
        private String email;

        public Builder() {}

        public Builder(Person person) {
            this.firstName = person.getFirstName();
            this.lastName = person.getLastName();
            this.phone = person.getPhone();
            this.email = person.getEmail();
        }

        public Person build() {
            return new Person(this);
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
    }
}
