package Pages;

import org.openqa.selenium.WebDriver;

public class NewAccountListPage extends BasePage{


    public NewAccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
