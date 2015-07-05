package com.diosoft.lecture4;

import com.diosoft.lecture3.*;
import org.junit.*;

import static org.junit.Assert.*;

public class ArrayHelperTest {
    private long startTime;

    @Test
    public void testLeftUnion() throws Exception {
        // initialize variable inputs
        int[] leftArray = {1,5,4,23,65,32,78};
        int[] rightArray = {3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = {1,5,4,23,65,32,78,5,4,1,32,5};

        // initialize class to test
        ArrayHelper testClass = new ArrayHelper();

        // invoke method on class to test
        int[] returnValue = testClass.leftUnion(leftArray, rightArray);

        // assert return value
        Assert.assertArrayEquals(expectedValue, returnValue);
    }

    @Test
    public void testLeftUnionWhenEmptyFirstArray() throws Exception {
        // initialize variable inputs
        int[] leftArray = new int[0];
        int[] rightArray = {3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = null;

        // initialize class to test
        ArrayHelper testClass = new ArrayHelper();

        // invoke method on class to test
        int[] returnValue = testClass.leftUnion(leftArray, rightArray);

        // assert return value
        Assert.assertArrayEquals(expectedValue, returnValue);
    }

    @Test
    public void testLeftUnionWhenEmptySecondArray() throws Exception {
        // initialize variable inputs
        int[] leftArray = {1,5,4,23,65,32,78};
        int[] rightArray = new int[0];
        int[] expectedValue = {1,5,4,23,65,32,78};

        // initialize class to test
        ArrayHelper testClass = new ArrayHelper();

        // invoke method on class to test
        int[] returnValue = testClass.leftUnion(leftArray, rightArray);

        // assert return value
        Assert.assertArrayEquals(expectedValue, returnValue);
    }

    @Test
    public void testLeftUnionWhenFirstArrayIsNullWithMessage() throws Exception {
        // initialize variable inputs
        int[] leftArray = null;
        int[] rightArray = {3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = null;
        String returnMessage = "test";

        // initialize class to test
        ArrayHelper testClass = new ArrayHelper();

        // invoke method on class to test
        try {
            testClass.leftUnion(leftArray, rightArray);
            fail("Exception should be thrown");
        }
        catch (MyException e) {
            Assert.assertEquals(returnMessage, e.getMessage());
        }
    }

    @Test
    public void testLeftUnionWhenSecodArrayIsNull() throws Exception {
        // initialize variable inputs
        int[] leftArray = {1,5,4,23,65,32,78};
        int[] rightArray = null;
        int[] expectedValue = {1,5,4,23,65,32,78};

        // initialize class to test
        ArrayHelper testClass = new ArrayHelper();

        // invoke method on class to test
        testClass.leftUnion(leftArray, rightArray);
    }

    @Test
    public void testLeftUnionWithDuplicates() throws Exception {
        // initialize variable inputs
        int[] leftArray = {1,5,4,23,65,32,78};
        int[] rightArray = {1,5,4,23,65,32,78};
        int[] expectedValue = {1,5,4,23,65,32,78};

        // initialize class to test
        ArrayHelper testClass = new ArrayHelper();

        // invoke method on class to test
        testClass.leftUnion(leftArray, rightArray);
    }

    @Before
    public void setStartTime(){
        startTime = System.nanoTime();
    }

    @After
    public void writeExecutionTime(){
        long endTime = System.nanoTime();
        System.out.println("Test execution time = " + (endTime - startTime) + " nanoseconds");
    }
}