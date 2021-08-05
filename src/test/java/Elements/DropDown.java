package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
public class DropDown {

    WebDriver driver;
    String label;
    String dropDownLocator;
    String selectLocator;
    Select select;
    WebDriverWait wait;

    public DropDown(WebDriver driver, String label, String page){
        if(page.equals("Account")){
            dropDownLocator = "\"//*[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//a\"";
            selectLocator = "//*[contains(@class,'uiMenuList') and contains(@class,'visible')]//a[@title='%s']";
        } else {
            dropDownLocator = " //*[contains(@class,'modal-body')]//label[text()='%s']/ancestor::lightning-combobox" +
                    "[contains(@class,'slds-form-element')]//div[contains(@class,'slds-form-element__control')]";
            selectLocator = "//*[contains(@class,'modal-body')]//*[contains(@class,'slds-form-element')]//*[@title='%s']";
        }
        this.driver = driver;
        this.label = label;
    }

    public void select(String option){
        log.debug(String.format("Writing text '%s' into input with label %s", select, label));
        try {
            driver.findElement(By.xpath(String.format(dropDownLocator,label))).click();
            wait = new WebDriverWait(driver, 5);
            driver.findElement(By.xpath(String.format(selectLocator,option))).click();
        }
        catch (Exception e){
            e.getStackTrace();
        }
            }
}
