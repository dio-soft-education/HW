package com.diosoft.lecture5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person.Builder()
                .email("test@test.ua")
                .phone("849384938903")
                .firstName("John")
                .lastName("Week")
                .build();

        Person person2 = new Person.Builder(person1)
                .phone("1213874837434")
                .build();

        Person person3 = new Person.Builder(person2)
                .email("test@dio-soft.ua")
                .build();

        ArrayHelper helper = new ArrayHelper();
        Person[] arr = helper.leftMerge(new Person[]{person1,person2}, new Person[]{person1,person3}, Person[].class);

        System.out.println(Arrays.toString(arr));
    }

}
