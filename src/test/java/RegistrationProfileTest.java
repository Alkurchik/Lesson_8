import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegistrationProfileTest {
    private WebDriver driver;
    SignInPage signInPage;
    SignUpPage signUpPage;
    ProfilePage profilePage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        profilePage = new ProfilePage(driver);

    }

    @Test
    public void createAccount(){
        Random random = new Random();
        int i = random.nextInt(9999);
        String email = "testemeil_"+ i + "@dmail.da";
        String name = "Alex";
        String lastname = "Kurt";

        signInPage.createAccount(email);
        signUpPage.fillingInTheFields(
                name,
                lastname,
                email,
                "emerep01",
                "1",
                "1",
                "1997",
                "elegia",
                "zhukovskogo",
                "Minsk",
                "1",
                "00000",
                "21",
                "Test",
                "+375291338075",
                "test@test.com");
        Assert.assertEquals(name + ' ' + lastname, profilePage.verifyProfile());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
