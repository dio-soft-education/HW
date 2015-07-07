package com.diosoft.lecture5;

import java.util.ArrayList;
import java.util.Arrays;

public class ServiceDelegate {
    private ServiceDelegate() {}

    public static ServiceDelegate getInstance() {
        return Internal.instance;
    }

    public <T> T[] leftMerge(T[] leftArray, T[] rightArray, Class<? extends T[]> clazz) {

        if(leftArray == null || rightArray == null)
            return null;

        ArrayList<T> list = new ArrayList<T>();

        Object[][] arrays = {leftArray, rightArray};
        for(Object[] arr: arrays) {
            for(Object el : arr)
                list.add((T)el);
        }

        Object[] objectList = list.toArray();
        T[] result = Arrays.copyOf(objectList, objectList.length, clazz);

        return result;
    }

    private static class Internal {
        private static final ServiceDelegate instance = new ServiceDelegate();
    }
}
