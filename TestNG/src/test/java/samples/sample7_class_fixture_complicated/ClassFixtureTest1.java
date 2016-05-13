package samples.sample7_class_fixture_complicated;

import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */

@Test(enabled = false)
public class ClassFixtureTest1 extends ClassFixtureTestBase{


    public void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }
    
}
