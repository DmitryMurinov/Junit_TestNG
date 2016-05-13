package samples.sample9_class_fixture_inheritance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */

@Test(enabled = false)
public class BrowserFixture {

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
