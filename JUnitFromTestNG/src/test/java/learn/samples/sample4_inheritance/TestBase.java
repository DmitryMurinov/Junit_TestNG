package learn.samples.sample4_inheritance;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExternalResource;

/**
 * Created by Dima on 03.05.2016.
 */

public class TestBase {

    @Rule
    public ExternalResource methodFixtureBaseRule = new ExternalResource() {

        @Override
        protected void before(){
            System.out.println("base setup");
        }

        @Override
        protected void after(){
            System.out.println("base teardown");
        }
    };
}
