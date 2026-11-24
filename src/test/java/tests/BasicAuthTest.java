package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    private final By SUCCESS_AUTH = By.xpath("//p[contains(text(), 'Congratulations')]");

    @Test
    public void basicAuthTest() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_AUTH)).getText();
        Assert.assertTrue(text.contains("Congratulations! You must have the proper credentials."),
                "Congratulations message is not displayed");
    }
}
