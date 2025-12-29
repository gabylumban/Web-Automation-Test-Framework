package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By usernameInputText = By.id("user-name");
    By passwordInputText = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText))
                .sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void validateErrorAppear(String expectedMessage) {
        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );
        assertTrue(error.getText().contains(expectedMessage));
    }
}
