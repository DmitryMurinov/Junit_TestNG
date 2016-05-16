package learn.homeworks.homework_9;

import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by d.murinov on 16.05.2016.
 */

public class UnstableRule extends TestWatcher implements TestRule {

    private int counter = 1;

    @Override
    public Statement apply(Statement base, Description desc) {
        return new UnstableRule.RunSeveralTimesStatement(base, desc);
    }

    public class RunSeveralTimesStatement extends Statement {

        private final Statement base;
        private Description desc;

        public RunSeveralTimesStatement(Statement base, Description desc) {
            this.base = base;
            this.desc = desc;
        }

        @Override
        public void evaluate() throws Throwable {

            counter = desc.getAnnotation(Unstable.class).value();

            for (int i = 1; i <= counter; i++) {
                Throwable throwable = null;
                try {
                    base.evaluate();
                } catch (Throwable t) {
                    throwable = t;
                } finally {
                    if(throwable == null){break;}
                }
            }
        }


    }


}
