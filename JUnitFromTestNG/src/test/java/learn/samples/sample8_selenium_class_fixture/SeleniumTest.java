package learn.samples.sample8_selenium_class_fixture;

import org.junit.Test;

/**
 * Created by Dima on 03.05.2016.
 */

public class SeleniumTest extends SeleniumClassFixture{

    @Test
    public void test1(){
        wd.get("http://seleniumhq.org");
    }

    @Test
    public void test2(){
        wd.get("http://selenium2.ru");
    }
}
