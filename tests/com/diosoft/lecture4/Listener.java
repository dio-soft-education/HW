package com.diosoft.lecture4;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Listener extends RunListener {
    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Execution of test method " + description.getMethodName() + " has been started");
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Execution of test method " + description.getMethodName() + " has finished");
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        super.testFailure(failure);
        System.out.println("Test has failed: " + failure.getException());
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Execution time of test is " + (float)result.getRunTime()/1000 + " seconds");
    }
}
