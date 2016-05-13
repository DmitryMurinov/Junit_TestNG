package learn.samples.sample7_class_fixture_complicated;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;

/**
 * Created by Dima on 03.05.2016.
 */

public class ClassFixtureTestBase {

    @ClassRule
    public ExternalResource classBaseRule = new ExternalResource() {

        @Override
        protected void before(){
            System.out.println("base setup before class");
        }

        @Override
        protected void after(){
            System.out.println("base teardown after class");
        }
    };

}
