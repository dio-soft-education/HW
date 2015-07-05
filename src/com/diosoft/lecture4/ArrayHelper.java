package com.diosoft.lecture4;

import java.util.Arrays;

public class ArrayHelper {

    public int[] leftUnion(int[] leftArray, int[] rightArray) throws MyException{

        if(leftArray == null)
            throw new MyException("test");

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
}
