package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchAndBuyProduct {
    private static WebElement element = null;

    public static WebElement searchProduct(WebDriver driver) {
        element = driver.findElement(By.id("input-search"));
        return element;
    }
    public static WebElement resultProduct(WebDriver driver) {
        element = driver.findElement(By.cssSelector("a[href=\"/notebook-asus-vivobook-16-intel-core-i7-8gb-256gb-ssd-16-windows-11-x1605za-mb310w/p/237655800/in/nass/\"]"));
        return element;
    }
    public static WebElement buyButton(WebDriver driver) {
        element = driver.findElement(By.cssSelector("button[data-testid=\"buyButton\"]"));
        return element;
    }
    public static WebElement deliveryContinueButton(WebDriver driver) {
        element = driver.findElement(By.cssSelector("button.DeliveryPage-continue"));
        return element;
    }
}
