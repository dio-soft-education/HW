package com.diosoft.lecture3;

import java.util.Arrays;

public class ArrayHelper {

    public int[] leftUnion(int[] leftArray, int[] rightArray) {

        if(leftArray == null)
            return null;

        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray == null ? 0 : rightArray.length;
        int[] tmp = new int[leftArrayLength + rightArrayLength];
        int length = leftArrayLength;

        System.arraycopy(leftArray, 0, tmp, 0, leftArrayLength);

        if(leftArray.length > 0 && rightArray != null && rightArray.length > 0) {
            for (int element : rightArray) {
                boolean exists = false;
                for (int aLeftArray : leftArray) {
                    if (element == aLeftArray) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    length++;
                    tmp[length - 1] = element;
                }
            }
        }

        int[] result = Arrays.copyOf(tmp, length);

        return result;
    }

    public int[] leftUnionBinary(int[] leftArray, int[] rightArray) {

        if(leftArray == null)
            return null;

        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray == null ? 0 : rightArray.length;
        int[] tmp = new int[leftArrayLength + rightArrayLength];
        int length = leftArrayLength;

        System.arraycopy(leftArray, 0, tmp, 0, leftArrayLength);

        if(leftArray.length > 0 && rightArray != null && rightArray.length > 0) {
            Arrays.sort(leftArray);
            for (int element : rightArray) {
                if (Arrays.binarySearch(leftArray, element) >= 0) {
                    length++;
                    tmp[length - 1] = element;
                }
            }
        }

        int[] result = Arrays.copyOf(tmp, length);

        return result;
    }

    public int[] leftMerge(int[] leftArray, int[] rightArray) {

        if(leftArray == null)
            return null;

        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray == null ? 0 : rightArray.length;
        int[] tmp = new int[leftArrayLength + rightArrayLength];
        int length = leftArrayLength;

        System.arraycopy(leftArray, 0, tmp, 0, leftArrayLength);

        if(leftArray.length > 0 && rightArray != null && rightArray.length > 0) {
            for (int element : rightArray) {
                boolean valid = false;
                for (int aLeftArray : leftArray) {
                    if (element != aLeftArray) {
                        valid = true;
                        for(int el: tmp) {
                            if(el == element) {
                                valid = false;
                                break;
                            }
                        }
                    }
                }
                if (valid) {
                    length++;
                    tmp[length - 1] = element;
                }
            }
        }

        int[] result = Arrays.copyOf(tmp, length);

        return result;
    }

    public int[] innerArrays(int[] leftArray, int[] rightArray) {

        if(leftArray == null || rightArray == null)
            return null;

        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;
        int[] tmp = new int[leftArrayLength + rightArrayLength];
        int length = 0;

        if(leftArray.length > 0 && rightArray.length > 0) {
            for (int element : rightArray) {
                boolean valid = false;
                for (int aLeftArray : leftArray) {
                    if (element == aLeftArray) {
                        valid = true;
                        for(int el: tmp) {
                            if(el == element) {
                                valid = false;
                                break;
                            }
                        }
                    }
                }
                if (valid) {
                    length++;
                    tmp[length - 1] = element;
                }
            }
        }

        int[] result = Arrays.copyOf(tmp, length);

        return result;
    }

    public int[] outerUnion(int[] leftArray, int[] rightArray) {

        if(leftArray == null || rightArray == null)
            return null;

        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;
        int[] tmp = new int[leftArrayLength + rightArrayLength];
        int length = 0;

        if(leftArray.length > 0 && rightArray.length > 0) {
            int[][] arrays = {leftArray, rightArray};
            for (int i = 0; i < arrays.length; i++) {
                int[] arr1 = i > 0 ? arrays[1] : arrays[0];
                int[] arr2 = i > 0 ? arrays[0] : arrays[1];
                for (int element1 : arr1) {
                    //local code review (vtegza): extract methods to make code more readable @ 06.07.15
                    boolean valid = false;
                    for (int element2 : arr2) {
                        if (element1 != element2) {
                            valid = true;
                            for (int element0 : arr2) {
                                if (element0 == element1) {
                                    valid = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (valid) {
                        length++;
                        tmp[length - 1] = element1;
                    }
                }
            }
        }

        int[] result = Arrays.copyOf(tmp, length);

        return result;
    }

    public boolean intArrayEquals(int[] a, int[] b) {
        if (a == b)
            return true;

        if (a == null || b == null)
            return false;

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}