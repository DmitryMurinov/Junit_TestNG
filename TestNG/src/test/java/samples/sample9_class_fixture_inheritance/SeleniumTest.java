package samples.sample9_class_fixture_inheritance;

import org.openqa.selenium.By;

/**
 * Created by Dima on 03.05.2016.
 */
public class SeleniumTest extends LoginFixture{

    public void test1(){
        System.out.println(wd.findElements(By.cssSelector("div.movie_box")).size());
    }

}
