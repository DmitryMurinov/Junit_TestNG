package learn.samples.sample3_method_fixtures_test;

import org.junit.*;
import org.junit.rules.ExternalResource;

/**
 * Created by Dima on 03.05.2016.
 */

public class MethodFixturesTest {

    @Rule
    public ExternalResource methodFixtureRule = new ExternalResource() {

        @Override
        protected void before(){
            System.out.println("setup");
        }

        @Override
        protected void after(){
            System.out.println("teardown");
        }

    };

    @Test
    @Ignore
    public void test1(){
        System.out.println("test1");
    }

    @Test
    @Ignore
    public void test2(){
        System.out.println("test2");
    }

}
