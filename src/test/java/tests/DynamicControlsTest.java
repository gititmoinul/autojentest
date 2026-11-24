package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class DynamicControlsTest extends BaseTest {
    private final By DYNAMIC_CONTROL = By.linkText("Dynamic Controls");
    private final By ENABLE = By.xpath("//form[@id='input-example']/button");
    private final By INPUT_FIELD = By.xpath("//form[@id='input-example']/input");

    @Test
    public void dynamicControlsTest() {
        driver.findElement(DYNAMIC_CONTROL).click();
        driver.findElement(ENABLE).click();

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD));
        Assert.assertTrue(input.isEnabled(), "Input field should be enabled after clicking Enable");

        String randomText = "Test-" + UUID.randomUUID().toString().substring(0, 8);
        input.sendKeys(randomText);
        Assert.assertEquals(input.getAttribute("value"), randomText, "Input value did not match typed text");
    }
}
