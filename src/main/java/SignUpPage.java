import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    List<WebElement> options;
    Select sel;


    private void typeField(By elem, String text) {
        driver.findElement(elem).sendKeys(text);
    }

    private void selectOptions(By select, String option){
        WebElement selecBox = driver.findElement(select);
        sel = new Select(selecBox);
        sel.selectByValue(option);
    }

    public ProfilePage fillingInTheFields(
            String firstName,
            String lastName,
            String email,
            String password,
            String day,
            String month,
            String year,
            String company,
            String address,
            String city,
            String state,
            String zipCode,
            String country,
            String other,
            String phone,
            String emailAlias)
    {
            driver.findElement(titleForm).click();

            this.typeField(customerFirstname, firstName);
            this.typeField(customerLastname, lastName);
            this.typeField(customerEmail, email);
            this.typeField(customerPasswd, password);

            this.selectOptions(customerDaysSelector, day);
            this.selectOptions(customerMonthsSelector, month);
            this.selectOptions(customerYearsSelector, year);

            try{
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.typeField(AddrFirstname, firstName);
            this.typeField(AddrLastname, lastName);
            this.typeField(AddrCompany, company);
            this.typeField(AddrAddress1, address);
            this.typeField(AddrCity, city);

            this.selectOptions(AddrState, state);
            this.selectOptions(AddrCountry,country);

            this.typeField(AddrZipCode, zipCode);
            this.typeField(AddrOtherInformation, other);
            this.typeField(AddrPhone, phone);
            this.typeField(AddrPhoneMobile, phone);
            this.typeField(AddrAlias, emailAlias);

        return new ProfilePage(driver);
    }
}
