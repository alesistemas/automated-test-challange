package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginUser;
import pageObjects.SearchAndBuyProduct;

import static runner.RunnerTest.driver;
import static runner.RunnerTest.wait;

public class SearchAndBuyProductSteps {
    @And("the user fill the search field to search for a product")
    public void theUserFillTheSearchFieldToSearchForProduct() {
        wait.until(ExpectedConditions.visibilityOf(SearchAndBuyProduct.searchProduct(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(SearchAndBuyProduct.searchProduct(driver)));
        SearchAndBuyProduct.searchProduct(driver).click();
        SearchAndBuyProduct.searchProduct(driver).sendKeys("Notebook Asus");
        SearchAndBuyProduct.searchProduct(driver).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(SearchAndBuyProduct.resultProduct(driver)));
        SearchAndBuyProduct.resultProduct(driver).isDisplayed();
        SearchAndBuyProduct.resultProduct(driver).click();
    }

    @And("the user click on buy product")
    public void theUserClickOnBuyProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchAndBuyProduct.buyButton(driver)));
        SearchAndBuyProduct.buyButton(driver).click();
    }

    @Then("the user is directed to the delivery options page and the user click on the delivery continue button")
    public void theUserIsDirectedToTheDeliveryOptionsPageAndTheUserClickOnTheDeliveryContinueButton() {
        wait.until(ExpectedConditions.stalenessOf(LoginUser.loadingElement(driver)));
        wait.until(ExpectedConditions.visibilityOf(SearchAndBuyProduct.deliveryContinueButton(driver)));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://sacola.magazineluiza.com.br/n#/entrega", currentUrl);
        wait.until(ExpectedConditions.elementToBeClickable(SearchAndBuyProduct.deliveryContinueButton(driver)));
        SearchAndBuyProduct.deliveryContinueButton(driver).click();
    }

    @Then("the user is directed to the payment page")
    public void theUserIsDirectedToThePaymentPage() {
        wait.until(ExpectedConditions.stalenessOf(LoginUser.loadingElement(driver)));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://sacola.magazineluiza.com.br/#/pagamento", currentUrl);
    }
}