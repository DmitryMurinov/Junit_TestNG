package learn.samples.sample9_class_fixture_inheritance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dima on 03.05.2016.
 */

public class BrowserAndLoginFixture {



    protected static WebDriver wd;

    @ClassRule
    public static ExternalResource classSelenuimWDRule = new ExternalResource() {

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

    @ClassRule
    public static ExternalResource classSelenuimLoginRule = new ExternalResource() {

        @Override
        protected void before(){
            System.out.println("login");
            wd.get("http://localhost/php4dvd");
            wd.findElement(By.name("username")).sendKeys("admin");
        }

        @Override
        protected void after(){
            System.out.println("logout");
            wd.findElement(By.xpath("//nav/ul/li[4]/a")).click();
        }
    };

    @ClassRule
    public static RuleChain rules = RuleChain
            .outerRule(classSelenuimWDRule)
            .around(classSelenuimLoginRule);
}
