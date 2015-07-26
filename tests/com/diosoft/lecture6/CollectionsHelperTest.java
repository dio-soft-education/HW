package com.diosoft.lecture6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@RunWith(Parameterized.class)
public class CollectionsHelperTest {

    private Collection<Integer> collection1;
    private Collection<Integer> collection2;

    public CollectionsHelperTest(Collection<Integer> collection1, Collection<Integer> collection2) {
        this.collection1 = collection1 == null ? null : Collections.unmodifiableList(new ArrayList<Integer>(collection1));
        this.collection2 = collection2 == null ? null : Collections.unmodifiableList(new ArrayList<Integer>(collection2));
    }

    @Parameterized.Parameters
    public static Collection<Collection<Integer>[]> setArraysValues() {
        final Collection<Integer> collection1 = new ArrayList<Integer>(){{
            this.add(1); this.add(5); this.add(4); this.add(23); this.add(65); this.add(32); this.add(78);
        }};
        final Collection<Integer> collection2 = new ArrayList<Integer>(){{
            this.add(3); this.add(5); this.add(24); this.add(4); this.add(1); this.add(2); this.add(34); this.add(45);
            this.add(32); this.add(5);
        }};

        return new ArrayList<Collection<Integer>[]>(){
            {
                this.add(
                        new Collection[]{
                                collection1,
                                collection2
                        }
                );
                this.add(
                        new Collection[]{
                                null,
                                collection2
                        }
                );
                this.add(
                        new Collection[]{
                                collection1,
                                null
                        }
                );
                this.add(
                        new Collection[]{
                                null,
                                null
                        }
                );
            }
        };
    }

    @Test
    public void testMergeCollections() throws Exception {

        class Expected {
            Collection<Integer> generate(Collection<Integer> collection1, Collection<Integer> collection2) {
                return (
                        collection1 == null
                            ? collection2
                            : (collection2 == null
                                ? collection1 :
                                new ArrayList<Integer>(){{
                                        this.add(1); this.add(5); this.add(4); this.add(23); this.add(65); this.add(32);
                                        this.add(78); this.add(3); this.add(5); this.add(24); this.add(4); this.add(1);
                                        this.add(2); this.add(34); this.add(45); this.add(32); this.add(5);
                                }}
                            )
                );
            }
        }

        Collection<Integer> expected = new Expected().generate(this.collection1, this.collection2);
        // initialize class to test
        CollectionsHelper helper = new CollectionsHelper();
        // invoke method on class to test
        Collection<Integer> actual = helper.mergeCollections(this.collection1, this.collection2);

        // assert return value
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testInnerUnion() throws Exception {
        class Expected {
            Collection<Integer> generate(Collection<Integer> collection1, Collection<Integer> collection2) {
                return (
                        collection1 == null
                                ? collection2
                                : (collection2 == null
                                ? collection1 :
                                new ArrayList<Integer>(){{
                                    this.add(1); this.add(5); this.add(4); this.add(32);
                                }}
                        )
                );
            }
        }

        Collection<Integer> expected = new Expected().generate(this.collection1, this.collection2);
        // initialize class to test
        CollectionsHelper helper = new CollectionsHelper();
        // invoke method on class to test
        Collection<Integer> actual = helper.innerUnion(this.collection1, this.collection2);

        // assert return value
        if(actual != null) {
            actual = new ArrayList<Integer>(actual);
            Collections.sort((List)actual);
        }
        if(expected != null) {
            expected = new ArrayList<Integer>(expected);
            Collections.sort((List)expected);
        }
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testOuterUnion() throws Exception {
        class Expected {
            Collection<Integer> generate(Collection<Integer> collection1, Collection<Integer> collection2) {
                return (
                        collection1 == null
                                ? collection2
                                : (collection2 == null
                                    ? collection1 :
                                    new ArrayList<Integer>(){{
                                        this.add(23); this.add(65); this.add(78); this.add(3); this.add(24); this.add(2);
                                        this.add(45); this.add(34);
                                    }}
                        )
                );
            }
        }

        Collection<Integer> expected = new Expected().generate(this.collection1, this.collection2);
        // initialize class to test
        CollectionsHelper helper = new CollectionsHelper();
        // invoke method on class to test
        Collection<Integer> actual = helper.outerUnion(this.collection1, this.collection2);

        // assert return value
        if(actual != null) {
            actual = new ArrayList<Integer>(actual);
            Collections.sort((List)actual);
        }
        if(expected != null) {
            expected = new ArrayList<Integer>(expected);
            Collections.sort((List)expected);
        }
        Assert.assertEquals(actual,expected);
    }
}