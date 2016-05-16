package learn.homeworks.homework_9;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

/**
 * Created by d.murinov on 16.05.2016.
 */
public class UnstableFixture {

    @Rule
    public UnstableRule unstableRule = new UnstableRule();

    @Rule
    public TestRule runSeveralTimesRule = new RunSeveralTimesRule(unstableRule.getCounter());

}
