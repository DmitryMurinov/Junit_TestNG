package learn.samples.sample10_suite_fixture;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Dima on 09.05.2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SeleniumTest1.class,
        SeleniumTest2.class
})

public class SuiteSelenium {

    public static void suiteSetup(){
        System.out.println("suite Setup");
    }

    public static void suiteTeardown(){
        System.out.println("suit teardown");
    }
}
