package learn.homeworks.homework_9;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

/**
 * Created by d.murinov on 16.05.2016.
 */
public class UnstableFixture {

    private int counter = 1;

    @ClassRule
    public TestRule unstableRule = new UnstableRule();

    @Rule
    public TestRule runSeveralTimesRule = new RunSeveralTimesRule(unstableRule);

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
