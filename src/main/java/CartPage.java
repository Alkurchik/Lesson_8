import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productName = By.cssSelector("tr.cart_item > td > p.product-name > a");


    public void readCart() throws IOException, ParseException {//можно вынести функцию
        driver.get("http://automationpractice.com/index.php?controller=order");
        JSONParser parser = new JSONParser();
        Object myJson = parser.parse(new FileReader("/Users/alex/IdeaProjects/Lesson_8/WishList.json"));
        JSONArray myData = new JSONArray(myJson.toString());
        List<WebElement> rows = driver.findElements(productName);
        for (int i = 0; i < rows.size(); i++) {
            String title = rows.get(i).getText();
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
