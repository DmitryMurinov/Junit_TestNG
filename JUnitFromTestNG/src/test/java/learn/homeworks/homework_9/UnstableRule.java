package learn.homeworks.homework_9;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.Iterator;

/**
 * Created by d.murinov on 16.05.2016.
 */
public class UnstableRule extends TestWatcher {

    private int counter;

    @Override
    protected void starting(Description description) {
        if (description.getAnnotation(Unstable.class) != null) {
            counter = description.getAnnotation(Unstable.class).value();
            System.out.println("Counter: " + counter);
        }
    }

    public int getCounter() {
        return counter;
    }
}
