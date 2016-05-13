package learn.samples.sample10_suite_fixture;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dima on 03.05.2016.
 */

public class SeleniumSuiteFixture {

    static protected WebDriver wd;

    @BeforeClass
    public static void setup(){
        System.out.println("Starting a browser");
        wd = new FirefoxDriver();
    }

    @AfterClass
    public static void teardown(){
        System.out.println("Stopping a browser");
        if(wd != null){
            wd.close();
            wd.quit();
        }
    }
}
