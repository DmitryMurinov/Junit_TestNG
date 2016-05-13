package samples.sample1_annotated_methods;

import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */
public class ChildOfAnnotatedMethods extends AnnotatedMethodsTest {

    @Test
    public void childTest(){
        System.out.println("child test");
    }
}
