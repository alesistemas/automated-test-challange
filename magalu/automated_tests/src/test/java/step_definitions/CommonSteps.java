package step_definitions;

import io.cucumber.java.en.Given;
import static runner.RunnerTest.driver;
import Util.GetLink;

public class CommonSteps {

    private GetLink getLink = new GetLink();
    public static String currentUrl = "";
    @Given("the user visit the homepage")
    public void theUserVisitTheHomepage() {
        driver.get(getLink.getBaseUrl());
        currentUrl = driver.getCurrentUrl();
    }
}