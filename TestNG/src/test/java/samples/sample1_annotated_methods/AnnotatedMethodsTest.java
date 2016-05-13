package samples.sample1_annotated_methods;

import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */

public class AnnotatedMethodsTest {

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test(enabled = false)
    public void notATest(){
        System.out.println("notATest");
    }

    @Test(enabled = false)
    private void privateTest(){
        System.out.println("private test");
    }

    @Test(enabled = false)
    public void disabledTest(){
        System.out.println("disabled test");
    }

}
