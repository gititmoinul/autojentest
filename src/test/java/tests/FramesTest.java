package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    private final By FRAMES_LINK_LOC = By.linkText("Frames");
    private final By NESTED_FRAMES_LINK_LOC = By.linkText("Nested Frames");
    private final By BODY_LOC = By.tagName("body");

    @Test
    public void nestedFramesTest() {
        driver.findElement(FRAMES_LINK_LOC).click();
        driver.findElement(NESTED_FRAMES_LINK_LOC).click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String leftText = driver.findElement(BODY_LOC).getText().trim();
        Assert.assertEquals(leftText, "LEFT", "Expected LEFT frame text");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        String rightText = driver.findElement(BODY_LOC).getText().trim();
        Assert.assertEquals(rightText, "RIGHT", "Expected RIGHT frame text");

        driver.switchTo().defaultContent();
    }
}
