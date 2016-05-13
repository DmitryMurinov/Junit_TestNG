package samples.sample9_class_fixture_inheritance;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Dima on 03.05.2016.
 */
public class LoginFixture extends BrowserFixture{

    @BeforeClass
    public void login(){
        System.out.println("login");
        wd.get("http://localhost/php4dvd");
        wd.findElement(By.name("username")).sendKeys("admin");
    }

    @AfterClass
    public void logout(){
        System.out.println("logout");
        wd.findElement(By.xpath("//nav/ul/li[4]/a")).click();
    }
}
