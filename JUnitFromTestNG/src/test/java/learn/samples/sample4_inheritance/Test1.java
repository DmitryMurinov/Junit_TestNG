package learn.samples.sample4_inheritance;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

/**
 * Created by Dima on 03.05.2016.
 */
public class Test1 extends TestBase{

    @Rule
    public ExternalResource methodFixtureInheritanceRule = new ExternalResource() {

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
