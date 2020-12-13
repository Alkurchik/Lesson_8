import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    private By titleForm = By.id("id_gender2");
    private By customerFirstname = By.id("customer_firstname");
    private By customerLastname = By.id("customer_lastname");
    private By customerEmail = By.id("email");
    private By customerPasswd = By.id("passwd");
    private By customerDaysSelector = By.id("days");
    private By customerMonthsSelector = By.id("months");
    private By customerYearsSelector = By.id("years");

    private By AddrFirstname = By.id("firstname");
    private By AddrLastname = By.id("lastname");
    private By AddrCompany = By.id("company");
    private By AddrAddress1 = By.id("address1");
    private By AddrCity = By.id("city");
    private By AddrState = By.id("id_state");
    private By AddrZipCode = By.id("postcode");
    private By AddrCountry = By.id("id_country");
    private By AddrOtherInformation = By.id("other");
    private By AddrPhone = By.id("phone");
    private By AddrPhoneMobile = By.id("phone_mobile");
    private By AddrAlias = By.id("alias");

    public void typeField(By elem, String text) {
        driver.findElement(elem).sendKeys(text);
    }

    public ProfilePage fillingInTheFields(
            String firstName,
            String lastName,
            String email,
            String password)
    {
        this.typeField(customerFirstname, firstName);
        this.typeField(customerLastname, lastName);
        this.typeField(customerEmail, email);
        this.typeField(customerPasswd, password);

        return new ProfilePage(driver);
    }

}
