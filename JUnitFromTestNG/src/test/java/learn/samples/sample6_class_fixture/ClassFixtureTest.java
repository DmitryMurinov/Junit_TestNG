package learn.samples.sample6_class_fixture;

import org.junit.*;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dima on 03.05.2016.
 */

public class ClassFixtureTest {

    @ClassRule
    public ExternalResource classRule = new ExternalResource() {

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
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

}
