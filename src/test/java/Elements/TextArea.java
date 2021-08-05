package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TextArea {
    WebDriver driver;
    String label;
    String textareaLocator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::*[contains(@class,'slds-form-element')]//textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info(String.format("Writing text '%s' into textarea with label %n", text, label));
        driver.findElement(By.xpath(String.format(textareaLocator, label))).sendKeys(text);
    }
}
