package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest extends BaseTest {
    private final By MULTIPLE_WINDOWS_LINK_LOC = By.linkText("Multiple Windows");
    private final By CLICK_HERE_LINK_LOC = By.linkText("Click Here");
    private final By NEW_WINDOW_HEADING = By.tagName("h3");

    @Test
    public void multipleWindowsTest() {
        driver.findElement(MULTIPLE_WINDOWS_LINK_LOC).click();
        String originalWindow = driver.getWindowHandle();

        driver.findElement(CLICK_HERE_LINK_LOC).click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String headingText = wait.until(d -> d.findElement(NEW_WINDOW_HEADING).getText()).trim();
        Assert.assertEquals(headingText, "New Window", "Expected New Window heading");
    }
}
