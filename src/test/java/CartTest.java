import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CartTest {
    private WebDriver driver;
    SignInPage signInPage;
    ProfilePage profilePage;
    WishListPage wishListPage;
    ProductPage productPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signInPage = new SignInPage(driver);
        profilePage = new ProfilePage(driver);
        wishListPage = new WishListPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void loginAccount(){
        signInPage.login("gooduser@alex.com", "emerep01");
        productPage.addToCart();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
