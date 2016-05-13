package learn.samples.sample3_method_fixtures_test;


import org.junit.*;
import org.junit.rules.ExternalResource;

/**
 * Created by Dima on 03.05.2016.
 */

public class TwoBeforeMethodAnnotations {

    @Rule
    public ExternalResource methodFixtureRule1 = new ExternalResource() {

        @Override
        protected void before(){
            System.out.println("setup1");
        }

        @Override
        protected void after(){
            System.out.println("teardown");
        }
    };

    @Rule
    public ExternalResource methodFixtureRule2 = new ExternalResource() {

        @Override
        protected void before(){
            System.out.println("setup2");
        }
    };

    @Test
    @Ignore
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

}
