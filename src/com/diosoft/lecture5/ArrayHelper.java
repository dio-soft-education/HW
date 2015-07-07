package com.diosoft.lecture5;

public class ArrayHelper {
    private ServiceDelegate delegate;

    public ArrayHelper() {
        delegate = ServiceDelegate.getInstance();
    }

    public <T> T[] leftMerge(T[] leftArray, T[] rightArray, Class<? extends T[]> clazz) {
        return delegate.leftMerge(leftArray, rightArray, clazz);
    }
}
