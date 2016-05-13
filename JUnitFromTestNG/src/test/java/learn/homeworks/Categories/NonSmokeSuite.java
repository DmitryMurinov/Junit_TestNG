package learn.homeworks.Categories;

import learn.homeworks.homework_3.CreateFileTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Dima on 09.05.2016.
 */

@Suite.SuiteClasses({
        CreateFileTest.class
})
@RunWith(Categories.class)
@Categories.ExcludeCategory(HomeWorkCategories.SmokeTests.class)
public class NonSmokeSuite {
}