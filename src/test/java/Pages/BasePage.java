package Pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public abstract class BasePage {
    public static final String BASE_URL = "https://d5g0000096rcieau.my.salesforce.com";
    String areaLocator = "//div[contains(@class,'active')]//span[text()='%s']/ancestor::force-record-layout-item//*[@slot='outputField']";
    WebDriver driver;
    WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
    }

    public abstract boolean isPageOpened();

    public boolean isExist(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public void checkElement(String label, String expected) {
        assertEquals(driver.findElement(By.xpath(String.format(areaLocator, label))).getText(), expected,
                "Element" + label + "contains a different text");
    }

    public void checkElements(String label, String[] expected) {
        String elementValue = driver.findElement(By.xpath(String.format(areaLocator, label))).getText();
        for (String s : expected) {
            boolean isValueCorrect = elementValue.contains(s);
            assertTrue(isValueCorrect, "Element contains a different text");
        }
    }
}
