package samples.sample4_inheritance;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Dima on 03.05.2016.
 */
public class Test1 extends TestBase{

    @BeforeMethod
    public void setup(){
        System.out.println("setup");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("teardown");
    }

    public void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }


}
