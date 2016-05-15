package learn.homeworks.homework_9.Barantsev;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class UnstableTest {

    @Rule
    public TestRule runTwiceRule = new RunTwiceRule();

    private static int attempt = 1;

    @Test
    public void randomlyFailingTest() {
        if (attempt == 2) {
            attempt = 10;

        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }
}