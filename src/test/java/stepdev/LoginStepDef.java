package stepdev;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginStepDef {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("user input username with {string}")
    public void userInputUsernameWith(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @Given("user input password with {string}")
    public void userInputPasswordWith(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String message) {
        String errorText =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertTrue(errorText.contains(message));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
