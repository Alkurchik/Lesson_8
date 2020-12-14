import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishListPage {
    WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By wishTable = By.id("block-history");
    private By MyWishlist = By.xpath("//*[@id=\"block-history\"]//tr/td/a[contains(text(),'My wishlist')]");
    private By firstProductInWishList = By.cssSelector("ul.wlp_bought_list");
    private By productsTitle = By.id("s_title");

    public WishListPage getTitle(){
        List<WebElement> rows = driver.findElements(productsTitle);
        System.out.println(rows.toString());
        return this;
    }

}
