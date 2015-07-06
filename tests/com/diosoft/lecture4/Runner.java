package com.diosoft.lecture4;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class Runner extends BlockJUnit4ClassRunner {
    private Listener listener;

    public Runner(Class<?> klass) throws InitializationError {
        super(klass);
        listener = new Listener();
    }

    public void run(RunNotifier notifier) {
        notifier.addListener(listener);
        super.run(notifier);
    }
}
