package learn.samples.sample1_annotated_methods;

import org.junit.Ignore;
import org.junit.Test;

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

    @Test
    @Ignore
    public void notATest(){
        System.out.println("notATest");
    }

    @Test
    @Ignore
    private void privateTest(){
        System.out.println("private test");
    }

    @Test
    @Ignore
    public void disabledTest(){
        System.out.println("disabled test");
    }

}
