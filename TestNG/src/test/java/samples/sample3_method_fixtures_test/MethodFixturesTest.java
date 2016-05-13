package samples.sample3_method_fixtures_test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */

@Test(enabled = false)
public class MethodFixturesTest {

    @BeforeMethod
    public void setup(){
        System.out.println("setup");
    }

    public void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("teardown");
    }

}
