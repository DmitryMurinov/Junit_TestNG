package learn.samples.sample5_SeleniumMethodfixture;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dima on 03.05.2016.
 */

public class SeleniumMethodFixture {

    protected WebDriver wd;

    @Rule
    public ExternalResource methodFixtureSeleniumBaseRule = new ExternalResource() {

        @Override
        protected void before(){
            System.out.println("Starting a browser");
            wd = new FirefoxDriver();
        }

        @Override
        protected void after(){
            System.out.println("Stopping a browser");
            if(wd != null){
                wd.close();
                wd.quit();
            }
        }
    };
}
