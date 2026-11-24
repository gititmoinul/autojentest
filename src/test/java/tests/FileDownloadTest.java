package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class FileDownloadTest extends BaseTest {
    private final String FILE_NAME = "some-file.txt";
    private final By FILE_DOWNLOAD = By.linkText("File Download");
    private final By FILE_NAME_LINK = By.linkText(FILE_NAME);

    @Test
    public void fileDownloadTest() throws IOException {
        Path downloadedFile = DOWNLOAD_DIR.resolve(FILE_NAME);
        Files.deleteIfExists(downloadedFile);

        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(FILE_NAME_LINK)).isDisplayed(),
                "File link is not displayed");
        driver.findElement(FILE_NAME_LINK).click();

        await().atMost(Duration.ofSeconds(MAX_WAIT))
                .pollInterval(Duration.ofMillis(250))
                .until(() -> Files.exists(downloadedFile) && Files.size(downloadedFile) > 0);

        Assert.assertTrue(Files.exists(downloadedFile), "Downloaded file does not exist");
        Files.deleteIfExists(downloadedFile);
    }
}
