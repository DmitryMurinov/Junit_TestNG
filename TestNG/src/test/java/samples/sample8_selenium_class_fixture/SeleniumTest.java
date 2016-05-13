package samples.sample8_selenium_class_fixture;

/**
 * Created by Dima on 03.05.2016.
 */

public class SeleniumTest extends SeleniumClassFixture{

    public void test1(){
        wd.get("http://seleniumhq.org");
    }

    public void test2(){
        wd.get("http://selenium2.ru");
    }
}
