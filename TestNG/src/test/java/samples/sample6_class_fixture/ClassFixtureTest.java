package samples.sample6_class_fixture;

import org.testng.annotations.*;

/**
 * Created by Dima on 03.05.2016.
 */

@Test(enabled = false)
public class ClassFixtureTest {

    @BeforeClass
    public void setup(){
        System.out.println("setup");
    }

    public void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }

    @AfterClass
    public void teardown(){
        System.out.println("teardown");
    }

}
