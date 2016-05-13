package samples.sample5_SeleniumMethodfixture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Dima on 03.05.2016.
 */

@Test(enabled = false)
public class SeleniumMethodFixture {

    protected WebDriver wd;

    @BeforeMethod
    public void setup(){
        System.out.println("Starting a browser");
        wd = new FirefoxDriver();
    }

    @AfterMethod
    public void teardown(){
        System.out.println("Stopping a browser");
        if(wd != null){
            wd.close();
            wd.quit();
        }
    }
}
