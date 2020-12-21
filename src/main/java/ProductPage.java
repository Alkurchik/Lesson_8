import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    JSONArray employeeList = new JSONArray();
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    private By productTitle = By.xpath("//div[@class=\"primary_block row\"]/div/h1[@itemprop=\"name\"]");
    private By productCategories = By.xpath("//a[@title=\"Women\"]");
    private By addToWishListButton = By.xpath("//*[@id=\"wishlist_button\"]");
    private By addToCart = By.xpath("//*[@id=\"add_to_cart\"]/button");


    public String getTitleText(){
        return driver.findElement(productTitle).getText();
    }

    public WishListPage goToWishList(){
        driver.get("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        return new WishListPage(driver);
    }

    @SuppressWarnings("unchecked")
    public void addToJson(String object, String item)
    {
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("name", item);

        JSONObject employeeObject = new JSONObject();
        employeeObject.put(object, employeeDetails);

        employeeList.add(employeeObject);

        try (FileWriter file = new FileWriter("WishList.json")) {
            file.write(employeeList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openProductPage(By action){
        driver.findElement(productCategories).click();
        List<WebElement> row =  driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
        for (int i=1; i<row.size(); i++){
            driver.findElement(By.xpath(String.format(
                    "//*[@id=\"center_column\"]/ul/li[%s]//h5[@itemprop=\"name\"]/a[@class=\"product-name\"]", i))).click();

            driver.findElement(action).click();

            this.addToJson(Integer.toString(i), this.getTitleText());
            driver.navigate().back();
        }
        this.goToWishList();
    }

    public void addToCart(){
        this.openProductPage(addToCart);
    }

    public void addToWishList(){
        this.openProductPage(addToWishListButton);
    }


}
