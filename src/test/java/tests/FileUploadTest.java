package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadTest extends BaseTest {
    private final By FILE_UPLOAD = By.linkText("File Upload");
    private final String FILE_NAME = "file.json";
    private final Path fileToUpload = Paths.get(ABSOLUTE_RESOURCE_PATH, FILE_NAME);
    private final By FILE_INPUT = By.id("file-upload");
    private final By UPLOAD_BUTTON = By.id("file-submit");
    private final By UPLOADED_FILES = By.id("uploaded-files");

    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_UPLOAD).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(FILE_INPUT))
                .sendKeys(fileToUpload.toString());
        driver.findElement(UPLOAD_BUTTON).click();

        String uploadedName = wait.until(ExpectedConditions.visibilityOfElementLocated(UPLOADED_FILES)).getText().trim();
        Assert.assertEquals(uploadedName, FILE_NAME, "Uploaded file name did not match");
    }
}
