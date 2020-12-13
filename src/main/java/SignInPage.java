import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    // CREATE AN ACCOUNT
    private By emailInput = By.id("email_create");
    private By formIsOk = By.xpath("//div[@class=\"form-group form-ok\"]");
    private By formError = By.xpath("//div[@class=\"form-group form-error\"]");

    // ALREADY REGISTERED?
    private By emailLoginInput = By.id("email");
    private By passwordLoginInput = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By loginFormIsOk = By.xpath("//form[@id=\"login_form\"]//div[@class=\"form-group form-ok\"]");
    private By faildMessage = By.xpath("//div[@class=\"alert alert-danger\"]/ol/li");

    public SignInPage typeEmail(String email){
        driver.findElement(emailLoginInput).sendKeys(email);
        return this;
    }

    public SignInPage typePassword(String password){
        driver.findElement(passwordLoginInput).sendKeys(password);
        return this;
    }

    public SignInPage invalidCredentials(String email, String password){
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

    public ProfilePage clickSubmitButton(){
        driver.findElement(signInButton).click();
        return new ProfilePage(driver);
    }

    public String getErrorText(){
        return driver.findElement(faildMessage).getText();
    }


}
