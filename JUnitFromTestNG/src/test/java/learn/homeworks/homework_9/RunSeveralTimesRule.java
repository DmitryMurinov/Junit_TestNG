package learn.homeworks.homework_9;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunSeveralTimesRule implements TestRule {

    int counter = 10;

    public RunSeveralTimesRule(TestRule unstableRule) {
//        counter = unstableRule.
    }


    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public Statement apply(Statement base, Description desc) {
        return new RunSeveralTimesStatement(base, desc);
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
            for (int i = 1; i <= counter; i++) {
                Throwable throwable = null;
                try {
                    base.evaluate();
                } catch (Throwable t) {
//                    System.out.println("Failed on attempt: " + i + " description: " + desc);
                    throwable = t;
                } finally {
                    if(throwable == null){break;}
                }
            }
        }
    }

}