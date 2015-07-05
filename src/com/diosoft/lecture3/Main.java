package com.diosoft.lecture3;


import java.util.Arrays;

public class Main {

    public static void main (String[] args) {
        testLeftUnion();
        testLeftUnionWithNull();
        testLeftMerge();
        tesInnerArrays();
        tesOuterUnion();
    }

    private static void testLeftUnion() {
        int[] a = {1,5,4,23,65,32,78};
        int[] b = {3,5,24,4,1,2,34,45,32,5};
        int[] test = {1,5,4,23,65,32,78,5,4,1,32,5};

        ArrayHelper helper = new ArrayHelper();

        int[] result1 = helper.leftUnion(a, b);
        System.out.println("testLeftUnion -> helper.leftUnion(a, b) -> helper.intArrayEquals(test, result1) = " + helper.intArrayEquals(test, result1));

        int[] result2 = helper.leftUnionBinary(a, b);
        System.out.println("testLeftUnion -> helper.leftUnionBinary(a, b) ->helper.intArrayEquals(test, result2) = " + helper.intArrayEquals(test, result2));
    }

    private static void testLeftMerge() {
        int[] a = {1,5,4,23,65,32,78};
        int[] b = {3,5,24,54,1,2,34,45,32};
        int[] test = {1,5,4,23,65,32,78,3,24,54,2,34,45};

        ArrayHelper helper = new ArrayHelper();

        int[] result = helper.leftMerge(a, b);
        System.out.println("testLeftMerge -> helper.intArrayEquals(test, result) = " + helper.intArrayEquals(test, result));
    }

    private static void tesInnerArrays() {
        int[] a = {1,5,4,23,65,32,78};
        int[] b = {3,5,24,4,1,2,34,45,32,5};
        int[] test = {5,4,1,32};

        ArrayHelper helper = new ArrayHelper();

        int[] result = helper.innerArrays(a, b);
        System.out.println("tesInnerArrays -> helper.intArrayEquals(test, result) = " + helper.intArrayEquals(test, result));
    }

    private static void tesOuterUnion() {
        int[] a = {1,5,4,23,65,32,78};
        int[] b = {3,5,24,4,1,2,34,45,32,5};
        int[] test = {23,65,78,3,24,2,34,45};

        ArrayHelper helper = new ArrayHelper();

        int[] result = helper.outerUnion(a, b);
        System.out.println("tesOuterUnion -> helper.intArrayEquals(test, result) = " + helper.intArrayEquals(test, result));
    }

    private static void testLeftUnionWithNull() {
        int[] a = {1,5,4,23,65,32,78};
        int[] b = null;
        int[] test = {1,5,4,23,65,32,78};

        ArrayHelper helper = new ArrayHelper();

        int[] result1 = helper.leftUnion(a, b);
        System.out.println("testLeftUnionWithNull -> helper.leftUnion(a, b) -> helper.intArrayEquals(test, result1) = " + helper.intArrayEquals(test, result1));

        int[] result2 = helper.leftUnionBinary(a, b);
        System.out.println("testLeftUnionWithNull -> helper.leftUnion(a, b) -> helper.leftUnionBinary(test, result2) = " + helper.intArrayEquals(test, result2));
    }
}
