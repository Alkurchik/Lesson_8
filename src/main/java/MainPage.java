import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By signIn = By.className("login");

    public SignInPage clickSignIn(){
        driver.findElement(signIn).click();
        return new SignInPage(driver);
    }


}
