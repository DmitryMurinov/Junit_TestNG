package learn.samples.sample2_annotated_class;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Dima on 03.05.2016.
 */

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

    @Test
    @Ignore
    public void disabledTest(){
        System.out.println("disabled test");
    }
}
