package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends BaseTest {
    private static final String LOGIN_URL = URL + "login";
    private static final By USERNAME_INPUT = By.id("username");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    private static final By ERROR_MESSAGE = By.id("flash");

    @Test
    public void unsuccessfulLoginTest() {
        driver.get(LOGIN_URL);
        driver.findElement(USERNAME_INPUT).sendKeys("invalidUser");
        driver.findElement(PASSWORD_INPUT).sendKeys("invalidPassword");
        driver.findElement(LOGIN_BUTTON).click();

        String flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE)).getText();
        Assert.assertTrue(flashMessage.contains("Your username is invalid!"),
                "Expected invalid username error message, but got: " + flashMessage);
    }
}
