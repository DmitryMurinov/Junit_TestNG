package learn.samples.sample8_selenium_class_fixture;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dima on 03.05.2016.
 */

public class SeleniumClassFixture {

    protected WebDriver wd;

    @ClassRule
    public ExternalResource classSelenuimBaseRule = new ExternalResource() {

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
