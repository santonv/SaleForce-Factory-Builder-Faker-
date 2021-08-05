package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public static final By LOGIN_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    public AccountsModal logIn(String logIn, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(logIn);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new AccountsModal(driver);
    }
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

}
