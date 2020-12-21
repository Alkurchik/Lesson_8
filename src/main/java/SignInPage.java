import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    // CREATE AN ACCOUNT
    private By emailInput = By.id("email_create");
    private By formIsOk = By.xpath("//div[contains(@class,'form-ok')]");
    private By formError = By.xpath("//div[@class=\"form-group form-error\"]");
    private By submitButton = By.id("SubmitCreate");

    // ALREADY REGISTERED?
    private By emailLoginInput = By.id("email");
    private By passwordLoginInput = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By loginFormIsOk = By.xpath("//form[@id=\"create-account_form\"]//div[contains(@class,'form-ok')]");
    private By faildMessage = By.xpath("//div[@class=\"alert alert-danger\"]/ol/li");

    private SignInPage typeEmail(String email){
        driver.findElement(emailLoginInput).sendKeys(email);
        return this;
    }

    private SignInPage typePassword(String password){
        driver.findElement(passwordLoginInput).sendKeys(password);
        return this;
    }

    public SignUpPage createAccount(String email) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(submitButton).click();
        return new SignUpPage(driver);
    }

    public SignInPage login(String email, String password){
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
