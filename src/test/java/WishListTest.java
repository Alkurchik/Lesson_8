import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WishListTest {
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
    public void loginAccount() throws IOException, ParseException {
        signInPage.login("gooduser@alex.com", "emerep01");
        profilePage.clickGoToWishList();
        wishListPage.verifyTable();
        productPage.addToWishList();
        wishListPage.readWishList();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
