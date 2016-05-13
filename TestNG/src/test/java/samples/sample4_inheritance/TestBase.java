package samples.sample4_inheritance;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */

@Test
public class TestBase {

    @BeforeMethod
    public void baseSetup(){
        System.out.println("base setup");
    }

    @AfterMethod
    public void baseTeardown(){
        System.out.println("base teardown");
    }
}
