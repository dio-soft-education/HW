package com.diosoft.lecture5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayHelperTest {

    private Person[] array1;
    private Person[] array2;
    //local code review (vtegza): this array could be modified by another test @ 19.07.15
    private Person[] expected;

    public ArrayHelperTest(Person[] array1, Person[] array2, Person[] expected) {
        this.array1 = array1;
        this.array2 = array2;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Person[][]> setArraysValues() {
        Person person1 = new Person.Builder().email("test@test.ua").phone("849384938903").build();
        Person person2 = new Person.Builder().firstName("John").lastName("Week").build();
        Person noDataPerson = new Person.Builder().build();

        return Arrays.asList(
                new Person[][][]{
                        {
                                new Person[]{person1, person2},
                                new Person[]{person2, noDataPerson},
                                new Person[] {person1, person2, person2, noDataPerson}
                        },
                        {
                                new Person[]{noDataPerson, person2},
                                null,
                                null
                        },
                        {
                                null,
                                new Person[]{person2, noDataPerson},
                                null
                        },
                        {
                                null,
                                null,
                                null
                        },
                }
        );
    }

    @Test
    public void testLeftMerge() {
        Person[] expected = this.expected;
        // initialize class to test
        ArrayHelper helper = new ArrayHelper();
        // invoke method on class to test
        Person[] actual = helper.leftMerge(this.array1, this.array2, Person[].class);

        // assert return value
        Assert.assertArrayEquals(actual,expected);
    }
}