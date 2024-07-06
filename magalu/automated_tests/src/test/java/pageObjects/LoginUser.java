package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUser {
    private static WebElement element = null;

    public static WebElement enterOrRegisterLink(WebDriver driver){
        element = driver.findElement(By.cssSelector("a[href=\"https://www.magazineluiza.com.br/cliente/login/\"]"));
        return element;
    }
    public static WebElement inputEmailField(WebDriver driver) {
        element = driver.findElement(By.cssSelector(".LoginBox .FormGroup-input"));
        return element;
    }
    public static WebElement inputPasswordField(WebDriver driver) {
        element = driver.findElement(By.name("password"));
        return element;
    }
    public static WebElement continueButton(WebDriver driver) {
        element = driver.findElement(By.cssSelector(".LoginBox #login-box-form-continue"));
        return element;
    }
    public static WebElement loadingElement(WebDriver driver) {
        element = driver.findElement(By.className("CenteredLoading"));
        return element;
    }
    public static WebElement myMenu(WebDriver driver) {
        element = driver.findElement(By.cssSelector("button[data-testid=\"dropdown-title\"]"));
        return element;
    }
    public static WebElement logoutLink(WebDriver driver) {
        element = driver.findElement(By.cssSelector("a[data-testid=\"link-logout\"]"));
        return element;
    }
}
