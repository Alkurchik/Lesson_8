import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private By wishListButton = By.xpath("//a[@title=\"My wishlists\"]");
    private By userName = By.xpath("//a[@class=\"account\"]/span");


    public WishListPage clickGoToWishList(){
        driver.findElement(wishListButton).click();
        return new WishListPage(driver);
    }

    public String verifyProfile(){
        String profileName = driver.findElement(userName).getText();
    return profileName;
    }
}
