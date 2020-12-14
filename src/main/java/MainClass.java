import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignIn();


        SignInPage signInPage = new SignInPage(driver);
        signInPage.login("gooduser@alex.com", "emerep01");

        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.getTitle();

//        SignUpPage signUpPage = new SignUpPage(driver);
//        signInPage.createAccount("test234emeil@dmail.da");
//        signUpPage.fillingInTheFields("Alex", "kurt", "alex@test.ru", "emerep01");


        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
