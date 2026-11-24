package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    private final By JS_ALERT = By.linkText("JavaScript Alerts");
    private final By CLICK_FOR_JS_ALERT_BUTTON = By.xpath("//button[@onclick='jsAlert()']");
    private final By RESULT_TEXT = By.id("result");

    @Test
    public void alertTest() {
        driver.findElement(JS_ALERT).click();
        driver.findElement(CLICK_FOR_JS_ALERT_BUTTON).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(RESULT_TEXT)).getText();
        Assert.assertEquals(result, "You successfully clicked an alert", "Unexpected alert result message");
    }
}
