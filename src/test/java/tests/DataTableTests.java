package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataTableTests extends BaseTest {
    private final By SORTABLE_DATA_TABLES = By.linkText("Sortable Data Tables");
    private final By TABLE1_DUES = By.xpath("//table[@id='table1']/tbody/tr/td[4]");

    @Test
    public void dataTableTest() {
        driver.findElement(SORTABLE_DATA_TABLES).click();
        List<WebElement> dueCells = driver.findElements(TABLE1_DUES);

        double actualSum = 0.0;
        for (WebElement cell : dueCells) {
            String amountText = cell.getText().replace("$", "").trim();
            actualSum += Double.parseDouble(amountText);
        }

        Assert.assertEquals(actualSum, 251.0, 0.01, "Expected total due sum for table1 is $251.00");
    }
}
