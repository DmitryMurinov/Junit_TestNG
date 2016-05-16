package learn.homeworks.homework_9;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class UnstableTest extends UnstableFixture {

    private static int attempt = 1;

    @Test
    @Unstable(100)
    public void randomlyFailingTest() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String time = String.valueOf(System.currentTimeMillis());
        time = time.substring(time.length() - 1, time.length());

        if (time.equals("5")) {
            System.out.println("Test passed with time: " + time);
        } else {
            System.out.println("Failed on " + (attempt++) + " attempt with time end on: " + time);
            Assert.fail();
        }
    }
}