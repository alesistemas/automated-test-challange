package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginUser;

import static runner.RunnerTest.driver;
import static runner.RunnerTest.wait;

public class UserLoginSteps {

    @When("the user click on the enter or register link")
    public void theUserClickOnTheEnterOrRegisterLink() {
        wait.until(ExpectedConditions.visibilityOf(LoginUser.enterOrRegisterLink(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.enterOrRegisterLink(driver)));
        LoginUser.enterOrRegisterLink(driver).click();
    }

    @And("^the user fill the email field$")
    public void theUserFillTheEmailField() {
        wait.until(ExpectedConditions.visibilityOf(LoginUser.inputEmailField(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.inputEmailField(driver)));
        LoginUser.inputEmailField(driver).click();
        LoginUser.inputEmailField(driver).sendKeys("test@gmail.com");
    }

    @And("the user fill the password field")
    public void theUserFillThePasswordField() {
        wait.until(ExpectedConditions.visibilityOf(LoginUser.inputPasswordField(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.inputPasswordField(driver)));
        LoginUser.inputPasswordField(driver).click();
        LoginUser.inputPasswordField(driver).sendKeys("password");
    }

    @And("the user click on the continue button")
    public void theUserClickOnTheContinueButton() {
        wait.until(ExpectedConditions.visibilityOf(LoginUser.continueButton(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.continueButton(driver)));
        LoginUser.continueButton(driver).click();
    }

    @Then("the user is logged in")
    public void theUserIsLoggedIn() {
        wait.until(ExpectedConditions.stalenessOf(LoginUser.loadingElement(driver)));
        String text;
        text = driver.findElement(By.cssSelector("button span b")).getText();
        Assert.assertEquals("Alessandra", text);
    }

    @Then("a warning message saying that the email and or password are required is presented to the user")
    public void aWarningMessageSayingThatTheEmailAndOrPasswordAreRequiredIsPresentedToTheUser() {
        wait.until(ExpectedConditions.stalenessOf(LoginUser.loadingElement(driver)));
        String text;
        text = driver.findElement(By.id("LoginBox-form")).getText();
        Assert.assertTrue(text.contains("Insira um CPF, CNPJ ou E-mail válido") ||
                                   text.contains("Insira a senha.") ||
                (text.contains("Insira um CPF, CNPJ ou E-mail válido") && text.contains("Insira a senha.")));
    }

    @And("the user enters with your email and or password with invalid values")
    public void theUserEntersWithYourEmailAndOrPasswordWithInvalidValues() {
        wait.until(ExpectedConditions.visibilityOf(LoginUser.inputEmailField(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.inputEmailField(driver)));
        LoginUser.inputEmailField(driver).click();
        LoginUser.inputEmailField(driver).sendKeys("testt@gmail.com");

        wait.until(ExpectedConditions.visibilityOf(LoginUser.inputPasswordField(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.inputPasswordField(driver)));
        LoginUser.inputPasswordField(driver).click();
        LoginUser.inputPasswordField(driver).sendKeys("wrongpassword");
    }

    @Then("the user will not be successfully logged in")
    public void theUserWillNotBeSuccessfullyLoggedIn() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.startsWith("https://sacola.magazineluiza.com.br/#/cliente/login/"));
    }
    @Then("the user is logged out and cannot see your account details")
    public void theUserIsLoggedOutAndCannotSeeYourAccountDetails(){
        wait.until(ExpectedConditions.visibilityOf(LoginUser.enterOrRegisterLink(driver)));
        LoginUser.enterOrRegisterLink(driver).isDisplayed();
    }
    @And("a warning message saying that incorrect username or password is presented to the user")
    public void aWarningMessageSayingThatIncorrectUsernameOrPasswordIsPresentedToTheUser() {
        wait.until(ExpectedConditions.stalenessOf(LoginUser.loadingElement(driver)));
        String text;
        text = driver.findElement(By.className("LoginBox-form-error--unique")).getText();
        Assert.assertEquals("Verifique o login e a senha para continuar.", text);
    }
    @When("the user click on your menu and then click on the logout link")
    public void theUserClickOnYourMenuAndThenClickOnTheLogoutLink() {
        wait.until(ExpectedConditions.visibilityOf(LoginUser.myMenu(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.myMenu(driver)));
        LoginUser.myMenu(driver).click();
        wait.until(ExpectedConditions.visibilityOf(LoginUser.logoutLink(driver)));
        wait.until(ExpectedConditions.elementToBeClickable(LoginUser.logoutLink(driver)));
        LoginUser.logoutLink(driver).click();
    }
}
