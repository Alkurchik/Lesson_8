import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private By wishListButton = By.xpath("//a[@title=\"My wishlists\"]");

    public WishListPage clickGoToWishList(){
        driver.findElement(wishListButton).click();
        return new WishListPage(driver);
    }
}
