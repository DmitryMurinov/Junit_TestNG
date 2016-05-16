package learn.homeworks.homework_9;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.Iterator;

/**
 * Created by d.murinov on 16.05.2016.
 */
public class UnstableRule extends TestWatcher implements Integer {

    private Integer counter = 1;

    public UnstableRule(){

    }

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

    @Override
    public byte byteValue() {
        return counter.byteValue();
    }

    @Override
    public short shortValue() {
        return counter.shortValue();
    }

    @Override
    public int intValue() {
        return counter.intValue();
    }

    @Override
    public long longValue() {
        return counter.longValue();
    }

    @Override
    public float floatValue() {
        return counter.floatValue();
    }

    @Override
    public double doubleValue() {
        return counter.doubleValue();
    }

    @Override
    public String toString() {
        return counter.toString();
    }

    @Override
    public int hashCode() {
        return counter.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return counter.equals(obj);
    }

    @Override
    public int compareTo(Integer anotherInteger) {
        return counter.compareTo(anotherInteger);
    }
}
