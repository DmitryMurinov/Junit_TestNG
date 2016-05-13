package samples.sample2_annotated_class;

import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */

@Test(enabled = false)
public class AnnotatedClassTest {

    public void test1(){
        System.out.println("test1");
    }

    public void test2(){
        System.out.println("test2");
    }

    private void privateTest(){
        System.out.println("private test");
    }

    @Test(enabled = false)
    public void disabledTest(){
        System.out.println("disabled test");
    }
}
