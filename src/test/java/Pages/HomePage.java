package Pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage{

    public static final By TITLE = By.xpath("//*[@title='Sales']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking Home page is open")
    public boolean isPageOpened() {
        log.info("Checking that Home page is open");
        return isExist(TITLE);
    }
}
