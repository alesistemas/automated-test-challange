package runner;

import Util.GetLink;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
         features = {"src/test/resources/features/"},
         glue = {"step_definitions"},
         publish = true)

public class RunnerTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    private static GetLink getLink = new GetLink();

    @BeforeClass
    public static void instantiateDriverObject() throws Exception {
        System.setProperty("webdriver.chrome.driver", getLink.getChromeDriverPath());
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        co.addArguments("disable-translate", "allow-running-insecure-content", "ignore-certificate-errors");
        co.addArguments("dns-prefetch-disable", "disable-component-update");
        co.addArguments("disable-bookmark-reordering", "disable-boot-animation", "disable-dinosaur-easter-egg");
        co.addArguments("disable-low-res-tiling", "disableprompt--on-repost", "disable-sync", "disk-cache-size");
        co.addArguments("enable-aggressive-domstorage-flushing", "fast", "no-wifi");
        co.addArguments("timeout=20");
        co.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        co.addArguments("no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        co.addArguments("disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        co.addArguments("disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        co.addArguments("disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770

        return co;
    }

    @AfterClass
    public static void killDriver() {
        driver.close();
    }
}
