package learn.homeworks.Categories;

import learn.homeworks.homework_3.CreateFileTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import learn.homeworks.Categories.HomeWorkCategories.*;

/**
 * Created by Dima on 09.05.2016.
 */

//DOESN'T WORK PROPERLY. JUNIT PROBLEMS?

@RunWith(Categories.class)
@Categories.IncludeCategory({SmokeTests.class, PositiveTests.class, NegativeTest.class})
@Suite.SuiteClasses({
        CreateFileTest.class
})

public class AllSuite {
}