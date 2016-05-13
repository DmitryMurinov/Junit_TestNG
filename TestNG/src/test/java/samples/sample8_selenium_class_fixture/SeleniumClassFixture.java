package samples.sample8_selenium_class_fixture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by Dima on 03.05.2016.
 */

@Test(enabled = false)
public class SeleniumClassFixture {

    protected WebDriver wd;

    @BeforeClass
    public void setup(){
        System.out.println("Starting a browser");
        wd = new FirefoxDriver();
    }

    @AfterClass
    public void teardown(){
        System.out.println("Stopping a browser");
        if(wd != null){
            wd.close();
            wd.quit();
        }
    }

}
