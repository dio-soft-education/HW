package com.diosoft.lecture6;

import java.util.*;

public class CollectionsHelper {

    public <T> Collection<T> mergeCollections(Collection<T> firstCollection, Collection<T> secondCollection) {

        if(firstCollection == null)
            return secondCollection;
        if(secondCollection == null)
            return firstCollection;

        List<T> container = new ArrayList<T>(firstCollection);
        container.addAll(secondCollection);

        return container;
    }

    public <T> Collection<T> innerUnion(Collection<T> firstCollection, Collection<T> secondCollection) {

        if(firstCollection == null)
            return secondCollection;
        if(secondCollection == null)
            return firstCollection;

        Set<T> container = new HashSet<T>(firstCollection);
        container.retainAll(secondCollection);

        return container;
    }

    public <T> Collection<T> outerUnion(Collection<T> firstCollection, Collection<T> secondCollection) {

        if(firstCollection == null)
            return secondCollection;
        if(secondCollection == null)
            return firstCollection;

        Set<T> container = new HashSet<T>(firstCollection);
        container.addAll(secondCollection);
        container.removeAll(innerUnion(firstCollection, secondCollection));

        return container;
    }

}
