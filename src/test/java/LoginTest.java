import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    SignInPage signInPage;
    ProfilePage profilePage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signInPage = new SignInPage(driver);
        profilePage = new ProfilePage(driver);

    }

    @Test
    public void loginAccount(){
        signInPage.login("gooduser@alex.com", "emerep01");
        Assert.assertEquals("alex gooduser", profilePage.verifyProfile());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
