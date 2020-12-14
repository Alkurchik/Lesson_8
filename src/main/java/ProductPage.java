import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    private By productTitle = By.xpath("//div[@class=\"primary_block row\"]/div/h1[@itemprop=\"name\"]");
    private By addToWishList = By.id("wishlist_button");


    public String getTitleText(){
        return driver.findElement(productTitle).getText();
    }

    private void clickWishListButton(){
        driver.findElement(addToWishList).click();
    }

    public WishListPage addToWishList(){
        clickWishListButton();
        driver.get("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        return new WishListPage(driver);
    }
}
