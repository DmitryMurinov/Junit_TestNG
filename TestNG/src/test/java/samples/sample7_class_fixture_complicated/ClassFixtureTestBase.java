package samples.sample7_class_fixture_complicated;

import org.testng.annotations.*;

/**
 * Created by Dima on 03.05.2016.
 */

public class ClassFixtureTestBase {

    @BeforeClass
    public void baseSetup(){
        System.out.println("base setup before class");
    }

    @AfterClass
    public void baseTeardown(){
        System.out.println("base teardown after class");
    }
}
