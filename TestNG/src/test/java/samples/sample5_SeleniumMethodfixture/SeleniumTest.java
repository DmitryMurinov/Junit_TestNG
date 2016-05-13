package samples.sample5_SeleniumMethodfixture;

/**
 * Created by Dima on 03.05.2016.
 */
public class SeleniumTest extends SeleniumMethodFixture{

    public void test1(){
        wd.get("http://seleniumhq.org");
    }

    public void test2(){
        wd.get("http://selenium2.ru");
    }
}
