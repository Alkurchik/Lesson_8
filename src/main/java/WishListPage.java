import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class WishListPage {
    WebDriver driver;
    ProfilePage profilePage;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By wishTable = By.id("block-history");
    private By MyWishlist = By.xpath("//*[@id=\"block-history\"]//tr/td/a[contains(text(),'My wishlist')]");
    private By productTitle = By.xpath("//div[@class=\"product_infos\"]/p[@id=\"s_title\"]");
    private By deleteWishListBtn = By.xpath("//i[@class=\"icon-remove\"]");
    private By qtyCount = By.xpath("//*[@id=\"wishlist_26910\"]/td[2]");


    public static String getTextNode(WebElement e) {
        String text = e.getText().trim();
        List<WebElement> children = e.findElements(By.xpath("./*"));

        for (WebElement child : children) {
            text = text.replaceFirst(child.getText(), "").trim();
        }

        return text;
    }

    public String checkQty() {
        return driver.findElement(qtyCount).getText();
    }

    public void verifyTable() {
        if (driver.findElement(wishTable).isDisplayed()) {
            driver.findElement(deleteWishListBtn).click();
            driver.switchTo().alert().accept();
        }
    }

    public void readWishList() throws IOException, ParseException {//можно вынести функцию
        driver.get("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        driver.findElement(MyWishlist).click();
        profilePage = new ProfilePage(driver);

        JSONParser parser = new JSONParser();
        Object myJson = parser.parse(new FileReader("/Users/alex/IdeaProjects/Lesson_8/WishList.json"));
        JSONArray myData = new JSONArray(myJson.toString());

        List<WebElement> rows = driver.findElements(productTitle);
        for (int i = 0; i < rows.size(); i++) {
            String title = this.getTextNode(rows.get(i));
            JSONObject row = myData.getJSONObject(i);
            Iterator<String> keys = row.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String name = row.getJSONObject(key).getString("name");
                Assert.assertEquals(title, name);
            }
        }
    }
}
